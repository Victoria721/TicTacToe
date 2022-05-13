//Victoria Caruso
//CS200
//TicTacToe
//5.10.22

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTBoard extends JFrame {

    //attributes
    private TTTCell[][] cells = new TTTCell[3][3];
    private JPanel  TTTCellPanel;
    private JButton gameRestart;
    private JButton victor;

    private Boolean playerA;
    private JButton playerAScore;
    private JButton playerBScore;
    private int scoreA;
    private int scoreB;

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 700;

    //constructor
    public TTTBoard() throws HeadlessException {

        TTTCellPanel = new JPanel();
        add(TTTCellPanel, BorderLayout.CENTER);
        victor = new JButton("Would you like to play a game?");
        victor.setFont(new Font("Arial", Font.BOLD, 15));
        scoreA = 0;
        scoreB = 0;
        playerAScore = new JButton("Player A: " + scoreA);
        playerAScore.setFont(new Font("Arial", Font.BOLD, 15));
        playerBScore = new JButton("Player B: " + scoreB);
        playerBScore.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel controlCell = new JPanel();//To handle the X,O cells
        JPanel gameControl = new JPanel();//To handle the game restart and selections
        JPanel titleControl = new JPanel();//To handle the score and let the player knows who wins
        controlCell.setLayout(new GridLayout(3, 3));
        ActionListener listen = new XOListener();
        int i = 0;
        int j = 0;
        for(TTTCell[] row : cells){
            for (TTTCell c : row ){
                c = new TTTCell("");
                c.setFont(new Font("Arial", Font.BOLD, 96));
                controlCell.add(c);
                c.addActionListener(listen);
                cells[i][j] = c;
                ++j;
            }
            j=0;
            ++i;
        }


        gameRestart = new JButton("Restart Game");

        gameControl.add(gameRestart);
        titleControl.add(playerAScore);
        titleControl.add(victor);
        titleControl.add(playerBScore);

        add(titleControl,BorderLayout.NORTH);
        add(controlCell, BorderLayout.CENTER);
        add(gameControl, BorderLayout.SOUTH);

        gameRestart.addActionListener(listen);

        playerA = true;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    //private class
    //This Listener handles each cell, changes the X of O, updates whose turn it is and will check to see if a row becomes a victory condition by calling testRow()
    private class XOListener implements ActionListener{

        public void actionPerformed(ActionEvent me) {
            if(me.getSource() instanceof TTTCell ) {

                for (TTTCell[] row : cells) {
                    for (TTTCell b : row) {
                        if (me.getSource() == b) {
                            if (playerA) {
                                b.setText("X");
                                b.setOccupied(true);
                                b.setX_or_O('X');
                                b.setEnabled(false);
                                playerA = false;
                                if (testRow()) {
                                    winnerAnnounce("A");
                                    disableCells(cells);
                                }
                            } else {
                                b.setText("O");
                                b.setEnabled(false);
                                b.setOccupied(true);
                                b.setX_or_O('O');
                                playerA = true;
                                if (testRow()) {
                                    winnerAnnounce("B");
                                    disableCells(cells);
                                }
                            }
                        }
                    }
                }
            }else if(me.getActionCommand()== "Restart Game"){
                int i = 0;
                int j = 0;
                for(TTTCell[] row : cells){
                    for (TTTCell c : row ){
                        c.setText("");
                        c.setOccupied(false);
                        c.setX_or_O(null);
                        ++j;
                    }
                    j=0;
                    ++i;
                }
                enableCells(cells);
                playerA = true;
                victor.setText("New Game Started!");
            }
        }
    }
    public void disableCells(TTTCell[][] mycells){
        for(TTTCell[] row : mycells){
            for(TTTCell c : row){
                c.setEnabled(false);
            }
        }
    }
    public void enableCells(TTTCell[][] mycells) {
        for (TTTCell[] row : mycells) {
            for (TTTCell c : row) {
                c.setEnabled(true);
            }
        }
    }
    //Methods
    //This method announces the winner by setting the text in the banner object named victor
    public void winnerAnnounce(String winner){
        if(winner == "A"){
            victor.setText("Player A wins!! Click Restart!");
            scoreA++;
            playerAScore.setText("Player A: " + scoreA);
        }
        if(winner == "B"){
            victor.setText("Player B wins!! Click Restart!");
            scoreB++;
            playerBScore.setText("Player B: " + scoreB);
        }
    }
    ///This method checks all possible victory conditions
    public  Boolean testRow() { 
        if(cells[0][0].getText().equals(cells[0][2].getText()) && cells[0][3].getText().equals(cells[0][2]) && (!cells[0][0].getText().isEmpty() && !cells[0][1].getText().isEmpty() && !cells[0][2].getText().isEmpty()))  {
            return true; //123
        } else if(cells[1][0].getText().equals(cells[1][1].getText()) && cells[1][0].getText().equals(cells[1][2].getText()) && (!cells[1][0].getText().isEmpty() && !cells[1][1].getText().isEmpty() && !cells[1][2].getText().isEmpty())) {
            return true; //456
        } else if(cells[2][0].getText().equals(cells[2][1].getText()) && cells[2][0].getText().equals(cells[2][2].getText()) && (!cells[2][0].getText().isEmpty() && !cells[2][1].getText().isEmpty() && !cells[2][2].getText().isEmpty())) {
            return true; //789
        } else if(cells[0][0].getText().equals(cells[1][1].getText()) && cells[0][0].getText().equals(cells[2][2].getText()) && (!cells[0][0].getText().isEmpty() && !cells[1][1].getText().isEmpty() && !cells[2][2].getText().isEmpty())) {
            return true; //159
        } else if(cells[0][1].getText().equals(cells[1][1].getText()) && cells[0][1].getText().equals(cells[2][1].getText())&& (!cells[1][1].getText().isEmpty() && !cells[0][1].getText().isEmpty() && !cells[2][1].getText().isEmpty())) {
            return true; //258
        } else if(cells[0][2].getText().equals(cells[1][2].getText()) && cells[0][2].getText().equals(cells[2][2].getText())&& (!cells[0][2].getText().isEmpty() && !cells[1][2].getText().isEmpty() && !cells[2][2].getText().isEmpty())) {
            return true; //369
        } else if(cells[0][0].getText().equals(cells[1][0].getText()) && cells[0][0].getText().equals(cells[2][0].getText())&& (!cells[1][0].getText().isEmpty() && !cells[0][0].getText().isEmpty() && !cells[2][0].getText().isEmpty())) {
            return true; //147
        } else if(cells[0][2].getText().equals(cells[1][1].getText()) && cells[0][2].getText().equals(cells[2][0].getText())&& (cells[0][2].getText().isEmpty() && !cells[1][1].getText().isEmpty() && !cells[2][0].getText().isEmpty())) {
            return true; //357
        }
        else{
            return false;
     }
    }

}
