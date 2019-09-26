package com.company.ActionListener;

import com.company.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteLastNumberActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event){
        String oldStr = Main.mainWindow.textOut.getText();
        String[] oldStrSymbol = oldStr.split("");
        int lastOperation = 0;
        for (int i = oldStrSymbol.length-1; i>=0 ; i--) {
            if(oldStrSymbol[i].equals("-") || oldStrSymbol[i].equals("+") || oldStrSymbol[i].equals("*") || oldStrSymbol[i].equals("/") ){
                lastOperation=i;
                break;
            }
        }
        if(lastOperation==0){
            Main.mainWindow.textOut.setText("0");
        }
        else{
            String newString = "";
            for (int i = 0; i <lastOperation+1 ; i++) {
                newString=newString+oldStrSymbol[i];
            }
            Main.mainWindow.textOut.setText(newString);
        }

    }
}
