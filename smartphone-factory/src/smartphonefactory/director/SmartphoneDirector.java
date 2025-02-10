package smartphonefactory.director;

import smartphonefactory.builder.SmartphoneBuilder;
import smartphonefactory.smartphone.Smartphone;

public class SmartphoneDirector {
    private SmartphoneBuilder smartphoneBuilder;

    public SmartphoneDirector(SmartphoneBuilder smartphoneBuilder) {
        this.smartphoneBuilder = smartphoneBuilder;
    }
    public Smartphone constructSmartphone(String phoneName, String model) {
        return smartphoneBuilder
                .phoneName(phoneName)
                .model(model)
                .memoryCapacity()
                .screenSize()
                .build();
    }
}
