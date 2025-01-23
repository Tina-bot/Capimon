package org.example.model;

import org.example.service.CapimonTypes;

public class FinalBoss extends Coach {

    private String nameBoss = "CapitaNegra Mockinator";
    private CapiShadow capimon;

    // Constructor
    public FinalBoss() {
       this.capimon = new CapiShadow(300, "oscuro", "CapiShadow");
    }


    public String getNameBoss() {
        return nameBoss;
    }

    public CapiShadow getCapimon() {
        return capimon;
    }

    public String showBossData() {
        return "Información del Boss Final:" +
                "\nNombre: " + getNameBoss();
    }

}
