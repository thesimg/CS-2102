package hw4;

/** A Candidate AVL Strategy (Prof. Ahrens is unsure if it is even correct or will always terminate */
public class StrategyAVL<E extends Comparable<E>> extends StrategyBST<E>{
    /**
     * Adding an element to a tree is a subclass responsibility
     *
     * @param elt the element to add
     * @param b   the tree to add it to
     * @return a new tree with the element added
     */
    @Override
    public IBinTree<E> addElt(E elt, IBinTree<E> b) {
        IBinTree<E> newTree = super.addElt(elt, b);
        if(newTree.getLeft().height() - newTree.getRight().height() > 1){
            IBinTree<E> newChildren = this.merge(newTree.getLeft(), newTree.getRight());
            return this.addElt(newTree.getRoot(),newChildren);
        }
        else if(newTree.getRight().height() - newTree.getLeft().height() > 1){
            IBinTree<E> newChildren = this.merge(newTree.getRight(), newTree.getLeft());
            return this.addElt(newTree.getRoot(),newChildren);
        }
        else {
            return newTree;
        }
    }
}
