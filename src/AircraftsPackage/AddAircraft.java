package AircraftsPackage;

import Admin.MainFrame;

import javax.swing.*;

public class AddAircraft extends JPanel {
    private MainFrame parent;
    private JButton backbutton,addbutton;
    private JLabel name,model,econom_class_capcity,business_class_capacity;
    private JTextField aname,amodel,aeconom_class_capacity,abusiness_class_capacity;
    public AddAircraft(MainFrame parent){
        this.parent = parent;
        setLayout(null);
        setSize(600,600);

        name = new JLabel("NAME:");
        name.setLocation(150,70);
        name.setSize(100,100);
        add(name);

        model = new JLabel("MODEL:");
        model.setLocation(150,120);
        model.setSize(100,100);
        add(model);

        econom_class_capcity = new JLabel("EC CAPACITY:");
        econom_class_capcity.setLocation(150,170);
        econom_class_capcity.setSize(100,100);
        add(econom_class_capcity);

        business_class_capacity = new JLabel("BC CAPACITY:");
        business_class_capacity.setLocation(150,220);
        business_class_capacity.setSize(100,100);
        add(business_class_capacity);

        aname = new JTextField();
        aname.setSize(150,30);
        aname.setLocation(250,105);
        add(aname);

        amodel = new JTextField();
        amodel.setSize(150,30);
        amodel.setLocation(250,155);
        add(amodel);

        aeconom_class_capacity = new JTextField();
        aeconom_class_capacity.setSize(150,30);
        aeconom_class_capacity.setLocation(250,205);
        add(aeconom_class_capacity);

        abusiness_class_capacity = new JTextField();
        abusiness_class_capacity.setSize(150,30);
        abusiness_class_capacity.setLocation(250,255);
        add(abusiness_class_capacity);

        backbutton = new JButton("BACK");
        backbutton.setSize(320,40);
        backbutton.setLocation(130,400);
        backbutton.addActionListener(e -> {
            parent.getAddAircraft().setVisible(false);
            parent.getAircraftsPage().setVisible(true);
        });
        add(backbutton);

        addbutton = new JButton("ADD");
        addbutton.setLocation(165,350);
        addbutton.setSize(250,40);
        addbutton.addActionListener(e -> {
            String name = aname.getText();
            String model = amodel.getText();
            int ec = Integer.parseInt(aeconom_class_capacity.getText());
            int bc = Integer.parseInt(abusiness_class_capacity.getText());
            Aircrafts aircrafts = new Aircrafts(null,name,model,ec,bc);
            if(parent.getDbManager().addAircraft(aircrafts)){
                System.out.println("COMPLETE!");
                aname.setText("");
                amodel.setText("");
                aeconom_class_capacity.setText("");
                abusiness_class_capacity.setText("");
            }else{
                System.out.println("ERROR!");
            }

        });
        add(addbutton);
    }


}
