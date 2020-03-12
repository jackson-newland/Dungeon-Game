package dungeon;

public class Inventory {
	private int healingPotions=0;
	private int visionPotions=0;
	private int pillars=0;
	private Hero player;
	
	public Inventory(final Hero player) {
		this.player = player;
	}
	
	public int getHealingPotions() {return healingPotions;}
	public int getVisionPotions() {return visionPotions;}
	public void addHealingPotion() {healingPotions++;}
	public void addVisionPotion() {visionPotions++;}
	public void removeHealingPotion() {healingPotions--;}
	public void removeVisionPotion() {visionPotions--;}
	
	public void addPillar() {pillars++;}
	
	public void useHealingPotion() {
		int amount = calculateHealingAmount();
		player.addHitPoints(amount);
		healingPotions--;
	}
	
	private int calculateHealingAmount() {
		//set amount from 20 to 50
		int amount =(int)(Math.random()*((15)-5))+5;
		return amount;
	}
	
	public boolean hasAllPillars() {
		if(pillars == 4)return true;
		return false;
	}
}
