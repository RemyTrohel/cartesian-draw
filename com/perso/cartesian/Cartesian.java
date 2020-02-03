package com.perso.cartesian;

import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import com.perso.cartesian.sequences.*;

public class Cartesian {

    private static List<Long> myList;
    
    public final static int NB_CHOICES = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long iterations = 0;
        int choice;
        // Sequence choice
        System.out.println("Veuillez choisir la séquence en entrant le chiffre associé : ");
        System.out.println("1 -> BalancedTernary");
        System.out.println("2 -> Recaman");
        System.out.println("3 -> VanEck");
        System.out.println("4 -> Ribbon");
        System.out.println("5 -> Alpes");
        do {
        	choice = sc.nextInt();
        } while (choice < 1 || choice > NB_CHOICES);
        
        // Iterations choice
        System.out.println("Veuillez choisir le nombre d'iterations entre 1 et " + CartesianPanel.xCoordNumbers + " :");
        do {
            iterations = sc.nextLong();
        } while (iterations < 1 || iterations > CartesianPanel.xCoordNumbers);
        sc.close();

        long startTime = System.currentTimeMillis();

        /********************* CHANGE CONSTRUCTOR HERE *********************/
        switch(choice) {
	        case 1:
	        	myList = new BalancedTernary(iterations, CartesianPanel.yCoordNumbers/2).getSequence();
	        	break;
	        case 2:
	        	myList = new Recaman(iterations).getSequence();
	        	break;
	        case 3:
	        	myList = new VanEck(iterations).getSequence();
	        	break;
	        case 4:
	        	myList = new Ribbon(iterations).getSequence();
	        	break;
	        case 5:
	        	myList = new Alpes(iterations).getSequence();
        }
        
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
