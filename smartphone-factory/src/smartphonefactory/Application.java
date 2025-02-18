package smartphonefactory;

import org.w3c.dom.ls.LSOutput;
import smartphonefactory.builder.SmartphoneBuilder;
import smartphonefactory.director.SmartphoneDirector;
import smartphonefactory.file.FileSearching;
import smartphonefactory.file.OrderHistoryWriter;
import smartphonefactory.smartphone.Smartphone;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Application implements Observer{
    public static void main(String[] args) {
        boolean isExit = true;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application();
        SmartphoneFactory smartphoneFactory = new SmartphoneFactory();

        smartphoneFactory.addObserver(application);

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
            Class<?> clazz =  classList.get(smartphoneChoice);
            String builderClassName = clazz.getName() + "$" + clazz.getSimpleName() + "Builder";
            Constructor<?> constructor = Class.forName(builderClassName).getConstructor();

            SmartphoneDirector smartphoneDirector = new SmartphoneDirector((SmartphoneBuilder) constructor.newInstance());
            Smartphone smartphone = smartphoneDirector.constructSmartphone(phoneName,phoneModel);
            return new Order(smartphone, numberOfTelephone);

        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

        try {
            OrderHistoryWriter.writingResult((String) arg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
