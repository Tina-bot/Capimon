package org.example;

import org.example.model.CapiShadow;
import org.example.model.Coach;
import org.example.model.Capimon;
import org.example.model.FinalBoss;
import org.example.service.utilities.CreateObjects;

public class Main {
    public static void main(String[] args) {
//        Coach coach = new Coach();
//
//        //Ingreso Nickname
//        coach.setWelcomeMessage();
//
//        //Asignación de personaje al usuario con metodo random
//        Capimon character = Coach.assignCharacter(coach);
//        System.out.println(" ");
//        System.out.println("Capibara asignado: " + character.getName());
//        System.out.println(character.showInformation());
//
//
//        //Incorporación de capibaras al usuario
//        coach.setCapimonsUser(character);
//        System.out.println("Capimones del usuario: " + coach.getCapimonsUser().toString());
//        character.attack();

        //Boss final
        FinalBoss finalBoss = new FinalBoss();
        CapiShadow capiShadow = new CapiShadow(300, "oscuro", "CapiShadow");

        System.out.println(finalBoss.showBossData());
        System.out.println(capiShadow.showDataShadow());

        capiShadow.attack();







    }
}