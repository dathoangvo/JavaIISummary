import javax.swing.*;

public class OrderedDataStructure extends RootPanel {
    private JPanel panel;

    private JLabel display_DS;

    private JButton reverse;
    private boolean show_reverse;

    private JButton front_add;
    private boolean show_add_front;

    private JButton back_add;
    private boolean show_add_back;

    private JTextField index_add_field;
    private JButton index_add;
    private boolean show_add_index;

    private JButton front_remove;
    private boolean show_front_remove;

    private JButton back_remove;
    private boolean show_back_remove;

    private JButton index_remove;
    private JTextField index_remove_field;
    private boolean show_index_remove;

    private JButton find;
    private JTextField find_field;
    private JLabel find_text;
    private boolean show_find;

    private JButton get;
    private JTextField get_field;
    private JLabel get_text;
    private boolean show_get;

    private JButton insertion_sort;
    private boolean show_insertion;

    private JButton merge_sort;
    private boolean show_merge;

    private JButton toggle_Stack;
    private JButton toggle_Queue;
    private JButton toggle_Base;

    public OrderedDataStructure() {
        super();
        panel = getRootPanel();
        OrderedSetup();
        enableAllComponents();
        addEnabledComponents();
    }

    public void OrderedSetup() {
        reverse = new JButton("reverse");
        reverse.setBounds(base_width * 3, 0, base_width, base_height);
        reverse.addActionListener(this);
        reverse.setActionCommand("REVERSE");

        display_DS = new JLabel("SET DATA STRUCTURE TEXT");
        display_DS.setBounds(0, base_height * 2, 1200, base_height);

        front_add = new JButton("add front");
        front_add.setBounds(0, base_height * 4, base_width, base_height);
        front_add.addActionListener(this);
        front_add.setActionCommand("ADD_TO_FRONT");

        back_add = new JButton("add back");
        back_add.setBounds(base_width, base_height * 4, base_width, base_height);
        back_add.addActionListener(this);
        back_add.setActionCommand("ADD_TO_BACK");

        index_add_field = new JTextField();
        index_add_field.setBounds(0, base_height * 5, base_width, base_height);

        index_add = new JButton("add here");
        index_add.setBounds(base_width, base_height * 5, base_width, base_height);
        index_add.addActionListener(this);
        index_add.setActionCommand("ADD_TO_INDEX");

        front_remove = new JButton("remove front");
        front_remove.setBounds(base_width * 2 + base_height, base_height * 4, base_width, base_height);
        front_remove.addActionListener(this);
        front_remove.setActionCommand("REMOVE_FROM_FRONT");

        back_remove = new JButton("remove back");
        back_remove.setBounds(base_width * 3 + base_height, base_height * 4, base_width, base_height);
        back_remove.addActionListener(this);
        back_remove.setActionCommand("REMOVE_FROM_BACK");

        index_remove_field = new JTextField();
        index_remove_field.setBounds(base_width * 2 + base_height, base_height * 5, base_width, base_height);

        index_remove = new JButton("remove here");
        index_remove.setBounds(base_width * 3 + base_height, base_height * 5, base_width, base_height);
        index_remove.addActionListener(this);
        index_remove.setActionCommand("REMOVE_FROM_INDEX");

        toggle_Base = new JButton("Base");
        toggle_Base.setBounds(base_width * 4 + base_height * 2, base_height * 4, base_width, base_height);
        toggle_Base.addActionListener(this);
        toggle_Base.setActionCommand("TOGGLE_BASE");

        toggle_Stack = new JButton("Stack");
        toggle_Stack.setBounds(base_width * 5 + base_height * 2, base_height * 4, base_width, base_height);
        toggle_Stack.addActionListener(this);
        toggle_Stack.setActionCommand("TOGGLE_STACK");

        toggle_Queue = new JButton("Queue");
        toggle_Queue.setBounds(base_width * 6 + base_height * 2, base_height * 4, base_width, base_height);
        toggle_Queue.addActionListener(this);
        toggle_Queue.setActionCommand("TOGGLE_QUEUE");

        find_field = new JTextField();
        find_field.setBounds(0, base_height * 7, base_width, base_height);

        find = new JButton("find");
        find.setBounds(base_width, base_height * 7, base_width, base_height);
        find.addActionListener(this);
        find.setActionCommand("FIND");

        find_text = new JLabel("SET FIND TEXT");
        find_text.setBounds(base_width * 2, base_height * 7, 1000, base_height);

        get_field = new JTextField();
        get_field.setBounds(0, base_height * 8, base_width, base_height);

        get = new JButton("get");
        get.setBounds(base_width, base_height * 8, base_width, base_height);
        get.addActionListener(this);
        get.setActionCommand("GET");

        get_text = new JLabel("SET GET TEXT");
        get_text.setBounds(base_width * 2, base_height * 8, 1000, base_height);

        insertion_sort = new JButton("insertion O(n^2)");
        insertion_sort.setBounds(0, base_height * 10, base_width, base_height);
        insertion_sort.addActionListener(this);
        insertion_sort.setActionCommand("INSERTION");

        merge_sort = new JButton("mergesort O(nlogn)");
        merge_sort.setBounds(base_width, base_height * 10, base_width, base_height);
        merge_sort.addActionListener(this);
        merge_sort.setActionCommand("MERGESORT");
    }

