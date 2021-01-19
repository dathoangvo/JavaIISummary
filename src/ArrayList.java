import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;

public class ArrayList implements OrderedDSInterface{
    int[] mainArray;
    int size = 0;

    public ArrayList() {
        mainArray = new int[16];
    }

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

    private void expand() {
        int[] tempArray = new int[mainArray.length * 2];
        for (int i = 0; i < mainArray.length; i++) {
            tempArray[i] = mainArray[i];
        }
        mainArray = tempArray;
    }

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

    @Override
    public String get(int index_to_get) {
        if (index_to_get < size && index_to_get >= 0) {
            return mainArray[index_to_get] + "";
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public void clear() {
        mainArray = new int[16];
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

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


    public String toString() {
        String builder = "";
        for (int i = 0; i < size; i++) {
            builder += "[" + mainArray[i] + "]";
        }
        return builder;
    }

}
