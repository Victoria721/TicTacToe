//Victoria Caruso
//CS200
//TicTacToe
//5.10.22

import javax.swing.*;
import java.util.Objects;

public class TTTCell extends JButton {

    //attributes
    private Boolean isOccupied;
    private Character X_or_O;

    //constructors

    public TTTCell()
    {
        X_or_O = null;
        isOccupied = false;
    }

    public TTTCell(Icon icon) {
        super(icon);
    }

    public TTTCell(String text) {
        super(text);
    }

    public TTTCell(Action a) {
        super(a);
    }

    public TTTCell(String text, Icon icon) {
        super(text, icon);
    }

    public TTTCell(Boolean isOccupied, Character x_or_O)
    {
        this.isOccupied = isOccupied;
       X_or_O = x_or_O;
    }

    //Getters and Setters

    public Boolean getOccupied()
    {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied)
    {
     //   isOccupied = occupied;
    }

    public Character getX_or_O()
    {
        return X_or_O;
    }

    public void setX_or_O(Character x_or_O)
    {
        X_or_O = x_or_O;
    }

    //Methods

  //  @Override
//    public String toString()
//    {
//        return "TTTCell: " +
//                "isOccupied: " + isOccupied +
//                ", X_or_O: " + X_or_O;
//    }

//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TTTCell tttCell = (TTTCell) o;
//        return Objects.equals(isOccupied, tttCell.isOccupied) && Objects.equals(X_or_O, tttCell.X_or_O);
//    }


}
