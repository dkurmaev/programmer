package ait.pet;

import ait.pet.model.Pet;

public class Dog extends Pet {
    private String name;
    private String breed;
    private int age;

    public Dog(String type, double weight, String livingConditions, String name, String breed, int age) {
        super(type, weight, livingConditions);
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        super.display();
        System.out.println("Name: " + name + ";_______" +  "Breed: " + breed + ";_______" + "Age: " + age);
    }
}
