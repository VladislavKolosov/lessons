package smartphonefactory.smartphone.lowprice;

import smartphonefactory.pricing.annotations.BudgetSmartphone;
import smartphonefactory.smartphone.Smartphone;

@BudgetSmartphone
public class NoNameIndiaSmartphone extends Smartphone {
    public NoNameIndiaSmartphone(String phoneName, String model) {
        super(phoneName, model,32,4.2);
    }

    public NoNameIndiaSmartphone(Smartphone copySmartphone) {
        super(copySmartphone);
    }
}
