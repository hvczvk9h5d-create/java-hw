public abstract class Hero {
    public static final int MIN_STAT_VALUE = 1;
    private final String name;
    private final int maxHealth;
    private final int baseAttack;
    private int health;
    public Hero(String name, int maxHealth, int baseAttack) {
        if (name == null || name.length() == 0) {
            this.name = "Безымянный";
        } else {
            this.name = name;
        }
        if (maxHealth <= MIN_STAT_VALUE) {
            this.maxHealth = MIN_STAT_VALUE;
        } else {
            this.maxHealth = maxHealth;
        }

        if (baseAttack <= MIN_STAT_VALUE) {
            this.baseAttack = MIN_STAT_VALUE;
        } else {
            this.baseAttack = baseAttack;
        }

        this.health = maxHealth;
    }

    public String getName() {
        return this.name;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getBaseAttack() {
        return this.baseAttack;
    }
    public int getHealth() {
        return health;
    }

    public abstract void attack(Hero target);
    public abstract ActionType makeTurn(Hero target);

    public void takeDamage(int damage) {
        if (damage < 0) return;

        this.health = this.health - damage;

        if (this.health < 0) {
            this.health = 0;
        }

        if (this.health == 0) {
            System.out.println(this.name + " пал в бою!");
        }
    }
    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        if (this.health >= this.maxHealth) {
            return;
        }

        this.health = this.health + amount;

        if (this.health >= this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
    public boolean isAlive() {
        boolean alive = false;
        if (this.health >= 1) {
            alive = true;
        }
        return alive;
    }
}
