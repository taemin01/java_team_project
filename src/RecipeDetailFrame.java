
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import org.json.JSONArray;
import org.json.JSONObject;
import util.TokenUtil;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author antaemin
 */
public class RecipeDetailFrame extends javax.swing.JFrame {
    private JSONObject recipeDataInfo; // 전달받은 데이터를 저장할 변수(작성자, 평점, 레시피 id등) 사용할 데이터는 레시피id와 작성자 이름(id, name)
    private int reviewCurrentPage = 1; // 리뷰 현재 페이지
    private int commentCurrentPage = 1; // 댓글 현재 페이지
    private JSONArray comments; // 댓글 데이터를 저장할 변수
    private JSONArray review; // 댓글 데이터를 저장할 변수
    private final int itemsPerPage = 3; // 한 페이지당 항목 수
    private int selectedCommentId;

    /**
     * Creates new form RecipeDetailFrame
     */
    public RecipeDetailFrame(JSONObject recipeData) {
        this.recipeDataInfo = recipeData;
        initComponents();
        fetchAndDisplayRecipeDetails(); // 레시피 상세 정보를 화면에 표시
    }
    
    private void fetchAndDisplayRecipeDetails() {
        try {
            // 요청을 보낼 URL 구성 (파라미터에 recipeId 추가) recipeData에서 id값 추출해서 파라미터로 전송
            
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/getUserRecipeDetail/?recipe_id=" 
                    + recipeDataInfo.getInt("id");

            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json") // Content-Type만 설정
                    .GET()
                    .build();

            // HttpRequest 전송 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response : " + response);

            // 응답 처리
            if (response.statusCode() == 200) {
                // JSON 파싱
                JSONObject responseData = new JSONObject(response.body());
                if (responseData.getString("result").equals("success")) {
                    JSONObject items = responseData.getJSONObject("items");
                    System.out.println("items all data : " + items.toString());
                    displayRecipeDetails(items); // 레시피 상세 정보 화면에 표시
                    displayCookingSteps(items.getJSONArray("details")); // 조리 순서 표시
                    System.out.println(" : " + items.getJSONArray("comment"));
                    System.out.println(" : " + items.getJSONArray("review"));
                    review = items.getJSONArray("review");
                    displayReview(review);
                    comments = items.getJSONArray("comment");
                    displayComment(comments);
                    
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "데이터 요청 실패: " + responseData.getString("result"), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "HTTP 요청 실패: " + response.statusCode(), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "요청 처리 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void displayReview(JSONArray reviews) {
        try {
            int start = (reviewCurrentPage - 1) * itemsPerPage; // 시작 인덱스
            int end = Math.min(start + itemsPerPage, reviews.length()); // 끝 인덱스

            // 데이터가 없으면 패널 숨기기
            if (start >= reviews.length()) {
                jPanel1.setVisible(false);
                jPanel2.setVisible(false);
                jPanel3.setVisible(false);
                return;
            }

            // 정적 패널에 데이터 매핑
            for (int i = start; i < end; i++) {
                JSONObject review = reviews.getJSONObject(i);
                String reviewer = review.getString("name");
                int star = review.getInt("star");
                String comment = review.getString("comment");
                String createdAt = review.getString("createdAt");
                
                boolean isCurrentUser = reviewer.equals(TokenUtil.loadUserInfo().getString("userName"));
                
                if(star > 5) {
                    star /= 2;
                }

                if (i % 3 == 0) { // 첫 번째 패널
                    lblReviewWriter1.setText("작성자: " + reviewer);
                    lblReviewGrade1.setText("점수: " + star);
                    jTextAreaReview1.setText(comment);
                    jTextAreaReview1.setEditable(false);
                    lblReviewCreate1.setText(createdAt);
                    btnReviewUpdForm1.setVisible(isCurrentUser);
                    btnReviewDelForm1.setVisible(isCurrentUser);
                    
                } else if (i % 3 == 1) { // 두 번째 패널
                    lblReviewWriter2.setText("작성자: " + reviewer);
                    lblReviewGrade2.setText("점수: " + star);
                    jTextAreaReview2.setText(comment);
                    jTextAreaReview2.setEditable(false);
                    lblReviewCreate2.setText(createdAt);
                    btnReviewUpdForm2.setVisible(isCurrentUser);
                    btnReviewDelForm2.setVisible(isCurrentUser);
                } else if (i % 3 == 2) { // 세 번째 패널
                    lblReviewWriter3.setText("작성자: " + reviewer);
                    lblReviewGrade3.setText("점수: " + star);
                    jTextAreaReview3.setText(comment);
                    jTextAreaReview3.setEditable(false);
                    lblReviewCreate3.setText(createdAt);
                    btnReviewUpdForm3.setVisible(isCurrentUser);
                    btnReviewDelForm3.setVisible(isCurrentUser);
                }
            }

            // 데이터가 없는 패널 숨기기
            if ((end - start) % 3 == 1) {
                jPanel2.setVisible(false);
                jPanel3.setVisible(false);
            } else if ((end - start) % 3 == 2) {
                jPanel3.setVisible(false);
            }

            // 현재 페이지 표시
            lblReviewCurrentPage.setText(String.valueOf(reviewCurrentPage));

            // 이전/다음 버튼 활성화 설정
//            btnReviewPrePage.setEnabled(reviewCurrentPage > 1);
//            btnReviewNextPage.setEnabled(reviewCurrentPage * itemsPerPage < reviews.length());

        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "리뷰 데이터를 표시 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    private void displayComment(JSONArray comments) {
    try {
        int start = (commentCurrentPage - 1) * itemsPerPage; // 시작 인덱스
        int end = Math.min(start + itemsPerPage, comments.length()); // 끝 인덱스

        // 데이터가 없으면 패널 숨기기
        if (start >= comments.length()) {
            jPanel4.setVisible(false);
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);
            return;
        }

        // 정적 패널에 데이터 매핑
        for (int i = start; i < end; i++) {
            JSONObject comment = comments.getJSONObject(i);
            String commenter = comment.getString("name");
            String content = comment.getString("comment");
            String createdAt = comment.getString("createdAt");
            
            // 작성자인지 확인
        boolean isCurrentUser = commenter.equals(TokenUtil.loadUserInfo().getString("userName"));

            if (i % 3 == 0) { // 첫 번째 패널
                lblCommWriter1.setText("작성자: " + commenter);
                lblCommCreate1.setText(createdAt);
                jTextAreaComm1.setText(content);
                jTextAreaComm1.setEditable(false);
                jPanel4.setVisible(true);
                btnCommUpdForm1.setVisible(isCurrentUser);
                btnCommDelForm1.setVisible(isCurrentUser);
            } else if (i % 3 == 1) { // 두 번째 패널
                lblCommWriter4.setText("작성자: " + commenter);
                lblCommCreate4.setText(createdAt);
                jTextAreaComm4.setText(content);
                jTextAreaComm4.setEditable(false);
                jPanel5.setVisible(true);
                btnCommUpdForm2.setVisible(isCurrentUser);
                btnCommDelForm2.setVisible(isCurrentUser);
            } else if (i % 3 == 2) { // 세 번째 패널
                lblCommWriter5.setText("작성자: " + commenter);
                lblCommCreate5.setText(createdAt);
                jTextAreaComm5.setText(content);
                jTextAreaComm5.setEditable(false);
                
                jPanel6.setVisible(true);
                btnCommUpdForm3.setVisible(isCurrentUser);
                btnCommDelForm3.setVisible(isCurrentUser);
            }
        }

        // 데이터가 없는 패널 숨기기
        if ((end - start) % 3 == 1) {
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);
        } else if ((end - start) % 3 == 2) {
            jPanel6.setVisible(false);
        }

        // 현재 페이지 표시
        lblCommCurrentPage.setText(String.valueOf(commentCurrentPage));

        // 이전/다음 버튼 활성화 설정
//        btnCommPrePage.setEnabled(commentCurrentPage > 1);
//        btnCommNextPage.setEnabled(commentCurrentPage * itemsPerPage < comments.length());
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "댓글 데이터를 표시 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}


    
    // 화면에 레시피 상세 정보 표시
    private void displayRecipeDetails(JSONObject recipeData) {
    try {
        // 데이터 추출
        String title = recipeData.getString("title");
        String description = recipeData.getString("description");
        String name = recipeDataInfo.getString("name");
        String ingredient = recipeDataInfo.getString("ingredient");

        // UI 컴포넌트에 설정
        lblTitle.setText("제목: " + title);
        jTextAreaContent.setText(description);
        jTextAreaContent.setEditable(false);
        lblWriter.setText("작성자: " + name);
        jTextAreaNecess.setText(ingredient);
        jTextAreaNecess.setEditable(false);
        lblReviewWriterWrite.setText(TokenUtil.loadUserInfo().getString("userName"));
        lblCommWriterWrite.setText(TokenUtil.loadUserInfo().getString("userName"));
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "레시피 데이터를 표시 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

// 화면에 조리 순서 표시
private void displayCookingSteps(JSONArray detailsArray) {
    try {
        jPanelDetails.setLayout(new BoxLayout(jPanelDetails, BoxLayout.Y_AXIS)); // 세로 배치
        jPanelDetails.removeAll(); // 기존 패널 내용 삭제        

        for (int i = 0; i < detailsArray.length(); i++) {
            JSONObject step = detailsArray.getJSONObject(i);
            String detail = step.getString("detail"); // 조리 순서 설명
            String imgUrl = step.optString("img", null); // 이미지 URL, 없을 경우 null 반환

            // 개별 조리 순서 패널 생성
            JPanel stepPanel = new JPanel();
            stepPanel.setName("stepPanel_" + i); // 고유한 이름 설정
            stepPanel.setLayout(new BorderLayout());
            stepPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // 설명 텍스트 추가
            JTextArea textAreaDetail = new JTextArea(detail);
            textAreaDetail.setName("textAreaDetail_" + i); // 고유 이름 설정
            textAreaDetail.setLineWrap(true);
            textAreaDetail.setWrapStyleWord(true);
            textAreaDetail.setEditable(false);
            textAreaDetail.setBackground(jPanelDetails.getBackground()); // 배경색 일치
            stepPanel.add(textAreaDetail, BorderLayout.CENTER); // 설명을 가운데에 배치

            // 이미지 추가
            JLabel imageLabel = new JLabel(); // 새로 생성
            imageLabel.setName("imageLabel_" + i); // 고유 이름 설정
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            if (imgUrl != null && !imgUrl.isEmpty()) {
                try {
                    ImageIcon icon = new ImageIcon(new URL(imgUrl));
                    Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 이미지 크기 조정
                    imageLabel.setIcon(new ImageIcon(scaledImage));
                    System.out.println("이미지 로드 성공: " + imgUrl);
                } catch (Exception e) {
                    imageLabel.setText("이미지 로드 실패");
                    System.err.println("이미지 로드 실패: " + imgUrl);
                }
            } else {
                imageLabel.setText("이미지 없음"); // 이미지가 없는 경우 텍스트 표시
            }
            stepPanel.add(imageLabel, BorderLayout.EAST); // 이미지를 오른쪽에 배치

            // 조리 순서 패널을 메인 패널에 추가
            jPanelDetails.add(stepPanel);
            System.out.println("패널 추가: " + stepPanel.getName() + " - 이미지 URL: " + imgUrl);

            // **여기서 강제 UI 갱신**
            jPanelDetails.revalidate();
            jPanelDetails.repaint();
        }

        // 전체 UI 갱신
        jPanelDetails.revalidate();
        jPanelDetails.repaint();
        System.out.println("UI 갱신 완료");
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "조리 순서를 표시 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
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

        jDialogReviewUpd = new javax.swing.JDialog();
        btnUpdReview = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaUpdateReview = new javax.swing.JTextArea();
        comboUpdGrade = new javax.swing.JComboBox<>();
        lblUpdGrade = new javax.swing.JLabel();
        lblUpdReview = new javax.swing.JLabel();
        jDialogReviewDel = new javax.swing.JDialog();
        lblDelReview = new javax.swing.JLabel();
        lblDelReviewConfirm = new javax.swing.JLabel();
        btnDelReviewYes = new javax.swing.JButton();
        btnDelReviewNo = new javax.swing.JButton();
        jDialogCommUpd = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaUpdComm = new javax.swing.JTextArea();
        btnDelComm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDialogCommDel = new javax.swing.JDialog();
        lblDelCommConfirm = new javax.swing.JLabel();
        btnDelCommYes = new javax.swing.JButton();
        btnDelCommNo = new javax.swing.JButton();
        lblDelComm = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        comboSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanelBody = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanelImg = new javax.swing.JPanel();
        lblCreate = new javax.swing.JLabel();
        lblWriter = new javax.swing.JLabel();
        jScrollPaneNecess = new javax.swing.JScrollPane();
        jTextAreaNecess = new javax.swing.JTextArea();
        lblOrder = new javax.swing.JLabel();
        lblNecess = new javax.swing.JLabel();
        jScrollPaneContent = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanelDetails = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblImage = new javax.swing.JLabel();
        ReviewAndComment = new javax.swing.JTabbedPane();
        jPanelReview = new javax.swing.JPanel();
        lblReviewCurrentPage = new javax.swing.JLabel();
        btnReviewPrePage = new javax.swing.JButton();
        btnReviewNextPage = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblReviewWriter1 = new javax.swing.JLabel();
        lblReviewGrade1 = new javax.swing.JLabel();
        jScrollPaneReview1 = new javax.swing.JScrollPane();
        jTextAreaReview1 = new javax.swing.JTextArea();
        lblReviewCreate1 = new javax.swing.JLabel();
        btnReviewUpdForm1 = new javax.swing.JButton();
        btnReviewDelForm1 = new javax.swing.JButton();
        writeReviewPanel = new javax.swing.JPanel();
        lblReviewWriterWrite = new javax.swing.JLabel();
        lblReviewGradeWrite = new javax.swing.JLabel();
        comboReviewGradeWrtie = new javax.swing.JComboBox<>();
        jScrollPaneReviewWrite = new javax.swing.JScrollPane();
        jTextArea15 = new javax.swing.JTextArea();
        btnReviewWrite = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblReviewWriter2 = new javax.swing.JLabel();
        lblReviewGrade2 = new javax.swing.JLabel();
        jScrollPaneReview2 = new javax.swing.JScrollPane();
        jTextAreaReview2 = new javax.swing.JTextArea();
        lblReviewCreate2 = new javax.swing.JLabel();
        btnReviewUpdForm2 = new javax.swing.JButton();
        btnReviewDelForm2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblReviewWriter3 = new javax.swing.JLabel();
        lblReviewGrade3 = new javax.swing.JLabel();
        jScrollPaneReview3 = new javax.swing.JScrollPane();
        jTextAreaReview3 = new javax.swing.JTextArea();
        lblReviewCreate3 = new javax.swing.JLabel();
        btnReviewUpdForm3 = new javax.swing.JButton();
        btnReviewDelForm3 = new javax.swing.JButton();
        jPanelComment = new javax.swing.JPanel();
        lblCommCurrentPage = new javax.swing.JLabel();
        btnCommNextPage = new javax.swing.JButton();
        btnCommPrePage = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblCommWriter1 = new javax.swing.JLabel();
        jScrollPaneComm1 = new javax.swing.JScrollPane();
        jTextAreaComm1 = new javax.swing.JTextArea();
        lblCommCreate1 = new javax.swing.JLabel();
        btnCommUpdForm1 = new javax.swing.JButton();
        btnCommDelForm1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblCommWriter4 = new javax.swing.JLabel();
        jScrollPaneComm4 = new javax.swing.JScrollPane();
        jTextAreaComm4 = new javax.swing.JTextArea();
        lblCommCreate4 = new javax.swing.JLabel();
        btnCommUpdForm2 = new javax.swing.JButton();
        btnCommDelForm2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblCommWriter5 = new javax.swing.JLabel();
        jScrollPaneComm5 = new javax.swing.JScrollPane();
        jTextAreaComm5 = new javax.swing.JTextArea();
        lblCommCreate5 = new javax.swing.JLabel();
        btnCommUpdForm3 = new javax.swing.JButton();
        btnCommDelForm3 = new javax.swing.JButton();
        writeCommnetPanel = new javax.swing.JPanel();
        lblCommWriterWrite = new javax.swing.JLabel();
        jScrollPaneCommWrite = new javax.swing.JScrollPane();
        jTextAreaCommWrite = new javax.swing.JTextArea();
        btnCommWrite = new javax.swing.JButton();

        btnUpdReview.setText("수정하기");
        btnUpdReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdReviewActionPerformed(evt);
            }
        });

        jTextAreaUpdateReview.setColumns(20);
        jTextAreaUpdateReview.setRows(5);
        jScrollPane1.setViewportView(jTextAreaUpdateReview);

        comboUpdGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "4", "3", "2", "1" }));

        lblUpdGrade.setText("점수");

        lblUpdReview.setText("리뷰 수정하기");

        javax.swing.GroupLayout jDialogReviewUpdLayout = new javax.swing.GroupLayout(jDialogReviewUpd.getContentPane());
        jDialogReviewUpd.getContentPane().setLayout(jDialogReviewUpdLayout);
        jDialogReviewUpdLayout.setHorizontalGroup(
            jDialogReviewUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogReviewUpdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogReviewUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogReviewUpdLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdReview))
                    .addGroup(jDialogReviewUpdLayout.createSequentialGroup()
                        .addComponent(lblUpdGrade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboUpdGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jDialogReviewUpdLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(lblUpdReview)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jDialogReviewUpdLayout.setVerticalGroup(
            jDialogReviewUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogReviewUpdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUpdReview)
                .addGap(18, 18, 18)
                .addGroup(jDialogReviewUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboUpdGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUpdGrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdReview)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        lblDelReview.setText("리뷰 삭제하기");

        lblDelReviewConfirm.setText("삭제하시겠습니까?");

        btnDelReviewYes.setText("예");
        btnDelReviewYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelReviewYesActionPerformed(evt);
            }
        });

