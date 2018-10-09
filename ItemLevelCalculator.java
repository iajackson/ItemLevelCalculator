/*
    Tool used to calculate the average iLvl of all equipped gear in FFXIV
*/

import java.util.Scanner;
import java.io.*;
import javax.swing.*;       // Used for GUI components
import java.awt.*;          // Used for layout managers
import java.awt.event.*;    // Used for Event Listeners

public class ItemLevelCalculator extends JFrame
{
    private InputPanel inputs;              // Contains all input items
    private JButton calcButton;             // Calculate button
    private JButton saveButton;             // Save button
    private JButton loadButton;             // Load button
    private JPanel buttonPanel;             // Contains all buttons
    private JPanel labelPanel;              // Contains the labels with result
    private JLabel iLvlResult;              // Label with the result
    
    /**
        Constructor
    */
    public ItemLevelCalculator()
    {
        // Display a title
        setTitle("Item Level Calculator");
        
        // Specify action for close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create BorderLayout manager
        setLayout(new BorderLayout());
        
        // Create text field panel
        inputs = new InputPanel();
        
        // Create button panel
        buildButtonPanel();
        
        buildLabelPanel();
        
        //Add components to content pane
        add(inputs, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
        add(labelPanel, BorderLayout.SOUTH);
        
        // Pack contents of window, centre on screen, and display it
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
        Builds the button panel
    */
    private void buildButtonPanel()
    {
        // Create panel
        buttonPanel = new JPanel();
        
        // Set GridLayout for 3 rows 1 column
        buttonPanel.setLayout(new GridLayout(3,1));
        
        // Create 3 buttons
        calcButton = new JButton("Calculate");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        
        // Add action listeners for buttons
        calcButton.addActionListener(new CalcButtonListener());
        saveButton.addActionListener(new SaveButtonListener());
        loadButton.addActionListener(new LoadButtonListener());
        
        // Add buttons to panel
        buttonPanel.add(calcButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
    }
    
    /**
        Builds the label panel
    */
    private void buildLabelPanel()
    {
        // Create panel
        labelPanel = new JPanel();
        
        // Create label
        iLvlResult = new JLabel("The calculated iLvl is: ");
        
        // Add label to panel
        labelPanel.add(iLvlResult);
    }
    
    /**
        Private inner class that handles the event when
        the user clicks the Calculate button
    */
    private class CalcButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int values[] = inputs.getValues();
            int sum = 0;
            double average;
            if (values != null)
            {
                for (int val : values)
                {
                    sum += val;
                }
                average = sum / 13.0;
                //JOptionPane.showMessageDialog(null, average);
                iLvlResult.setText(String.format("The calculated iLvl is: %.2f", average));
            }
        }
    }
    
    /**
        Private inner class that handles the event when
        the user clicks the Save button
    */
    private class SaveButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Save not yet implemented");
        }
    }
    
    /**
        Private inner class that handles the event when
        the user clicks the Load button
    */
    private class LoadButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Load not yet implemented");
        }
    }
    
    /**
        Main method
    */
    public static void main(String[] args) throws IOException
    {
        new ItemLevelCalculator();
    }

    /*
        #####################################
        METHODS BELOW HERE NOT CURRENTLY USED
        #####################################
    */
    
    /**
        Save the current values to file
        @param values The values to save to file
    */
    //TODO: Update to output to binary file
    private static void saveValues(int[] values) throws IOException
    {
        PrintWriter out = new PrintWriter("data.txt");
        for (int value : values)
        {
            out.println(value);
        }
        out.close();
    }
    
    /**
        Load values from file
        @return The values loaded from file
    */
    //TODO: Update to input from binary file
    private static int[] loadValues() throws IOException
    {
        int[] values = new int[13];
        int counter = 0;
        File inFile = new File("data.txt");
        Scanner inScan = new Scanner(inFile);
        while (inScan.hasNext())
        {
            values[counter] = inScan.nextInt();
            counter++;
        }
        return values;
    }
}