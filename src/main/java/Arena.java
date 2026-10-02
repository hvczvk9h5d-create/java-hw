public class Arena {
    private Hero hero1;
    private Hero hero2;
    private int round;

    public Arena(Hero hero1, Hero hero2) {
        if (hero1 == null) {
            System.out.println("первый герой пустой");
        } else {
            this.hero1 = hero1;
        }
        if (hero2 == null) {
            System.out.println("второй герой пустой");
        } else {
            this.hero2 = hero2;
        }
        this.round = 1;
    }
    public void startTournament() {
        if (this.hero1 == null || this.hero2 == null) {
            System.out.println("бой не может начаться героев нет");
            return;
        }
        while (true) {
            boolean h1Live = this.hero1.isAlive();
            boolean h2Live = this.hero2.isAlive();
            if (h1Live == false || h2Live == false) {
                break;
            }
            System.out.println("--- раунд " + this.round + " ---");

            ActionType act1 = this.hero1.makeTurn(this.hero2);
            System.out.println(this.hero1.getName() + " действие: " + act1.getDescription());

            if (this.hero2.isAlive() == false) {
                break;
            }

            ActionType act2 = this.hero2.makeTurn(this.hero1);
            System.out.println(this.hero2.getName() + " действие: " + act2.getDescription());

            if (this.hero1.isAlive() == false) {
                break;
            }

            this.round = this.round + 1;
        }
        System.out.println("бой окончен");
        if (this.hero1.isAlive() == true && this.hero2.isAlive() == false) {
            System.out.println("победил " + this.hero1.getName());
        } else if (this.hero2.isAlive() == true && this.hero1.isAlive() == false) {
            System.out.println("победил " + this.hero2.getName());
        } else {
            System.out.println("ничья");
        }
    }
}
