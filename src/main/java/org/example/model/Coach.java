package org.example.model;

import java.util.Scanner;

public class Coach {

    // Atributos
    private String name;

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Constructor
    public Coach() {
    }

    // Métodos
    public void setNickname(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nickname de entrenador: ");
        this.setName(scanner.nextLine());
        System.out.println("¡Bienvenido " + this.getName() + " a la Liga de los Capibara!");
    }
}
