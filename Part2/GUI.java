import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{

    private int lanes = 3;
    private int distance;
    private boolean runCode = false;

    JLabel title = new JLabel("Welcome to horse race simulator");
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;

    JTextField ChooseDistance;

    JButton submit;

    GUI() {
        JPanel header = new JPanel();
        header.add(title);

        three = new JRadioButton("three(Default)");
        four = new JRadioButton("four");
        five = new JRadioButton("five");

        //For radio buttons
        JPanel radio = new JPanel();
        JLabel PickLanes = new JLabel("How many hourses would you like?");
        ButtonGroup group = new ButtonGroup();
        group.add(three);
        group.add(four);
        group.add(five);
        radio.add(PickLanes);
        radio.add(three);
        radio.add(four);
        radio.add(five);

        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);

        three.setSelected(true);

        //Distance
        JPanel DistancePanel = new JPanel();
        JLabel DistanceLabel = new JLabel("How long would you like the track to be?");
        ChooseDistance = new JTextField();
        ChooseDistance.setPreferredSize(new Dimension(50,30));
        DistancePanel.add(DistanceLabel);
        DistancePanel.add(ChooseDistance);

        ChooseDistance.setText("10");

        ChooseDistance.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        //JButton submit
        JPanel submitPanel = new JPanel();
        submit = new JButton("submit");
        submit.addActionListener(this);
        submitPanel.add(submit);

        //set Window
        this.setTitle("Horse Race Simulator");
        this.setLayout(new GridLayout(4,1));
        this.setSize(500,300);
        this.setResizable(false);

        //add into JFrame
        this.add(header);
        this.add(radio);
        this.add(DistancePanel);
        this.add(submitPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==three) {
            lanes = 3;
        } else if(e.getSource()==four) {
            lanes = 4;
        } else if(e.getSource()==five) {
            lanes = 5;
        }

        if(e.getSource()==submit) {
            try {
                distance = Integer.parseInt(ChooseDistance.getText());
            } catch (Exception a) {
                distance = 10;
            }
            runCode = true;
            this.dispose();
        }
    }

    public int getLanes() {
        return this.lanes;
    }

    public int getDistance() {
        return this.distance;
    }

    public boolean getRunCode() {
        return this.runCode;
    }
}
