package com.alura.api.utils;

import java.util.Arrays;
import java.util.Optional;

public class EnumUtils {
    public static <T extends Enum<T>> T fromName(Class<T> enumClass, String name) {
        String lowerName = name.toLowerCase();
        Optional<T> matchingEnum = Arrays.stream(enumClass.getEnumConstants())
                .filter(enumValue -> enumValue.name().toLowerCase().equals(lowerName))
                .findFirst();

        return matchingEnum.orElseThrow(() -> new IllegalArgumentException("No se encontró un valor en el enum " + enumClass.getSimpleName() + " con el nombre: " + name));
    }
}
