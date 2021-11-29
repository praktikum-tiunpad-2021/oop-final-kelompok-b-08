package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tampilan extends javax.swing.JPanel {
    Sudoku game;
    private static JTextField[][] boxes;
    private JPanel[][] panels;
    private JPanel center, bPanel;
    private JButton hardBtn, medBtn, easyBtn;
    private int[][] temp = new int[9][9];
    private int[][] grid = new int[9][9];

    public JTextField newtextfield() {
        JTextField j = new JTextField("");
        j.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        j.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        j.setHorizontalAlignment(JTextField.CENTER);
        // MOUSE LISTENER
        j.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.decode("#f6ea80")));
                    ((JTextField) e.getSource()).setBackground(Color.decode("#f6ea80"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.lightGray));
                    ((JTextField) e.getSource()).setBackground(Color.white);
                }
            }
        });

        //==============================================

        j.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setForeground(Color.decode("#0c4"));
                } else {
                    ((JTextField) e.getSource()).setForeground(Color.black);
                }
            }
        });
        return j;
    }

    public Tampilan() {
        initComponents();
        /* MAIN PANEL */
        center = new JPanel();  // Main panel
        center.setLayout(new GridLayout(3, 3));     // Grid berukuran 3x3
        center.setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(center); 

        boxes = new JTextField[9][9];
        panels = new JPanel[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                panels[i][j].setLayout(new GridLayout(3, 3));
                center.add(panels[i][j]);
            }
        }

        for (int n = 0; n < 9; n++) {
            for (int i = 0; i < 9; i++) {
                boxes[n][i] = newtextfield();
                int fm = (n + 1) / 3;
                if ((n + 1) % 3 > 0) {
                    fm++;
                }
                int cm = (i + 1) / 3;
                if ((i + 1) % 3 > 0) {
                    cm++;
                }
                panels[fm - 1][cm - 1].add(boxes[n][i]); 
            }
        }
        
        /* PANEL UNTUK BUTTON */

        bPanel = new JPanel();
        bPanel.setBackground(Color.decode("#ffb3c1"));
        bPanel.setBorder(BorderFactory.createLineBorder(Color.black, 6, true));
        bPanel.setLayout(new GridLayout(4, 3, 0, 20)); 
        
        /* PANEL UNTUK MODE HARD */
        easyBtn = new JButton("Hard");

        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                // Sudoku.setlevel(4);
            //       Sudoku.newGame();
            }
        });
        /* PANEL UNTUK MODE MEDIUM */
        medBtn = new JButton("Medium");

        medBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                // Sudoku.setlevel(3);
        //        Sudoku.newGame();

            }
        });

        /* PANEL UNTUK MODE EASY */
        hardBtn = new JButton("Easy");

        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                // Sudoku.setlevel(2);
            //       Sudoku.newGame();
            }
        });

        bPanel.add(hardBtn);   //add new game button to 
        bPanel.add(medBtn);
        bPanel.add(easyBtn);

        add(bPanel, "South");
    }
           
    private void initComponents() {
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    public void setTextLable() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.temp[i][j] != 0) {
                    boxes[i][j].setText(String.valueOf(this.temp[i][j]));
                    boxes[i][j].setEditable(false);
                    boxes[i][j].setBackground(Color.decode("#C0DCC0"));
                } else {
                    boxes[i][j].setText("");
                }
            }
        }
    }
    
    public void setarray(int[][] grid, int[][] temp) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.temp[i][j] = temp[i][j];
                this.grid[i][j] = grid[i][j];
            }
        }
    }
    
    public static void restgame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boxes[i][j].setForeground(Color.black);
                boxes[i][j].setEditable(true);
                boxes[i][j].setBackground(Color.WHITE);
            }
        }
    }
}
