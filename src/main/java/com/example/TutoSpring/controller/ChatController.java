package com.example.TutoSpring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {



        @PostMapping("/chat")
        public String handleChatMessage(@RequestBody ChatMessage chatMessage) {
            String message = chatMessage.getMessage();
            String response = generateResponse(message);
            return response;
        }

        private String generateResponse(String message) {
            if (message.equalsIgnoreCase("bonjour")) {
                return "Bonjour !";
            } else if (message.equalsIgnoreCase("comment ça va")) {
                return "Je suis juste un programme informatique, mais merci de demander !";
            } else {
                return "Désolé, je ne comprends pas cela.";
            }
        }
    }
