/**
 * Name: InPlaceIntHeapSort.java
 * <p>
 * Description: Class for in place heap sort
 * 
 * @author Will St. Onge
 */

public class InPlaceIntHeapSort {
	/**
	 * Sorts an array of integers using an in-place heap sort. Complexity = O(nlogn)
	 * 
	 * @param array
	 *            Array of integers to be sorted (input and output)
	 */
	public static void heapSort(int[] array) {
		heapify(array, array.length);

		for (int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			siftDown(array, 0, i - 1);
		}
	}

	/**
	 * Heapifies an array of integers
	 * 
	 * @param array
	 *            Array of integers to be heapified
	 * @param length
	 *            Length of the array
	 */
	private static void heapify(int[] array, int length) {
		// Gets parent index of last element
		int start = getParentIndex(length - 1);

		// Sift everything down that is not in the bottom row
		while (start >= 0) {
			siftDown(array, start, length - 1);
			start--;
		}
	}

	/**
	 * Sifts the array[index] element down to the end
	 * 
	 * @param array
	 *            Array in which element will be sifted down
	 * @param start
	 *            Index of element that will be sifted down
	 * @param end
	 *            End point for element to be sifted down to
	 */
	private static void siftDown(int[] array, int start, int end) {
		int child, swap, root = start;

		// This decides if we return or swap 2 elements in the heap
		while ((child = getLeftChildIndex(root)) <= end) {
			swap = root;

			if (array[swap] < array[child])
				swap = child;
			if (child + 1 <= end && array[swap] < array[child + 1])
				swap = child + 1;
			if (swap == root)
				return;
			else {
				swap(array, swap, root);
				root = swap;
			}
		}
	}

	/**
	 * Gets parent of the index
	 * 
	 * @param index
	 *            Index of child node we want the parent of. An index of '0' will
	 *            throw a RuntimeException
	 */
	private static int getParentIndex(int index) {
		if (!(index == 0))
			return (index - 1) / 2;
		else
			throw new RuntimeException("Root node does not have a parent");
	}

	/**
	 * Get the left hand child of the index
	 * 
	 * @param index
	 *            Index of parent node we want the left child of
	 */
	private static int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}
	
	/**
	 * Swaps items at index a and b in the array
	 * 
	 * @param array
	 *            Array where elements are stored
	 * @param a
	 *            First element
	 * @param b
	 *            Second element
	 */
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}