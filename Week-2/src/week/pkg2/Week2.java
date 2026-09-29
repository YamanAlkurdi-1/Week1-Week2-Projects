/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week.pkg2;

import java.util.Scanner;

/**
 *
 * @author LARTEK
 */
public class Week2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of stops: ");
        int numberOfStops = input.nextInt();
        input.nextLine();

        String[] stopNames = new String[numberOfStops];
        int[] boarding = new int[numberOfStops];
        int[] alighting = new int[numberOfStops];

        System.out.print("Enter bus seating capacity: ");
        int capacity = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numberOfStops; i++) {

            System.out.println("\nStop " + (i + 1));

            System.out.print("Stop name: ");
            stopNames[i] = input.nextLine();

            System.out.print("Passengers boarding: ");
            boarding[i] = input.nextInt();

            System.out.print("Passengers alighting: ");
            alighting[i] = input.nextInt();

            input.nextLine();
        }

        int currentPassengers = 0;

        int[] occupancy = new int[numberOfStops];

        for (int i = 0; i < numberOfStops; i++) {

            if (alighting[i] > currentPassengers) {

                System.out.println(
                    "Data entry error at " + stopNames[i] +
                    ": cannot have more passengers alighting than currently on the bus."
                );

                currentPassengers = 0;

            } else {

                currentPassengers =
                    currentPassengers + boarding[i] - alighting[i];
            }

            occupancy[i] = currentPassengers;

            System.out.println(
                "Passengers after " + stopNames[i] +
                ": " + currentPassengers
            );
        }

        int overCapacityStops = 0;

        for (int i = 0; i < numberOfStops; i++) {

            if (occupancy[i] > capacity) {

                System.out.println(
                    "Warning: Bus is over capacity at "
                    + stopNames[i]
                );

                overCapacityStops++;
            }
        }

        System.out.println("\n==============================");
        System.out.println("ALL STOPS");
        System.out.println("==============================");

        System.out.println(
            "Stop\tBoarding\tAlighting\tOccupancy"
        );

        for (int i = 0; i < numberOfStops; i++) {

            System.out.println(
                stopNames[i] + "\t" +
                boarding[i] + "\t\t" +
                alighting[i] + "\t\t" +
                occupancy[i]
            );
        }

        int busiestStop = 0;

        for (int i = 1; i < numberOfStops; i++) {

            if (boarding[i] > boarding[busiestStop]) {
                busiestStop = i;
            }
        }

        int totalOccupancy = 0;

        for (int i = 0; i < numberOfStops; i++) {
            totalOccupancy += occupancy[i];
        }

        double averageOccupancy =
            (double) totalOccupancy / numberOfStops;

        System.out.println("\n==============================");
        System.out.println("STATISTICS");
        System.out.println("==============================");

        System.out.println(
            "Busiest stop: " +
            stopNames[busiestStop]
        );

        System.out.println(
            "Passengers boarding at busiest stop: " +
            boarding[busiestStop]
        );

        System.out.println(
            "Average occupancy: " +
            averageOccupancy
        );

        System.out.println(
            "Number of stops over capacity: " +
            overCapacityStops
        );

        int finalOccupancy =
            occupancy[numberOfStops - 1];

        System.out.println(
            "\nFinal occupancy: " + finalOccupancy
        );

        if (finalOccupancy != 0) {

            System.out.println(
                "Warning: " + finalOccupancy +
                " passengers still on the bus after the final stop - please check your data."
            );
        }

        input.close();
    }
}
  