package com.messages.app.crud.ui;

import com.messages.app.crud.models.services.MessageService;

import java.util.Scanner;

public class UIMessageMenu {
    public static void showMessageMenu() {
        int choose;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("--------------------------------------------------------");
            System.out.println(" ========= App De Mensajes ========= ");
            System.out.println("1. Listar Mensajes.");
            System.out.println("2. Listar Mensaje.");
            System.out.println("3. Crear Mensaje.");
            System.out.println("4. Editar Mensaje.");
            System.out.println("5. Eliminar Mensaje.");
            System.out.println("6. Salir.");
            System.out.println(" ========= App De Mensajes ========= ");
            System.out.println("--------------------------------------------------------");

            System.out.println("Seleccione Un Item Del Menú De Opciones: ");
            choose = input.nextInt();

            switch (choose) {
                case 1:
                    MessageService.list();
                    break;

                case 2:
                    MessageService.findById();
                    break;

                case 3:
                    MessageService.create();
                    break;

                case 4:
                    MessageService.update();
                    break;

                case 5:
                    MessageService.delete();
                    break;

                default:
                    System.exit(-1);
                    break;
            }
        } while (choose != 6);
    }
}
