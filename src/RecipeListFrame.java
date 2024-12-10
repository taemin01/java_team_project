
import java.util.ArrayList;
import java.util.List;


public class RecipeListFrame extends javax.swing.JFrame {
    private static final int ITEMS_PER_PAGE = 3; // 한 페이지에 표시할 항목 수
    private static int currentPage = 1; // 현재 페이지

    public RecipeListFrame() {
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
        lblCurrentPage = new javax.swing.JLabel();
        btnNextPage = new javax.swing.JButton();
        btnPrePage = new javax.swing.JButton();
        jPanelRecipeList1 = new javax.swing.JPanel();
        lblRecipeTitle1 = new javax.swing.JLabel();
        lblRecipeGrade1 = new javax.swing.JLabel();
        jPanelRecipeOrder1 = new javax.swing.JPanel();
        lblRecipeOrder1 = new javax.swing.JLabel();
        jPanelRecipeImg1 = new javax.swing.JPanel();
        lblRecipeWiter1 = new javax.swing.JLabel();
        btnRecipeBook1 = new javax.swing.JButton();
        lblRecipeCreate1 = new javax.swing.JLabel();
        jPanelRecipeList2 = new javax.swing.JPanel();
        lblRecipeTitle2 = new javax.swing.JLabel();
        lblRecipeGrade2 = new javax.swing.JLabel();
        jPanelRecipeOrder2 = new javax.swing.JPanel();
        lblRecipeOrder2 = new javax.swing.JLabel();
        jPanelRecipeImg2 = new javax.swing.JPanel();
        lblRecipeWiter2 = new javax.swing.JLabel();
        btnRecipeBokk2 = new javax.swing.JButton();
        lblRecipeCreate2 = new javax.swing.JLabel();
        jPanelRecipeList3 = new javax.swing.JPanel();
        lblRecipeTitle3 = new javax.swing.JLabel();
        lblRecipeGrade3 = new javax.swing.JLabel();
        jPanelRecipeOrder3 = new javax.swing.JPanel();
        lblRecipeOrder3 = new javax.swing.JLabel();
        jPanelRecipeImg3 = new javax.swing.JPanel();
        lblRecipeWriter3 = new javax.swing.JLabel();
        btnRecipeBook3 = new javax.swing.JButton();
        lblRecipeCreate3 = new javax.swing.JLabel();
        lblRecipe = new javax.swing.JLabel();
        btnRecipeWrite = new javax.swing.JButton();

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

        lblCurrentPage.setText("1");

        btnNextPage.setText(">");

        btnPrePage.setText("<");

        jPanelRecipeList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRecipeList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRecipeList1MouseClicked(evt);
            }
        });

        lblRecipeTitle1.setText("제목 : 김치");

        lblRecipeGrade1.setText("평점 : 0.0");

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
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addGap(0, 58, Short.MAX_VALUE)
        );

        lblRecipeWiter1.setText("작성자 : 홍길동");

        btnRecipeBook1.setText("북마크");

        lblRecipeCreate1.setText("작성날짜 : 2025.01.01");

        javax.swing.GroupLayout jPanelRecipeList1Layout = new javax.swing.GroupLayout(jPanelRecipeList1);
        jPanelRecipeList1.setLayout(jPanelRecipeList1Layout);
        jPanelRecipeList1Layout.setHorizontalGroup(
            jPanelRecipeList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeList1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipeList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeGrade1)
                    .addComponent(lblRecipeTitle1)
                    .addGroup(jPanelRecipeList1Layout.createSequentialGroup()
                        .addComponent(lblRecipeWiter1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRecipeCreate1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecipeBook1)
                .addContainerGap())
        );
        jPanelRecipeList1Layout.setVerticalGroup(
            jPanelRecipeList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeList1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRecipeList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeList1Layout.createSequentialGroup()
                        .addGroup(jPanelRecipeList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipeList1Layout.createSequentialGroup()
                                .addComponent(lblRecipeTitle1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRecipeGrade1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelRecipeList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRecipeWiter1)
                                    .addComponent(lblRecipeCreate1)))
                            .addComponent(jPanelRecipeImg1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecipeBook1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeList1Layout.createSequentialGroup()
                        .addComponent(jPanelRecipeOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanelRecipeList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRecipeList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRecipeList2MouseClicked(evt);
            }
        });

        lblRecipeTitle2.setText("제목 : 김치");

        lblRecipeGrade2.setText("평점 : 0.0");

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
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addGap(0, 58, Short.MAX_VALUE)
        );

        lblRecipeWiter2.setText("작성자 : 홍길동");

        btnRecipeBokk2.setText("북마크");

        lblRecipeCreate2.setText("작성날짜 : 2025.01.01");

        javax.swing.GroupLayout jPanelRecipeList2Layout = new javax.swing.GroupLayout(jPanelRecipeList2);
        jPanelRecipeList2.setLayout(jPanelRecipeList2Layout);
        jPanelRecipeList2Layout.setHorizontalGroup(
            jPanelRecipeList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeList2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipeList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeGrade2)
                    .addComponent(lblRecipeTitle2)
                    .addGroup(jPanelRecipeList2Layout.createSequentialGroup()
                        .addComponent(lblRecipeWiter2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRecipeCreate2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecipeBokk2)
                .addContainerGap())
        );
        jPanelRecipeList2Layout.setVerticalGroup(
            jPanelRecipeList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeList2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipeList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRecipeList2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelRecipeList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeList2Layout.createSequentialGroup()
                                .addGroup(jPanelRecipeList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipeList2Layout.createSequentialGroup()
                                        .addComponent(lblRecipeTitle2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRecipeGrade2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelRecipeList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblRecipeWiter2)
                                            .addComponent(lblRecipeCreate2)))
                                    .addComponent(jPanelRecipeImg2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeList2Layout.createSequentialGroup()
                                .addComponent(jPanelRecipeOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanelRecipeList2Layout.createSequentialGroup()
                        .addComponent(btnRecipeBokk2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanelRecipeList3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRecipeList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRecipeList3MouseClicked(evt);
            }
        });

        lblRecipeTitle3.setText("제목 : 김치");

        lblRecipeGrade3.setText("평점 : 0.0");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 58, Short.MAX_VALUE)
        );

        lblRecipeWriter3.setText("작성자 : 홍길동");

        btnRecipeBook3.setText("북마크");

        lblRecipeCreate3.setText("작성날짜 : 2025.01.01");

        javax.swing.GroupLayout jPanelRecipeList3Layout = new javax.swing.GroupLayout(jPanelRecipeList3);
        jPanelRecipeList3.setLayout(jPanelRecipeList3Layout);
        jPanelRecipeList3Layout.setHorizontalGroup(
            jPanelRecipeList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeList3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRecipeOrder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeImg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRecipeList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecipeGrade3)
                    .addComponent(lblRecipeTitle3)
                    .addGroup(jPanelRecipeList3Layout.createSequentialGroup()
                        .addComponent(lblRecipeWriter3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                        .addComponent(lblRecipeCreate3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecipeBook3)
                .addContainerGap())
        );
        jPanelRecipeList3Layout.setVerticalGroup(
            jPanelRecipeList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeList3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecipeList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRecipeBook3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelRecipeList3Layout.createSequentialGroup()
                        .addGroup(jPanelRecipeList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelRecipeOrder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRecipeList3Layout.createSequentialGroup()
                                .addComponent(lblRecipeTitle3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRecipeGrade3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelRecipeList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRecipeWriter3)
                                    .addComponent(lblRecipeCreate3)))
                            .addComponent(jPanelRecipeImg3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        lblRecipe.setText("레시피");

        btnRecipeWrite.setText("작성하기");
        btnRecipeWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecipeWriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRecipeList3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnPrePage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCurrentPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNextPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecipeWrite))
                    .addComponent(jPanelRecipeList2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRecipeList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(lblRecipe)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRecipe)
                .addGap(18, 18, 18)
                .addComponent(jPanelRecipeList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeList2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecipeList3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRecipeWrite)
                .addGap(32, 32, 32)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentPage)
                    .addComponent(btnNextPage)
                    .addComponent(btnPrePage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        new SearchResultFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked
        // TODO add your handling code here:
        new SubFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoMouseClicked

    private void jPanelRecipeList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRecipeList1MouseClicked
        // TODO add your handling code here:
//        new RecipeDetailFrame().setVisible(true);
    }//GEN-LAST:event_jPanelRecipeList1MouseClicked

    private void jPanelRecipeList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRecipeList2MouseClicked
        // TODO add your handling code here:
