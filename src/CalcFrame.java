import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalcFrame implements ActionListener {

    // flag prevents typing multiple dots

    int flag = 0;

    //declare frame, panels, and text field

    JPanel panelBottom;
    JLabel label;
    JFrame frame;
    JPanel panelNumbers;
    JPanel panelOperators;
    JTextField field;
    JButton[] numberButtons;
    Font myFont;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    //declare operators buttons

    JButton ceButton;
    JButton cButton;
    JButton percentButton;
    JButton divisionButton;
    JButton plusButton;
    JButton multButton;
    JButton minusButton;
    JButton equalButton;

    //declare number buttons

    JButton button7;
    JButton button8;
    JButton button9;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton buttonPlusMinus;
    JButton button0;
    JButton buttonDot;

    //create calculator constructor

    CalcFrame() {
        frame = new JFrame("Calculator");
        myFont = new Font("Arial", Font.BOLD,16);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());

        //initialize panels and text field

        panelNumbers = new JPanel();
        panelOperators = new JPanel();
        field = new JTextField(18);
        field.setEditable(false);
        field.setFont(myFont);

        //initialize functional buttons

        ceButton = new JButton("CE");
        cButton = new JButton("C");
        percentButton = new JButton("%");
        divisionButton = new JButton("/");
        plusButton = new JButton("+");
        multButton = new JButton("*");
        minusButton = new JButton("-");
        equalButton = new JButton("=");

        //initialize number buttons

        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        buttonPlusMinus = new JButton("+/-");
        button0 = new JButton("0");
        buttonDot = new JButton(".");
        label = new JLabel("© Created by Dmitrii Sumenko  2020");
        label.setEnabled(true);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        panelBottom = new JPanel();


        //create array of buttons for easier work after

        numberButtons = new JButton[12];
        numberButtons[0] = button0;
        numberButtons[1] = button1;
        numberButtons[2] = button2;
        numberButtons[3] = button3;
        numberButtons[4] = button4;
        numberButtons[5] = button5;
        numberButtons[6] = button6;
        numberButtons[7] = button7;
        numberButtons[8] = button8;
        numberButtons[9] = button9;
        numberButtons[10] = buttonDot;
        numberButtons[11] = buttonPlusMinus;

        //adding number buttons to number panel

        panelNumbers.add(button7);
        panelNumbers.add(button8);
        panelNumbers.add(button9);
        panelNumbers.add(button4);
        panelNumbers.add(button5);
        panelNumbers.add(button6);
        panelNumbers.add(button1);
        panelNumbers.add(button2);
        panelNumbers.add(button3);
        panelNumbers.add(buttonPlusMinus);
        panelNumbers.add(button0);
        panelNumbers.add(buttonDot);
        panelBottom.add(label);


        //adding operators buttons to operators panel

        panelOperators.add(ceButton);
        panelOperators.add(cButton);
        panelOperators.add(percentButton);
        panelOperators.add(divisionButton);
        panelOperators.add(plusButton);
        panelOperators.add(multButton);
        panelOperators.add(minusButton);
        panelOperators.add(equalButton);

        //adding action listener to number buttons

        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        buttonPlusMinus.addActionListener(this);
        button0.addActionListener(this);
        buttonDot.addActionListener(this);

        //adding action listener to operators buttons

        ceButton.addActionListener(this);
        cButton.addActionListener(this);
        percentButton.addActionListener(this);
        divisionButton.addActionListener(this);
        plusButton.addActionListener(this);
        multButton.addActionListener(this);
        minusButton.addActionListener(this);
        equalButton.addActionListener(this);

        //adding panels and text field to frame

        frame.add(field);
        frame.add(panelNumbers);
        frame.add(panelOperators);
        frame.add(panelBottom);

        //set size of buttons

        button0.setPreferredSize(new Dimension(40, 40));
        equalButton.setPreferredSize(new Dimension(40, 40));

        //set backgrounds

        field.setBackground(Color.YELLOW);
        panelOperators.setBackground(Color.CYAN);
        panelNumbers.setBackground(Color.CYAN);

        //set layouts for panels

        panelOperators.setLayout(new GridLayout(4, 2, 4, 4));
        panelNumbers.setLayout(new GridLayout(4, 3, 4, 4));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //print numbers to text field

        for (int i = 0; i <= 9; i++) {

            if (e.getSource() == numberButtons[i]) {
                field.setText(field.getText().concat(String.valueOf(i)));
            }

        }

        if(flag == 0) {

            if (e.getSource() == buttonDot) {
                field.setText(field.getText().concat("."));
                flag = 1;
            }

        } else {
            System.out.println();
        }

        // deals with action commands operators


        if (e.getSource() == plusButton) {

            num1 = Double.parseDouble(field.getText());
            operator = '+';
            field.setText("");
            flag = 0;
        }

        if (e.getSource() == minusButton) {

            num1 = Double.parseDouble(field.getText());
            operator = '-';
            field.setText("");
            flag = 0;
        }

        if (e.getSource() == multButton) {

            num1 = Double.parseDouble(field.getText());
            operator = '*';
            field.setText("");
            flag = 0;
        }

        if (e.getSource() == divisionButton) {

            num1 = Double.parseDouble(field.getText());
            operator = '/';
            field.setText("");
            flag = 0;
        }

        if (e.getSource() == percentButton) {
            num1 = Double.parseDouble(field.getText());
            operator = '%';
            field.setText("");
            flag = 0;
        }

        if (e.getSource() == equalButton) {
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

        if (e.getSource() == ceButton) {
            field.setText("");
        }
        if (e.getSource() == cButton) {
            String string = field.getText();
            field.setText("");

            for (int i = 0; i < string.length() - 1; i++) {

                field.setText(field.getText() + string.charAt(i));
            }

        }

        if (e.getSource() == buttonPlusMinus) {
            double temp = Double.parseDouble(field.getText());
            temp *= -1;
            field.setText(String.valueOf(temp));
            flag = 0;
        }
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(CalcFrame::new);

    }
}
