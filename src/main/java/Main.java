import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Account account = new Account(12345, 999, new BigDecimal("10000.00"), BankType.AUM);

        System.out.println("Добро пожаловать в банкомат!");

        System.out.println("Введите номер карты:");
        if (!sc.hasNextInt()) {
            System.out.println("Ошибка доступа");
            return;
        }
        int card = sc.nextInt();

        System.out.println("Введите пин-код:");
        if (!sc.hasNextInt()) {
            System.out.println("Ошибка доступа");
            return;
        }
        int pin = sc.nextInt();

        if (card != account.getCard() || pin != account.getPin()) {
            System.out.println("Ошибка доступа");
            return;
        }

        System.out.println(account);
        CashMachine machine = new CashMachine();

        System.out.println("Введите сумму для внесения:");
        if (!sc.hasNextBigDecimal()) {
            System.out.println("Неверная сумма");
            return;
        }
        BigDecimal sum1 = sc.nextBigDecimal();
        account.balance = machine.deposit(account.getBalance(), sum1);
        System.out.println("Баланс после внесения: " + account.getBalance() + " руб.");

        System.out.println("Введите сумму для снятия:");
        if (!sc.hasNextBigDecimal()) {
            System.out.println("Неверная сумма");
            return;
        }
        BigDecimal sum2 = sc.nextBigDecimal();
        account.balance = machine.withdraw(account.getBalance(), sum2, account.getBank());
        System.out.println("Баланс после снятия: " + account.getBalance() + " руб.");
    }
}
