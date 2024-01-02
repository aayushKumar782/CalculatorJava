package CalculatorAWT;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
 class Calculator implements ActionListener{


    JFrame frame;
    JTextField textField;
    JButton[] numberButtions = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,eqButton,delButton,clrButton;
    JPanel panel;
    
    Font myFont = new Font("Int Free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);

        frame.add(textField);
        textField.setEditable(false);
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numberButtions.length; i++) {
            numberButtions[i] = new JButton(String.valueOf(i));
            numberButtions[i].addActionListener(this);
            numberButtions[i].setFont(myFont);
            numberButtions[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtions[1]);
        panel.add(numberButtions[2]);
        panel.add(numberButtions[3]);
        panel.add(addButton);
        panel.add(numberButtions[4]);
        panel.add(numberButtions[5]);
        panel.add(numberButtions[6]);
        panel.add(subButton);
        panel.add(numberButtions[7]);
        panel.add(numberButtions[8]);
        panel.add(numberButtions[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtions[0]);
        panel.add(eqButton);
        panel.add(divButton); 

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

     @Override
     public void actionPerformed(ActionEvent e) {
        for(int i= 0 ; i < 10 ; i++){
            if(e.getSource() == numberButtions[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0 ; i < string.length()-1 ; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            
            switch (operator) {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
                default:
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
     }
 }
