/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jayjomjohn
 */
public class MyImage {
       //Code sa Image Lang
    public ImageIcon resizePic (String picPath, byte[] BLOBpic, int width, int hght) {
      
         ImageIcon myImg; 
        if(picPath != null){
          myImg = new ImageIcon(picPath);
        }else{
            myImg = new ImageIcon(BLOBpic);
        }
   
    Image img = myImg.getImage().getScaledInstance(width, hght, Image.SCALE_SMOOTH);
    ImageIcon myPicture = new ImageIcon(img);
    return myPicture;
}    
    
    public String browseImage (JLabel lbl) 
    {
        String path="";
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));     
        FileNameExtensionFilter filefilter = new FileNameExtensionFilter( "*.Images", "jpg", "png", "gif");
        filec.addChoosableFileFilter(filefilter);
        
        int filestate = filec.showSaveDialog(null);
           //if the user select a file
        if(filestate == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
           //imagePth = path;
           //display the image in the jLabel
           lbl.setIcon(resizePic(path, null, lbl.getWidth(), lbl.getHeight()));    
           //if the user cancel
        }else if(filestate == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Image Selected");
        }
        return path;
    }
}
