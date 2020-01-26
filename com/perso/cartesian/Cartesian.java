package com.perso.cartesian;

import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import com.perso.cartesian.sequences.*;

public class Cartesian {

    private static List<Long> myList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long iterations = 0;
        System.out.println("Veuillez choisir le nombre d'iterations entre 1 et " + CartesianPanel.xCoordNumbers + " :");
        do {
            iterations = sc.nextInt();
        } while (iterations < 1 || iterations > CartesianPanel.xCoordNumbers);
        sc.close();

        long startTime = System.currentTimeMillis();

        /********************* CHANGE CONSTRUCTOR HERE *********************/
        //myList = new BalancedTernary(iterations, CartesianPanel.yCoordNumbers/2).getSequence();
        //myList = new Recaman(iterations).getSequence();
        //myList = new VanEck(iterations).getSequence();
        //myList = new Ribbon(iterations).getSequence();
        myList = new Alpes(iterations).getSequence();
        /********************* CHANGE CONSTRUCTOR HERE *********************/

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("\nList generation time : " + elapsedTime + " ms");


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CartesianFrame frame = new CartesianFrame();
                frame.showUI();
                long startTime = System.currentTimeMillis();
                frame.panel.init(myList);
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("\nList to Points time : " + elapsedTime + " ms");
            }
        });
    }
}