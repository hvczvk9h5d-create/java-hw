import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("создание первого бойца");
        Hero hero1 = createHero(sc);
        if (hero1 == null) {
            return;
        }
        System.out.println("создание второго бойца");
        Hero hero2 = createHero(sc);
        if (hero2 == null) {
            return;
        }
        Arena arena = new Arena(hero1, hero2);
        arena.startTournament();
    }
    public static Hero createHero(Scanner sc) {
        System.out.println("Выберите тип: 1 - Воин, 2 - Маг");
        if (!sc.hasNextInt()) {
            System.out.println("Нужно ввести число");
            return null;
        }
        int type = sc.nextInt();
        if (type != 1 && type != 2) {
            System.out.println("Нет такого типа");
            return null;
        }
        System.out.println("Введите имя:");
        String name = sc.next();

        System.out.println("Введите максимальное здоровье:");
        if (!sc.hasNextInt()) {
            System.out.println("Нужно ввести число");
            return null;
        }
        int maxHealth = sc.nextInt();

        System.out.println("Введите базовую атаку:");
        if (!sc.hasNextInt()) {
            System.out.println("нужно ввести число");
            return null;
        }
        int baseAttack = sc.nextInt();

        if (type == 1) {
            System.out.println("Введите броню:");
            if (!sc.hasNextInt()) {
                System.out.println("нужно ввести число");
                return null;
            }
            int armor = sc.nextInt();
            return new Warrior(name, maxHealth, baseAttack, armor);
        } else {
            System.out.println("Введите максимальную ману:");
            if (!sc.hasNextInt()) {
                System.out.println("нужно ввести число");
                return null;
            }
            int maxMana = sc.nextInt();
            return new Mage(name, maxHealth, baseAttack, maxMana);
        }
    }
}
