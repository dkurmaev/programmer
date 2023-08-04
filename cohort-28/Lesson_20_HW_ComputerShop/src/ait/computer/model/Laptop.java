package ait.computer.model;

public class Laptop extends Computer {

    double hours; // Время работы от аккумулятора в часах
    double weight; // Вес ноутбука в килограммах

    public Laptop(long barCode, String brand, String cpu, int ddram, int ssd, double hours, double weight) {
        super(barCode, brand, cpu, ddram, ssd); // Вызов конструктора родительского класса Computer
        this.hours = hours; // Инициализация поля hours
        this.weight = weight; // Инициализация поля weight
    }

    public double getHours() {
        return hours; // Получение значения поля hours
    }

    public double getWeight() {
        return weight; // Получение значения поля weight
    }

    @Override
    public String toString() {
        return "Laptop: " + "Barcode = " + getBarCode() + ", Brand = " + getBrand() + ", Cpu = " + getCpu() +
                ", DDRAM = " + getDdram() + "GB" + ", SSD = " + getSsd() + "GB" + ", Hours = " + hours + "Hours" + ", Weight = " + weight + "Gr."; // Форматированная строка, содержащая информацию о ноутбуке, его характеристики и параметры времени работы и веса
    }


}
