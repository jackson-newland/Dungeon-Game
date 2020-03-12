package dungeon;

public class HeroFactory {

    public Hero getHero(int value) {

        switch (value) {

            case 1:
                return new Warrior();

            case 2:
                return new Sorceress();

            case 3:
                return new Thief();

            case 4:
                return new Spongebob();

            default:
                System.out.println("invalid choice, returning DungeonCharacters.Thief");
                return new Thief();
        }
    }
}
