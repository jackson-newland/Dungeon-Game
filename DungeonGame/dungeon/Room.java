package dungeon;
import java.util.*;

public class Room {
	
	private boolean healingPotion=false;
	private boolean pit=false;
	private boolean visionPotion = false;
	private boolean entrance=false;
	private boolean exit=false;
	private boolean inheritance=false;
	private boolean abstraction=false;
	private boolean polymorphism=false;
	private boolean encapsulation=false;
	private boolean monster=false;
	
	
	private boolean ndoor=true;
	private boolean sdoor=true;
	private boolean wdoor=true;
	private boolean edoor=true;
	
	private Random r = new Random();

	
	public Room() {
		setSurprise();
	}
	
	public Room(String option) {
		if(option.equals("entrance")) 
			entrance = true;
		if(option.equals("exit"))
			exit = true;
		if(option.equals("inheritance"))
			inheritance = true;
		if(option.equals("abstraction"))
			abstraction = true;
		if(option.equals("polymorphism"))
			polymorphism = true;
		if(option.equals("encapsulation"))
			encapsulation = true;
	}
	
	public boolean isEntrance() {
		if(entrance)
			return true;
		return false;
	}
	
	public boolean isExit() {
		if(exit)
			return true;
		return false;
		
	}
	
	//will tell you if there is a crown piece in the room
	public boolean hasPillar()
	{
		if(abstraction) {return true;}
		else if(inheritance) {return true;}
		else if(polymorphism) {return true;}
		else if(encapsulation) {return true;}
		else
			return false;
	}
	

	public void setWall(char s){
		if(s=='n')
			ndoor=false;
		if(s=='s')
			sdoor=false;
		if(s=='e')
			edoor=false;
		if(s=='w')
			wdoor=false;
	}
	
	
	private void setSurprise()
	{
		float chance = r.nextFloat();
		//15% chance
		if(chance <= 0.15) {
			setSpecialItem();
		}
	}
	
	private void setSpecialItem() {
		float chance = r.nextFloat();
		//33% chance of either
		if(chance <= 0.33 && chance >= 0) {
			setHealingPotion();
		}
		else if(chance <=0.66 && chance >0.33) {
			setPit();
		}
		else {
			setVisionPotion();
		}
	}
	
	
	private void setVisionPotion() {visionPotion = true;}

	private void setHealingPotion() {healingPotion = true;}
	
	private void setPit() {pit = true;}
	
	public void setWalls(int n, int s, int e, int w) {
		if(n==0)ndoor=false;
		if(s==0)sdoor=false;
		if(e==0)edoor=false;
		if(w==0)wdoor=false;
	}
	
	

	public boolean hasSouthWall() {
		if(sdoor == true)return false;
		return true;
	}
	public boolean hasNorthWall() {
		if(ndoor == true)return false;
		return true;
	}
	public boolean hasWestWall() {
		if(wdoor == true)return false;
		return true;
	}
	public boolean hasEastWall() {
		if(edoor == true)return false;
		return true;
	}

	public boolean hasHealthPotion() {
		if(healingPotion)return true;
		return false;
	}

	public String pillarName() {
		if(abstraction) return "Abstraction";
		if(inheritance) return "Inheritance";
		if(encapsulation) return "Encapsulation";
		if(polymorphism) return "Polymorphism";
		return null;
	}

	public void removePillar(String name) {
		if(name.equals("abstraction")) abstraction = false;
		if(name.equals("encapsulation")) encapsulation = false;
		if(name.equals("inheritance"))inheritance = false;
		if(name.equals("polymorphism")) polymorphism = false;
	}

	public void removeHealingPotion() {healingPotion = false;}

	public boolean hasPit() {
		if(pit)return true;
		return false;
	}

	public boolean hasVisionPotion() {
		if(visionPotion)return true;
		return false;
	}

	public void removeVisionPotion() {visionPotion = false;}

	public void monsterRoom(Hero theHero) {
		HashChainAttack attackIndex = new HashChainAttack(3);
		HashChainSpecial specialIndex = new HashChainSpecial(3);
		MonsterFactory theMonster = new MonsterFactory(attackIndex, specialIndex);
		Battle arena = new Battle();
		
		arena.getBattle(theHero, theMonster.getMonster(generateMonster()));
		
		
	}
	
	public static int generateMonster() {
        int choice;

        choice = (int) (Math.random() * 5) + 1;
        return choice;
    }
	public void removeMonster() {
		monster = false;
	}
	
	public String printRoom() {
		if(entrance)return "I";
		if(exit)return"O";
		if(pit)return"P";
		if(healingPotion)return"H";
		if(visionPotion)return"V";
		if(inheritance||polymorphism||abstraction||encapsulation)return"C";
		else {
			return "E";
		}
		
	}
	
	public String toString() {
		String result="";
		if(ndoor)
			result+="\n*-*";
		else
			result+="\n***";
		if(wdoor)
			result+="\n|";
		else
			result+="\n*";
		if(entrance)result+="I";
		else if(exit)result+="O";
		else if(pit)result+="P";
		else if(healingPotion)result+="H";
		else if(visionPotion)result+="V";
		//tester to see where crown pieces are located
		else if(inheritance)result+="C";
		else if(polymorphism)result+="C";
		else if(abstraction)result+="C";
		else if(encapsulation)result+="C";
		
		else {//if just an empty room
			result+="E";
		}
		if(edoor)
			result+="|\n";
		else
			result+="*\n";
		if(sdoor)
			result+="*-*";
		else
			result+="***";
		return result;
		
	}
	
	
	
	
}
