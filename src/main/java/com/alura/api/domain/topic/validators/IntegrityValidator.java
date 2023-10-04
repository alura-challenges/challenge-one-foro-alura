package com.alura.api.domain.topic.validators;

public class IntegrityValidator extends RuntimeException {

    public IntegrityValidator(String s) {
        super(s);
    }
}
