package com.messages.app.crud.models.repository;

import com.messages.app.crud.dbConfig.DBConnection;
import com.messages.app.crud.models.entity.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageRepository {

    public static void list() {
        DBConnection dbConnection = new DBConnection();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        try(Connection connection = dbConnection.getConnection()) {
            String query = "SELECT * FROM messages";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_message"));
                System.out.println("TWEET: " + resultSet.getString("message_content"));
                System.out.println("AUTHOR: " + resultSet.getString("message_author"));
                System.out.println("DATE: " + resultSet.getString("message_date"));
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("Problemas Para Obtener Los Tweets.");
            System.out.println(e);
        }
    }

    public static void findById(int id) {
        boolean response = false;
        DBConnection dbConnection = new DBConnection();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        try(Connection connection = dbConnection.getConnection()) {
            String query = "SELECT * FROM messages WHERE id_message = '" + id + "'";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_message"));
                System.out.println("TWEET: " + resultSet.getString("message_content"));
                System.out.println("AUTHOR: " + resultSet.getString("message_author"));
                System.out.println("DATE: " + resultSet.getString("message_date"));
                response = true;
                System.out.println("");
            }

            if (!response) {
                System.out.println("El Código Del Tweet Ingresado, No Existe En El Sistema.");
            }

        } catch (SQLException e) {
            System.out.println("Problemas Para Obtener El Tweet.");
            System.out.println(e);
        }
    }

    public static void create(Message message) {
        DBConnection dbConnection = new DBConnection();

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement preparedStatement;

            try {
                String query = "INSERT INTO messages (message_content, message_author, message_date) VALUES (?,?,?)";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message.getMessageContent());
                preparedStatement.setString(2, message.getMessageAuthor());
                preparedStatement.setString(3, message.getMessageDate());
                preparedStatement.execute();
                System.out.println("Tweet Guardado Exitosamente.");

            } catch (SQLException e) {
                System.out.println("Problemas Para Guardar El Tweet.");
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println("Problemas De Conexión A La Base De Datos.");
            System.out.println(e);
        }
    }

    public static void update(Message message) {
        DBConnection dbConnection = new DBConnection();

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement preparedStatement;

            try {
                String query = "UPDATE messages SET message_content = ? WHERE id_message = ?";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message.getMessageContent());
                preparedStatement.setInt(2, message.getIdMessage());
                preparedStatement.executeUpdate();
                System.out.println("Tweet Actualizado Exitosamente.");

            } catch (SQLException e) {
                System.out.println("Problemas Para Actualizar El Tweet.");
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println("Problemas De Conexión A La Base De Datos.");
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        DBConnection dbConnection = new DBConnection();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        try(Connection connection = dbConnection.getConnection()) {

            try {
                String query = "DELETE FROM messages WHERE id_message = ?";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();

                System.out.println("Tweet Eliminado Exitosamente.");

            } catch (SQLException e) {
                System.out.println("Problemas Para Eliminar El Tweet.");
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println("Problemas De Conexión A La Base De Datos.");
            System.out.println(e);
        }
    }

}