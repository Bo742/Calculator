package com.company.ActionListener;

import com.company.Main;
import com.company.MathEquals;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathEqualsActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event){
        String str = Main.mainWindow.textOut.getText();

        MathEquals mathEquals = new MathEquals(str);
        Main.mainWindow.textOut.setText(mathEquals.getAnswer());

    }
}
