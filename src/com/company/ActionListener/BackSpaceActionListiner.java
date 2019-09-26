package com.company.ActionListener;

import com.company.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackSpaceActionListiner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event){
        String oldStr=Main.mainWindow.textOut.getText();
        String[] oldStrSymbol = oldStr.split("");
        String newString = "";
        for (int i = 0; i < oldStrSymbol.length-1; i++) {
            newString = newString+oldStrSymbol[i];
        }
        Main.mainWindow.textOut.setText(newString);
    }
}
