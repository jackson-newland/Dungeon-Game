package dungeon;

public class FishingNet implements SpecialBehavior {

	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 100) + 100;
            System.out.println(user.getName() + " tries to catch " + opponent.getName() + " in a net for " + blowPoints + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(user.getName() + " failed to catch " + opponent.getName());
            System.out.println();
        }
		
	}

	@Override
	public String specialOption() {
		return "Use Net On Opponent\n";
	}

}
