package org.example.model;

public class Capimon {

    String nombre;
    String tipo;
    int healt = 0;

    public Capimon(String nombre) {

    }

    public Capimon(String nombre, String tipo) {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }



    //crear, uno para el nuestro y el otro enemigo. Cuando instanciemos el enemigo en el main


    /*private String name;
    private int health;
    private int defense;
    private boolean isAlive;

    public Capimon(String name, int health, int defense, boolean isAlive) {
        this.name = name;
        this.health = health;
        this.isAlive = isAlive;
    }

    public Capimon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) setAlive(false);
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return health >= 0;
    }

    public void reset(int health){
        this.health=health;
        this.isAlive=true;
    }*/
}

