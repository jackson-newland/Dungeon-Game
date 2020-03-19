package dungeon;

public class Infect implements SpecialBehavior{
	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		if(opponent.isOldMan()) {
			System.out.println("Oh No! "+opponent.getName()+ " is infected!");
			opponent.hitPoints = 0;//dead
		}
		else {
			//takes 3/4 of opponent's health
			System.out.println(user.getName()+" infects "+opponent.getName()+".");
			int damage;
			if(opponent.hitPoints > 2)
				damage = (int)(opponent.hitPoints * .75);
			else {
				damage = 1;
			}
			opponent.subtractHitPoints(damage);
		}
	}
	
	@Override
	public String specialOption() {
		return "Perform Infect\n";
	}
}
