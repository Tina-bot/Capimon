package org.example.model;

import org.example.service.CapimonTypeDmg;

import java.util.Scanner;

public class Battle {
    private Coach playerCoach;
    private Capimon playerCapi;
    private Capimon enemyCapi;

    public Battle(Coach playerCoach, Capimon playerCapi, Capimon enemyCapi) {
       this.playerCoach = playerCoach;
      /* this.playerCapi = getFirstCapi(playerCoach);*/
        this.playerCapi = playerCapi;
        this.enemyCapi = enemyCapi;
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Se abre la pelea entre " + playerCapi.getName() +
                    " y " + enemyCapi.getName());

            playerCapi.setEnergy(100);
            enemyCapi.setEnergy(100);

            boolean battleResult = executeBattle(scanner);

            if (battleResult) {
                System.out.println("\nGanaste, muy bien!");
                playerCoach.setCapimonsUser(enemyCapi.getName());
                System.out.println("Se te unio " + enemyCapi.getName() + " ,felicidades");
                System.out.println(playerCoach.getCapimonsUser());
                break;
            } else {
                System.out.println("\nPerdiste :(, se reiniciara la batalla");
            }
        }
    }

    public boolean executeBattle(Scanner scanner) {
        while (playerCapi.getEnergy() > 0 && enemyCapi.getEnergy() > 0) {
            System.out.println("\n Info:");
            System.out.println(playerCapi.getName() + " [Tuyo] - Vida: " + playerCapi.getEnergy());
            System.out.println(enemyCapi.getName() + " [Enemigo] - Vida: " + enemyCapi.getEnergy());

            //turno propio
            System.out.println("\nEs tu turno, que ataque queres usar?");

            System.out.println("1-Ataque basico");
            System.out.println("2- Ataque especial");
            System.out.println("Tu eleccion: ");
            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    attack(playerCapi, enemyCapi, false);
                    break;
                case 2:
                    attack(playerCapi, enemyCapi, true);
                    break;
                default:
                    System.out.println("Eleccion invalida, perdes turno por manco");
            }
            if (enemyCapi.getEnergy() <= 0) {
                return true; //jugador gana
            }
            //turno enemigo
            attack(enemyCapi, playerCapi, false);
            if (playerCapi.getEnergy() <= 0) {
                return false; //te gana
            }
        }
        return false;
    }


    private void attack(Capimon attacker, Capimon target, boolean isSpecial) {
        int damage= CapimonTypeDmg.calculateDamage(attacker.getCategory(), target.getCategory(), isSpecial);
        target.setEnergy(target.getEnergy() - damage);
        System.out.println(attacker.getName() + " ataca haciendo " + damage + " de daños a "
                + target.getName());
    }

    private Capimon getFirstCapi (Coach coach){
        String firstCapi = (String) coach.getCapimonsUser().toArray()[0];
        return new Capimon(firstCapi);
    }
}


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
