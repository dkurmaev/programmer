package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        Computer comp1 = new Computer("i5", 12, 512, "HP");
        Laptop lap1 = new Laptop("i7", 16, 512, "Asus", 2.5, 3.5);
        Smartphone smart1 = new Smartphone("8хCortex-A53", 3,32,"LG W30", 6, 172, 464234646489676876L, 6.26);
        System.out.println("______________________________________________________________________________________________________________________________");
        comp1.display();
        System.out.println();
        System.out.println("______________________________________________________________________________________________________________________________");
        lap1.display();
        System.out.println();
        System.out.println("______________________________________________________________________________________________________________________________");
        smart1.display();
        //System.out.println();
        System.out.println("______________________________________________________________________________________________________________________________");

    }
}
