package hw4;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> b = new BinaryTree<>();
        b.setStrategy(new StrategyMaxHeap<>());
        for(int i = 1; i <= 30; i++){
            b.addElt(i);
        }
        System.out.println("done");
        for(int i = 1; i <= 30; i+= 2){
            b.removeElt(i);
        }
        System.out.println("done");
    }

}
