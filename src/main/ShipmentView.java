package main;

import javax.swing.*; // JFrame, JPanel, ...import javax.swing.border.Border;

import java.awt.*; // GridLayout


public class ShipmentView extends JPanel { 
        public ShipmentView(double cost, double ship) {
        	this.setLayout(new GridLayout(2, 1));
            JTextArea area = new JTextArea(); 
            area.setText(Double.toString(ship)); 
            area.setEditable(false); 
            area.setBackground(Color.cyan);
            this.add(area); 
            
            JTextArea shp = new JTextArea(); 
            shp.setText(Double.toString(cost)); 
            shp.setEditable(false); 
            shp.setBackground(Color.gray);
            this.add(shp); 
            
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
