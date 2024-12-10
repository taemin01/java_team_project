
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
        jDialogRegister = new javax.swing.JDialog();
        lblRegister = new javax.swing.JLabel();
        lblRegisterId = new javax.swing.JLabel();
        lblRegisterPass = new javax.swing.JLabel();
        lblRegisterPassConf = new javax.swing.JLabel();
        lblRegisterName = new javax.swing.JLabel();
        txtRegisterId = new javax.swing.JTextField();
        pwRegisterPass = new javax.swing.JPasswordField();
        pwRegisterPassConf = new javax.swing.JPasswordField();
        txtRegisterName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        lblRegisterPhone = new javax.swing.JLabel();
        txtRegisterPhone = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        lblLoginId = new javax.swing.JLabel();
        lblLoginPass = new javax.swing.JLabel();
        rbtnUser = new javax.swing.JRadioButton();
        rbtnAdmin = new javax.swing.JRadioButton();
        txtLoginId = new javax.swing.JTextField();
        pwLoginPass = new javax.swing.JPasswordField();
        lblCaptcha = new javax.swing.JLabel();
        txtCaptchaInput = new javax.swing.JTextField();
        btnRefreshCaptcha = new javax.swing.JButton();

        lblRegister.setText("회원가입");

        lblRegisterId.setText("아이디");

        lblRegisterPass.setText("비밀번호");

        lblRegisterPassConf.setText("비밀번호 확인");

        lblRegisterName.setText("닉네임");

        btnCreate.setText("회원가입");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblRegisterPhone.setText("전화번호");

        javax.swing.GroupLayout jDialogRegisterLayout = new javax.swing.GroupLayout(jDialogRegister.getContentPane());
        jDialogRegister.getContentPane().setLayout(jDialogRegisterLayout);
        jDialogRegisterLayout.setHorizontalGroup(
            jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogRegisterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegister)
                .addGap(180, 180, 180))
            .addGroup(jDialogRegisterLayout.createSequentialGroup()
                .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRegisterLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegisterPassConf)
                            .addComponent(lblRegisterId)
                            .addComponent(lblRegisterPass)
                            .addComponent(lblRegisterName)
                            .addComponent(lblRegisterPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRegisterId)
                            .addComponent(pwRegisterPass)
                            .addComponent(pwRegisterPassConf)
                            .addComponent(txtRegisterName, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtRegisterPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                    .addGroup(jDialogRegisterLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnCreate)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jDialogRegisterLayout.setVerticalGroup(
            jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRegisterLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblRegister)
                .addGap(29, 29, 29)
                .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegisterId)
                    .addComponent(txtRegisterId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegisterPass)
                    .addComponent(pwRegisterPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegisterPassConf)
                    .addComponent(pwRegisterPassConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegisterName)
                    .addComponent(txtRegisterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegisterPhone)
                    .addComponent(txtRegisterPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnCreate)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setText("레시피 공유 프로그램");

        btnLogin.setText("로그인");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegister.setText("회원가입");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblLoginId.setText("아이디");

        lblLoginPass.setText("비밀번호");

        buttonGroup1.add(rbtnUser);
        rbtnUser.setSelected(true);
        rbtnUser.setText("사용자");

        buttonGroup1.add(rbtnAdmin);
        rbtnAdmin.setText("관리자");

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
                        .addComponent(lblLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLoginPass)
                            .addComponent(lblLoginId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pwLoginPass, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtLoginId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegister))))
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
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoginId)
                    .addComponent(txtLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoginPass)
                    .addComponent(pwLoginPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnUser)
                    .addComponent(rbtnAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaptchaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshCaptcha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnLogin))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //로그인 코드
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (!validateCaptcha()) {
            JOptionPane.showMessageDialog(null, "캡챠 문자 재입력 바랍니다.");
            return;
        }

        try {
            // 사용자 입력값 가져오기
            String account = txtLoginId.getText().trim();
            char[] passwordChars = pwLoginPass.getPassword();
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
                String number = jsonResponse.getString("number");
                String accessToken = jsonResponse.getString("access_token");

                // 사용자 정보 저장
                TokenUtil.saveUserInfo(accessToken, name, id, number);

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
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        jDialogRegister.setSize(400, 350);
        jDialogRegister.setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRefreshCaptchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCaptchaActionPerformed
        generateCaptcha();
    }//GEN-LAST:event_btnRefreshCaptchaActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        char[] passwordChars = pwRegisterPass.getPassword();
        char[] passwordCheckChars = pwRegisterPassConf.getPassword();
        String password = new String(passwordChars);
        String passwordCheck = new String(passwordCheckChars);
        Arrays.fill(passwordChars, '\0'); // 비밀번호 보안을 위해 초기화
        String account = txtRegisterId.getText();
        String name = txtRegisterName.getText();
        String number = txtRegisterPhone.getText();
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
                    jDialogRegister.dispose();
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
                pwRegisterPass.setText("");
                pwRegisterPassConf.setText("");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRefreshCaptcha;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog jDialogRegister;
    private javax.swing.JLabel lblCaptcha;
    private javax.swing.JLabel lblLoginId;
    private javax.swing.JLabel lblLoginPass;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblRegisterId;
    private javax.swing.JLabel lblRegisterName;
    private javax.swing.JLabel lblRegisterPass;
    private javax.swing.JLabel lblRegisterPassConf;
    private javax.swing.JLabel lblRegisterPhone;
    private javax.swing.JPasswordField pwLoginPass;
    private javax.swing.JPasswordField pwRegisterPass;
    private javax.swing.JPasswordField pwRegisterPassConf;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JRadioButton rbtnUser;
    private javax.swing.JTextField txtCaptchaInput;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JTextField txtRegisterId;
    private javax.swing.JTextField txtRegisterName;
    private javax.swing.JTextField txtRegisterPhone;
    // End of variables declaration//GEN-END:variables
}
