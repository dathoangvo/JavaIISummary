import javax.swing.*;

public class UnorderedDataStructure extends RootPanel {
    private JPanel panel;

    private JTextField add_field;
    private JButton add;

    private JTextField remove_field;
    private JButton remove;

    private JTextField find_field;
    private JButton find;
    private JLabel find_text;

    public UnorderedDataStructure() {
        super();
        panel = getRootPanel();
        UnorderedSetup();
    }

    public void UnorderedSetup() {
        add = new JButton("add");
        add.setBounds(0, base_height * 3, base_width, base_height);
        add.addActionListener(this);
        add.setActionCommand("ADD");
        panel.add(add);

        add_field = new JTextField();
        add_field.setBounds(base_width, base_height * 3, base_width, base_height);
        panel.add(add_field);


        remove = new JButton("remove");
        remove.setBounds(0, base_height * 4, base_width, base_height);
        remove.addActionListener(this);
        remove.setActionCommand("REMOVE");
        panel.add(remove);

        remove_field = new JTextField();
        remove_field.setBounds(base_width, base_height * 4, base_width, base_height);
        panel.add(remove_field);

        find = new JButton("find");
        find.setBounds(0, base_height * 5, base_width, base_height);
        find.addActionListener(this);
        find.setActionCommand("FIND");
        panel.add(find);

        find_field = new JTextField();
        find_field.setBounds(base_width, base_height * 5, base_width, base_height);
        panel.add(find_field);

        find_text = new JLabel();
        find_text.setBounds(base_width * 2, base_height * 5, base_width * 2, base_height);
        panel.add(find_text);

    }

    public JPanel getUnorderedDataStructurePanel() { return panel; }

    public String getAddField() { return add_field.getText();}
    public String getRemoveField() { return remove_field.getText();}
    public String getFindField() { return find_field.getText();}
    public void setFindText(String s) {find_text.setText(s);}
}
