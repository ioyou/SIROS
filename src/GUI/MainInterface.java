package GUI;

/**
 * A class that creates the Main Interface GUI
 * with buttons and log in
 * 
 * Created by Heidi, Edited by Andy and Chris
 * Comments by Andy
 * Version 0.25 - Last modified June 13, 2011
 * Created for ICS 4U1 Final Project or SIROS
 * Main Interface
 */
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import utilities.Encryption;
import datatstructures.*;
import InputOutput.*;

public class MainInterface extends JFrame implements ActionListener {

    JFrame f;
    Container contentPane;
    JPanel pnlLogos;
    JPanel pnlLogin;
    ImageIcon imgLogo;
    JLabel lblImg;
    JLabel lblEmployee;
    JLabel lblPass;
    JTextField txtEmployee;
    JPasswordField passField;
    JRadioButton rbtnManager;
    JRadioButton rbtnCashier;
    JButton btnAbout;
    JButton btnLogin;
    ButtonGroup bg1;
    Font fntLabels;
    public static EmployeeRecord test[];

    /*****************************************************************************
    Name: MainInterface method
    Creator: Heidi
    Date of Creation: May 25, 2011
    Purpose: Constructor Function
    Inputs: String title
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    public MainInterface(String title) {
        super(title);
        setLayout(null);
        init();
    }

    /*****************************************************************************
    Name: main method (PROCEDURE)
    Creator: Heidi
    Date of Creation: May 25, 2011
    Purpose: Main method
    Inputs: String args[]
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    public static void main(String args[]) {
        final String RAF_EMPLOYEE_FILE = "login.bin";           // random access file of records
        final int SIZE = 20;                         // maximum amount of data
        final long REC_LENGTH = 84;                  // size of raf record in bytes
        RandomFile rafEmployeeFile = new RandomFile(RAF_EMPLOYEE_FILE, REC_LENGTH);
        rafEmployeeFile.prepareInputFile();

        EmployeeRecord tempRecord;

        test = new EmployeeRecord[1];
        for (int i = 0; i < 1; i++) {
            //Read in employee records into an array
            tempRecord = rafEmployeeFile.getNextRecord(i);
            test[i] = tempRecord;
        }

        rafEmployeeFile.close();

        MainInterface mainMenu = new MainInterface("Main Menu");
        MainMenuSetter(mainMenu);
    }

    /*****************************************************************************
    Name: MainMenuSetter method (PROCEDURE)
    Creator: Andy
    Date of Creation: June 3, 2011
    Purpose: Sets up the main menu
    Inputs: MainInterface main
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    private static void MainMenuSetter(MainInterface main) {

        //close program when clicking x
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //center window on screen and set bounds
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - 1000) / 2;
        int y = (screen.height - 800) / 2;
        main.setBounds(x, y, 1000, 800);

        main.setVisible(true);

    }

    /*****************************************************************************
    Name: init method (PROCEDURE)
    Creator: Chris
    Date of Creation: May 27, 2011
    Purpose: initialize the GUI
    Inputs: N/A
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    public void init() {
        //Testing Employee Record for Main Interface

        fntLabels = new Font("Britannic Bold", Font.BOLD, 20);

        //Call methods to initialize the logo and login
        initializeLogos();
        initializeLogin();
    }

    /*****************************************************************************
    Name: initializeLogos method (PROCEDURE)
    Creator: Heidi
    Date of Creation:  May 25, 2011
    Purpose: initialize the logo
    Inputs: N/A
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    public void initializeLogos() {
        pnlLogos = new JPanel();
        pnlLogos.setLayout(null);

        //set logo as image in project
        imgLogo = new ImageIcon("Logo2.jpg");
        lblImg = new JLabel();
        lblImg.setIcon(imgLogo);
        lblImg.setBounds(0, 0, 1000, 210);


        pnlLogos.add(lblImg);

        pnlLogos.setBounds(0, 0, 1000, 210);
        add(pnlLogos);

    }

    /*****************************************************************************
    Name: initializeLogin method (PROCEDURE)
    Creator: Heidi (Andy for login buttons)
    Date of Creation:  May 27, 2011
    Purpose: initialize the login
    Inputs: N/A
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    public void initializeLogin() {
        pnlLogin = new JPanel();
        pnlLogin.setLayout(null);
        //Color cooBlue = new Color (163, 199, 253);
        Color cooBlue = new Color(190, 219, 246);

        /*Radio Buttons*/
        rbtnManager = new JRadioButton("Manager");
        rbtnManager.setBounds(310, 80, 160, 30);
        rbtnManager.setFont(fntLabels);
        rbtnManager.setBackground(cooBlue);
        rbtnManager.addActionListener(this);
        rbtnCashier = new JRadioButton("Cashier");
        rbtnCashier.setBounds(550, 80, 160, 30);
        rbtnCashier.setFont(fntLabels);
        rbtnCashier.setBackground(cooBlue);
        rbtnCashier.addActionListener(this);
        bg1 = new ButtonGroup();
        bg1.add(rbtnManager);
        bg1.add(rbtnCashier);


        /*Labels*/
        lblEmployee = new JLabel("Employee #");
        lblEmployee.setBounds(270, 230, 160, 30);
        lblEmployee.setFont(fntLabels);
        lblPass = new JLabel("Password");
        lblPass.setBounds(270, 310, 160, 30);
        lblPass.setFont(fntLabels);

        /*Text Fields*/
        txtEmployee = new JTextField(20);
        txtEmployee.setBounds(510, 225, 250, 40);
        txtEmployee.setFont(fntLabels);
        passField = new JPasswordField(20);
        passField.setBounds(510, 300, 250, 40);
        passField.setFont(fntLabels);


