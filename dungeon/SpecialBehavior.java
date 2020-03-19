package dungeon;

public interface SpecialBehavior {
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent);
	public String specialOption();
}
