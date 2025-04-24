import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
public class Deli {

    List<Customer> customers = new ArrayList<Customer>();
    int workers = 3;

    /**
     * Take a customer, increasing the workforce if we get busy
     * @param customer
     */
    public void takeOrder(Customer customer) {
        customers.add(customer);
        if(customers.size() >= 2 * workers) {
            workers++;
        }
    }

    /**
     * have all the works help whoever's next in line
     * @return
     */
    List<Customer> runShift(){
        List<Customer> helped = new LinkedList<>();
        for(int i = 0; i < workers; i++){
            Customer toHelp = customers.remove(0);
            toHelp.help(10);
            helped.add(toHelp);
        }
        return helped;

    }

//    public void swapQueue(Supplier<Queue<Customer>> queueConstructor) {
//        Queue<Customer> queue = queueConstructor.get();
//        this.customers.transferAllTo(queue);
//        this.customers = queue;
//    }
}
