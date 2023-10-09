package org.example;

import java.util.Random;

class Player extends Creature {
    private int healingCount;
    private static final int MAX_HEAL_COUNT = 4;
    public Player(int attack, int defense, int health, int minDamage, int maxDamage) {
        super(attack, defense, health, minDamage, maxDamage);
        healingCount = 0;
        System.out.println("\nИгрок готов к бою!");
    }

    public int getHealingCount() {
        return healingCount;
    }

    public void heal() {
        if (healingCount < MAX_HEAL_COUNT) {
            int maxHeal = (int) (0.3 * this.getMaxHealth());
            if (this.getHealth() == 0) {
                return;
            }
            int healAmount = new Random().nextInt(maxHeal) + 1;
            this.setHealth(this.getHealth()+healAmount);
            if (this.getHealth() > this.getMaxHealth()) {
                this.setHealth(this.getMaxHealth());
                System.out.println();
                System.out.println("Игрок выпил зелье и полностью востановил здоровье.");
            } else {
                System.out.println("Игрок выпил зелье и востановил "+healAmount+" здоровья.");
            }
            healingCount++;
        } if (healingCount == MAX_HEAL_COUNT){
            System.out.println("В сумке игрока больше нет зелья для исцеления!");
        }
    }
}
