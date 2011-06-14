/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import datatstructures.*;
public class PayrollInterface extends JFrame implements ActionListener {

    JPanel pnlTable;
    JPanel pnlButtons;
    ButtonGroup btnGroup;
    JRadioButton rbtnNumber;
    JRadioButton rbtnName;
    JTextField txtSearch;
    JButton btnGO;
    JLabel lblFound;
    JLabel lblPayroll;
    JButton btnRateChange;
    JButton btnPay;
    JButton btnGetInfo;
    JScrollPane scrollPane;
    JTable table;
    Font fntLabels = new Font("Arial Narrow", Font.BOLD, 20);
    JLabel lblFind;
    JLabel lblAccountsPayable;

    public PayrollInterface(String title) {
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
    }

    public void initializeTable() {
        pnlTable = new JPanel();
        pnlTable.setLayout(null);
        pnlTable.setBounds(300, 0, 700, 800);

        String[] columnNames = {"Employee #",
            "Name",
            "Position", "Amount Owed"};

        Object[][] data = {{"1", "Heidi",
                "Manager", "$100.00"}};

        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 600, 500);
        table.setEnabled(false);
        pnlTable.add(scrollPane);

        lblPayroll = new JLabel("Payroll");
        lblPayroll.setBounds(300, 30, 200, 50);
        lblPayroll.setFont(fntLabels);

        pnlTable.add(lblPayroll);

        lblAccountsPayable = new JLabel("Total Accounts Payable: $100.00");
        lblAccountsPayable.setBounds(350,700,300,30);
        lblAccountsPayable.setFont(fntLabels);
        pnlTable.add (lblAccountsPayable);
        
        this.add(pnlTable);

    }

    public void initializeButtons() {
        pnlButtons = new JPanel();
        pnlButtons.setLayout(null);
        pnlButtons.setBounds(0, 0, 300, 800);


        rbtnNumber = new JRadioButton("Number");
        rbtnNumber.setBounds(30, 140, 150, 50);
        rbtnNumber.setFont(fntLabels);
        rbtnNumber.setSelected(true);
        rbtnName = new JRadioButton("Name");
        rbtnName.setBounds(30, 180, 80, 50);
        rbtnName.setFont(fntLabels);


        lblFind = new JLabel("Find employee by:");
        lblFind.setBounds(90, 55, 180, 20);
        lblFind.setFont(fntLabels);
        pnlButtons.add(lblFind);


        btnGroup = new ButtonGroup();
        btnGroup.add(rbtnNumber);
        btnGroup.add(rbtnName);




        txtSearch = new JTextField(50);
        txtSearch.setBounds(20, 250, 160, 30);
        txtSearch.setFont(fntLabels);
        pnlButtons.add(txtSearch);
        btnGO = new JButton("GO");
        btnGO.setBounds(200, 250, 100, 30);
        btnGO.setFont(fntLabels);
        pnlButtons.add(btnGO);

        lblFound = new JLabel("Employee Found!");
        lblFound.setBounds(80, 330, 160, 30);
        lblFound.setFont(fntLabels);
        pnlButtons.add(lblFound);

        btnGetInfo = new JButton("Get Info");
        btnGetInfo.setBounds(80, 400, 150, 50);
        btnGetInfo.setFont(fntLabels);
        btnPay = new JButton("Pay Employee");
        btnPay.setBounds(80, 470, 150, 50);
        btnPay.setFont(fntLabels);
        btnRateChange = new JButton("Change Rate");
        btnRateChange.setBounds(80, 540, 150, 50);
        btnRateChange.setFont(fntLabels);


        pnlButtons.add(btnPay);
        pnlButtons.add(btnRateChange);
        pnlButtons.add(btnGetInfo);
        pnlButtons.add(rbtnNumber);
        pnlButtons.add(rbtnName);


        this.add(pnlButtons);
    }

    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        Object source = e.getSource();
    }
}
