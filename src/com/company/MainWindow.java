package com.company;

import javax.swing.*;
import java.awt.*;
import com.company.ActionListener.*;

public class MainWindow extends JFrame {
    private final  char symbolMathReverse = 177;
    public JFrame mainFrame;
    public JTextField textOut = new JTextField("");
    private JButton[] numberButton = new JButton[10];
    private JButton mathReverse = new JButton(String.valueOf(symbolMathReverse));
    private JButton mathMinus = new JButton("-");
    private JButton mathPlus = new JButton("+");
    private JButton mathMultiplication = new JButton("*");
    private JButton mathDivision = new JButton("/");
    private JButton mathEquals = new JButton("=");
    private JButton mathPoint = new JButton(",");

    private Font fontMathButton = new Font("SansSerif", Font.BOLD,15);
    private Font fontNumberButton = new Font("SansSerif", Font.BOLD,25);
    private Font fontOutput = new Font("SansSerif",Font.BOLD,40);

    public MainWindow(){
        //Main window application
        mainFrame = new JFrame("Калькулятор");
        //Process end after close window
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set size main window
        mainFrame.setSize(256,397);
        //Set start location(mid screen)
        mainFrame.setLocationRelativeTo(null);
        //Ban to resize window
        mainFrame.setResizable(false);
        //Set layout
        mainFrame.setLayout(null);
        //Add button
        addButton();
        //Add output frame
        addOutput();
        //Show window
        mainFrame.setVisible(true);

    }
    //add button
    public void addButton(){
        //Create button with number 1-9
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int number=i*3+j+1;
                numberButton[number] = new JButton(number+"");
                numberButton[number].setBounds(j*60+10,310-10*(i+1)-50*(i+1),50,50);
                numberButton[number].setFont(fontNumberButton);
                numberButton[number].addActionListener(new NumberButtonActionListener());
                mainFrame.add(numberButton[number]);
            }
        }

        //Create button with number 0
        numberButton[0] = new JButton("0");
        numberButton[0].setBounds(70,310,50,50);
        numberButton[0].setFont(fontNumberButton);
        numberButton[0].addActionListener(new NumberButtonActionListener());
        mainFrame.add(numberButton[0]);


        //Create button with reverse -
        mathReverse.setBounds(10,310,50,50);
        mathReverse.setFont(fontMathButton);
        mainFrame.add(mathReverse);

        //Create button with math -
        mathMinus.setBounds(190,130,50,50);
        mathMinus.setFont(fontMathButton);
        mathMinus.addActionListener(new MathActionListener());
        mainFrame.add(mathMinus);

        //Create button with math +
        mathPlus.setBounds(190,70,50,50);
        mathPlus.setFont(fontMathButton);
        mathPlus.addActionListener(new MathActionListener());
        mainFrame.add(mathPlus);

        //Create button with math *
        mathMultiplication.setBounds(190,190,50,50);
        mathMultiplication.setFont(fontMathButton);
        mathMultiplication.addActionListener(new MathActionListener());
        mainFrame.add(mathMultiplication);

        //Create button with math /
        mathDivision.setBounds(190,250,50,50);
        mathDivision.setFont(fontMathButton);
        mathDivision.addActionListener(new MathActionListener());
        mainFrame.add(mathDivision);

        //Create button with math =
        mathEquals.setBounds(190,310,50,50);
        mathEquals.setFont(fontMathButton);
        mathEquals.addActionListener(new MathEqualsActionListener());
        mainFrame.add(mathEquals);

        //Create button with math .
        mathPoint.setBounds(130,310,50,50);
        mathPoint.setFont(fontMathButton);

        mainFrame.add(mathPoint);



    }
    //add output
    public void addOutput(){
        textOut.setBounds(10,10,230,50);
        textOut.setEditable(false);
        textOut.setFont(fontOutput);
        textOut.setHorizontalAlignment(JTextField.RIGHT);
        textOut.setBackground(Color.LIGHT_GRAY);
        textOut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainFrame.add(textOut);
    }
}
