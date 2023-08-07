package ait.pomergranate;

import ait.pomergranate.model.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PomergranateAppl {
    public static void main(String[] args) {
        List<Box> boxes = generateRandomBoxes();
        int totalSeeds = calculateTotalSeeds(boxes);
        System.out.println("Total seeds: " + totalSeeds);
        int maxSeeds = calculateMaxSeeds(boxes);
        System.out.println("Max seeds: " + maxSeeds);
        List<String> boxesWithMaxSeeds = findBoxesWithMaxSeeds(boxes, maxSeeds);
        System.out.println("Boxes with max seeds: " + boxesWithMaxSeeds);

    }
    private static List<Box> generateRandomBoxes() {
        List<Box> boxes = new ArrayList<>();
        Random random = new Random();
        int numberOfBoxes = random.nextInt(101) + 100;
        for (int i = 0; i < numberOfBoxes ; i++) {
            int numberOfPomergranates = random.nextInt(11) + 10;
            String boxName = "Box" + (i+1);
            boxes.add(new Box(boxName, numberOfPomergranates));
        }
        return boxes;
    }


}
