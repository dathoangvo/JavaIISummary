import javax.swing.*;
import java.awt.event.ActionEvent;

public class ArrayListPanel extends OrderedDataStructure{
    private JPanel panel;
    ArrayList arrayList;

    public ArrayListPanel() {
        super();
        ArrayListSetup();
    }

    private void ArrayListSetup() {
        panel = getOrderedPanel();
        arrayList = new ArrayList();
        setDisplay_DS(arrayList.toString());
        setFind_text("");
        setGet_text("");

        setAddFrontBigO("O(n)");
        setAddBackBigO("O(1)");
        setAddIndexBigO("O(n)");

        setRemoveFrontBigO("O(n)");
        setRemoveBackBigO("O(1)");
        setRemoveIndexBigO("O(n)");

        setFindBigO("O(n)");
        setGetBigO("O(n)");
        panel.setLayout(null);
    }

    public JPanel getArrayListPanel() {return panel;}

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
        setDisplay_DS(arrayList.toString());
        setSizeText("current size: " + arrayList.getSize());
    }

    private void gotoMainMenu() {
        panel.removeAll();
        panel.add(getHome_panel());
        panel.repaint();
        panel.revalidate();
    }

    private void addToFront() {
        arrayList.addAtIndex(0);
        updateGUI();
    }

    private void addToBack() {
        arrayList.addAtIndex(arrayList.getSize());
        updateGUI();
    }

    private void addToIndex() {
        if (isValidInt(getAddIndexField())) {
            arrayList.addAtIndex(Integer.parseInt(getAddIndexField()));
            updateGUI();
        }
    }

    private void removeFromFront() {
        arrayList.removeAtIndex(0);
        updateGUI();
    }

    private void removeFromBack() {
        arrayList.removeAtIndex(arrayList.getSize());
        updateGUI();
    }

    private void removeFromIndex() {
        if (isValidInt(getRemoveIndexField())) {
            arrayList.removeAtIndex(Integer.parseInt(getRemoveIndexField()));
            updateGUI();
        }
    }

    private void findValue() {
        if (isValidInt(getFindField())) {
            setFind_text(getFindField() + " can be found at index " + arrayList.find(Integer.parseInt(getFindField())));
        }
    }

    private void getValue() {
        if (isValidInt(getGetField())) {
            setGet_text("index " + getGetField() + " contains the value " + arrayList.get(Integer.parseInt(getGetField())));
        }
    }

    private void clear() {
        arrayList.clear();
        updateGUI();
    }

    private void reverse() {
        arrayList.reverse();
        updateGUI();
    }

    private void insertion() {
        arrayList.insertionSort();
        updateGUI();
    }

    private void mergesort() {
        arrayList.mergesort();
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
        disableAddFront();
        disableAddIndex();
        disableRemoveFront();
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
        disableAddFront();
        disableAddIndex();
        disableRemoveBack();
        disableRemoveIndex();
        disableInsertion();
        disableMerge();
        disableGet();
        addRootComponent();
        addEnabledComponents();
    }
}
