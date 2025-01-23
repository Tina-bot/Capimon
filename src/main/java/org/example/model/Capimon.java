package org.example.model;

import org.example.service.CapimonTypes;

public class Capimon implements CapimonTypes {
    private String name;
    private String category;
    private int energy = 0;

    public Capimon() {

    }

    public String toString() {
        return name;
    }

    public Capimon(int energy, String category) {
        setCategory(category);
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getCategory() {
        return category;
    }

    // Validación de los tipos de capimones
    public void setCategory(String category) {
        if (category.equalsIgnoreCase("agua")) {
            this.category = "agua";
            this.name = "Aquabara";
        } else if (category.equalsIgnoreCase("fuego")) {
            this.category = "fuego";
            this.name = "Capibrasas";
        } else if (category.equalsIgnoreCase("planta")) {
            this.category = "planta";
            this.name = "Capibrotes";
        }else if (category.equalsIgnoreCase("oscuro")) {
            this.category = "oscuro";
            this.name = "Capishadow";
        } else {
            throw new IllegalArgumentException("Categoría inválida. Debe ser agua, fuego o planta.");
        }
    }

    public String showInformation() {
        return "Información del Capimon: " + "\nNombre: " + getName() + "\nCategoría: " + getCategory() + "\nEnergía: " + getEnergy();
    }

    @Override
    public void attack() {
        if (getCategory() == null) {
            throw new IllegalStateException("Primero debe establecerse una categoría.");
        }

        System.out.println("\nAtaques disponibles:");
        System.out.println("0. Placaje (Resta 10 energía, -15 energía del enemigo)."); // Ataque básico

        // Mostrar ataques específicos según el elemento
        switch (getCategory().toLowerCase()) {
            case "agua":
                System.out.println("1. Escudo de burbujas (-20 energía, -30 energía del enemigo).");
                System.out.println("2. Pistola de agua (-40 energía, -60 energía del enemigo).");
                break;
            case "fuego":
                System.out.println("1. Pirotecnia (-20 energía, -30 energía del enemigo).");
                System.out.println("2. Lanzallamas (-80 energía, -90 energía del enemigo).");
                break;
            case "planta":
                System.out.println("1. Látigo cepa (-20 energía, -30 energía del enemigo).");
                System.out.println("2. Navaja afilada (-50 energía, -70 energía del enemigo).");
                break;
            case "oscuro":
                System.out.println("0. Placaje (Resta 10 energía, -15 energía del enemigo).");
                System.out.println("1. Cofre explosivo (Resta 0 energía, -99 vida).");
                System.out.println("2. Cataclismo unitario (Resta 0 energía, -150 vida).");
            default:
                throw new IllegalStateException("Categoría desconocida: " + getCategory());
        }
    }
}