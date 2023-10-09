package org.example;

import java.util.Random;

class Creature {
    private int attack;
    private int defense;
    private int health;
    private int maxHealth;
    private int minDamage;
    private int maxDamage;

    public Creature(int attack, int defense, int health, int minDamage, int maxDamage) {
        if (attack < 1 || defense < 1 || health < 0 || minDamage >= maxDamage) {
            throw new IllegalArgumentException("Некорректные параметры существа");
        }
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон не может быть отрицательным");
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean attackCreature(Creature target) {
        int attackModifier = attack - target.getDefense() + 1;
        attackModifier = Math.max(1, attackModifier);
        int numDiceRolls = attackModifier;
        Random random = new Random();
        boolean successfulHit = false;

        for (int i = 0; i < numDiceRolls; i++) {
            int diceRoll = random.nextInt(6) + 1;
            if (diceRoll >= 5) {
                successfulHit = true;
                break;
            }
        }

        if (successfulHit) {
            int damage = Math.min(maxDamage, random.nextInt(getMaxDamage() - getMinDamage() + 1) + getMinDamage());
            target.takeDamage(damage);
            if (this instanceof Player) {
                System.out.println("Игрок нанес урон монстру в размере " + damage + " единиц.");
            } else if (this instanceof Monster) {
                System.out.println("Монстр нанес урон игроку в размере " + damage + " единиц.");
            }
            return true;
        } else {
            if (this instanceof Player) {
                System.out.println("Игрок промахнулся.");
            } else if (this instanceof Monster) {
                System.out.println("Монстр промахнулся.");
            }
            return false;
        }
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}
