package datatstructures;

/**
 *
 * @author Chris
 * @version 0.1
 */
public class InventoryRecord extends Record {

    private int quantity;
    private String description;
    private long number;
    private double cost;
    private double price;

    public InventoryRecord(int quant, String descrip, long num, double acost, double aprice) {
        quantity = quant;
        description = descrip;
        number = num;
        cost = acost;
        price = aprice;

    }

    public InventoryRecord() {
        quantity = 0;
        description = "";
        number = 0;
        cost = 0;
        price = 0;
    }

    public String getRecord() {
        return (Integer.toString(quantity) + " " + description + " " + Long.toString(number) + " " + Double.toString(cost) + " " + Double.toString(price));
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public long getNumber() {
        return number;
    }

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return price;
    }

    public void setNull() {
        quantity = -1;
        description = "";
        number = -1;
        cost = -1;
        price = -1;
    }

    public void setQuantity(int n) {
        quantity = n;
    }

    public void setDescription(String x) {
        description = x;
    }

    public void setNumber(long n) {
        number = n;
    }

    public void setCost(double n) {
        cost = n;
    }

    public void setPrice(double n) {
        price = n;
    }
}
