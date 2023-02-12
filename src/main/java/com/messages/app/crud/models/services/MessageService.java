package com.messages.app.crud.models.services;

import com.messages.app.crud.models.entity.Message;
import com.messages.app.crud.models.repository.MessageRepository;

import java.util.List;
import java.util.Scanner;

public class MessageService {
    static Scanner input = new Scanner(System.in);

    public static void list() {
        MessageRepository.list();
    }

    public static void findById() {
        System.out.println("\nIngrese El Código Del Tweet Que Desea Buscar: ");
        int id = input.nextInt();

        MessageRepository.findById(id);
    }

    public static void create() {
        System.out.println("\nIngrese Un Tweet: ");
        String tweet = input.nextLine();

        System.out.println("Ingrese Un Author: ");
        String author = input.nextLine();

        System.out.println("Ingrese La Fecha Del Tweet: dd/MM/yyyy");
        String date = input.next();

        Message message = new Message();
        message.setMessageContent(tweet);
        message.setMessageAuthor(author);
        message.setMessageDate(date);

        MessageRepository.create(message);
    }

    public static void update() {
        System.out.println("\nIngrese El Código Del Tweet Que Desea Actualizar: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.println("\nIngrese El Nuevo Tweet: ");
        String tweet = input.nextLine();

        Message message = new Message();
        message.setIdMessage(id);
        message.setMessageContent(tweet);

        MessageRepository.update(message);
    }

    public static void delete() {
        System.out.println("\nIngrese El Código Del Tweet Que Desea Eliminar: ");
        int id = input.nextInt();

        MessageRepository.delete(id);
    }

}