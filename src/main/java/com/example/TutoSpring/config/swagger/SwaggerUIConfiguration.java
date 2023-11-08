package com.example.TutoSpring.config.swagger;

// import com.elyadata.sm.util.tools.Constants;
import com.example.TutoSpring.util.tools.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@OpenAPIDefinition(
        servers = {@Server(url = "/", description = "Default Server URL")},
        info = @Info(title = "${info.app.name}",
                version = "${info.app.version}",
                description = "${info.app.description}",
                contact = @Contact(name = "${info.app.contact.name}",
                        email = "${info.app.contact.email}")))
class SwaggerUIConfiguration {

    @Bean
    public OperationCustomizer customGlobalHeaders() {

        return (Operation operation, HandlerMethod handlerMethod) -> {

            List.of(new Parameter()
                            .in(ParameterIn.HEADER.toString())
                            .schema(new StringSchema())
                            .name(Constants.X_SESSION_ID)
                            .description("The session id associated to the user. X-Session-ID helps to make a logs search depending on the session id.")
                            .required(false),
                    new Parameter()
                            .in(ParameterIn.HEADER.toString())
                            .schema(new StringSchema())
                            .name(Constants.X_CORRELATION_ID)
                            .description("Correlation ID between each request from the same scenario.")
                            .required(false),
                    new Parameter()
                            .in(ParameterIn.HEADER.toString())
                            .schema(new StringSchema())
                            .name(Constants.X_FORWARDED_FOR)
                            .description("The ip address of the user. X-Forwarded-For helps to make a logs search depending on the user ip.")
                            .required(false)
            ).forEach(operation::addParametersItem);

            return operation;
        };
    }


    @Bean
    public GroupedOpenApi healthGroupOpenApi() {
        return GroupedOpenApi.builder()
                .group("Rest Api V1")
                .pathsToMatch("/skills/**")
                .addOperationCustomizer(customGlobalHeaders())
                .build();
    }



    @Bean
    public GroupedOpenApi userGroupOpenApi() {
        return GroupedOpenApi.builder()
                .group("Employee")
                .pathsToMatch("/skills/**")
                .addOperationCustomizer(customGlobalHeaders())
                .build();
    }
}
