
package Guess;
import java.sql.*;
/**
 *
 * @author Adrian 00061686
 */
public class Scores extends javax.swing.JPanel {

    /**
     * Creates new form Scores
     */
    public Scores() {
        initComponents();
        handlingDatabase();
        
        user.setEditable(false);
        strike.setEditable(false);
        time.setEditable(false);
        correct.setEditable(false);
        date.setEditable(false);
        user.setLineWrap(true);
        strike.setLineWrap(true);
        date.setLineWrap(true);
        correct.setLineWrap(true);
        time.setLineWrap(true);
        
    }
    
    /**
     *This method inserts the is used to display the top 10 players in the database .
     */
     public void database() throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/guess";
               
		String userr = "root";		
		String pass = "pass";
                
              

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, userr, pass);
			                 
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("SELECT * FROM PLAYERS ORDER BY CORRECTLY_ANSWERED DESC,TIME_REMAINING DESC");
			
			// 5. Process the result set
                        user.setText("");
                        correct.setText("");
                        time.setText("");
                        strike.setText("");
                        date.setText("");
                        
                        //displaying the results of the database to the users.
			while (myRs.next()) {
				user.setText(user.getText()+"\n   "+ myRs.getString("USERNAME"));                                
                                correct.setText(correct.getText()+"\n    "+ myRs.getString("CORRECTLY_ANSWERED"));
                                time.setText(time.getText()+"\n       "+ myRs.getString("TIME_REMAINING"));
                                strike.setText(strike.getText()+"\n    "+ myRs.getString("STRIKES"));
                                date.setText(date.getText()+"\n  "+ myRs.getString("DATE_OF_SCORE"));
                                        
			}
                
                }
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
   /**
    *This method handles the database() method 
    */  
   public void handlingDatabase(){
       
       try{
       database();
       }
       catch(Exception x){
           System.out.println("Oops Somthing went wrong");
       }
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        strike = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        user = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        correct = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        time = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        date = new javax.swing.JTextArea();
        UPDATE = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Top 10 High Scores ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 11, -1, 66));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("USER");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 118, 45, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 475, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CORRECT ANS");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 115, 95, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TIME REMAINING");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 118, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("STRIKES");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 118, 63, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("DATE");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 118, 47, -1));

        strike.setEditable(false);
        strike.setColumns(20);
        strike.setRows(5);
        jScrollPane2.setViewportView(strike);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 70, 256));

        user.setEditable(false);
        user.setColumns(20);
        user.setRows(5);
        jScrollPane3.setViewportView(user);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, 130, 256));

        correct.setEditable(false);
        correct.setColumns(20);
        correct.setRows(5);
        jScrollPane4.setViewportView(correct);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, 256));

        time.setEditable(false);
        time.setColumns(20);
        time.setRows(5);
        jScrollPane5.setViewportView(time);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 101, 256));

        date.setEditable(false);
        date.setColumns(20);
        date.setRows(5);
        jScrollPane6.setViewportView(date);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 90, 256));

        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        add(UPDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        
        handlingDatabase();
    }//GEN-LAST:event_UPDATEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextArea correct;
    private javax.swing.JTextArea date;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea strike;
    private javax.swing.JTextArea time;
    private javax.swing.JTextArea user;
    // End of variables declaration//GEN-END:variables
}
