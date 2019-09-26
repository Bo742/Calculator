package com.company.ActionListener;

import com.company.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAllActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event){
        Main.mainWindow.textOut.setText("");
    }
}
