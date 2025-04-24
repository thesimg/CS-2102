import hw4.BinaryTree;
import hw4.IBinTree;
import hw4.StrategyMaxHeap;

public class PriorityQueue extends BinaryTree<Customer> implements Queue<Customer> {
    public PriorityQueue() {
        super();
        this.setStrategy(new StrategyMaxHeap());

    }

    @Override
    public void enqueue(Customer elem) {
        this.addElt(elem);
    }

    @Override
    public Customer dequeue() {
        Customer richestAndOldest = this.data.getRoot();
        this.removeElt(richestAndOldest);
        return richestAndOldest;
    }

    @Override
    public Customer peek() {
        return this.data.getRoot();
    }

    @Override
    public void transferAllTo(Queue<Customer> other) {
        this.transferAllTo(other, this.data);
    }

    private void transferAllTo(Queue<Customer> other, IBinTree<Customer> tree) {
        if(!tree.isEmpty()){
            other.enqueue(tree.getRoot());
            transferAllTo(other, tree.getLeft());
            transferAllTo(other, tree.getRight());
        }
    }
}
