/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A51;

/**
 *
 * @author tbui48
 */
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
public class DashBoard extends javax.swing.JFrame {

    private static Component frame;

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
    }
    public static String convertToBinary(String input) {
        try{
            int a = Integer.parseInt(input);
            
            return Integer.toBinaryString(a);
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
    
    public static String prettyBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }
    public static boolean isNumeric(String str) { 
  try {  
    Double.parseDouble(str);  
    return true;
  } catch(NumberFormatException e){  
    return false;  
  }  
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
                         if(charsA[i] == charsB[i]){
                            result.append("1");
                        }
                        else{
                            result.append("0");
                        }
                    }
                    catch(Exception e){
                           System.err.println(e);
                    }
                    }
                    else{
                         JOptionPane.showMessageDialog(frame,"Vui lòng chỉ nhập số 0,1");
                         break;
                    }
            }
        
        
        return result.toString();  
    }
    public static boolean checkXOR(char a,char b)
    {
        if(a == b)
            return true;
        else
            return false;
    }
    public static String major(String x, String y,String z){
         String[] mangX = x.split("");
         String[] mangY = y.split("");
         String[] mangZ = z.split("");
         String m;
         if(mangX[8].equals(mangY[10]))
         {
             m = mangX[8];
         }
         else if(mangX[8].equals(mangZ[10]))
         {
             m = mangX[8];
         }
         else{
             m = mangY[10];
         }
         if(m.equals("0"))
         {
             if(mangX[8].equals("0")){
                  x = RotateX(x);
                mangX = x.split("");}
             if(mangY[10].equals("0")){
              y= RotateY(y);
                 mangY = y.split("");}
             if(mangZ[10].equals("0")){
                 z =RotateZ(z);
                 mangZ=z.split("");}
         }
         else{
             if(mangX[8].equals("1")){
                x = RotateX(x);
                mangX = x.split("");}
             if(mangY[10].equals("1")){
                y= RotateY(y);
                 mangY = y.split("");}
             if(mangZ[10].equals("1")){
                   z= RotateZ(z);
                 mangZ = z.split("");}
         }
         String abc =tinhXOR(tinhXOR(mangX[18], mangY[21]),mangZ[22]);
         return abc;
    }
     public static String RotateX(String x)
    {
        StringBuilder result = new StringBuilder();
         String[] mangX = x.split("");
        
         String t = tinhXOR(tinhXOR(tinhXOR(mangX[13], mangX[16]),mangX[17]),mangX[18]);
         
         result.append(t);

         for (int j = 0; j < 18; j++) {
             result.append(mangX[j]);
        }
           System.out.println(result.toString());
         return result.toString();
    }
    public static String RotateY(String y)
    {
        StringBuilder result = new StringBuilder();
         String[] mangY = y.split("");  
         String t = tinhXOR(mangY[20],mangY[21]);
         result.append(t);

         for (int j = 0; j < 21; j++) {
             result.append(mangY[j]);
        }
         System.out.println(result.toString());
         return result.toString();
    }
    public static String RotateZ(String z)
    {
        StringBuilder result = new StringBuilder();
         String[] mangZ = z.split("");  
         String t = tinhXOR(tinhXOR(tinhXOR(mangZ[7], mangZ[20]),mangZ[21]),mangZ[22]);
         result.append(t);

         for (int j = 0; j < 22; j++) {
             result.append(mangZ[j]);
        }
           System.out.println(result.toString());
         return result.toString();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtKeyDecryption = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tareaDecryptionResult = new javax.swing.JTextArea();
        txtPlainText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDecryption = new javax.swing.JButton();
        txtKeyEncryption = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tareaEncryptionResult = new javax.swing.JTextArea();
        btnEncryption = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCipherText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Key");

        jLabel1.setText("Plain Text");

        tareaDecryptionResult.setColumns(20);
        tareaDecryptionResult.setRows(5);
        jScrollPane2.setViewportView(tareaDecryptionResult);

        jLabel2.setText("Key");

        btnDecryption.setText("Decryption");

        tareaEncryptionResult.setColumns(20);
        tareaEncryptionResult.setRows(5);
        jScrollPane1.setViewportView(tareaEncryptionResult);

        btnEncryption.setText("Encryption");

        jLabel3.setText("Cipher Text");

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
                                        .addComponent(btnEncryption, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(183, 183, 183)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
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
    }// </editor-fold>                        

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

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDecryption;
    private javax.swing.JButton btnEncryption;
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
    // End of variables declaration                   
}