        btnDelReviewNo.setText("아니오");
        btnDelReviewNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelReviewNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogReviewDelLayout = new javax.swing.GroupLayout(jDialogReviewDel.getContentPane());
        jDialogReviewDel.getContentPane().setLayout(jDialogReviewDelLayout);
        jDialogReviewDelLayout.setHorizontalGroup(
            jDialogReviewDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogReviewDelLayout.createSequentialGroup()
                .addGroup(jDialogReviewDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogReviewDelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(lblDelReview))
                    .addGroup(jDialogReviewDelLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblDelReviewConfirm))
                    .addGroup(jDialogReviewDelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnDelReviewYes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelReviewNo)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jDialogReviewDelLayout.setVerticalGroup(
            jDialogReviewDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogReviewDelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDelReview)
                .addGap(51, 51, 51)
                .addComponent(lblDelReviewConfirm)
                .addGap(54, 54, 54)
                .addGroup(jDialogReviewDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelReviewNo)
                    .addComponent(btnDelReviewYes))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTextAreaUpdComm.setColumns(20);
        jTextAreaUpdComm.setRows(5);
        jScrollPane2.setViewportView(jTextAreaUpdComm);

        btnDelComm.setText("수정하기");
        btnDelComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCommActionPerformed(evt);
            }
        });

        jLabel1.setText("댓글 수정하기");

        javax.swing.GroupLayout jDialogCommUpdLayout = new javax.swing.GroupLayout(jDialogCommUpd.getContentPane());
        jDialogCommUpd.getContentPane().setLayout(jDialogCommUpdLayout);
        jDialogCommUpdLayout.setHorizontalGroup(
            jDialogCommUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCommUpdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogCommUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCommUpdLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelComm)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCommUpdLayout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(246, 246, 246))
        );
        jDialogCommUpdLayout.setVerticalGroup(
            jDialogCommUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCommUpdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnDelComm)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        lblDelCommConfirm.setText("삭제하시겠습니까?");

        btnDelCommYes.setText("예");
        btnDelCommYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCommYesActionPerformed(evt);
            }
        });

        btnDelCommNo.setText("아니오");
        btnDelCommNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCommNoActionPerformed(evt);
            }
        });

        lblDelComm.setText("댓글 삭제하기");

        javax.swing.GroupLayout jDialogCommDelLayout = new javax.swing.GroupLayout(jDialogCommDel.getContentPane());
        jDialogCommDel.getContentPane().setLayout(jDialogCommDelLayout);
        jDialogCommDelLayout.setHorizontalGroup(
            jDialogCommDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCommDelLayout.createSequentialGroup()
                .addGroup(jDialogCommDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogCommDelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(lblDelComm))
                    .addGroup(jDialogCommDelLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblDelCommConfirm))
                    .addGroup(jDialogCommDelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnDelCommYes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelCommNo)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jDialogCommDelLayout.setVerticalGroup(
            jDialogCommDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCommDelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDelComm)
                .addGap(51, 51, 51)
                .addComponent(lblDelCommConfirm)
                .addGap(54, 54, 54)
                .addGroup(jDialogCommDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelCommNo)
                    .addComponent(btnDelCommYes))
                .addContainerGap(48, Short.MAX_VALUE))
        );

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
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
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

        jPanelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelImgLayout = new javax.swing.GroupLayout(jPanelImg);
        jPanelImg.setLayout(jPanelImgLayout);
        jPanelImgLayout.setHorizontalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
        jPanelImgLayout.setVerticalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        lblCreate.setText("작성일자 : 2025.01.01");

        lblWriter.setText("작성자 : 홍길동");

        jTextAreaNecess.setColumns(20);
        jTextAreaNecess.setRows(5);
        jScrollPaneNecess.setViewportView(jTextAreaNecess);

        lblOrder.setText("조리 순서");

        lblNecess.setText("필요한 재료");

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jTextAreaContent.setText("내용");
        jScrollPaneContent.setViewportView(jTextAreaContent);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        lblImage.setText("jLabel2");

        javax.swing.GroupLayout jPanelDetailsLayout = new javax.swing.GroupLayout(jPanelDetails);
        jPanelDetails.setLayout(jPanelDetailsLayout);
        jPanelDetailsLayout.setHorizontalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );
        jPanelDetailsLayout.setVerticalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanelDetails);

        lblReviewCurrentPage.setText("1");

        btnReviewPrePage.setText("<");
        btnReviewPrePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewPrePageActionPerformed(evt);
            }
        });

        btnReviewNextPage.setText(">");
        btnReviewNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewNextPageActionPerformed(evt);
            }
        });

        lblReviewWriter1.setText("작성자 : 홍길동");

        lblReviewGrade1.setText("점수 : 5");

        jTextAreaReview1.setColumns(20);
        jTextAreaReview1.setRows(5);
        jScrollPaneReview1.setViewportView(jTextAreaReview1);

        lblReviewCreate1.setText("2025.01.01");

        btnReviewUpdForm1.setText("수정");
        btnReviewUpdForm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewUpdForm1ActionPerformed(evt);
            }
        });

        btnReviewDelForm1.setText("삭제");
        btnReviewDelForm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewDelForm1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblReviewWriter1)
                        .addGap(18, 18, 18)
                        .addComponent(lblReviewGrade1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReviewCreate1))
                    .addComponent(jScrollPaneReview1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReviewUpdForm1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReviewDelForm1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReviewWriter1)
                    .addComponent(lblReviewCreate1)
                    .addComponent(lblReviewGrade1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneReview1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReviewUpdForm1)
                    .addComponent(btnReviewDelForm1)))
        );

        lblReviewWriterWrite.setText("작성자 : 홍길동");

        lblReviewGradeWrite.setText("점수 :");

        comboReviewGradeWrtie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "4", "3", "2", "1" }));

        jTextArea15.setColumns(20);
        jTextArea15.setRows(5);
        jScrollPaneReviewWrite.setViewportView(jTextArea15);

        btnReviewWrite.setText("작성하기");
        btnReviewWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewWriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout writeReviewPanelLayout = new javax.swing.GroupLayout(writeReviewPanel);
        writeReviewPanel.setLayout(writeReviewPanelLayout);
        writeReviewPanelLayout.setHorizontalGroup(
            writeReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeReviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(writeReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneReviewWrite)
                    .addGroup(writeReviewPanelLayout.createSequentialGroup()
                        .addComponent(lblReviewWriterWrite)
                        .addGap(18, 18, 18)
                        .addComponent(lblReviewGradeWrite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboReviewGradeWrtie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, writeReviewPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReviewWrite)))
                .addContainerGap())
        );
        writeReviewPanelLayout.setVerticalGroup(
            writeReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeReviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(writeReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboReviewGradeWrtie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReviewWriterWrite)
                    .addComponent(lblReviewGradeWrite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneReviewWrite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReviewWrite)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblReviewWriter2.setText("작성자 : 홍길동");

        lblReviewGrade2.setText("점수 : 5");

        jTextAreaReview2.setColumns(20);
        jTextAreaReview2.setRows(5);
        jScrollPaneReview2.setViewportView(jTextAreaReview2);

        lblReviewCreate2.setText("2025.01.01");

        btnReviewUpdForm2.setText("수정");
        btnReviewUpdForm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewUpdForm2ActionPerformed(evt);
            }
        });

        btnReviewDelForm2.setText("삭제");
        btnReviewDelForm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewDelForm2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblReviewWriter2)
                        .addGap(18, 18, 18)
                        .addComponent(lblReviewGrade2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReviewCreate2))
                    .addComponent(jScrollPaneReview2, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReviewUpdForm2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReviewDelForm2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReviewWriter2)
                    .addComponent(lblReviewCreate2)
                    .addComponent(lblReviewGrade2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneReview2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReviewUpdForm2)
                    .addComponent(btnReviewDelForm2)))
        );

        lblReviewWriter3.setText("작성자 : 홍길동");

        lblReviewGrade3.setText("점수 : 5");

        jTextAreaReview3.setColumns(20);
        jTextAreaReview3.setRows(5);
        jScrollPaneReview3.setViewportView(jTextAreaReview3);

        lblReviewCreate3.setText("2025.01.01");

        btnReviewUpdForm3.setText("수정");
        btnReviewUpdForm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewUpdForm3ActionPerformed(evt);
            }
        });

        btnReviewDelForm3.setText("삭제");
        btnReviewDelForm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewDelForm3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblReviewWriter3)
                        .addGap(18, 18, 18)
                        .addComponent(lblReviewGrade3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReviewCreate3))
                    .addComponent(jScrollPaneReview3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReviewUpdForm3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReviewDelForm3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReviewWriter3)
                    .addComponent(lblReviewCreate3)
                    .addComponent(lblReviewGrade3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneReview3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReviewUpdForm3)
                    .addComponent(btnReviewDelForm3)))
        );

        javax.swing.GroupLayout jPanelReviewLayout = new javax.swing.GroupLayout(jPanelReview);
        jPanelReview.setLayout(jPanelReviewLayout);
        jPanelReviewLayout.setHorizontalGroup(
            jPanelReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(writeReviewPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelReviewLayout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(btnReviewPrePage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReviewCurrentPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReviewNextPage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelReviewLayout.setVerticalGroup(
            jPanelReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(writeReviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReviewCurrentPage)
                    .addComponent(btnReviewNextPage)
                    .addComponent(btnReviewPrePage))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        ReviewAndComment.addTab("리뷰", jPanelReview);

        lblCommCurrentPage.setText("1");

        btnCommNextPage.setText(">");
        btnCommNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommNextPageActionPerformed(evt);
            }
        });

        btnCommPrePage.setText("<");
        btnCommPrePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommPrePageActionPerformed(evt);
            }
        });

        lblCommWriter1.setText("작성자 : 홍길동");

        jTextAreaComm1.setColumns(20);
        jTextAreaComm1.setRows(5);
        jScrollPaneComm1.setViewportView(jTextAreaComm1);

        lblCommCreate1.setText("2025.01.01");

        btnCommUpdForm1.setText("수정");
        btnCommUpdForm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommUpdForm1ActionPerformed(evt);
            }
        });

        btnCommDelForm1.setText("삭제");
        btnCommDelForm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommDelForm1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneComm1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCommWriter1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCommCreate1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCommUpdForm1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCommDelForm1)))
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommWriter1)
                    .addComponent(lblCommCreate1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneComm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCommUpdForm1)
                    .addComponent(btnCommDelForm1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lblCommWriter4.setText("작성자 : 홍길동");

        jTextAreaComm4.setColumns(20);
        jTextAreaComm4.setRows(5);
        jScrollPaneComm4.setViewportView(jTextAreaComm4);

        lblCommCreate4.setText("2025.01.01");

        btnCommUpdForm2.setText("수정");
        btnCommUpdForm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommUpdForm2ActionPerformed(evt);
            }
        });

        btnCommDelForm2.setText("삭제");
        btnCommDelForm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommDelForm2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneComm4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblCommWriter4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCommCreate4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCommUpdForm2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCommDelForm2)))
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommWriter4)
                    .addComponent(lblCommCreate4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneComm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCommUpdForm2)
                    .addComponent(btnCommDelForm2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lblCommWriter5.setText("작성자 : 홍길동");

        jTextAreaComm5.setColumns(20);
        jTextAreaComm5.setRows(5);
        jScrollPaneComm5.setViewportView(jTextAreaComm5);

        lblCommCreate5.setText("2025.01.01");

        btnCommUpdForm3.setText("수정");
        btnCommUpdForm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommUpdForm3ActionPerformed(evt);
            }
        });

        btnCommDelForm3.setText("삭제");
        btnCommDelForm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommDelForm3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneComm5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblCommWriter5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCommCreate5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCommUpdForm3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCommDelForm3)))
                .addGap(17, 17, 17))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommWriter5)
                    .addComponent(lblCommCreate5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneComm5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCommUpdForm3)
                    .addComponent(btnCommDelForm3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCommWriterWrite.setText("작성자 : 홍길동");

        jTextAreaCommWrite.setColumns(20);
        jTextAreaCommWrite.setRows(5);
        jScrollPaneCommWrite.setViewportView(jTextAreaCommWrite);

        btnCommWrite.setText("작성하기");
        btnCommWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommWriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout writeCommnetPanelLayout = new javax.swing.GroupLayout(writeCommnetPanel);
        writeCommnetPanel.setLayout(writeCommnetPanelLayout);
        writeCommnetPanelLayout.setHorizontalGroup(
            writeCommnetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeCommnetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(writeCommnetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneCommWrite, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                    .addGroup(writeCommnetPanelLayout.createSequentialGroup()
                        .addComponent(lblCommWriterWrite)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, writeCommnetPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCommWrite)))
                .addContainerGap())
        );
        writeCommnetPanelLayout.setVerticalGroup(
            writeCommnetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, writeCommnetPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCommWriterWrite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneCommWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCommWrite)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelCommentLayout = new javax.swing.GroupLayout(jPanelComment);
        jPanelComment.setLayout(jPanelCommentLayout);
        jPanelCommentLayout.setHorizontalGroup(
            jPanelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCommentLayout.createSequentialGroup()
                .addGroup(jPanelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCommentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelCommentLayout.createSequentialGroup()
                                .addGroup(jPanelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCommentLayout.createSequentialGroup()
                                        .addGap(314, 314, 314)
                                        .addComponent(btnCommPrePage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCommCurrentPage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCommNextPage))
                                    .addGroup(jPanelCommentLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(writeCommnetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelCommentLayout.setVerticalGroup(
            jPanelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCommentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(writeCommnetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommCurrentPage)
                    .addComponent(btnCommNextPage)
                    .addComponent(btnCommPrePage))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        ReviewAndComment.addTab("댓글", jPanelComment);

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrder)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addComponent(jPanelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelBodyLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPaneContent, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBodyLayout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblWriter)
                                    .addComponent(lblCreate))
                                .addGap(14, 14, 14))))
                    .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                        .addComponent(lblNecess, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneNecess, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(ReviewAndComment, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelBodyLayout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addGap(41, 41, 41))
                            .addGroup(jPanelBodyLayout.createSequentialGroup()
                                .addComponent(lblCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblWriter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPaneContent, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(lblNecess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneNecess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrder)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReviewAndComment, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jScrollPane3.setViewportView(jPanelBody);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(371, 371, 371))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1469, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnReviewPrePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewPrePageActionPerformed
            if (reviewCurrentPage > 1) {
            reviewCurrentPage--;
            displayReview(review); // reviews는 JSONArray로 전달된 데이터
        }
    }//GEN-LAST:event_btnReviewPrePageActionPerformed

    private void btnCommPrePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommPrePageActionPerformed
        if (commentCurrentPage > 1) {
            commentCurrentPage--;
            displayComment(comments); // comments는 JSONArray로 전달된 데이터
        }
    }//GEN-LAST:event_btnCommPrePageActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        // TODO add your handling code here:
        new MyProfileFrame().setVisible(true);
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void handleCommentUpdate(int commentIndex) {
        try {
            // 해당 댓글의 ID와 내용을 가져오기
            selectedCommentId = comments.getJSONObject(commentIndex).getInt("id");
            System.out.println("수정할 댓글 ID: " + selectedCommentId);

            // 수정 다이얼로그를 띄우기
            jDialogCommUpd.setSize(400, 350);
            jTextAreaUpdComm.setText(comments.getJSONObject(commentIndex).getString("comment")); // 기존 댓글 내용 설정
            jDialogCommUpd.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "댓글 데이터를 가져오는 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
   private void handleCommentDelete(int commentIndex) {
        try {
            // 해당 댓글의 ID와 내용을 가져오기
            selectedCommentId = comments.getJSONObject(commentIndex).getInt("id");
            System.out.println("삭제할 댓글 ID: " + selectedCommentId);

            // 수정 다이얼로그를 띄우기
            jDialogCommDel.setSize(400, 350);
            jDialogCommDel.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "댓글 데이터를 가져오는 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnReviewUpdForm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewUpdForm1ActionPerformed
        // TODO add your handling code here:
        jDialogReviewUpd.setSize(400, 350);
        jDialogReviewUpd.setVisible(true);
    }//GEN-LAST:event_btnReviewUpdForm1ActionPerformed

    private void btnReviewDelForm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewDelForm1ActionPerformed
        // TODO add your handling code here:
        jDialogReviewDel.setSize(400, 350);
        jDialogReviewDel.setVisible(true);
    }//GEN-LAST:event_btnReviewDelForm1ActionPerformed

    private void btnCommUpdForm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommUpdForm1ActionPerformed
        handleCommentUpdate(0); // 첫 번째 댓글 수정 처리
    }//GEN-LAST:event_btnCommUpdForm1ActionPerformed

    private void btnCommDelForm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommDelForm1ActionPerformed
        handleCommentDelete(0);
    }//GEN-LAST:event_btnCommDelForm1ActionPerformed

    private void btnCommUpdForm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommUpdForm2ActionPerformed
        handleCommentUpdate(1); // 첫 번째 댓글 처리
    }//GEN-LAST:event_btnCommUpdForm2ActionPerformed

    private void btnCommDelForm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommDelForm2ActionPerformed
        handleCommentDelete(2);
    }//GEN-LAST:event_btnCommDelForm2ActionPerformed

    private void btnCommUpdForm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommUpdForm3ActionPerformed
        handleCommentUpdate(2); // 첫 번째 댓글 처리
    }//GEN-LAST:event_btnCommUpdForm3ActionPerformed

    private void btnCommDelForm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommDelForm3ActionPerformed
        handleCommentDelete(3);
    }//GEN-LAST:event_btnCommDelForm3ActionPerformed

    private void btnReviewUpdForm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewUpdForm2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReviewUpdForm2ActionPerformed

    private void btnReviewDelForm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewDelForm2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReviewDelForm2ActionPerformed

    private void btnReviewUpdForm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewUpdForm3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReviewUpdForm3ActionPerformed

    private void btnReviewDelForm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewDelForm3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReviewDelForm3ActionPerformed

    private void btnReviewNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewNextPageActionPerformed
        if (reviewCurrentPage * itemsPerPage < review.length()) {
            reviewCurrentPage++;
            displayReview(review);
        }
    }//GEN-LAST:event_btnReviewNextPageActionPerformed

    private void btnCommNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommNextPageActionPerformed
        if (commentCurrentPage * itemsPerPage < comments.length()) {
            commentCurrentPage++;
            displayComment(comments);
        }
    }//GEN-LAST:event_btnCommNextPageActionPerformed

    private void btnReviewWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewWriteActionPerformed
        try {
            // 레시피 ID 가져오기
            int recipeId = recipeDataInfo.getInt("id"); // 레시피 ID는 recipeDataInfo에서 가져옴
            // 선택한 별점 가져오기
            int star = Integer.parseInt(comboReviewGradeWrtie.getSelectedItem().toString());
            // 작성된 리뷰 내용 가져오기
            String comment = jTextArea15.getText();

            // 유효성 검사
            if (comment.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "리뷰 내용을 입력하세요!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            // JSON 데이터 생성
            JSONObject requestBody = new JSONObject();
            requestBody.put("recipe_id", recipeId);
            requestBody.put("star", star);
            requestBody.put("comment", comment);

            // 요청 URL
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/postUserRecipeReview";

            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenUtil.loadUserInfo().getString("token"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            // 요청 전송 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 처리
            if (response.statusCode() == 200) {
                JSONObject responseData = new JSONObject(response.body());
                if (responseData.getString("result").equals("success")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "리뷰가 성공적으로 등록되었습니다!", "성공", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "리뷰 등록 실패: " + responseData.getString("message"), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "HTTP 오류: " + response.statusCode(), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "리뷰 등록 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnReviewWriteActionPerformed

    private void btnCommWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommWriteActionPerformed
        try {
            // 레시피 ID 가져오기
            int recipeId = recipeDataInfo.getInt("id"); // 레시피 ID는 recipeDataInfo에서 가져옴
            // 작성된 댓글 내용 가져오기
            String comment = jTextAreaCommWrite.getText();

            // 유효성 검사
            if (comment.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "댓글 내용을 입력하세요!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            // JSON 데이터 생성
            JSONObject requestBody = new JSONObject();
            requestBody.put("recipe_id", recipeId);
            requestBody.put("comment", comment);

            // 요청 URL
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/postUserRecipeComment";

            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenUtil.loadUserInfo().getString("token"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            // 요청 전송 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 처리
            if (response.statusCode() == 200) {
                JSONObject responseData = new JSONObject(response.body());
                if (responseData.getString("result").equals("success")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "댓글이 성공적으로 등록되었습니다!", "성공", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "댓글 등록 실패: " + responseData.getString("message"), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "HTTP 오류: " + response.statusCode(), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "리뷰 등록 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCommWriteActionPerformed

    //리뷰 수정하기
    private void btnUpdReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdReviewActionPerformed
        try {
            // 레시피 ID 가져오기
            int recipeId = recipeDataInfo.getInt("id"); // 레시피 ID는 recipeDataInfo에서 가져옴
            // 선택한 별점 가져오기
            int star = Integer.parseInt(comboUpdGrade.getSelectedItem().toString());
            // 작성된 리뷰 내용 가져오기
            String comment = lblUpdReview.getText();

            // 유효성 검사
            if (comment.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "리뷰 내용을 입력하세요!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            // JSON 데이터 생성
            JSONObject requestBody = new JSONObject();
            requestBody.put("recipe_id", recipeId);
            requestBody.put("star", star);
            requestBody.put("comment", comment);

            // 요청 URL
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/postUserRecipeReview";

            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenUtil.loadUserInfo().getString("token"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            // 요청 전송 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 처리
            if (response.statusCode() == 200) {
                JSONObject responseData = new JSONObject(response.body());
                if (responseData.getString("result").equals("success")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "리뷰가 성공적으로 등록되었습니다!", "성공", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "리뷰 등록 실패: " + responseData.getString("message"), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "HTTP 오류: " + response.statusCode(), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "리뷰 등록 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdReviewActionPerformed

    private void btnDelReviewNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelReviewNoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDelReviewNoActionPerformed

    private void btnDelReviewYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelReviewYesActionPerformed
        try {
            // 레시피 ID 가져오기
            int recipeId = recipeDataInfo.getInt("id"); // 레시피 ID는 recipeDataInfo에서 가져옴

            // 요청 URL
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/deleteUserRecipeReview/"+recipeId;

            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenUtil.loadUserInfo().getString("token"))
                    .DELETE()
                    .build();

            // 요청 전송 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 처리
            if (response.statusCode() == 200) {
                JSONObject responseData = new JSONObject(response.body());
                if (responseData.getString("result").equals("success")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "리뷰가 성공적으로 삭제되었습니다!", "성공", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                   
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "리뷰 삭제 실패: " + responseData.getString("message"), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "HTTP 오류: " + response.statusCode(), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "리뷰 삭제 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelReviewYesActionPerformed

    //댓글 수정
    private void btnDelCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCommActionPerformed
        try {
            // 작성된 댓글 내용 가져오기
            String comment = jTextAreaUpdComm.getText();
            // 유효성 검사
            if (comment.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "댓글 내용을 입력하세요!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            // JSON 데이터 생성
            JSONObject requestBody = new JSONObject();
            requestBody.put("comment_id", selectedCommentId);
            requestBody.put("comment", comment);

            // 요청 URL
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/putUserRecipeComment";
            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();
            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenUtil.loadUserInfo().getString("token"))
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();
            // 요청 전송 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 처리
            if (response.statusCode() == 200) {
                JSONObject responseData = new JSONObject(response.body());
                if (responseData.getString("result").equals("success")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "댓글이 성공적으로 수정되었습니다!", "성공", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "댓글 수정 실패: " + responseData.getString("message"), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "HTTP 오류: " + response.statusCode(), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "댓글 수정 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelCommActionPerformed

    private void btnDelCommNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCommNoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDelCommNoActionPerformed

    private void btnDelCommYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCommYesActionPerformed
        try {
            // 요청 URL
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/deleteUserRecipeComment/"+selectedCommentId;

            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenUtil.loadUserInfo().getString("token"))
                    .DELETE()
                    .build();

            // 요청 전송 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 처리
            if (response.statusCode() == 200) {
                JSONObject responseData = new JSONObject(response.body());
                if (responseData.getString("result").equals("success")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "댓글이 성공적으로 삭제되었습니다!", "성공", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                   
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "댓글 삭제 실패: " + responseData.getString("message"), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "HTTP 오류: " + response.statusCode(), "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "댓글 삭제 중 오류 발생!", "오류", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelCommYesActionPerformed

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
            java.util.logging.Logger.getLogger(RecipeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecipeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecipeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecipeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new RecipeDetailFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ReviewAndComment;
    private javax.swing.JButton btnCommDelForm1;
    private javax.swing.JButton btnCommDelForm2;
    private javax.swing.JButton btnCommDelForm3;
    private javax.swing.JButton btnCommNextPage;
    private javax.swing.JButton btnCommPrePage;
    private javax.swing.JButton btnCommUpdForm1;
    private javax.swing.JButton btnCommUpdForm2;
    private javax.swing.JButton btnCommUpdForm3;
    private javax.swing.JButton btnCommWrite;
    private javax.swing.JButton btnDelComm;
    private javax.swing.JButton btnDelCommNo;
    private javax.swing.JButton btnDelCommYes;
    private javax.swing.JButton btnDelReviewNo;
    private javax.swing.JButton btnDelReviewYes;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnReviewDelForm1;
    private javax.swing.JButton btnReviewDelForm2;
    private javax.swing.JButton btnReviewDelForm3;
    private javax.swing.JButton btnReviewNextPage;
    private javax.swing.JButton btnReviewPrePage;
    private javax.swing.JButton btnReviewUpdForm1;
    private javax.swing.JButton btnReviewUpdForm2;
    private javax.swing.JButton btnReviewUpdForm3;
    private javax.swing.JButton btnReviewWrite;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdReview;
    private javax.swing.JComboBox<String> comboReviewGradeWrtie;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JComboBox<String> comboUpdGrade;
    private javax.swing.JDialog jDialogCommDel;
    private javax.swing.JDialog jDialogCommUpd;
    private javax.swing.JDialog jDialogReviewDel;
    private javax.swing.JDialog jDialogReviewUpd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelComment;
    private javax.swing.JPanel jPanelDetails;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelImg;
    private javax.swing.JPanel jPanelReview;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPaneComm1;
    private javax.swing.JScrollPane jScrollPaneComm4;
    private javax.swing.JScrollPane jScrollPaneComm5;
    private javax.swing.JScrollPane jScrollPaneCommWrite;
    private javax.swing.JScrollPane jScrollPaneContent;
    private javax.swing.JScrollPane jScrollPaneNecess;
    private javax.swing.JScrollPane jScrollPaneReview1;
    private javax.swing.JScrollPane jScrollPaneReview2;
    private javax.swing.JScrollPane jScrollPaneReview3;
    private javax.swing.JScrollPane jScrollPaneReviewWrite;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea15;
    private javax.swing.JTextArea jTextAreaComm1;
    private javax.swing.JTextArea jTextAreaComm4;
    private javax.swing.JTextArea jTextAreaComm5;
    private javax.swing.JTextArea jTextAreaCommWrite;
    private javax.swing.JTextArea jTextAreaContent;
    private javax.swing.JTextArea jTextAreaNecess;
    private javax.swing.JTextArea jTextAreaReview1;
    private javax.swing.JTextArea jTextAreaReview2;
    private javax.swing.JTextArea jTextAreaReview3;
    private javax.swing.JTextArea jTextAreaUpdComm;
    private javax.swing.JTextArea jTextAreaUpdateReview;
    private javax.swing.JLabel lblCommCreate1;
    private javax.swing.JLabel lblCommCreate4;
    private javax.swing.JLabel lblCommCreate5;
    private javax.swing.JLabel lblCommCurrentPage;
    private javax.swing.JLabel lblCommWriter1;
    private javax.swing.JLabel lblCommWriter4;
    private javax.swing.JLabel lblCommWriter5;
    private javax.swing.JLabel lblCommWriterWrite;
    private javax.swing.JLabel lblCreate;
    private javax.swing.JLabel lblDelComm;
    private javax.swing.JLabel lblDelCommConfirm;
    private javax.swing.JLabel lblDelReview;
    private javax.swing.JLabel lblDelReviewConfirm;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNecess;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblReviewCreate1;
    private javax.swing.JLabel lblReviewCreate2;
    private javax.swing.JLabel lblReviewCreate3;
    private javax.swing.JLabel lblReviewCurrentPage;
    private javax.swing.JLabel lblReviewGrade1;
    private javax.swing.JLabel lblReviewGrade2;
    private javax.swing.JLabel lblReviewGrade3;
    private javax.swing.JLabel lblReviewGradeWrite;
    private javax.swing.JLabel lblReviewWriter1;
    private javax.swing.JLabel lblReviewWriter2;
    private javax.swing.JLabel lblReviewWriter3;
    private javax.swing.JLabel lblReviewWriterWrite;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUpdGrade;
    private javax.swing.JLabel lblUpdReview;
    private javax.swing.JLabel lblWriter;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JPanel writeCommnetPanel;
    private javax.swing.JPanel writeReviewPanel;
    // End of variables declaration//GEN-END:variables
}
