package smartphonefactory.smartphone.lowprice;

import smartphonefactory.builder.SmartphoneBuilder;
import smartphonefactory.pricing.annotations.BudgetSmartphone;
import smartphonefactory.smartphone.Smartphone;

@BudgetSmartphone
public class NoNameIndiaSmartphone extends Smartphone {
    public NoNameIndiaSmartphone(String phoneName, String model, int memoryCapacity, double screenSize) {
        super(phoneName, model,memoryCapacity,screenSize);
    }

    public NoNameIndiaSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }

    public static class NoNameIndiaSmartphoneBuilder implements SmartphoneBuilder {
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
            this.memoryCapacity = 32;
            return this;
        }

        @Override
        public SmartphoneBuilder screenSize() {
            this.screenSize = 4.2;
            return this;
        }

        @Override
        public Smartphone build() {
            return new NoNameIndiaSmartphone(phoneName,model,memoryCapacity,screenSize);
        }
    }
}
