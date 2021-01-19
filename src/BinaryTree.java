public class BinaryTree {
    private class node {
        public int data;
        public node left_node;
        public node right_node;

        public node(int n) {
            data = n;
        }
    }

    private node root;
    private int size;

    public BinaryTree() {
        size = 0;
    }

    public void add(int n) {
        node temp = new node(n);
        if (root == null) {
            root = temp;
            size++;
            return;
        } else {
            add(root, temp);
        }
    }

    private void add(node parent, node new_child) {
        if (new_child.data > parent.data) {
            if (parent.right_node == null) {
                parent.right_node = new_child;
                size++;
            } else {
                add(parent.right_node, new_child);
            }
        } else if (new_child.data < parent.data) {
            if (parent.left_node == null) {
                parent.left_node = new_child;
                size++;
            } else {
                add(parent.left_node, new_child);
            }
        }
    }

    public void remove(int i) {
        // Find the node
        if (root != null) {
            if (root.data == i) {
                if (root.left_node != null && root.right_node != null) {
                    int replacer_data = findMax(root.left_node).data;
                    remove(replacer_data);
                    root.data = replacer_data;
                } else if (root.left_node != null) {
                    root = root.left_node;
                } else if (root.right_node != null) {
                    root = root.right_node;
                } else {
                    root = null;
                }
                size--;
            } else {
                remove(root, i);
            }
        }
    }

    private void remove(node parent, int i) {
        // Find the parent node
        if (parent != null) {
            if (parent.left_node != null && parent.left_node.data == i) {
                // If child has no child
                if (parent.left_node.left_node != null && parent.left_node.right_node != null) {
                    int replacer_data = findMax(parent.left_node).data;
                    remove(replacer_data);
                    parent.left_node.data = replacer_data;
                } else if (parent.left_node.left_node != null) {
                    parent.left_node = parent.left_node.left_node;
                } else if (parent.left_node.right_node != null) {
                    parent.left_node = parent.left_node.right_node;
                } else {
                    parent.left_node = null;
                }
                size--;
            } else if (parent.right_node != null && parent.right_node.data == i) {
                if (parent.right_node.left_node != null && parent.right_node.right_node != null) {
                    int replacer_data = findMax(parent.right_node).data;
                    remove(replacer_data);
                    parent.right_node.data = replacer_data;
                } else if (parent.right_node.left_node != null) {
                    parent.right_node = parent.right_node.left_node;
                } else if (parent.right_node.right_node != null) {
                    parent.right_node = parent.right_node.right_node;
                } else {
                    parent.right_node = null;
                }
                size--;
            } else if (i > parent.data) {
                remove(parent.right_node, i);
            } else if (i < parent.data) {
                remove(parent.left_node, i);
            }
        }
    }

    private node findMax(node n) {
        if (n.right_node != null) {
            return findMax(n.right_node);
        } else {
            return n;
        }
    }

    public boolean find(int i) {
        return find(root, i);
    }

    private boolean find(node n, int i) {
        if (n == null) {
            return false;
        } else if (i == n.data) {
            return true;
        } else if (i > n.data) {
            return find(n.right_node, i);
        } else if (i < n.data) {
            return find(n.left_node, i);
        } else {
            return false;
        }
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public int getSize() {return size;}

    public String getInorderString() {
        String builder = "";
        if (root != null) {
            if (root.left_node != null) { builder = getInorderString(root.left_node, builder); }
            builder += "[" + root.data + "]";
            if (root.right_node != null) {builder = getInorderString(root.right_node, builder); }
        }
        return builder;
    }

    private String getInorderString(node n, String s) {
        if (n.left_node != null) { s = toString(n.left_node, s);}
        s += "[" + n.data + "]";
        if (n.right_node != null) { s = toString(n.right_node, s);}
        return s;
    }

    public String getPreorderString() {
        String builder = "";
        if (root != null) {
            builder += "[" + root.data + "]";
            if (root.left_node != null) { builder = getPreorderString(root.left_node, builder); }
            if (root.right_node != null) {builder = getPreorderString(root.right_node, builder); }
        }
        return builder;
    }

    private String getPreorderString(node n, String s) {
        s += "[" + n.data + "]";
        if (n.left_node != null) { s = toString(n.left_node, s);}
        if (n.right_node != null) { s = toString(n.right_node, s);}
        return s;
    }

    public String getPostorderString() {
        String builder = "";
        if (root != null) {
            if (root.left_node != null) { builder = getPostorderString(root.left_node, builder); }
            if (root.right_node != null) {builder = getPostorderString(root.right_node, builder); }
            builder += "[" + root.data + "]";
        }
        return builder;
    }

    private String getPostorderString(node n, String s) {
        if (n.left_node != null) { s = toString(n.left_node, s);}
        if (n.right_node != null) { s = toString(n.right_node, s);}
        s += "[" + n.data + "]";
        return s;
    }

    /**
     * Default form is inorder
     * @return inorder string representation of BST.
     */
    public String toString() {
        String builder = "";
        if (root != null) {
            if (root.left_node != null) { builder = toString(root.left_node, builder); }
            builder += "[" + root.data + "]";
            if (root.right_node != null) {builder = toString(root.right_node, builder); }
        }
        return builder;

    }

    private String toString(node n, String s) {
        if (n.left_node != null) { s = toString(n.left_node, s);}
        s += "[" + n.data + "]";
        if (n.right_node != null) { s = toString(n.right_node, s);}
        return s;
    }

}
