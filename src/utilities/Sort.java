package utilities;

/**
 *
 * @author nieschri125
 */
import datatstructures.*;

public class Sort {

    public static void bubble(int[] data) {
        int last = data.length - 1;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < last; j++) {
                if (data[j] > data[j + 1]) {
                    swapInt(data, j, j + 1);
                }
            }
            last--;

        }

    }

    public static void bubble(String[] data) {
        int last = data.length - 1;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < last; j++) {
                if ((data[j].compareTo(data[j + 1])) > 0) {
                    swapString(data, j, j + 1);
                }
            }
            last--;

        }


    }
    // sort Employee by lastName

    public static void bubbleLastname(EmployeeRecord[] data) {
        int last = data.length - 1;
        String temp1;
        String temp2;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < last; j++) {
                temp1 = data[j].getLastName();
                temp2 = data[j + 1].getLastName();

                if (temp1.compareTo(temp2) > 0) {
                    swapRecord(data, j, j + 1);
                }
            }
            last--;

        }

    }
    //sort Inventory by name

    public static void bubbleName(InventoryRecord[] data) {
        int last = data.length - 1;
        String temp1;
        String temp2;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < last; j++) {
                temp1 = data[j].getDescription();
                temp2 = data[j + 1].getDescription();

                if (temp1.compareTo(temp2) > 0) {
                    swapRecord(data, j, j + 1);
                }
            }
            last--;

        }

    }
    //sort employee record by their #

    public static void bubbleNumber(EmployeeRecord[] data) {
        int last = data.length - 1;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < last; j++) {
                if (data[j].getEmployeeNumber() > data[j + 1].getEmployeeNumber()) {
                    swapRecord(data, j, j + 1);
                }
            }
            last--;

        }

    }
    //sort inventory by item #

    public static void bubbleNumber(InventoryRecord[] data) {
        int last = data.length - 1;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < last; j++) {
                if (data[j].getNumber() > data[j + 1].getNumber()) {
                    swapRecord(data, j, j + 1);
                }
            }
            last--;

        }

    }
    //sort Inventory by price

    public static void bubblePrice(InventoryRecord[] data) {
        int last = data.length - 1;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < last; j++) {
                if (data[j].getPrice() > data[j + 1].getPrice()) {
                    swapRecord(data, j, j + 1);
                }
            }
            last--;

        }

    }

    public static void swapInt(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void swapString(String[] data, int i, int j) {
        String tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void swapRecord(EmployeeRecord[] data, int i, int j) {
        EmployeeRecord tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void swapRecord(InventoryRecord[] data, int i, int j) {
        InventoryRecord tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
