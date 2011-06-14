/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InputOutput;
import datatstructures.EmployeeRecord;

/**
 *
 * @author nieschri125
 */
public interface DataFile {

    public String getNext();

    public void prepareInputFile();

    public void prepareOutputFile();

    public void writeNext(String field);

    public EmployeeRecord getNextRecord();

    public void writeNextRecord(EmployeeRecord record);

    public void close();
}// close interface 

