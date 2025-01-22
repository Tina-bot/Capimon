package org.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Coach {
    private ArrayList<String> typesCapimons;
    private HashSet<String> capimonsUser;

    public Coach() {
        this.typesCapimons = new ArrayList<>();
        this.capimonsUser = new HashSet<>();
        typesCapimons.add("Aquabara");
        typesCapimons.add("Capibrasas");
        typesCapimons.add("Capibrote");
    }

    public static String assingCharacter(Coach coach) {
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
