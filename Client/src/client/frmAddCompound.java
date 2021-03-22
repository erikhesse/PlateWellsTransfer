package client;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class frmAddCompound extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JComboBox cmbCompounds = new JComboBox();
    private JButton btnAdd = new JButton();

    String CompoundID = "";

    // frmAddCompound contructor
    public frmAddCompound() {
        this(null, "", false);
    }

    // frmAddCompound constructor
    public frmAddCompound(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
            
            // Load the Compounds to the dropdown control
            LoadCompounds();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // jbInit
    private void jbInit() throws Exception {
        this.setSize(new Dimension(288, 132));
        this.getContentPane().setLayout( null );
        jLabel1.setText("Select Compound:");
        jLabel1.setBounds(new Rectangle(15, 20, 95, 15));
        cmbCompounds.setBounds(new Rectangle(115, 15, 135, 20));
        btnAdd.setText("Add");
        btnAdd.setBounds(new Rectangle(95, 60, 75, 20));
        btnAdd.setToolTipText("Add ");
        btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAdd_actionPerformed(e);
                }
            });
        this.getContentPane().add(btnAdd, null);
        this.getContentPane().add(cmbCompounds, null);
        this.getContentPane().add(jLabel1, null);
    }

    // Add button event handler
    // - get the selected compound from the dropdown and close the form
    private void btnAdd_actionPerformed(ActionEvent e) {
        // Get the selected CompoundID 
        if(cmbCompounds.getSelectedIndex() > 0){
            CompoundID = cmbCompounds.getSelectedItem().toString();
        }
        
        // Close the form
        this.dispose();
    }
    
    // LoadCompounds
    // - get the CompoundIDs from CompoundTracking and add to the combobox control
    private void LoadCompounds(){
    
        CompoundTracking compounds = new CompoundTracking();
        
        String[] strCompounds = compounds.GetCompounds();
        cmbCompounds.addItem("- Compound IDs -");
            
        for(int i = 0; i < strCompounds.length; i++)
        {
            cmbCompounds.addItem(strCompounds[i]);
        }
    }
}
