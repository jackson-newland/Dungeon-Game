package dungeon;


/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 *
 * @author
 * @version 1.0
 */


abstract class Monster extends DungeonCharacter {
    protected double chanceToHeal;
    protected int minHeal, maxHeal;


    public Monster(String name, int hitPoints, int attackSpeed,
                   double chanceToHit, double chanceToHeal,
                   int damageMin, int damageMax,
                   int minHeal, int maxHeal) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToHeal = chanceToHeal;
        this.maxHeal = maxHeal;
        this.minHeal = minHeal;

    }

    private void heal() {
        boolean canHeal;
        int healPoints;

        canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

        if (canHeal) {
            healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
            addHitPoints(healPoints);
            System.out.println("\n"+name + " healed itself for <" + healPoints + "> points.");
            System.out.println(name + " now has "+hitPoints+" hit points remaining.");
        }

    }

    public void subtractHitPoints(int hitPoints) {
        super.subtractHitPoints(hitPoints);
        heal();
    }

    public void attack(DungeonCharacter Opponent) {
        double specialChance = Math.random();
        if (specialChance <= .3) {
            special.specialMove(this, Opponent);
        } else {
            super.attack(Opponent);
        }
    }

	public void specialMove(DungeonCharacter Opponent) {
		special.specialMove(this, Opponent);
		
	}

}