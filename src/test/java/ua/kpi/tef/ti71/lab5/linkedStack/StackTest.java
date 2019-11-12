package ua.kpi.tef.ti71.lab5.linkedStack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ua.kpi.tef.ti71.lab5.linkedStack.LinkedStack;
import ua.kpi.tef.ti71.lab5.linkedStack.Stack;

public class StackTest {
	private Stack<Integer> intStack = new LinkedStack<>();

	@Test
	public void testPushElementOntoEmptyStack() {
		intStack.push(234);
	}

	@Test
	public void testPopElementFromEmptyStack() {
		assertThrows(EmptyStackException.class, () -> intStack.pop());
	}

	@Test
	public void testPushElements() {
		intStack.push(23);
		intStack.push(35);
		intStack.push(72);

		intStack.push(55);

		assertEquals(intStack.pop(), 55);
	}

	@Test
	public void testPopElements() {
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		intStack.pop();
		intStack.push(234);
		Integer lastElement = intStack.pop();

		assertEquals(lastElement, 234);
	}

	@Test
	public void testSize(){
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		int actualSize = intStack.size();

		assertEquals(actualSize, 3);
	}

	@Test
	public void testSizeOnEmptyStack(){
		int actualSize = intStack.size();

		assertEquals(actualSize, 0);
	}

	@Test
	public void testIsEmpty(){
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		boolean stackEmpty = intStack.isEmpty();

		assertFalse(stackEmpty);
	}

	@Test
	public void testIsEmptyOnEmptyStack(){
		boolean stackEmpty = intStack.isEmpty();

		assertTrue(stackEmpty);
	}
}
