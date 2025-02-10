package smartphonefactory;

import smartphonefactory.smartphone.Smartphone;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class SmartphoneFactory extends Observable {
    private final LinkedBlockingQueue<Order> orders = new LinkedBlockingQueue<>();
    private final int conveyorCount = Runtime.getRuntime().availableProcessors();
    private final ExecutorService produce = Executors.newFixedThreadPool(conveyorCount);
    private final ExecutorService processOrder = Executors.newSingleThreadExecutor();

    public void addOrder(Order order) {
        orders.add(order);

        processOrder();
    }

    private void processOrder() {
        processOrder.submit(() -> {
            Order order = orders.poll();
            produce(order);
        });
    }

    private void produce(Order order) {
        int numberOfTelephone = order.getNumberOfDevice() / conveyorCount;
        System.out.println("Выполнение заказа: " + order);

        CountDownLatch latch = new CountDownLatch(conveyorCount);
        for (int i = 0; i < conveyorCount; i++) {
            produce.submit(() -> {
                for (int j = 0; j < numberOfTelephone; j++) {

                    Class<?> clazz = order.getSmartphone().getClass();
                    try {
                        Constructor<?> constructor = clazz.getConstructor(Smartphone.class);
                        constructor.newInstance(order.getSmartphone());

                    } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String message = "Заказ от " + order.getOrderDateTime().format(order.getFormatter()) +
                " в количестве " + order.getNumberOfDevice() + " выполнен " +
                LocalDateTime.now().format(order.getFormatter());

        setChanged();
        notifyObservers(message);
    }
}