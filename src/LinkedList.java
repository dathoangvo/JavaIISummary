import java.util.Random;

public class LinkedList implements OrderedDSInterface{
    private class node {
        int data;
        node next;

        public node(int _data) {
            data = _data;
            next = null;
        }
    }

    node root;
    int size;

    public LinkedList() {
        root = null;
        size = 0;
    }

    /**
     * adds a new value into the linkedlist with a random data between -100 to 100 at a given index.
     */

    public int addAtIndex(int index) {
        if (index > size) {
            System.out.println("Index out of bounds.");
            return -1;
        }
        Random rand = new Random();
        int temp_data = rand.nextInt(201) - 100;
        node temp_node = new node(temp_data);
        if (index == 0) {
            if (root == null) {
                root = temp_node;
            } else {
                temp_node.next = root;
                root = temp_node;
            }
        } else {
            node current_node = root;
            int counter = 0;
            while (counter < index - 1) {
                current_node = current_node.next;
                counter++;
            }
            temp_node.next = current_node.next;
            current_node.next = temp_node;
        }
        size++;
        return temp_data;
    }

    public int removeAtIndex(int index) {
        if (index >= size) {
            System.out.println("Index out of bounds.");
            return -9999;
        }
        if (index == 0) {
            node return_node = root;
            if (root.next != null) {
                root = root.next;
            } else {
                root = null;
            }
            size--;
            return return_node.data;
        }
        int counter = 0;
        node current_node = root;
        node back_node = root;
        while (counter < index) {
            back_node = current_node;
            current_node = current_node.next;
            counter++;
        }
        back_node.next = current_node.next;
        size--;
        return current_node.data;
    }

    public String find(int integer_to_find) {
        if (root == null) { return ""; }
        String builder = "";
        int counter = 0;
        node current_node = root;
        while (counter < size) {
            if (current_node.data == integer_to_find) {
                builder += counter + " ";
            }
            current_node = current_node.next;
            counter++;
        }
        return builder;
    }

    public String get(int index_to_get) {
        int counter = 0;
        node traversal = root;
        while (counter < index_to_get) {
            if (traversal.next == null) {
                throw new IndexOutOfBoundsException("The get value is greater than the size of the list");
            }
            traversal = traversal.next;
            counter++;
        }
        String return_text = traversal.data + "";
        return return_text;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insertionSort() {
        if (root == null) {
            return;
        }
        node full_traversal_follower = root;
        node full_traversal = root.next;
        while (full_traversal != null) {
            node next = full_traversal.next;

            // Find where the current root needs to be placed.
            node repeat_traversal = root;
            while (full_traversal.data > repeat_traversal.next.data) {
                repeat_traversal = repeat_traversal.next;
            }

            // Place the node where it needs to be
            if (repeat_traversal == root && full_traversal.data < repeat_traversal.data) {
                full_traversal_follower.next = full_traversal.next;
                full_traversal.next = repeat_traversal;
                root = full_traversal;
            } else if (full_traversal.data <= repeat_traversal.next.data) {
                full_traversal_follower.next = full_traversal.next;
                full_traversal.next = repeat_traversal.next;
                repeat_traversal.next = full_traversal;
            }

            // Advanced the follower node as well as the current node
            full_traversal_follower = root;
            while (full_traversal_follower.next != next) {
                full_traversal_follower = full_traversal_follower.next;
            }
            full_traversal = next;
        }
    }

    public void mergesort() {
        if (size > 1) {
            int middle = size / 2;
            LinkedList left = new LinkedList();
            LinkedList right = new LinkedList();
            node current = root;
            int counter = 1;
            while (counter < middle) {
                current = current.next;
                counter++;
            }
            right.root = current.next;
            left.root = root;
            current.next = null;
            root = mergesort(left, middle, right, size - middle).root;
        }
    }

    private LinkedList mergesort(LinkedList left, int left_size, LinkedList right, int right_size) {
        if (left_size > 1) {
            int middle = left_size / 2;
            LinkedList new_left = new LinkedList();
            LinkedList new_right = new LinkedList();
            node current = left.root;
            int counter = 1;
            while (counter < middle) {
                current = current.next;
                counter++;
            }
            new_right.root = current.next;
            new_left.root = left.root;
            current.next = null;
            left = mergesort(new_left, middle, new_right, left_size - middle);
        }

        if (right_size > 1) {
            int middle = right_size / 2;
            LinkedList new_left = new LinkedList();
            LinkedList new_right = new LinkedList();
            node current = right.root;
            int counter = 1;
            while (counter < middle) {
                current = current.next;
                counter++;
            }
            new_right.root = current.next;
            new_left.root = right.root;
            current.next = null;
            right = mergesort(new_left, middle, new_right, right_size - middle);
        }
        return merge(left, right);
    }

    private LinkedList merge(LinkedList left, LinkedList right) {
        LinkedList merged_list = new LinkedList();

        while (left.root != null && right.root != null) {
            if (left.root.data <= right.root.data) {
                merged_list.addData(left.root.data);
                left.root = left.root.next;
            } else {
                merged_list.addData(right.root.data);
                right.root = right.root.next;
            }
        }

        if (left.root != null) {
            node current = merged_list.root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = left.root;
        }
        if (right.root != null) {
            node current = merged_list.root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = right.root;
        }
        return merged_list;
    }

    private void addData(int data) {
        node new_node = new node(data);
        if (root == null) {
            root = new_node;
        } else {
            node current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;
            size++;
        }
    }

    public void reverse() {
        LinkedList reversed_list = new LinkedList();
        if (root.next != null) {
            reverse(reversed_list, root.next);
        }
        if (root != null) {
            reversed_list.addData(root.data);
        }
        root = reversed_list.root;
    }

    private void reverse(LinkedList new_root, node next) {
        if (next.next != null) {
            reverse(new_root, next.next);
        }
        new_root.addData(next.data);
    }

    public String toString() {
        String builder = "[root] > ";
        if (root == null) {
            return "[root] >";
        }
        node current_node = root;
        builder += "[" + current_node.data + "]";
        while (current_node.next != null) {
            builder += " > ";
            current_node = current_node.next;
            builder += "[" + current_node.data + "]";
        }
        return builder;
    }


}
