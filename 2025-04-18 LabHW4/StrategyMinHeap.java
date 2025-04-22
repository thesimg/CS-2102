class StrategyMinHeap<E extends Comparable<E>> extends StrategyBTAbs<E> implements IBTStrategy<E> {
    @Override
    public IBinTree<E> addElt(E elt, IBinTree<E> b) {
        if (b.isEmpty()) {
            return new BTNode<>(elt, new BTEmpty<>(), new BTEmpty<>());
        } else if (elt.compareTo(b.getRoot()) < 0) {
            return new BTNode<>(elt, b.getLeft(), addElt(b.getRoot(), b.getRight()));
        } else {
            return new BTNode<>(b.getRoot(), b.getLeft(), addElt(elt, b.getRight()));
        }
    }
}