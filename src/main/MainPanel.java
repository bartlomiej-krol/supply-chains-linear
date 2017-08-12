package main;

import net.sf.javailp.Result;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JFrame {

    JPanel mainPanel;
    JList<Provider> providerJList;
    JList<Receiver> receiverJList;
    JList<Broker> brokerJList;
    DefaultListModel providerModel;
    DefaultListModel receiverModel;
    DefaultListModel brokerModel;
    JTextArea logArea;
    JScrollPane pane;

    private static final String PROVIDER_NAME = "D_";
    private static final String RECEIVER_NAME = "O_";
    private static final String BROKER_NAME = "P_";


    public MainPanel() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        mainConfiguration();
        mainPanelConfiguration();
        receiverListElements();
        providerListElements();
        brokerListElements();
        tableElements();
        addStartButton();
        addLogArea();
    }

    private void addLogArea() {
        logArea = new JTextArea();
        logArea.setLineWrap(true);
        pane = new JScrollPane(logArea);
        pane.setBounds(200, 400, 300, 300);
        pane.setVisible(false);
        mainPanel.add(pane);
    }

    private void mainConfiguration() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setTitle("Supply Chain Management");
        setBounds(100, 100, 900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void mainPanelConfiguration() {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);
    }

    private void providerListElements() {
        JLabel providerListTitle = new JLabel("Lista dostawców");
        providerListTitle.setFont(new Font(providerListTitle.getName(), Font.BOLD, 14));
        providerListTitle.setBounds(10, 10, 150, 20);
        mainPanel.add(providerListTitle);


        JLabel inputLabel = new JLabel("Podaż");
        inputLabel.setBounds(10, 145, 40, 20);
        mainPanel.add(inputLabel);

        JLabel providerId = new JLabel("ID");
        providerId.setBounds(10, 125, 40, 20);
        mainPanel.add(providerId);

        final JTextField supplyInput = new JTextField("");
        supplyInput.setBounds(55, 145, 25, 20);
        mainPanel.add(supplyInput);

        final JTextField idInput = new JTextField("");
        idInput.setBounds(55, 125, 25, 20);
        mainPanel.add(idInput);

        JButton addProvider = new JButton("Dodaj");
        addProvider.setBounds(10, 170, 60, 20);
        addProvider.addActionListener(e -> {
            int supplyAmmount = Integer.parseInt(supplyInput.getText());
            int pId = Integer.parseInt(idInput.getText());
            providerModel.addElement(new Provider(pId, PROVIDER_NAME + providerModel.size(), supplyAmmount));
        });
        mainPanel.add(addProvider);

        JButton deleteProvider = new JButton("Usuń");
        deleteProvider.setBounds(80, 170, 60, 20);
        deleteProvider.addActionListener(e -> providerModel.removeElementAt(providerJList.getSelectedIndex()));
        mainPanel.add(deleteProvider);

        providerModel = new DefaultListModel();
        providerJList = new JList<>(providerModel);

        JScrollPane scrollPane = new JScrollPane(providerJList);
        scrollPane.setBounds(10, 40, 140, 80);
        mainPanel.add(scrollPane);
    }

    private void receiverListElements() {

        JLabel receiverLabel = new JLabel("Lista odbiorców");
        receiverLabel.setFont(new Font(receiverLabel.getName(), Font.BOLD, 14));
        receiverLabel.setBounds(10, 210, 150, 20);
        mainPanel.add(receiverLabel);


        JLabel inputLabel = new JLabel("Popyt");
        inputLabel.setBounds(10, 345, 40, 20);
        mainPanel.add(inputLabel);

        JLabel receiverIdLabel = new JLabel("ID");
        receiverIdLabel.setBounds(10, 325, 40, 20);
        mainPanel.add(receiverIdLabel);

        final JTextField demandAmount = new JTextField("");
        demandAmount.setBounds(55, 345, 25, 20);
        mainPanel.add(demandAmount);

        final JTextField receiverId = new JTextField("");
        receiverId.setBounds(55, 325, 25, 20);
        mainPanel.add(receiverId);

        JButton addReceiver = new JButton("Dodaj");
        addReceiver.setBounds(10, 370, 60, 20);
        addReceiver.addActionListener(e -> {
            int supplyAmount = Integer.parseInt(demandAmount.getText());
            int rId = Integer.parseInt(receiverId.getText());
            receiverModel.addElement(new Receiver(rId, RECEIVER_NAME + receiverModel.size(), supplyAmount));
        });
        mainPanel.add(addReceiver);

        JButton deleteReceiver = new JButton("Usuń");
        deleteReceiver.setBounds(80, 370, 60, 20);
        deleteReceiver.addActionListener(e -> receiverModel.removeElementAt(receiverJList.getSelectedIndex()));
        mainPanel.add(deleteReceiver);

        receiverModel = new DefaultListModel();
        receiverJList = new JList<>(receiverModel);

        JScrollPane receiverScrollPane = new JScrollPane(receiverJList);
        receiverScrollPane.setBounds(10, 240, 140, 80);
        mainPanel.add(receiverScrollPane);


    }

    private void brokerListElements() {

        JLabel brokerLabel = new JLabel("Lista pośredników");
        brokerLabel.setFont(new Font(brokerLabel.getName(), Font.BOLD, 14));
        brokerLabel.setBounds(10, 410, 150, 20);
        mainPanel.add(brokerLabel);


        JLabel inputLabel = new JLabel("ID");
        inputLabel.setBounds(10, 525, 40, 20);
        mainPanel.add(inputLabel);

        final JTextField brokerId = new JTextField("");
        brokerId.setBounds(55, 525, 25, 20);
        mainPanel.add(brokerId);

         final JTextField brokerVal = new JTextField("");
        brokerVal.setBounds(55, 545, 25, 20);
        mainPanel.add(brokerVal);

        JButton addReceiver = new JButton("Dodaj");
        addReceiver.setBounds(10, 570, 60, 20);
        addReceiver.addActionListener(e -> {
            int bId = Integer.parseInt(brokerId.getText());
            int val = Integer.parseInt(brokerVal.getText());
            brokerModel.addElement(new Broker(bId, BROKER_NAME + brokerModel.size(),val));
        });
        mainPanel.add(addReceiver);

        JButton deleteReceiver = new JButton("Usuń");
        deleteReceiver.setBounds(80, 570, 60, 20);
        deleteReceiver.addActionListener(e -> brokerModel.removeElementAt(brokerJList.getSelectedIndex()));
        mainPanel.add(deleteReceiver);

        brokerModel = new DefaultListModel();
        brokerJList = new JList<>(brokerModel);

        JScrollPane receiverScrollPane = new JScrollPane(brokerJList);
        receiverScrollPane.setBounds(10, 440, 140, 80);
        mainPanel.add(receiverScrollPane);


    }


    private void tableElements() {
        //Print table for calculations ?
    }

    private void addStartButton() {
        JButton startButton = new JButton("Stworz macierz");
        startButton.addActionListener(e -> {
            showCostMatrix();
            replaceStartButton();
            this.repaint();
        });
        startButton.setBounds(10, 610, 150, 20);
        mainPanel.add(startButton);
        mainPanel.invalidate();
        mainPanel.repaint();
    }

    private void replaceStartButton() {
        JButton startButton = new JButton("start calculating");
        startButton.addActionListener(e -> {
            startCalculating();
        });
        startButton.setBounds(10, 640, 150, 20);
        mainPanel.add(startButton);
        mainPanel.invalidate();
    }

    private void startCalculating() {
        List<Trip> trips = transportMatrix.getTrips();
        List<Node> nodes = transportMatrix.nodes;

//        readFromFile(trips, nodes);

        List<Equation> equations = new ArrayList<>();
        for (Node n : nodes) {
            if (n.nodeType.equals(Node.Type.BROKER))
                equations.addAll(NodesHelper.getBrokerEq(trips, n));
            else if (n.nodeType.equals(Node.Type.RECEIVER))
                equations.add(NodesHelper.getReceiverEq(trips, n));
            else if (n.nodeType.equals(Node.Type.PROVIDER))
                equations.add(NodesHelper.getProviderEq(trips, n));
        }
        
        pane.setVisible(true);

        logArea.append("\n__Równania__\n");
        for (Equation e : equations){
            logArea.append(e.getStringVal() + "\n");
        }
        
        Result result = Solver2.resolve(trips, equations);
//    	showMatrix(Solver.getResult());
        logArea.setText("");
        logArea.append("Wynik = " + result.getObjective().doubleValue() + "\n");
        logArea.append("\n__Drogi__\n");
        for (Trip t :
                trips) {
            logArea.append("Droga: " + NodesHelper.resolveIndexes(t.name)
                    + " " + Math.round((Double) result.getPrimalValue(t.name)) + "\n");
        }
    }

    private void readFromFile(List<Trip> trips, List<Node> nodes) {
        trips.clear();
        nodes.clear();
        try {
            File file = new File("trips_input.txt");
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(file));
            for (String line; (line = reader.readLine()) != null; ) {
                Trip trip = new Trip();
                trip.from = Integer.parseInt(line.split(",")[0]);
                trip.to = Integer.parseInt(line.split(",")[1]);
                trip.name = line.split(",")[2];
                trip.cost = Double.parseDouble(line.split(",")[3]);
                trip.value = Double.parseDouble(line.split(",")[4]);
                trips.add(trip);
            }
            File file2 = new File("trips_input_nodes.txt");
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            for (String line; (line = reader2.readLine()) != null; ) {
                Node node = new Node();
                node.id = Integer.parseInt(line.split(",")[0]);
                node.value = Double.parseDouble(line.split(",")[1]);
                nodes.add(node);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    TransportMatrix transportMatrix = null;

    private void showCostMatrix() {
        if(transportMatrix != null)
            mainPanel.remove(transportMatrix);
        List<Provider> providers = new ArrayList<>();
        List<Receiver> receivers = new ArrayList<>();
        List<Broker> brokers = new ArrayList<>();

        List<Node> nodes = new ArrayList<>();
        int index = 0;

        int proSize = providerModel.size();
        int recSize = receiverModel.size();
        int broSize = brokerModel.size();
        for (int i = 0; i < proSize; i++) {
            Provider r = (Provider) providerModel.get(i);
            nodes.add(new Node(r.getId(), r.getSupply(), Node.Type.PROVIDER));
        }
        for (int i = 0; i < recSize; i++) {
            Receiver r = (Receiver) receiverModel.get(i);
            nodes.add(new Node(r.getId(), -r.getDemand(), Node.Type.RECEIVER));
        }
        for (int i = 0; i < broSize; i++) {
            Broker b = (Broker) brokerModel.get(i);
            nodes.add(new Node(b.getId(), b.value, Node.Type.BROKER));
        }
        transportMatrix = new TransportMatrix(nodes);
        transportMatrix.setBounds(200, 10, (1+nodes.size())*60, (1+nodes.size())*60); //TODO: jakos policzyc wielkosc w zaleznosci od ilosci elelemntow
        mainPanel.add(transportMatrix);
        mainPanel.validate();
        

    }

    private void showMatrix(Shipment[][] matrix) {
//    	mainPanel.remove(costView);
//    	
//    	MatrixView view = new MatrixView(matrix);
//    	view.setBounds(10,  180,  300, 300); //TODO: jakos policzyc wielkosc w zaleznosci od ilosci elelemntow
//    	mainPanel.add(view);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainPanel frame = new MainPanel();
                frame.setBounds(30, 30, 1000, 700);
                frame.setBackground(Color.green);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
