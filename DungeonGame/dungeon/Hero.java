package DungeonCharacters;

import java.util.Scanner;

/**
 * Title: DungeonCharacters.Hero.java
 * <p>
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 * from DungeonCharacters.DungeonCharacter.  A DungeonCharacters.Hero has battle choices: regular attack and a
 * special skill which is defined by the classes derived from DungeonCharacters.Hero.
 * <p>
 * class variables (all are directly accessible from derived classes):
 * chanceToBlock -- a hero has a chance to block an opponents attack
 * numTurns -- if a hero is faster than opponent, their is a possibility
 * for more than one attack per round of battle
 * <p>
 * class methods (all are public):
 * public DungeonCharacters.Hero(String name, int hitPoints, int attackSpeed,
 * double chanceToHit, int damageMin, int damageMax,
 * double chanceToBlock)
 * public void readName()
 * public boolean defend()
 * public void subtractHitPoints(int hitPoints)
 * public void battleChoices(DungeonCharacters.DungeonCharacter opponent)
 * <p>
 * Copyright:    Copyright (c) 2001
 * Company:
 *
 * @author
 * @version 1.0
 */


abstract class Hero extends DungeonCharacter {
    protected double chanceToBlock;
    protected int numTurns;

    public Hero(String name, int hitPoints, int attackSpeed,
                double chanceToHit, int damageMin, int damageMax,
                double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToBlock = chanceToBlock;
        readName();
    }

    private void readName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter character name: ");
        this.name = in.nextLine();

    }

    public void subtractHitPoints(int hitPoints) {
        if (Math.random() <= chanceToBlock) {
            System.out.println(name + " BLOCKED the attack!");
        } else {
            super.subtractHitPoints(hitPoints);
        }

    }

    public void battleChoices(DungeonCharacter opponent) {
        numTurns = calcTurns(this.attackSpeed, opponent.getAttackSpeed());

        if (numTurns == 0)
            numTurns++;

        System.out.println("Number of turns this round is: " + numTurns);

        int choice;

        Scanner inInt = new Scanner(System.in);

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. " + specialOption());
            System.out.print("Choose an option: ");
            choice = inInt.nextInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    specialMove(opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }

            numTurns--;
            if (numTurns > 0)
                System.out.println("Number of turns remaining is: " + numTurns);

        } while (numTurns > 0);

    }

    private int calcTurns(final int attackSpeedHero, final int attackSpeedMonster) {
        return attackSpeedHero / attackSpeedMonster;
    }

    protected abstract String specialOption();

}