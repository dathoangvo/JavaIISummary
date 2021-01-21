import java.util.Arrays;
import java.util.Random;

/**
 * Class demonstrating the implementation of the Array List that holds integer data type.
 * @author Dat Vo
 * @version 1/19/2021
 */

public class ArrayList implements OrderedDSInterface{
    int[] mainArray;
    int size = 0;

    public ArrayList() {
        mainArray = new int[16];
    }

    /**
     * This method adds a random number between -100 and 100 at the given index. Only add when within proper bounds of
     * the Array list.
     * @param index represents where the number should be added.
     * @return the number that was added at the index.
     */
    public int addAtIndex(int index) {
        if (index > size) {
            System.out.println("Index out of bounds");
            return -1;
        }
        if (size == mainArray.length) {
            expand();
        }
        Random rand = new Random();
        int temp_data = rand.nextInt(201) - 100;

        for (int i = size; i > index; i--) {
            mainArray[i] = mainArray[i - 1];
        }
        mainArray[index] = temp_data;

        size++;
        return temp_data;
    }

    /**
     * This method doubles the max size of the Array list once it's full.
     */
    private void expand() {
        int[] tempArray = new int[mainArray.length * 2];
        for (int i = 0; i < mainArray.length; i++) {
            tempArray[i] = mainArray[i];
        }
        mainArray = tempArray;
    }

    /**
     * This method removes the data at the given index.
     * @param index represents the index being deleted.
     * @return the data value that was deleted.
     */
    public int removeAtIndex(int index) {
        if (index > size) {
            System.out.println("Index out of bounds");
            return -1;
        }
        int temp_data = mainArray[index];
        while (index < size) {
            mainArray[index] = mainArray[index + 1];
            index++;
        }
        size--;
        return temp_data;
    }

    /**
     * This method finds which index holds a given value.
     * @param int_to_find represents the value being searched for.
     * @return a list of all the index holding the given value.
     */
    @Override
    public String find(int int_to_find) {
        String builder = "";
        for (int i = 0; i < size; i++) {
            if (mainArray[i] == int_to_find) {
                builder += i + " ";
            }
        }
        return builder;
    }

    /**
     * This method gets the value at a given index.
     * @param index_to_get represents the index we are getting the value of.
     * @return a string of the value at the given index.
     */
    @Override
    public String get(int index_to_get) {
        if (index_to_get < size && index_to_get >= 0) {
            return mainArray[index_to_get] + "";
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * This method resets the Array List to as if it was first initialized.
     */
    @Override
    public void clear() {
        mainArray = new int[16];
        size = 0;
    }

    /**
     * @return the amount of numbers stored in the array list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * This method sorts the Array list using the insertion sort algorithm.
     */
    @Override
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            int current = i;
            while (current > 0 && mainArray[current] < mainArray[current - 1]) {
                int temp_data = mainArray[current];
                mainArray[current] = mainArray[current - 1];
                mainArray[current - 1] = temp_data;
                current--;
            }
        }
    }

    /**
     * This method sorts the Array list using the merge sort algorithm. Also acts as the helper method for the recursive
     * merge sort method.
     */
    @Override
    public void mergesort() {
        if (size > 2) {
            int middle = size / 2;
            int[] left_array = new int[middle];
            int[] right_array = new int[size - middle];

            for (int i = 0; i < middle; i++) {
                left_array[i] = mainArray[i];
                right_array[i] = mainArray[i + middle];
            }
            if (size % 2 != 0) {
                right_array[right_array.length - 1] = mainArray[size - 1];
            }

            int[] temp_array = mergesort(left_array, right_array);

            System.out.println(Arrays.toString(temp_array));

            for (int i = 0; i < size; i++) {
                mainArray[i] = temp_array[i];
            }
        }
    }

    /**
     * Recursive merge sort method. Merges the left and right array together after sorting them each.
     * @param left_array represents the left array being merged.
     * @param right_array represents the right array being merged.
     * @return a sorted merged version of the left_array and right_array.
     */
    private int[] mergesort(int[] left_array, int[] right_array) {
        if (left_array.length > 1) {
            int middle = left_array.length / 2;
            int[] temp_left_array = new int[middle];
            int[] temp_right_array = new int[left_array.length - middle];

            for (int i = 0; i < middle; i++) {
                temp_left_array[i] = left_array[i];
                temp_right_array[i] = left_array[i + middle];
            }
            if (left_array.length % 2 != 0) {
                temp_right_array[temp_right_array.length - 1] = left_array[left_array.length - 1];
            }
            left_array = mergesort(temp_left_array, temp_right_array);
        }

        if (right_array.length > 1) {
            int middle = right_array.length / 2;
            int[] temp_left_array = new int[middle];
            int[] temp_right_array = new int[right_array.length - middle];

            for (int i = 0; i < middle; i++) {
                temp_left_array[i] = right_array[i];
                temp_right_array[i] = right_array[i + middle];
            }
            if (right_array.length % 2 != 0) {
                temp_right_array[temp_right_array.length - 1] = right_array[right_array.length - 1];
            }
            right_array = mergesort(temp_left_array, temp_right_array);
        }

        return merge(left_array, right_array);
    }

    /**
     * This method merges the two given array together in ascending order.
     * @param left_array represents one of the array being merged and sorted.
     * @param right_array represents the other array being merged and sorted.
     * @return a merged and sorted version of the left_array and right_array.
     */
    private int[] merge(int[] left_array, int[] right_array) {
        int[] return_array = new int[left_array.length + right_array.length];
        int return_traversal = 0;
        int left_traversal = 0;
        int right_traversal = 0;
        while (left_traversal < left_array.length && right_traversal < right_array.length) {
            if (left_array[left_traversal] < right_array[right_traversal]) {
                return_array[return_traversal] = left_array[left_traversal];
                left_traversal++;
            } else {
                return_array[return_traversal] = right_array[right_traversal];
                right_traversal++;
            }
            return_traversal++;
        }

        while (left_traversal < left_array.length) {
            return_array[return_traversal] = left_array[left_traversal];
            left_traversal++;
            return_traversal++;
        }

        while (right_traversal < right_array.length) {
            return_array[return_traversal] = right_array[right_traversal];
            right_traversal++;
            return_traversal++;
        }
        return return_array;
    }

    /**
     * This method reverses the order of the entire Array list.
     */
    @Override
    public void reverse() {
        int[] reversed_array = new int[mainArray.length];
        int counter = 0;
        for (int i = size - 1; i >= 0; i--) {
            reversed_array[counter] = mainArray[i];
            counter++;
        }
        mainArray = reversed_array;
    }


    /**
     * @return a string representation of the Array List.
     */
    public String toString() {
        String builder = "";
        for (int i = 0; i < size; i++) {
            builder += "[" + mainArray[i] + "]";
        }
        return builder;
    }

}
