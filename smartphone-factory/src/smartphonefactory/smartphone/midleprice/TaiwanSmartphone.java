package smartphonefactory.smartphone.midleprice;

import smartphonefactory.pricing.annotations.MidTierSmartphone;
import smartphonefactory.smartphone.Smartphone;

@MidTierSmartphone
public class TaiwanSmartphone extends Smartphone {
    public TaiwanSmartphone(String phoneName, String model) {
        super(phoneName, model,256,5.5);
    }

    public TaiwanSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }
}
