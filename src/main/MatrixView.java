package main;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MatrixView extends JPanel {

	public MatrixView(Shipment[][] matrix){
		int w = matrix.length;
		int h = matrix[0].length;
		
		this.setLayout(new GridLayout(w, h));
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				if(matrix[i][j] == null){
					this.add(new ShipmentView(0, 0));
					continue;
				}
				this.add(new ShipmentView(matrix[i][j].getCostPerUnit(), matrix[i][j].getQuantity()));
			}
		}
	}
	
	
	
}
