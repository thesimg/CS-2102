public abstract class ValidatorHeapAbstract<E extends Comparable<E>> implements IBTValidator<E> {
    @Override
    public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return countElt(elt, newTree) == countElt(elt, oldTree) + 1
                && containsAll(oldTree, newTree)
                && newTree.size() == oldTree.size() + 1
                && heapInvariant(newTree);
    }

    @Override
    public boolean validRemove(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return countElt(elt, newTree) == countElt(elt, oldTree) - 1
                && containsAllAfterRemovingOne(oldTree, elt, newTree)
                && newTree.size() == oldTree.size() - 1
                && heapInvariant(newTree);
    }

    private int countElt(E elt, IBinTree<E> b) {
        if (b.isEmpty()) return 0;
        int count = b.getRoot().equals(elt) ? 1 : 0;
        return count + countElt(elt, b.getLeft()) + countElt(elt, b.getRight());
    }

    private boolean containsAll(IBinTree<E> subset, IBinTree<E> superset) {
        if (subset.isEmpty()) return true;
        return countElt(subset.getRoot(), superset) >= countElt(subset.getRoot(), subset)
                && containsAll(subset.getLeft(), superset)
                && containsAll(subset.getRight(), superset);
    }


    private boolean containsAllAfterRemovingOne(IBinTree<E> subset, E removedElt, IBinTree<E> superset) {
        if (subset.isEmpty()) return true;
        int expectedCount = countElt(subset.getRoot(), subset);
        if (subset.getRoot().equals(removedElt)) {
            expectedCount--;
        }
        return countElt(subset.getRoot(), superset) >= expectedCount
                && containsAllAfterRemovingOne(subset.getLeft(), removedElt, superset)
                && containsAllAfterRemovingOne(subset.getRight(), removedElt, superset);
    }

    private boolean heapInvariant(IBinTree<E> b) {
        if (b.isEmpty()) return true;
        return heapRespected(b.getRoot(), b.getLeft())
                && heapRespected(b.getRoot(), b.getRight())
                && heapInvariant(b.getLeft())
                && heapInvariant(b.getRight());
    }

    protected abstract boolean heapRespected(E parent, IBinTree<E> child);

}