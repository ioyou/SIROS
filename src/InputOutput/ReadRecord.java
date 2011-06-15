package InputOutput;

import datatstructures.EmployeeRecord;
import Keyboard;

/**
 *
 * @author nieschri125
 * @purpose To test the reading in of records
 */
public class ReadRecord {

    final static String RAF_FILE = "login.bin";
    final static int REC_LENGTH = 500;

    public static void main(String[] args) {
        RandomFile rFile = new RandomFile(RAF_FILE, REC_LENGTH);
        rFile.prepareInputFile();
        EmployeeRecord rdInRecord = new EmployeeRecord();
        rdInRecord = rFile.getNextRecord();
        System.out.println(rdInRecord.getFirstName());
        System.out.println(rdInRecord.getLastName());
        System.out.println(rdInRecord.getEmployeeNumber());
        System.out.println(rdInRecord.getPassword());
        System.out.println(rdInRecord.isManager());
        System.out.print("Clear file?");

    }
}
