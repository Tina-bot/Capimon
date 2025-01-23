package org.example;

import org.example.model.Capimon;
import org.example.model.Coach;
import org.example.service.utilities.CreateObjects;

public class Main {

    public static void main(String[] args) {

        Coach coach = new Coach();

        //Ingreso Nickname
        coach.setWelcomeMessage();
        Capimon capimon1 = new Capimon( 100, "agua");
        capimon1.ingresarCategoriaPorTeclado();

        //Asignación de personaje al usuario con metodo random
        String character = Coach.assignCharacter(coach);
        System.out.println("");
        System.out.println("Capibara asignado: " + character);
        capimon1.attack();

        //Incorporación de capibaras al usuario
        coach.setCapimonsUser(character);
        System.out.println("Capibaras del usuario: " + coach.getCapimonsUser());

    }
}