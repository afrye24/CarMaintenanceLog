import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.NumberFormat;
/*
    This class represents the GUI of the Car Maintenance Tool.
    Author: Aniya Frye 6/30/2025
 */
public class GUI {
    private final JPanel panel;
    private final JFrame frame;
    private String makeSelection;
    private String yearSelection;
    private String mileInput;
    private JLabel labelMileage;
    private JFormattedTextField mileage;
    private JButton enterButton;
    private JComboBox hondaList;
    private JComboBox toyotaList;
    private JComboBox hyundaiList;
    private JLabel labelModel;

// Creates the frame and overall setup of the GUI for the maintenance tool

    GUI() {

        frame = new JFrame(" Car Maintenance Tool");
        panel = new JPanel(new GridLayout(5, 4, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        listOfYears();
        listOfMakes();
        frame.setVisible(true);
        frame.pack();
    }
// Creates the 2005-2010 year options for the user to choose from

    public void listOfYears() {
        JLabel labelYear = new JLabel("Vehicle Year");
        labelYear.setFont(new Font("Arial", Font.PLAIN, 15));
        labelYear.setHorizontalAlignment(2);
        panel.add(labelYear);
        String[] carYears = {
                "Select Year",
                "2020",
                "2021",
                "2022",
                "2023",
                "2024",
                "2025"
        };
        JComboBox yearsList = new JComboBox(carYears);
        yearsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                yearSelection = yearsList.getSelectedItem().toString();
            }
        });
        panel.add(yearsList);
    }
//Creates the list of 5 make options for the user to choose from
//Once a make is selected, the action listener calls for the model options to appear for the specific make
    public void listOfMakes() {
        JLabel labelMake = new JLabel("Vehicle Make");
        labelMake.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(labelMake);
        String[] carMakes = {
                "Select Make",
                "Toyota",
                "Hyundai",
                "Honda"
        };
        JComboBox makeList = new JComboBox(carMakes);
        panel.add(makeList);

        makeList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeSelection = makeList.getSelectedItem().toString();
                makeDeletion();
                makeAddition();
                panel.revalidate();
                frame.pack();
            }
        });
    }
    //Creates the model list for the make chosen
    public void makeAddition() {
        modelLabel();

        if (makeSelection.equals("Honda")) {
            String[] hondaModel = {
                    "CR-V",
                    "Civic",
                    "Accord",
                    "Pilot",
                    "HR-V",
                    "Odyssey",
            };
            hondaList = new JComboBox(hondaModel);
            panel.add(hondaList);
            textboxForMileage();

        }
        if (makeSelection.equals("Hyundai")) {
            String[] hyundaiModel = {
                    "Tucson",
                    "Elantra",
                    "Santa Fe",
                    "Kona",
                    "Sonata",
                    "Santa Cruz",
            };
            hyundaiList = new JComboBox(hyundaiModel);
            panel.add(hyundaiList);
            textboxForMileage();

        }
        if (makeSelection.equals("Toyota")) {
            String[] toyotaModel = {
                    "Camry",
                    "Corolla",
                    "RAV4",
                    "Sienna",
                    "4Runner",
                    "Prius"
            };
            toyotaList = new JComboBox(toyotaModel);
            panel.add(toyotaList);
            textboxForMileage();

        }
        panel.revalidate();
        frame.pack();
    }
//Deletes the model list if the make is changed or unselected
    public void makeDeletion()
    {
        if (hondaList != null) {
            panel.remove(hondaList);
            hondaList = null;
        }
        if (hyundaiList != null) {
            panel.remove(hyundaiList);
            hyundaiList = null;
        }
        if (toyotaList != null) {
            panel.remove(toyotaList);
            toyotaList = null;
        }
        if (labelModel != null) {
            panel.remove(labelModel);
            labelModel = null;
        }
        if (labelMileage != null) {
            panel.remove(labelMileage);
            labelMileage = null;
        }
        if (mileage != null) {
            panel.remove(mileage);
            mileage = null;
        }
        if (enterButton != null) {
            panel.remove(enterButton);
            enterButton = null;
        }
        frame.pack();
    }
//Activates the enter button once a year and make is selected by the user
    public void activateEnter()
    {
        //if vehicle year, mileage, make, and model all have selected values, activate the enter button

        if(yearSelection != null && makeSelection != null)
        {
            enterButton.setEnabled(true);
            panel.revalidate();
            frame.pack();
        }
    }
//Creates the mileage box that only allows numbers to be inserted
    public void textboxForMileage() {
        labelMileage = new JLabel("Vehicle Mileage");
        labelMileage.setFont(new Font("Arial", Font.PLAIN, 15));
        labelMileage.setHorizontalAlignment(2);
        panel.add(labelMileage);

        NumberFormat mileageFormat = NumberFormat.getIntegerInstance();
        NumberFormatter mileageFormatter = new NumberFormatter(mileageFormat);
        mileageFormatter.setAllowsInvalid(false);
        mileage = new JFormattedTextField(mileageFormatter);
        panel.add(mileage);

        enterButton = new JButton("Enter for Recommended Maintenance");
        enterButton.setVerticalTextPosition(AbstractButton.CENTER);
        enterButton.setHorizontalTextPosition(AbstractButton.LEADING);
        enterButton.setMnemonic(KeyEvent.VK_ENTER);
        enterButton.setEnabled(false);


        panel.add(enterButton);
        mileage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                  mileInput = mileage.getText();
                activateEnter();
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            }
        });
    }
//Creates the model label for the GUI
    public void modelLabel() {
        labelModel = new JLabel("Model");
        labelModel.setFont(new Font("Arial", Font.PLAIN, 15));
        labelModel.setHorizontalAlignment(2);
        panel.add(labelModel);
    }


}