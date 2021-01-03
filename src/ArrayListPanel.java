import javax.swing.*;

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

        panel.setLayout(null);
    }

    public JPanel getArrayListPanel() {return panel;}


}
