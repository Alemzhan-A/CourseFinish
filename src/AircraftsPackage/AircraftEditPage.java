package AircraftsPackage;

import Admin.MainFrame;

import javax.swing.*;

public class AircraftEditPage extends JPanel {
    private MainFrame parent;

    private JLabel name, model, bc_capacity,ec_capacity;
    private JTextField nameText,modelText, bc_capacityText, ec_capacityText;
    private JButton save, back, delete;

    private Aircrafts aircraft = null;

    public AircraftEditPage(MainFrame parent) {
        this.parent = parent;

        setSize(600, 600);
        setLayout(null);

        name = new JLabel("Name: ");
        name.setBounds(90, 50, 100, 30);
        add(name);

        model = new JLabel("Model: ");
        model.setBounds(90, 100, 100, 30);
        add(model);

        bc_capacity = new JLabel("BC capacity: ");
        bc_capacity.setBounds(90, 150, 100, 30);
        add(bc_capacity);

        ec_capacity = new JLabel("EC capacity: ");
        ec_capacity.setBounds(90, 200, 100, 30);
        add(ec_capacity);

        nameText = new JTextField();
        nameText.setBounds(220, 50, 250, 30);
        add(nameText);

        modelText = new JTextField();
        modelText.setBounds(220, 100, 250, 30);
        add(modelText);

         bc_capacityText= new JTextField();
        bc_capacityText.setBounds(220, 150, 250, 30);
        add(bc_capacityText);

        ec_capacityText= new JTextField();
        ec_capacityText.setBounds(220, 200, 250, 30);
        add(ec_capacityText);

        back = new JButton("BACK");
        back.setSize(200,55);
        back.setLocation(180,400);
        back.addActionListener(e->{
            parent.getAircraftEditPage().setVisible(false);
            parent.getListAircrafts().generateTable();
            parent.getListAircrafts().setVisible(true);
        });
        add(back);

        save = new JButton("SAVE");
        save.setSize(200,40);
        save.setLocation(300,310);
        save.addActionListener(e->{
            Long id = null;
            String name = nameText.getText();
            String model = modelText.getText();
            int bc_capacity = Integer.parseInt(bc_capacityText.getText());
            int ec_capacity = Integer.parseInt(ec_capacityText.getText());

            aircraft.setName(name);
            aircraft.setModel(model);
            aircraft.setBusiness_class_capacity(bc_capacity);
            aircraft.setEconom_class_capcity(ec_capacity);

            if (parent.getDbManager().saveAircrafts(aircraft)){
                System.out.println("SAVE COMPLETE!");
            } else
                System.out.println("ERROR!");
        });
        add(save);

        delete = new JButton("DELETE");
        delete.setSize(200,40);
        delete.setLocation(80,310);
        delete.addActionListener(e->{
            if (parent.getDbManager().deleteAircraft(aircraft.getId())){
                System.out.println("DELETE COMPLETE!");
            } else
                System.out.println("cannot delete!");

            parent.getAircraftEditPage().setVisible(false);
            parent.getListAircrafts().generateTable();
            parent.getListAircrafts().setVisible(true);
        });
        add(delete);


    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
        nameText.setText(aircraft.getName());
        modelText.setText(aircraft.getModel());
        bc_capacityText.setText(aircraft.getBusiness_class_capacity() + "");
        ec_capacityText.setText(aircraft.getEconom_class_capcity()+"");
    }
}
