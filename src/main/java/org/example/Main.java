package org.example;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Подключаемся к MongoDB
        var mongoClient = MongoClients.create();
        var db = mongoClient.getDatabase("mongo");
        var collection = db.getCollection("mycollection");

        // Подключаемся к PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "someuser";
        String password = "somepass";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Выполняем запросы к MongoDB
        var todoDocument = new Document(Map.of(
                "_id", new ObjectId(),
                "firstName", "Alex",
                "lastName", "Bogdanov",
                "email", "Bogdan@mail.ru",
                "phone", "8924526655",
                "hireDate", "1982-11-27",
                "jobId", "Ad_pres",
                "salary", 4000));

        collection.insertOne(todoDocument);

        // Выполняем запросы к PostgreSQL
        String sql = "INSERT INTO \"Contacts\" (customerId, firstName, lastName, email, phone, hireDate, jobId) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, 106);
            statement.setString(2, "Alex");
            statement.setString(3, "Bogdan");
            statement.setString(4, "bog@mail.ru");
            statement.setString(5, "89123665543");
            statement.setString(6, "1999-04-23");
            statement.setString(7, "Ress");
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Новый пользователь добавлен успешно!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Закрываем соединения
        mongoClient.close();
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

