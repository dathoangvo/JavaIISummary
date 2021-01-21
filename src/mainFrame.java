import javax.swing.*;
import java.awt.event.*;

public class mainFrame implements ActionListener{
    public static void main(String[] args) {
        mainFrame gui = new mainFrame();
    }

    private int screenWidth;
    private int screenHeight;
    private int screenX;
    private int screenY;

    private JFrame frame;
    private JPanel panel;
    private JButton linkedList;
    private JButton arrayList;
    private JButton binarySearchTree;
    private JButton hash;
    private JButton heap;

    // Constructor
    public mainFrame() {
        setup();
    }

    private void setup() {
        panel = new JPanel();
        panel.setLayout(null);

        screenWidth = 1200;
        screenHeight = 600;
        screenX = 500;
        screenY = 400;

        frame = new JFrame();
        frame.setBounds(screenX, screenY, screenWidth, screenHeight);
        frame.setTitle("Temp title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        linkedList = new JButton("Linked List");
        linkedList.setBounds(0, 0, 100, 30);
        linkedList.addActionListener(this);
        linkedList.setActionCommand("LAUNCH_LINKED_LIST");
        panel.add(linkedList);

        arrayList = new JButton("Array List");
        arrayList.setBounds(0, 30, 100, 30);
        arrayList.addActionListener(this);
        arrayList.setActionCommand("LAUNCH_ARRAY_LIST");
        panel.add(arrayList);

        binarySearchTree = new JButton("Binary Tree");
        binarySearchTree.setBounds(0, 60, 100, 30);
        binarySearchTree.addActionListener(this);
        binarySearchTree.setActionCommand("LAUNCH_BINARY_SEARCH_TREE");
        panel.add(binarySearchTree);

        hash = new JButton("Hash");
        hash.setBounds(0, 90, 100, 30);
        hash.addActionListener(this);
        hash.setActionCommand("LAUNCH_HASH");
        panel.add(hash);

        heap = new JButton("heap");
        heap.setBounds(0, 120, 100, 30);
        heap.addActionListener(this);
        heap.setActionCommand("LAUNCH_HEAP");
        panel.add(heap);

        frame.add(panel);
        frame.setVisible(true);

        RootPanel rootPanel = new RootPanel();
        rootPanel.setHome_panel(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if      (e.getActionCommand().equals("LAUNCH_LINKED_LIST")) launchLinkedList();
        else if (e.getActionCommand().equals("LAUNCH_ARRAY_LIST")) launchArrayList();
        else if (e.getActionCommand().equals("LAUNCH_BINARY_SEARCH_TREE")) launchBinarySearchTree();
        else if (e.getActionCommand().equals("LAUNCH_HASH")) launchHash();
        else if (e.getActionCommand().equals("LAUNCH_HEAP")) launchHeap();
    }


    private void launchLinkedList() {
        LinkedListPanel linked_list = new LinkedListPanel();
        frame.setContentPane(linked_list.getLinkedListPanel());
        frame.repaint();
        frame.revalidate();
    }

    private void launchArrayList() {
        ArrayListPanel array_list = new ArrayListPanel();
        frame.setContentPane(array_list.getArrayListPanel());
        frame.repaint();
        frame.revalidate();
    }

    private void launchBinarySearchTree() {
        BinaryTreePanel binary_tree = new BinaryTreePanel();
        frame.setContentPane(binary_tree.getBinaryTreePanel());
        frame.repaint();
        frame.revalidate();
    }

    private void launchHash() {
        HashPanel hash = new HashPanel();
        frame.setContentPane(hash.getHashPanel());
        frame.repaint();
        frame.revalidate();
    }

    private void launchHeap() {
        HeapPanel heap = new HeapPanel();
        frame.setContentPane(heap.getHeapPanel());
        frame.repaint();
        frame.revalidate();
    }
}
