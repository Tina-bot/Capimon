package org.example;

import org.example.model.*;
import org.example.service.utilities.CreateObjects;

public class Main {
    public static void main(String[] args) {
        Coach coach = new Coach();
        Capimon enemy = new Capimon( 100, "fuego");
        Capimon ally = new Capimon(100, "planta");

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

        coach.setCapimonsUser(character);
        System.out.println("Capibaras del usuario: " + coach.getCapimonsUser());
        System.out.println("_______________________");
        Battle battle1 = new Battle(coach, ally, enemy);
        battle1.startBattle();






    }
}