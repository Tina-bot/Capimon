package org.example;

import org.example.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Capimon> typesCapimons;

        Capimon chispabara = new Capimon(100, "electrico", 1);
        Capimon capibrote = new Capimon(100, "planta", 1);
        Capimon capibrasa = new Capimon(100, "fuego", 1);
        Capimon aquabara = new Capimon(100, "agua", 1);
        Capimon capishadow = new Capimon(300, "oscuro", 1);

        typesCapimons = new ArrayList<>();
        typesCapimons.add(capibrote);
        typesCapimons.add(capibrasa);
        typesCapimons.add(aquabara);
        typesCapimons.add(capishadow);

        Coach coach = new Coach();
        coach.setCapimonsUser(chispabara);

        //Ingreso Nickname
        coach.setWelcomeMessage();

        //Incorporación de capibaras al usuario
        coach.getCapimonsUser();
        System.out.println("Capimones del usuario: " + coach.getCapimonsUser().toString());

        System.out.println("\n⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢\n" +
                " ");

        System.out.println(chispabara.showInformation());
        chispabara.attack();

        System.out.println("\n⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢\n");

        for (int i = 0; i < typesCapimons.size(); i++) {
            Capimon enemy = typesCapimons.get(i);
            Battle battle = new Battle(coach, chispabara, enemy);
            battle.startBattle();
        }

        System.out.println("\nFINAL\n");
    }
}