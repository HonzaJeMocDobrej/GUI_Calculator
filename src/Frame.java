import javax.swing.border.Border;
import javax.sound.midi.VoiceStatus;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class Frame extends JFrame implements ActionListener  {

    String fullStr;
    String numString;

    String calcOperation;

    boolean isCont = false;

    float firstNumber;
    float secondNumber;
    float result;

    int clickCount;
    int clickCountOpr = 0;
    int clickCountNum = 0;

    int frameWidth = 400;
    int frameHeight = 400;

    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonDot;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonTimes;
    JButton buttonSlash;
    JButton buttonEquals;

    JLabel mainText;

    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        Content();
        
        this.setSize(frameHeight, frameWidth);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    void Content(){
        

        JPanel header = new JPanel();
        header.setLayout(new GridBagLayout());
        header.setBackground(Color.gray);
        header.setPreferredSize(new Dimension(75, 75));

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 4, 10, 10));
        center.setBackground(Color.gray);

        JPanel footer = new JPanel();
        footer.setBackground(Color.gray);
        footer.setPreferredSize(new Dimension(50, 50));

        JPanel leftBorder = new JPanel();
        leftBorder.setBackground(Color.gray);
        leftBorder.setPreferredSize(new Dimension(50, 50));

        JPanel rightBorder = new JPanel();
        rightBorder.setBackground(Color.gray);
        rightBorder.setPreferredSize(new Dimension(50, 50));

        JPanel borderHeaderPanel = new JPanel();
        borderHeaderPanel.setLayout(new GridBagLayout());
        borderHeaderPanel.setBackground(Color.green);
        borderHeaderPanel.setPreferredSize(new Dimension(300, 50));

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonDot = new JButton(".");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonTimes = new JButton("*");
        buttonSlash = new JButton("/");
        buttonEquals = new JButton("=");

        ArrayList<JButton> buttons = new ArrayList<JButton>();

        buttons.add(button0);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(buttonDot);
        buttons.add(buttonPlus);
        buttons.add(buttonMinus);
        buttons.add(buttonSlash);
        buttons.add(buttonTimes);
        buttons.add(buttonEquals);        

        mainText = new JLabel();
        
        for (JButton b : buttons) {
            b.setFocusPainted(false);
            b.addActionListener(this);
        }

        if (fullStr != null) {
            mainText.setText(fullStr);
        }
        else{
            mainText.setText("");
        }

        borderHeaderPanel.add(mainText);

        header.add(borderHeaderPanel);

        center.add(button7);
        center.add(button8);
        center.add(button9);
        center.add(buttonSlash);
        center.add(button4);
        center.add(button5);
        center.add(button6);
        center.add(buttonTimes);
        center.add(button1);
        center.add(button2);
        center.add(button3);
        center.add(buttonMinus);
        center.add(button0);
        center.add(buttonDot);
        center.add(buttonPlus);
        center.add(buttonEquals);

        this.add(header, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.add(leftBorder, BorderLayout.WEST);
        this.add(rightBorder, BorderLayout.EAST);
    }

    void textShowing(String stringValue){
        if (fullStr == null) {
            fullStr = stringValue;
            mainText.setText(fullStr);
        }

        else{
            fullStr = fullStr.concat(stringValue);
            mainText.setText(fullStr);
        }
    }

    
    void numberSaving(int number){
        // if (clickCount == 0) {
            //     firstNumber = number;
        //     clickCount++;
        // }
        // else if (clickCount == 1) {
        //     secondNumber = number;
        //     clickCount = 0;
        // }
        
    }
    
    void numberTextSaving(String stringValue){
        clickCountNum++;
        
        if (numString == null) {
            numString = stringValue;
        }
        else{
            numString = numString.concat(stringValue);
        }
    }

    void numStrToIntOne(){
        if (isCont == false) {
            firstNumber = Integer.parseInt(numString);
            System.out.println(firstNumber);
            numString = "";
        }
    }

    void numStrToIntTwo(){
        secondNumber = Integer.parseInt(numString);
        System.out.println(secondNumber);
        numString = "";
    }
    
    void calcLogic(){
        if (calcOperation.equals("+")) {
            result = firstNumber + secondNumber;
        }
        
        else if (calcOperation.equals("-")) {
            result = firstNumber - secondNumber;
        }
        
        else if (calcOperation.equals("*")) {
            result = firstNumber * secondNumber;
        }
        
        else if (calcOperation.equals("/")) {
            result = firstNumber / secondNumber;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == button0) {
            textShowing("0");
            numberTextSaving("0");
            numberSaving(0);
        }
        
        if (e.getSource() == button1) {
            textShowing("1");
            numberTextSaving("1");
            numberSaving(1);
        }
        
        if (e.getSource() == button2) {
            textShowing("2");
            numberTextSaving("2");
            numberSaving(2);
        }

        if (e.getSource() == button3) {
            textShowing("3");
            numberTextSaving("3");
            numberSaving(3);
        }

        if (e.getSource() == button4) {
            textShowing("4");
            numberTextSaving("4");
            numberSaving(4);
        }
        
        if (e.getSource() == button5) {
            textShowing("5");
            numberTextSaving("5");
            numberSaving(5);
        }

        if (e.getSource() == button6) {
            textShowing("6");
            numberTextSaving("6");
            numberSaving(6);
        }

        if (e.getSource() == button7) {
            textShowing("7");
            numberTextSaving("7");
            numberSaving(7);
        }

        if (e.getSource() == button8) {
            textShowing("8");
            numberTextSaving("8");
            numberSaving(8);
        }
        
        if (e.getSource() == button9) {
            textShowing("9");
            numberTextSaving("9");
            numberSaving(9);
        }
        
        if (e.getSource() == buttonDot) {
            if (clickCountNum != 0) {
                textShowing(".");
            }
        }
        
        if (e.getSource() == buttonPlus) {
                textShowing(" + ");
                numStrToIntOne();
                calcOperation = "+";
        }
        
        if (e.getSource() == buttonMinus) {
                textShowing(" - ");
                numStrToIntOne();
                calcOperation = "-";
        }

        if (e.getSource() == buttonTimes) {
                textShowing(" * ");
                numStrToIntOne();
                calcOperation = "*";
        }

        if (e.getSource() == buttonSlash) {
                textShowing(" / ");
                numStrToIntOne();
                calcOperation = "/";
        }

        if (e.getSource() == buttonEquals) {
            if (firstNumber != 0.0f && numString != "") {
                numStrToIntTwo();
                calcLogic();
                System.out.println(result);
                firstNumber = result;
                result = 0;
                clickCount = 1;
                fullStr = String.valueOf(firstNumber);
                mainText.setText(fullStr);
                isCont = true;
            }
        }

    }
    
}
