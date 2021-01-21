import javax.swing.*;
import java.awt.event.ActionEvent;

public class HeapPanel extends UnorderedDataStructure{
    private JPanel panel;
    private Heap heap;
    private JTextArea heap_text;

    private JButton toggle_min_heap;
    private JButton toggle_max_heap;

    public HeapPanel() {
        super();
        heapSetup();
    }

    private void heapSetup() {
        panel = getUnorderedDataStructurePanel();
        heap = new Heap();

        heap_text = new JTextArea();
        heap_text.setBounds(0, base_height * 7, 2000, 200);
        heap_text.setAlignmentX(1000);
        panel.add(heap_text);

        toggle_min_heap = new JButton("Min Heap");
        toggle_min_heap.setBounds(0, base_height * 6, base_width, base_height);
        toggle_min_heap.addActionListener(this);
        toggle_min_heap.setActionCommand("TOGGLE_MIN_HEAP");
        panel.add(toggle_min_heap);

        toggle_max_heap = new JButton("Max Heap");
        toggle_max_heap.setBounds(base_width, base_height * 6, base_width, base_height);
        toggle_max_heap.addActionListener(this);
        toggle_max_heap.setActionCommand("TOGGLE_MAX_HEAP");
        panel.add(toggle_max_heap);

        panel.setLayout(null);
    }

    public JPanel getHeapPanel() {return panel;}

    public void actionPerformed(ActionEvent e) {
        if      (e.getActionCommand().equals("HOME")) gotoMainMenu();
        else if (e.getActionCommand().equals("ADD")) add();
        else if (e.getActionCommand().equals("REMOVE")) remove();
        else if (e.getActionCommand().equals("FIND")) find();
        else if (e.getActionCommand().equals("CLEAR")) clear();
        else if (e.getActionCommand().equals("TOGGLE_MIN_HEAP")) toggleMinHeap();
        else if (e.getActionCommand().equals("TOGGLE_MAX_HEAP")) toggleMaxHeap();

    }

    private void gotoMainMenu() {
        panel.removeAll();
        panel.add(getHome_panel());
        panel.repaint();
        panel.revalidate();
    }

    private void updateGUI() {
        heap_text.setText(heap.treeString());
        setSizeText("size:" + heap.getSize());
    }

    private void add() {
        if (isValidInt(getAddField())) {
            heap.add(Integer.parseInt(getAddField()));
            updateGUI();
        }
    }

    private void remove() {
        heap.remove();
        updateGUI();
    }

    private void find() {
        if (isValidInt(getFindField())) {
            if (heap.find(Integer.parseInt(getFindField()))) {
                setFindText(getFindField() + " exist in the heap");
            } else {
                setFindText(getFindField() + " does not exist in the heap");
            }
        }
    }

    private void clear() {
        heap.clear();
        updateGUI();
    }

    private void toggleMinHeap() {
        heap.toggleMin();
        updateGUI();
    }

    private void toggleMaxHeap() {
        heap.toggleMax();
        updateGUI();
    }
}
