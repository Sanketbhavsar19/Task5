package task;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField tf;
    private double total = 0.0;
    private char math_operator;

    public Calculator() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));
        p1.add(new JButton("7"));
        p1.add(new JButton("8"));
        p1.add(new JButton("9"));
        p1.add(new JButton("4"));
        p1.add(new JButton("5"));
        p1.add(new JButton("6"));
        p1.add(new JButton("1"));
        p1.add(new JButton("2"));
        p1.add(new JButton("3"));
        p1.add(new JButton("."));
        p1.add(new JButton("0"));
        p1.add(new JButton("="));
        cp.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 1));
        p2.add(new JButton("+"));
        p2.add(new JButton("-"));
        p2.add(new JButton("*"));
        p2.add(new JButton("/"));
        p2.add(new JButton("C"));
        cp.add(p2, BorderLayout.EAST);

        tf = new JTextField();
        cp.add(tf, BorderLayout.NORTH);

        for (int i = 0; i < 10; i++) {
            ((JButton) p1.getComponent(i)).addActionListener(this);
        }

        for (int i = 0; i < 5; i++) {
            ((JButton) p2.getComponent(i)).addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("+")) {
            math_operator = '+';
            total = total + Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("-")) {
            math_operator = '-';
            total = total + Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("*")) {
            math_operator = '*';
            total = total + Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("/")) {
            math_operator = '/';
            total = total + Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("=")) {
            if (math_operator == '+') {
                total = total + Double.parseDouble(tf.getText());
                tf.setText(Double.toString(total));
                total = 0;
            } else if (math_operator == '-') {
                total = total - Double.parseDouble(tf.getText());
                tf.setText(Double.toString(total));
                total = 0;
            } else if (math_operator == '*') {
                total = total * Double.parseDouble(tf.getText());
                tf.setText(Double.toString(total));
                total = 0;
            } else if (math_operator == '/') {
                total = total / Double.parseDouble(tf.getText());
                tf.setText(Double.toString(total));
                total = 0;
            }
        } else if (s.equals("C")) {
            total = 0;
            tf.setText("");
        } else {
            tf.setText(tf.getText() + s);
        }
    }

    public static void main(String[] args) {
      Calculator calc=new Calculator();
      calc.setTitle("Calculator");
      calc.setSize(200,200);
      calc.setVisible(true);
      calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

