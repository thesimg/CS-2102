public class BTNode2<E> extends BTNode<E> {
    private final int cachedSize;

    public BTNode2(E data, IBinTree<E> left, IBinTree<E> right) {
        super(data, left, right);
        this.cachedSize = 1 + left.size() + right.size();
    }

    @Override
    public int size() {
        return this.cachedSize;
    }
}
