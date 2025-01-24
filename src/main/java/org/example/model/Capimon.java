package org.example.model;

import org.example.service.CapimonTypes;

public class Capimon implements CapimonTypes {
    private String name;
    private String category;
    private int energy = 0;
    private int level = 0;

    public Capimon() {

    }

    public String toString() {
        return name;
    }

    public Capimon(int energy, String category, int level) {
        setCategory(category);
        this.energy = energy;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    // Validación de los tipos de capimones
    public void setCategory(String category) {
        if (category.equalsIgnoreCase("agua")) {
            this.category = "agua";
            this.name = "Aquabara \uD83D\uDCA7";
        } else if (category.equalsIgnoreCase("fuego")) {
            this.category = "fuego";
            this.name = "Capibrasas \uD83D\uDD25";
        } else if (category.equalsIgnoreCase("planta")) {
            this.category = "planta";
            this.name = "Capibrotes \uD83C\uDF43";
        } else if (category.equalsIgnoreCase("electrico")) {
            this.category = "electrico";
            this.name = "Chispabara \uD83C\uDF87";
        } else if (category.equalsIgnoreCase("oscuro")) {
            this.category = "oscuro";
            this.name = "Capishadow \uD83C\uDF11";
        } else {
            throw new IllegalArgumentException("Categoría inválida. Debe ser agua, fuego o planta.");
        }
    }

    public void levelUp() {
        level++;
    }

    public String showInformation() {
        return "Información del Capimon: " + "\nNombre: " + getName() + "\nCategoría: " + getCategory() + "\nEnergía: " + getEnergy() + "\nNivel: " + getLevel();
    }

    @Override
    public void attack() {
        if (getCategory() == null) {
            throw new IllegalStateException("Primero debe establecerse una categoría.");
        }

        System.out.println("\nAtaques disponibles:");

        // Mostrar ataques específicos según el elemento
        switch (getCategory().toLowerCase()) {
            case "agua":
                System.out.println("1. Escudo de burbujas (Ataque básico).");
                System.out.println("2. Pistola de agua (Ataque especial).");
                break;
            case "fuego":
                System.out.println("1. Pirotecnia (Ataque básico).");
                System.out.println("2. Lanzallamas (Ataque especial).");
                break;
            case "planta":
                System.out.println("1. Látigo cepa (Ataque básico).");
                System.out.println("2. Navaja afilada (Ataque especial).");
                break;
            case "electrico":
                System.out.println("1. Chispa Danzante (Ataque básico).");
                System.out.println("2. Descarga Relámpago (Ataque especial).");
                break;
            case "oscuro":
                System.out.println("1. Cofre explosivo (Resta 0 energía, -99 vida).");
                System.out.println("2. Cataclismo unitario (Resta 0 energía, -150 vida).");
            default:
                throw new IllegalStateException("Categoría desconocida: " + getCategory());
        }
    }
}