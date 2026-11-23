public class Healer extends GameCharacter implements Supporter{

    private int healAmount;


    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        this.healAmount = healAmount;
    }

    @Override
    public String getCharacterInfo() {
        return "---Healer---\n"
                + getName() + " | Level: " + getLevel() + ", Current Health: " + getHealth() + ", Max Health: " + getMaxHealth() + ", Healing Power: " + healAmount
                + " | Power Level: " + calculatePower() + "\n";
    }
    @Override
    public int calculatePower() {
        return (getLevel() * 5) + healAmount;
    }

    @Override
    public int heal(GameCharacter target) {
        if (getHealth() == 0) {
            System.out.println(getName() + " is fallen, therefore they cannot heal!\n");
            return 0;
        }
        int restoredHealth = getLevel() + healAmount;
        target.restoreHealth(restoredHealth);
        System.out.println(getName() + " healed " + target.getName() + " for " + restoredHealth + " health!");
        return restoredHealth;
    }
}
