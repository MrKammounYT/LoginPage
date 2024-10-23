package me.kammoun;

import javax.swing.SwingUtilities;

import Pages.LoginPage;

public class Main {


	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
	
}
