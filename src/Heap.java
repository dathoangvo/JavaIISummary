import java.util.ArrayList;

public class Heap {
    int current_index;
    int max_size;
    boolean is_min_heap;
    Integer[] mainArray;

    public Heap() {
        current_index = 1;
        max_size = 16;
        is_min_heap = true;
        mainArray = new Integer[max_size];
    }

    public int getSize() {return current_index - 1;}

    public void toggleMin() {
        if (!is_min_heap) {
            is_min_heap = true;
            clear();
        }
    }

    public void toggleMax() {
        if (is_min_heap) {
            is_min_heap = false;
            clear();
        }
    }

    public void add(int i) {
        if (current_index <= 31) {
            if (current_index * 3 >= max_size) expand();
            mainArray[current_index] = i;
            if (is_min_heap) minHeapSiftUp(current_index);
            else maxHeapSiftUp(current_index);
            current_index++;
        }
    }

    private void expand() {
        Integer[] replacer = new Integer[max_size * 2];
        for (int i = 1; i < current_index; i++) { replacer[i] = mainArray[i]; }
        mainArray = replacer;
        max_size *= 2;
    }

    private void minHeapSiftUp(int index) {
        int parent = index / 2;
        if (parent > 0 && mainArray[parent] > mainArray[index]) {
            int temp = mainArray[parent];
            mainArray[parent] = mainArray[index];
            mainArray[index] = temp;
            minHeapSiftUp(parent);
        }
    }

    private void maxHeapSiftUp(int index) {
        int parent = index / 2;
        if (parent > 0 && mainArray[parent] < mainArray[index]) {
            int temp = mainArray[parent];
            mainArray[parent] = mainArray[index];
            mainArray[index] = temp;
            maxHeapSiftUp(parent);
        }
    }

    public void remove() {
        if (current_index > 2) {
            mainArray[1] = mainArray[current_index - 1];
            if (is_min_heap) {
                current_index--;
                mainArray[current_index] = null;
                minHeapSiftDown(1);
            } else {
                current_index--;
                mainArray[current_index] = null;
                maxHeapSiftDown(1);
            }
        } else {
            clear();
        }
    }

    private void minHeapSiftDown(int index) {
        int left_node = index * 2;
        int right_node = index * 2 + 1;
        if (mainArray[left_node] != null && mainArray[right_node] != null) {
            if (mainArray[left_node] < mainArray[right_node]) {
                if (mainArray[left_node] < mainArray[index]) {
                    swapLeftChild(index);
                    minHeapSiftDown(left_node);
                }
            } else {
                if (mainArray[right_node] < mainArray[index]) {
                    swapRightChild(index);
                    minHeapSiftDown(right_node);
                }
            }
        } else if (mainArray[left_node] != null && mainArray[left_node] < mainArray[index]) {
            swapLeftChild(index);
            minHeapSiftDown(index);
        } else if (mainArray[right_node] != null && mainArray[right_node] < mainArray[index]) {
            swapRightChild(index);
            minHeapSiftDown(index);
        }
    }

    private void maxHeapSiftDown(int index) {
        int left_node = index * 2;
        int right_node = index * 2 + 1;
        if (mainArray[left_node] != null && mainArray[right_node] != null) {
            if (mainArray[left_node] > mainArray[right_node]) {
                if (mainArray[left_node] > mainArray[index]) {
                    swapLeftChild(index);
                    maxHeapSiftDown(left_node);
                }
            } else {
                if (mainArray[right_node] > mainArray[index]) {
                    swapRightChild(index);
                    maxHeapSiftDown(right_node);
                }
            }
        } else if (mainArray[left_node] != null && mainArray[left_node] > mainArray[index]) {
            swapLeftChild(index);
            maxHeapSiftDown(index);
        } else if (mainArray[right_node] != null && mainArray[right_node] > mainArray[index]) {
            swapRightChild(index);
            maxHeapSiftDown(index);
        }
    }

    private void swapLeftChild(int index) {
        int left_node = index * 2;
        int temp_parent_data = mainArray[index];
        mainArray[index] = mainArray[left_node];
        mainArray[left_node] = temp_parent_data;
    }

    private void swapRightChild(int index) {
        int right_node = index * 2 + 1;
        int temp_parent_data = mainArray[index];
        mainArray[index] = mainArray[right_node];
        mainArray[right_node] = temp_parent_data;
    }

    public boolean find(int find_this) {
        for (int i = 1; i < current_index; i++) { if (mainArray[i] == find_this) return true; }
        return false;
    }

    public void clear() {
        current_index = 1;
        max_size = 16;
        mainArray = new Integer[max_size];
    }

    private ArrayList<Boolean> isMaped = new ArrayList<>();
    private int spacing;
    private int max_row;

    public String treeString() {
        String builder = "";
        if (current_index > 1) {
            int center = 200;
            spacing = 8;
            ArrayList<Integer> location_map = new ArrayList<>();
            int row_counter = 1;
            max_row = 1;
            while (row_counter * 2 < current_index) {
                max_row++;
                row_counter *= 2;
            }

            for (int i = 0; i < current_index; i++) {
                location_map.add(0);
                isMaped.add(false);
            }

            // Generates the estimated proper location of each data point.
            generateLocationMapping(location_map, 1, center, (max_row - 1) * 2);

            ArrayList<String> output_rows = new ArrayList<>();
            output_rows.add("");
            int current_line_counter = 0;
            int max_in_line = 1;
            int current_row_being_developed = 0;
            // Generate string with spacing. Place each row as independent string into output_rows.
            for (int i = 1; i < current_index; i++) {
                if (current_line_counter == max_in_line) {
                    current_line_counter = 0;
                    max_in_line *= 2;
                    current_row_being_developed++;
                    output_rows.add("");
                    builder = "";
                }
                int spaces_to_add = location_map.get(i);
                if (i != max_in_line) {
                    spaces_to_add -= (mainArray[i].toString().length() + 2) / 2;
                    spaces_to_add -= location_map.get(i - 1);
                    spaces_to_add -= mainArray[i - 1].toString().length() + 2;
                }
                for (int s = 0; s < spaces_to_add; s++) {
                    builder += " ";
                }
                builder += "[" + mainArray[i] + "]";
                output_rows.set(current_row_being_developed, builder);
                current_line_counter++;
            }
            // Build final display String
            builder = "";
            for (int i = 0; i < output_rows.size(); i++) {
                builder += output_rows.get(i) + "\n";
            }
        }

        return builder;
    }

    private void generateLocationMapping(ArrayList<Integer> map, int index, int location, int row_subtractor) {
        int left_node = index * 2;
        int right_node = index * 2 + 1;
        map.set(index, location);
        if (mainArray[left_node] != null) {
            generateLocationMapping(map, left_node, location - spacing * (row_subtractor), row_subtractor / 2);
        }
        if (mainArray[right_node] != null) {
            generateLocationMapping(map, right_node, location + spacing * (row_subtractor), row_subtractor / 2);
        }
    }
}
