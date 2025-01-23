package org.example.service.utilities;
import org.example.model.Battle;
import org.example.model.Capimon;
import org.example.model.Coach;

public class CreateObjects {
    private  Coach coach = new Coach();
    private  Capimon miCapimon = new Capimon("Pepe");
    private  Capimon enemigo = new Capimon("Mario", "Agua");
    private  Battle battle = new Battle(miCapimon, enemigo);
    public  Coach getCoach() {
        return coach;    }
    public  Capimon getCapimon() {
        return miCapimon;
    }
    public  Battle getBattle() {
        return battle;
    }}