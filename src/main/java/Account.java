import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    public int card;
    public int pin;
    public BigDecimal balance;
    public BankType bank;

    public Account(int card, int pin, BigDecimal balance, BankType bank) {
        if (card >= 10000 && card <= 99999) {
            this.card = card;
        } else {
            this.card = 0;
        }

        if (pin >= 100 && pin <= 999) {
            this.pin = pin;
        } else {
            this.pin = 0;
        }

        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            this.balance = new BigDecimal("0.00");
        } else {
            this.balance = balance.setScale(2, RoundingMode.HALF_UP);
        }

        if (bank == null) {
            this.bank = BankType.NEO;
        } else {
            this.bank = bank;
        }
    }

    public int getCard() {
        return card;
    }

    public int getPin() {
        return pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BankType getBank() {
        return bank;
    }

    public String toString() {
        return bank.getName() + " Карта: " + card + ", Баланс: " + balance + " руб.";
    }
}
