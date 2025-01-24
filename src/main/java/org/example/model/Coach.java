package org.example.model;

import java.util.Scanner;
import java.util.HashSet;

public class Coach {
    private String name;
    private HashSet<Capimon> capimonsUser;

    public Coach() {
        this.capimonsUser = new HashSet<>();
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

    public void setCapimonsUser(Capimon capimonNew) {
        capimonsUser.add(capimonNew);
    }

    public HashSet<Capimon> getCapimonsUser() {
        return capimonsUser;
    }
}