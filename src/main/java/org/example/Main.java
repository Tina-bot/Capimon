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

        coach.setWelcomeMessage();

        coach.getCapimonsUser();
        System.out.println("Capimones del usuario: " + coach.getCapimonsUser().toString());

        System.out.println("\n⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢\n");

        System.out.println(chispabara.showInformation());
        chispabara.attack();

        System.out.println("\n⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢\n");

        for (int i = 0; i < typesCapimons.size(); i++) {
            Capimon enemy = typesCapimons.get(i);

            if (i == 0) {
                enemy.levelUp(0);
            } else if (i == 1) {
                enemy.levelUp(2);
                enemy.setEnergy(enemy.getEnergy() + 10);
            } else if (i == 2) {
                enemy.levelUp(3);
                enemy.setEnergy(enemy.getEnergy() + 20);
            } else if (i == 3) {
                enemy.levelUp(4);
                enemy.setEnergy(enemy.getEnergy() + 26);
            }

            System.out.println("Batalla " + (i + 1) + ": ¡" + enemy.getName() + " ahora está en el nivel " + enemy.getLevel() + "!");
            System.out.println("Energía actualizada: " + enemy.getEnergy());

            Battle battle = new Battle(coach, chispabara, enemy);
            battle.startBattle();
        }

        System.out.println("\n¡Felicidades " + coach.getName() + "! Has derrotado a Capishadow y completado tu aventura.");
        System.out.println("Has demostrado ser un gran entrenador de Capimones. ¡Gracias por jugar!");
        System.out.println("¡Nos vemos en la próxima aventura!");
    }
}