
package Guess;
import java.sql.*;
/**
 *
 * @author Adrian 00061686
 */
public class Standings extends javax.swing.JPanel {

    /**
     *This class is used to display players in first, second and third place of the score board
     * ever time a new play is added to the database.
     */
    
    
    public Standings() {
        initComponents();
        handlingDatabase();
        user.setEditable(false);
        user.setLineWrap(true);
        
    }
    /**
     *This method is used as a sub-query which returns a player score based 
     * their username
     */
    public int places(String player) throws SQLException {
        
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
			
			myRs = myStmt.executeQuery("SELECT * FROM PLAYERS WHERE USERNAME='"+player+"';");
			
			// 5. Process the result set
                        
                        //displaying the results of the database to the users.
                        
                        
			while (myRs.next()) {
                            return Integer.parseInt(myRs.getString("CORRECTLY_ANSWERED"));      
			}
                                
                
                }
		catch (Exception exc) {
			exc.printStackTrace();
		}
                
                return 0;
    }
    
    /**
     *This method grab data from the database by time and and process that data using the observer pattern.
     *
     */
     public void database() throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
                
                
                
		
		String dbUrl = "jdbc:mysql://localhost:3306/guess";
               
		String userr = "root";		
		String pass = "pass";
                
              //creating observers
               Setting_Scores ss = new Setting_Scores();
               Player_Observer observer1 = new Player_Observer(ss);
                
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, userr, pass);
			                 
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("SELECT * FROM PLAYERS ORDER BY DATE_OF_SCORE,TIME_OF_PLAY ");
			
			// 5. Process the result set
                        
                        //displaying the results of the database to the users.
                        
                        
                        //default first second and third place
                        String firstPlace="un";
                        String secondPlace="un";
                        String thirdPlace="un";
                        
                        
                        //iterate through database
			while (myRs.next()) {
                         
                         //setting player to 1st 2nd and 3rd place
                        if(firstPlace.equals("un")){
                            firstPlace=myRs.getString("USERNAME");
                             ss.setPlayer1("First Place: "+myRs.getString("USERNAME"),true);
                        }    
                        else if(secondPlace.equals("un")){
                            secondPlace=myRs.getString("USERNAME");
                             ss.setPlayer2("Second Place: "+myRs.getString("USERNAME"),true);
                        }   
                        else if(thirdPlace.equals("un")){
                            thirdPlace=myRs.getString("USERNAME");
                             ss.setPlayer3("Third Place: "+myRs.getString("USERNAME"),true);
                        } 
                        else{
                          //runs the subquery method  
                          int x=places(firstPlace);
                          int y=places(secondPlace);
                          int z=places(thirdPlace);
                          
                          //update first second and third place
                          if(Integer.parseInt(myRs.getString("CORRECTLY_ANSWERED"))>x){
                               ss.setPlayer3("Third Place: "+secondPlace,false); 
                               ss.setPlayer2("Second Place: "+firstPlace,false); 
                               ss.setPlayer1("First Place: "+myRs.getString("USERNAME"),true);
                               secondPlace=firstPlace;
                               thirdPlace=secondPlace;
                               firstPlace=myRs.getString("USERNAME");
                               
                           }
                          //update  second and third place
                          else if(Integer.parseInt(myRs.getString("CORRECTLY_ANSWERED"))>y){
                               ss.setPlayer3("Third Place: "+secondPlace,false); 
                               ss.setPlayer2("Second Place: "+myRs.getString("USERNAME"),true);
                               thirdPlace=secondPlace;
                               secondPlace=myRs.getString("USERNAME");
                               
                               
                           }
                          //update  third place
                          else if(Integer.parseInt(myRs.getString("CORRECTLY_ANSWERED"))>z){
                               ss.setPlayer3("Third Place: "+myRs.getString("USERNAME"),true);
                               thirdPlace=myRs.getString("USERNAME");
                           }
                        }    

                               
			}
                                
                
                }
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
   /**
    *This method handles the database() method. 
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
        jScrollPane3 = new javax.swing.JScrollPane();
        user = new javax.swing.JTextArea();
        UPDATE = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Previous Standings");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 66));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("USER");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 118, 45, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 475, -1));

        user.setEditable(false);
        user.setColumns(20);
        user.setRows(5);
        jScrollPane3.setViewportView(user);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 460, 280));

        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        add(UPDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        Player_Observer.tracker=0;  
        user.setText("");
        Player_Observer.data="";
        handlingDatabase();
    }//GEN-LAST:event_UPDATEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UPDATE;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextArea user;
    // End of variables declaration//GEN-END:variables
}
