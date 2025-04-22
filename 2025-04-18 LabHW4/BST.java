import java.util.Optional;
/**
 * a binary search tree implementation extending BinaryTree
 * with an efficient recursive search method based on BST invariants
 * @author graham simons
 */
public class BST<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * constructs a BST from a given IBinTree and sets the appropriate strategy and validator
     */
    public BST(IBinTree<E> data) {
        this.data = data;
        this.setStrategy(new StrategyBST<>());
        this.setValidator(new ValidatorBST<>());
    }

    /**
     * public search method for finding an element in the tree
     * @param key the element to search for
     * @return an Optional containing the element if found, otherwise empty
     */
    public Optional<E> search(E key) {
        return search(key, this.data);
    }

    /**
     * private helper for recursively searching the binary search tree
     */
    private Optional<E> search(E key, IBinTree<E> tree) {
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