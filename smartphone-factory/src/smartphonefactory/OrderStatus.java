package smartphonefactory;

public enum OrderStatus {
    CREATE("Order create"), PROCESS("Order in process"), COMPLETE("Order complete");

    private final String description;
    OrderStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