    public void enableAllComponents() {
        show_reverse = true;

        show_add_front = true;
        show_add_back = true;
        show_add_index = true;

        show_front_remove = true;
        show_back_remove = true;
        show_index_remove = true;

        show_find = true;
        show_get = true;

        show_insertion = true;
        show_merge = true;
    }

    public void disableAddFront() {show_add_front = false;}
    public void disableAddBack() {show_add_back = false;}
    public void disableAddIndex() {show_add_index = false;}

    public void disableRemoveFront() {show_front_remove = false;}
    public void disableRemoveBack() {show_back_remove = false;}
    public void disableRemoveIndex() {show_index_remove = false;}

    public void disableFind() {show_find = false;}
    public void disableGet() {show_get = false;}

    public void disableInsertion() {show_insertion = false;}
    public void disableMerge() {show_merge = false;}

    public void addEnabledComponents() {
        if (show_reverse) {panel.add(reverse);}

        if (show_add_front) {panel.add(front_add);}
        if (show_add_back) {panel.add(back_add);}
        if (show_add_index) {panel.add(index_add); panel.add(index_add_field);}

        if (show_front_remove) {panel.add(front_remove);}
        if (show_back_remove) {panel.add(back_remove);}
        if (show_index_remove) {panel.add(index_remove); panel.add(index_remove_field);}

        if (show_find) {panel.add(find); panel.add(find_field); panel.add(find_text);}
        if (show_get) {panel.add(get); panel.add(get_field); panel.add(get_text);}

        if (show_insertion) {panel.add(insertion_sort);}
        if (show_merge) {panel.add(merge_sort);}

        panel.add(display_DS);

        panel.add(toggle_Base);
        panel.add(toggle_Stack);
        panel.add(toggle_Queue);
    }

    public JPanel getOrderedPanel() {return panel;}

    public String getAddIndexField() {return index_add_field.getText();}

    public String getRemoveIndexField() {return index_remove_field.getText();}

    public String getFindField() {return find_field.getText();}

    public String getGetField() {return get_field.getText();}

    public void setDisplay_DS(String text) {
        display_DS.setText(text);
    }

    public void setFind_text(String text) {
        find_text.setText(text);
    }

    public void setGet_text(String text) {
        get_text.setText(text);
    }

    public void setAddFrontBigO(String text) {
        front_add.setText("add front " + text);
    }

    public void setAddBackBigO(String text) {
        back_add.setText("add back " + text);
    }

    public void setAddIndexBigO(String text) {
        index_add.setText("add index " + text);
    }

    public void setRemoveFrontBigO(String text) {
        front_remove.setText("remove front " + text);
    }

    public void setRemoveBackBigO(String text) {
        back_remove.setText("remove back " + text);
    }

    public void setRemoveIndexBigO(String text) {
        index_remove.setText("remove index " + text);
    }

    public void setFindBigO(String text) {
        find.setText("find " + text);
    }

    public void setGetBigO(String text) {
        get.setText("get " + text);
    }

}
