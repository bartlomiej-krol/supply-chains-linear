package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TransportMatrix extends JPanel {

    List<Node> nodes = new ArrayList<>();

    private JTextArea[][] texts;
    private int size;

    public TransportMatrix(List<Node> nodes) {
        super();
        this.nodes = nodes;
        this.size = nodes.size();

        this.texts = new JTextArea[size][size];

        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 32);
        this.setLayout(new GridLayout(size + 1, size + 1));
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                JTextArea area = new JTextArea();
                if (i == 0 && j == 0) {
                    area.setEditable(false);
                    area.setBackground(Color.WHITE);
                    area.setText("");
                    area.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    this.add(area);
                    continue;
                }

                if (i != 0) {
                    if (j != 0) {
                        if (i==j) {
                            area.setEditable(false);
                            area.setBackground(Color.GRAY);
                        }
                        else {
                            area.setEditable(true);
                            area.setBackground(Color.YELLOW);
                        }
                        area.setFont(f);
                        area.setText("0");
                        texts[i - 1][j - 1] = area;
                        area.setBorder(BorderFactory.createLineBorder(Color.RED));
                        this.add(area);
                    } else {
                        area.setEditable(false);
                        area.setBackground(Color.PINK);
                        area.setText(String.format("%d. %s\n(%d)", this.nodes.get(i - 1).id,getNameForNode(this.nodes.get(i - 1)),(int)this.nodes.get(i-1).value));
                        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        this.add(area);
                    }

                } else {
                    area.setEditable(false);
                    area.setBackground(Color.CYAN);
                        area.setText(String.format("%d. %s\n(%d)", this.nodes.get(j - 1).id,getNameForNode(this.nodes.get(j - 1)),(int)this.nodes.get(j-1).value));
                    area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    this.add(area);
                }
            }
        }
    }

    private String getNameForNode(Node node) {
        if (Node.Type.BROKER.equals(node.nodeType)) {
            return "Posr.";
        }
        if (Node.Type.RECEIVER.equals(node.nodeType)) {
            return "Odb.";
        }
        if (Node.Type.PROVIDER.equals(node.nodeType)) {
            return "Dost.";
        }

        return "BLAD";
    }

    public List<Trip> getTrips() {
        List<Trip> res = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double val = 0;
                try {
                    val = Double.parseDouble(texts[i][j].getText());
                } catch (NumberFormatException e) {
                }
                if (val != 0) {
                    res.add(new Trip(nodes.get(i).id, nodes.get(j).id, "x" + i + j, val, 0));
                }
            }
        }
        return res;
    }

}
