import java.math.BigDecimal;

public enum BankType {
    NEO("НеоКредит Банк", new BigDecimal("0.01")),
    AUM("Арум Финтех", new BigDecimal("0.02")),
    VTA("Вектор Альянс Банк", new BigDecimal("0.00"));

    public String name;
    public BigDecimal commission;

    BankType(String name, BigDecimal commission) {
        this.name = name;
        this.commission = commission;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCommission() {
        return commission;
    }
}
