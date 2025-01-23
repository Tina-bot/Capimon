package org.example;

import org.example.model.Capimon;
import org.example.service.utilities.CreateObjects;

public class Main {
    public static void main(String[] args) {

        Capimon capimon1 = new Capimon( 100, "agua");
        capimon1.ingresarCategoriaPorTeclado();

        capimon1.attack();


        /*CreateObjects createObjects = new CreateObjects();

        Capimon miCapimon = createObjects.getCapimon();
        Capimon enemy = createObjects.getEnemy();

        miCapimon.ingresarCategoriaPorTeclado();
        miCapimon.attack();*/
    }
}