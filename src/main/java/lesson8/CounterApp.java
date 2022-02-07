package lesson8;

import clojure.lang.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;
    private JLabel infolabel;

    public CounterApp() {
        setBounds(500,500,300,120);
        setTitle("Counter app");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        Font font = new Font("Arial", Font.BOLD, 32 );
        JLabel label = new JLabel(String.valueOf(value));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);


        // ДОбвыление мнфопанели. Будет показывать ошибку, если значение счетчика по модулю больше 10.
        infolabel = new JLabel();
        //infolabel.setBackground(Color.RED);
        add(infolabel);


        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton);


        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BoxLayout.PAGE_AXIS);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        //  inserted here
        JButton dedecrementButton = new JButton("<<");
        dedecrementButton.setFont(font);
        add(dedecrementButton, BoxLayout.LINE_AXIS);


        JButton inincrementButton = new JButton(">>");
        inincrementButton.setFont(font);
        add(inincrementButton);

        dedecrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = value - 10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        inincrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = value + 10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });


        // finished insert
        JTextField field = new JTextField();
        field.setFont(font);
        add(field);


        JButton cat = new JButton("Press for a CAT to say Myaou");
        cat.setFont(font);
        add(cat, BoxLayout.LINE_AXIS);

        cat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("Myaou");
            }
        });





        setVisible(true);
    }

    private void validateRange() {
        if (Math.abs(value)>10) {
            infolabel.setText("value out of range");
        }  else {
            infolabel.setText(" ");
        }

    }

    public static void main(String[] args) {
        new CounterApp();
    }



}

