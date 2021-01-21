import javax.swing.*;
import java.awt.event.*;

public class RootPanel implements ActionListener{
    public final static int base_width = 150;
    public final static int base_height = 25;

    private JPanel panel;
    private static JPanel home_panel;

    private JButton home_button;
    private JButton clear_button;

    private JLabel size;

    public RootPanel() {
        rootSetup();
        addRootComponent();
    }

    private void rootSetup() {
        panel = new JPanel();

        home_button = new JButton("return");
        home_button.setBounds(0, 0, base_width, base_height);
        home_button.addActionListener(this);
        home_button.setActionCommand("HOME");


        clear_button = new JButton("clear");
        clear_button.setBounds(base_width, 0, base_width, base_height);
        clear_button.addActionListener(this);
        clear_button.setActionCommand("CLEAR");


        size = new JLabel("size: 0");
        size.setBounds(base_width * 2 + base_height, 0, base_width, base_height);

    }

    public void addRootComponent() {
        panel.add(home_button);
        panel.add(clear_button);
        panel.add(size);
    }

    public void setHome_panel(JPanel INPUT_HOME_PANEL) {
        home_panel = INPUT_HOME_PANEL;
    }

    public void setSizeText(String text) {
        size.setText(text);
    }

    public JPanel getRootPanel() {return panel;}

    public JPanel getHome_panel() {return home_panel;}

    public boolean isValidInt(String text) {
        return text.matches("-?\\d+(\\.\\d+)?") && !text.isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}