//        new RecipeDetailFrame().setVisible(true);
    }//GEN-LAST:event_jPanelRecipeList2MouseClicked

    private void jPanelRecipeList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRecipeList3MouseClicked
        // TODO add your handling code here:
//        new RecipeDetailFrame().setVisible(true);
    }//GEN-LAST:event_jPanelRecipeList3MouseClicked

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        // TODO add your handling code here:
        new MyProfileFrame().setVisible(true);
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnRecipeWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecipeWriteActionPerformed
        // TODO add your handling code here:
        new WriteRecipeFrame().setVisible(true);
    }//GEN-LAST:event_btnRecipeWriteActionPerformed

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
            java.util.logging.Logger.getLogger(SearchResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= items.size(); i++) {
            items.add("Item " + i);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchResultFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPrePage;
    private javax.swing.JButton btnRecipeBokk2;
    private javax.swing.JButton btnRecipeBook1;
    private javax.swing.JButton btnRecipeBook3;
    private javax.swing.JButton btnRecipeWrite;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelRecipeImg1;
    private javax.swing.JPanel jPanelRecipeImg2;
    private javax.swing.JPanel jPanelRecipeImg3;
    private javax.swing.JPanel jPanelRecipeList1;
    private javax.swing.JPanel jPanelRecipeList2;
    private javax.swing.JPanel jPanelRecipeList3;
    private javax.swing.JPanel jPanelRecipeOrder1;
    private javax.swing.JPanel jPanelRecipeOrder2;
    private javax.swing.JPanel jPanelRecipeOrder3;
    private javax.swing.JLabel lblCurrentPage;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRecipe;
    private javax.swing.JLabel lblRecipeCreate1;
    private javax.swing.JLabel lblRecipeCreate2;
    private javax.swing.JLabel lblRecipeCreate3;
    private javax.swing.JLabel lblRecipeGrade1;
    private javax.swing.JLabel lblRecipeGrade2;
    private javax.swing.JLabel lblRecipeGrade3;
    private javax.swing.JLabel lblRecipeOrder1;
    private javax.swing.JLabel lblRecipeOrder2;
    private javax.swing.JLabel lblRecipeOrder3;
    private javax.swing.JLabel lblRecipeTitle1;
    private javax.swing.JLabel lblRecipeTitle2;
    private javax.swing.JLabel lblRecipeTitle3;
    private javax.swing.JLabel lblRecipeWiter1;
    private javax.swing.JLabel lblRecipeWiter2;
    private javax.swing.JLabel lblRecipeWriter3;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
