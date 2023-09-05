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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class MiniProject {
    private JFrame frame;
    private JTextField tfPercent;
    private JButton bSubmit;
    private final ButtonGroup bgBoard = new ButtonGroup();
    private final ButtonGroup bgBranch = new ButtonGroup();
    private final ButtonGroup bgCaste = new ButtonGroup();
    private final ButtonGroup bgCAP = new ButtonGroup();
    private JLabel lBoard;
    private JPanel pCaste, pBoard, pBranch, pUniversity, pCAP, pPercent;
    private JRadioButton rbHSC, rbCBSE, rbICSE, rbCOMP, rbIT, rbENTC, rbBIOMED,
            rbOPEN, rbSC, rbST, rbOBC, rbRound1, rbRound2, rbRound3;
    private JComboBox cbUniversity;
    String selectedCaste = "Open";
    String selectedRound = "Round 1";


    /**
    * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MiniProject window = new MiniProject();
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
    
    
    public MiniProject() {
        initialize();
        
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

        //BOARD
//        pBoard = new JPanel();
//        pBoard.setBorder(new LineBorder(new Color(255, 102, 0), 2));
//        pBoard.setBackground(new Color(204, 255, 51));
//        pBoard.setBounds(53, 220, 133, 35);
//        frame.getContentPane().add(pBoard);
//
//        lBoard = new JLabel("12th Board");
//        pBoard.add(lBoard);
//        lBoard.setFont(new Font("Algerian", Font.BOLD, 17));
//        lBoard.setBackground(Color.WHITE);
//        
//        rbHSC = new JRadioButton("HSC");
//        bgBoard.add(rbHSC);
//        rbHSC.setBackground(new Color(102, 255, 255));
//        rbHSC.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
//        rbHSC.setBounds(260, 220, 109, 23);
//        frame.getContentPane().add(rbHSC);
//
//        rbCBSE = new JRadioButton("CBSE");
//        bgBoard.add(rbCBSE);
//        rbCBSE.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
//        rbCBSE.setBackground(new Color(102, 255, 255));
//        rbCBSE.setBounds(260, 257, 109, 23);
//        frame.getContentPane().add(rbCBSE);
//
//        rbICSE = new JRadioButton("ICSE");
//        bgBoard.add(rbICSE);
//        rbICSE.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
//        rbICSE.setBackground(new Color(102, 255, 255));
//        rbICSE.setBounds(260, 294, 109, 23);
//        frame.getContentPane().add(rbICSE);

        //CASTE
        pCaste = new JPanel();
        pCaste.setForeground(new Color(0, 0, 0));
        pCaste.setBorder(new LineBorder(new Color(255, 102, 0), 2, true));
        pCaste.setBackground(new Color(204, 255, 51));
        pCaste.setBounds(1000, 200, 133, 35);
        frame.getContentPane().add(pCaste);

        JLabel lCaste = new JLabel("Caste");
        pCaste.add(lCaste);
        lCaste.setFont(new Font("Algerian", Font.BOLD, 17));
        lCaste.setBackground(Color.WHITE);
        
        rbOPEN = new JRadioButton("OPEN");
        bgCaste.add(rbOPEN);
        rbOPEN.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbOPEN.setBackground(new Color(102, 255, 255));
        rbOPEN.setBounds(1174, 200, 109, 23);
        frame.getContentPane().add(rbOPEN);

        rbSC = new JRadioButton("SC");
        bgCaste.add(rbSC);
        rbSC.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbSC.setBackground(new Color(102, 255, 255));
        rbSC.setBounds(1174, 237, 109, 23);
        frame.getContentPane().add(rbSC);

        rbST = new JRadioButton("ST");
        bgCaste.add(rbST);
        rbST.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbST.setBackground(new Color(102, 255, 255));
        rbST.setBounds(1174, 274, 109, 23);
        frame.getContentPane().add(rbST);

        rbOBC = new JRadioButton("OBC");
        bgCaste.add(rbOBC);
        rbOBC.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbOBC.setBackground(new Color(102, 255, 255));
        rbOBC.setBounds(1174, 311, 109, 23);
        frame.getContentPane().add(rbOBC);

        //Percent
        pPercent = new JPanel();
        pPercent.setBorder(new LineBorder(new Color(255, 102, 0), 2));
        pPercent.setBackground(new Color(204, 255, 51));
        pPercent.setBounds(500, 200, 180, 35);
        frame.getContentPane().add(pPercent);

        JLabel lPercent = new JLabel("CET Percentile");
        pPercent.add(lPercent);
        lPercent.setFont(new Font("Algerian", Font.BOLD, 17));
        lPercent.setBackground(Color.WHITE);
        
        tfPercent = new JTextField();
        tfPercent.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tfPercent.setBackground(new Color(51, 255, 255));
        tfPercent.setBounds(707, 200, 133, 29);
        frame.getContentPane().add(tfPercent);
        tfPercent.setColumns(10);

        //Branch
        pBranch = new JPanel();
        pBranch.setBorder(new LineBorder(new Color(255, 102, 0), 2));
        pBranch.setBackground(new Color(204, 255, 51));
        pBranch.setBounds(500, 381, 133, 35);
        frame.getContentPane().add(pBranch);

        JLabel lBranch = new JLabel("Branch");
        pBranch.add(lBranch);
        lBranch.setFont(new Font("Algerian", Font.BOLD, 17));
        lBranch.setBackground(Color.WHITE);
        
        rbCOMP = new JRadioButton("COMP");
        bgBranch.add(rbCOMP);
        rbCOMP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbCOMP.setBackground(new Color(102, 255, 255));
        rbCOMP.setBounds(707, 381, 109, 23);
        frame.getContentPane().add(rbCOMP);

        rbIT = new JRadioButton("IT");
        bgBranch.add(rbIT);
        rbIT.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbIT.setBackground(new Color(102, 255, 255));
        rbIT.setBounds(707, 418, 109, 23);
        frame.getContentPane().add(rbIT);

        rbENTC = new JRadioButton("ENTC");
        bgBranch.add(rbENTC);
        rbENTC.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbENTC.setBackground(new Color(102, 255, 255));
        rbENTC.setBounds(707, 455, 109, 23);
        frame.getContentPane().add(rbENTC);

        rbBIOMED = new JRadioButton("BIOMED");
        bgBranch.add(rbBIOMED);
        rbBIOMED.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbBIOMED.setBackground(new Color(102, 255, 255));
        rbBIOMED.setBounds(707, 492, 109, 23);
        frame.getContentPane().add(rbBIOMED);

        //CAP
        pCAP = new JPanel();
        pCAP.setBorder(new LineBorder(new Color(255, 102, 0), 2));
        pCAP.setBackground(new Color(204, 255, 51));
        pCAP.setBounds(1000, 381, 133, 35);
        frame.getContentPane().add(pCAP);

        JLabel lCap = new JLabel("CAP Round");
        pCAP.add(lCap);
        lCap.setFont(new Font("Algerian", Font.BOLD, 17));
        lCap.setBackground(Color.WHITE);
        
        rbRound1 = new JRadioButton("ROUND 1");
        bgCAP.add(rbRound1);
        rbRound1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbRound1.setBackground(new Color(102, 255, 255));
        rbRound1.setBounds(1174, 381, 109, 23);
        frame.getContentPane().add(rbRound1);

        rbRound2 = new JRadioButton("ROUND 2");
        bgCAP.add(rbRound2);
        rbRound2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbRound2.setBackground(new Color(102, 255, 255));
        rbRound2.setBounds(1174, 418, 109, 23);
        frame.getContentPane().add(rbRound2);

        rbRound3 = new JRadioButton("ROUND 3");
        bgCAP.add(rbRound3);
        rbRound3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        rbRound3.setBackground(new Color(102, 255, 255));
        rbRound3.setBounds(1174, 455, 109, 23);
        frame.getContentPane().add(rbRound3);

        //University
        pUniversity = new JPanel();
        pUniversity.setBorder(new LineBorder(new Color(255, 102, 0), 2));
        pUniversity.setBackground(new Color(204, 255, 51));
        pUniversity.setBounds(750, 600, 153, 35);
        frame.getContentPane().add(pUniversity);

        JLabel lUniversity = new JLabel("University");
        pUniversity.add(lUniversity);
        lUniversity.setFont(new Font("Algerian", Font.BOLD, 17));
        lUniversity.setBackground(Color.WHITE);


        cbUniversity = new JComboBox();
        cbUniversity.setBackground(new Color(51, 255, 255));
        cbUniversity.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        cbUniversity.setModel(new DefaultComboBoxModel(new String[] {"Select", "All",
            "Mumbai University", "Savitribar Phule Pune University", 
            "Dr.Bababsaheb Ambedkar Marathwada University", 
            "Kavayatri Bahinabai Chaudhari North Maharashtra University", 
            "Rashtrasant Tukadoji Maharaj Nagpur University", 
            "Swami Ramanand Teerth Marathwada University", 
            "Sant Gadge Baba Amravati University", "Shivaji University", 
            "Punyashlok Ahilyadevi Holkar Solapur University", 
            "Autonomous University"}));
        cbUniversity.setMaximumRowCount(5);
        cbUniversity.setBounds(924, 600, 250, 35);
        frame.getContentPane().add(cbUniversity);

        //Submit
        bSubmit = new JButton("SUBMIT");
        bSubmit.setBorder(new LineBorder(new Color(0, 204, 255), 2, true));
        bSubmit.setForeground(new Color(0, 0, 0));
        bSubmit.setFont(new Font("Arial Black", Font.PLAIN, 16));
        bSubmit.setBackground(new Color(204, 51, 0));
        bSubmit.setBounds(850, 707, 200, 35);
        frame.getContentPane().add(bSubmit);
        
        bSubmit.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent ae) {
                try{
                    Boolean isFiltered = false;
                    String branch = "", percent, caste, cap, university, board;
                    String query = "Select * from dbtable where ";
                    if(tfPercent.getText().isEmpty() || bgCaste.getSelection() == null){
                        System.out.print(bgCaste.getSelection());
                        JOptionPane.showMessageDialog(frame, "Please enter percentile and caste!");
                    }
                    if(!tfPercent.getText().isEmpty() && bgCaste.getSelection() != null){
                        
                        if(rbRound1.isSelected()){
                            if(rbOPEN.isSelected()){
                                if(isFiltered == false){
                                   query = query + "open1 <= " + tfPercent.getText();
                                   selectedCaste = "Open";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and open1 <= " + tfPercent.getText();
                                    selectedCaste = "Open";
                                    selectedRound = "1";
                                }
                            }else if(rbOBC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "obc1 <= " + tfPercent.getText();
                                   selectedCaste = "OBC";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and obc1 <= " + tfPercent.getText();
                                    selectedCaste = "OBC";
                                   selectedRound = "1";
                                }
                            }else if(rbSC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "sc1 <= " + tfPercent.getText();
                                   selectedCaste = "SC";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and sc1 <= " + tfPercent.getText();
                                    selectedCaste = "SC";
                                   selectedRound = "1";
                                }
                            }else if(rbST.isSelected()){
                                if(isFiltered == false){
                                   query = query + "st1 <= " + tfPercent.getText();
                                   selectedCaste = "ST";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and st1 <= " + tfPercent.getText();
                                    selectedCaste = "ST";
                                   selectedRound = "1";
                                }
                            }
                            
                        }else if(rbRound2.isSelected()){
                            if(rbOPEN.isSelected()){
                                if(isFiltered == false){
                                   query = query + "open2 <= " + tfPercent.getText();
                                   selectedCaste = "Open";
                                   selectedRound = "2";
                                   isFiltered = true;
                                }else{
                                    query = query + "and open2 <= " + tfPercent.getText();
                                    selectedCaste = "Open";
                                    selectedRound = "2";
                                }
                            }else if(rbOBC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "obc2 <= " + tfPercent.getText();
                                   selectedCaste = "OBC";
                                   selectedRound = "2";
                                   isFiltered = true;
                                }else{
                                    query = query + "and obc2 <= " + tfPercent.getText();
                                    selectedCaste = "OBC";
                                   selectedRound = "2";
                                }
                            }else if(rbSC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "sc2 <= " + tfPercent.getText();
                                   selectedCaste = "SC";
                                   selectedRound = "2";
                                   isFiltered = true;
                                }else{
                                    query = query + "and sc2 <= " + tfPercent.getText();
                                    selectedCaste = "SC";
                                   selectedRound = "2";
                                }
                            }else if(rbST.isSelected()){
                                if(isFiltered == false){
                                   query = query + "st2 <= " + tfPercent.getText();
                                   selectedCaste = "ST";
                                   selectedRound = "2";
                                   isFiltered = true;
                                }else{
                                    query = query + "and st2 <= " + tfPercent.getText();
                                    selectedCaste = "ST";
                                   selectedRound = "2";
                                }
                            }
                        }else if(rbRound3.isSelected()){
                            if(rbOPEN.isSelected()){
                                if(isFiltered == false){
                                   query = query + "open3 <= " + tfPercent.getText();
                                   selectedCaste = "Open";
                                   selectedRound = "3";
                                   isFiltered = true;
                                }else{
                                    query = query + "and open3 <= " + tfPercent.getText();
                                    selectedCaste = "Open";
                                   selectedRound = "3";
                                }
                            }else if(rbOBC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "obc3 <= " + tfPercent.getText();
                                   selectedCaste = "OBC";
                                   selectedRound = "3";
                                   isFiltered = true;
                                }else{
                                    query = query + "and obc3 <= " + tfPercent.getText();
                                    selectedCaste = "OBC";
                                   selectedRound = "3";
                                }
                            }else if(rbSC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "sc3 <= " + tfPercent.getText();
                                   selectedCaste = "SC";
                                   selectedRound = "3";
                                   isFiltered = true;
                                }else{
                                    query = query + "and sc3 <= " + tfPercent.getText();
                                    selectedCaste = "SC";
                                   selectedRound = "3";
                                }
                            }else if(rbST.isSelected()){
                                if(isFiltered == false){
                                   query = query + "st3 <= " + tfPercent.getText();
                                   selectedCaste = "ST";
                                   selectedRound = "3";
                                   isFiltered = true;
                                }else{
                                    query = query + "and st3 <= " + tfPercent.getText();
                                    selectedCaste = "ST";
                                   selectedRound = "3";
                                    
                                }
                            }
                        }else{
                            if(rbOPEN.isSelected()){
                                if(isFiltered == false){
                                   query = query + "open1 <= " + tfPercent.getText();
                                   selectedCaste = "Open";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and open1 <= " + tfPercent.getText();
                                    selectedCaste = "Open";
                                   selectedRound = "1";
                                }
                            }else if(rbOBC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "obc1 <= " + tfPercent.getText();
                                   selectedCaste = "OBC";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and obc1 <= " + tfPercent.getText();
                                    selectedCaste = "OBC";
                                   selectedRound = "1";
                                }
                            }else if(rbSC.isSelected()){
                                if(isFiltered == false){
                                   query = query + "sc1 <= " + tfPercent.getText();
                                   selectedCaste = "SC";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and sc1 <= " + tfPercent.getText();
                                    selectedCaste = "SC";
                                   selectedRound = "1";
                                }
                            }else if(rbST.isSelected()){
                                if(isFiltered == false){
                                   query = query + "st1 <= " + tfPercent.getText();
                                   selectedCaste = "ST";
                                   selectedRound = "1";
                                   isFiltered = true;
                                }else{
                                    query = query + "and st1 <= " + tfPercent.getText();
                                    selectedCaste = "ST";
                                   selectedRound = "1";
                                }
                            }else{
                                query = query + "open1 <= " + tfPercent.getText();
                                selectedCaste = "Open";
                                   selectedRound = "1";
                            }
                        }
                        if(rbCOMP.isSelected()){
                            query = query + " and branch = " + "'COMPS'";
                        }
                        if(rbENTC.isSelected()){
                            query = query + " and branch = " + "'EXTC'";
                        }
                        if(rbIT.isSelected()){
                            query = query + " and branch = " + "'IT'";
                        }
                        if(rbBIOMED.isSelected()){
                            query = query + " and branch = " + "'BIOMED'";
                        }
                        if(cbUniversity.getSelectedItem().equals("Select") || cbUniversity.getSelectedItem().equals("All")){
                            
                        }else{
                            query = query + " and university = '" + cbUniversity.getSelectedItem() + "'";
                        }
                        System.out.println(selectedCaste);
                        System.out.println(selectedRound);
                        new CollegeList(query, selectedCaste, selectedRound).isVisible(true);
                    }
                    
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        });

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(MiniProject.class.getResource("/miniproject/SQ.png")));
//        lblNewLabel_1.setIcon(new ImageIcon(MiniProject.class.getResource("/bg.jpeg")));
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setBounds(0, 0, 2000, 1000);
        frame.getContentPane().add(lblNewLabel_1);
      //  frame.setBounds(100, 100, 1400, 1050);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}