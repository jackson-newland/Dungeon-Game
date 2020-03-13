package dungeon;

public class HealSpell implements SpecialBehavior {

	private final int MIN_ADD = 25;
    private final int MAX_ADD = 50;
	
	@Override
	public void specialMove(DungeonCharacter player, DungeonCharacter opponent) {
		int hPoints;

        hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
        player.addHitPoints(hPoints);
        System.out.println(player.getName() + " added [" + hPoints + "] points.\n"
                + "Total hit points remaining are: "
                + player.getHitPoints());
        System.out.println();
	}
	
	@Override
	public String specialOption() {
		return "Increase Hit Points\n";
	}
}