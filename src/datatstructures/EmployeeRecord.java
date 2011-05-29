/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datatstructures;

/**
 *
 * @author Chris
 */
public class EmployeeRecord extends Record {

    private String firstName;
    private String lastName;
    private int employeeNumber;
    private String password;
    private boolean manager;

    public EmployeeRecord(String fname, String lname, int number, String pass, boolean mang) {
        firstName = fname;
        lastName = lname;
        employeeNumber = number;
        password = pass;
        manager = mang;

    }

    public EmployeeRecord() {
        firstName = "";
        lastName = "";
        employeeNumber = 0;
        password = "";
    }

    public String getRecord() {
        String number = Integer.toString(employeeNumber);
        String record = (firstName + " " + lastName + " " + number);
        return record;
    }

    public void setNull() {
        firstName = "";
        lastName = "";
        employeeNumber = -1;
        password = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isManager() {
        return manager;
    }

    public void setFirstName(String fName) {
        firstName = fName;
    }

    public void setLastName(String lName) {
        lastName = lName;
    }

    public void setEmployeeNumber(int n) {
        employeeNumber = n;
    }

    public void setPassword(String hash) {
        password = hash;
    }

    public void setManager(boolean isManager) {
        manager = isManager;
    }
}
