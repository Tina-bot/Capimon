package org.example.service.utilities;


import org.example.model.Battle;
import org.example.model.Capimon;
import org.example.model.Coach;

public class CreateObjects {

    private  Coach coach = new Coach();

    private  Capimon miCapimon = new Capimon("Pepe"); //funciona tanto como jugador como enemigo

    private  Capimon enemigo = new Capimon("Mario", "Agua");

    private  Battle battle = new Battle(); //funcion podria funcionar mejor como una funcion en capimon siendo mas un metodo a llamar entre ellos

    //Los siguientes son los metodos para acceder a las instancias

    public  Coach getCoach() {
        return coach;
    }

    public  Capimon getCapimon() {
        return miCapimon;
    }

    public  Battle getBattle() {
        return battle;
    }

}
