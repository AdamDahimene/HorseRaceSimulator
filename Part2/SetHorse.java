import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SetHorse extends JFrame implements ActionListener{
    private String Name;
    private char Symbol = '\u2658';
    private double Confidence;
    private boolean runCode = false;

    JLabel title;
    JTextField ChooseName;
    JRadioButton Knight;
    JRadioButton King;
    JRadioButton Queen;
    JSlider Slider;
    JButton submit;

    SetHorse(int Lane) {
        JPanel header = new JPanel();
        title = new JLabel("Horse " + Lane);
        header.add(title);

        //Name
        JPanel NamePanel = new JPanel();
        JLabel NameLabel = new JLabel("Horse Name");
        ChooseName = new JTextField();
        ChooseName.setPreferredSize(new Dimension(70,30));
        NamePanel.add(NameLabel);
        NamePanel.add(ChooseName);

        ChooseName.setText("Horse " + Lane);

        //Symbol
        JPanel radio = new JPanel();
        JLabel PickSymbol = new JLabel("Select character: ");

        Knight = new JRadioButton("\u2658");
        King = new JRadioButton("\u2654");
        Queen = new JRadioButton("\u2655");

        Knight.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(Knight);
        group.add(King);
        group.add(Queen);
        radio.add(PickSymbol);
        radio.add(Knight);
        radio.add(King);
        radio.add(Queen);

        Knight.addActionListener(this);
        King.addActionListener(this);
        Queen.addActionListener(this);

        //Confidence
        JPanel ConfidencePanel = new JPanel();
        JLabel ConfidenceLabel = new JLabel("Select confidence: ");
        Slider = new JSlider(0, 10, 5);
        Slider.setPaintTrack(true);
        Slider.setMajorTickSpacing(1);
        Slider.setPaintLabels(true);
        ConfidencePanel.add(ConfidenceLabel);
        ConfidencePanel.add(Slider);

        //Submit
        JPanel submitPanel = new JPanel();
        submit = new JButton("submit");
        submit.addActionListener(this);
        submitPanel.add(submit);

        this.add(header);
        this.add(NamePanel);
        this.add(radio);
        this.add(ConfidencePanel);
        this.add(submitPanel);

        //set Window
        this.setTitle("Horse Race Simulator");
        this.setLayout(new GridLayout(5,1));
        this.setSize(500,300);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Knight) {
            Symbol = '\u2658';
        } else if(e.getSource()==King) {
            Symbol = '\u2654';
        } else if(e.getSource()==Queen) {
            Symbol = '\u2655';
        }

        if(e.getSource()==submit) {
            Name = ChooseName.getText();
            Confidence = Slider.getValue();
            this.runCode = true;
            this.dispose();
        }
    }

    public String getName() {
        return this.Name;
    }

    public char getSymbol() {
        return this.Symbol;
    }

    public double getConfidence() {
        return this.Confidence/10;
    }

    public boolean getRunCode() {
        return this.runCode;
    }
}
