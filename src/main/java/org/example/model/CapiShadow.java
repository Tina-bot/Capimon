package org.example.model;

import org.example.service.CapimonTypes;

public class CapiShadow implements CapimonTypes {

    private String name;
    private int energy;
    private String category;

    // Constructor con parámetros
    public CapiShadow(int energy, String category, String name) {
        this.energy = 300;
        this.category = "oscuro";
        this.name = "CapiShadow";
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public String getCategory() {
        return category;
    }


    public String showDataShadow() {
        return "Información del capimon final:" +
                "\nNombre: " + getName() +
                "\nCategoría: " + getCategory();
    }

    @Override
    public void attack() {
        if (!isBossFinal()) {
            throw new IllegalStateException("Este no es el boss final.");
        }

        System.out.println("\nAtaques disponibles del capimon final:");
        System.out.println("0. Placaje (Resta 10 energía, -15 energía del enemigo).");
        System.out.println("1. Cofre explosivo (Resta 0 energía, -99 vida).");
        System.out.println("2. Cataclismo unitario (Resta 0 energía, -150 vida).");

    }

    private boolean isBossFinal() {
        return "oscuro".equalsIgnoreCase(getCategory());
    }
}
