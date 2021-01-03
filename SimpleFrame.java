import javax.swing.*;         // Storage for most of the GUI stuff
import java.awt.*;            // Used for some parts of GUI
import java.awt.event.*;      // Basic Event Handing class,  Note that it is NOT auto added when you add java.awt.*l
import java.util.*;

public class SimpleFrame implements ActionListener
{
      // List of GUI fields
      private JFrame myFrame;
      private JButton button1;
      private JButton button2;
      private JButton button3;            
      private JLabel  text1;
      private JTextField field1;
      
      // List of fields for the program. 
      private java.util.List<Integer> allQuizes;
      private double quizGrade;
      

   public static void main(String[] args)
   {
      SimpleFrame x = new SimpleFrame();
      
     
   }


   public SimpleFrame() 
   {
     setupTheWholeGUI();
     allQuizes = new ArrayList<Integer>();
   }
   
   public void setupTheWholeGUI()
   {
    myFrame = new JFrame();
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setTitle("Mr. Wood's Program");
      myFrame.setSize(new Dimension(300,300));
      myFrame.setLocation(new Point(700, 350));
      
      // Setup 3 buttons
      
     button1 = new JButton();
      button1.setText("Add Quiz to List");
      //button1.setBackground(Color.BLUE);
      button1.setBounds(10,10, 150, 25);
      button1.addActionListener(this);
      button1.setActionCommand("Button 1 Pressed");
      
      
     button2 = new JButton("Find Average");
      button2.setBounds(10,45, 150, 25);
      button2.setActionCommand("Button 2 Pressed");
      button2.addActionListener(this);


     button3 = new JButton("Reset");
     button3.setActionCommand("Button 3 Pressed");
      button3.setBounds(10,80, 200, 25);
      button3.addActionListener(this);

      
     text1 = new JLabel();
      text1.setText("Hello World");
      text1.setBounds(10, 200, 100, 25);
      
      
     field1 = new JTextField();
      field1.setBounds(125, 200, 100, 25);
      
      
      myFrame.add(button1);
      myFrame.add(button2);
      myFrame.add(button3);
      myFrame.add(text1);
      myFrame.add(field1);
      
      // Change the layout
      
      myFrame.setLayout( null );
      
      // make whole thing visible
      
      myFrame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e)      // Needed for inteface. // This method isn't static!!!!!
   {
      if      (e.getActionCommand().equals("Button 1 Pressed") ) button1Pressed();
      else if (e.getActionCommand().equals("Button 2 Pressed") ) button2Pressed(); 
      else if (e.getActionCommand().equals("Button 3 Pressed") ) button3Pressed();
   }

   private void button3Pressed()
   {
     quizGrade = 0;
     allQuizes.clear();
     text1.setText("" + quizGrade);
   }   
   
   private void button1Pressed()
   {
     String temp = field1.getText();
     int i = Integer.parseInt(temp);
     allQuizes.add(i);
     
     //System.out.println(allQuizes); 
   }
   
   private void button2Pressed()
   {
        int total = 0;
        
        for (int i : allQuizes)
          total += i;
          
         quizGrade = total * 1.0 / allQuizes.size(); 
         
         text1.setText("" + quizGrade);
       
   }
   
   
}