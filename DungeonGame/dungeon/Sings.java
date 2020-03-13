package dungeon;

public class Sings implements SpecialBehavior {

	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		System.out.println(user.getName() + " sings all star.");
        opponent.subtractHitPoints(60);
	}

	@Override
	public String specialOption() {
		return "Sing All Star\n";
	}

}
