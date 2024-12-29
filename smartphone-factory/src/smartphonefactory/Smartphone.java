package smartphonefactory;

public class Smartphone implements Cloneable {
    private int smartphoneId;
    private String phoneName;
    private String model;
    private int memoryCapacity;
    private double screenSize;

    public Smartphone(String phoneName, String model, int memoryCapacity, double screenSize) {
        this.phoneName = phoneName;
        this.model = model;
        this.memoryCapacity = memoryCapacity;
        this.screenSize = screenSize;
    }

    @Override
    protected Smartphone clone() throws CloneNotSupportedException {
        return (Smartphone) super.clone();
    }

    public int getSmartphoneId() {
        return smartphoneId;
    }

    public void setSmartphoneId(int smartphoneId) {
        this.smartphoneId = smartphoneId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}

