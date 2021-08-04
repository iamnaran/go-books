package com.kec.gobooks.utils;

public class DefineClassType {

    // A generic class to cast a Type Of Object with a Give Class Type.

    public static <T> T typeCast(Object type, Class<T> classes) {
        try {
            return classes.cast(type);
        } catch (ClassCastException ex) {
            return null;
        }
    }
}
