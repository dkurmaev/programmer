package shop.goods;

public class Computer extends ElectronicDevice{

    public Computer(String name) {
        super(name);
    }

    public Computer(String name, int ram) {
        super(name);
        this.ram = ram;
    }

    public Computer(double price, boolean hasGuarantee, String name, String company, int ram) {
        super(price, hasGuarantee, name, company);
        this.ram = ram;
    }

    private int ram;


    public void loadOS(){

    }
}
