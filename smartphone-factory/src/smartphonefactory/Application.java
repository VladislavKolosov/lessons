package smartphonefactory;

import smartphonefactory.smartphone.Smartphone;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean isExit = true;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application();
        SmartphoneFactory smartphoneFactory = new SmartphoneFactory();

        while (isExit) {
            System.out.println("1. Сделать заказ");
            System.out.println("0. Выход");

            switch (scanner.nextInt()) {
                case 1:
                    Order order = application.createOrder(scanner);
                    smartphoneFactory.addOrder(order);
                    break;

                case 0:
                    isExit = false;
                    break;
            }
        }
    }

    private Order createOrder(Scanner scanner) {
        FileSearching fileSearching = new FileSearching();

        System.out.println("Количество телефонов ");
        int numberOfTelephone = scanner.nextInt();

        List<Class<?>> classList = fileSearching.selectOfPriceCategory(scanner);
        for (int i = 1; i <= classList.size(); i++) {
            System.out.println(i + ". " + classList.get(i - 1).getSimpleName());
        }

        int smartphoneChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Введите название телефона");
        String phoneName = scanner.nextLine();

        System.out.println("Введите модель телефона");
        String phoneModel = scanner.nextLine();

        try {
            Constructor<?> constructor = classList.get(smartphoneChoice).getConstructor(String.class,String.class);
            Smartphone smartphone = (Smartphone) constructor.newInstance(phoneName,phoneModel);

            return new Order(smartphone,numberOfTelephone);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
