package com.redbeemedia.enigma.core.testutil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public static Collection<Method> getPublicMethods(Class<?> owner, IPublicMethodFilter filter) {
        List<Method> methods = new ArrayList<>();
        for(Method method : owner.getMethods()) {
            method.setAccessible(true);
            if(filter.matches(Modifier.isStatic(method.getModifiers()), method.getReturnType(), method.getName(), method.getParameterTypes())) {
                methods.add(method);
            }
        }
        return methods;
    }

    public static Collection<Field> getFields(Class<?> owner, IFieldFilter filter) {
        List<Field> fields = new ArrayList<>();
        for(Field field : owner.getDeclaredFields()) {
            field.setAccessible(true);
            if(filter.matches(field.getModifiers(), field.getType(), field.getName(), owner)) {
                fields.add(field);
            }
        }
        Class<?> superclass = owner.getSuperclass();
        if(superclass != null) {
            fields.addAll(getFields(superclass, filter));
        }
        return fields;
    }


    public interface IPublicMethodFilter {
        boolean matches(boolean isStatic, Class<?> returnType, String name, Class<?>[] parametersTypes);
    }

    public interface IFieldFilter {
        boolean matches(int modifiers, Class<?> fieldType, String name, Class<?> declaringClass);
    }
}
