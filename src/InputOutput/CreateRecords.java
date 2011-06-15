/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InputOutput;

import datatstructures.EmployeeRecord;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Encryption;

/**
 *
 * @author nieschri125
 * @purpose To create a random file
 */
public class CreateRecords {

    final static String RAF_FILE = "login.bin";
    final static int REC_LENGTH = 500;

    public static void main(String args[]) {
        RandomFile rFile = new RandomFile(RAF_FILE, REC_LENGTH);
        rFile.prepareInputFile();
        try {

            //static login user
            EmployeeRecord test;
            String fname = "Chris";
            String lname = "Niesel";
            int number = 10001;
            Boolean manager = false;
            String pass = "test";

            test = new EmployeeRecord();
            test.setEmployeeNumber(number);
            test.setFirstName(fname);
            test.setLastName(lname);
            test.setManager(manager);
            test.setPassword(Encryption.makeHash(pass));
            rFile.writeNextRecord(test);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CreateRecords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CreateRecords.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
