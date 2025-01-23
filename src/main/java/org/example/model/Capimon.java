package org.example.model;

import org.example.service.CapimonTypes;

import java.util.Scanner;

public class Capimon implements CapimonTypes {
    private String name;
    private String category;
    private int energy = 0;

    public Capimon() {

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
        } else {
            throw new IllegalArgumentException("Categoría inválida. Debe ser agua, fuego o planta.");
        }
    }

    public void ingresarCategoriaPorTeclado() {
        Scanner scanner = new Scanner(System.in);
        String categoriaIngresada = "";
        while (true) {
            System.out.print("Ingrese la categoría (agua, fuego, planta): ");
            categoriaIngresada = scanner.nextLine();

            try {
                setCategory(categoriaIngresada);
                System.out.println("Categoría: " + getCategory());
                mostrarInformacion();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void mostrarInformacion() {
        System.out.println("\nInformación del Capimon:");
        System.out.println("Nombre: " + getName());
        System.out.println("Categoría: " + getCategory());
        System.out.println("Energía: " + getEnergy());
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
            default:
                throw new IllegalStateException("Categoría desconocida: " + getCategory());
        }

        // Elegir ataque -- Esto debe ir en batalla
        Scanner scanner = new Scanner(System.in);
        System.out.print("Selecciona el ataque (0, 1 o 3): ");
        int choice = scanner.nextInt();

        // Lógica del ataque basado en la elección
        switch (choice) {
            case 0: // Ataque básico
                System.out.println(getName() + " usa Placaje (-10 energía, -15 energía del enemigo).");
                energy -= 10;
                break;
            case 1: // Primer ataque especial
                switch (getCategory().toLowerCase()) {
                    case "agua":
                        System.out.println(getName() + " usa Escudo de burbujas (-20 energía, -30 energía del enemigo).");
                        energy -= 20;
                        break;
                    case "fuego":
                        System.out.println(getName() + " usa Pirotecnia (-20 energía, -30 energía del enemigo).");
                        energy -= 20;
                        break;
                    case "planta":
                        System.out.println(getName() + " usa Látigo cepa (-20 energía, -30 energía del enemigo).");
                        energy -= 20;
                        break;
                }
                break;
            case 2:
                switch (getCategory().toLowerCase()) {
                    case "agua":
                        System.out.println(getName() + " usa Pistola de agua (-40 energía, -60 energía del enemigo).");
                        energy -= 40;
                        break;
                    case "fuego":
                        System.out.println(getName() + " usa Lanzallamas (-80 energía, -90 energía del enemigo).");
                        energy -= 80;
                        break;
                    case "planta":
                        System.out.println(getName() + " usa Navaja afilada (-50 energía, -70 energía del enemigo).");
                        energy -= 50;
                        break;
                }
            case 3:
                switch (getCategory().toLowerCase()) {
                    case "agua":
                        System.out.println(getName() + " usa defensa 1, retiene energia en ");
                        energy -= 1; //pierde poca energia
                        break;
                    case "fuego":
                        System.out.println(getName() + " usa defensa 1, retiene energia a");
                        energy -= 1; //pierde poca energia
                        break;
                    case "planta":
                        System.out.println(getName() + " usa defensa 1, retiene energia");
                        energy -= 1; //pierde poca energia
                        break;
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
}

