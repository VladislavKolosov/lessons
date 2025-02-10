package smartphonefactory.smartphone.midleprice;

import smartphonefactory.builder.SmartphoneBuilder;
import smartphonefactory.pricing.annotations.MidTierSmartphone;
import smartphonefactory.smartphone.Smartphone;

@MidTierSmartphone
public class TaiwanSmartphone extends Smartphone {
    public TaiwanSmartphone(String phoneName, String model, int memoryCapacity, double screenSize) {
        super(phoneName, model,memoryCapacity,screenSize);
    }

    public TaiwanSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }

    public static class TaiwanSmartphoneBuilder implements SmartphoneBuilder {
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
            this.memoryCapacity = 256;
            return this;
        }

        @Override
        public SmartphoneBuilder screenSize() {
            this.screenSize = 5.5;
            return this;
        }

        @Override
        public Smartphone build() {
            return new TaiwanSmartphone(phoneName,model,memoryCapacity,screenSize);
        }
    }
}
