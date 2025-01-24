
package org.example.model;

import org.example.service.CapimonTypeDmg;

import java.util.Scanner;

public class Battle {
    private Coach playerCoach;
    private Capimon playerCapi;
    private Capimon enemyCapi;

    public Battle(Coach playerCoach, Capimon playerCapi, Capimon enemyCapi) {
        this.playerCoach = playerCoach;
        this.playerCapi = playerCapi;
        this.enemyCapi = enemyCapi;
    }

    private void resetBattle() {
        // Restablece la energía inicial de ambos capimons
        System.out.println("\nPerdiste :(, su Capimon será transladado al hospital. 🏥");
        playerCapi.setEnergy(100);
        if(enemyCapi.getName().equals("Capishadow")){
            enemyCapi.setEnergy(300);
        } else {
            enemyCapi.setEnergy(100);
        }
        playerCapi.subirNivel();
        System.out.println("\nEnergia restaurada. Ha subido al nivel: " + playerCapi.getNivel());

        //Pausa
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢\n");
        System.out.println("Presiona 'Enter' para continuar ...");
        scanner.nextLine();
        
        System.out.println(" La batalla se reinicia!");
    }


    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Se abre la pelea entre " + playerCapi.getName() +
                    " y " + enemyCapi.getName());

            boolean battleResult = executeBattle(scanner);

            if (battleResult) {
                System.out.println("\nGanaste, muy bien! ⭐");
                playerCoach.setCapimonsUser(enemyCapi);
                System.out.println("Se te unio " + enemyCapi + " ,felicidades");
                System.out.println("Tu lista actulizada: " + playerCoach.getCapimonsUser());
                break;
            } else {
                resetBattle();
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
                System.out.println("\nEs tu turno, ¿qué ataque querés usar?");
                System.out.println("1 - Ataque basico");
                System.out.println("2 - Ataque especial");
                System.out.println("Tu elección: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        attack(playerCapi, enemyCapi, false,3);
                        break;
                    case 2:
                        attack(playerCapi, enemyCapi, true,3);
                        break;
                    default:
                        System.out.println("Elección invalida, perdés el turno.");
                }
                if (enemyCapi.getEnergy() <= 0) {
                    return true; // El jugador gana
                }
            } else {
                // Turno del enemigo
                System.out.println("\nEs turno del enemigo.");
                attack(enemyCapi, playerCapi, false,3);
                if (playerCapi.getEnergy() <= 0) {
                    return false; // enemigo gana
                }
            }

            // quien empieza en la próxima ronda
            playerStarts = !playerStarts;
        }
        return false;
    }


    private void attack(Capimon attacker, Capimon target, boolean isSpecial, int lvl) {
        int damage = CapimonTypeDmg.calculateDamage(attacker.getCategory(), target.getCategory(), isSpecial);
        target.setEnergy(target.getEnergy() - damage * lvl/2);
        System.out.println(attacker.getName() + " ataca haciendo " + damage + " de daño a "
                + target.getName());
    }

}
