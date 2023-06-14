
package online.examination;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Timer;
import java.sql.*;
import javax.swing.JOptionPane;

public class Java_Test extends javax.swing.JFrame {
    String s_name ;
    int s_id;
    
    
    String answers[] = {"1","2","1","3","1"};
    int second,minute;
    String ddSecond,ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");
    
    Timer timer;
    public void countDownTimer()
    {
        timer = new Timer(1000,new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute+":"+ddSecond);
                
                if(second == -1)
                {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counterLabel.setText(ddMinute+":"+ddSecond);
                }
                if(minute==0 && second==0)
                {
                    submission();
                    timer.stop();
                }
            }
        });
    }
    public void startTimer()
    {
        counterLabel.setText("01:00");
        second = 20;
        minute = 0;
        countDownTimer();
        timer.start();
    }
    public Java_Test() {
        initComponents();
    }
    
    
    
    public void submission()
    {
        one_1.setActionCommand("1");
        one_2.setActionCommand("2");
        one_3.setActionCommand("3");
        one_4.setActionCommand("4");
        
        two_1.setActionCommand("1");
        two_2.setActionCommand("2");
        two_3.setActionCommand("3");
        two_4.setActionCommand("4");
        
        three_1.setActionCommand("1");
        three_2.setActionCommand("2");
        three_3.setActionCommand("3");
        three_4.setActionCommand("4");
        
        four_1.setActionCommand("1");
        four_2.setActionCommand("2");
        four_3.setActionCommand("3");
        four_4.setActionCommand("4");
        
        five_1.setActionCommand("1");
        five_2.setActionCommand("2");
        five_3.setActionCommand("3");
        five_4.setActionCommand("4");
        
//        System.out.print(buttonGroup1.getSelection().getSelectedObjects());
        String ans1 = buttonGroup1.getSelection().getActionCommand();
        String ans2 = buttonGroup2.getSelection().getActionCommand();
        String ans3 = buttonGroup3.getSelection().getActionCommand();
        String ans4 = buttonGroup4.getSelection().getActionCommand();
        String ans5 = buttonGroup5.getSelection().getActionCommand();
        
        String selectedOptions[] = {ans1,ans2,ans3,ans4,ans5};
        
        int correct = 0;
        for(int i=0;i<answers.length;i++)
        {
            if(answers[i] == selectedOptions[i])
                correct ++;
        }
        
        PreparedStatement ps;
        String query = "UPDATE Users SET `java`=? WHERE `sid`=?";
        try
        {
            ps = OnlineExamination.jdbc().prepareStatement(query);
            ps.setInt(1, correct);
            ps.setInt(2, s_id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Submitted successfully");
            MainPage mp = new MainPage();
            mp.s_name = s_name;
            mp.s_id = s_id;
            mp.setVisible(true);
            mp.pack();
            mp.setLocationRelativeTo(null);
            mp.checkTests();
            mp.display();
            this.dispose();
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Exception occured");
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        one_1 = new javax.swing.JRadioButton();
        one_2 = new javax.swing.JRadioButton();
        one_3 = new javax.swing.JRadioButton();
        one_4 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        two_1 = new javax.swing.JRadioButton();
        two_2 = new javax.swing.JRadioButton();
        two_3 = new javax.swing.JRadioButton();
        two_4 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        three_1 = new javax.swing.JRadioButton();
        three_2 = new javax.swing.JRadioButton();
        three_3 = new javax.swing.JRadioButton();
        three_4 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        four_1 = new javax.swing.JRadioButton();
        four_2 = new javax.swing.JRadioButton();
        four_3 = new javax.swing.JRadioButton();
        four_4 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        five_1 = new javax.swing.JRadioButton();
        five_2 = new javax.swing.JRadioButton();
        five_3 = new javax.swing.JRadioButton();
        five_4 = new javax.swing.JRadioButton();
        submit = new javax.swing.JButton();
        counterLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("1.  What is the size of float and double in java?");

        buttonGroup1.add(one_1);
        one_1.setText("32 and 64");

        buttonGroup1.add(one_2);
        one_2.setText("64 and 32");

        buttonGroup1.add(one_3);
        one_3.setText("32 and 32");

        buttonGroup1.add(one_4);
        one_4.setText("64 and 64");
        one_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                one_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(one_4)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(one_2)
                                .addComponent(one_1)
                                .addComponent(one_3)))))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addComponent(one_1)
                .addGap(18, 18, 18)
                .addComponent(one_2)
                .addGap(18, 18, 18)
                .addComponent(one_3)
                .addGap(18, 18, 18)
                .addComponent(one_4)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 147, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("1", jPanel2);

        jLabel2.setText("2.  Number of primitive data types in Java are?      ");

        buttonGroup2.add(two_1);
        two_1.setText("5");

        buttonGroup2.add(two_2);
        two_2.setText("8");

        buttonGroup2.add(two_3);
        two_3.setText("7");

        buttonGroup2.add(two_4);
        two_4.setText("10");
        two_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                two_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(two_4)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(two_2)
                                .addComponent(two_1)
                                .addComponent(two_3)))))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(two_1)
                .addGap(18, 18, 18)
                .addComponent(two_2)
                .addGap(18, 18, 18)
                .addComponent(two_3)
                .addGap(18, 18, 18)
                .addComponent(two_4)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 124, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("2", jPanel3);

        jLabel1.setText("3.  Automatic type conversion is possible in which of the possible cases?");

        buttonGroup3.add(three_1);
        three_1.setText("int to long");

        buttonGroup3.add(three_2);
        three_2.setText("long to int");

        buttonGroup3.add(three_3);
        three_3.setText("byte to int");

        buttonGroup3.add(three_4);
        three_4.setText("short to int");
        three_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                three_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(three_4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(three_2)
                                .addComponent(three_1)
                                .addComponent(three_3)))))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(three_1)
                .addGap(18, 18, 18)
                .addComponent(three_2)
                .addGap(18, 18, 18)
                .addComponent(three_3)
                .addGap(18, 18, 18)
                .addComponent(three_4)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("3", jPanel1);

        jLabel4.setText("4.  Select the valid statement.");

        buttonGroup4.add(four_1);
        four_1.setText("int[] arr = new int(5);");

        buttonGroup4.add(four_2);
        four_2.setText("int[] arr = new int();");

        buttonGroup4.add(four_3);
        four_3.setText("int[] arr = new int[5];");

        buttonGroup4.add(four_4);
        four_4.setText("int[] arr = new int[];");
        four_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                four_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(four_4)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(four_1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(four_2)
                                    .addComponent(four_3))))))
                .addContainerGap(570, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(four_1)
                .addGap(18, 18, 18)
                .addComponent(four_2)
                .addGap(18, 18, 18)
                .addComponent(four_3)
                .addGap(18, 18, 18)
                .addComponent(four_4)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("4", jPanel6);

        jLabel6.setText("5.  When an array is passed to a method, what does the method receive?");

        buttonGroup5.add(five_1);
        five_1.setText("Reference of an array");

        buttonGroup5.add(five_2);
        five_2.setText("Copy of an array");

        buttonGroup5.add(five_3);
        five_3.setText("Length of an array");
        five_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                five_3ActionPerformed(evt);
            }
        });

        buttonGroup5.add(five_4);
        five_4.setText("Copy of first element");
        five_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                five_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(five_4)
                            .addComponent(five_1)
                            .addComponent(five_2)
                            .addComponent(five_3))))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(five_1)
                .addGap(18, 18, 18)
                .addComponent(five_2)
                .addGap(18, 18, 18)
                .addComponent(five_3)
                .addGap(18, 18, 18)
                .addComponent(five_4)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("5", jPanel8);

        submit.setBackground(new java.awt.Color(255, 0, 0));
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        counterLabel.setText("Timer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(counterLabel)
                .addGap(31, 31, 31)
                .addComponent(submit)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(counterLabel))
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void three_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_three_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_three_4ActionPerformed

    private void two_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_two_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_two_4ActionPerformed

    private void one_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_one_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_one_4ActionPerformed

    private void four_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_four_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_four_4ActionPerformed

    private void five_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_five_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_five_4ActionPerformed

    private void five_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_five_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_five_3ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        submission();
    }//GEN-LAST:event_submitActionPerformed

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
            java.util.logging.Logger.getLogger(Java_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Java_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Java_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Java_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java_Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel counterLabel;
    private javax.swing.JRadioButton five_1;
    private javax.swing.JRadioButton five_2;
    private javax.swing.JRadioButton five_3;
    private javax.swing.JRadioButton five_4;
    private javax.swing.JRadioButton four_1;
    private javax.swing.JRadioButton four_2;
    private javax.swing.JRadioButton four_3;
    private javax.swing.JRadioButton four_4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton one_1;
    private javax.swing.JRadioButton one_2;
    private javax.swing.JRadioButton one_3;
    private javax.swing.JRadioButton one_4;
    private javax.swing.JButton submit;
    private javax.swing.JRadioButton three_1;
    private javax.swing.JRadioButton three_2;
    private javax.swing.JRadioButton three_3;
    private javax.swing.JRadioButton three_4;
    private javax.swing.JRadioButton two_1;
    private javax.swing.JRadioButton two_2;
    private javax.swing.JRadioButton two_3;
    private javax.swing.JRadioButton two_4;
    // End of variables declaration//GEN-END:variables
}
