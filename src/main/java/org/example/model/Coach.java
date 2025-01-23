package org.example.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Coach {
    private String name;
    private ArrayList<Capimon> typesCapimons;
    private HashSet<Capimon> capimonsUser;

    Capimon capibrote = new Capimon(100, "planta");
    Capimon capibrasa = new Capimon(100, "fuego");
    Capimon aquabara = new Capimon(100, "agua");
    Capimon capishadow = new Capimon(300, "oscuro");

    public Coach() {
        this.typesCapimons = new ArrayList<>();
        this.capimonsUser = new HashSet<>();
        typesCapimons.add(capibrote);
        typesCapimons.add(capibrasa);
        typesCapimons.add(aquabara);
        typesCapimons.add(capishadow);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWelcomeMessage() {
        System.out.println("¡Hola forastero! Veo que eres nuevo por aquí. ¿Cómo es tu nombre?");
        Scanner scanner = new Scanner(System.in);
        this.setName(scanner.nextLine());
        System.out.println("¡Bienvenido " + this.getName() + " a Pueblo Capibara! Aquí comienza tu aventura.");
        System.out.println("Tendrás que superar tres batallas contra " +
                "distintos capimones del tipo: fuego, agua y planta.");

        System.out.println("Si consigues la victoria en los tres duelos, enfrentaras al boss final: " +
                "Capibarco Pirata.");

        System.out.println("Pero tranquilo, no estarás solo: aquí" +
                " te asignamos a tu compañero Capimon para que te acompañe durante el viaje. ¡Mucha suerte!");
    }

    public static Capimon assignCharacter(Coach coach) {
            Random random = new Random();
            int index = random.nextInt(3);
            return coach.typesCapimons.get(index);
    }

    public ArrayList<Capimon> getTypesCapimons() {
        return typesCapimons;
    }

    public void setCapimonsUser(Capimon capimonNew) {
        capimonsUser.add(capimonNew);
    }

    public HashSet<Capimon> getCapimonsUser() {
        return capimonsUser;
    }
}