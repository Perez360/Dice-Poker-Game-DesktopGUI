package dicepokergame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame {

    JTable highScoreTable;
    JScrollPane pane;

    Table() {
        setSize(625, 458);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dice Poker Game");
        setLocationRelativeTo(null);
        setBackground(new Color(102, 102, 255));
        setResizable(false);

        highScoreTable = new JTable();
        pane = new JScrollPane();

        highScoreTable.setBackground(new java.awt.Color(102, 102, 255));
        highScoreTable.setShowGrid(true);
        highScoreTable.setVisible(false);
        highScoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        highScoreTable.setShowGrid(true);
        highScoreTable.setModel(new DefaultTableModel(
                new Object[][]{
                    {DicePokerGame.playerName, "lkhgjfjggc"}}, new String[]{"Player Name", "Highest Score"}));
        highScoreTable.setFont(new Font("Arial", 2, 20));
        highScoreTable.setForeground(Color.white);

        pane.setViewportView(highScoreTable);
        this.add(pane);
        pane.setBounds(290, 150, 330, 270);
    }
}
