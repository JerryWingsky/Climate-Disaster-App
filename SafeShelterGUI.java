package com.nono.groupproject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class SafeShelterGUI extends JFrame {
    
    private JTextField txtfield;
    private final JLabel label;
    private final TableModel model;
    private JTable table;
    private final TableRowSorter sorter;
    private final JScrollPane scroll;
    private final JButton sButton;
    private final JButton rButton;
    
    public SafeShelterGUI() {
        setTitle("Shelter Location");                
        setLayout(new FlowLayout(FlowLayout.CENTER));
        txtfield = new JTextField(15);
        label = new JLabel("What do you want to Search?"); 
        sButton = new JButton("Search");
        rButton = new JButton("Return");
        
        String[] searchName = {"Name", "Link"};
        Object[][] nameShelter = {
            {"Anjung Singgah","https://yknm.org.my/anjung-singgah-ykn/"},
            {"Global Street Mission","https://www.ngohub.asia/organizations/global-street-mission-kuala-lumpur"},
            {"Salvation Army Malaysia","https://www.salvationarmy.org.my/"},
            {"Pusat Transit Gelandangan Kuala Lumpur","https://www.facebook.com/PusatTransitGelandanganKL"},
            {"Women Aid Organisation (WAO)","http://www.wao.org.my"},
            {"Women's Centre for Change (WCC) Penang","http://wccpenang.org"},
};
        
        model = new DefaultTableModel(nameShelter, searchName);
        sorter = new TableRowSorter <> (model);
        table = new JTable(model) {
        @Override
    public boolean isCellEditable(int row, int column) {
        return false;
}
};
        
        table.setRowSorter(sorter);
        scroll = new JScrollPane(table);
        
        add(label);
        add(txtfield);
        add(sButton);
        add(rButton);
        add(scroll);
        
        txtfield.getDocument().addDocumentListener(new DocumentListener(){
        @Override
    public void insertUpdate(DocumentEvent e) {
        search(txtfield.getText());
}
        
        @Override
    public void removeUpdate(DocumentEvent e) {
        search(txtfield.getText());
}
        
        @Override
    public void changedUpdate(DocumentEvent e) {
        search(txtfield.getText());
}
});
        
        sButton.addActionListener(new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        if (row != -1) {
        try {
        Desktop.getDesktop().browse(new URI((String) table.getValueAt(row, 1)));
}       catch (IOException | URISyntaxException ex) {
}
}
}
});
        
        rButton.addActionListener(new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
}
});
        
        setSize(475, 250);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); 
        setVisible(true);
}  
      
    private void search(String str) {
        String searchText = str.toLowerCase();
        sorter.setRowFilter(
        str.length() == 0 ? null : RowFilter.regexFilter("(?i)" + searchText));
}
   
/*  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        @Override
    public void run() {
        new SafeShelterGUI();
}
});
}*/

    void createAndShowGUI() {
}
}
