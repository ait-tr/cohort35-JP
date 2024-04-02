package org.v2;

public class HelloWorld {

    public void init() throws Exception {
        System.out.println("Я инит-метод " + this.getClass().getSimpleName());
    }

    public void destroy() throws Exception{
        System.out.println("Я destroy-метод " + this.getClass().getSimpleName());
    }
}
