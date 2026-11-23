public class Warrior extends GameCharacter implements Attacker{

    private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    @Override
    public int attack(GameCharacter target) {
        if (getHealth() == 0) {
            System.out.println(getName() + " is fallen, therefore they cannot attack!\n");
            return 0;
        }
        int damage = calculatePower() / 4;
        target.takeDamage(damage);
        System.out.println(getName() + " attacked " + target.getName() + " for " + damage + " damage!");
        return damage;
    }
    @Override
    public String getCharacterInfo() {
        return "---Warrior---\n"
                + getName() + " | Level: " + getLevel() + ", Current Health: " + getHealth() + ", Max Health: " + getMaxHealth() + ", Armor: " + armor
                + " | Power Level: " + calculatePower() + "\n";
    }
    @Override
    public int calculatePower() {
        return (getLevel() * 10) + (armor * 2);
    }
    @Override
    public int takeDamage(int damage) {
        int tempHealth = getHealth();
        int newDamage;
        if ((damage - (armor / 2)) <= 0) newDamage = 1;
        else newDamage = damage - (armor / 2);

        if (getHealth() - newDamage < 0) {
            setHealth(0);
            return tempHealth;
        } else {
            setHealth(getHealth() - newDamage);
            return newDamage;
        }
    }

    public int getArmor() {return armor;}
    public void setArmor(int armor) {this.armor = armor;}
}
