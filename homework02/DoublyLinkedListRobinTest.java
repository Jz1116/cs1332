import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedListRobinTest {

    private static final int TIMEOUT = 200;
    private DoublyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        list.addAtIndex(0, "2a"); // 2a
        list.addAtIndex(0, "1a"); // 1a, 2a
        list.addAtIndex(2, "4a"); // 1a, 2a, 4a
        list.addAtIndex(2, "3a"); // 1a, 2a, 3a, 4a
        list.addAtIndex(0, "0a"); // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        String[] expected = new String[5];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = i + "a";
        }

        assertArrayEquals(expected, list.toArray());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        list.addToFront("4a"); // 4a
        list.addToFront("3a"); // 3a, 4a
        list.addToFront("2a"); // 2a, 3a, 4a
        list.addToFront("1a"); // 1a, 2a, 3a, 4a
        list.addToFront("0a"); // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        list.addToBack("0a"); // 0a
        list.addToBack("1a"); // 0a, 1a
        list.addToBack("2a"); // 0a, 1a, 2a
        list.addToBack("3a"); // 0a, 1a, 2a, 3a
        list.addToBack("4a"); // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex() {
        String temp = "5a";

        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a"); // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        assertSame(temp, list.removeAtIndex(5)); // 0a, 1a, 3a, 4a, 5a
        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        String temp = "0a";

        list.addAtIndex(0, temp); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a"); // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        assertSame(temp, list.removeFromFront()); // 1a, 2a, 3a, 4a, 5a
        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("1a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("5a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        String temp = "5a";

        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, temp); // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        assertEquals(temp, list.removeFromBack()); // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("0a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("1a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a

        assertEquals("0a", list.get(0));
        assertEquals("1a", list.get(1));
        assertEquals("2a", list.get(2));
        assertEquals("3a", list.get(3));
        assertEquals("4a", list.get(4));
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmptyAndClear() {
        // Should be empty at initialization
        assertTrue(list.isEmpty());

        // Should not be empty after adding elements
        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "3a"); // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a"); // 0a, 1a, 2a, 3a, 4a
        assertFalse(list.isEmpty());

        // Clearing the list should empty the array and reset size
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test(timeout = TIMEOUT)
    public void testLastOccurrence() {
        String temp = "0a";

        list.addAtIndex(0, "0a"); // 0a
        list.addAtIndex(1, "1a"); // 0a, 1a
        list.addAtIndex(2, "2a"); // 0a, 1a, 2a
        list.addAtIndex(3, "2a"); // 0a, 1a, 2a, 2a
        list.addAtIndex(4, "3a"); // 0a, 1a, 2a, 2a, 3a
        list.addAtIndex(5, "4a"); // 0a, 1a, 2a, 2a, 3a, 4a
        assertEquals(6, list.size());

        assertSame(temp, list.removeLastOccurrence("0a")); // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        DoublyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertNull(cur.getPrevious());
        assertEquals("1a", cur.getData());

        DoublyLinkedListNode<String> prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("2a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("3a", cur.getData());

        prev = cur;
        cur = cur.getNext();
        assertNotNull(cur);
        assertSame(prev, cur.getPrevious());
        assertEquals("4a", cur.getData());
        assertSame(list.getTail(), cur);

        cur = cur.getNext();
        assertNull(cur);
    }

    @Test(timeout = TIMEOUT)
    public void testToArray() {
        String[] expected = new String[5];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = i + "a";
            list.addAtIndex(i, expected[i]);
        }

        assertArrayEquals(expected, list.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException1() {
        list.addAtIndex(-1, "1a"); // 0a, 1a
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException2() {
        list.addAtIndex(1, "1a"); // 0a, 1a
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException1() {
        list.addAtIndex(0, null); // 0a, 1a
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException2() {
        list.addToFront(null); // 0a, 1a
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException3() {
        list.addToBack(null); // 0a, 1a
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException3() {
        list.addAtIndex(0, "1a");
        list.removeAtIndex(-1); // 0a, 1a
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException4() {
        list.addAtIndex(0, "1a");
        list.removeAtIndex(2); // 0a, 1a
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException1() {
        list.removeFromFront();
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException2() {
        list.removeFromBack();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException5() {
        list.addAtIndex(0, "1a");
        list.get(-1); // 0a, 1a
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException6() {
        list.addAtIndex(0, "1a");
        list.get(2); // 0a, 1a
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException4() {
        list.removeLastOccurrence(null); // 0a, 1a
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException3() {
        list.removeLastOccurrence("2a");
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException4() {
        list.addAtIndex(0,"2a");
        list.addAtIndex(1,"0a");
        list.removeLastOccurrence("1a");
    }
}