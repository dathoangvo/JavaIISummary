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

        frame.add(panel);
        frame.setVisible(true);

        RootPanel rootPanel = new RootPanel();
        rootPanel.setHome_panel(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if      (e.getActionCommand().equals("LAUNCH_LINKED_LIST")) launchLinkedList();
        else if (e.getActionCommand().equals("LAUNCH_ARRAY_LIST")) launchArrayList();
    }


    private void launchLinkedList() {
        LinkedListPanel linked_list = new LinkedListPanel();
        linked_list.setHome_panel(panel);
        frame.setContentPane(linked_list.getLinkedListPanel());
        frame.repaint();
        frame.revalidate();
    }

    private void launchArrayList() {

    }
}
