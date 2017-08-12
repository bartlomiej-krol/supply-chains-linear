package main;

import javax.swing.*;
import java.awt.*;

public class CostView  extends JPanel {

	private JTextArea[][] texts;
	
	private int rows;
	private int cols;
	
	public CostView(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		
		this.texts = new JTextArea[rows][cols];
		
		this.setLayout(new GridLayout(rows+1, cols+1));
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				JTextArea area = new JTextArea(); 
	            area.setEditable(true); 
	            area.setBackground(Color.cyan);
	            texts[i][j] = area;
	            area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            this.add(area); 
			}
		}
	}
	
	
	public double[][] getCosts(){
		double[][] costs = new double[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				double val = 0;
				try{
					val = Double.parseDouble(texts[i][j].getText());
				} catch (NumberFormatException e){}
				costs[i][j] = val;
			}
		}
		return costs;
	}
	
}
