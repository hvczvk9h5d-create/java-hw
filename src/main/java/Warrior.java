public class Warrior extends Hero implements Castable, Restable {
    private final int armor;
    public Warrior(String name, int maxHealth, int baseAttack, int armor) {
        super(name, maxHealth, baseAttack);
        if (armor < MIN_STAT_VALUE) {
            this.armor = MIN_STAT_VALUE;
        } else {
            this.armor = armor;
        }
    }
    public int getArmor() {
        return armor;
    }
    @Override
    public void takeDamage(int damage) {

        int res = damage - armor;
        if (res < 1) {
            res = 1;
        }
        super.takeDamage(res);
    }
    @Override
    public void attack(Hero target) {

        if (target == null) {
            return;
        }
        System.out.println(getName() + " атакует  мечом " + target.getName() + " на " + getBaseAttack() + " урона");
        target.takeDamage(getBaseAttack());
    }
    @Override
    public ActionType makeTurn(Hero target) {

        if (canCast()) {
            castSpecialSkill(target);
            return ActionType.SPECIAL_SKILL;
        }
        if (needsRest()) {

            rest();
            return ActionType.REST;
        }
        attack(target);
        return ActionType.BASE_ATTACK;
    }
    @Override
    public boolean canCast() {

        return getHealth() < getMaxHealth() * 0.5;
    }
    @Override
    public void castSpecialSkill(Hero target) {
        if (target == null) {
            return;
        }
        if (canCast()) {
            int dmg = getBaseAttack() + (armor * 2);
            System.out.println(getName() + "ударяет щитом по " + target.getName() + ", урон: " + dmg);
            target.takeDamage(dmg);
        } else {
            System.out.println("Воин попытался цдарить щитом, но потерял равновесие!");
        }
    }
    @Override
    public boolean needsRest() {
        return getHealth() < getMaxHealth() * 0.15;
    }
    @Override
    public void rest() {
        int h = armor * 2;
        heal(h);
        System.out.println(getName() + "восстановил здоровье на " + h);
    }
}
