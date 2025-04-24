package hw4;

/**
 * An example max heap strategy for adding an int to an existing max heap
 */
public class StrategyMaxHeap<E extends Comparable<E>> extends StrategyBTAbs<E> implements IBTStrategy<E> {
    @Override
    public BTNode<E> addElt(E elt, IBinTree<E> b) {
        if(b.isEmpty()){
            return new BTNode<E>(elt, new BTEmpty<E>(), new BTEmpty<E>());
        }
        else{
            E newRoot;
            E pushDown;
            if(elt.compareTo(b.getRoot()) <= 0){
                newRoot = b.getRoot();
                pushDown = elt;
            }
            else{
                newRoot = elt;
                pushDown = b.getRoot();
            }
            if(b.getLeft().height() > b.getRight().height()){
                return new BTNode<>(newRoot, b.getLeft(), addElt(pushDown, b.getRight()));
            } else {
                return new BTNode<>(newRoot, addElt(pushDown, b.getLeft()), b.getRight());
            }
        }
    }



    @Override
    public IBinTree<E> removeElt(E elt, IBinTree<E> b) {
        if(b.isEmpty()){
            return b;
        } else if(elt.compareTo(b.getRoot()) == 0 && b.size() == 1){
            return new BTEmpty<>();
        } else if(elt.compareTo(b.getRoot()) == 0 && b.getLeft().isEmpty()){
            return b.getRight();
        } else if(elt.compareTo(b.getRoot()) == 0 && b.getRight().isEmpty()){
            return b.getLeft();
        } else if(elt.compareTo(b.getRoot()) == 0 && b.getLeft().getRoot().compareTo(b.getRight().getRoot()) >= 0){
            return new BTNode<>(b.getLeft().getRoot(),
                                removeElt(b.getLeft().getRoot(),b.getLeft()),
                                b.getRight());
        } else if(elt.compareTo(b.getRoot()) == 0 && b.getRight().getRoot().compareTo(b.getLeft().getRoot()) >= 0){
            return new BTNode<>(b.getRight().getRoot(),
                                b.getLeft(),
                                removeElt(b.getRight().getRoot(), b.getRight()));
        } else {
            IBinTree<E> newLeft = removeElt(elt, b.getLeft());
            IBinTree<E> newRight = b.getRight();
            if(newLeft.size() == b.getLeft().size()){ //wasn't removed from left
                newRight = removeElt(elt, b.getRight()); //remove from right
            }
            return new BTNode<>(b.getRoot(), newLeft, newRight);
        }
    }
}
