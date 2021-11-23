package sudoku;

import javax.swing.JFrame;

public class Sudoku {

    static JFrame frame;
    static Tampilan p;
    
    public static void main(String[] args){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(320, 40);
        frame.setSize(650, 650);
        frame.setTitle("SUDOKU Project PBO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new Tampilan();
        frame.setContentPane(p);
        frame.setVisible(true);
    }
}