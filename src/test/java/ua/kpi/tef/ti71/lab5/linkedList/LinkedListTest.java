package ua.kpi.tef.ti71.lab5.linkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ua.kpi.tef.ti71.lab5.linkedList.LinkedList;
import ua.kpi.tef.ti71.lab5.linkedList.List;

public class LinkedListTest {

    private List<Integer> intList = new LinkedList<>();

    @Test
    public void testAddIntoEmptyList() {
        intList.add(41);

        assertEquals(1, intList.size());
        assertEquals(41, intList.get(0).intValue());
    }

    @Test
    public void testGetFirstElementFromSingleElementList() {
        intList.add(25);

        int element = intList.get(0);

        assertEquals(25, element);
    }

    @Test
    public void testAddElements() {
        intList = LinkedList.of(43, 233, 54);

        assertEquals(3, intList.size());
        assertEquals(43, intList.get(0).intValue());
        assertEquals(233, intList.get(1).intValue());
        assertEquals(54, intList.get(2).intValue());
    }


    @Test
    public void testGetElements() {
        intList = LinkedList.of(25, 87, 45);

        int firstElement = intList.get(0);
        int secondElement = intList.get(1);
        int thirdElement = intList.get(2);

        assertEquals(25, firstElement);
        assertEquals(87, secondElement);
        assertEquals(45, thirdElement);
    }

    @Test
    public void testGetFirstElementFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.get(0));
    }

    @Test
    public void testGetElementByNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.get(-1));
    }

    @Test
    public void testGetElementByIndexEqualsToListSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            intList = LinkedList.of(33, 46, 25, 87, 45);
            intList.get(5);
        });
    }

    @Test
    public void testAddElementByZeroIndexIntoEmptyList() {
        intList.add(0, 45);

        assertEquals(1, intList.size());
        assertEquals(45, intList.get(0).intValue());
    }

    @Test
    public void testAddElementByIndexToTheEndOfList() {
        intList = LinkedList.of(98, 64, 23, 1, 3, 4);

        int newElementIndex = intList.size();
        intList.add(newElementIndex, 44);

        assertEquals(44, intList.get(newElementIndex).intValue());
        assertEquals(7, intList.size());
    }

    @Test
    public void testAddElementToTheHeadOfNonEmptyList() {
        intList = LinkedList.of(4, 6, 8, 9, 0, 2);

        intList.add(0, 53);

        assertEquals(53, intList.get(0).intValue());
        assertEquals(4, intList.get(1).intValue());
        assertEquals(7, intList.size());
    }

    @Test
    public void testAddElementByIndex() {
        intList = LinkedList.of(43, 5, 6, 8);

        int newElementIdx = 2;
        intList.add(newElementIdx, 66);

        assertEquals(66, intList.get(newElementIdx).intValue());
        assertEquals(43, intList.get(0).intValue());
        assertEquals(5, intList.get(1).intValue());
        assertEquals(6, intList.get(3).intValue());
        assertEquals(8, intList.get(4).intValue());
        assertEquals(5, intList.size());
    }

    @Test
    public void testAddElementByNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(-1, 66));
    }

    @Test
    public void testAddElementByIndexLargerThanListSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            intList = LinkedList.of(4, 6, 11, 9);

            int newElementIdx = 5;
            intList.add(newElementIdx, 88);
        });
    }

    @Test
    public void testAddElementByIndexEqualToSize() {
        intList = LinkedList.of(1, 2, 3, 4, 5); // size = 5

        intList.add(5, 111);

        assertEquals(6, intList.size());
        assertEquals(111, intList.get(5).intValue());
    }

    @Test
    public void testSetFirstElementOnEmptyTree() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.set(0, 34));
    }

    @Test
    public void testSetElementByIndexEqualToSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            intList = LinkedList.of(2, 3, 4); // size = 3

            intList.set(3, 222);
        });
    }

    @Test
    public void testSetElementByIndex() {
        intList = LinkedList.of(34, 78, 9, 8);

        int index = 2; //element = 78
        intList.set(index, 99);

        assertEquals(99, intList.get(index).intValue());
        assertEquals(34, intList.get(0).intValue());
        assertEquals(78, intList.get(1).intValue());
        assertEquals(8, intList.get(3).intValue());
        assertEquals(4, intList.size());

    }

    @Test
    public void testRemoveElementFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.remove(234));
    }

    @Test
    public void testRemoveFirstElement() {
        intList = LinkedList.of(4, 6, 8, 9);

        intList.remove(0);

        assertEquals(6, intList.get(0).intValue());
        assertEquals(3, intList.size());
    }

    @Test
    public void testRemoveLastElement() {
        intList = LinkedList.of(4, 6, 8, 9);

        intList.remove(intList.size() - 1);

        assertEquals(8, intList.get(intList.size() - 1).intValue());
        assertEquals(3, intList.size());
    }

    @Test
    public void testRemoveElement() {
        intList = LinkedList.of(1, 2, 3, 4, 5);

        int elementIndex = 2;
        intList.remove(elementIndex); // element = 3

        assertEquals(4, intList.get(elementIndex).intValue());
        assertEquals(4, intList.size());
    }

    @Test
    public void testContainsOnEmptyList() {
        boolean contains = intList.contains(34);

        assertFalse(contains);
    }

    @Test
    public void testContains() {
        intList = LinkedList.of(45, 6, 3, 6);

        boolean containsExistingElement = intList.contains(3);
        boolean containsNotExistingElement = intList.contains(54);

        assertTrue(containsExistingElement);
        assertFalse(containsNotExistingElement);
    }

    @Test
    public void testIsEmptyOnEmptyList() {
        boolean empty = intList.isEmpty();

        assertTrue(empty);
    }

    @Test
    public void testIsEmpty() {
        intList = LinkedList.of(34, 5, 6);

        boolean empty = intList.isEmpty();

        assertFalse(empty);
    }

    @Test
    public void testSizeOnEmptyList() {
        int size = intList.size();

        assertEquals(0, size);
    }

    @Test
    public void testSize() {
        intList = LinkedList.of(4, 7, 9, 0, 7);

        int size = intList.size();

        assertEquals(5, size);
    }

    @Test
    public void testClearOnEmptyList() {
        intList.clear();

        assertEquals(0, intList.size());
    }

    @Test
    public void testClearChangesTheSize() {
        intList = LinkedList.of(4, 5, 6);

        intList.clear();

        assertEquals(0, intList.size());
    }

    @Test
    public void testClearRemovesElements() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            intList = LinkedList.of(4, 5, 6);

            intList.clear();
            intList.get(0);
        });
    }


}
