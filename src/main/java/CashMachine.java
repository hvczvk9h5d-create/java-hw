import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashMachine implements WithdrawalOperations, DepositOperations {

    public BigDecimal deposit(BigDecimal balance, BigDecimal sum) {
        if (sum == null || sum.compareTo(BigDecimal.ZERO) <= 0) {
            return balance;
        }
        BigDecimal newBalance = balance.add(sum);
        newBalance = newBalance.setScale(2, RoundingMode.HALF_UP);
        return newBalance;
    }

    public BigDecimal withdraw(BigDecimal balance, BigDecimal sum, BankType bank) {
        if (sum == null || sum.compareTo(BigDecimal.ZERO) <= 0) {
            return balance;
        }
        BigDecimal commission = applyCommission(sum, bank);
        BigDecimal total = sum.add(commission);
        if (total.compareTo(balance) > 0) {
            System.out.println("Недостаточно средств");
            return balance;
        }
        BigDecimal newBalance = balance.subtract(total);
        newBalance = newBalance.setScale(2, RoundingMode.HALF_UP);
        return newBalance;
    }
}
