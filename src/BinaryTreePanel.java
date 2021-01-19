import javax.swing.*;
import java.awt.event.ActionEvent;

public class BinaryTreePanel extends UnorderedDataStructure {
    private JPanel panel;
    private BinaryTree binaryTree;

    private JLabel inorder;
    private JLabel preorder;
    private JLabel postorder;

    public BinaryTreePanel() {
        super();
        binaryTreeSetup();
    }

    private void binaryTreeSetup() {
        panel = getUnorderedDataStructurePanel();
        binaryTree = new BinaryTree();

        inorder = new JLabel("Inorder:");
        inorder.setBounds(0, base_height * 6, 2000, base_height);
        panel.add(inorder);

        preorder = new JLabel("Preorder:");
        preorder.setBounds(0, base_height * 7, 2000, base_height);
        panel.add(preorder);

        postorder = new JLabel("Postorder:");
        postorder.setBounds(0, base_height * 8, 2000, base_height);
        panel.add(postorder);

        panel.setLayout(null);
    }

    public JPanel getBinaryTreePanel() {return panel;}

    public void actionPerformed(ActionEvent e) {
        if      (e.getActionCommand().equals("ADD")) add();
        else if (e.getActionCommand().equals("HOME")) gotoMainMenu();
        else if (e.getActionCommand().equals("REMOVE")) remove();
        else if (e.getActionCommand().equals("FIND")) find();
        else if (e.getActionCommand().equals("CLEAR")) clear();
    }

    private void gotoMainMenu() {
        panel.removeAll();
        panel.add(getHome_panel());
        panel.repaint();
        panel.revalidate();
    }

    private void updateGUI() {
        inorder.setText("Inorder:" + binaryTree.getInorderString());
        preorder.setText("Preorder:" + binaryTree.getPreorderString());
        postorder.setText("Postorder:" + binaryTree.getPostorderString());
        setSizeText("size: " + binaryTree.getSize());
    }

    private void add() {
        if (isValidInt(getAddField())) {
            binaryTree.add(Integer.parseInt(getAddField()));
        }
        updateGUI();
    }

    private void remove() {
        if (isValidInt(getRemoveField())) {
            binaryTree.remove(Integer.parseInt(getRemoveField()));
        }
        updateGUI();
    }

    private void find() {
        if (isValidInt(getFindField())) {
            boolean value_exist = binaryTree.find(Integer.parseInt(getFindField()));
            if (value_exist == true) {
                setFindText("The value " + getFindField() + " exist in the tree");
            } else {
                setFindText("The value " + getFindField() + " does not exist in the tree");
            }
        }
    }

    private void clear() {
        binaryTree.clear();
        updateGUI();
    }
}
