public class ValidatorMaxHeap<E extends Comparable<E>> extends ValidatorHeapAbstract<E> {
    @Override
    protected boolean heapRespected(E parent, IBinTree<E> child) {
        return child.isEmpty() || parent.compareTo(child.getRoot()) >= 0;
    }
}