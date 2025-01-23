package smartphonefactory.smartphone.topprice;

import smartphonefactory.pricing.annotations.FlagshipSmartphone;
import smartphonefactory.smartphone.Smartphone;

@FlagshipSmartphone
public class TopKoreaSmartphone extends Smartphone {
    public TopKoreaSmartphone(String phoneName, String model) {
        super(phoneName, model,512,6.1);
    }

    public TopKoreaSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }
}
