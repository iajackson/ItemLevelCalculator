/**
    Panel containing all input fields and checkbox
*/

// TODO: Implement offhand checkbox functionality

import javax.swing.*;   // Used for GUI components
import java.awt.*;      // Used for Layout Manager
import java.awt.event.*;

public class InputPanel extends JPanel
{
    private JTextField[] textFields = new JTextField[13];
    private JCheckBox offHandCheckBox;
    private String saved;
    
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
        offHandCheckBox.setSelected(true);
        offHandCheckBox.addActionListener(new CheckedActionListener());
        
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
        try
        {
            if (offHandCheckBox.isSelected())
            {
                for (int i=0; i<13; i++)
                {
                    itemLevels[i] = Integer.parseInt(textFields[i].getText());
                    if (itemLevels[i] <= 0)
                        throw new NumberFormatException();
                }
            }
            else
            {
                itemLevels[0] = Integer.parseInt(textFields[0].getText());
                itemLevels[1] = Integer.parseInt(textFields[1].getText());
                itemLevels[2] = Integer.parseInt(textFields[0].getText());
                for (int i=3; i<13; i++)
                {
                    itemLevels[i] = Integer.parseInt(textFields[i].getText());
                    if (itemLevels[i] <= 0)
                        throw new NumberFormatException();
                }
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Bad data");
            itemLevels = null;
        }
        return itemLevels;
    }
    
    /**
        Sets the text field values to those provided
        @param values The values to set the text fields to
    */
    public void setValues(String[] values)
    {
        for (int i=0; i<13; i++)
        {
            textFields[i].setText(values[i]);
        }
    }
    
    /**
        Private inner class that handles the event when
        the user clicks the Offhand? checkbox
    */
    private class CheckedActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (offHandCheckBox.isSelected())
            {
                textFields[2].setEnabled(true);
                textFields[2].setText(saved);
            }
            else
            {
                textFields[2].setEnabled(false);
                saved = textFields[2].getText();
                textFields[2].setText("");
            }
        }
    }
}