        /*Buttons*/
        btnAbout = new JButton("About");
        btnAbout.setBounds(850, 500, 100, 50);
        btnAbout.setFont(fntLabels);
        btnLogin = new JButton("Login");
        btnLogin.setBounds(450, 400, 100, 50);
        btnLogin.setFont(fntLabels);

        //Register Keyboard Actions for entering and spacing
        btnLogin.registerKeyboardAction(btnLogin.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                JComponent.WHEN_FOCUSED);

        btnLogin.registerKeyboardAction(btnLogin.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED);

        btnLogin.setMnemonic(KeyEvent.VK_ENTER);
        btnLogin.addActionListener(this);
        UIManager.put("btnLogin.defaultButtonFollowsFocus", Boolean.TRUE);

        //Add to panel
        pnlLogin.add(rbtnManager);
        pnlLogin.add(rbtnCashier);
        pnlLogin.add(lblEmployee);
        pnlLogin.add(txtEmployee);
        pnlLogin.add(lblPass);
        pnlLogin.add(passField);
        pnlLogin.add(btnLogin);
        pnlLogin.add(btnAbout);


        pnlLogin.setBackground(cooBlue);
        pnlLogin.setBounds(0, 210, 1000, 600);
        add(pnlLogin);

    }

    /*****************************************************************************
    Name: isNumeric method (FUNCTION)
    Creator: Chris
    Date of Creation:  May 26, 2011
    Purpose: Checks if input is numeric for bug testing
    Inputs: String input
    Returns: True or false
    Affects: N/A
     *****************************************************************************/
    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // input not numeric
            return false;
        }
    }

    /*****************************************************************************
    Name: checkLogin method (PROCEDURE)
    Creator: Chris , Modified by Andy
    Date of Creation:  May 26, 2011
    Purpose: Checks if login is correct and logs in
    Inputs: n/a
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    public void checkLogin() throws Exception {


        //If the txt of Employees is numeric (For bug testing)
        if (isNumeric(txtEmployee.getText())) {

            int checkerPassword = 1;
            int checkerInput = 1;

            //Create temporary number for the employee number input
            int tempNumber = Integer.parseInt(txtEmployee.getText());

            //Create temporary hash from password input
            String tempHash = new String(passField.getPassword());

            //Make encryption of temporary hash
            tempHash = Encryption.makeHash(tempHash);
            System.out.println(tempHash); //(For testing)

            for (int i = 0; i < test.length; i++) {
                //If password and temporary number equal the actual employee number/password
                if (test[i].getPassword().equals(tempHash) && tempNumber == test[i].getEmployeeNumber() && test[i].isManager() == true) //if (test[0].getPassword().equals(tempHash)) 
                {
                    System.out.println("Password is correct: Manager");
                    if (rbtnManager.isSelected() == true) {
                        ManagerInterface manager = new ManagerInterface("Manager");
                        checkerPassword = 0;
                        checkerInput = 0;
                    } else if (rbtnCashier.isSelected() == true) {
                        CashierInterface cashier = new CashierInterface("Cashier");
                        checkerPassword = 0;
                        checkerInput = 0;
                    } else {
                        // Show dialog with input           
                        checkerInput = 0;
                    }

                }

                //If password and temporary number equal the actual employee number/password
                if (test[i].getPassword().equals(tempHash) && tempNumber == test[i].getEmployeeNumber() && test[i].isManager() == false) //if (test[0].getPassword().equals(tempHash)) 
                {
                    System.out.println("Password is correct: Cashier");

                    if (rbtnManager.isSelected() == true) {
                        checkerInput = 0;
                        checkerPassword = 2;
                    } else if (rbtnCashier.isSelected() == true) {
                        CashierInterface cashier = new CashierInterface("Cashier");
                        checkerPassword = 0;
                        checkerInput = 0;
                    } else {
                        // Show dialog with input           
                        checkerInput = 0;
                    }
                }
            }

            if (checkerPassword == 0) {
                dispose();
            } //Else if password/temporary number is wrong 
            else if (checkerInput == 0 && checkerPassword == 1) {
                JOptionPane.showMessageDialog(rootPane, "No User Option");
                System.out.println("No User Option");
            } else if (checkerInput == 0 && checkerPassword == 2) {
                JOptionPane.showMessageDialog(rootPane, "YOU ARE NOT A MANAGER");
                System.out.println("Good JOB!!!");
            } else// clear fields
            {
                txtEmployee.setText("");
                passField.setText("");

                // Show dialog with Message of incorrect password                
                JOptionPane.showMessageDialog(rootPane, "User or Password Incorrect");
                System.out.println("User or Password incorrect");

            }
        //}
        } //Else if txt is not numeric
        else {
            txtEmployee.setText("");
            passField.setText("");
            JOptionPane.showMessageDialog(rootPane, "Please type proper input");
        }
    }

    /*****************************************************************************
    Name: actionPerformed method (PROCEDURE)
    Creator: Heidi
    Date of Creation:  May 26, 2011
    Purpose: Checks if action was performed from a button, txt, etc.
    Inputs: ActionEvent e
    Returns: N/A
    Affects: MainInterface
     *****************************************************************************/
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        Object source = e.getSource();


        //If button is clicked, create new interfaces...
        if (source instanceof JRadioButton) {
            if (arg.equals("Manager")) {
                System.out.println("Manager Radio Button Pressed");
            }
            if (arg.equals("Cashier")) {
                System.out.println("Cashier Radio Button Pressed");
            }

        }

        //If button login is clicked
        if (source == btnLogin) {

            System.out.println("Login Pressed");
            try {
                //Check the login
                checkLogin();

            } catch (Exception ex) {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex); //get logger
            }
        }

    }
}
