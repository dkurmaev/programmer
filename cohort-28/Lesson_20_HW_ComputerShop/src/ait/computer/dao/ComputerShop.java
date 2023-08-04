package ait.computer.dao;

import ait.computer.model.Computer;

public class ComputerShop {

    private Computer[] computers; // Массив компьютеров
    //private Laptop[] laptops; // Массив ноутбуков
    //private Smartphone[] smartphones; // Массив смартфонов
    private int size; // Текущий размер массива

    public ComputerShop(int capacity) {
        computers = new Computer[capacity]; // Создание массива компьютеров заданной емкости
        //laptops = new Laptop[capacity]; // Создание массива ноутбуков заданной емкости
        //smartphones = new Smartphone[capacity]; // Создание массива смартфонов заданной емкости
        size = 0; // Изначально размер массивов равен 0
    }

    public boolean addComputer(Computer computer) {
        if (size == computers.length || findComputer(computer.getBarCode()) != null) {
            return false; // Если массив уже заполнен или компьютер с таким же идентификатором уже существует, возвращаем false
        }
        computers[size] = computer; // Добавляем компьютер в массив
        size++; // Увеличиваем размер массива
        return true; // Возвращаем true, чтобы указать успешное добавление компьютера
    }

    public void printComputers() {
        for (int i = 0; i < size; i++) {
            System.out.println(computers[i]); // Выводим информацию о каждом компьютере в массиве
        }
    }

    public int getSize() {
        return size; // Возвращаем текущий размер массива
    }

    public Computer findComputer(long barCode) {
        for (int i = 0; i < size; i++) {
            if (computers[i].getBarCode() == barCode) {
                return computers[i]; // Если компьютер с указанным идентификатором найден, возвращаем его
            }
        }
        return null; // Если компьютер не найден, возвращаем null
    }

    //public Smartphone findImei(long imei) {
       // for (int i = 0; i < size; i++) {
           // if (smartphones[i].getImei() == imei) {
           //     return smartphones[i]; // Если смартфон с указанным IMEI найден, возвращаем его
           // }
       // }
       // return null; // Если смартфон не найден, возвращаем null
   // }

    public Computer removeComputer(long barCode) {
        Computer removedComputer = null;
        for (int i = 0; i < size; i++) {
            if (computers[i].getBarCode() == barCode) {
                removedComputer = computers[i]; // Запоминаем компьютер, который будет удален
                computers[i] = computers[size - 1]; // Заменяем удаляемый компьютер последним компьютером в массиве
                computers[size - 1] = null; // Очищаем ссылку на последний компьютер
                size--; // Уменьшаем размер массива
                break; // Прерываем цикл после удаления компьютера
            }
        }
        return removedComputer; // Возвращаем удаленный компьютер
    }
}
