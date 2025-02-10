package smartphonefactory.file;

import smartphonefactory.pricing.annotations.BudgetSmartphone;
import smartphonefactory.pricing.annotations.FlagshipSmartphone;
import smartphonefactory.pricing.annotations.MidTierSmartphone;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSearching {
    private final static File DIRECTORYPATH = new File("src/smartphonefactory/smartphone");

    public List<Class<?>> selectOfPriceCategory(Scanner scanner) {
        List<Class<?>> classList = new ArrayList<>();
        System.out.println("Выберите ценовую категорию");
        System.out.println("1. Бюджетные");
        System.out.println("2. Средние");
        System.out.println("3. Дорогие");

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return processFilesFromFolder(DIRECTORYPATH, classList, BudgetSmartphone.class);
                case 2:
                    return processFilesFromFolder(DIRECTORYPATH, classList, MidTierSmartphone.class);
                case 3:
                    return processFilesFromFolder(DIRECTORYPATH, classList, FlagshipSmartphone.class);
                default:
                    System.out.println("неверный выбор");
            }
        }
    }

    private List<Class<?>> processFilesFromFolder(File folder, List<Class<?>> classList, Class<? extends Annotation> annotation) {
        File[] folderEntries = folder.listFiles();
        if (folderEntries == null) {
            return classList;
        }
        for (File file : folderEntries) {
            if (file.isFile()) {
                String fileName = getClassName(file);
                compareAnnotation(fileName, classList, annotation);
            } else {
                processFilesFromFolder(file, classList, annotation);
            }
        }
        return classList;
    }

    private void compareAnnotation(String fullClassName, List<Class<?>> classList, Class<? extends Annotation> annotation) {
        try {
            Class<?> clazz = Class.forName(fullClassName);
            if (clazz.isAnnotationPresent(annotation)) {
                classList.add(clazz);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String getClassName(File file) {
        return file.getPath()
                .replace("src\\", "")
                .replace(".java", "")
                .replace("\\", ".");
    }
}
