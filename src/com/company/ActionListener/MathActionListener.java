package com.company.ActionListener;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event){
        JButton button = (JButton)event.getSource();
        String strParam = button.getText();
        String oldStr = Main.mainWindow.textOut.getText();
        Main.mainWindow.textOut.setText(oldStr + strParam);

    }
}
