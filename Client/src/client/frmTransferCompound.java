package client;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class frmTransferCompound extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JTextField txtPlateName = new JTextField();
    private JTextField txtCompound = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JComboBox cmbPlates = new JComboBox();
    private JLabel jLabel4 = new JLabel();
    private JComboBox cmbWells = new JComboBox();
    private JList lstPlateWells = new JList();
    private JButton btnAdd = new JButton();
    private JButton btnTransfer = new JButton();

    private DefaultListModel lstModel = new DefaultListModel();
    String PlateName;
    String Compound;
    List<Plate> Plates;
    private JLabel jLabel5 = new JLabel();

    public frmTransferCompound() {
        this(null, "", false);
    }

    public frmTransferCompound(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
            
            lstPlateWells.setModel(lstModel);
            
            // Load the wells
            LoadWells();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(382, 288));
        this.getContentPane().setLayout( null );
        this.setTitle("Transfer Compound");
        jLabel1.setText("Plate Name:");
        jLabel1.setBounds(new Rectangle(15, 20, 60, 15));
        jLabel2.setText("Compound:");
        jLabel2.setBounds(new Rectangle(15, 45, 65, 15));
        txtPlateName.setBounds(new Rectangle(80, 15, 105, 20));
        txtPlateName.setFocusable(false);
        txtCompound.setBounds(new Rectangle(80, 40, 105, 20));
        txtCompound.setFocusable(false);
        jLabel3.setText("Plate:");
        jLabel3.setBounds(new Rectangle(15, 90, 35, 15));
        cmbPlates.setBounds(new Rectangle(50, 85, 115, 20));
        jLabel4.setText("Well:");
        jLabel4.setBounds(new Rectangle(15, 115, 34, 14));
        cmbWells.setBounds(new Rectangle(50, 110, 115, 20));
        lstPlateWells.setBounds(new Rectangle(215, 85, 135, 115));
        btnAdd.setText("Add");
        btnAdd.setBounds(new Rectangle(90, 145, 75, 21));
        btnAdd.setActionCommand("btnAdd");
        btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAdd_actionPerformed(e);
                }
            });
        btnTransfer.setText("Transfer");
        btnTransfer.setBounds(new Rectangle(275, 215, 75, 21));
        btnTransfer.setActionCommand("btnTransfer");
        btnTransfer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnTransfer_actionPerformed(e);
                }
            });
        jLabel5.setText("New locations:");
        jLabel5.setBounds(new Rectangle(215, 65, 70, 15));
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(btnTransfer, null);
        this.getContentPane().add(btnAdd, null);
        this.getContentPane().add(lstPlateWells, null);
        this.getContentPane().add(cmbWells, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(cmbPlates, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(txtCompound, null);
        this.getContentPane().add(txtPlateName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
    }

    // Add button event handler
    // - add the selected plate and well to the lstPlateWells list control
    private void btnAdd_actionPerformed(ActionEvent e) {
        
        // Create the string and add it to the lstPlateWells control
        String strPlateWell = cmbPlates.getSelectedItem().toString() + "." + cmbWells.getSelectedItem().toString();
        lstModel.addElement(strPlateWell);
    }

    // btnTrnsfer button event handler
    // - add the specified compound to the plate well locations specifed in the lstPlateWells control
    private void btnTransfer_actionPerformed(ActionEvent e) {
        
        // Loop through the list of Plate.RowColumn strings
        for(int i = 0; i < lstModel.getSize(); i++) 
        {
            // Get the row and column characters from the list box control
            String temp = lstModel.getElementAt(i).toString();
            String strPlateName = temp.substring(0, temp.length() - 3);
            String strRowColumn = temp.substring(temp.length() - 2, temp.length());
           
            // Loop through the plates list
            for(int iPlate = 0; iPlate < Plates.size(); iPlate++){
                
                // Check the plate name
                if(Plates.get(iPlate).Name.contains(strPlateName)){
                    
                    boolean bTransfer = true;
                    
                    // Check the wells to see if the specified well already exists
                    for(int iWell = 0; iWell < Plates.get(iPlate).Wells.size(); iWell++){
                        if(Plates.get(iPlate).Wells.get(iWell).RowColumn().contains(strRowColumn)){
                            bTransfer = false; // if the well already exists then it contains a compound
                        }
                    }
                    
                    // Add the well to the plate
                    if(bTransfer){
                        // Create the well object and sett the properties
                        Well well = new Well();
                        well.Row = strRowColumn.substring(0, 1);
                        well.Column = Integer.parseInt(strRowColumn.substring(1,2));
                        well.Compound = txtCompound.getText();
                        Plates.get(iPlate).Wells.add(well);
                    }
                }
            }
        }
        
        // Save the new changes
        SavePlates();
        
        // Close the form
        this.dispose();
    }
    
    // SavePlates
    // - save the plate list to the data store
    private void SavePlates(){
        
        // Persist the changes to the data store
        CompoundTracking cmpTracking = new CompoundTracking();
        cmpTracking.SavePlates(Plates);
    }
    
    // SetPlateCompound
    // - set the selected controls
    public void SetPlateCompound(){
        
        txtPlateName.setText(PlateName);
        txtCompound.setText(Compound);
        
        // Load the plates
        LoadPlates();
    }
    
    // LoadPlates
    // - read the Plates from the XML file and load into the combobox
    private void LoadPlates() {
        
        // Create the Compoundtracking object and get the list of plates
        CompoundTracking cmpTracking = new CompoundTracking();
        Plates = cmpTracking.GetPlates();

        // Add default plates item
        cmbPlates.addItem("- Select Plate -");
        
        // Loop through the plates list and add the plate names to the dropdown
        for(int i = 0; i < Plates.size(); i++){
            
            if(!Plates.get(i).Name.contains(PlateName)){
                cmbPlates.addItem(Plates.get(i).Name);
            }
        }
    }
    
    // LoadWells
    // - load the well locations to  cmbWells
    private void LoadWells(){
        
        // Loop through characters A to D
        for(int iRow = 65; iRow <= 68; iRow++){
            char cRow = (char)iRow;
            
            // Loop through numbers 1 to 4
            for(int iColumn = 1; iColumn <= 4; iColumn++){
                // Create the RowColumn string and add it to the comboBox
                String strRowColumn = String.valueOf(cRow) + iColumn;
                cmbWells.addItem(strRowColumn);
            }
        }
    }
}
