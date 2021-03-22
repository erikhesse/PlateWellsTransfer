package client;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class frmRegisterCompound extends JFrame {
    private JLabel jLabel1 = new JLabel();
    private JTextField txtCompound = new JTextField();
    private JButton btnRegister = new JButton();
    private JList lstCompounds = new JList();
    private JButton btnClose = new JButton();
    private DefaultListModel lstModel = new DefaultListModel();
    private JLabel jLabel2 = new JLabel();

    public frmRegisterCompound() {
        try {
            jbInit();
            
            // Initialize the Compound JList control
            lstCompounds.setModel(lstModel);
            
            // Load the compounds into the list control
            GetCompounds();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(313, 239));
        this.setTitle("Register Compounds");
        jLabel1.setText("Enter Compound ID:");
        jLabel1.setBounds(new Rectangle(10, 15, 110, 15));
        txtCompound.setBounds(new Rectangle(10, 35, 120, 20));
        btnRegister.setText("Register");
        btnRegister.setBounds(new Rectangle(10, 70, 120, 20));
        btnRegister.setActionCommand("btnRegister");
        btnRegister.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAddCompound_actionPerformed(e);
                }
            });
        lstCompounds.setBounds(new Rectangle(160, 30, 115, 130));
        btnClose.setText("Close");
        btnClose.setBounds(new Rectangle(185, 170, 90, 20));
        btnClose.setActionCommand("btnClose");
        btnClose.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnClose_actionPerformed(e);
                }
            });
        jLabel2.setText("Compound List:");
        jLabel2.setBounds(new Rectangle(160, 10, 80, 15));
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(btnClose, null);
        this.getContentPane().add(lstCompounds, null);
        this.getContentPane().add(btnRegister, null);
        this.getContentPane().add(txtCompound, null);
        this.getContentPane().add(jLabel1, null);
    }

    // Close button event handler
    // - close the frame
    private void btnClose_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    // Add Compound button click event handler
    // - add the compound entered in the text input control into the Compounds JList control
    private void btnAddCompound_actionPerformed(ActionEvent e) {
        
        boolean bAdd = true;   // Set to true for default condition
        
        // Get the Compound ID entered by the user
        String strCompound = txtCompound.getText();
        
        // Need to check if compound already exists in the list
        for(int i = 0; i < lstModel.getSize(); i++){
            if(lstModel.getElementAt(i).toString().contains(strCompound)){
                bAdd = false;
                break;
            }
        }
            
        // If compounds doesn't exist in the list then add it
        if(bAdd){
            // Add the Compound ID to the list
            lstModel.addElement(strCompound);
            
            // Save the Compounds
            SaveCompounds();
        }
    }

    // SaveCompounds
    // - save the conpounds in the list control
    private void SaveCompounds() {
        
        CompoundTracking compounds = new CompoundTracking();
        String[] strCompounds = new String[lstModel.getSize()];
            
        for(int i = 0; i < strCompounds.length; i++) 
        {
            strCompounds[i] = lstModel.getElementAt(i).toString();
            System.out.println("Compound ID: "+ strCompounds[i]); 
        }
        compounds.SaveCompounds(strCompounds);
    }
    
    // GetCompounds
    // - get the list of compounds from the data store
    private void GetCompounds(){
        
        
        // Get a string array of CompoundIDs from the CompoundTracking data store
        CompoundTracking compounds = new CompoundTracking();
        String[] strCompounds = compounds.GetCompounds();
        
        // Clear the list before adding all CompoundIDs
        lstModel.removeAllElements();
        
        // Loop through the string array of CompoundIDs and add to the list control
        for(int i = 0; i < strCompounds.length; i++) {
            lstModel.addElement(strCompounds[i]);
        }
    }
}
