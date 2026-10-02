import java.math.BigDecimal;
import java.math.RoundingMode;

public interface WithdrawalOperations {
    BigDecimal withdraw(BigDecimal balance, BigDecimal sum, BankType bank);

    default BigDecimal applyCommission(BigDecimal sum, BankType bank) {
        if (sum == null || bank == null) {
            return new BigDecimal("0.00");
        }
        BigDecimal commission = sum.multiply(bank.getCommission());
        commission = commission.setScale(2, RoundingMode.HALF_UP);
        return commission;
    }
}
