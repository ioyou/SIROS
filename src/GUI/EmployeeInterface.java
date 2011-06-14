package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import datatstructures.*;
public class EmployeeInterface extends JFrame implements ActionListener {

    JPanel pnlTable;
    JPanel pnlButtons;
    JTextField txtSearch;
    JButton btnGO;
    JButton btnHire;
    JButton btnFire;
    JButton btnGetInfo;
    JButton btnTimeStamps;
    JButton btnModify;
    JTextField txtQuantity;
    JScrollPane scrollPane;
    JTable table;
    JLabel lblEmployee;
    JLabel lblFound;
    Font fntLabels = new Font("Arial Narrow", Font.BOLD, 20);
    JLabel lblTotalEmployees;
    ButtonGroup btnGroup;
    ButtonGroup btnGroup2;
    JRadioButton rbtnFind;
    JRadioButton rbtnSort;
    JRadioButton rbtnNumber;
    JRadioButton rbtnName;
    JRadioButton rbtnPrice;
    JLabel lblOr;
    JLabel lblItemBy;

    public EmployeeInterface(String title) {
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
        lblEmployee = new JLabel("Employee Database");
        lblEmployee.setBounds(280, 10, 200, 100);
        lblEmployee.setFont(fntLabels);
        pnlTable.add(lblEmployee);

        String[] columnNames = {"Employee #",
            "Name",
            "Position",};

        Object[][] data = {{"1", "Heidi",
                "Manager"}};

        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 600, 500);
        table.setEnabled(false);
        pnlTable.add(scrollPane);

        lblTotalEmployees = new JLabel("Total Quantity: " + 39);
        lblTotalEmployees.setBounds(150, 650, 200, 50);
        lblTotalEmployees.setFont(fntLabels);


        pnlTable.add(lblEmployee);

        lblTotalEmployees = new JLabel("Total Employees: 1");
        lblTotalEmployees.setBounds(450, 700, 150, 50);
        lblTotalEmployees.setFont(fntLabels);
        pnlTable.add(lblTotalEmployees);

        this.add(pnlTable);

    }

    public void initializeButtons() {
        pnlButtons = new JPanel();
        pnlButtons.setLayout(null);
        pnlButtons.setBounds(0, 0, 300, 800);

        rbtnFind = new JRadioButton("Find");
        rbtnFind.setBounds(20, 40, 80, 50);
        rbtnFind.setFont(fntLabels);
        rbtnFind.setSelected(true);
        rbtnSort = new JRadioButton("Sort");
        rbtnSort.setBounds(180, 40, 120, 50);
        rbtnSort.setFont(fntLabels);
        rbtnNumber = new JRadioButton("Number");
        rbtnNumber.setBounds(30, 140, 150, 50);
        rbtnNumber.setFont(fntLabels);
        rbtnNumber.setSelected(true);
        rbtnName = new JRadioButton("Name");
        rbtnName.setBounds(30, 180, 80, 50);
        rbtnName.setFont(fntLabels);


        lblOr = new JLabel("OR");
        lblOr.setBounds(120, 55, 60, 20);
        lblOr.setFont(fntLabels);
        pnlButtons.add(lblOr);
        lblItemBy = new JLabel("item by:");
        lblItemBy.setBounds(100, 90, 180, 50);
        lblItemBy.setFont(fntLabels);
        pnlButtons.add(lblItemBy);

        btnGroup = new ButtonGroup();
        btnGroup.add(rbtnFind);
        btnGroup.add(rbtnSort);
        btnGroup2 = new ButtonGroup();
        btnGroup2.add(rbtnNumber);
        btnGroup2.add(rbtnName);



        txtSearch = new JTextField(50);
        txtSearch.setBounds(20, 250, 160, 30);
        txtSearch.setFont(fntLabels);
        pnlButtons.add(txtSearch);
        btnGO = new JButton("GO");
        btnGO.setBounds(200, 250, 100, 30);
        btnGO.setFont(fntLabels);
        pnlButtons.add(btnGO);

        lblFound = new JLabel("Employee Found!");
        lblFound.setBounds(70, 320, 160, 30);
        lblFound.setFont(fntLabels);
        pnlButtons.add(lblFound);

        btnGetInfo = new JButton("Get Info");
        btnGetInfo.setBounds(80, 380, 150, 50);
        btnGetInfo.setFont(fntLabels);
        btnHire = new JButton("Hire");
        btnHire.setBounds(80, 450, 150, 50);
        btnHire.setFont(fntLabels);
        btnFire = new JButton("Fire");
        btnFire.setBounds(80, 520, 150, 50);
        btnFire.setFont(fntLabels);
        btnTimeStamps = new JButton("Time Stamps");
        btnTimeStamps.setBounds(80, 590, 150, 50);
        btnTimeStamps.setFont(fntLabels);
        btnModify = new JButton("Modify Employee");
        btnModify.setBounds(80, 660, 150, 50);
        Font fntLabels = new Font("Arial Narrow", Font.BOLD, 16);
        btnModify.setFont(fntLabels);




        pnlButtons.add(btnHire);
        pnlButtons.add(btnModify);
        pnlButtons.add(btnFire);
        pnlButtons.add(btnTimeStamps);
        pnlButtons.add(btnGetInfo);
        pnlButtons.add(rbtnFind);
        pnlButtons.add(rbtnSort);
        pnlButtons.add(rbtnNumber);
        pnlButtons.add(rbtnName);


        this.add(pnlButtons);
    }

    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        Object source = e.getSource();
    }
}
