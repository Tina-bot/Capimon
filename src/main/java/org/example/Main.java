package org.example;

import org.example.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Coach coach = new Coach();
//        Capimon enemy = new Capimon(100, "fuego");
//        Capimon ally = new Capimon(100, "planta");

        //Ingreso Nickname
/*
        coach.setWelcomeMessage();
*/
      Capimon character = Coach.assignCharacter(coach);
        character.subirNivel();
        character.subirNivel();
        System.out.println(character.showInformation());
        //Asignación de personaje al usuario con metodo random
/*        Capimon character = Coach.assignCharacter(coach);
        System.out.println(" ");
        System.out.println("Capibara asignado: " + character.getName());
        System.out.println(character.showInformation());*/

        //Incorporación de capibaras al usuario
/*        coach.setCapimonsUser(character);
        System.out.println("Capimones del usuario: " + coach.getCapimonsUser().toString());
        character.attack();

        coach.setCapimonsUser(character);
        System.out.println("_______________________");

        ArrayList<Capimon> enemies = coach.getTypesCapimons();
        for(int i = 0; i <= enemies.size(); i++) {
            Capimon enemy = enemies.get(i);
            Battle battle = new Battle(coach, character, enemy);
            battle.startBattle();
        }*/

    }
}