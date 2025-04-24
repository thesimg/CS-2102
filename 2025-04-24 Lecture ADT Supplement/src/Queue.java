public interface Queue<T> {

    void enqueue(T elem);

    T dequeue();

    T peek();

    int size();

    void transferAllTo(Queue<T> other);
}
