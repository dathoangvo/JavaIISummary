import javax.swing.*;
import java.awt.event.*;

public class LinkedListPanel extends OrderedDataStructure {
    JPanel panel;
    LinkedList linkedList;

    public LinkedListPanel() {
        super();
        linkedListSetup();
    }

    private void linkedListSetup() {
        panel = getOrderedPanel();
        linkedList = new LinkedList();
        setDisplay_DS(linkedList.toString());
        setFind_text("");
        setGet_text("");

        setAddFrontBigO("O(1)");
        setAddBackBigO("O(n)");
        setAddIndexBigO("O(n)");

        setRemoveFrontBigO("O(1)");
        setRemoveBackBigO("O(n)");
        setRemoveIndexBigO("O(n)");

        setFindBigO("O(n)");
        setGetBigO("O(n)");
        panel.setLayout(null);
    }

    public JPanel getLinkedListPanel() {return panel;}

    public void actionPerformed(ActionEvent e) {
        if      (e.getActionCommand().equals("HOME")) gotoMainMenu();
        else if (e.getActionCommand().equals("ADD_TO_FRONT")) addToFront();
        else if (e.getActionCommand().equals("ADD_TO_BACK")) addToBack();
        else if (e.getActionCommand().equals("ADD_TO_INDEX")) addToIndex();
        else if (e.getActionCommand().equals("REMOVE_FROM_FRONT")) removeFromFront();
        else if (e.getActionCommand().equals("REMOVE_FROM_BACK")) removeFromBack();
        else if (e.getActionCommand().equals("REMOVE_FROM_INDEX")) removeFromIndex();
        else if (e.getActionCommand().equals("FIND")) findValue();
        else if (e.getActionCommand().equals("GET")) getValue();
        else if (e.getActionCommand().equals("INSERTION")) insertion();
        else if (e.getActionCommand().equals("MERGESORT")) mergesort();
        else if (e.getActionCommand().equals("TOGGLE_BASE")) toggleBase();
        else if (e.getActionCommand().equals("TOGGLE_STACK")) toggleStack();
        else if (e.getActionCommand().equals("TOGGLE_QUEUE")) toggleQueue();
        else if (e.getActionCommand().equals("CLEAR")) clear();
        else if (e.getActionCommand().equals("REVERSE")) reverse();
    }

    private void updateGUI() {
        setDisplay_DS(linkedList.toString());
        setSizeText("current size: " + linkedList.getSize());
    }

    private void gotoMainMenu() {
        panel.removeAll();
        panel.add(getHome_panel());
        panel.repaint();
        panel.revalidate();
    }

    private void clear() {
        linkedList.clear();
        updateGUI();
    }

    private void addToFront() {
        linkedList.addAtIndex(0);
        updateGUI();
    }

    private void addToBack() {
        linkedList.addAtIndex(linkedList.size);
        updateGUI();
    }

    private void addToIndex() {
        if (isValidInt(getAddIndexField())) {
            linkedList.addAtIndex(Integer.parseInt(getAddIndexField()));
            updateGUI();
        }
    }

    private void removeFromFront() {
        linkedList.removeAtIndex(0);
        updateGUI();
    }

    private void removeFromBack() {
        linkedList.removeAtIndex(linkedList.size - 1);
        updateGUI();
    }

    private void removeFromIndex() {
        if (isValidInt(getRemoveIndexField())) {
            linkedList.removeAtIndex(Integer.parseInt(getRemoveIndexField()));
            updateGUI();
        }
    }

    private void findValue() {
        if (isValidInt(getFindField())) {
            setFind_text(getFindField() + " can be found at index " + linkedList.find(Integer.parseInt(getFindField())));
        }
    }

    private void getValue() {
        if (isValidInt(getGetField())) {
            setGet_text("index " + getGetField() + " contains the number " + linkedList.get(Integer.parseInt(getGetField())));
        }
    }

    private void insertion() {
        linkedList.insertionSort();
        updateGUI();
    }

    private void mergesort() {
        linkedList.mergesort();
        updateGUI();
    }

    private void toggleBase() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        enableAllComponents();
        addRootComponent();
        addEnabledComponents();
    }

    private void toggleStack() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        enableAllComponents();
        disableAddBack();
        disableAddIndex();
        disableRemoveBack();
        disableRemoveIndex();
        disableInsertion();
        disableMerge();
        disableGet();
        addRootComponent();
        addEnabledComponents();
    }

    private void toggleQueue() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        enableAllComponents();
        disableAddBack();
        disableAddIndex();
        disableRemoveFront();
        disableRemoveIndex();
        disableInsertion();
        disableMerge();
        disableGet();
        addRootComponent();
        addEnabledComponents();
    }

    private void reverse() {
        linkedList.reverse();
        updateGUI();
    }


}
