public enum ActionType {
    BASE_ATTACK("базовая атака"),
    SPECIAL_SKILL("применение особого умения"),
    REST("пропуск хода для восстановления");
    private final String description;

    ActionType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
