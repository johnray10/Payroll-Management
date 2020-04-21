/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

/**
 *
 * @author Jayjomjohn
 */
public class Splash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
          Loading a =new Loading();
          a.setVisible(true);     
     try {        
         for (int i=0; i<=100; i++) {
          Thread.sleep(40);
         // sp.per.setText(" "+i);
          a.jProgressBar1.setValue(i);
             if (i==100) {
                 Login m = new Login();
                 a.setVisible(false);
                 m.setVisible(true);
             }
         }
     } catch (Exception e) {
        
     }
      
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
    

