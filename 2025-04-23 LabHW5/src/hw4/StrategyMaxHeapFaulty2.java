package hw4;

/**
 * An incorrect example max heap strategy for adding an int to an existing max heap
 */
public class StrategyMaxHeapFaulty2<E extends Comparable<E>> extends StrategyBTAbs<E> implements IBTStrategy<E> {
    @Override
    public BTNode<E> addElt(E elt, IBinTree<E> b) {
        if(b.isEmpty()){
            return new BTNode<E>(elt, new BTEmpty<E>(), new BTEmpty<E>());
        }
        else{
            if(elt.compareTo(b.getRoot()) < 0){
                return new BTNode<E>(b.getRoot(), new BTEmpty<E>(), new BTNode<E>(elt, b.getLeft(), b.getRight()));
            }
            else{
                return new BTNode<E>(elt, b.getLeft(), b.getRight());
            }
        }
    }
}
