package utilities;

import datatstructures.EmployeeRecord;

/**
 *
 * @author nieschri125
 */
public class Search {

    public static int binarySearch(int[] data, int key) {
        int length = data.length;
        int bottom = 0;
        int top = length - 1;
        int middle;
        boolean found = false;
        while ((bottom <= top) && (found == false)) {
            middle = (top + bottom) / 2;
            if (data[middle] == key) {
                return middle;
            } else {
                if (data[middle] > key) {
                    top = middle - 1;
                } else {
                    bottom = middle + 1;
                }

            }
        }

        return -1;
    }

    public static int binarySearch(String[] data, String key) {
        int length = data.length;
        int bottom = 0;
        int top = length - 1;
        int middle;
        boolean found = false;
        while ((bottom <= top) && (found == false)) {
            middle = (top + bottom) / 2;
            if (data[middle].equals(key)) {
                return middle;
            } else {
                if (data[middle].compareTo(key) > 0) {
                    top = middle - 1;
                } else {
                    bottom = middle + 1;
                }

            }
        }

        return -1;
    }

    /* 
     * find employee by lastname
     * requires EmployeeRecord array
     * 
     */
    public static int binarySearch(EmployeeRecord[] data, String keyLastName) {
        int length = data.length;
        int bottom = 0;
        int top = length - 1;
        int middle;
        boolean found = false;
        String temp;

        while ((bottom <= top) && (found == false)) {
            middle = (top + bottom) / 2;
            temp = data[middle].getLastName();
            if (temp.equals(keyLastName)) {
                return middle;
            } else {
                temp = data[middle].getLastName();
                if (temp.compareTo(keyLastName) > 0) {
                    top = middle - 1;
                } else {
                    bottom = middle + 1;
                }

            }


        }
        return -1;

    }

    /* 
     * find employee by number
     * requires EmployeeRecord array
     * 
     */
    public static int binarySearch(EmployeeRecord[] data, int keyEmployeeNumber) {
        int length = data.length;
        int bottom = 0;
        int top = length - 1;
        int middle;
        boolean found = false;
        while ((bottom <= top) && (found == false)) {
            middle = (top + bottom) / 2;
            if (data[middle].getEmployeeNumber() == keyEmployeeNumber) {
                return middle;
            } else {
                if (data[middle].getEmployeeNumber() > keyEmployeeNumber) {
                    top = middle - 1;
                } else {
                    bottom = middle + 1;
                }

            }
        }

        return -1;
    }
}
