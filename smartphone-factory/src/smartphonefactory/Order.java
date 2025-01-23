package smartphonefactory;

import smartphonefactory.smartphone.Smartphone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private int orderId;
    private LocalDateTime orderDateTime;
    private OrderStatus orderStatus;
    private Smartphone smartphone;
    private int numberOfDevice;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public Order(Smartphone smartphone, int numberOfDevice) {
        this.orderDateTime = LocalDateTime.now();
        this.smartphone = smartphone;
        this.numberOfDevice = numberOfDevice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public int getNumberOfDevice() {
        return numberOfDevice;
    }

    public void setNumberOfDevice(int numberOfDevice) {
        this.numberOfDevice = numberOfDevice;
    }

    @Override
    public String toString() {
        return "Order " +  "smartphone=" + smartphone;

    }
}
