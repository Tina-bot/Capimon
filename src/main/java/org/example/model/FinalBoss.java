package org.example.model;

import org.example.service.CapimonTypes;

public class FinalBoss extends Coach implements CapimonTypes {


    @Override
    public void attack() {
        if (getCategory() == null) {
            throw new IllegalStateException("Error al cargar boss final");

        }
        System.out.println("\nAtaques disponibles:");


        switch (getCategory().toLowerCase()) {
            case "boss":
                System.out.println("0. Placaje (Resta 10 energía, -15 energía del enemigo)."); // Ataque básico
                System.out.println("1. Cofre explosivo (resta 0 energia, -99 vida)"); // Ataque básico
                System.out.println("2. Cataclismo unitario (resta 0 energia, -150 vida)"); // Ataque básico

                break;

        }
    }
}
