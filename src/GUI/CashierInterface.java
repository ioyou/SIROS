package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import datatstructures.*;

public class CashierInterface extends JFrame implements ActionListener {

    JPanel pnlTable;
    JPanel pnlButtons;
    JLabel lblItm;
    JTextField txtItmNum;
    JLabel lblItmFound;
    JButton btnAddItem;
    JButton btnReturnItem;
    JButton btnPay;
    JButton btnCancel;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem logOut;
    JScrollPane scrollPane;
    JTable table;
    JLabel lblCashier;
    JLabel lblSubtotal;
    JLabel lblTax;
    JLabel lblTotal;
    JLabel lblSubtotalNum;
    JLabel lblTaxNum;
    JLabel lblTotalNum;
    
    Font fntLabels = new Font("Arial Narrow", Font.BOLD, 20);

    public CashierInterface(String title) {
        super(title);
        setLayout(null);
        setSize(1000, 800);
        setVisible(true);
        init();
    }

    public static void main(String args[]) {
    }

    public void init() {


        initializeTable();
        initializeButtons();
        //Call method to show menu bar
        showMenuBarSystem();
    }

    public void initializeTable() {
        pnlTable = new JPanel();
        pnlTable.setLayout(null);
        pnlTable.setBounds(300, 0, 700, 800);
        lblCashier = new JLabel("Cashier:Employee Name");
        lblCashier.setBounds(250, 10, 200, 100);
        lblCashier.setFont(fntLabels);
        pnlTable.add(lblCashier);

        String[] columnNames = {"Item #",
            "Description",
            "Quantity",
            "Amount",
        };
        Object[][] data = {{"1", "Campbell's Soup",
                "2", "$ 5.00"
            }
        };

        table = new JTable(data, columnNames);
        table.setEnabled(false);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 600, 500);


        lblSubtotal = new JLabel("Subtotal");
        lblSubtotal.setBounds(350, 600, 100, 50);
        lblSubtotal.setFont(fntLabels);
        lblTax = new JLabel("Tax");
        lblTax.setBounds(350, 650, 100, 50);
        lblTax.setFont(fntLabels);
        lblTotal = new JLabel("Total");
        lblTotal.setBounds(350, 700, 100, 50);
        lblTotal.setFont(fntLabels);
        lblSubtotalNum = new JLabel("$100.00");
        lblSubtotalNum.setBounds(500, 600, 100, 50);
        lblSubtotalNum.setFont(fntLabels);
        lblTaxNum = new JLabel("$13.00");
        lblTaxNum.setBounds(500, 650, 100, 50);
        lblTaxNum.setFont(fntLabels);
        lblTotalNum = new JLabel("$113.00");
        lblTotalNum.setBounds(500, 700, 100, 50);
        lblTotalNum.setFont(fntLabels);

        pnlTable.add(scrollPane);
        pnlTable.add(lblSubtotal);
        pnlTable.add(lblTax);
        pnlTable.add(lblTotal);
        pnlTable.add(lblSubtotalNum);
        pnlTable.add(lblTaxNum);
        pnlTable.add(lblTotalNum);
        this.add(pnlTable);

    }

    public void initializeButtons() {
        pnlButtons = new JPanel();
        pnlButtons.setLayout(null);
        pnlButtons.setBounds(0, 0, 300, 800);



        lblItm = new JLabel("Enter Item #:");
        lblItm.setBounds(50, 30, 180, 30);
        lblItm.setFont(fntLabels);
        txtItmNum = new JTextField(50);
        txtItmNum.setBounds(20, 90, 160, 30);
        txtItmNum.setFont(fntLabels);
        lblItmFound = new JLabel("XXXXXXXXXXX");
        lblItmFound.setBounds(30, 150, 180, 20);
        lblItmFound.setFont(fntLabels);

        btnAddItem = new JButton("Add Item");
        btnAddItem.setBounds(20, 300, 150, 50);
        btnAddItem.setFont(fntLabels);
        btnReturnItem = new JButton("Return Item");
        btnReturnItem.setBounds(20, 400, 150, 50);
        btnReturnItem.setFont(fntLabels);
        btnPay = new JButton("Pay");
        btnPay.setBounds(20, 550, 150, 50);
        btnPay.setFont(fntLabels);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(20, 650, 150, 50);
        btnCancel.setFont(fntLabels);

        pnlButtons.add(lblItm);
        pnlButtons.add(txtItmNum);
        pnlButtons.add(lblItmFound);
        pnlButtons.add(btnAddItem);
        pnlButtons.add(btnReturnItem);
        pnlButtons.add(btnPay);
        pnlButtons.add(btnCancel);
        this.add(pnlButtons);
        
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
        //help = new JMenu("Help");

        //Add menu bar
        menuBar.add(file);
        //menuBar.add(help);

        //Add log out button
        logOut = new JMenuItem("Log Out");
        logOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        logOut.addActionListener(this);
        file.add(logOut);

        //Set menu bar
        setJMenuBar(menuBar);
        show(); //USED TO FIX BUG 1124098 AKA menu bar not showing until resized!
    }

    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        Object source = e.getSource();

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
