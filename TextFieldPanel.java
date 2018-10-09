import javax.swing.*;
import java.awt.*;

public class TextFieldPanel extends JPanel
{
    private JTextField mainHand, offHand, helm, chest, gloves, belt, legs, feet, ears, neck, wrist, ring1, ring2;
    private JCheckBox offHandCheckBox;
    
    public TextFieldPanel()
    {
        // Create a GridLayout manager with 
        // seven rows and two columns.
        setLayout(new GridLayout(7, 2));
        
        // Create the text fields
        mainHand = new JTextField(4);
        offHand = new JTextField(4);
        helm = new JTextField(4);
        chest = new JTextField(4);
        gloves = new JTextField(4);
        belt = new JTextField(4);
        legs = new JTextField(4);
        feet = new JTextField(4);
        ears = new JTextField(4);
        neck = new JTextField(4);
        wrist = new JTextField(4);
        ring1 = new JTextField(4);
        ring2 = new JTextField(4);
        
        offHandCheckBox = new JCheckBox("Offhand?");
        
        // Add the text fields to the panel
        add(mainHand);
        add(offHandCheckBox);
        add(helm);
        add(offHand);
        add(chest);
        add(ears);
        add(gloves);
        add(neck);
        add(belt);
        add(wrist);
        add(legs);
        add(ring1);
        add(feet);
        add(ring2);
    }
    
    public int[] getValues()
    {
        String[] strItemLevels = new String[13];
        int[] itemLevels = new int[13];
        strItemLevels[0] = mainHand.getText();
        if (offHandCheckBox.isSelected())
            strItemLevels[1] = offHand.getText();
        else
            strItemLevels[1] = mainHand.getText();
        strItemLevels[2] = helm.getText();
        strItemLevels[3] = chest.getText();
        strItemLevels[4] = gloves.getText();
        strItemLevels[5] = belt.getText();
        strItemLevels[6] = legs.getText();
        strItemLevels[7] = feet.getText();
        strItemLevels[8] = ears.getText();
        strItemLevels[9] = neck.getText();
        strItemLevels[10] = wrist.getText();
        strItemLevels[11] = ring1.getText();
        strItemLevels[12] = ring2.getText();
        for (int i=0; i<13; i++)
        {
            itemLevels[i] = Integer.parseInt(strItemLevels[i]);
        }
        return itemLevels;
    }
}