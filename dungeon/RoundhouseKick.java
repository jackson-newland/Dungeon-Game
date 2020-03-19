package dungeon;

public class RoundhouseKick implements SpecialBehavior {

	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		System.out.println(user.getName() + " screams and roundhouse kicks " + opponent.getName());
        opponent.subtractHitPoints(35);
	}

	@Override
	public String specialOption() {
		return "Perform a Roundhouse Kick";
	}

}
