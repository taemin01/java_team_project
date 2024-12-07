
import java.awt.Color;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;
import util.TokenUtil;


public class SubFrame extends javax.swing.JFrame {
     private JSONObject userInfo;

    public SubFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        comboSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanelBody = new javax.swing.JPanel();
        jPanelNotice = new javax.swing.JPanel();
        jScrollPaneNotice = new javax.swing.JScrollPane();
        jTableNotice = new javax.swing.JTable();
        lblNotice = new javax.swing.JLabel();
        btnNotice = new javax.swing.JButton();
        jScrollPaneRecipe = new javax.swing.JScrollPane();
        jPanelRecipe = new javax.swing.JPanel();
        lblRecipe = new javax.swing.JLabel();
        btnRecipe = new javax.swing.JButton();
        jPanelRecipeTop10 = new javax.swing.JPanel();
        jPanelRecipe1 = new javax.swing.JPanel();
        lblRecipeTitle1 = new javax.swing.JLabel();
        lblRecipeGrade1 = new javax.swing.JLabel();
        jPanelRecipeOrder1 = new javax.swing.JPanel();
        lblRecipeOrder1 = new javax.swing.JLabel();
        jPanelRecipeImg1 = new javax.swing.JPanel();
        jPanelRecipe2 = new javax.swing.JPanel();
        lblRecipeTitle2 = new javax.swing.JLabel();
        lblRecipeGrade2 = new javax.swing.JLabel();
        jPanelRecipeOrder2 = new javax.swing.JPanel();
        lblRecipeOrder2 = new javax.swing.JLabel();
        jPanelRecipeImg2 = new javax.swing.JPanel();
        jPanelRecipe3 = new javax.swing.JPanel();
        lblRecipeTitle3 = new javax.swing.JLabel();
        lblRecipeGrade3 = new javax.swing.JLabel();
        jPanelRecipeOrder3 = new javax.swing.JPanel();
        lblRecipeOrder3 = new javax.swing.JLabel();
        jPanelRecipeImg3 = new javax.swing.JPanel();
        jPanelRecipe4 = new javax.swing.JPanel();
        lblRecipeTitle4 = new javax.swing.JLabel();
        lblRecipeGrade4 = new javax.swing.JLabel();
        jPanelRecipeOrder4 = new javax.swing.JPanel();
        lblRecipeOrder4 = new javax.swing.JLabel();
        jPanelRecipeImg4 = new javax.swing.JPanel();
        jPanelRecipe5 = new javax.swing.JPanel();
        lblRecipeTitle5 = new javax.swing.JLabel();
        lblRecipeGrade5 = new javax.swing.JLabel();
        jPanelRecipeOrder5 = new javax.swing.JPanel();
        lblRecipeOrder5 = new javax.swing.JLabel();
        jPanelRecipeImg5 = new javax.swing.JPanel();
        jPanelRecipe6 = new javax.swing.JPanel();
        lblRecipeTitle6 = new javax.swing.JLabel();
        lblRecipeGrade6 = new javax.swing.JLabel();
        jPanelRecipeOrder6 = new javax.swing.JPanel();
        lblRecipeOrder6 = new javax.swing.JLabel();
        jPanelRecipeImg6 = new javax.swing.JPanel();
        jPanelRecipe7 = new javax.swing.JPanel();
        lblRecipeTitle7 = new javax.swing.JLabel();
        lblRecipeGrade7 = new javax.swing.JLabel();
        jPanelRecipeOrder7 = new javax.swing.JPanel();
        lblRecipeOrder7 = new javax.swing.JLabel();
        jPanelRecipeImg7 = new javax.swing.JPanel();
        jPanelRecipe8 = new javax.swing.JPanel();
        lblRecipeTitle8 = new javax.swing.JLabel();
        lblRecipeGrade8 = new javax.swing.JLabel();
        jPanelRecipeOrder8 = new javax.swing.JPanel();
        lblRecipeOrder8 = new javax.swing.JLabel();
        jPanelRecipeImg8 = new javax.swing.JPanel();
        jPanelRecipe9 = new javax.swing.JPanel();
        lblRecipeTitle9 = new javax.swing.JLabel();
        lblRecipeGrade9 = new javax.swing.JLabel();
        jPanelRecipeOrder9 = new javax.swing.JPanel();
        lblRecipeOrder9 = new javax.swing.JLabel();
        jPanelRecipeImg9 = new javax.swing.JPanel();
        jPanelRecipe10 = new javax.swing.JPanel();
        lblRecipeTitle10 = new javax.swing.JLabel();
        lblRecipeGrade10 = new javax.swing.JLabel();
        jPanelRecipeOrder10 = new javax.swing.JPanel();
        lblRecipeOrder10 = new javax.swing.JLabel();
        jPanelRecipeImg10 = new javax.swing.JPanel();
        jPanelNews = new javax.swing.JPanel();
        lblNews = new javax.swing.JLabel();
        jScrollPaneNews = new javax.swing.JScrollPane();
        jTableNews = new javax.swing.JTable();
        btnNews = new javax.swing.JButton();

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

