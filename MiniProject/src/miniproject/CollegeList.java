package miniproject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class CollegeList {
    private JFrame frame;
    Connection con = null;
    private String query = "";
    private String selectedCaste = "";
    private String selectedRound = "";
  private JPanel pCaste , Jtab;
  private JTable Table;
   private JScrollPane  jScrollPane1;

    /**
    * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CollegeList window = new CollegeList();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
    * Create the application.
    */
    
    
    public CollegeList() {
        initialize();
        con = dbConnection.con();
        loadData();
    }
    
    public CollegeList(String query, String selectedCaste, String selectedRound) {
        initialize();
        System.out.println(query);
        con = dbConnection.con();
        this.query = query;
        this.selectedCaste = selectedCaste;
        this.selectedRound = selectedRound;
        loadData();
    }
    
    public void loadData(){
        try{
//            String query = "Select * from dbtable where branch = 'COMPS' or branch = 'IT'";
            String CutOff = selectedCaste + selectedRound;
            System.out.println(CutOff);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String Name = rs.getString("Name");
                String Branch = rs.getString("Branch");
                String cutOff = rs.getString(CutOff);
//                String Open1 = rs.getString("Open1");
//                String Open2 = rs.getString("Open2");
//                String Open3 = rs.getString("Open3");
//                String OBC1 = rs.getString("OBC1");
//                String OBC2 = rs.getString("OBC2");
//                String OBC3 = rs.getString("OBC3");
//                String SC1 = rs.getString("SC1");
//                String SC2 = rs.getString("SC2");
//                String SC3 = rs.getString("SC3");
//                String ST1 = rs.getString("ST1");
//                String ST2 = rs.getString("ST2");
//                String ST3 = rs.getString("ST3");
                String University = rs.getString("University");
                
                String tbData[] = {Name, Branch, cutOff, University};
                DefaultTableModel model = (DefaultTableModel)Table.getModel();
                model.addRow(tbData);
            }
        }catch(Exception e){
            System.out.println("CollegeListPage - loadData - " + e);
        }
    }
    
    /**
    * Initialize the contents of the frame.
    */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setEnabled(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.getContentPane().setForeground(Color.BLACK);
        frame.getContentPane().setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setUndecorated(true);
        frame.setVisible(true);
        
        pCaste = new JPanel();
        pCaste.setForeground(new Color(0, 0, 0));
        pCaste.setBorder(new LineBorder(new Color(255, 102, 0), 2, true));
        pCaste.setBackground(new Color(204, 255, 51));
        pCaste.setBounds(850, 200, 200, 35);
        frame.getContentPane().add(pCaste);

        // Label
        JLabel lCaste = new JLabel("Eligible Colleges");
        pCaste.add(lCaste);
        lCaste.setFont(new Font("Algerian", Font.BOLD, 17));
        lCaste.setBackground(Color.WHITE);
      
        //table
        
        Jtab = new JPanel();
      //  Jtab.setForeground(new Color(0, 0, 0));
       //Jtab.setBorder(new LineBorder(new Color(255, 102, 0), 2, true));
        //Jtab.setBackground(new Color(204, 255, 51));
        Jtab.setBounds(700,300,500,600);
        frame.getContentPane().add(Jtab);
        
        String data[][]={ };    
    String column[]={ "Name", "Branch", "Cut-Off", "University"};         
    Table=new JTable(data,column);  
//    jt.setBackground(Color.red);
//    jt.setBounds(400,200,700,700);   
    
    JScrollPane sp=new JScrollPane(Table);   
    Jtab.add(sp);          
      
        //background image
      JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(MiniProject.class.getResource("/miniproject/SQ.png")));
//        lblNewLabel_1.setIcon(new ImageIcon(MiniProject.class.getResource("/bg.jpeg")));
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setBounds(0, 0, 2000, 1000);
        frame.getContentPane().add(lblNewLabel_1);
      //  frame.setBounds(100, 100, 1400, 1050);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void isVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}