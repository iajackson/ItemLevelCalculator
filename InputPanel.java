/**
    Panel containing all input fields and checkbox
*/

// TODO: Implement offhand checkbox functionality

import javax.swing.*;   // Used for GUI components
import java.awt.*;      // Used for Layout Manager

public class InputPanel extends JPanel
{
    private JTextField[] textFields = new JTextField[13];
    private JCheckBox offHandCheckBox;
    
    public InputPanel()
    {
        // Create a GridLayout manager with 
        // seven rows and two columns.
        setLayout(new GridLayout(7, 2));
        
        // Create the text fields
        for(int i=0;i<13;i++)
        {
            textFields[i] = new JTextField(4);
        }

        // Create the check box
        offHandCheckBox = new JCheckBox("Offhand?");
        
        // Add the text fields and check box to the panel
        add(textFields[0]);
        add(offHandCheckBox);
        for(int i=1;i<13;i++)
        {
            add(textFields[i]);
        }
    }
    
    /**
        Gets and returns the values from the text fields
        @return An array containing all the text field entries
    */
    public int[] getValues()
    {
        int[] itemLevels = new int[13];
        for (int i=0; i<13; i++)
        {
            itemLevels[i] = Integer.parseInt(textFields[i].getText());
        }
        return itemLevels;
    }
}