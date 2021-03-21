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
    private JButton btnAddCompound = new JButton();
    private JList lstCompounds = new JList();
    private JButton btnRegister = new JButton();
    private JButton btnClose = new JButton();
    private DefaultListModel lstModel = new DefaultListModel();
    private JButton btnGetCompounds = new JButton();

    public frmRegisterCompound() {
        try {
            jbInit();
            
            // Initialize the Compound JList control
            lstCompounds.setModel(lstModel);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(419, 256));
        this.setTitle("Register Compounds");
        jLabel1.setText("Enter Compound ID:");
        jLabel1.setBounds(new Rectangle(10, 15, 110, 15));
        txtCompound.setBounds(new Rectangle(140, 10, 120, 20));
        btnAddCompound.setText("Add Compound");
        btnAddCompound.setBounds(new Rectangle(270, 10, 110, 20));
        btnAddCompound.setActionCommand("btnAddCompound");
        btnAddCompound.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAddCompound_actionPerformed(e);
                }
            });
        lstCompounds.setBounds(new Rectangle(10, 60, 180, 140));
        btnRegister.setText("Register");
        btnRegister.setBounds(new Rectangle(215, 90, 125, 20));
        btnRegister.setActionCommand("btnRegister");
        btnRegister.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnRegister_actionPerformed(e);
                }
            });
        btnClose.setText("Close");
        btnClose.setBounds(new Rectangle(290, 180, 90, 20));
        btnClose.setActionCommand("btnClose");
        btnClose.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnClose_actionPerformed(e);
                }
            });
        btnGetCompounds.setText("Get Compounds");
        btnGetCompounds.setBounds(new Rectangle(215, 60, 125, 20));
        btnGetCompounds.setActionCommand("Get Compounds");
        btnGetCompounds.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnGetCompounds_actionPerformed(e);
                }
            });
        this.getContentPane().add(btnGetCompounds, null);
        this.getContentPane().add(btnClose, null);
        this.getContentPane().add(btnRegister, null);
        this.getContentPane().add(lstCompounds, null);
        this.getContentPane().add(btnAddCompound, null);
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
        
        // Get the Compound ID entered by the user
        String strCompound = txtCompound.getText();
        // Add the Compound ID to the list
        lstModel.addElement(strCompound);
    }

    // Register button event handler
    // - add the user entered Compound IDs to final storage
    private void btnRegister_actionPerformed(ActionEvent e) {
        
        CompoundTracking compounds = new CompoundTracking();
        String[] strCompounds = new String[lstModel.getSize()];
            
        for(int i = 0; i < strCompounds.length; i++) 
        {
            strCompounds[i] = lstModel.getElementAt(i).toString();
            System.out.println("Compound ID: "+ strCompounds[i]); 
        }
        compounds.SaveCompounds(strCompounds);
    }

    // Get Compounds button event handler
    // - get the list of compounds and add them to the JList
    private void btnGetCompounds_actionPerformed(ActionEvent e) {
        
        // Get a string array of CompoundIDs from the CompoundTracking data store
        CompoundTracking compounds = new CompoundTracking();
        String[] strCompounds = compounds.GetCompounds();
        
        // Clear the list before adding all CompoundIDs
        lstModel.removeAllElements();
        
        // Loop through the string array of CompoundIDs and add to the list control
        for(int i = 0; i < strCompounds.length; i++)
        {
            lstModel.addElement(strCompounds[i]);
        }
    }
}
