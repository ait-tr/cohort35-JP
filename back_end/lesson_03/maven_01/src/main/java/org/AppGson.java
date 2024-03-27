package org;

import com.google.gson.Gson;

public class AppGson {
    public static void main(String[] args) {
        // Создание объекта
        Person person = new Person("John", "Smith", 32);

        // Преобразовать объект в JSON
        Gson gson = new Gson();
        String json = gson.toJson(person);

        System.out.println("JSON: " + json);



    }
}
