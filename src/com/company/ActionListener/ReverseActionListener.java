package com.company.ActionListener;

import com.company.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReverseActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event){
        String strCur = Main.mainWindow.textOut.getText();
        int count = 0;
        String[] strSymbol = strCur.split("");
        for (int i = 0; i <strCur.length() ; i++) {
            if( strSymbol[i].equals("*") || strSymbol[i].equals("/") ) {
                count++;
                break;
            }
            if(strSymbol[i].equals("-")){
                count=count+10;
            }
            if(strSymbol[i].equals("+")){
                count=count+20;
            }
        }
        if(count==0){
            Main.mainWindow.textOut.setText("-"+strCur);
        }
        else{
            if(count==10){
                String strNew="";
                for (int i = 1; i <strCur.length() ; i++) {
                    strNew=strNew+strSymbol[i];
                }
                Main.mainWindow.textOut.setText("+"+strNew);
            }
            if(count==20){
                String strNew="";
                for (int i = 1; i <strCur.length() ; i++) {
                    strNew=strNew+strSymbol[i];
                }
                Main.mainWindow.textOut.setText("-"+strNew);
            }
        }
    }
}
