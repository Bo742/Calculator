package com.company.ActionListener;

import com.company.Main;
import com.company.MathEquals;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathEqualsActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event){
        String str = Main.mainWindow.textOut.getText();
        String[] strSymbol = str.split("");
        int count =0;
        for (int i = 0; i < strSymbol.length ; i++) {
            if(strSymbol[i].equals("+") || strSymbol[i].equals("-") || strSymbol[i].equals("*") || strSymbol[i].equals("/") ) {
                count++;
                break;
            }
        }
        if(count!=0){
            MathEquals mathEquals = new MathEquals(str);
            Main.mainWindow.textOut.setText(mathEquals.getAnswer());
        }


    }
}
