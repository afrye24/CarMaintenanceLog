import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class GUI
{
    private JPanel panel;
    private JFrame frame;
    private String ford;
    private String honda;
    private String chevrolet;
    private String hyundai;
    private String toyota;
    private JLabel selectMake;

    GUI() {
        frame = new JFrame(" Car Maintenance Tool");
        panel = new JPanel(new GridLayout(5,4,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        ford = "Ford";
        honda = "Honda";
        chevrolet = "Chevrolet";
        toyota = "Toyota";
        hyundai = "Hyundai";
        listOfYears();
        listOfMakes();
        modelLabel();
        textboxForMileage();
        frame.setVisible(true);
        frame.pack();
    }
    public void listOfYears()
    {
        JLabel labelYear = new JLabel("Vehicle Year");
        labelYear.setFont(new Font("Arial", Font.PLAIN, 15));
        labelYear.setHorizontalAlignment(2);
        panel.add(labelYear);
        String[] carYears = {
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
            public void actionPerformed(ActionEvent e) {

            }
        });


        panel.add(yearsList);


    }

    public void listOfMakes()
    {
        JLabel labelMake = new JLabel("Vehicle Make");
        labelMake.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(labelMake);
        String[] carMakes = {
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
            public void actionPerformed(ActionEvent e)
            {
                String selection = makeList.getSelectedItem().toString();
                if(selection.equals(ford))
                {
                    fordModels();
                }
                else if(selection.equals(honda))
                {
                    hondaModels();
                }
                else if(selection.equals(hyundai))
                {
                    hyundaiModels();
                }
                else if(selection.equals(toyota))
                {
                    toyotaModels();
                }
                else if(selection.equals(chevrolet))
                {
                    chevroletModels();
                }

            }
        });
    }

    public void textboxForMileage()
{
    JLabel labelMileage = new JLabel("Vehicle Mileage");
    labelMileage.setFont(new Font("Arial", Font.PLAIN, 15));
    labelMileage.setHorizontalAlignment(2);
    panel.add(labelMileage);

    NumberFormat mileageFormat = NumberFormat.getIntegerInstance();
    NumberFormatter mileageFormatter = new NumberFormatter(mileageFormat);
    mileageFormatter.setAllowsInvalid(false);
    JFormattedTextField mileage = new JFormattedTextField(mileageFormatter);
    panel.add(mileage);

    JButton enterButton = new JButton("Enter for Recommended Maintenance");
    enterButton.setVerticalTextPosition(AbstractButton.CENTER);
    enterButton.setHorizontalTextPosition(AbstractButton.LEADING);
    enterButton.setMnemonic(KeyEvent.VK_ENTER);
    enterButton.setEnabled(false);
    enterButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    panel.add(enterButton);
    mileage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
public void modelLabel()
{
    JLabel labelModel = new JLabel("Model");
    labelModel.setFont(new Font("Arial", Font.PLAIN, 15));
    labelModel.setHorizontalAlignment(2);
    panel.add(labelModel);
    selectMake = new JLabel("Select Make");
    selectMake.setFont(new Font("Arial", Font.PLAIN, 15));
    panel.add(selectMake);
    selectMake.isOpaque();
}
public void fordModels()
{
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
    JComboBox fordList = new JComboBox(fordModel);
    panel.add(fordList);
}
public void toyotaModels()
{
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
    JComboBox toyotaList = new JComboBox(toyotaModel);
    panel.add(toyotaList);
}
public void hyundaiModels()
{
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
    JComboBox hyundaiList = new JComboBox(hyundaiModel);
    panel.add(hyundaiList);
}
public void hondaModels()
{
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
    JComboBox hondaList = new JComboBox(hondaModel);
        panel.add(hondaList);
}

public void chevroletModels()
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
    JComboBox chevroletList = new JComboBox(chevroletModel);
        panel.add(chevroletList);

}


}
