import java.util.Arrays;
import java.util.Formatter;

/**
 * Created by Dmitriy on 13.01.2020.
 */
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int width = 7;

    private String[] controlWidth(int w) {
        return new String[]{"%-" + w * 3 + "s %" + w + "s %" + w * 2 + "s\n",
                "%-" + w * 3 + "." + w * 3 + "s %" + w + "d %" + w * 2 + ".2f\n",
                "%-" + w * 3 + "s %" + w + "s %" + w * 2 + ".2f\n"};
    }

    public void printTitle() {
        f.format(controlWidth(width)[0], "Item", "Qty", "Price");
        f.format(controlWidth(width)[0], "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(controlWidth(width)[1], name,qty, price);
        total +=price;
    }

    public void printTotal() {
        f.format(controlWidth(width)[2], "Tax", "", total*0.06);
        f.format(controlWidth(width)[0], "", "", "-----");
        f.format(controlWidth(width)[2], "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
