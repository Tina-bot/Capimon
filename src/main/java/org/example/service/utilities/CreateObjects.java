package org.example.service.utilities;

import org.example.model.Capimon;
import org.example.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class CreateObjects {
    private Coach coach = new Coach();
    private Capimon miCapimon = new Capimon();
    private Capimon enemy = new Capimon();
    private Coach bossFinal = new Coach();
    private List<Capimon> capimonList = new ArrayList<>();

    public CreateObjects() {
        Capimon capibrote = new Capimon(100, "planta");
        Capimon capibrasa = new Capimon(100, "fuego");
        Capimon aquabara = new Capimon(100, "agua");

        capimonList.add(capibrote);
        capimonList.add(capibrasa);
        capimonList.add(aquabara);
    }
    // Métodos para obtener los objetos

    public Coach getCoach() {
        return coach;
    }

    public Capimon getCapimon() {
        return miCapimon;
    }

    public Capimon getEnemy() {
        return enemy;
    }

    public Coach getBossFinal() {
        return bossFinal;
    }

    public List<Capimon> getCapimonList() {
        return capimonList;
    }
}
