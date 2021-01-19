import javax.swing.*;
import java.awt.event.ActionEvent;

public class HashPanel extends UnorderedDataStructure {
    private JPanel panel;
    private Hash hash;

    private JLabel hash_text;

    public HashPanel() {
        super();
        hashSetup();
    }

    private void hashSetup() {
        panel = getUnorderedDataStructurePanel();
        hash = new Hash();

        hash_text = new JLabel(hash.toString());
        hash_text.setBounds(0, base_height * 6, 2000, base_height);
        panel.add(hash_text);

        panel.setLayout(null);
    }

    public JPanel getHashPanel() {return panel;}

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("HOME")) gotoMainMenu();
        else if (e.getActionCommand().equals("ADD")) add();
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
        hash_text.setText(hash.toString());
        setSizeText("size: " + hash.getSize());
    }

    private void add() {
        if (isValidInt(getAddField())) {
            hash.add(Integer.parseInt(getAddField()));
            updateGUI();
        }
    }

    private void remove() {
        if (isValidInt(getRemoveField())) {
            hash.remove(Integer.parseInt(getRemoveField()));
            updateGUI();
        }
    }

    private void find() {
        if (isValidInt(getFindField())) {
            int found_at = hash.findIndex(Integer.parseInt(getFindField()));
            if (found_at != -1) {
                setFindText(getFindField() + " can be found at index " + found_at + ".");
            } else {
                setFindText(getFindField() + " could not be found.");
            }
        }
    }

    private void clear() {
        hash.clear();
        updateGUI();
    }
}
