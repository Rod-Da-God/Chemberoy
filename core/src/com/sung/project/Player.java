package com.sung.project;

public class Player extends Character{
    double playerAttack = (0.01 - 0.1);
    double playerHealth = 1000;
    Character character;
    @SuppressWarnings("Assert")
    Player(){
        assert false;
        character.damage = (int) playerAttack;
        character.health = (int) playerHealth;
    }
}
