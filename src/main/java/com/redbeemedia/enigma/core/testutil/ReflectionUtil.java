package com.redbeemedia.enigma.core.testutil;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static <T> T getDeclaredField(Object object, Class<T> fieldType, String fieldName) {
        Class<?> clazz = object.getClass();
        Container<T> resultContainer = new Container<>();
        for(Field field : clazz.getDeclaredFields()) {
            if(resultContainer.hasValueSet()) {
                break;
            }
            access(field, accessibleField -> {
                if(fieldName.equals(accessibleField.getName())) {
                    resultContainer.setValue((T) accessibleField.get(object));
                }
            });
        }
        if(resultContainer.hasValueSet()) {
            return resultContainer.getValue();
        } else {
            throw new RuntimeException("Could not find field "+fieldName);
        }
    }

    private static void access(Field field, IConsumer<Field> consumer) {
        boolean accessible = field.isAccessible();
        try {
            field.setAccessible(true);
            consumer.accept(field);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                field.setAccessible(accessible);
            } catch (Exception e) {
                //Ignore
            }
        }
    }

    private interface IConsumer<T> {
        void accept(T obj) throws IllegalAccessException;
    }

    private static class Container<T> {
        private boolean valueSet = false;
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.valueSet = true;
            this.value = value;
        }

        public boolean hasValueSet() {
            return valueSet;
        }
    }
}
