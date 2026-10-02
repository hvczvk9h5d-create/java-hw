public class Mage extends Hero implements Castable, Restable {
    private final int maxMana;
    private int mana;
    public Mage(String name, int maxHealth, int baseAttack, int maxMana) {
        super(name, maxHealth, baseAttack);
        if (maxMana < MIN_STAT_VALUE) {
            this.maxMana = MIN_STAT_VALUE;
        } else {
            this.maxMana = maxMana;
        }
        this.mana = this.maxMana;
    }
    public int getMaxMana() {
        return this.maxMana;
    }

    public int getMana() {
        return mana;
    }
    @Override
    public void attack(Hero target) {
        if (target == null) return;
        if (mana >= 10) {
            mana = mana - 10;
            int d = getBaseAttack() + getBaseAttack();
            System.out.println(getName() + " маг выстрел по " + target.getName() + " нанес " + d);
            target.takeDamage(d);
        } else {
            int d = (int)(getBaseAttack() / 2.0);
            mana = mana + 5;
            if (mana > maxMana) mana = maxMana;
            System.out.println(getName() + " бьет посохом " + target.getName() + " нанес " + d + " и восстановил 5 маны");
            target.takeDamage(d);
        }
    }
    @Override
    public ActionType makeTurn(Hero target) {
        boolean can = canCast();
        if (can == true) {
            castSpecialSkill(target);
            return ActionType.SPECIAL_SKILL;
        } else {
            boolean need = needsRest();
            if (need == true) {
                rest();
                return ActionType.REST;
            } else {
                attack(target);
                return ActionType.BASE_ATTACK;
            }
        }
    }
    @Override
    public boolean canCast() {
        if (mana >= 25) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void castSpecialSkill(Hero target) {
        if (target == null) {
            return;
        }
        if (canCast() != false) {
            mana = mana - 25;
            int dmg = getBaseAttack() + (getBaseAttack() * 2);
            System.out.println(getName() + " кинул огненную глыбу в " + target.getName() + " на " + dmg);
            target.takeDamage(dmg);
        } else {
            System.out.println("заклинание сорвалось, не хватило маны");
        }
    }
    @Override
    public boolean needsRest() {
        int threshold = (int)(getMaxHealth() * 30 / 100);
        if (mana <= 0 || getHealth() < threshold) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void rest() {
        mana = maxMana;
        int hp = getBaseAttack();
        this.heal(hp);
        System.out.println(getName() + " сел медитировать, мана полная, и похилил " + hp);
    }
}

