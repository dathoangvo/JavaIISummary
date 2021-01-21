import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    int current_size;
    int max_size;
    boolean is_min_heap;
    Integer[] mainArray;

    public Heap() {
        is_min_heap = true;
        current_size = 0;
        max_size = 16;
        mainArray = new Integer[max_size];
    }

    public void add(int i) {
        if (current_size == max_size) expand();
        mainArray[current_size] = i;
        if (is_min_heap) {
            minHeapBalanceUp(current_size);
        } else {
            maxHeapBalanceUp(current_size);
        }

        current_size++;
    }

    private void minHeapBalanceUp(int index) {
        int parent = index / 2;
        if (mainArray[parent] > mainArray[index]) {
            int temp = mainArray[parent];
            mainArray[parent] = mainArray[index];
            mainArray[index] = temp;
            minHeapBalanceUp(parent);
        }
    }

    private void maxHeapBalanceUp(int index) {

    }

    private void expand() {
        Integer[] replacer = new Integer[max_size * 2];
        for (int i = 0; i < current_size; i++) {
            replacer[i] = mainArray[i];
        }
        mainArray = replacer;
        max_size *= 2;
    }

    public void remove() {
        mainArray[0] = mainArray[current_size - 1];
        mainArray[current_size - 1] = null;
        current_size--;
        minHeapBalanceDown(0);
    }

    private void minHeapBalanceDown(int index) {
        int left_node = index * 2;
        int right_node = index * 2 + 1;
        if (mainArray[left_node] != null && mainArray[right_node] != null) {
            if (mainArray[index] > mainArray[left_node] && mainArray[index] > mainArray[right_node]) {
                if (mainArray[left_node] < mainArray[right_node]) {
                    minHeapSwapDownLeft(index);
                } else {
                    minHeapSwapDownRight(index);
                }
            } else if (mainArray[left_node] < mainArray[index]) {
                minHeapSwapDownLeft(index);
            } else if (mainArray[right_node] < mainArray[index]) {
                minHeapSwapDownRight(index);
            }
        }
    }

    private void minHeapSwapDownLeft(int index) {
        int left_node = index * 2;
        int temp_data = mainArray[index];
        mainArray[index] = mainArray[left_node];
        mainArray[left_node] = temp_data;
        minHeapBalanceDown(left_node);
    }

    private void minHeapSwapDownRight(int index) {
        int right_node = index * 2 + 1;
        int temp_data = mainArray[index];
        mainArray[index] = mainArray[right_node];
        mainArray[right_node] = temp_data;
        minHeapBalanceDown(right_node);
    }

    private void maxHeapBalanceDown(int index) {

    }



    public boolean find(int value) {
        return false;
    }

    public int getSize() {return current_size;}

    public String toString() {
        int center = 100;
        int line_current = 0;
        int line_max = 1;
        String builder = "";
        for (int i = 0; i < current_size; i++) {
            if (line_current == line_max) {
                line_current = 0;
                line_max *= 2;
                builder += "\n";
            }
            line_current++;
            builder += "[" + mainArray[i] + "]";
        }
        return builder;
    }

    public String treeString() {
        Integer[] generate_node_location = new Integer[current_size];

        int backwards_halver = 1;
        while (backwards_halver * 2 <= current_size) {
            backwards_halver *= 2;
        }

        int current_traversal = backwards_halver - 1;
        // This chunk deals with generating the bottom line location.
        boolean is_first = true;
        while (mainArray[current_traversal] != null && current_traversal + 1 != backwards_halver * 2) {
            System.out.println(current_traversal);
            if (is_first) {
                generate_node_location[current_traversal] = 0;
                is_first = false;
            } else {
                generate_node_location[current_traversal] = generate_node_location[current_traversal - 1] + mainArray[current_traversal].toString().length() + 2;
            }
            current_traversal++;
        }
        System.out.println(Arrays.toString(generate_node_location));
        // Now generate the rest
        backwards_halver /= 2;
        current_traversal = backwards_halver - 1;
        System.out.println("2:" + current_traversal);
        while (backwards_halver > 0) {
            int left_node_index = current_traversal * 2;
            int right_node_index = current_traversal * 2 + 1;
            int average_distance_between_leftright_node = 0;
            if (mainArray[left_node_index] != null) {
                average_distance_between_leftright_node += generate_node_location[left_node_index];
                if (mainArray[right_node_index] != null) {
                    average_distance_between_leftright_node += generate_node_location[right_node_index];
                    average_distance_between_leftright_node /= 2;
                }
            }

            generate_node_location[current_traversal] = average_distance_between_leftright_node;
            backwards_halver /= 2;
            current_traversal = backwards_halver - 1;
        }

        System.out.println(Arrays.toString(generate_node_location));

        // now generate the string using location data.
        ArrayList<String> list_of_lines = new ArrayList<>();
        list_of_lines.add("");
        int current_cells_in_line = 0;
        int max_cell_in_line = 1;
        int current_line_being_developed = 0;

        String line_builder = "";

        for (int i = 0; i < current_size; i++) {
            if (current_cells_in_line == max_cell_in_line) {
                list_of_lines.add("");
                current_cells_in_line = 0;
                max_cell_in_line *= 2;
                current_line_being_developed++;
            }
            int half_length_of_current_index_string = (mainArray[i].toString().length() + 2) / 2;
            int spaces_to_add = generate_node_location[i] - half_length_of_current_index_string;
            if (i != max_cell_in_line - 1) {
                spaces_to_add -= generate_node_location[i - 1];
            }
            for (int s = 0; s < spaces_to_add; s++) {
                line_builder += " ";
            }
            line_builder += "[" + mainArray[i] + "]";
            list_of_lines.set(current_line_being_developed, line_builder);
            current_cells_in_line++;
        }
        String final_string = "";
        for (int i = 0; i < list_of_lines.size(); i++) {
            final_string += list_of_lines.get(i) + "\n";
        }
        return final_string;
    }
}
