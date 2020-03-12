package dungeon;

/**
 * Title: DungeonCharacters.DungeonCharacter.java
 * <p>
 * Description: Abstract Base class for inheritance hierarchy for a
 * role playing game
 * <p>
 * class variables (all will be directly accessible from derived classes):
 * name (name of character)
 * hitPoints (points of damage a character can take before killed)
 * attackSpeed (how fast the character can attack)
 * chanceToHit (chance an attack will strike the opponent)
 * damageMin, damageMax (range of damage the character can inflict on
 * opponent)
 * <p>
 * class methods (all are directly accessible by derived classes):
 * DungeonCharacters.DungeonCharacter(String name, int hitPoints, int attackSpeed,
 * double chanceToHit, int damageMin, int damageMax)
 * public String getName()
 * public int getHitPoints()
 * public int getAttackSpeed()
 * public void addHitPoints(int hitPoints)
 * public void subtractHitPoints(int hitPoints) -- this method will be
 * overridden
 * public boolean isAlive()
 * public void attack(DungeonCharacters.DungeonCharacter opponent) -- this method will be
 * overridden
 * <p>
 * Copyright:    Copyright (c) 2001
 * Company:
 *
 * @author
 * @version 1.0
 */

abstract class DungeonCharacter implements Attack {

    protected String name;
    protected int hitPoints;
    protected int attackSpeed;
    protected double chanceToHit;
    protected int damageMin, damageMax;


    public DungeonCharacter(String name, int hitPoints, int attackSpeed,
                            double chanceToHit, int damageMin, int damageMax) {

        this.name = name;
        this.hitPoints = hitPoints;
        this.attackSpeed = attackSpeed;
        this.chanceToHit = chanceToHit;
        this.damageMin = damageMin;
        this.damageMax = damageMax;

    }


    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }


    public void addHitPoints(int hitPoints) {
        if (hitPoints <= 0)
            System.out.println("Hitpoint amount must be positive.");
        else {
            this.hitPoints += hitPoints;
        }
    }


    public void subtractHitPoints(int hitPoints) {
        if (hitPoints < 0)
            System.out.println("Hitpoint amount must be positive.");
        else if (hitPoints > 0) {
            this.hitPoints -= hitPoints;
            if (this.hitPoints < 0)
                this.hitPoints = 0;
            System.out.println(getName() + " hit " +
                    " for <" + hitPoints + "> points damage.");
            System.out.println(getName() + " now has " +
                    getHitPoints() + " hit points remaining.");
            System.out.println();
        }

        if (this.hitPoints == 0)
            System.out.println(name + " has been killed :-(");


    }

    public boolean isAlive() {
        return (hitPoints > 0);
    }


    public void attack(DungeonCharacter opponent) {
        boolean canAttack;
        int damage;

        System.out.println(name + attackDialogue() + opponent.getName() + ":");

        canAttack = Math.random() <= chanceToHit;

        if (canAttack) {
            damage = (int) (Math.random() * (damageMax - damageMin + 1))
                    + damageMin;
            opponent.subtractHitPoints(damage);


            System.out.println();
        } else {

            System.out.println(getName() + "'s attack on " + opponent.getName() +
                    " failed!");
            System.out.println();
        }

    }

    public abstract String attackDialogue();

    protected abstract void specialMove(DungeonCharacter opponent);


}