package org.example;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(20, 10, 100, 15, 20);
        Monster monster = new Monster(30, 8, 120, 5, 40);

        while (player.isAlive() && monster.isAlive()) {
            player.attackCreature(monster);
            if (monster.isAlive()) {
                monster.attackCreature(player);
            }
            if (player.getHealingCount()<4){
                player.heal();
            }
        }
        if (player.isAlive()) {
            System.out.println("\nЧудовище пало от рук игрока!");
        } else {
            System.out.println("\nГерой пал в неравном бою!");
        }
    }
}
