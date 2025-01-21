package org.example;

import org.example.model.Battle;
import org.example.model.Capifire;
import org.example.model.Capimon;
import org.example.model.Capiwater;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Capimon> capis = new HashSet();
        Capiwater blas = new Capiwater("Blas", 200, 300, true);
        Capifire fuegui = new Capifire("Fuegui", 400, 400, true);
        Capiwater tipito = new Capiwater("Tipito", 200, 300, true);

        Battle pelea1 = new Battle(blas, fuegui);
        boolean battleWin = false;
        while (!battleWin) {
            battleWin = pelea1.StartBattle();
        }
        capis.add(fuegui);
        System.out.println("Ganaste, Te agarraste un capi nuevo");

        Battle pelea2 = new Battle(blas, tipito);
        boolean battleWin2 = false;
        while (!battleWin2) {
            battleWin2 = pelea2.StartBattle();
        }
        capis.add(tipito);
        System.out.println("Ganaste la segunda, segundo capi añadido");
    }
}