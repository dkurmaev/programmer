package ait.pet.model;

import ait.pet.Dog;

public class Pet {
    private String type;
    private double weight;
    private String livingConditions;

    public Pet(String type, double weight, String livingConditions) {
        this.type = type;
        this.weight = weight;
        this.livingConditions = livingConditions;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getLivingConditions() {
        return livingConditions;
    }
    public void display(){
        System.out.println("*******************************************************************************************************************************");
        System.out.println("Type: " + type +";_______" + " Weight: " + weight + ";_______" + " Living Conditions: " + livingConditions);
    }

    public void eat() {
        System.out.println("The pet is eating.");
    }

    public void sleep() {
        System.out.println("The pet is sleeping.");
    }
    public void voice() {
        System.out.println("Gau -Gau!");
    }

    public void run() {
        System.out.println("The dog is running.");
    }
}
