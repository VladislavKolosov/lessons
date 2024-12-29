package smartphonefactory;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class SmartphoneFactory {
    private final Queue<Order> orders = new LinkedList<>();
    private final int conveyorCount = Runtime.getRuntime().availableProcessors();


    public void addOrder(Order order) {
        if (orders.isEmpty()) {
            orders.add(order);
            produce();
        } else {
            orders.add(order);
        }
    }

    private void produce() {
        Order order = orders.peek();
        for (int i = 0; i < order.getNumberOfDevice(); i++) {
            try {
                order.getSmartphone().clone();
                Thread.sleep(1000);
            }
            catch (CloneNotSupportedException |InterruptedException e ) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Заказ от " + order.getOrderDateTime().format(order.getFormatter()) +
                " в количестве " + order.getNumberOfDevice() + " выполнен " + LocalDateTime.now().format(order.getFormatter()));
    }

    public Queue<Order> getOrders() {
        return orders;
    }
}

