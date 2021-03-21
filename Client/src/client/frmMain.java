package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class frmMain extends JFrame {
    BorderLayout layoutMain = new BorderLayout();
    JPanel panelCenter = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu();
    JMenuItem menuFileExit = new JMenuItem();
    JLabel statusBar = new JLabel();
    private JLabel jLabel1 = new JLabel();
    private JButton btnGetPlate = new JButton();
    private JButton btnCreatePlate = new JButton();
    private JButton btnRegisterCompound = new JButton();
    private JComboBox cmbPlates = new JComboBox();
    private JLabel lblRowA = new JLabel();
    private JLabel lblRowB = new JLabel();
    private JLabel lblRowC = new JLabel();
    private JLabel lblRowD = new JLabel();
    private JLabel lblColumn1 = new JLabel();
    private JLabel lblColumn2 = new JLabel();
    private JLabel lblColumn3 = new JLabel();
    private JLabel lblColumn4 = new JLabel();
    private JLabel lblA1 = new JLabel();
    private JLabel lblA2 = new JLabel();
    private JLabel lblA3 = new JLabel();
    private JLabel lblA4 = new JLabel();
    private JLabel lblB1 = new JLabel();
    private JLabel lblB2 = new JLabel();
    private JLabel lblB3 = new JLabel();
    private JLabel lblB4 = new JLabel();
    private JLabel lblC1 = new JLabel();
    private JLabel lblC2 = new JLabel();
    private JLabel lblC3 = new JLabel();
    private JLabel lblC4 = new JLabel();
    private JLabel lblD1 = new JLabel();
    private JLabel lblD2 = new JLabel();
    private JLabel lblD4 = new JLabel();
    private JLabel lblD3 = new JLabel();

    private Plate mainPlate;
    private JLabel lblPlateName = new JLabel();

    public frmMain() {
        try {
            jbInit();
            
            // Load Plates into cmoboBox control
            LoadPlates();
            // Clear the plate layout controls
            ClearPlate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout( null );
        this.setSize(new Dimension(505, 393));
        this.setTitle( "Plate Wells Transfer" );
        menuFile.setText( "File" );
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        statusBar.setText( "" );
        jLabel1.setText("Plate:");
        jLabel1.setBounds(new Rectangle(10, 20, 34, 14));
        btnGetPlate.setText("Get Plate");
        btnGetPlate.setBounds(new Rectangle(190, 15, 95, 20));
        btnGetPlate.setActionCommand("btnGetPlate");
        btnGetPlate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnGetPlate_actionPerformed(e);
                }
            });
        btnCreatePlate.setText("Create Plate");
        btnCreatePlate.setBounds(new Rectangle(345, 55, 130, 20));
        btnCreatePlate.setActionCommand("btnCreatePlate");
        btnRegisterCompound.setText("Register Compound");
        btnRegisterCompound.setBounds(new Rectangle(345, 15, 130, 20));
        btnRegisterCompound.setActionCommand("btnRegisterCompound");
        btnRegisterCompound.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnRegisterCompound_actionPerformed(e);
                }
            });
        cmbPlates.setBounds(new Rectangle(55, 15, 125, 20));
        lblRowA.setText("A");
        lblRowA.setBounds(new Rectangle(10, 115, 15, 15));
        lblRowA.setFont(new Font("Tahoma", 1, 16));
        lblRowB.setText("B");
        lblRowB.setBounds(new Rectangle(10, 170, 15, 15));
        lblRowB.setFont(new Font("Tahoma", 1, 16));
        lblRowC.setText("C");
        lblRowC.setBounds(new Rectangle(10, 225, 15, 15));
        lblRowC.setFont(new Font("Tahoma", 1, 16));
        lblRowD.setText("D");
        lblRowD.setBounds(new Rectangle(10, 280, 15, 15));
        lblRowD.setFont(new Font("Tahoma", 1, 16));
        lblColumn1.setText("1");
        lblColumn1.setBounds(new Rectangle(50, 80, 15, 15));
        lblColumn1.setFont(new Font("Tahoma", 1, 16));
        lblColumn2.setText("2");
        lblColumn2.setBounds(new Rectangle(115, 80, 10, 15));
        lblColumn2.setFont(new Font("Tahoma", 1, 16));
        lblColumn3.setText("3");
        lblColumn3.setBounds(new Rectangle(180, 80, 10, 15));
        lblColumn3.setFont(new Font("Tahoma", 1, 16));
        lblColumn4.setText("4");
        lblColumn4.setBounds(new Rectangle(245, 80, 10, 15));
        lblColumn4.setFont(new Font("Tahoma", 1, 16));
        lblA1.setBounds(new Rectangle(30, 100, 55, 45));
        lblA1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblA1.setToolTipText("A1");
        lblA1.setOpaque(true);
        lblA1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblA1_mouseClicked(e);
                }
            });
        lblA2.setBounds(new Rectangle(95, 100, 55, 45));
        lblA2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblA2.setToolTipText("A2");
        lblA2.setOpaque(true);
        lblA2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblA2_mouseClicked(e);
                }
            });
        lblA3.setBounds(new Rectangle(160, 100, 55, 45));
        lblA3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblA3.setOpaque(true);
        lblA3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblA3_mouseClicked(e);
                }
            });
        lblA4.setBounds(new Rectangle(225, 100, 55, 45));
        lblA4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblA4.setOpaque(true);
        lblA4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblA4_mouseClicked(e);
                }
            });
        lblB1.setBounds(new Rectangle(30, 155, 55, 45));
        lblB1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblB1.setOpaque(true);
        lblB1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblB1_mouseClicked(e);
                }
            });
        lblB2.setBounds(new Rectangle(95, 155, 55, 45));
        lblB2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblB2.setOpaque(true);
        lblB2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblB2_mouseClicked(e);
                }
            });
        lblB3.setBounds(new Rectangle(160, 155, 55, 45));
        lblB3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblB3.setOpaque(true);
        lblB3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblB3_mouseClicked(e);
                }
            });
        lblB4.setBounds(new Rectangle(225, 155, 55, 45));
        lblB4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblB4.setOpaque(true);
        lblB4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblB4_mouseClicked(e);
                }
            });
        lblC1.setBounds(new Rectangle(30, 210, 55, 45));
        lblC1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblC1.setOpaque(true);
        lblC1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblC1_mouseClicked(e);
                }
            });
        lblC2.setBounds(new Rectangle(95, 210, 55, 45));
        lblC2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblC2.setOpaque(true);
        lblC2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblC2_mouseClicked(e);
                }
            });
        lblC3.setBounds(new Rectangle(160, 210, 55, 45));
        lblC3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblC3.setOpaque(true);
        lblC3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblC3_mouseClicked(e);
                }
            });
        lblC4.setBounds(new Rectangle(225, 210, 55, 45));
        lblC4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblC4.setOpaque(true);
        lblC4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblC4_mouseClicked(e);
                }
            });
        lblD1.setBounds(new Rectangle(30, 265, 55, 45));
        lblD1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblD1.setOpaque(true);
        lblD1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblD1_mouseClicked(e);
                }
            });
        lblD2.setBounds(new Rectangle(95, 265, 55, 45));
        lblD2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblD2.setOpaque(true);
        lblD2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblD2_mouseClicked(e);
                }
            });
        lblD4.setBounds(new Rectangle(225, 265, 55, 45));
        lblD4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblD4.setToolTipText("D4");
        lblD4.setOpaque(true);
        lblD4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblD4_mouseClicked(e);
                }
            });
        lblD3.setBounds(new Rectangle(160, 265, 55, 45));
        lblD3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lblD3.setOpaque(true);
        lblD3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblD3_mouseClicked(e);
                }
            });
        lblPlateName.setText("Plate Name");
        lblPlateName.setBounds(new Rectangle(10, 55, 115, 15));
        lblPlateName.setFont(new Font("Tahoma", 1, 16));
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        this.getContentPane().add( statusBar, BorderLayout.SOUTH );
        this.getContentPane().add( panelCenter, BorderLayout.CENTER);
        panelCenter.add(lblPlateName, null);
        panelCenter.add(lblD3, null);
        panelCenter.add(lblD4, null);
        panelCenter.add(lblD2, null);
        panelCenter.add(lblD1, null);
        panelCenter.add(lblC4, null);
        panelCenter.add(lblC3, null);
        panelCenter.add(lblC2, null);
        panelCenter.add(lblC1, null);
        panelCenter.add(lblB4, null);
        panelCenter.add(lblB3, null);
        panelCenter.add(lblB2, null);
        panelCenter.add(lblB1, null);
        panelCenter.add(lblA4, null);
        panelCenter.add(lblA3, null);
        panelCenter.add(lblA2, null);
        panelCenter.add(lblA1, null);
        panelCenter.add(lblColumn4, null);
        panelCenter.add(lblColumn3, null);
        panelCenter.add(lblColumn2, null);
        panelCenter.add(lblColumn1, null);
        panelCenter.add(lblRowD, null);
        panelCenter.add(lblRowC, null);
        panelCenter.add(lblRowB, null);
        panelCenter.add(lblRowA, null);
        panelCenter.add(cmbPlates, null);
        panelCenter.add(btnRegisterCompound, null);
        panelCenter.add(btnCreatePlate, null);
        panelCenter.add(btnGetPlate, null);
        panelCenter.add(jLabel1, null);
    }

    // File->Exit menu item event handler
    // - exit the application
    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    // btnGetPlate button event handler
    // - get the plate details for the selected plate
    private void btnGetPlate_actionPerformed(ActionEvent e) {
        
        if (cmbPlates.getSelectedIndex() != 0){
            CompoundTracking cmpTracking = new CompoundTracking();
            String strPlate = cmbPlates.getSelectedItem().toString();
            mainPlate = cmpTracking.GetPlate(strPlate);
            
            // Update plate layout controls with the selected plate information
            DisplayPlate();
        }
        else{
            // Clear the plate layout controls
            ClearPlate();
        }
    }

    // btnRegsiterCompound button event handler
    // - show the frmRegisterCompounds form to allow the user to add compounds
    private void btnRegisterCompound_actionPerformed(ActionEvent e) {
    
        // Create the Register Compounds form
        frmRegisterCompound frm = new frmRegisterCompound();
        
        // Set the location and make visible
        frm.setLocation(this.getLocation());
        frm.setVisible(true);
    }

    private void lblA1_mouseClicked(MouseEvent e) {

        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("A", 1);
        }
    }

    private void lblA2_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("A", 2);
        }
    }

    private void lblA3_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("A", 3);
        }
    }

    private void lblA4_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("A", 4);
        }
    }

    private void lblB1_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("B", 1);
        }
    }

    private void lblB2_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("B", 2);
        }
    }

    private void lblB3_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("B", 3);
        }
    }

    private void lblB4_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("B", 4);
        }
    }

    private void lblC1_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("C", 1);
        }
    }

    private void lblC2_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("C", 2);
        }
    }

    private void lblC3_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("C", 3);
        }
    }

    private void lblC4_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("C", 4);
        }
    }

    private void lblD1_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("D", 1);
        }
    }

    private void lblD2_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("D", 2);
        }
    }

    private void lblD3_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("D", 3);
        }
    }

    private void lblD4_mouseClicked(MouseEvent e) {
        
        // Check click count to only handle double click event
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();

            // Allow the user to select a compound from a dialog and add it to the selected well
            AddCompoundToWell("D", 4);
        }
    }
    
    
    // AddCompoundToWell
    // - allow the user to add a compound to the selected well
    private void AddCompoundToWell(String strRow, int iColumn){
        
        // Create dialog, set the location and make visible
        frmAddCompound frm = new frmAddCompound(this,"Add Compound", true);
        frm.setLocation(this.getLocation());
        frm.setVisible(true);
        
        System.out.print("Compound = " + frm.CompoundID);
    }
    
    // LoadPlates
    // - read the Plates from the XML file and load into the combobox
    private void LoadPlates() {
        
        CompoundTracking cmpTracking = new CompoundTracking();
        String[] strPlates = cmpTracking.GetPlates();

        cmbPlates.addItem("- Select Plate -");
        
        for(int i = 0; i < strPlates.length; i++)
        {
            cmbPlates.addItem(strPlates[i]);
        }
    }
    
    // DisplayPlate
    // - update plate layout controls with the specified plate information
    private void DisplayPlate(){

        // Clear the current plate layout controls
        ClearPlate();
            
        // Set the Plate Name label
        lblPlateName.setText(mainPlate.Name);
        
        // Loop through the plate wells and update the plate layout controls 
        for(int i = 0; i < mainPlate.Wells.size(); i++){
        
            // Get well Row Column string
            String strRowColumn = mainPlate.Wells.get(i).RowColumn();
            
            // Set Row A
            if(strRowColumn.contains("A1")){
                lblA1.setBackground(Color.green);    
                lblA1.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("A2")){
                lblA2.setBackground(Color.green); 
                lblA2.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("A3")){
                lblA3.setBackground(Color.green); 
                lblA3.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("A4")){
                lblA4.setBackground(Color.green); 
                lblA4.setText(mainPlate.Wells.get(i).Compound);
            }
            // Set Row B
            else if(strRowColumn.contains("B1")){
                lblB1.setBackground(Color.green);    
                lblB1.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("B2")){
                lblB2.setBackground(Color.green); 
                lblB2.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("B3")){
                lblB3.setBackground(Color.green); 
                lblB3.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("B4")){
                lblB4.setBackground(Color.green); 
                lblB4.setText(mainPlate.Wells.get(i).Compound);
            }
            // Set Row C
            else if(strRowColumn.contains("C1")){
                lblC1.setBackground(Color.green);    
                lblC1.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("C2")){
                lblC2.setBackground(Color.green); 
                lblC2.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("C3")){
                lblC3.setBackground(Color.green); 
                lblC3.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("C4")){
                lblC4.setBackground(Color.green); 
                lblC4.setText(mainPlate.Wells.get(i).Compound);
            }
            // Set Row D
            else if(strRowColumn.contains("D1")){
                lblD1.setBackground(Color.green);    
                lblD1.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("D2")){
                lblD2.setBackground(Color.green); 
                lblD2.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("D3")){
                lblD3.setBackground(Color.green); 
                lblD3.setText(mainPlate.Wells.get(i).Compound);
            }
            else if(strRowColumn.contains("D4")){
                lblD4.setBackground(Color.green); 
                lblD4.setText(mainPlate.Wells.get(i).Compound);
            }
        }
    }
    
    // ClearPlate
    // - clear the plate layout controls
    public void ClearPlate(){
    
        // Set the Plate Name label
        lblPlateName.setText("");
        
        // Row A
        lblA1.setBackground(Color.gray);    
        lblA1.setText("");
        lblA2.setBackground(Color.gray); 
        lblA2.setText("");
        lblA3.setBackground(Color.gray); 
        lblA3.setText("");
        lblA4.setBackground(Color.gray); 
        lblA4.setText("");
        // Set Row B
        lblB1.setBackground(Color.gray);    
        lblB1.setText("");
        lblB2.setBackground(Color.gray); 
        lblB2.setText("");
        lblB3.setBackground(Color.gray); 
        lblB3.setText("");
        lblB4.setBackground(Color.gray); 
        lblB4.setText("");
        // Set Row C
        lblC1.setBackground(Color.gray);    
        lblC1.setText("");
        lblC2.setBackground(Color.gray); 
        lblC2.setText("");
        lblC3.setBackground(Color.gray); 
        lblC3.setText("");
        lblC4.setBackground(Color.gray); 
        lblC4.setText("");
        // Set Row D
        lblD1.setBackground(Color.gray);    
        lblD1.setText("");
        lblD2.setBackground(Color.gray); 
        lblD2.setText("");
        lblD3.setBackground(Color.gray); 
        lblD3.setText("");
        lblD4.setBackground(Color.gray); 
        lblD4.setText("");
    }
}
