package org.example.model;

import java.util.Scanner;

public class Capimon {
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
}

