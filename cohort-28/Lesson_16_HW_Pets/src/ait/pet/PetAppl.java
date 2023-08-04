package ait.pet;

public class PetAppl {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Cat", 3, "Indoor;", "Bas", "Pers ", 3);
        cat1.display();
        cat1.eat();
        Cat cat2 = new Cat("Cat", 4, "Indoor;", "Mia", "Scotish ", 2);
        cat2.display();
        cat2.sleep();
        Cat cat3 = new Cat("Cat", 5, "Outdoor;", "Tyson", "Britan ", 4);
        cat3.display();
        cat3.voice();
        Dog dog1 = new Dog("Dog", 6, "Indoor;", "Jacky", "Mops ", 5);
        dog1.display();
        dog1.eat();
        Dog dog2 = new Dog("Dog", 7, "Outdoor;", "Marta ", " German Shepherd ", 10);
        dog2.display();
        dog2.sleep();
        Dog dog3 = new Dog("Dog", 8, "Indoor;", "Gucci ", " Toyterjer ", 12);
        dog3.display();
        dog3.run();
        Dog dog4 = new Dog("Dog", 3, "Indoor;", "Mars ", " Pudel ", 3);
        dog4.display();
        dog2.voice();


    }

}
