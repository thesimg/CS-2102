/**
 * a validator for AVL trees: ensures BST invariant and height balance.
 * @author graham simons
 */
class ValidatorAVL<E extends Comparable<E>> extends ValidatorBST<E> {
    @Override
    public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return super.validAdd(oldTree, elt, newTree) && balanced(newTree);
    }

    @Override
    public boolean validRemove(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return super.validRemove(oldTree, elt, newTree) && balanced(newTree);
    }

    private int height(IBinTree<E> b) {
        if (b.isEmpty()) return 0;
        return 1 + Math.max(height(b.getLeft()), height(b.getRight()));
    }

    private boolean balanced(IBinTree<E> b) {
        if (b.isEmpty()) return true;
        int lh = height(b.getLeft());
        int rh = height(b.getRight());
        return Math.abs(lh - rh) <= 1 && balanced(b.getLeft()) && balanced(b.getRight());
    }
}
