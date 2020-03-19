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

abstract class DungeonCharacter{

    protected String name;
    protected int hitPoints;
    protected int attackSpeed;
    protected double chanceToHit;
    protected int damageMin, damageMax;
    protected AttackBehavior basicAttack;
    protected SpecialBehavior special;


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


    public void subtractHitPoints(int damage) {
        if (damage < 0)
            System.out.println("Hitpoint amount must be positive.");
        else if (damage > 0) {
            this.hitPoints -= damage;
            if (this.hitPoints < 0)
                this.hitPoints = 0;
            System.out.println(getName() + " hit" +
                    " for <" + damage + "> points damage.");
            System.out.println(getName() + " now has " +
                    getHitPoints() + " hit points remaining.");
        }

    }

    public boolean isAlive() {
        return (hitPoints > 0);
    }


    public void attack(DungeonCharacter opponent) {
        boolean canAttack;
        int damage;

        System.out.println(name + basicAttack.attackDialogue() + opponent.getName() + ":");

        canAttack = Math.random() <= chanceToHit;

        if (canAttack) {
            damage = (int) (Math.random() * (damageMax - damageMin + 1))
                    + damageMin;
            opponent.subtractHitPoints(damage);

        } else {

            System.out.println(getName() + "'s attack on " + opponent.getName() +
                    " failed!");
        }

    }
    
    protected void setAttacks(AttackBehavior ab, SpecialBehavior sb) {
    	this.basicAttack = ab;
    	this.special = sb;
    }
    
    public boolean isOldMan() {
		if(chanceToHit == 1.0) {
			return true;
		}
		return false;
	}

}