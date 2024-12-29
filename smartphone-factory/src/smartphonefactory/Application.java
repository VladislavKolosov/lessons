package smartphonefactory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean isExit = true;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application();
        SmartphoneFactory smartphoneFactory = new SmartphoneFactory();


        while(isExit){
            System.out.println("1. Сделать заказ");
            System.out.println("0. Выход");

            switch (scanner.nextInt()){
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
    private Order createOrder(Scanner scanner){
        scanner.nextLine();
        System.out.println("Название телефона");
        String phoneName = scanner.nextLine();

        System.out.println("Модель телефона");
        String phoneModel = scanner.nextLine();

        System.out.println("Объем памяти телефона");
        int phoneMemoryCapacity = scanner.nextInt();

        System.out.println("Размер экрана телефона");
        double phoneScreenSize = scanner.nextDouble();

        System.out.println("Количество телефонов в заказе");
        int numberOfDevice = scanner.nextInt();

        return new Order(new Smartphone(phoneName,phoneModel,phoneMemoryCapacity,phoneScreenSize), numberOfDevice);
    }
}
