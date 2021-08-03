package com.kec.gobooks.utils;

public class DefineClassType {

    public static <T> T typeCast(Object type, Class<T> classes) {
        try {
            return classes.cast(type);
        } catch (ClassCastException ex) {
            return null;
        }
    }
}
