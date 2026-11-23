public class Mage extends GameCharacter implements Attacker, Supporter{

    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    @Override
    public String getCharacterInfo() {
        return "---Mage---\n"
                + getName() + " | Level: " + getLevel() + ", Current Health: " + getHealth() + ", Max Health: " + getMaxHealth() + ", Current Mana: " + mana
                + " | Power Level: " + calculatePower() + "\n";
    }
    @Override
    public int calculatePower() {
        return (getLevel() * 8) + mana;
    }
    @Override
    public int attack(GameCharacter target) {
        if (getHealth() == 0) {
            System.out.println(getName() + " is fallen, therefore they cannot attack!\n");
            return 0;
        }
        int damage = calculatePower() / 3;
        if (mana - 20 < 0) {
            System.out.println("There is not enough mana to Attack!\n");
            return 0;
        }
        mana -= 20;
        target.takeDamage(damage);
        System.out.println(getName() + " attacked " + target.getName() + " for " + damage + " damage!");
        return damage;
    }
    @Override
    public int heal(GameCharacter target) {
        if (getHealth() == 0) {
            System.out.println(getName() + " is fallen, therefore they cannot heal!\n");
            return 0;
        }
        int healAmount = getLevel() * 2;
        if (mana - 15 < 0) {
            System.out.println("There is not enough mana to Heal!\n");
            return 0;
        }
        mana -= 15;
        target.restoreHealth(healAmount);
        System.out.println(getName() + " healed " + target.getName() + " for " + healAmount + " health!");
        return healAmount;
    }
}
