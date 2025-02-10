package smartphonefactory.smartphone.lowprice;

import smartphonefactory.builder.SmartphoneBuilder;
import smartphonefactory.smartphone.Smartphone;
import smartphonefactory.pricing.annotations.BudgetSmartphone;

@BudgetSmartphone
public class NoNameChinaSmartphone extends Smartphone {
    public NoNameChinaSmartphone(String phoneName, String model, int memoryCapacity, double screenSize) {
        super(phoneName, model, memoryCapacity, screenSize);
    }

    public NoNameChinaSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }

    public static class NoNameChinaSmartphoneBuilder implements SmartphoneBuilder {
        private String phoneName;
        private String model;
        private int memoryCapacity;
        private double screenSize;

        @Override
        public SmartphoneBuilder phoneName(String phoneName) {
            this.phoneName = phoneName;
            return this;
        }

        @Override
        public SmartphoneBuilder model(String model) {
            this.model = model;
            return this;
        }

        @Override
        public SmartphoneBuilder memoryCapacity() {
            this.memoryCapacity = 64;
            return this;
        }

        @Override
        public SmartphoneBuilder screenSize() {
            this.screenSize = 4.1;
            return this;
        }

        @Override
        public Smartphone build() {
            return new NoNameChinaSmartphone(phoneName, model, memoryCapacity, screenSize);
        }

    }
}
