package ait.tarakan;

import ait.tarakan.model.Tarakan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TarakansRaceAppl {

    public static void main(String[] args) {
        int numberOfTarakans = 0;
        int distance = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the number of tarakans: ");
            numberOfTarakans = Integer.parseInt(reader.readLine());

            System.out.print("Enter the distance: ");
            distance = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Tarakan[] tarakans = new Tarakan[numberOfTarakans];

        for (int i = 0; i < numberOfTarakans; i++) {
            tarakans[i] = new Tarakan(i + 1, distance);
            tarakans[i].start();
        }

        for (Tarakan tarakan : tarakans) {
            try {
                tarakan.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int winner = findWinner(tarakans);
        System.err.println("Congratulations to tarakan #" + winner + " (winner)");
    }

    private static int findWinner(Tarakan[] tarakans) {
        int winner = -1;
        long minFinishTime = Long.MAX_VALUE;

        for (Tarakan tarakan : tarakans) {
            if (tarakan.getFinishTime() < minFinishTime) {
                minFinishTime = tarakan.getFinishTime();
                winner = tarakan.getNumber();
            }
        }

        return winner;
    }
}
