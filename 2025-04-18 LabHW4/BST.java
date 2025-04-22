import java.util.Optional;
public class BST<E extends Comparable<E>> extends BinaryTree<E> {

    public BST(IBinTree<E> data){
        this.data = data;
        this.setStrategy(new StrategyBST<>());
        this.setValidator(new ValidatorBST<>());
    }

    public Optional<E> search(E key){
        return search(key, this.data);
    }

    private Optional<E> search(E key, IBinTree<E> tree){
        // TODO
        if (tree.isEmpty()) {
            return Optional.empty();
        }

        int cmp = key.compareTo(tree.getRoot());
        if (cmp == 0) {
            return Optional.of(tree.getRoot());
        } else if (cmp < 0) {
            return search(key, tree.getLeft());
        } else {
            return search(key, tree.getRight());
        }
    }

}