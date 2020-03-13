package dungeon;

public class ArmSwing implements SpecialBehavior {

	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		System.out.println(user.getName() + " takes his arm off and swings it at " + opponent.getName());
        opponent.subtractHitPoints(55);
	}

	@Override
	public String specialOption() {
		return "Take Off Arm and Swing It\n";
	}

}
