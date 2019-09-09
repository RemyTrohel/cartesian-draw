package com.perso.cartesian;

import javax.swing.JFrame;

public class CartesianFrame extends JFrame {
    CartesianPanel panel;

    public CartesianFrame() {
        panel = new CartesianPanel();
        add(panel);
    }

    public void showUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cartesian");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
    }
}