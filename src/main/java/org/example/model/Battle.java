package org.example.model;

import org.example.service.CapimonTypeDmg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Coach playerCoach;
    private Capimon playerCapi;
    private Capimon enemyCapi;
    private ArrayList<Capimon> originalCapimons; //segui
    private int initialAllyEnergy;
    private int initialEnemyEnergy;

    public Battle(Coach playerCoach, Capimon playerCapi, Capimon enemyCapi) {
        this.playerCoach = playerCoach;
        this.playerCapi = playerCapi;
        this.enemyCapi = enemyCapi;
        this.originalCapimons = new ArrayList<>(playerCoach.getCapimonsUser());
        this.initialAllyEnergy = 100;
        this.initialEnemyEnergy = enemyCapi.getEnergy();
    }
    private void resetEnergy(){
        playerCapi.resetEnergy(initialAllyEnergy);
        enemyCapi.resetEnergy((initialEnemyEnergy));
    }
    private void resetBattle() {
        System.out.println("\nPerdiste :(, tu Capimon será llevado al hospital. 🏥");
        playerCapi.levelUp(1);
        System.out.println("\nEnergia restaurada. Ha subido al nivel: " + playerCapi.getLevel());

        resetEnergy();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢⇢\n");
        System.out.println("Presiona 'Enter' para continuar ...");
        scanner.nextLine();

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
                System.out.println("Se te unió " + enemyCapi.getName() + ", felicidades");
                resetEnergy();
                System.out.println("Tu lista actualizada: " + playerCoach.getCapimonsUser());
                break;
            } else {
                if (playerCoach.getCapimonsUser().size() > 1) {
                    playerCoach.removeFirstCapimon();
                    playerCapi = playerCoach.getNextCapimon();
                    System.out.println("\nDerrotado, ahora luchas con " + playerCapi.getName());
                } else {
                    if (playerCoach.getCapimonsUser().isEmpty()) {
                        System.out.println("Te quedaste sin Capimons. ¡La batalla ha terminado!");
                        break;
                    }
                    resetBattle();
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
                // Turno jugador
                int choice = -1;
                while (choice != 1 && choice != 2) {
                    try {
                        System.out.println("\nEs tu turno, Qué ataque querés usar?");
                        System.out.println("1 - Ataque básico");
                        System.out.println("2 - Ataque especial");
                        System.out.println("Tu elección: ");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            attack(playerCapi, enemyCapi, false, playerCapi.getLevel());
                        } else if (choice == 2) {
                            attack(playerCapi, enemyCapi, true, playerCapi.getLevel());
                        } else {
                            System.out.println("Elección inválida. Por favor, ingresa 1 o 2.");
                        }
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Ingresa un número (1 o 2).");
                        scanner.nextLine(); // Limpiar el buffer del scanner
                    }
                }
                if (enemyCapi.getEnergy() <= 0) {
                    return true; // jugador gana
                }
            } else {
                // Turno del enemigo
                System.out.println("\nEs turno del enemigo.");
                boolean isSpecialAttack = new Random().nextBoolean();
                attack(enemyCapi, playerCapi, isSpecialAttack, 3);
                if (playerCapi.getEnergy() <= 0) {
                    resetEnergy();
                    return false;
                }
            }

            playerStarts = !playerStarts;
        }
        return false;
    }

    private void attack(Capimon attacker, Capimon target, boolean isSpecial, int lvl) {
        Random luck = new Random();
        boolean miss = luck.nextInt(100) < 10;
        boolean isCritic = luck.nextInt(100) < 25;

        if (miss) {
            System.out.println(attacker.getName() + " ha fallado");
            return;
        }

        int damage = CapimonTypeDmg.calculateDamage(attacker.getCategory(), target.getCategory(), isSpecial);

        if (isCritic) {
            damage *= 1.5;
            System.out.println(attacker.getName() + " ha realizado un ataque crítico");
        }

        int remainingEnergy = target.getEnergy() - (damage * lvl / 2);
        target.setEnergy(Math.max(remainingEnergy, 0));
        System.out.println(attacker.getName() + " ataca haciendo " + damage + " de daño a " + target.getName());
    }
}
