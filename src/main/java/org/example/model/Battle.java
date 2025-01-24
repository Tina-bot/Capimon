package org.example.model;

import org.example.service.CapimonTypeDmg;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    private Coach playerCoach;
    private Capimon playerCapi;
    private Capimon enemyCapi;
    private ArrayList<Capimon> originalCapimons;

    public Battle(Coach playerCoach, Capimon playerCapi, Capimon enemyCapi) {
        this.playerCoach = playerCoach;
        this.playerCapi = playerCapi;
        this.enemyCapi = enemyCapi;
        this.originalCapimons = new ArrayList<>(playerCoach.getCapimonsUser());
    }

    private void resetBattle() {
        System.out.println("\nPerdiste :(, tu Capimon será llevado al hospital. 🏥");
        playerCapi.setEnergy(100);
        if (enemyCapi.getName().equals("Capishadow")) {
            enemyCapi.setEnergy(300);
        } else {
            enemyCapi.setEnergy(100);
        }
        playerCapi.levelUp(1);
        System.out.println("\nEnergia restaurada. Ha subido al nivel: " + playerCapi.getLevel());
        System.out.println("La batalla se reinicia con el equipo original.");

        playerCoach.getCapimonsUser().clear();
        playerCoach.getCapimonsUser().addAll(originalCapimons);
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSe abre la pelea entre " + playerCapi.getName() +
                    " y " + enemyCapi.getName());

            boolean battleResult = executeBattle(scanner);

            if (battleResult) {
                System.out.println("\nGanaste, muy bien! ⭐");
                playerCoach.setCapimonsUser(enemyCapi);
                System.out.println("Se te unio " + enemyCapi.getName() + ", felicidades");
                System.out.println("Tu lista actulizada: " + playerCoach.getCapimonsUser());
                break;
            } else {
                if (playerCoach.getCapimonsUser().size() > 1) {
                    playerCoach.removeFirstCapimon();
                    playerCapi = playerCoach.getNextCapimon();
                    System.out.println("\nDerrotado, ahora luchas con " + playerCapi.getName());
                } else {
                    resetBattle(); //si no quedan mas
                }
            }
        }
    }

    public boolean executeBattle(Scanner scanner) {
        boolean playerStarts = true;

        while (playerCapi.getEnergy() > 0 && enemyCapi.getEnergy() > 0) {
            System.out.println("\n Info:");
            System.out.println(playerCapi.getName() + " [Tuyo] - Vida: " + playerCapi.getEnergy());
            System.out.println(enemyCapi.getName() + " [Enemigo] - Vida: " + enemyCapi.getEnergy());

            if (playerStarts) {
                // turno jugador
                System.out.println("\nEs tu turno, Qué ataque querés usar?");
                System.out.println("1 - Ataque basico");
                System.out.println("2 - Ataque especial");
                System.out.println("Tu elección: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        attack(playerCapi, enemyCapi, false, playerCapi.getLevel());
                        break;
                    case 2:
                        attack(playerCapi, enemyCapi, true, playerCapi.getLevel());
                        break;
                    default:
                        System.out.println("Elección invalida, perdes el turno.");
                }
                if (enemyCapi.getEnergy() <= 0) {
                    return true; // jugador gana
                }
            } else {
                // Turno del enemigo
                System.out.println("\nEs turno del enemigo.");
                attack(enemyCapi, playerCapi, false, 3);
                if (playerCapi.getEnergy() <= 0) {
                    return false; // El enemigo gana
                }
            }

            // quien empieza en la próxima ronda
            playerStarts = !playerStarts;
        }
        return false;
    }

    private void attack(Capimon attacker, Capimon target, boolean isSpecial, int lvl) {
        int damage = CapimonTypeDmg.calculateDamage(attacker.getCategory(), target.getCategory(), isSpecial);
        target.setEnergy(target.getEnergy() - damage * lvl / 2);
        System.out.println(attacker.getName() + " ataca haciendo " + damage + " de daño a " + target.getName());
    }
}
