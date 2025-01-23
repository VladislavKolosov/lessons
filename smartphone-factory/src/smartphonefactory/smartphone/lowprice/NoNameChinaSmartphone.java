package smartphonefactory.smartphone.lowprice;

import smartphonefactory.smartphone.Smartphone;
import smartphonefactory.pricing.annotations.BudgetSmartphone;

@BudgetSmartphone
public class NoNameChinaSmartphone extends Smartphone {
    public NoNameChinaSmartphone(String phoneName, String model) {
        super(phoneName, model,64,4.1);
    }

    public NoNameChinaSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }
}
