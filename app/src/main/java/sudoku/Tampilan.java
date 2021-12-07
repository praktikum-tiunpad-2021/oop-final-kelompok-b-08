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
import javax.swing.JOptionPane;


public class Tampilan extends javax.swing.JPanel {
    
    private static JTextField[][] boxes;
    private JPanel[][] panels;
    private JPanel center, bPanel, aPanel;
    private JButton hardBtn, medBtn, easyBtn, resetBtn, eBtn, cBtn, about, helpBtn;
    private int[][] temp = new int[9][9];
    private int[][] grid = new int[9][9];
    private int counter = 0;

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

        Listener listener = new Listener();

        /* text field text boxes */
        for (int n = 0; n < 9; n++) {
            for (int i = 0; i < 9; i++) {
                boxes[n][i] = listener.newtextfield();
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
        aPanel = new JPanel();
        aPanel.setBackground(Color.decode("#97a97c"));
        aPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        aPanel.setLayout(new GridLayout(0, 4, 0, 4)); 

        bPanel = new JPanel();
        bPanel.setBackground(Color.decode("#97a97c"));
        bPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        bPanel.setLayout(new GridLayout(2, 3, 4, 4)); 
        
        /* PANEL UNTUK MODE HARD */
        
        easyBtn = new JButton("HARD");
        easyBtn.setBackground(Color.decode("#e9f5db"));
        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetgame();
                Sudoku.setlevel(18);
                Sudoku.newGame();
                counter = 0;
            }
        });
        /* PANEL UNTUK MODE MEDIUM */
        medBtn = new JButton("MEDIUM");

        medBtn.setBackground(Color.decode("#e9f5db"));
        medBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetgame();
                Sudoku.setlevel(8);
                Sudoku.newGame();
                counter = 0;

            }
        });

        /* PANEL UNTUK MODE EASY */
        hardBtn = new JButton("EASY");

        hardBtn.setBackground(Color.decode("#e9f5db"));
        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetgame();
                Sudoku.setlevel(3);
                Sudoku.newGame();
                counter = 0;
            }
        });

        /* PANEL UNTUK RESET */
        resetBtn = new JButton("RESET");

        resetBtn.setBackground(Color.decode("#d6cfcb"));
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetgame();
                Sudoku.newGame();
                counter = 0;
            }
        });
                
        /* PANEL UNTUK EXIT */
        eBtn = new JButton("EXIT");

        eBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /* PANEL UNTUK CHECK GAME */
        cBtn = new JButton("CHECK");

        cBtn.setBackground(Color.decode("#d6cfcb"));
        cBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!boxes[i][j].isEditable()) {
                            continue;
                        } else if (boxes[i][j].getText().equals(String.valueOf(grid[i][j]))) {
                            boxes[i][j].setBackground(Color.green);
                        } else if (boxes[i][j].getText().isEmpty()) {
                            boxes[i][j].setBackground(Color.WHITE);
                            continue;
                        } else {
                            boxes[i][j].setBackground(Color.red);
                        }
                    }
                }
                 counter += 30;
            }
        });
        /* PANEL UNTUK EXIT GAME */
        eBtn = new JButton("EXIT");

        eBtn.setBackground(Color.decode("#d6cfcb"));
        eBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /* PANEL UNTUK ABOUT GAME */
        about = new JButton("About");

        about.setBackground(Color.decode("#e9f5db"));
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(center, "By Kelompok 8: \n 140810200008 - Anggie Forestry \n 140810200028 - Ananda S. Farell \n 140810200044 - Ade Dwi Fatwa S");
            }
        });

        /* PANEL UNTUK HELP GAME */
        helpBtn = new JButton("Help");

        helpBtn.setBackground(Color.decode("#e9f5db"));
        helpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(center, "Aturan dalam bermain Sudoku: \n 1. Pada baris harus di isi oleh angka-angka mulai dari 1-9 dan tidak boleh ada angka yang kembar dalam satu baris. \n 2. Pada kolom juga begitu harus di isi dengan angka-angka mulai dari 1-9 dan tidak boleh ada angka yang kembar dalam satu kolom. \n 3. Pada setiap bagian kotak area dengan ukuran 3 x 3 yang berisi 9 kotak-kotak kecil. Kotak kecil tersebut harus diisi dengan angka 1-9 dan syaratnya tidak boleh ada angka yang berulang pada setiap kotak area.");
            }
        });
        
        bPanel.add(hardBtn);   //add new game button to 
        bPanel.add(medBtn);
        bPanel.add(easyBtn);
        bPanel.add(cBtn);
        bPanel.add(resetBtn);
        bPanel.add(eBtn);

        aPanel.add(about);
        aPanel.add(helpBtn);

        add(aPanel, "North");
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
                    boxes[i][j].setBackground(Color.decode("#e9f5db"));
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
    
    public static void resetgame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boxes[i][j].setForeground(Color.black);
                boxes[i][j].setEditable(true);
                boxes[i][j].setBackground(Color.WHITE);
            }
        }
    }

}