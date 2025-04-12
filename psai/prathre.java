import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Lucky7Game extends Frame implements ActionListener {
    Label label;
    Button play;
    Random rand;

    Lucky7Game() {
        setLayout(new FlowLayout());
        label = new Label("Click to play Lucky 7!");
        play = new Button("Play");
        rand = new Random();

        add(label);
        add(play);

        play.addActionListener(this);

        setSize(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int num = rand.nextInt(10);
        if (num == 7)
            label.setText("You Win! Lucky Number: " + num);
        else
            label.setText("Try Again. You got: " + num);
    }
}


class TicTacToe extends Frame implements ActionListener {
    Button[] buttons = new Button[9];
    char turn = 'X';

    TicTacToe() {
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button("");
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setSize(300, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        if (b.getLabel().equals("")) {
            b.setLabel(String.valueOf(turn));
            turn = (turn == 'X') ? 'O' : 'X';
        }
    }

   
}

public class prathre {
     public static void main(String[] args) {
        new TicTacToe();
    }
}
