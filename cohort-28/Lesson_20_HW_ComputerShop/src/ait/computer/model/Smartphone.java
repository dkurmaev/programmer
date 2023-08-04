package ait.computer.model;

public class Smartphone extends Laptop {

    long imei; // Идентификационный номер IMEI для смартфона

    public Smartphone(long barCode, String brand, String cpu, int ddram, int ssd, double hours, double weight, long imei) {
        super(barCode, brand, cpu, ddram, ssd, hours, weight); // Вызов конструктора родительского класса Laptop
        this.imei = imei; // Инициализация поля imei
    }

    public long getImei() {
        return imei; // Получение значения поля imei
    }

    @Override
    public String toString() {
        return "Smatphone: " + "Barcode = " + getBarCode() + ", Brand = " + getBrand() + ", Cpu = " + getCpu() +
                ", DDRAM = " + getDdram() + "GB" + ", SSD = " + getSsd() + "GB" + ", Hours = " + hours + "Hours" + ", Weight = " + weight + "Gr." + ", Imei = " + imei; // Форматированная строка, содержащая информацию о смартфоне и его IMEI
    }


}
