package com.company.Annotations;

import java.lang.reflect.Field;

public class ObjectToSql {
    public String insert(Object object) throws IllegalAccessException {
        boolean isObject = false;
        String sql = String.format("INSERT INTO %s(%s) VALUES(%s)", object.getClass().getSimpleName(), "%s", "%s");
        if (object.getClass().isAnnotationPresent(MappedClass.class)) {
            return "";
        }
        //Insert INTO table_name(column1. column2, ...) VALUES (value1, value2, ...)
        StringBuilder values = new StringBuilder();
        StringBuilder columns = new StringBuilder();
        while (!isObject) {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Mapped.class)) {
                    field.setAccessible(true);
                    String tempVal = String.format("%s, ", field.get(object));
                    String tempCol = String.format("%s, ", field.getName());
                    values.append(tempVal);
                    columns.append(tempCol);
                }
            }
            object = object.getClass().getSuperclass();
            isObject = object.getClass().getSimpleName().equals("Class");
        }
        sql = String.format(sql, columns.toString(), values.toString());
        return sql;
    }
}
