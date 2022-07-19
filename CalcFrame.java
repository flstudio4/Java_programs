import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalcFrame extends Thread implements ActionListener  {

    int flag = 0;        // flag prevents typing multiple dots
    JPanel panelBottom;
    JLabel label;
    JFrame frame;
    JPanel panelNumbers;
    JPanel panelOperators;
    JTextField field;
    JButton[] numberButtons;
    JButton[] operatorButtons;
    Font myFont;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    //create calculator constructor

    CalcFrame() {
        frame = new JFrame("Calculator");
        myFont = new Font("Arial", Font.BOLD,16);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 330);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        panelNumbers = new JPanel();
        panelOperators = new JPanel();
        panelBottom = new JPanel();

        field = new JTextField(19);
        field.setEditable(false);
        field.setFont(myFont);

        label = new JLabel("  © Created by Dmitrii Sumenko  2022  ");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setEnabled(false);
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);
        panelBottom.add(label);

        //create array of buttons for easier work after

        numberButtons = new JButton[12];

        for(int i = 0; i <= 9; i++){
            numberButtons[i] = new JButton("" + i);
        }

        numberButtons[10] = new JButton("+/-");
        numberButtons[11] = new JButton(".");

        operatorButtons = new JButton[8];

        operatorButtons[0] = new JButton("CE");
        operatorButtons[1]= new JButton("C");
        operatorButtons[2] = new JButton("%");
        operatorButtons[3] = new JButton("/");
        operatorButtons[4] = new JButton("+");
        operatorButtons[5] = new JButton("*");
        operatorButtons[6] = new JButton("-");
        operatorButtons[7] = new JButton("=");

        // add numbers in right order

        panelNumbers.add(numberButtons[7]);
        panelNumbers.add(numberButtons[8]);
        panelNumbers.add(numberButtons[9]);
        panelNumbers.add(numberButtons[4]);
        panelNumbers.add(numberButtons[5]);
        panelNumbers.add(numberButtons[6]);
        panelNumbers.add(numberButtons[1]);
        panelNumbers.add(numberButtons[2]);
        panelNumbers.add(numberButtons[3]);
        panelNumbers.add(numberButtons[10]);
        panelNumbers.add(numberButtons[0]);
        panelNumbers.add(numberButtons[11]);

        for(int i = 0; i < 12; i++){
            numberButtons[i].addActionListener(this);
        }

        for(int i = 0; i < 8; i++){
            panelOperators.add(operatorButtons[i]);
            operatorButtons[i].addActionListener(this);
        }

        frame.add(field);
        frame.add(panelNumbers);
        frame.add(panelOperators);
        frame.add(panelBottom);

        for(int i = 0; i < 12; i++){
            numberButtons[i].setPreferredSize(new Dimension(50, 50));
        }
        for(int i = 0; i < 8; i++){
            operatorButtons[i].setPreferredSize(new Dimension(50, 50));
        }

        //set backgrounds

        field.setBackground(Color.YELLOW);
        panelOperators.setBackground(Color.CYAN);
        panelNumbers.setBackground(Color.CYAN);
        panelBottom.setSize(50, 50);

        //set layouts for panels

        panelOperators.setLayout(new GridLayout(4, 2, 4, 4));
        panelNumbers.setLayout(new GridLayout(4, 3, 4, 4));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //print numbers to text field

        if(e.getSource() == numberButtons[0]){
            if(!field.getText().equals("0") && !field.getText().equals("-0")) {
                field.setText(field.getText().concat(String.valueOf(0)));
            }
        }

        for (int i = 1; i <= 9; i++) {

            if (e.getSource() == numberButtons[i]) {
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }

        if(flag == 0) {

            if (e.getSource() == numberButtons[11] && !field.getText().equals("")) {
                field.setText(field.getText().concat("."));
                flag = 1;
            }
        }

        // deals with action commands operators

        if (e.getSource() == operatorButtons[4]) {
            if(!field.getText().equals("")) {
                num1 = Double.parseDouble(field.getText());
                operator = '+';
                field.setText("");
                flag = 0;
            }
        }

        if (e.getSource() == operatorButtons[6]) {
            if(!field.getText().equals("")) {
                num1 = Double.parseDouble(field.getText());
                operator = '-';
                field.setText("");
                flag = 0;
            }
        }

        if (e.getSource() == operatorButtons[5]) {
            if(!field.getText().equals("")) {
                num1 = Double.parseDouble(field.getText());
                operator = '*';
                field.setText("");
                flag = 0;
            }
        }

        if (e.getSource() == operatorButtons[3]) {
            if(!field.getText().equals("")) {
                num1 = Double.parseDouble(field.getText());
                operator = '/';
                field.setText("");
                flag = 0;
            }
        }

        if (e.getSource() == operatorButtons[2]) {
            if(!field.getText().equals("")) {
                num1 = Double.parseDouble(field.getText());
                operator = '%';
                field.setText("");
                flag = 0;
            }
        }

        if (e.getSource() == operatorButtons[7]) {
            num2 = Double.parseDouble(field.getText());


            switch (operator) {

                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                case '%' -> result = (num1 * num2) / 100;
            }

            field.setText(String.valueOf(result));
            num1 = result;
            flag = 0;
        }

        if (e.getSource() == operatorButtons[0]) {
            field.setText("");
            flag = 0;
        }

        if (e.getSource() == operatorButtons[1]) {
            String string = field.getText();
            field.setText("");

            for (int i = 0; i < string.length() - 1; i++) {

                field.setText(field.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == numberButtons[10] && field.getText().equals("")) {
            field.setText("-");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(CalcFrame::new);
    }
}
