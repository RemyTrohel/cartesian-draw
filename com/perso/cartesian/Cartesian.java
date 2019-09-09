package com.perso.cartesian;

import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import com.perso.cartesian.sequences.*;

public class Cartesian {

    private static List<Integer> myList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iterations = 0;
        System.out.println("Veuillez choisir le nombre d'itérations entre 1 et " + CartesianPanel.xCoordNumbers + " :");
        do {
            iterations = sc.nextInt();
        } while (iterations < 1 || iterations > CartesianPanel.xCoordNumbers);
        sc.close();


        /********************* CHANGE CONSTRUCTOR HERE *********************/
        myList = new MySequence(iterations).getSequence();
        /********************* CHANGE CONSTRUCTOR HERE *********************/


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CartesianFrame frame = new CartesianFrame();
                frame.showUI();
                long startTime = System.currentTimeMillis();
                frame.panel.init(myList);
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("\nExecution time : " + elapsedTime + " ms");
            }
        });
    }
}