        jPanelNotice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableNotice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "순번", "제목", "작성자", "날짜"
            }
        ));
        jScrollPaneNotice.setViewportView(jTableNotice);

        lblNotice.setText("공지사항");

        btnNotice.setFont(new java.awt.Font("맑은 고딕", 0, 8)); // NOI18N
        btnNotice.setText("바로가기");
        btnNotice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoticeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNoticeLayout = new javax.swing.GroupLayout(jPanelNotice);
        jPanelNotice.setLayout(jPanelNoticeLayout);
        jPanelNoticeLayout.setHorizontalGroup(
            jPanelNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanelNoticeLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblNotice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelNoticeLayout.setVerticalGroup(
            jPanelNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNoticeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotice)
                    .addComponent(btnNotice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneNotice, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
        );

        jPanelRecipe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipe.setText("레시피 TOP 10");

        btnRecipe.setFont(new java.awt.Font("맑은 고딕", 0, 8)); // NOI18N
        btnRecipe.setText("바로가기");
        btnRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecipeActionPerformed(evt);
            }
        });

        jPanelRecipeTop10.setPreferredSize(new java.awt.Dimension(169, 200));

        jPanelRecipe1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle1.setText("제목");

        lblRecipeGrade1.setText("평점");

        lblRecipeOrder1.setText("1");

        javax.swing.GroupLayout jPanelRecipeOrder1Layout = new javax.swing.GroupLayout(jPanelRecipeOrder1);
        jPanelRecipeOrder1.setLayout(jPanelRecipeOrder1Layout);
        jPanelRecipeOrder1Layout.setHorizontalGroup(
            jPanelRecipeOrder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder1Layout.setVerticalGroup(
            jPanelRecipeOrder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg1Layout = new javax.swing.GroupLayout(jPanelRecipeImg1);
        jPanelRecipeImg1.setLayout(jPanelRecipeImg1Layout);
        jPanelRecipeImg1Layout.setHorizontalGroup(
            jPanelRecipeImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg1Layout.setVerticalGroup(
            jPanelRecipeImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe1Layout = new javax.swing.GroupLayout(jPanelRecipe1);
        jPanelRecipe1.setLayout(jPanelRecipe1Layout);
        jPanelRecipe1Layout.setHorizontalGroup(
            jPanelRecipe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle1)
                    .addComponent(lblRecipeGrade1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe1Layout.setVerticalGroup(
            jPanelRecipe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe1Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade1))
                    .addComponent(jPanelRecipeImg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle2.setText("제목");

        lblRecipeGrade2.setText("평점");

        lblRecipeOrder2.setText("2");

        javax.swing.GroupLayout jPanelRecipeOrder2Layout = new javax.swing.GroupLayout(jPanelRecipeOrder2);
        jPanelRecipeOrder2.setLayout(jPanelRecipeOrder2Layout);
        jPanelRecipeOrder2Layout.setHorizontalGroup(
            jPanelRecipeOrder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder2)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder2Layout.setVerticalGroup(
            jPanelRecipeOrder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder2)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg2Layout = new javax.swing.GroupLayout(jPanelRecipeImg2);
        jPanelRecipeImg2.setLayout(jPanelRecipeImg2Layout);
        jPanelRecipeImg2Layout.setHorizontalGroup(
            jPanelRecipeImg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg2Layout.setVerticalGroup(
            jPanelRecipeImg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe2Layout = new javax.swing.GroupLayout(jPanelRecipe2);
        jPanelRecipe2.setLayout(jPanelRecipe2Layout);
        jPanelRecipe2Layout.setHorizontalGroup(
            jPanelRecipe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle2)
                    .addComponent(lblRecipeGrade2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe2Layout.setVerticalGroup(
            jPanelRecipe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe2Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade2))
                    .addComponent(jPanelRecipeImg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle3.setText("제목");

        lblRecipeGrade3.setText("평점");

        lblRecipeOrder3.setText("3");

        javax.swing.GroupLayout jPanelRecipeOrder3Layout = new javax.swing.GroupLayout(jPanelRecipeOrder3);
        jPanelRecipeOrder3.setLayout(jPanelRecipeOrder3Layout);
        jPanelRecipeOrder3Layout.setHorizontalGroup(
            jPanelRecipeOrder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder3)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder3Layout.setVerticalGroup(
            jPanelRecipeOrder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg3Layout = new javax.swing.GroupLayout(jPanelRecipeImg3);
        jPanelRecipeImg3.setLayout(jPanelRecipeImg3Layout);
        jPanelRecipeImg3Layout.setHorizontalGroup(
            jPanelRecipeImg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg3Layout.setVerticalGroup(
            jPanelRecipeImg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe3Layout = new javax.swing.GroupLayout(jPanelRecipe3);
        jPanelRecipe3.setLayout(jPanelRecipe3Layout);
        jPanelRecipe3Layout.setHorizontalGroup(
            jPanelRecipe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle3)
                    .addComponent(lblRecipeGrade3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe3Layout.setVerticalGroup(
            jPanelRecipe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe3Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade3))
                    .addComponent(jPanelRecipeImg3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle4.setText("제목");

        lblRecipeGrade4.setText("평점");

        lblRecipeOrder4.setText("4");

        javax.swing.GroupLayout jPanelRecipeOrder4Layout = new javax.swing.GroupLayout(jPanelRecipeOrder4);
        jPanelRecipeOrder4.setLayout(jPanelRecipeOrder4Layout);
        jPanelRecipeOrder4Layout.setHorizontalGroup(
            jPanelRecipeOrder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder4)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder4Layout.setVerticalGroup(
            jPanelRecipeOrder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg4Layout = new javax.swing.GroupLayout(jPanelRecipeImg4);
        jPanelRecipeImg4.setLayout(jPanelRecipeImg4Layout);
        jPanelRecipeImg4Layout.setHorizontalGroup(
            jPanelRecipeImg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg4Layout.setVerticalGroup(
            jPanelRecipeImg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe4Layout = new javax.swing.GroupLayout(jPanelRecipe4);
        jPanelRecipe4.setLayout(jPanelRecipe4Layout);
        jPanelRecipe4Layout.setHorizontalGroup(
            jPanelRecipe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle4)
                    .addComponent(lblRecipeGrade4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe4Layout.setVerticalGroup(
            jPanelRecipe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe4Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade4))
                    .addComponent(jPanelRecipeImg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle5.setText("제목");

        lblRecipeGrade5.setText("평점");

        lblRecipeOrder5.setText("5");

        javax.swing.GroupLayout jPanelRecipeOrder5Layout = new javax.swing.GroupLayout(jPanelRecipeOrder5);
        jPanelRecipeOrder5.setLayout(jPanelRecipeOrder5Layout);
        jPanelRecipeOrder5Layout.setHorizontalGroup(
            jPanelRecipeOrder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder5)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder5Layout.setVerticalGroup(
            jPanelRecipeOrder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder5)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg5Layout = new javax.swing.GroupLayout(jPanelRecipeImg5);
        jPanelRecipeImg5.setLayout(jPanelRecipeImg5Layout);
        jPanelRecipeImg5Layout.setHorizontalGroup(
            jPanelRecipeImg5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg5Layout.setVerticalGroup(
            jPanelRecipeImg5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe5Layout = new javax.swing.GroupLayout(jPanelRecipe5);
        jPanelRecipe5.setLayout(jPanelRecipe5Layout);
        jPanelRecipe5Layout.setHorizontalGroup(
            jPanelRecipe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle5)
                    .addComponent(lblRecipeGrade5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe5Layout.setVerticalGroup(
            jPanelRecipe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe5Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade5))
                    .addComponent(jPanelRecipeImg5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle6.setText("제목");

        lblRecipeGrade6.setText("평점");

        lblRecipeOrder6.setText("6");

        javax.swing.GroupLayout jPanelRecipeOrder6Layout = new javax.swing.GroupLayout(jPanelRecipeOrder6);
        jPanelRecipeOrder6.setLayout(jPanelRecipeOrder6Layout);
        jPanelRecipeOrder6Layout.setHorizontalGroup(
            jPanelRecipeOrder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder6)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder6Layout.setVerticalGroup(
            jPanelRecipeOrder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder6)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg6Layout = new javax.swing.GroupLayout(jPanelRecipeImg6);
        jPanelRecipeImg6.setLayout(jPanelRecipeImg6Layout);
        jPanelRecipeImg6Layout.setHorizontalGroup(
            jPanelRecipeImg6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg6Layout.setVerticalGroup(
            jPanelRecipeImg6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe6Layout = new javax.swing.GroupLayout(jPanelRecipe6);
        jPanelRecipe6.setLayout(jPanelRecipe6Layout);
        jPanelRecipe6Layout.setHorizontalGroup(
            jPanelRecipe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle6)
                    .addComponent(lblRecipeGrade6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe6Layout.setVerticalGroup(
            jPanelRecipe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe6Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade6))
                    .addComponent(jPanelRecipeImg6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle7.setText("제목");

        lblRecipeGrade7.setText("평점");

        lblRecipeOrder7.setText("7");

        javax.swing.GroupLayout jPanelRecipeOrder7Layout = new javax.swing.GroupLayout(jPanelRecipeOrder7);
        jPanelRecipeOrder7.setLayout(jPanelRecipeOrder7Layout);
        jPanelRecipeOrder7Layout.setHorizontalGroup(
            jPanelRecipeOrder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder7)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder7Layout.setVerticalGroup(
            jPanelRecipeOrder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder7)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg7Layout = new javax.swing.GroupLayout(jPanelRecipeImg7);
        jPanelRecipeImg7.setLayout(jPanelRecipeImg7Layout);
        jPanelRecipeImg7Layout.setHorizontalGroup(
            jPanelRecipeImg7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg7Layout.setVerticalGroup(
            jPanelRecipeImg7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe7Layout = new javax.swing.GroupLayout(jPanelRecipe7);
        jPanelRecipe7.setLayout(jPanelRecipe7Layout);
        jPanelRecipe7Layout.setHorizontalGroup(
            jPanelRecipe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle7)
                    .addComponent(lblRecipeGrade7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe7Layout.setVerticalGroup(
            jPanelRecipe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe7Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade7))
                    .addComponent(jPanelRecipeImg7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle8.setText("제목");

        lblRecipeGrade8.setText("평점");

        lblRecipeOrder8.setText("8");

        javax.swing.GroupLayout jPanelRecipeOrder8Layout = new javax.swing.GroupLayout(jPanelRecipeOrder8);
        jPanelRecipeOrder8.setLayout(jPanelRecipeOrder8Layout);
        jPanelRecipeOrder8Layout.setHorizontalGroup(
            jPanelRecipeOrder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder8)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder8Layout.setVerticalGroup(
            jPanelRecipeOrder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder8)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg8Layout = new javax.swing.GroupLayout(jPanelRecipeImg8);
        jPanelRecipeImg8.setLayout(jPanelRecipeImg8Layout);
        jPanelRecipeImg8Layout.setHorizontalGroup(
            jPanelRecipeImg8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg8Layout.setVerticalGroup(
            jPanelRecipeImg8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe8Layout = new javax.swing.GroupLayout(jPanelRecipe8);
        jPanelRecipe8.setLayout(jPanelRecipe8Layout);
        jPanelRecipe8Layout.setHorizontalGroup(
            jPanelRecipe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle8)
                    .addComponent(lblRecipeGrade8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe8Layout.setVerticalGroup(
            jPanelRecipe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe8Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade8))
                    .addComponent(jPanelRecipeImg8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle9.setText("제목");

        lblRecipeGrade9.setText("평점");

        lblRecipeOrder9.setText("9");

        javax.swing.GroupLayout jPanelRecipeOrder9Layout = new javax.swing.GroupLayout(jPanelRecipeOrder9);
        jPanelRecipeOrder9.setLayout(jPanelRecipeOrder9Layout);
        jPanelRecipeOrder9Layout.setHorizontalGroup(
            jPanelRecipeOrder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder9)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder9Layout.setVerticalGroup(
            jPanelRecipeOrder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder9)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg9Layout = new javax.swing.GroupLayout(jPanelRecipeImg9);
        jPanelRecipeImg9.setLayout(jPanelRecipeImg9Layout);
        jPanelRecipeImg9Layout.setHorizontalGroup(
            jPanelRecipeImg9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg9Layout.setVerticalGroup(
            jPanelRecipeImg9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe9Layout = new javax.swing.GroupLayout(jPanelRecipe9);
        jPanelRecipe9.setLayout(jPanelRecipe9Layout);
        jPanelRecipe9Layout.setHorizontalGroup(
            jPanelRecipe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle9)
                    .addComponent(lblRecipeGrade9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe9Layout.setVerticalGroup(
            jPanelRecipe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe9Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade9))
                    .addComponent(jPanelRecipeImg9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRecipe10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRecipeTitle10.setText("제목");

        lblRecipeGrade10.setText("평점");

        lblRecipeOrder10.setText("10");

        javax.swing.GroupLayout jPanelRecipeOrder10Layout = new javax.swing.GroupLayout(jPanelRecipeOrder10);
        jPanelRecipeOrder10.setLayout(jPanelRecipeOrder10Layout);
        jPanelRecipeOrder10Layout.setHorizontalGroup(
            jPanelRecipeOrder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRecipeOrder10)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelRecipeOrder10Layout.setVerticalGroup(
            jPanelRecipeOrder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeOrder10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRecipeOrder10)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelRecipeImg10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelRecipeImg10Layout = new javax.swing.GroupLayout(jPanelRecipeImg10);
        jPanelRecipeImg10.setLayout(jPanelRecipeImg10Layout);
        jPanelRecipeImg10Layout.setHorizontalGroup(
            jPanelRecipeImg10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanelRecipeImg10Layout.setVerticalGroup(
            jPanelRecipeImg10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRecipe10Layout = new javax.swing.GroupLayout(jPanelRecipe10);
        jPanelRecipe10.setLayout(jPanelRecipe10Layout);
        jPanelRecipe10Layout.setHorizontalGroup(
            jPanelRecipe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeTitle10)
                    .addComponent(lblRecipeGrade10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRecipe10Layout.setVerticalGroup(
            jPanelRecipe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipe10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelRecipeOrder10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipe10Layout.createSequentialGroup()
                        .addComponent(lblRecipeTitle10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecipeGrade10))
                    .addComponent(jPanelRecipeImg10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRecipeTop10Layout = new javax.swing.GroupLayout(jPanelRecipeTop10);
        jPanelRecipeTop10.setLayout(jPanelRecipeTop10Layout);
        jPanelRecipeTop10Layout.setHorizontalGroup(
            jPanelRecipeTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeTop10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipeTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRecipe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipe10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelRecipeTop10Layout.setVerticalGroup(
            jPanelRecipeTop10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeTop10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipe10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRecipeLayout = new javax.swing.GroupLayout(jPanelRecipe);
        jPanelRecipe.setLayout(jPanelRecipeLayout);
        jPanelRecipeLayout.setHorizontalGroup(
            jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblRecipe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelRecipeTop10, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        jPanelRecipeLayout.setVerticalGroup(
            jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecipe)
                    .addComponent(btnRecipe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeTop10, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE))
        );

        jScrollPaneRecipe.setViewportView(jPanelRecipe);

        jPanelNews.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNews.setText("신문/기사");

        jTableNews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "순번", "제목", "작성자", "날짜"
            }
        ));
        jScrollPaneNews.setViewportView(jTableNews);

        btnNews.setFont(new java.awt.Font("맑은 고딕", 0, 8)); // NOI18N
        btnNews.setText("바로가기");
        btnNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNewsLayout = new javax.swing.GroupLayout(jPanelNews);
        jPanelNews.setLayout(jPanelNewsLayout);
        jPanelNewsLayout.setHorizontalGroup(
            jPanelNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewsLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(lblNews)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnNews, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPaneNews, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelNewsLayout.setVerticalGroup(
            jPanelNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNews)
                    .addComponent(btnNews))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneNews, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNotice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262)
                .addComponent(jPanelNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBodyLayout.createSequentialGroup()
                    .addGap(239, 239, 239)
                    .addComponent(jScrollPaneRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGap(240, 240, 240)))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelNotice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBodyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        sendSearchRequest();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void sendSearchRequest() {
        try {
            // HttpClient 객체 생성
            HttpClient client = HttpClient.newHttpClient();

            // 사용자가 선택한 검색 기준(제목 또는 재료) 가져오기
            String searchCriteria = comboSearch.getSelectedItem().toString(); // 콤보박스 선택 값
            String searchKeyword = txtSearch.getText().trim(); // 텍스트 필드에 입력된 검색어를 가져오고 공백 제거

            // 검색어가 비어 있는지 확인
            if (searchKeyword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "검색어를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 검색 기준에 따른 파라미터 이름 설정
            String paramName;
            if ("제목".equals(searchCriteria)) {
                paramName = "title"; // 제목 검색
            } else if ("재료".equals(searchCriteria)) {
                paramName = "ingredient"; // 재료 검색
            } else {
                JOptionPane.showMessageDialog(this, "유효한 검색 기준이 아닙니다.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 검색 요청 URL 생성
            String url = "https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/getUserRecipe?"
                    + paramName + "=" + URLEncoder.encode(searchKeyword, "UTF-8"); // 검색 키워드를 URL 인코딩

            // HttpRequest 객체 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)) // URL 설정
                    .GET() // GET 요청 설정
                    .header("Content-Type", "application/json") // Content-Type 헤더 추가
                    .build();

            // 요청을 보내고 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 상태 코드 확인
            if (response.statusCode() == 200) {
                // 응답 본문 가져오기
                String responseBody = response.body();
                System.out.println("검색 결과: " + responseBody);

                // JSON 응답 파싱
                JSONObject jsonResponse = new JSONObject(responseBody);
                String resultStatus = jsonResponse.getString("result");

                // 결과 상태 확인
                if ("success".equals(resultStatus)) {
                    // 검색 결과 배열 가져오기
                    JSONArray results = jsonResponse.getJSONArray("items");

                    // 검색 결과를 새 창에 전달하여 표시
                    SearchResultFrame resultFrame = new SearchResultFrame();
                    resultFrame.displayResults(results); // 결과 데이터를 설정
                    resultFrame.setVisible(true); // 새 창 열기
                    this.dispose(); // 현재 창 닫기
                } else {
                    // 결과 상태가 실패인 경우
                    JOptionPane.showMessageDialog(this, "검색 실패: 결과가 없습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                // 응답 상태 코드가 성공이 아닌 경우
                JOptionPane.showMessageDialog(this, "검색 실패: 서버 오류 발생", "오류", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            // 예외 발생 시 처리
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "검색 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnNoticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoticeActionPerformed
        // TODO add your handling code here:
        new NoticeListFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNoticeActionPerformed

    private void btnRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecipeActionPerformed
        // TODO add your handling code here:
        new RecipeListFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRecipeActionPerformed

    private void btnNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewsActionPerformed
        // TODO add your handling code here:
        new NewsListFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNewsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        try {
            userInfo = TokenUtil.loadUserInfo();
            System.out.println("userInfo : " + userInfo);
            System.out.println("token : " + userInfo.getString("token"));

            if (userInfo == null) {
                JOptionPane.showMessageDialog(this, "로그아웃할 토큰이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // HttpClient를 사용하여 백엔드로 로그아웃 요청
            HttpClient client = HttpClient.newHttpClient();
            String token = userInfo.getString("token");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://m4srikufjgyzqbwltnujr7zyae0zlnrv.lambda-url.ap-northeast-2.on.aws/userLogout")) // 올바른 엔드포인트
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token) // 토큰 추가
                    .POST(HttpRequest.BodyPublishers.noBody()) // POST 요청
                    .build();

            // 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // 응답 상태 코드 확인
            if (response.statusCode() == 200) {
                // 로그아웃 성공 처리
                JOptionPane.showMessageDialog(this, "로그아웃 성공!");
                TokenUtil.deleteUserInfo(); // 토큰 파일 삭제

                // 메인 화면으로 돌아가기
                new MainFrame().setVisible(true);
                this.dispose();
            } else {
                // 로그아웃 실패 처리
                JOptionPane.showMessageDialog(this, "로그아웃 실패: " + responseBody, "오류", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "로그아웃 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked
        // TODO add your handling code here:
        new SubFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoMouseClicked

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        // TODO add your handling code here:
        new MyProfileFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyProfileActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(SubFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnNews;
    private javax.swing.JButton btnNotice;
    private javax.swing.JButton btnRecipe;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelNews;
    private javax.swing.JPanel jPanelNotice;
    private javax.swing.JPanel jPanelRecipe;
    private javax.swing.JPanel jPanelRecipe1;
    private javax.swing.JPanel jPanelRecipe10;
    private javax.swing.JPanel jPanelRecipe2;
    private javax.swing.JPanel jPanelRecipe3;
    private javax.swing.JPanel jPanelRecipe4;
    private javax.swing.JPanel jPanelRecipe5;
    private javax.swing.JPanel jPanelRecipe6;
    private javax.swing.JPanel jPanelRecipe7;
    private javax.swing.JPanel jPanelRecipe8;
    private javax.swing.JPanel jPanelRecipe9;
    private javax.swing.JPanel jPanelRecipeImg1;
    private javax.swing.JPanel jPanelRecipeImg10;
    private javax.swing.JPanel jPanelRecipeImg2;
    private javax.swing.JPanel jPanelRecipeImg3;
    private javax.swing.JPanel jPanelRecipeImg4;
    private javax.swing.JPanel jPanelRecipeImg5;
    private javax.swing.JPanel jPanelRecipeImg6;
    private javax.swing.JPanel jPanelRecipeImg7;
    private javax.swing.JPanel jPanelRecipeImg8;
    private javax.swing.JPanel jPanelRecipeImg9;
    private javax.swing.JPanel jPanelRecipeOrder1;
    private javax.swing.JPanel jPanelRecipeOrder10;
    private javax.swing.JPanel jPanelRecipeOrder2;
    private javax.swing.JPanel jPanelRecipeOrder3;
    private javax.swing.JPanel jPanelRecipeOrder4;
    private javax.swing.JPanel jPanelRecipeOrder5;
    private javax.swing.JPanel jPanelRecipeOrder6;
    private javax.swing.JPanel jPanelRecipeOrder7;
    private javax.swing.JPanel jPanelRecipeOrder8;
    private javax.swing.JPanel jPanelRecipeOrder9;
    private javax.swing.JPanel jPanelRecipeTop10;
    private javax.swing.JScrollPane jScrollPaneNews;
    private javax.swing.JScrollPane jScrollPaneNotice;
    private javax.swing.JScrollPane jScrollPaneRecipe;
    private javax.swing.JTable jTableNews;
    private javax.swing.JTable jTableNotice;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNews;
    private javax.swing.JLabel lblNotice;
    private javax.swing.JLabel lblRecipe;
    private javax.swing.JLabel lblRecipeGrade1;
    private javax.swing.JLabel lblRecipeGrade10;
    private javax.swing.JLabel lblRecipeGrade2;
    private javax.swing.JLabel lblRecipeGrade3;
    private javax.swing.JLabel lblRecipeGrade4;
    private javax.swing.JLabel lblRecipeGrade5;
    private javax.swing.JLabel lblRecipeGrade6;
    private javax.swing.JLabel lblRecipeGrade7;
    private javax.swing.JLabel lblRecipeGrade8;
    private javax.swing.JLabel lblRecipeGrade9;
    private javax.swing.JLabel lblRecipeOrder1;
    private javax.swing.JLabel lblRecipeOrder10;
    private javax.swing.JLabel lblRecipeOrder2;
    private javax.swing.JLabel lblRecipeOrder3;
    private javax.swing.JLabel lblRecipeOrder4;
    private javax.swing.JLabel lblRecipeOrder5;
    private javax.swing.JLabel lblRecipeOrder6;
    private javax.swing.JLabel lblRecipeOrder7;
    private javax.swing.JLabel lblRecipeOrder8;
    private javax.swing.JLabel lblRecipeOrder9;
    private javax.swing.JLabel lblRecipeTitle1;
    private javax.swing.JLabel lblRecipeTitle10;
    private javax.swing.JLabel lblRecipeTitle2;
    private javax.swing.JLabel lblRecipeTitle3;
    private javax.swing.JLabel lblRecipeTitle4;
    private javax.swing.JLabel lblRecipeTitle5;
    private javax.swing.JLabel lblRecipeTitle6;
    private javax.swing.JLabel lblRecipeTitle7;
    private javax.swing.JLabel lblRecipeTitle8;
    private javax.swing.JLabel lblRecipeTitle9;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
