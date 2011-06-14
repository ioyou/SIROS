/** 
 * A class that creates the Manager Interface GUI
 * with buttons and menu bars
 * 
 * Created by Heidi, Edited by Andy and Chris
 * Comments by Andy 
 * Version 0.22 - Last modified June 2, 2011
 * Created for ICS 4U1 Final Project or SIROS
 * Manager Interface
 */
package GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.*;
import java.applet.Applet;
import datatstructures.*;

public class ManagerInterface extends JFrame implements ActionListener{
    //Where GUI created
    JButton btnInventory;
    JButton btnPayroll;
    JButton btnEmployees;
    JButton btnStatistics;
    JLabel lblManager;
    JMenu menu;
    JMenu file;
    JMenu help;
    JMenuBar menuBar;
    JMenuItem logOut;

    /*****************************************************************************
    Name: ManagerInterface method
    Creator: Heidi
    Date of Creation: May 25, 2011
    Purpose: Constructor Function
    Inputs: String title
    Returns: N/A
    Affects: ManagerInterface
     *****************************************************************************/
    public ManagerInterface(String title) {
        //title is for title of ManagerInterface
        super(title);
        setLayout(null);
        setSize(1100, 900);
        setVisible(true);

        //Call initializer method
        init();
    }

    /*****************************************************************************
    Name: Main method (PROCEDURE)
    Creator: Heidi
    Date of Creation: May 25, 2011
    Purpose: Main method
    Inputs: String args[]
    Returns: N/A
    Affects: ManagerInterface
     *****************************************************************************/
    public static void main(String args[]) {
    }

    /*****************************************************************************
    Name: init method (PROCEDURE)
    Creator: Heidi
    Date of Creation: May 25, 2011
    Purpose: Initialize applet
    Inputs: N/A
    Returns: N/A
    Affects: ManagerInterface
     *****************************************************************************/
    public void init() {

        Font fntLabels = new Font("Arial Narrow", Font.BOLD, 20);

        //to be replaced by reading in manager title
        String name = "Heidi Fouche";

        //Inventory Button
        lblManager = new JLabel("Manager: " + name);
        lblManager.setBounds(400, 150, 180, 80);
        lblManager.setFont(fntLabels);

        //Inventory Button
        btnInventory = new JButton("Inventory");
        btnInventory.setBounds(230, 300, 200, 120);
        btnInventory.setFont(fntLabels);
        btnInventory.addActionListener(this);

        //Payroll Button
        btnPayroll = new JButton("Payroll");
        btnPayroll.setBounds(230, 500, 200, 120);
        btnPayroll.setFont(fntLabels);
        btnPayroll.addActionListener(this);

        //Employee Button
        btnEmployees = new JButton("Employee Database");
        btnEmployees.setBounds(530, 300, 200, 120);
        btnEmployees.setFont(fntLabels);
        btnEmployees.addActionListener(this);

        //Statistics Button
        btnStatistics = new JButton("Statistics");
        btnStatistics.setBounds(530, 500, 200, 120);
        btnStatistics.setFont(fntLabels);

        //Add buttons and labels
        this.add(lblManager);
        this.add(btnInventory);
        this.add(btnPayroll);
        this.add(btnEmployees);
        this.add(btnStatistics);

        //Call method to show menu bar
        showMenuBarSystem();
         
         
    }

    /*****************************************************************************
    Name: showMenuBarSystem method (PROCEDURE)
    Creator: Heidi
    Date of Creation: June 1, 2011
    Purpose: create and show menu bar
    Inputs: N/A
    Returns: N/A
    Affects: ManagerInterface
     *****************************************************************************/
    public void showMenuBarSystem() {
        menuBar = new JMenuBar();
        menuBar.setVisible(true);

        file = new JMenu("File");
        help = new JMenu("Help");

        //Add menu bar
        menuBar.add(file);
        menuBar.add(help);

        //Add log out button
        logOut = new JMenuItem("Log Out");
        logOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        logOut.addActionListener(this);
        file.add(logOut);

        //Set menu bar
        setJMenuBar(menuBar);
        show(); //USED TO FIX BUG 1124098 AKA menu bar not showing until resized!
    }

    /*****************************************************************************
    Name: actionPeformed method (PROCEDURE)
    Creator: Heidi
    Date of Creation: May 25, 2011
    Purpose: to perform actions when something is done
    Inputs: ActionEvent e
    Returns: N/A
    Affects: ManagerInterface
     *****************************************************************************/
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        Object source = e.getSource();

        //If button is clicked, create new interfaces...
        if (source instanceof JButton) {
            if (arg.equals("Inventory")) {
                InventoryInterface inv = new InventoryInterface("Inventory");
            }
            if (arg.equals("Employee Database")) {
                EmployeeInterface emp = new EmployeeInterface("Employee Database");
            }
            if (arg.equals("Payroll")) {
                PayrollInterface pay = new PayrollInterface("Payroll");
            }
        }

        //If menu item is clicked, create new interfaces....
        if (source instanceof JMenuItem) {
            if (arg.equals("Log Out")) {
                MainInterface mainMenu = new MainInterface("Main Menu");
               
                mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //center window on screen
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screen.width - 1000) / 2;
                int y = (screen.height - 800) / 2;

                mainMenu.setBounds(x, y, 1000, 800);
                mainMenu.setVisible(true);
                
                
                //MainMenuSetter(mainMenu);
                dispose();
            }
        }
    }
}
