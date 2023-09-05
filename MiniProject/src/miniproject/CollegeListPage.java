package miniproject;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CollegeListPage extends javax.swing.JFrame {
    
    Connection con = null;
    private String query = "";
    private String selectedCaste = "";
    private String selectedRound = "";

    public CollegeListPage() {
        initComponents();
//        System.out.println(query);
        con = dbConnection.con();
        loadData();
    }
    
    public CollegeListPage(String query, String selectedCaste, String selectedRound) {
        initComponents();
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(java.awt.Color.white);

        jLabel1.setText("Eligible Colleges");

        Table.setBackground(java.awt.Color.darkGray);
        Table.setForeground(java.awt.Color.white);
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Branch", "Cut-Off", "University"
            }
        ));
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(865, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(527, 527, 527))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CollegeListPage().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
