package ait.computer.model;

import java.util.Objects;

public class Computer {
    //Поля - обьектов, которые входят в этот класс - Computer
    public static final int barCode_Length = 9;//константа - определяет длину инвентарного номера
    private final long barCode;// уникальный идентификатор
    private String Brand;//название бренда компьютера
    private String cpu;//тип процессора
    private int ddram;//обьем оперативки
    private int ssd;//обьем жесткого диска

    //Конструктор(Метод) - создает обьект класса - Computer
    public Computer(long barCode, String brand, String cpu, int ddram, int ssd) {
        this.barCode = checkId(barCode); //Конструктор с проверкой правильности Id
        this.Brand = brand;
        this.cpu = cpu;
        this.ddram = ddram;
        this.ssd = ssd;
    }

    //Этот конструктор позволяет создать Computer без бренда
    //Это и есть перегрузка(Overload) конструктора
    //Это и есть полиморфизм! метода
    public Computer(long barCode, String cpu, int ddram, int ssd) {
        this.barCode = checkId(barCode);
        this.cpu = cpu;
        this.ddram = ddram;
        this.ssd = ssd;

    }

    public Computer(long barCode, String brand) {
        this.barCode = checkId(barCode); //Конструктор с проверкой правильности Id
        this.Brand = brand;
    }

    public long getBarCode() {
        return barCode;
    }

    public String getBrand() {
        return Brand;
    }

    public String getCpu() {
        return cpu;
    }

    public int getDdram() {
        return ddram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setDdram(int ddram) {
        this.ddram = ddram;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }
    //Метод для валидации Id
    private long checkId(long barCode) {
        if (countDigits(barCode) == barCode_Length) {// Проверка длины Id, вызывает еше один метод countDigits
            return barCode;
        }
        return -1;
    }
    //Метод для подсчета количество цифр в Id
    private int countDigits(long barCode) {
        int count = 0;
        do {
            count++;
            barCode /= 10;//Целочисленное деление. Пример: 536/10=53, 53/10=5, 5/10=0
        }while (barCode != 0);
        return count;
    }

    @Override

    public String toString() {
        return "Computer: " + "Barcode = " + barCode + ", Brand = " + Brand + ", Cpu = " + cpu + ", DDRAM = " + ddram + "GB" + ", SSD = " + ssd + "GB";
    }

    //Метод сравнивает обьекты между собой по полям
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//Если в ходе поиска мы наткнулись на ссылку искомого обьекта то возврашаем true
        if (o == null || getClass() != o.getClass()) return false;//Есть обьект не нашего класса то возврашаем false
        Computer computer = (Computer) o;//Перековываем обьект и даем имя переменной Computer
        boolean result = false;
        if (barCode == computer.barCode){
            result = true;
        }

        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }
}