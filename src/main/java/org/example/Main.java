package org.example;

import org.example.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Capimon> typesCapimons;

        Capimon capielectric = new Capimon(100, "electrico");
        Capimon capibrote = new Capimon(100, "planta");
        Capimon capibrasa = new Capimon(100, "fuego");
        Capimon aquabara = new Capimon(100, "agua");
        Capimon capishadow = new Capimon(300, "oscuro");

        typesCapimons = new ArrayList<>();
        typesCapimons.add(capibrote);
        typesCapimons.add(capibrasa);
        typesCapimons.add(aquabara);
        typesCapimons.add(capishadow);

        Coach coach = new Coach();
        coach.setCapimonsUser(capielectric);

        //Ingreso Nickname
        coach.setWelcomeMessage();

        //Incorporación de capibaras al usuario
        coach.getCapimonsUser();
        System.out.println("Capimones del usuario: " + coach.getCapimonsUser().toString());
        capielectric.attack();


        System.out.println("_______________________");

        for (int i = 0; i <= typesCapimons.size(); i++) {
            Capimon enemy = typesCapimons.get(i);
            Battle battle = new Battle(coach, capielectric, enemy);
            battle.startBattle();
        }

    }
}