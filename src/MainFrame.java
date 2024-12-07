
import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.ImageIcon;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject; // JSON 데이터 파싱용
import util.TokenUtil;

//JSON 요청 데이터 담는 클래스
class LoginRequest {
    private String account;
    private String password;
    
    public LoginRequest(String account, String password) {
        this.account = account;
        this.password = password;
    }
}

public class MainFrame extends javax.swing.JFrame {
    
    
    
    private Captcha captcha; //캡쳐 객체

    public MainFrame() {
        initComponents();
        autoLogin();
        generateCaptcha(); // 초기 CAPTCHA 생성
        
    }
    
    private void autoLogin() {
        try {
            JSONObject userInfo = TokenUtil.loadUserInfo();
            if (userInfo != null) {
                JOptionPane.showMessageDialog(this, "자동 로그인 성공!");
                new SubFrame().setVisible(true);
                this.dispose(); // 메인 프레임 닫기
            }
        } catch (IOException e) {
            System.err.println("자동 로그인 실패: " + e.getMessage());
        }
    }
    
    public void generateCaptcha() {
        captcha = new Captcha.Builder(200, 50)
                .addText() // 기본 텍스트 생성
                .addBackground(new GradiatedBackgroundProducer()) // 배경 추가
                .gimp() // CAPTCHA 왜곡 효과 추가
                .addNoise() // 노이즈 추가
                .addBorder() // 테두리 추가
                .build();

        // CAPTCHA 이미지를 lblCaptcha에 표시
        lblCaptcha.setIcon(new ImageIcon(captcha.getImage()));
    }

    public boolean validateCaptcha() {
        String userInput = txtCaptchaInput.getText().trim();
        return captcha.isCorrect(userInput);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        btnDuplicateCheck = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        lblCaptcha = new javax.swing.JLabel();
        txtCaptchaInput = new javax.swing.JTextField();
        btnRefreshCaptcha = new javax.swing.JButton();

        jLabel4.setText("회원가입");

        jLabel5.setText("아이디");

        jLabel6.setText("비밀번호");

        jLabel7.setText("비밀번호 확인");

        jLabel8.setText("닉네임");

        btnDuplicateCheck.setText("중복확인");
        btnDuplicateCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuplicateCheckActionPerformed(evt);
            }
        });

        btnSignUp.setText("회원가입");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        jLabel9.setText("전화번호");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(180, 180, 180))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jPasswordField2)
                            .addComponent(jPasswordField3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDuplicateCheck))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnSignUp)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDuplicateCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnSignUp)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("레시피 공유 프로그램");

        btnLogin.setText("로그인");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jButton2.setText("회원가입");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("아이디");

        jLabel3.setText("비밀번호");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("사용자");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("관리자");

        btnRefreshCaptcha.setText("새로고침");
        btnRefreshCaptcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCaptchaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCaptchaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefreshCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaptchaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshCaptcha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnLogin))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (!validateCaptcha()) {
            JOptionPane.showMessageDialog(null, "캡챠 문자 재입력 바랍니다.");
            return;
        }

        try {
            // 사용자 입력값 가져오기
            String account = jTextField1.getText().trim();
            char[] passwordChars = jPasswordField1.getPassword();
            String password = new String(passwordChars);
            Arrays.fill(passwordChars, '\0'); // 비밀번호 보안을 위해 초기화

            // JSON 요청 바디 생성
            String requestBody = "{"
                    + "\"account\":\"" + account + "\","
                    + "\"password\":\"" + password + "\""
                    + "}";

            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/userLogin"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // 요청 보내기 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // 응답 데이터 처리
            if (responseBody.trim().startsWith("{")) {
                // 성공: JSON 객체로 처리
                JSONObject jsonResponse = new JSONObject(responseBody);

                // 성공 처리
                int id = jsonResponse.getInt("id");
                String name = jsonResponse.getString("name");
                String accessToken = jsonResponse.getString("access_token");

                // 사용자 정보 저장
                TokenUtil.saveUserInfo(accessToken, name, id);

                JOptionPane.showMessageDialog(this, "로그인 성공!");

                // SubFrame으로 사용자 정보 전달
                new SubFrame().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "로그인 실패: 서버 응답이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "로그인 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jDialog1.setSize(400, 350);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRefreshCaptchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCaptchaActionPerformed
        generateCaptcha();
    }//GEN-LAST:event_btnRefreshCaptchaActionPerformed

    private void btnDuplicateCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuplicateCheckActionPerformed
        
    }//GEN-LAST:event_btnDuplicateCheckActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        char[] passwordChars = jPasswordField2.getPassword();
        char[] passwordCheckChars = jPasswordField3.getPassword();
        String password = new String(passwordChars);
        String passwordCheck = new String(passwordCheckChars);
        Arrays.fill(passwordChars, '\0'); // 비밀번호 보안을 위해 초기화
        String account = jTextField3.getText();
        String name = jTextField2.getText();
        String number = jTextField4.getText();
        try {
            if(password.equals(passwordCheck)) {
                String reqeustBody = "{"
                        + "\"account\":\"" + account + "\","
                        + "\"password\":\"" + password + "\","
                        + "\"name\":\"" + name + "\","
                        + "\"number\":\"" + number + "\""
                        + "}";
                
                // HttpClient 생성
                HttpClient client = HttpClient.newHttpClient();

                // HttpRequest 생성
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/userRegister"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(reqeustBody))
                    .build();

                // 요청 보내기 및 응답 받기
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                System.out.println("response : " + responseBody);
                
                // 응답 데이터 처리
                if (responseBody.trim().startsWith("{")) {
                    // 성공: JSON 객체로 처리
                    JSONObject jsonResponse = new JSONObject(responseBody);
                    JOptionPane.showMessageDialog(null, "회원가입 완료");
                    // 화면 전환
                    jDialog1.dispose();
                } else if (responseBody.trim().startsWith("[")) {
                    // 실패: JSON 배열로 처리
                    JSONArray jsonArray = new JSONArray(responseBody);
                    JSONObject jsonResponse = jsonArray.getJSONObject(0); // 첫 번째 객체 추출

                    String errorMessage = jsonResponse.getString("result");
                    JOptionPane.showMessageDialog(null, "회원가입 실패 : 이미 존재하는 아이디입니다.");
                } else {
                    // 예기치 않은 응답 처리
                    JOptionPane.showMessageDialog(null, "서버 응답이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                }
//                jDialog1.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. 동일하게 입력해주세요.");
                jPasswordField2.setText("");
                jPasswordField3.setText("");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDuplicateCheck;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRefreshCaptcha;
    private javax.swing.JButton btnSignUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblCaptcha;
    private javax.swing.JTextField txtCaptchaInput;
    // End of variables declaration//GEN-END:variables
}
