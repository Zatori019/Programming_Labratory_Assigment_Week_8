public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;
        if (level < 1 || level > 100) {
            System.out.println("WARNING: Level must be between 1 and 100, setting it to 1!");
            this.level = 1;
        } else this.level = level;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
    }

    public abstract String getCharacterInfo();
    public abstract int calculatePower();

    public boolean isAlive() {
        return health > 0;
    }
    public int takeDamage(int damage) {
        int tempHealth = health;
        if (health - damage < 0) {
            health = 0;
            return tempHealth;
        } else {
            health -= damage;
            return damage;
        }
    }
    public int restoreHealth(int amount) {
        if (health + amount > maxHealth) {
            health = maxHealth;
            return maxHealth - health;
        } else {
            health += amount;
            return amount;
        }
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}
    public int getMaxHealth() {return maxHealth;}
    public void setMaxHealth(int maxHealth) {this.maxHealth = maxHealth;}
}
