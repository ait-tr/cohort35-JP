package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class H2MemoryDbDemo {
    /*
    1) загрузить драйвер
    2) подключится к базе данных - установить соединение
    3) создание нужной таблицы и / или вставка данных в таблицу
    4) извлечение данных
    5) закрытие ресурса

    DriverManager - позволяет подключится к базе данных по указанному URL
    также он загружает JDBC Driver'а

    URL (Uniform Resource Locator)

    Регистрация драйвера в системе:
    1) Driver driver = new com.mysql.jdbc.Driver();
    DriverManager.registerDriver(driver);

    2)
    Class.forName(" com.mysql.jdbc.Drive");

     */

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
        org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();

        System.out.println(connection.isClosed());

        Statement statement = connection.createStatement();;

        // создадим таблицу

        String sqlRequest = "CREATE TABLE employees (id INT PRIMARY KEY, name VARCHAR(255))";
        System.out.println("Create table was success: " + statement.execute(sqlRequest));

        // вставить данные в таблицу

        String sqlRequest1 = "INSERT INTO employees VALUES(1, 'John')";
        String sqlRequest2 = "INSERT INTO employees VALUES(2, 'Bill')";

        boolean result1 = statement.execute(sqlRequest1);
        System.out.println("Insert first data was success: " + result1);
        boolean result2 = statement.execute(sqlRequest2);
        System.out.println("Insert first data was success: " + result2);


        System.out.println();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        statement.close();
        connection.close();
    }
}
