import java.util.ArrayList;

public class Team {
    private ArrayList<GameCharacter> team = new ArrayList<>();

    public void addCharacter(GameCharacter character) {
        boolean found = false;
        for (GameCharacter character1 : team) {
            if (character1.getName().equals(character.getName())) {
                found = true;
                break;
            }
            else found = false;
        }
        if (!found) {
            team.add(character);
            System.out.println("Added " + character.getName() + " to the team!\n");
        }
        else System.out.println("There is already a character with that name in the team!\n");
    }
    public void removeCharacter(GameCharacter character) {
        boolean found = false;
        for (GameCharacter character1 : team) {
            if (character1.getName().equals(character.getName())) {
                found = true;
                break;
            }
            else found = false;
        }
        if (found) {
            team.remove(character);
            System.out.println("Removed " + character.getName() + " from the team!\n");
        }
        else System.out.println("There is no character with that name in the team!\n");
    }
    public int getTotalPower() {
        int totalPower = 0;
        for (GameCharacter character : team) {
            if (character.getHealth() != 0) totalPower += character.calculatePower();
        }
        return totalPower;
    }
    public void displayTeam() {
        System.out.println("===== TEAM INFO =====\n");
        for (GameCharacter character : team) {
            System.out.println(character.getCharacterInfo());
        }
    }
    public void healTeam() {
        GameCharacter target = team.get(0);
        for (GameCharacter character : team) {
            if (character.getHealth() != 0) {
                target = character;
            }
        }
        for (GameCharacter character : team) {
            if (character.getHealth() != 0) {
                if ((character.getHealth() / character.getMaxHealth()) < (target.getHealth() / target.getMaxHealth())) target = character;
            }
        }
        for (GameCharacter character : team) {
            if (character.getHealth() != 0 && character instanceof Supporter) ((Supporter) character).heal(target);
        }
    }
}
