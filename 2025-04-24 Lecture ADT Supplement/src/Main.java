import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Deli d = new Deli();
        List<Customer> helped = new LinkedList<>();
        for(int i = 0; i < 100; i++){
            Random r = new Random();
            if(r.nextBoolean()){
                d.takeOrder(new Customer(String.format("Customer #%d",i),
                                         r.nextInt(10000),
                                         r.nextInt(10)));
            } else {
                helped.addAll(d.runShift());
            }
        }
        System.out.println("done!");
    }
}