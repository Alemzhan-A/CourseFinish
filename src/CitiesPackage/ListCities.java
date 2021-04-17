package CitiesPackage;

import Admin.ButtonRenderer;
import Admin.MainFrame;
import Admin.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class ListCities extends JPanel {
    private MainFrame parent;
    private JButton backbutton;
    private JScrollPane scrollPane;
    private JTable table;
    private ButtonRenderer renderer = new ButtonRenderer();

    public ListCities(MainFrame parent) {
        this.parent = parent;
        setSize(600, 600);
        setLayout(null);

        backbutton = new JButton("BACK");
        backbutton.setBounds(170, 400, 250, 50);
        backbutton.addActionListener(e -> {
            parent.getCitiesPage().setVisible(true);
            parent.getListCities().setVisible(false);
        });
        add(backbutton);

        table = new JTable();
        table.setFont(new Font("Montserrat", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.addMouseListener(new MouseListener(table, parent, this));

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(580, 370);
        scrollPane.setLocation(5, 10);
        add(scrollPane);

    }

    public void generateTable() {
        ArrayList<Cities> cities = parent.getDbManager().ListCities();

        CitiesTableModel model = new CitiesTableModel(cities);
        table.setModel(model);
        table.getColumn("EDIT").setCellRenderer(renderer);
    }
}
