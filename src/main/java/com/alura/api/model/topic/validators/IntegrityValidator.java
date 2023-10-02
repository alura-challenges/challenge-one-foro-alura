package com.alura.api.model.topic.validators;

public class IntegrityValidator extends RuntimeException {

    public IntegrityValidator(String s) {
        super(s);
    }
}
