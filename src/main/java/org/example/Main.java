package org.example;

import org.example.model.Coach;
import org.example.model.Capimon;

public class Main {
    public static void main(String[] args) {
        Coach coach = new Coach();

        //Ingreso Nickname
        coach.setWelcomeMessage();

        //Asignación de personaje al usuario con metodo random
        Capimon character = Coach.assignCharacter(coach);
        System.out.println(" ");
        System.out.println("Capibara asignado: " + character.getName());
        System.out.println(character.showInformation());

        //Incorporación de capibaras al usuario
        coach.setCapimonsUser(character);
        System.out.println("Capimones del usuario: " + coach.getCapimonsUser().toString());
        character.attack();

    }
}