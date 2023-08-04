package shop.goods;

public class HardDrive extends ElectronicDevice{


    private int volume;

    public void format(){

    }

    public void copy(){

    }

    public void delete(){

    }

    @Override
    public void on() {
        // специфичное включение жесткого диска
    }

    @Override
    public void off() {
        // специфичное отключение жесткого диска
    }
}
