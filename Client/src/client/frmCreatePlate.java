package client;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frmCreatePlate extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JTextField txtPlateName = new JTextField();
    private JButton btnAdd = new JButton();

    String PlateName;
    
    public frmCreatePlate() {
        this(null, "", false);
    }

    public frmCreatePlate(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(231, 120));
        this.getContentPane().setLayout( null );
        this.setTitle("Create Plate");
        jLabel1.setText("Plate Name:");
        jLabel1.setBounds(new Rectangle(15, 20, 60, 15));
        txtPlateName.setBounds(new Rectangle(90, 15, 95, 20));
        btnAdd.setText("Add");
        btnAdd.setBounds(new Rectangle(75, 50, 75, 21));
        btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAdd_actionPerformed(e);
                }
            });
        this.getContentPane().add(btnAdd, null);
        this.getContentPane().add(txtPlateName, null);
        this.getContentPane().add(jLabel1, null);
    }

    // Add button event handler
    // - close the form
    private void btnAdd_actionPerformed(ActionEvent e) {
        
        // Get the plate name
        PlateName = txtPlateName.getText();
        
        // Close the form
        this.dispose();
    }
}
