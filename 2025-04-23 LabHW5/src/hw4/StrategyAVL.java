package hw4;

/** Confirmed actually runs in O(log(n)) time */
public class StrategyAVL<E extends Comparable<E>> extends StrategyBST<E>{
    /**
     * Adding an element to a tree is a subclass responsibility
     * Bottom-up balancing algorithm
     * @param elt the element to add
     * @param b   the tree to add it to (assume balanced)
     * @return a new tree with the element added
     */
    @Override
    public IBinTree<E> addElt(E elt, IBinTree<E> b) {
        IBinTree<E> newTree;
        if(b.isEmpty()){
            newTree = new BTNode<E>(elt,new BTEmpty<E>(), new BTEmpty<E>());
        }
        else if(elt.compareTo(b.getRoot()) < 0){
            newTree = new BTNode<E>(b.getRoot(),this.addElt(elt, b.getLeft()), b.getRight());
        }
        else {
            newTree = new BTNode<E>(b.getRoot(), b.getLeft(), this.addElt(elt, b.getRight()));
        }
        IBinTree<E> mt = new BTEmpty<>();
        // left-left rotation
        if(newTree.getLeft().height() == 2 && newTree.getLeft().getLeft().height() == 1 && newTree.getRight().height() == 0){
            return new BTNode<>(newTree.getLeft().getRoot(),
                                 newTree.getLeft().getLeft(), new BTNode<>(newTree.getRoot(),mt,mt));
        }
        // left-right rotation
        else if(newTree.getLeft().height() == 2 && newTree.getLeft().getRight().height() == 1 && newTree.getRight().height() == 0){
            return new BTNode<>(newTree.getLeft().getRight().getRoot(),
                    new BTNode<>(newTree.getLeft().getRoot(),mt,mt), new BTNode<>(newTree.getRoot(),mt,mt));
        }
        //right-right rotation
        else if(newTree.getRight().height() == 2 && newTree.getRight().getRight().height() == 1 && newTree.getLeft().height() == 0){
            return new BTNode<>(newTree.getRight().getRoot(),
                    new BTNode<>(newTree.getRoot(),mt,mt), newTree.getRight().getRight());
        }
        // right-left
        else if(newTree.getRight().height() == 2 && newTree.getRight().getLeft().height() == 1 && newTree.getLeft().height() == 0){
            return new BTNode<>(newTree.getRight().getLeft().getRoot(),
                    new BTNode<>(newTree.getRoot(),mt,mt), new BTNode<>(newTree.getRight().getRoot(),mt,mt));
        } //balanced by default
        else {
            return newTree;
        }
    }

    @Override
    public IBinTree<E> removeElt(E elt, IBinTree<E> b) {
        //https://www.geeksforgeeks.org/deletion-in-binary-search-tree/
        if(b.isEmpty()){
            return b;
        } else if(elt.compareTo(b.getRoot()) == 0){
            if(b.size() == 1){
                return new BTEmpty<>();
            } else if (b.size() == 2 && b.getLeft().size() == 1) {
                return b.getLeft();
            } else if(b.size() == 2 && b.getRight().size() == 1) {
                return b.getRight();
            } else {
                E leafElt = getMinVal(b.getRight());
                return new BTNode<>(leafElt,
                        b.getLeft(),
                        removeElt(leafElt, b.getRight()));
            }
        } else {
            //https://www.geeksforgeeks.org/deletion-in-an-avl-tree/
            IBinTree<E> newTree;
            if(elt.compareTo(b.getRoot()) < 0){
                newTree = new BTNode<E>(b.getRoot(),this.removeElt(elt, b.getLeft()), b.getRight());
            }
            else {
                newTree = new BTNode<E>(b.getRoot(), b.getLeft(), this.removeElt(elt, b.getRight()));
            }

            // left-left
            E x;
            E y;
            E z;
            IBinTree<E> t1;
            IBinTree<E> t2;
            IBinTree<E> t3;
            IBinTree<E> t4;
            int balance = Math.abs(newTree.getLeft().height() - newTree.getRight().height());
            if(balance > 1){
                z = newTree.getRoot();
                // left-left
                if(newTree.getLeft().height() > newTree.getRight().height() &&
                   newTree.getLeft().getLeft().height() > newTree.getLeft().getRight().height()){
                    y = newTree.getLeft().getRoot();
                    x = newTree.getLeft().getLeft().getRoot();
                    t1 = newTree.getLeft().getLeft().getLeft();
                    t2 = newTree.getLeft().getLeft().getRight();
                    t3 = newTree.getLeft().getRight();
                    t4 = newTree.getRight();
                    return new BTNode<>(y,
                            new BTNode<>(x,t1,t2),
                            new BTNode<>(z,t3,t4));
                } // left-right
                else if(newTree.getLeft().height() > newTree.getRight().height()){
                    y = newTree.getLeft().getRoot();
                    x = newTree.getLeft().getRight().getRoot();
                    t1 = newTree.getLeft().getLeft();
                    t2 = newTree.getLeft().getRight().getLeft();
                    t3 = newTree.getLeft().getRight().getRight();
                    t4 = newTree.getRight();
                    return new BTNode<>(x,
                            new BTNode<>(y,t1,t2),
                            new BTNode<>(z,t3,t4));
                } // right-right
                else if(newTree.getRight().height() > newTree.getLeft().height() &&
                        newTree.getRight().getRight().height() > newTree.getRight().getLeft().height()) {
                    y = newTree.getRight().getRoot();
                    x = newTree.getRight().getRight().getRoot();
                    t1 = newTree.getLeft();
                    t2 = newTree.getRight().getLeft();
                    t3 = newTree.getRight().getRight().getLeft();
                    t4 = newTree.getRight().getRight().getRight();
                    return new BTNode<>(y,
                            new BTNode<>(z,t1,t2),
                            new BTNode<>(x,t3,t4));
                } // right-left
                else if (newTree.getRight().height() > newTree.getLeft().height()){ // right-left
                    y = newTree.getRight().getRoot();
                    x = newTree.getRight().getLeft().getRoot();
                    t1 = newTree.getLeft();
                    t2 = newTree.getRight().getLeft().getLeft();
                    t3 = newTree.getRight().getLeft().getRight();
                    t4 = newTree.getRight().getRight();
                    return new BTNode<>(x,
                            new BTNode<>(z,t1,t2),
                            new BTNode<>(y,t3,t4));
                }
                 else {
                     throw new RuntimeException(newTree.toString());
                }
            } else {
                return newTree;
            }

        }

    }

    public E getMinVal(IBinTree<E> b){
        if(b.getLeft().isEmpty()){
            return b.getRoot();
        } else {
            return getMinVal(b.getLeft());
        }
    }
}
