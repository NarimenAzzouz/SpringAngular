package com.example.TutoSpring.util.supplier;

import jakarta.persistence.EntityNotFoundException;

import java.util.function.Supplier;

import static com.example.TutoSpring.util.constant.MessageConstant.ENTITY_NOT_FOUND;
public class ExceptionSupplier {

    private ExceptionSupplier() {
    }

    public static Supplier<EntityNotFoundException> getNotFoundExceptionSupplier(String id, String entityName) {
        return () -> new EntityNotFoundException(ENTITY_NOT_FOUND.formatted(entityName, id));
    }
}
