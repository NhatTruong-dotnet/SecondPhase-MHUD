/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A511;

/**
 *
 * @author tbui48
 */
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class DashBoard extends javax.swing.JFrame {

    private static Component frame;

    /**
     * Creates new form DashBoard
     */
    final String sessionKey = "0101110111111010001001101010100011110100110100101101011110011010";
    final String bitFrameCounter = "1110101011001111001011";
    final int[] x_TappedBit = new int[]{13, 16, 17, 18};
    final int[] y_TappedBit = new int[]{20, 21};
    final int[] z_TappedBit = new int[]{7, 20, 21, 22};
    final int[] streamKeyIndex = new int[]{18, 21, 22};
    final int clocked_X_Major = 8;
    final int clocked_Y_Major = 10;
    final int clocked_Z_Major = 10;
    final int streamKeySize = 228;
    String[] x_Register = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    String[] y_Register = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    String[] z_Register = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};

    public DashBoard() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Dau"> 
    public static String convertPlainTextToBinary(String plainText) {
        try{
            int dec = Integer.parseInt(plainText);
            String result= "00000000";
            int i=result.length()-1;
            while(dec!=0)
            {
              char a[]=result.toCharArray();
              a[i--]= String.valueOf(dec%2).charAt(0);
              result=new String(a);
              dec=dec/2;  

            }
            return  result;
        }
        catch(Exception e)
        {
             StringBuilder result = new StringBuilder();
            char[] chars = plainText.toCharArray();
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
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String tinhXOR(String a, String b) {
        StringBuilder result = new StringBuilder();

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        for (int i = 0; i <= a.length() - 1; i++) {
            if ((charsA[i] == '0' || charsA[i] == '1') && ((charsB[i] == '0' || charsB[i] == '1'))) {
                try {
                    result.append(charsA[i] ^ charsB[i]);
                } catch (Exception e) {
                    System.err.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Vui long chi nhap so 0,1");
                break;
            }
        }

        return result.toString();
    }
    public static String[] major(String x, String y, String z) {
        String[] mangX = x.split("");
        String[] mangY = y.split("");
        String[] mangZ = z.split("");
        String[] mang = new String[4];

        String m;
        if (mangX[8].equals(mangY[10])) {
            m = mangX[8];
        } else if (mangX[8].equals(mangZ[10])) {
            m = mangX[8];
        } else {
            m = mangY[10];
        }
        if (m.equals("0")) {
            if (mangX[8].equals("0")) {
                x = RotateX(x);
                mangX = x.split("");
            }
            if (mangY[10].equals("0")) {
                y = RotateY(y);
                mangY = y.split("");
            }
            if (mangZ[10].equals("0")) {
                z = RotateZ(z);
                mangZ = z.split("");
            }
        } else {
            if (mangX[8].equals("1")) {
                x = RotateX(x);
                mangX = x.split("");
            }
            if (mangY[10].equals("1")) {
                y = RotateY(y);
                mangY = y.split("");
            }
            if (mangZ[10].equals("1")) {
                z = RotateZ(z);
                mangZ = z.split("");
            }
        }
        String abc = tinhXOR(tinhXOR(mangX[18], mangY[21]), mangZ[22]);
        mang[0] = abc;
        mang[1] = x;
        mang[2] = y;
        mang[3] = z;
        return mang;
    }
    public static String RotateX(String x) {
        StringBuilder result = new StringBuilder();
        String[] mangX = x.split("");

        String t = tinhXOR(tinhXOR(tinhXOR(mangX[13], mangX[16]), mangX[17]), mangX[18]);

        result.append(t);

        for (int j = 0; j < 18; j++) {
            result.append(mangX[j]);
        }
        System.out.println(result.toString());
        return result.toString();
    }
    public static String RotateY(String y) {
        StringBuilder result = new StringBuilder();
        String[] mangY = y.split("");
        String t = tinhXOR(mangY[20], mangY[21]);
        result.append(t);

        for (int j = 0; j < 21; j++) {
            result.append(mangY[j]);
        }
        System.out.println(result.toString());
        return result.toString();
    }
    public static String RotateZ(String z) {
        StringBuilder result = new StringBuilder();
        String[] mangZ = z.split("");
        String t = tinhXOR(tinhXOR(tinhXOR(mangZ[7], mangZ[20]), mangZ[21]), mangZ[22]);
        result.append(t);

        for (int j = 0; j < 22; j++) {
            result.append(mangZ[j]);
        }
        System.out.println(result.toString());
        return result.toString();
    }
// </editor-fold> 
    
    
    // <editor-fold defaultstate="collapsed" desc="Truong rewrite all thing">  
    //step1 finsih
    //step2: init value for 3 register base session key and tapped bit
    private void initRegisterBaseKey(String[] sessionKeyInput) {
        //already check, not complete test
        if (sessionKeyInput != null) {
            int count_X = 0;
            int count_Y = 0;
            int count_Z = 0;
            for (int index = 0; index < sessionKeyInput.length; index++) {
                x_Register[count_X >= 18 ? count_X = 0 : count_X++] = XOR(sessionKeyInput[index], XORWithConstArrayIndex(x_TappedBit, x_Register));
                y_Register[count_Y >= 21 ? count_Y = 0 : count_Y++] = XOR(sessionKeyInput[index], XORWithConstArrayIndex(y_TappedBit, y_Register));
                z_Register[count_Z >= 22 ? count_Z = 0 : count_Z++] = XOR(sessionKeyInput[index], XORWithConstArrayIndex(z_TappedBit, z_Register));
            }
        }
    }

    private String XORWithConstArrayIndex(int[] indexXOR, String[] register) {
        //already check, not complete test
        int currentXOR = 0;
        for (int index = 0; index < indexXOR.length; index++) {
            currentXOR = Integer.parseInt(register[indexXOR[index]]) ^ currentXOR;
        }
        return String.valueOf(currentXOR);
    }

    private String XOR(String firstBit, String secondBit) {
        //already check, not complete test
        return String.valueOf(Integer.parseInt(firstBit) ^ Integer.parseInt(secondBit));
    }

    private String Major() {
        return String.valueOf(Integer.parseInt(x_Register[clocked_X_Major]) ^ Integer.parseInt(y_Register[clocked_Y_Major]) ^ Integer.parseInt(z_Register[clocked_Z_Major]));
    }

    private void Rotate(String[] register, String bitReplace) {
        //move left to 1 bit at index 0 = XOR tappedBit together in register
        int currentIndex = register.length;
        while (currentIndex > 0) {
            register[currentIndex] = register[currentIndex - 1];
            currentIndex--;
        }
        register[currentIndex] = bitReplace;
    }

    private void rotate100ReInit() {
        for (int counter = 0; counter < 100; counter++) {
            String majorResult = Major();
            if (Objects.equals(x_Register[clocked_X_Major], majorResult)) {
                Rotate(x_Register, XORWithConstArrayIndex(x_TappedBit, x_Register));
            }
            if (Objects.equals(y_Register[clocked_Y_Major], majorResult)) {
                Rotate(y_Register, XORWithConstArrayIndex(y_TappedBit, y_Register));
            }
            if (Objects.equals(z_Register[clocked_Z_Major], majorResult)) {
                Rotate(z_Register, XORWithConstArrayIndex(z_TappedBit, z_Register));
            }
        }
    }

    private String[] generateStreamKey() {
        String[] streamKey = new String[streamKeySize];
        for (int index = 0; index < streamKeySize; index++) {
            String majorResult = Major();
            String[] streamKeyArr = new String[3];
            if (Objects.equals(x_Register[clocked_X_Major], majorResult)) {
                Rotate(x_Register, XORWithConstArrayIndex(x_TappedBit, x_Register));
                streamKeyArr[0] = x_Register[18];
            }
            if (Objects.equals(y_Register[clocked_Y_Major], majorResult)) {
                Rotate(y_Register, XORWithConstArrayIndex(y_TappedBit, y_Register));
                streamKeyArr[1] = y_Register[21];
            }
            if (Objects.equals(z_Register[clocked_Z_Major], majorResult)) {
                Rotate(z_Register, XORWithConstArrayIndex(z_TappedBit, z_Register));
                streamKeyArr[2] = z_Register[22];
            }
            streamKey[index] = XORWithConstArrayIndex(streamKeyIndex, streamKeyArr);
        }
        return streamKey;
    }
// </editor-fold> 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        btnDecryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptionActionPerformed(evt);
            }
        });

        tareaEncryptionResult.setColumns(20);
        tareaEncryptionResult.setRows(5);
        jScrollPane1.setViewportView(tareaEncryptionResult);

        btnEncryption.setText("Encryption");
        btnEncryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptionActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(txtPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(txtKeyEncryption, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(183, 183, 183))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEncryption, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(247, 247, 247)))
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
                        .addGap(41, 41, 41)
                        .addComponent(btnEncryption))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
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
    private String generateStreamKey(int length, String K){
        String streamKey = "";
        
        String X, Y, Z;
        try{
            if(K.contains(".")){
            String [] arrayXYZ = K.split(".");
            X = arrayXYZ[0];
            Y = arrayXYZ[1];
            Z = arrayXYZ[2];
            }
            else{
                X = K.substring(0, 19);
                Y = K.substring(19, 41);
                Z = K.substring(41);
            }
            if(X.length() != 19 || Y.length() != 22 || Z.length() !=23)
            {
                JOptionPane.showMessageDialog(frame,"Key invalid");
            }

            for(int i = 0; i < length; i++){
                String[] arr;
                arr = major(X,Y,Z);
                
                streamKey += arr[0];
                X = arr[1];
                Y = arr[2];
                Z = arr[3];
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(frame,"Key invalid");
        }
        return streamKey;
    }
    private void btnEncryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptionActionPerformed
//        String[] streamKey = new String[streamKeySize];
//        initRegisterBaseKey(sessionKey.split(""));
//        initRegisterBaseKey(bitFrameCounter.split(""));
//        rotate100ReInit();
//        streamKey = generateStreamKey();
//        
//        System.out.println(Arrays.toString(x_Register));
//        System.out.println(Arrays.toString(y_Register));
//        System.out.println(Arrays.toString(z_Register));
          String plainText = txtPlainText.getText().trim().replaceAll("\\s{1,}","");
            String K = txtKeyEncryption.getText().trim().replaceAll("\\s{1,}","");

            if("".equals(plainText) || "".equals(K)){
                JOptionPane.showMessageDialog(frame,"Key or plainText invalid");
            }
            else{
                String cipherText ;
                plainText = convertPlainTextToBinary(plainText);

                String streamKey = generateStreamKey(plainText.length(), K);

                cipherText = tinhXOR(streamKey, plainText);
                tareaEncryptionResult.setText(cipherText);
            } 
    }//GEN-LAST:event_btnEncryptionActionPerformed

    private void btnDecryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptionActionPerformed
        // TODO add your handling code here:
        String cipherText = txtCipherText.getText().trim().replaceAll("\\s{1,}","");
        String K = txtKeyDecryption.getText().trim().replaceAll("\\s{1,}","");
        if("".equals(cipherText) || "".equals(K)){
            JOptionPane.showMessageDialog(frame,"Key or plainText invalid");
        }
        else{
            String plainText;
        
            cipherText = convertPlainTextToBinary(cipherText);
            String streamKey = generateStreamKey(cipherText.length(), K);

            plainText = tinhXOR(streamKey, cipherText);
            tareaDecryptionResult.setText(plainText);
        }
    }//GEN-LAST:event_btnDecryptionActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
