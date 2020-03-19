package dungeon;

public class StealToiletPaper implements SpecialBehavior{
	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		System.out.println(user.getName()+" steals toilet paper from "+opponent.getName()+".");
		opponent.subtractHitPoints(60);
	}
	
	@Override
	public String specialOption() {
		return "Perform Steal Toilet Paper";
	}
}
