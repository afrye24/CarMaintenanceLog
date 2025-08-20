import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
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
// Creates the 2008 year option for the user to choose

    public void listOfYears() {
        JLabel labelYear = new JLabel("Vehicle Year");
        labelYear.setFont(new Font("Arial", Font.PLAIN, 15));
        labelYear.setHorizontalAlignment(2);
        panel.add(labelYear);
        String[] carYears = {
                "Select Year",
                "2008"
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
//Creates the list of make options for the user to choose from
//Once a make is selected, the action listener calls for the model options to appear for the specific make
    public void listOfMakes() {
        JLabel labelMake = new JLabel("Vehicle Make");
        labelMake.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(labelMake);
        String[] carMakes = {
                "Select Make",
                "Toyota"
        };
        JComboBox makeList = new JComboBox(carMakes);
        panel.add(makeList);

        makeList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeSelection = makeList.getSelectedItem().toString();
                makeAddition();
                panel.revalidate();
                frame.pack();
            }
        });
    }
    //Creates the model list for the make chosen
    public void makeAddition() {
        modelLabel();
        if (makeSelection.equals("Toyota")) {
            String[] toyotaModel = {
                    "Scion xB",
            };
            toyotaList = new JComboBox(toyotaModel);
            panel.add(toyotaList);
            textboxForMileage();
        }
        panel.revalidate();
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
                maintenanceRecommendation();
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
    //Creates the recommendation of maintenance based on the mileage entered into the tool
    // after pressing the enter button
    public void maintenanceRecommendation()
    {
        int mile = Integer.parseInt(mileInput.replace(",", ""));

        if(mile < 5000)
        {
            JOptionPane.showMessageDialog(frame,
                    "No maintenance needs to be done.",
                    "Maintenance Recommendation",
                    JOptionPane.PLAIN_MESSAGE);
        }
        else if (mile >= 5000 && mile < 10000)
        {
            everyFiveThousand();
        }
        else if (mile >= 10000 && mile < 15000)
        {
            everyFiveThousand();
        }
        else if (mile >= 15000 && mile < 20000)
        {
            everyFifteenThousand();

        }
        else if (mile >= 20000 && mile < 25000)
        {
            everyFiveThousand();
        }
        else if (mile >= 25000 && mile < 30000)
        {
            everyFiveThousand();
        }
        else if (mile >= 30000 && mile < 35000)
        {
            everyThirtyThousand();
        }
        else if (mile >= 35000 && mile < 40000)
        {
            everyFiveThousand();
        }
        else if (mile >= 40000 && mile < 45000)
        {
            everyFiveThousand();
        }
        else if (mile >= 45000 && mile < 50000)
        {
            everyFifteenThousand();

        }
        else if (mile >= 50000 && mile < 55000)
        {
            everyFiveThousand();
        }
        else if (mile >= 55000 && mile < 60000)
        {
            everyFiveThousand();
        }
        else if (mile >= 60000 && mile < 65000)
        {
            everyThirtyThousand();
        }
        else if (mile >= 65000 && mile < 70000)
        {
            everyFiveThousand();
        }
        else if (mile >= 70000 && mile < 75000)
        {
            everyFiveThousand();
        }
        else if (mile >= 75000 && mile < 80000)
        {
            everyFifteenThousand();
        }
        else if (mile >= 80000 && mile < 85000)
        {
            everyFiveThousand();
        }
        else if (mile >= 85000 && mile < 90000)
        {
            everyFiveThousand();
        }
        else if (mile >= 90000 && mile < 95000)
        {
            everyThirtyThousand();
        }
        else if (mile >= 95000 && mile < 100000)
        {
            everyFiveThousand();
        }
        else if (mile >= 100000 && mile < 105000)
        {
            everyFiveThousand();
        }
        else if (mile >= 105000 && mile < 110000)
        {
            everyFifteenThousand();
        }
        else if (mile >= 110000 && mile < 115000)
        {
            everyFiveThousand();
        }
        else if (mile >= 115000 && mile < 120000)
        {
            everyFiveThousand();
        }
        else if (mile >=120000 && mile < 125000)
        {
            JOptionPane.showMessageDialog(frame,
                    "Replace cabin air filter\n"+
                            "Replace engine air filter\n" +
                            "Replace engine oil and oil filter\n"+
                            "Replace spark plugs\n"+
                            "Rotate tires\n"+

                            "Inspect the:\n" +
                            "Brake linings/drums and brake pads/discs\n" +
                            "Drive shaft boots\n" +
                            "Ball joints and dust covers\n" +
                            "Brake lines and hoses\n" +
                            "Drive shaft boots\n" +
                            "Engine coolant \n" +
                            "Exhaust pipes and mountings\n" +
                            "Steering gear box\n" +
                            "Front differential oil\n" +
                            "Fuel lines and connections, fuel tank band and fuel tank " +
                            "vapor vent system hoses\n" +
                            "Fuel tank cap gasket\n" +
                            "Transmission fluid or oil\n" +
                            "Steering linkage and boots",
                    "Maintenance Recommendation",
                    JOptionPane.PLAIN_MESSAGE);
        }
        else if (mile >= 125000 && mile < 130000)
        {
            everyFiveThousand();
        }
        else if (mile >= 130000 && mile < 135000)
        {
            everyFiveThousand();
        }
        else if (mile >= 135000 && mile < 140000)
        {
            everyFifteenThousand();

        }
        else if (mile >= 140000 && mile < 145000)
        {
            everyFiveThousand();
        }
        else if (mile >= 145000 && mile < 150000)
        {
            everyFiveThousand();
        }
        else if (mile >= 150000 && mile < 155000)
        {
            everyThirtyThousand();
        }
        else if (mile >= 155000 && mile < 160000)
        {
            everyFiveThousand();
        }
        else if (mile >= 160000 && mile < 165000)
        {
            everyFiveThousand();
        }
        else if (mile >= 165000 && mile < 170000)
        {
            everyFifteenThousand();

        }
        else if (mile >= 170000 && mile < 175000)
        {
            everyFiveThousand();
        }
        else if (mile >= 175000 && mile < 180000)
        {
            everyFiveThousand();
        }
        else if (mile >= 180000 && mile < 185000)
        {
            everyThirtyThousand();
        }
        else if (mile >= 185000 && mile < 190000)
        {
            everyFiveThousand();
        }
        else if (mile >= 190000 && mile < 195000)
        {
            everyFiveThousand();
        }
        else if (mile >= 195000 && mile < 200000)
        {
            everyFifteenThousand();
        }
        else if (mile >= 200000 && mile < 205000)
        {
            everyFiveThousand();
        }
        else if (mile >= 205000 && mile < 210000)
        {
            everyFiveThousand();
        }
        else if (mile >= 210000 && mile < 215000)
        {
            everyThirtyThousand();
        }
        else if (mile >= 215000 && mile < 220000)
        {
            everyFiveThousand();
        }
        else if (mile >= 220000 && mile < 225000)
        {
            everyFiveThousand();
        }
        else if (mile >= 225000 && mile < 230000)
        {
            everyFifteenThousand();
        }
        else if (mile >= 230000 && mile < 235000)
        {
            everyFiveThousand();
        }
        else if (mile >= 235000 && mile < 240000)
        {
            everyFiveThousand();
        }
        else if (mile >=240000 && mile < 245000)
        {
            JOptionPane.showMessageDialog(frame,
                    "Replace cabin air filter\n"+
                            "Replace engine air filter\n" +
                            "Replace engine oil and oil filter\n"+
                            "Replace spark plugs\n"+
                            "Rotate tires\n"+

                            "Inspect the:\n" +
                            "Brake linings/drums and brake pads/discs\n" +
                            "Drive shaft boots\n" +
                            "Ball joints and dust covers\n" +
                            "Brake lines and hoses\n" +
                            "Drive shaft boots\n" +
                            "Engine coolant \n" +
                            "Exhaust pipes and mountings\n" +
                            "Steering gear box\n" +
                            "Front differential oil\n" +
                            "Fuel lines and connections, fuel tank band and fuel tank " +
                            "vapor vent system hoses\n" +
                            "Fuel tank cap gasket\n" +
                            "Transmission fluid or oil\n" +
                            "Steering linkage and boots",
                    "Maintenance Recommendation",
                    JOptionPane.PLAIN_MESSAGE);
        }

    }
    //Creates the maintenance recommendations for every 5000 miles of the Scion xB
    public void everyFiveThousand()
    {
        JOptionPane.showMessageDialog(frame,
                "Replace engine oil and oil filter\n"+
                        "Rotate tires\n" +
                        "Visually inspect brake linings/drums" +
                        " and brake pads/discs",
                "Maintenance Recommendation",
                JOptionPane.PLAIN_MESSAGE);
    }
    //Creates the maintenance recommendations for every 15000 miles of the Scion xB
        public void everyFifteenThousand()
        {
            JOptionPane.showMessageDialog(frame,
                    "Replace engine oil and oil filter\n"+
                            "Rotate tires\n" +
                            "Visually inspect brake linings/drums" +
                            " and brake pads/discs\n"+
                            "Inspect the:\n" +
                            "Ball joints and dust covers\n" +
                            "Brake lines and hoses\n" +
                            "Drive shaft boots\n" +
                            "Engine coolant \n" +
                            "Exhaust pipes and mountings\n" +
                            "Steering gear box\n" +
                            "Steering linkage and boots",
                    "Maintenance Recommendation",
                    JOptionPane.PLAIN_MESSAGE);
        }
    //Creates the maintenance recommendations for every 30000 miles of the Scion xB

    public void everyThirtyThousand()
        {
            JOptionPane.showMessageDialog(frame,
                    "Replace cabin air filter\n"+
                            "Replace engine air filter\n" +
                            "Replace engine oil and oil filter\n"+
                            "Rotate tires\n"+

                            "Inspect the:\n" +
                            "Brake linings/drums and brake pads/discs\n" +
                            "Drive shaft boots\n" +
                            "Ball joints and dust covers\n" +
                            "Brake lines and hoses\n" +
                            "Drive shaft boots\n" +
                            "Engine coolant \n" +
                            "Exhaust pipes and mountings\n" +
                            "Steering gear box\n" +
                            "Front differential oil\n" +
                            "Fuel lines and connections, fuel tank band and fuel tank" +
                            "vapor vent system hoses\n" +
                            "Fuel tank cap gasket\n" +
                            "Transmission fluid or oil\n" +
                            "Steering linkage and boots",
                    "Maintenance Recommendation",
                    JOptionPane.PLAIN_MESSAGE);
        }
}