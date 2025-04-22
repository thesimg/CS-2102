import java.util.Optional;
public class BST<E extends Comparable<E>> extends BinaryTree<E> {

    public BST(IBinTree<E> data){
        this.data = data;
        this.setStrategy(new StrategyBST<>());
        this.setValidator(new ValidatorBST<>());
    }

    public Optional<E> search(E key){
        return Optional.empty(); //stub, replace me
    }

    private Optional<E> search(E key, IBinTree<E> someTree){
        // TODO
        return Optional.empty(); //stub, replace me        
    }

}