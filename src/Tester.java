//Victoria Caruso
//CS200
//TicTacToe
//5.10.22

import javax.swing.*;

public class Tester { 

    public static void main(String[] args) {
        TTTBoard myBoard = new TTTBoard();
        myBoard.setTitle("Tic Tac Toe by Victoria Caruso");
        myBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBoard.setVisible(true);
    }
}
