package smartphonefactory.builder;

import smartphonefactory.smartphone.Smartphone;

public interface SmartphoneBuilder {
    SmartphoneBuilder phoneName(String phoneName);
    SmartphoneBuilder model(String model);
    SmartphoneBuilder memoryCapacity();
    SmartphoneBuilder screenSize();
    Smartphone build();
}
