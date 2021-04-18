/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RC41;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Component;
import java.awt.RenderingHints;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static sun.util.calendar.CalendarUtils.mod;

/**
 *
 * @author tbui48
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
    }
    int[] S = new int[256] ;
    String[] T = new String[256];
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlainText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtKeyEncryption = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tareaEncryptionResult = new javax.swing.JTextArea();
        btnEncryption = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCipherText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKeyDecryption = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tareaDecryptionResult = new javax.swing.JTextArea();
        btnDecryption = new javax.swing.JButton();
        btnOpenPlainText = new javax.swing.JButton();
        btnSaveCipherText = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Plain Text");

        txtPlainText.setDoubleBuffered(true);
        txtPlainText.setDragEnabled(true);

        jLabel2.setText("Key");

        tareaEncryptionResult.setColumns(20);
        tareaEncryptionResult.setRows(5);
        tareaEncryptionResult.setDragEnabled(true);
        tareaEncryptionResult.setDropMode(javax.swing.DropMode.INSERT);
        jScrollPane1.setViewportView(tareaEncryptionResult);

        btnEncryption.setText("Encryption");
        btnEncryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptionActionPerformed(evt);
            }
        });

        jLabel3.setText("Cipher Text");

        jLabel4.setText("Key");

        tareaDecryptionResult.setColumns(20);
        tareaDecryptionResult.setRows(5);
        jScrollPane2.setViewportView(tareaDecryptionResult);

        btnDecryption.setText("Decryption");
        btnDecryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptionActionPerformed(evt);
            }
        });

        btnOpenPlainText.setText("Open File");
        btnOpenPlainText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenPlainTextActionPerformed(evt);
            }
        });

        btnSaveCipherText.setText("Save");
        btnSaveCipherText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCipherTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCipherText, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKeyDecryption, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(btnDecryption, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(183, 183, 183)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(txtPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKeyEncryption, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(btnEncryption, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(btnOpenPlainText)
                                        .addGap(196, 196, 196)
                                        .addComponent(btnSaveCipherText)))))
                        .addGap(183, 183, 183)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKeyEncryption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(btnEncryption))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpenPlainText)
                    .addComponent(btnSaveCipherText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCipherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtKeyDecryption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(btnDecryption))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnEncryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptionActionPerformed
        String plainText = txtPlainText.getText();
        String key = txtKeyEncryption.getText();

        if(!plainText.isEmpty() && !key.isEmpty()){
            //handle key > 255 
            if(key.length() > 255){
                key = key.substring(0, 255);
            }
            String[] arrayKey = new String[key.length()];
            //convert to decimal value in ascii
            for(int i = 0; i < key.length(); i++){
                arrayKey[i] = String.valueOf(key.codePointAt(i));
            }
            //encryption
            initS_and_T_Array(arrayKey);

            permutatesS();
            String streamKey = generateStreamKey(plainText.length());
            plainText = convertToBinary(plainText);      

            String xorResult = tinhXOR(plainText, streamKey);

            String cipherText=convertBinarytoDecimal(xorResult);
            
            tareaEncryptionResult.setText(cipherText);
        }else{
            JOptionPane.showMessageDialog(rootPane,"PlainText or key invalid");
        } 
    }//GEN-LAST:event_btnEncryptionActionPerformed

    private void btnDecryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptionActionPerformed
        // TODO add your handling code here:
        String cipherText = txtCipherText.getText();
        String key = txtKeyDecryption.getText();

        if(!cipherText.isEmpty()&& !key.isEmpty()){
            //handle key > 255 
            if(key.length() > 255){
                key = key.substring(0, 255);
            }
            
            String[] arrayKey = new String[key.length()];
            for(int i = 0; i < key.length(); i++){
                try {
                    arrayKey[i] = Integer.parseInt(String.valueOf(key.charAt(i)))+"";
                    
                } catch (Exception e) {
                    arrayKey[i] = String.valueOf(key.codePointAt(i));
                    
                }
            }
            //decryption
            initS_and_T_Array(arrayKey);
            permutatesS();
            String streamKey = generateStreamKey(cipherText.length());
            cipherText = convertToBinary(cipherText);
            
            String xorResult = tinhXOR(cipherText, streamKey);
            String plainText = convertBinarytoDecimal(xorResult);
            tareaDecryptionResult.setText(plainText);
        }else{
            JOptionPane.showMessageDialog(rootPane,"PlainText or Key invalid");
        }
    }//GEN-LAST:event_btnDecryptionActionPerformed
    //open file explore and read file
    private void btnOpenPlainTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenPlainTextActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();
        String out = "";
        if(f != null){
            
            try {
                Scanner sc = new Scanner(f);
                
                while(sc.hasNext()){
                    out += sc.nextLine();
                }
                txtPlainText.setText(out);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane,"cannot open file");
                
            }
        }
    }//GEN-LAST:event_btnOpenPlainTextActionPerformed
    //open file explore and print file
    private void btnSaveCipherTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCipherTextActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        //file select
        File f = chooser.getSelectedFile();
        
        if(f != null){
            Formatter saveFile;
            try {
                String input = tareaEncryptionResult.getText();
                saveFile = new Formatter(f);
                saveFile.format("%s", input);
                saveFile.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane,"cannot open file");

            }
        }
    }//GEN-LAST:event_btnSaveCipherTextActionPerformed
    private String convertBinarytoDecimal(String input){
        String result = "";
        for(int i = 0; i < input.length() ; ){
            result += (char)Integer.parseInt(input.substring(i, i+=8),2);
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }
        public static String tinhXOR(String a,String b)
        {
             StringBuilder result = new StringBuilder();

                char[] charsA = a.toCharArray();
                char[] charsB = b.toCharArray();
                 for (int i = 0; i <= a.length()-1; i++) {
                        if(charsA[i] == '0' || charsA[i] == '1' ||charsB[i] == '0' || charsB[i] == '1')
                        {
                            try
                            {
                                result.append(charsA[i] ^ charsB[i]);
                            }
                            catch(Exception e){
                                   System.err.println(e);
                            }
                        }
                        else{
                            Component frame = null;
                             JOptionPane.showMessageDialog(frame,"Vui lòng chỉ nhập số 0,1");
                             break;
                        }
                }


            return result.toString();  
        }
        public static String convertToBinary(String input) {
            
            try{
                int dec = Integer.parseInt(input);
                String result= "00000000";
                int i=result.length()-1;
                while(dec!=0)
                {
                  char a[]=result.toCharArray();
                  a[i--]= String.valueOf(dec%2).charAt(0);
                  result=new String(a);
                  dec=dec/2;  }
                    return  result;
                }
            catch(Exception e)
            {
                StringBuilder result = new StringBuilder();
                char[] chars = input.toCharArray();
                for (char aChar : chars) {
                    result.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0")  );    // char -> int, auto-cast
                }
               
                return result.toString();  
            }

        }
        private String generateStreamKey(int length){
        
            
            String streamKey = "";
            int i = 0, j =0, loop = 0;
            
            while(loop < length){
                
                i = (i+1) % 256;
                j = (j+S[i]) % 256;

                int temp ;
                temp = S[i];
                S[i] = S[j];
                S[j] = temp;

                int t = (S[i] + S[j]) % 256;
                int k = S[t];
                streamKey += convertToBinary(String.valueOf(k));
                loop++;
            }
            return streamKey;
        }
        
        
        
        private void initS_and_T_Array(String[]keyArray){
//            String key = txtKeyEncryption.getText();
            
//                String[] keyArray = key.split("");
                int modForFill = 256 % keyArray.length;
                int repeatToFill = 256 / keyArray.length;

                if(repeatToFill != 0){
                    for(int index = 0; index < 256;){
                        while(repeatToFill > 0) {
                            for(int indexT = 0; indexT < keyArray.length; indexT++){
                                T[index] = keyArray[indexT];
                                S[index] = index;
                                index++;
                            }
                            repeatToFill--;
                        }
                        if(index > 255){
                            return;
                        }
                        else{
                            S[index] = index;
                            index++;
                        }
                    }

                    repeatToFill = 256 / keyArray.length;    
                    for(int index = 0; index < modForFill; index++){
                        int currentIndexToInsert = repeatToFill*keyArray.length + index;
                        T[currentIndexToInsert] = keyArray[index];
                    }
                }
                else{
                    for(int index = 0; index < 256;index++){
                        S[index] = index;
                    }
                    T = keyArray;
                }
            
            
        }
        
        private void permutatesS(){
            int j =0;
            for(int index = 0; index < 256; index++){
                int temp = Integer.parseInt(T[index]);
                j = (j + S[index] +  temp) % 256;
                temp = S[index];
                S[index] = S[j];
                S[j] = temp;
            }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecryption;
    private javax.swing.JButton btnEncryption;
    private javax.swing.JButton btnOpenPlainText;
    private javax.swing.JButton btnSaveCipherText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tareaDecryptionResult;
    private javax.swing.JTextArea tareaEncryptionResult;
    private javax.swing.JTextField txtCipherText;
    private javax.swing.JTextField txtKeyDecryption;
    private javax.swing.JTextField txtKeyEncryption;
    private javax.swing.JTextField txtPlainText;
    // End of variables declaration//GEN-END:variables
}
