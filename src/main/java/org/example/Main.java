package org.example;

import org.example.model.Capimon;
import org.example.model.Coach;

public class Main {
    public static void main(String[] args) {
        Coach coach = new Coach();
        Capimon enemy = new Capimon( 100, "agua");

        //Ingreso Nickname
        coach.setNickname();

        //Asignación de personaje al usuario con metodo random
        String character = Coach.assignCharacter(coach);
        System.out.println("Capibara asignado: " + character);

        //Incorporación de capibaras al usuario
        coach.setCapimonsUser(character);
        System.out.println("Capibaras del usuario: " + coach.getCapimonsUser());


    }
}