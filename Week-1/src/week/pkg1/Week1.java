/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week.pkg1;

import java.util.Scanner;

/**
 *
 * @author LARTEK
 */
public class Week1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    
        Scanner input = new Scanner(System.in);

        String[] teams = {"A", "B", "C", "D"};

        int[] team1 = {0, 0, 0, 1, 1, 2};
        int[] team2 = {1, 2, 3, 2, 3, 3};

        int[] homeGoals = new int[6];
        int[] awayGoals = new int[6];

        for (int i = 0; i < 6; i++) {

            System.out.println(
                teams[team1[i]] + " vs " + teams[team2[i]]
            );

            System.out.print(
                teams[team1[i]] + " goals: "
            );
            homeGoals[i] = input.nextInt();

            System.out.print(
                teams[team2[i]] + " goals: "
            );
            awayGoals[i] = input.nextInt();
        }

        int[] points = new int[4];

        int[] wins = new int[4];
        int[] draws = new int[4];
        int[] losses = new int[4];

        for (int i = 0; i < 6; i++) {

            if (homeGoals[i] > awayGoals[i]) {

                points[team1[i]] += 3;

                wins[team1[i]]++;
                losses[team2[i]]++;

            } else if (homeGoals[i] < awayGoals[i]) {

                points[team2[i]] += 3;

                wins[team2[i]]++;
                losses[team1[i]]++;

            } else {

                points[team1[i]]++;
                points[team2[i]]++;

                draws[team1[i]]++;
                draws[team2[i]]++;
            }
        }

        int[] goalsFor = new int[4];
        int[] goalsAgainst = new int[4];

        for (int i = 0; i < 6; i++) {

            goalsFor[team1[i]] += homeGoals[i];
            goalsAgainst[team1[i]] += awayGoals[i];

            goalsFor[team2[i]] += awayGoals[i];
            goalsAgainst[team2[i]] += homeGoals[i];
        }

        System.out.println("\nSTANDINGS");

        System.out.println(
            "TEAM\tW\tD\tL\tGF\tGA\tGD\tPOINTS"
        );

        for (int i = 0; i < 4; i++) {

            int gd = goalsFor[i] - goalsAgainst[i];

            System.out.println(
                teams[i] + "\t" +
                wins[i] + "\t" +
                draws[i] + "\t" +
                losses[i] + "\t" +
                goalsFor[i] + "\t" +
                goalsAgainst[i] + "\t" +
                gd + "\t" +
                points[i]
            );
        }

        int champion = 0;

        for (int i = 1; i < 4; i++) {

            int currentGD =
                goalsFor[i] - goalsAgainst[i];

            int championGD =
                goalsFor[champion] - goalsAgainst[champion];

            if (points[i] > points[champion]) {

                champion = i;

            } else if (
                points[i] == points[champion]
                && currentGD > championGD
            ) {

                champion = i;
            }
        }

        System.out.println(
            "\nChampion: " + teams[champion]
        );

        input.close();
    }
}
        
        
        
      
        
    
    

