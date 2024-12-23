
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URI;
import util.TokenUtil;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USER
 */
public class WriteRecipeFrame extends javax.swing.JFrame {

    /**
     * Creates new form WriteRecipeFrame
     */
    public WriteRecipeFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanelHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        comboSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanelBody = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblNecess = new javax.swing.JLabel();
        jScrollPaneOrder = new javax.swing.JScrollPane();
        jTextAreaOrder = new javax.swing.JTextArea();
        lblOrder = new javax.swing.JLabel();
        jScrollPaneNecess = new javax.swing.JScrollPane();
        jTextAreaNecess = new javax.swing.JTextArea();
        btnWrite = new javax.swing.JButton();
        lblRefSite = new javax.swing.JLabel();
        txtRefUrl = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();
        lblFile = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        jScrollPaneContent = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();
        lblContent = new javax.swing.JLabel();
        btnAddTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setText("레시피 공유 프로그램");
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoMouseClicked(evt);
            }
        });

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "제목", "작성자", "재료" }));

        btnSearch.setText("검색");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnMyProfile.setText("내 정보");
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileActionPerformed(evt);
            }
        });

        btnLogout.setText("로그아웃");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHeaderLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblLogo)
                    .addGap(46, 46, 46)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                    .addComponent(btnMyProfile)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnLogout)
                    .addContainerGap()))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHeaderLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLogo)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch)
                        .addComponent(btnMyProfile)
                        .addComponent(btnLogout)
                        .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        lblTitle.setText("제목");

        lblNecess.setText("필요한 재료");

        jTextAreaOrder.setColumns(20);
        jTextAreaOrder.setRows(5);
        jScrollPaneOrder.setViewportView(jTextAreaOrder);

        lblOrder.setText("조리 순서");

        jTextAreaNecess.setColumns(20);
        jTextAreaNecess.setRows(5);
        jScrollPaneNecess.setViewportView(jTextAreaNecess);

        btnWrite.setText("작성하기");
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteActionPerformed(evt);
            }
        });

        lblRefSite.setText("참조 사이트");

        btnFile.setText("파일 불러오기");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        lblFile.setText("첨부파일");

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPaneContent.setViewportView(jTextAreaContent);

        lblContent.setText("내용");

        btnAddTable.setText("추가하기");
        btnAddTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTableActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "설명", "이미지"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addComponent(btnAddTable)
                        .addGap(18, 18, 18)
                        .addComponent(btnWrite))
                    .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblRefSite)
                        .addComponent(lblOrder)
                        .addComponent(lblNecess)
                        .addComponent(jScrollPaneOrder)
                        .addComponent(jScrollPaneNecess)
                        .addComponent(txtRefUrl)
                        .addGroup(jPanelBodyLayout.createSequentialGroup()
                            .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFile)
                                .addComponent(lblTitle)
                                .addComponent(lblContent))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelBodyLayout.createSequentialGroup()
                                    .addComponent(txtFile)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnFile))))
                        .addComponent(jScrollPaneContent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFile)
                            .addComponent(btnFile)
                            .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblContent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNecess)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneNecess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRefSite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRefUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWrite)
                    .addComponent(btnAddTable))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked
        // TODO add your handling code here:
        new SubFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        new SearchResultFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        // TODO add your handling code here:
        new MyProfileFrame().setVisible(true);
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        int returnValue = jFileChooser1.showOpenDialog(this);
            if (returnValue == jFileChooser1.APPROVE_OPTION) {
                File selectedFile = jFileChooser1.getSelectedFile();
                txtFile.setText(selectedFile.getAbsolutePath()); // 선택한 파일 경로 표시
            }
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnAddTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTableActionPerformed
        String detail = jTextAreaOrder.getText(); // 조리 순서 내용
        String imgPath = txtFile.getText();      // 이미지 파일 경로

        if (detail == null || detail.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "조리 순서를 입력해주세요!");
            return;
        }

        // 테이블 모델에 추가
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (imgPath == null || imgPath.trim().isEmpty()) {
            // 이미지 없이 조리 순서만 추가
            model.addRow(new Object[]{detail, ""});
        } else {
            // 이미지와 조리 순서 모두 추가
            model.addRow(new Object[]{detail, imgPath});
        }

        // 입력 필드 초기화
        jTextAreaOrder.setText("");
        txtFile.setText("");
    }//GEN-LAST:event_btnAddTableActionPerformed

    private void btnWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteActionPerformed
        try {
        String apiUrl = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/postRecipe";
        String boundary = "Boundary-" + System.currentTimeMillis();
        String token = TokenUtil.loadUserInfo().getString("token");

        // HTTP 연결 설정
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        connection.setRequestProperty("Authorization", "Bearer " + token);

        // 요청 데이터 작성
        try (OutputStream outputStream = connection.getOutputStream();
             DataOutputStream writer = new DataOutputStream(outputStream)) {

            // 필수 필드 추가
            addFormField(writer, "title", txtTitle.getText(), boundary);
            addFormField(writer, "description", jTextAreaContent.getText(), boundary);
            addFormField(writer, "ingredient", jTextAreaNecess.getText(), boundary);

            // 테이블 데이터 추가 (detail & img)
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                String detail = (String) model.getValueAt(i, 0);
                String imgPath = (String) model.getValueAt(i, 1);

                // detail 추가
                addFormField(writer, "detail" + (i + 1), detail, boundary);

                // img 추가 (이미지가 있는 경우에만)
                if (imgPath != null && !imgPath.trim().isEmpty()) {
                    File imgFile = new File(imgPath);
                    if (imgFile.exists()) {
                        addFilePart(writer, "img" + (i + 1), imgFile, boundary);
                    } else {
                        JOptionPane.showMessageDialog(this, "이미지 파일이 존재하지 않습니다: " + imgPath);
                        return;
                    }
                }
            }

            // Boundary 종료
            writer.writeBytes("--" + boundary + "--\r\n");
        }

        // 서버 응답 확인
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            JOptionPane.showMessageDialog(this, "레시피 업로드 성공!");
        } else {
            InputStream errorStream = connection.getErrorStream();
            if (errorStream != null) {
                String responseMessage = new String(errorStream.readAllBytes(), StandardCharsets.UTF_8);
                System.out.println("서버 응답: " + responseMessage);
            }
            JOptionPane.showMessageDialog(this, "업로드 실패: 응답 코드 " + responseCode);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "오류 발생: " + e.getMessage());
    }
    }//GEN-LAST:event_btnWriteActionPerformed

    // 텍스트 필드 추가 메서드
    private static void addFormField(DataOutputStream writer, String fieldName, String value, String boundary) throws Exception {
        writer.writeBytes("--" + boundary + "\r\n"); // Boundary 시작
    writer.writeBytes("Content-Disposition: form-data; name=\"" + fieldName + "\"\r\n"); // 필드 이름
    writer.writeBytes("\r\n"); // 빈 줄
    writer.writeBytes(value + "\r\n"); // 데이터 쓰기 (중복 제거)
    }

    // 파일 필드 추가 메서드
    private static void addFilePart(DataOutputStream writer, String fieldName, File uploadFile, String boundary) throws Exception {
        String fileName = uploadFile.getName();
        writer.writeBytes("--" + boundary + "\r\n");
        writer.writeBytes("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"\r\n");
        writer.writeBytes("Content-Type: application/octet-stream\r\n"); // 파일 타입 설정
        writer.writeBytes("\r\n");

        try (FileInputStream inputStream = new FileInputStream(uploadFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }
        }

        writer.writeBytes("\r\n");
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
            java.util.logging.Logger.getLogger(WriteRecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteRecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteRecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteRecipeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WriteRecipeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTable;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnWrite;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneContent;
    private javax.swing.JScrollPane jScrollPaneNecess;
    private javax.swing.JScrollPane jScrollPaneOrder;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaContent;
    private javax.swing.JTextArea jTextAreaNecess;
    private javax.swing.JTextArea jTextAreaOrder;
    private javax.swing.JLabel lblContent;
    private javax.swing.JLabel lblFile;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNecess;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblRefSite;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextField txtRefUrl;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
