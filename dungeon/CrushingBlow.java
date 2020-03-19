package dungeon;

public class CrushingBlow implements SpecialBehavior {

	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(user.getName() + " lands a CRUSHING BLOW for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(user.getName() + " failed to land a crushing blow");
            System.out.println();
        }
	}

	@Override
	public String specialOption() {
		return "Crushing Blow on Opponent";
	}

}
