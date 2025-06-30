import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class GUI {
    private final JPanel panel;
    private final JFrame frame;
    private String makeSelection, yearSelection, mileageInput;
    private JLabel labelMileage;
    private JFormattedTextField mileage;
    private JButton enterButton;
    private JComboBox fordList;
    private JComboBox hondaList;
    private JComboBox toyotaList;
    private JComboBox hyundaiList;
    private JComboBox chevroletList;
    private JLabel labelModel;

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

    public void listOfYears() {
        JLabel labelYear = new JLabel("Vehicle Year");
        labelYear.setFont(new Font("Arial", Font.PLAIN, 15));
        labelYear.setHorizontalAlignment(2);
        panel.add(labelYear);
        String[] carYears = {
                "Select Year",
                "2010",
                "2011",
                "2012",
                "2013",
                "2014",
                "2015",
                "2016",
                "2017",
                "2018",
                "2019",
                "2020"
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

    public void listOfMakes() {
        JLabel labelMake = new JLabel("Vehicle Make");
        labelMake.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(labelMake);
        String[] carMakes = {
                "Select Make",
                "Ford",
                "Chevrolet",
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
    public void makeAddition() {
        modelLabel();
        if (makeSelection.equals("Ford")) {
            String[] fordModel = {
                    "Explorer",
                    "Edge",
                    "Maverick",
                    "Transit",
                    "F-Series",
                    "Bronco",
                    "Mustang",
                    "Expedition",
                    "Bronco Sport"
            };
            fordList = new JComboBox(fordModel);
            panel.add(fordList);
            textboxForMileage();
        }
        if (makeSelection.equals("Honda")) {
            String[] hondaModel = {
                    "CR-V",
                    "Civic",
                    "Accord",
                    "Pilot",
                    "HR-V",
                    "Odyssey",
                    "Prologue",
                    "Ridgeline",
                    "Passport"
            };
            hondaList = new JComboBox(hondaModel);
            panel.add(hondaList);
            textboxForMileage();

        }
        if (makeSelection.equals("Hyundai")) {
            String[] hyundaiModel = {
                    "Tucson",
                    "Elantra",
                    "Palisade",
                    "Santa Fe",
                    "Kona",
                    "Ioniq-5",
                    "Sonata",
                    "Santa Cruz",
                    "Venue"
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
                    "Highlander",
                    "Tacoma",
                    "Tundra",
                    "Sienna",
                    "4Runner",
                    "Prius"
            };
            toyotaList = new JComboBox(toyotaModel);
            panel.add(toyotaList);
            textboxForMileage();

        }
        if (makeSelection.equals("Chevrolet")) {
            {
                String[] chevroletModel = {
                        "Trailblazer",
                        "Colorado",
                        "Equinox",
                        "Malibu",
                        "Silverado LD",
                        "Silverado HD",
                        "Tahoe",
                        "Trax",
                        "Traverse"
                };
                chevroletList = new JComboBox(chevroletModel);
                panel.add(chevroletList);
                textboxForMileage();
            }

        }
        panel.revalidate();
        frame.pack();
    }

    public void makeDeletion()
    {
        if (fordList != null) {
            panel.remove(fordList);
            fordList = null;
        }
        if (hondaList != null) {
            panel.remove(hondaList);
            hondaList = null;
        }
        if (hyundaiList != null) {
            panel.remove(hyundaiList);
            hyundaiList = null;
        }
        if (chevroletList != null) {
            panel.remove(chevroletList);
            chevroletList = null;
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

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        panel.add(enterButton);
        mileage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                 mileageInput = mileage.getSelectedText();
                activateEnter();
            }
        });
    }
    public void modelLabel() {
        labelModel = new JLabel("Model");
        labelModel.setFont(new Font("Arial", Font.PLAIN, 15));
        labelModel.setHorizontalAlignment(2);
        panel.add(labelModel);
    }

}