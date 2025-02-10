package smartphonefactory.smartphone.topprice;

import smartphonefactory.builder.SmartphoneBuilder;
import smartphonefactory.pricing.annotations.FlagshipSmartphone;
import smartphonefactory.smartphone.Smartphone;

@FlagshipSmartphone
public class TopUsaSmartphone extends Smartphone {
    public TopUsaSmartphone(String phoneName, String model, int memoryCapacity, double screenSize) {
        super(phoneName, model,memoryCapacity,screenSize);
    }

    public TopUsaSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }


    public static class TopUsaSmartphoneBuilder implements SmartphoneBuilder {
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
            this.memoryCapacity = 1024;
            return this;
        }

        @Override
        public SmartphoneBuilder screenSize() {
            this.screenSize = 6.3;
            return this;
        }

        @Override
        public Smartphone build() {
            return new TopUsaSmartphone(phoneName,model,memoryCapacity,screenSize);
        }
    }
}
