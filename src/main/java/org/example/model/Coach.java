package org.example.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Coach {
    private String name;
    private ArrayList<String> typesCapimons;
    private HashSet<String> capimonsUser;

    public Coach() {
        this.typesCapimons = new ArrayList<>();
        this.capimonsUser = new HashSet<>();
        typesCapimons.add("Aquabara");
        typesCapimons.add("Capibrasas");
        typesCapimons.add("Capibrote");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nickname de entrenador: ");
        this.setName(scanner.nextLine());
        System.out.println("¡Bienvenido " + this.getName() + " a la Liga de los Capibara!");
    }

    public static String assignCharacter(Coach coach) {
        Random random = new Random();
        int index = random.nextInt(coach.typesCapimons.size());
        return coach.typesCapimons.get(index);
    }

    public void setCapimonsUser(String capimonNew) {
        capimonsUser.add(capimonNew);
    }

    public HashSet<String> getCapimonsUser() {
        return capimonsUser;
    }
}