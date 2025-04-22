import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class Examples {

    /// min heap

    @Test
    public void testValidAddMinHeapTrue() {
        IBinTree<Integer> oldTree = new BTNode<>(3, new BTEmpty<>(), new BTEmpty<>());
        IBinTree<Integer> newTree = new BTNode<>(3, new BTNode<>(5, new BTEmpty<>(), new BTEmpty<>()), new BTEmpty<>());
        IBTValidator<Integer> validator = new ValidatorMinHeap<>();
        assertTrue(validator.validAdd(oldTree, 5, newTree));
    }

    @Test
    public void testValidAddMinHeapFalse() {
        IBinTree<Integer> oldTree = new BTNode<>(3, new BTEmpty<>(), new BTEmpty<>());
        IBinTree<Integer> newTree = new BTNode<>(5, new BTNode<>(3, new BTEmpty<>(), new BTEmpty<>()), new BTEmpty<>());
        IBTValidator<Integer> validator = new ValidatorMinHeap<>();
        assertFalse(validator.validAdd(oldTree, 5, newTree)); // breaks min heap invariant
    }

    @Test
    public void testValidRemoveMinHeapTrue() {
        IBinTree<Integer> oldTree = new BTNode<>(2,
                new BTNode<>(5, new BTEmpty<>(), new BTEmpty<>()),
                new BTNode<>(8, new BTEmpty<>(), new BTEmpty<>())
        );
        IBinTree<Integer> newTree = new BTNode<>(2, new BTEmpty<>(), new BTNode<>(8, new BTEmpty<>(), new BTEmpty<>()));
        IBTValidator<Integer> validator = new ValidatorMinHeap<>();
        assertTrue(validator.validRemove(oldTree, 5, newTree));
    }

    @Test
    public void testValidRemoveMinHeapFalse() {
        IBinTree<Integer> oldTree = new BTNode<>(2, new BTEmpty<>(), new BTEmpty<>());
        IBinTree<Integer> newTree = new BTEmpty<>();
        IBTValidator<Integer> validator = new ValidatorMinHeap<>();
        assertFalse(validator.validRemove(oldTree, 5, newTree)); // elt not in tree
    }

    /// max heap

    @Test
    public void testValidAddMaxHeapTrue() {
        IBinTree<Integer> oldTree = new BTNode<>(10, new BTEmpty<>(), new BTEmpty<>());
        IBinTree<Integer> newTree = new BTNode<>(10, new BTNode<>(5, new BTEmpty<>(), new BTEmpty<>()), new BTEmpty<>());
        IBTValidator<Integer> validator = new ValidatorMaxHeap<>();
        assertTrue(validator.validAdd(oldTree, 5, newTree));
    }

    @Test
    public void testValidAddMaxHeapFalse() {
        IBinTree<Integer> oldTree = new BTNode<>(5, new BTEmpty<>(), new BTEmpty<>());
        IBinTree<Integer> newTree = new BTNode<>(3, new BTNode<>(5, new BTEmpty<>(), new BTEmpty<>()), new BTEmpty<>());
        IBTValidator<Integer> validator = new ValidatorMaxHeap<>();
        assertFalse(validator.validAdd(oldTree, 3, newTree)); // breaks max heap invariant
    }

    @Test
    public void testValidRemoveMaxHeapTrue() {
        IBinTree<Integer> oldTree = new BTNode<>(10,
                new BTNode<>(6, new BTEmpty<>(), new BTEmpty<>()),
                new BTNode<>(5, new BTEmpty<>(), new BTEmpty<>())
        );
        IBinTree<Integer> newTree = new BTNode<>(10, new BTEmpty<>(), new BTNode<>(5, new BTEmpty<>(), new BTEmpty<>()));
        IBTValidator<Integer> validator = new ValidatorMaxHeap<>();
        assertTrue(validator.validRemove(oldTree, 6, newTree));
    }

    @Test
    public void testValidRemoveMaxHeapFalse() {
        IBinTree<Integer> oldTree = new BTNode<>(7, new BTEmpty<>(), new BTEmpty<>());
        IBinTree<Integer> newTree = new BTEmpty<>();
        IBTValidator<Integer> validator = new ValidatorMaxHeap<>();
        assertFalse(validator.validRemove(oldTree, 3, newTree)); // elt not in tree
    }
    
    
    ///  bst search tests
    @Test
    public void testSearchFound() {
        BST<String> bst = new BST<>(new BTEmpty<String>());
        bst.addElt("test1");
        bst.addElt("test2");
        bst.addElt("test3");
        bst.addElt("test4");

        // these would fail until BST.search is implemented
        assertEquals(Optional.of("test2"), bst.search("test2"));
        assertEquals(Optional.of("test4"), bst.search("test4"));
        assertEquals(Optional.of("test3"), bst.search("test3"));
    }

    @Test
    public void testSearchNotFound() {
        BST<String> bst = new BST<>(new BTEmpty<String>());
        bst.addElt("test1");
        bst.addElt("test2");
        bst.addElt("test3");
        bst.addElt("test4");

        // These should pass even with the stubbed search (since it always returns empty)
        assertEquals(Optional.empty(), bst.search("jerry"));
        assertEquals(Optional.empty(), bst.search("tom"));
    }
}