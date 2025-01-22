package org.example.model;

import java.util.Scanner;

public class Battle {




    /*
    private Capimon capi1;
    private Capimon capi2;
    private int capi1VidaFull;
    private int capi2VidaFull;
    private Scanner scanner;

    public Battle(Capimon capi1, Capimon capi2) {
        this.capi1 = capi1;
        this.capi2 = capi2;
        this.capi1VidaFull = capi1.getHealth();
        this.capi2VidaFull = capi2.getHealth();
    }

    public Battle() {

    }

    public boolean StartBattle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Comienza la batalla entre: " + capi1.getName() +
                " Y " + capi2.getName());
        while (capi1.isAlive() && capi2.isAlive()) {
            System.out.println("---------------");
            System.out.println("Ataca el muchacho: " + capi1.getName());
            System.out.println("Vida: " + capi2.getHealth() + " de " + capi2.getName());
            System.out.println("1-Ataque 2-Ataque2 3-Ataque3");
            int selectedAttack = scanner.nextInt();
            switch (selectedAttack) {
                case 1:
                    capi2.takeDamage(30);
                    System.out.println("Vida Despues de ser atacado : " + capi2.getHealth() + " de " + capi2.getName());
                    break;
                case 2:
                    capi2.takeDamage(80);
                    System.out.println("Vida Despues de ser atacado : " + capi2.getHealth() + " de " + capi2.getName());
                    break;
                case 3:
                    System.out.println("Aca iria el especial y un 4to case");
                    break;
                default:
                    System.out.println("no valido");
            }
            if (!capi2.isAlive()) {
                System.out.println(capi2.getName() + " Fue derrotado, buena");
                return true;
            }
            System.out.println("---------------");
            System.out.println("Ataca el muchacho: " + capi2.getName());
            System.out.println("Vida : " + capi1.getHealth() + " de " + capi1.getName());
            capi1.takeDamage(30);
            System.out.println("Vida Despues de ser atacado : " + capi1.getHealth() + " de " + capi1.getName());
            if (!capi1.isAlive()) {
                System.out.println("Te gano el capimalo, reseteando");
                resetBattle();
            }
        }

        return false;
    }

    private void resetBattle() {
        capi1.reset(capi1VidaFull);
        capi2.reset(capi2VidaFull);
    }*/
}
