package org.example;

class Monster extends Creature {
    public Monster(int attack, int defense, int health, int minDamage, int maxDamage) {
        super(attack, defense, health, minDamage, maxDamage);
        System.out.println("Монстр на горизонте!\n");
    }
}
