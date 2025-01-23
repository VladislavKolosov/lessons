package smartphonefactory.smartphone.topprice;

import smartphonefactory.pricing.annotations.FlagshipSmartphone;
import smartphonefactory.smartphone.Smartphone;

@FlagshipSmartphone
public class TopUsaSmartphone extends Smartphone {
    public TopUsaSmartphone(String phoneName, String model) {
        super(phoneName, model,1024,6.3);
    }

    public TopUsaSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }
}
