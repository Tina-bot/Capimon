package org.example.service.utilities;


import org.example.model.Battle;
import org.example.model.Capimon;
import org.example.model.Coach;

public class CreateObjects {

    private static final Coach coach = new Coach();

    private static final Capimon capimon = new Capimon(); //funciona tanto como jugador como enemigo

    private static final Battle battle = new Battle(); //funcion podria funcionar mejor como una funcion en capimon siendo mas un metodo a llamar entre ellos

    //Los siguientes son los metodos para acceder a las instancias

    public static Coach getCoach() {
        return coach;
    }

    public static Capimon getCapimon() {
        return capimon;
    }

    public static Battle getBattle() {
        return battle;
    }

}
