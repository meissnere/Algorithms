package techQuestions;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

//Given the array orders, which represents the orders that customers have done in a restaurant.
//        More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is
//        the name of the customer, tableNumberi is the table customer sit at, and foodItemi is the
//        item customer orders.
//
//        Return the restaurant's “display table”. The “display table” is a table whose row entries
//        denote how many of each food item each table ordered. The first column is the table number
//        and the remaining columns correspond to each food item in alphabetical order. The first row
//        should be a header whose first column is “Table”, followed by the names of the food items.
//        Note that the customer names are not part of the table. Additionally, the rows should be
//        sorted in numerically increasing order.
public class DisplayTableFood {
    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<List<String>>();
        List<String> table = new ArrayList<>();
//        table.add();
//        input.add();
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<List<String>>;
        List<String> header = new ArrayList<String>;
        header.add("Table");
        header.add("Beef Burrito");
        header.add("Ceviche");
        header.add("Fried Chicken");
        header.add("Water");
        for (int i = 0; i < orders.size(); i++) {
            int ceviche = 0;
            int burrito = 0;
            int fried_chicken = 0;
            int water = 0;
            List<String> table = new ArrayList<>();
            table.add();
        }
    }
}
