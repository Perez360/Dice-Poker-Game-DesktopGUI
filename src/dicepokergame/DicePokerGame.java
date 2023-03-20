package dicepokergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public final class DicePokerGame extends JFrame implements ActionListener, PokerInterface{

    private JLabel attemptLabel;
    private JLabel backLabel;
    private JLabel betPlacedLabel;
    private JTextField betPlacedText;
    private JPanel changeRewardPanel;
    private JLabel currentWalletLabel;
    private javax.swing.JLabel gamePicLabel;
    private JTable highScoreTable;
    private JLabel identicalLabel;
    private JTextField identicalText;
    private JPanel infoPanel;
    private JScrollPane scrollTable;
    private JPanel mainPanel;
    private static JLabel playerNameLabel;
    private JButton rollDiceButton;
    private JLabel sequentialLabel;
    private static JTextField sequentialText;
    static int totalWallet = 60;
    private int FisrtDice = 0;
    private int SecondDice = 0;
    private int[] dicesInArray;
    private Random random;
    private int attempt = 5;
    private int identicalReward = 2;
    private int sequentialReward = 3;
    private static String stakeAmount = "";
    private static int getStakeAmount;
    static String playerName;
    private int calc = 0;

    public DicePokerGame() {
        setSize(625, 458);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dice Poker Game");
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(102, 102, 255));
        setResizable(false);

        initComponents();
        setVisible(true);

        yourNameMethod();
        betAmount();
        checkWallet(totalWallet);

    }

    private void initComponents() {

        mainPanel = new JPanel();
        infoPanel = new JPanel();
        playerNameLabel = new JLabel();
        currentWalletLabel = new JLabel();
        gamePicLabel = new JLabel();
        betPlacedLabel = new JLabel();
        betPlacedText = new JTextField();
        changeRewardPanel = new JPanel();
        identicalText = new JTextField();
        identicalLabel = new JLabel();
        sequentialLabel = new JLabel();
        sequentialText = new JTextField();
        scrollTable = new JScrollPane();
        highScoreTable = new JTable();
        rollDiceButton = new JButton();
        backLabel = new JLabel();
        attemptLabel = new JLabel();

        mainPanel.setBackground(new Color(153, 0, 255));
        mainPanel.setLayout(null);

        infoPanel.setBackground(new Color(153, 0, 255));
        infoPanel.setBorder(BorderFactory.createTitledBorder(null, "Player Info", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", 1, 12), new Color(255, 255, 0)));
        infoPanel.setForeground(new Color(255, 255, 255));

        playerNameLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        playerNameLabel.setForeground(new Color(255, 255, 255));
        playerNameLabel.setText("Player Name:");

        currentWalletLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        currentWalletLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentWalletLabel.setText("Current Wallet: ");

        gamePicLabel.setIcon(new ImageIcon("wan.png"));

        betPlacedLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        betPlacedLabel.setForeground(new Color(255, 255, 255));
        betPlacedLabel.setText("Current Bet Placed:");
        try {
            javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
            infoPanel.setLayout(infoPanelLayout);
            infoPanelLayout.setHorizontalGroup(
                    infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(currentWalletLabel)
                                            .addComponent(playerNameLabel)
                                            .addGroup(infoPanelLayout.createSequentialGroup()
                                                    .addComponent(betPlacedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(betPlacedText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(27, 27, 27)
                                    .addComponent(gamePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            infoPanelLayout.setVerticalGroup(
                    infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(playerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(currentWalletLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(betPlacedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(betPlacedText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
                            .addComponent(gamePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            );

            mainPanel.add(infoPanel);
            infoPanel.setBounds(0, 0, 290, 150);

            changeRewardPanel.setBackground(new java.awt.Color(153, 0, 255));
            changeRewardPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change reward for:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 51))); // NOI18N

            identicalLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
            identicalLabel.setForeground(new java.awt.Color(255, 255, 255));
            identicalLabel.setText("Identical Outcome:");

            sequentialLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
            sequentialLabel.setForeground(new java.awt.Color(255, 255, 255));
            sequentialLabel.setText("Sequential Outcome:");

            javax.swing.GroupLayout changeRewardPanelLayout = new javax.swing.GroupLayout(changeRewardPanel);
            changeRewardPanel.setLayout(changeRewardPanelLayout);
            changeRewardPanelLayout.setHorizontalGroup(
                    changeRewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeRewardPanelLayout.createSequentialGroup()
                                    .addGroup(changeRewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(identicalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sequentialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(31, 31, 31)
                                    .addGroup(changeRewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(identicalText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sequentialText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
            );
            changeRewardPanelLayout.setVerticalGroup(
                    changeRewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(changeRewardPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(changeRewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(identicalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(changeRewardPanelLayout.createSequentialGroup()
                                                    .addComponent(identicalText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(changeRewardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(sequentialText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sequentialLabel))
                                    .addGap(151, 151, 151))
            );

            mainPanel.add(changeRewardPanel);
            changeRewardPanel.setBounds(0, 150, 290, 120);

            identicalText.setFont(new Font("Comic Sans MS", 2, 18));

            sequentialText.setFont(new Font("Comic Sans MS", 2, 18));

            rollDiceButton.setBackground(new Color(255, 255, 0));
            rollDiceButton.setText("ROLL DICES");
            mainPanel.add(rollDiceButton);
            rollDiceButton.setBounds(90, 320, 120, 35);
            rollDiceButton.setFont(new Font("Comic Sans MS", 2, 15));
            rollDiceButton.addActionListener(this);

            backLabel.setIcon(new ImageIcon("wan.png"));
            mainPanel.add(backLabel);
            backLabel.setBounds(290, -0, 320, 420);
            Image i = new ImageIcon("wan.png").getImage().getScaledInstance(backLabel.getSize().width + 20, backLabel.getSize().height, Image.SCALE_SMOOTH);
            backLabel.setIcon(new ImageIcon(i));

            attemptLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // 
            attemptLabel.setForeground(new java.awt.Color(255, 255, 0));
            attemptLabel.setText("Attempt Left:");
            mainPanel.add(attemptLabel);
            attemptLabel.setBounds(10, 270, 200, 30);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void betAmount() {

        do {
            stakeAmount = JOptionPane.showInputDialog(null, "Stake not less than €10\nand not more than your Total Wallet ( €60 )\nPlease Enter your Stake Amount\nPlease input only numbers", "Stake", JOptionPane.YES_NO_CANCEL_OPTION);
            if (stakeAmount == null) {
                int answer = JOptionPane.showConfirmDialog(null, "Do you want to Exit the Application", "Exit", JOptionPane.YES_NO_OPTION);
                if (answer == 0) {
                    System.exit(0);
                } else {
                    if (stakeAmount == null) {
                        stakeAmount = "";
                    }
                }
            }

        } while ((!stakeAmount.matches("[0-9]+") && Integer.valueOf(getStakeAmount) < 10) || Integer.valueOf(stakeAmount) > 50);

        getStakeAmount = Integer.valueOf(stakeAmount);
        //totalWallet -= getStakeAmount;
        currentWalletLabel.setText("Current Wallet: €" + totalWallet);
        betPlacedText.setText(String.valueOf(getStakeAmount));
        betPlacedText.setFont(new Font("Comic Sans MS", 2, 18));
        attemptLabel.setText("Attempt Left: " + attempt);
        identicalText.setText(String.valueOf(identicalReward));
        sequentialText.setText(String.valueOf(sequentialReward));
    }

    @Override
    public void checkWallet(int totAmount) {
        if (totAmount < 10) {
            currentWalletLabel.setForeground(new Color(255, 0, 0));
            JOptionPane.showMessageDialog(null, "You have Exceeded your Wallet", "Low Balance", JOptionPane.INFORMATION_MESSAGE);
            if (totalWallet < 10) {
                int ans = JOptionPane.showConfirmDialog(null, playerName + ", Your Account is insufficient to Bet\nWould you like to Start Game", "Low Balance", JOptionPane.YES_NO_OPTION);
                if (ans == 0) {
                    new DicePokerGame();
                    dispose();

                } else {
                    System.exit(0);
                }
            }

        }
    }

    @Override
    public void yourNameMethod() {
        do {
            playerName = JOptionPane.showInputDialog(null, "Please make sure you enter your name before \nyou can play the Game", "Player Name", JOptionPane.YES_NO_OPTION);
            if (playerName == null) {
                int r = JOptionPane.showConfirmDialog(null, "Do you want to exit Application", "Exit", JOptionPane.YES_NO_OPTION);
                if (r == 0) {
                    System.exit(0);
                }
            }
        } while ("".equals(playerName) || playerName == null);

        if (playerName.matches("[0-9]+")) {
            playerNameLabel.setText("Player Name: Player" + playerName);
            currentWalletLabel.setText(String.valueOf("Current Wallet: €" + totalWallet));
        } else {
            playerNameLabel.setText("Player Name: " + playerName);
            currentWalletLabel.setText(String.valueOf("Current Wallet: €" + totalWallet));
        }

    }

    @Override
    public void shuffleDices(int firstDice, int secondDice
    ) {
        this.random = new Random();
        firstDice = random.nextInt(6) + 1;
        secondDice = random.nextInt(6) + 1;

        //instancing an Array of length two to contain the two Dices
        dicesInArray = new int[2];

        //Assigning each index of the array to Outcome of the Two Dices respectively.
        dicesInArray[0] = firstDice;
        dicesInArray[1] = secondDice;

    }

    public void IdenticalCheckDice(int a, int b) {
        if (a == b) {//check for Identical OutCome

            //Assigning the Triple of the Amount Stake win to the identicalDiceBonus variable.
            calc = (Integer.valueOf(identicalText.getText())) * (Integer.valueOf(betPlacedText.getText()));

            //Using the Addition Assignment Operator to reAssign the Wallet;
            totalWallet -= Integer.valueOf(betPlacedText.getText()) - calc;
            currentWalletLabel.setText("Current Wallet: €" + totalWallet);

            //Displaying of the OutCome And the Winning bonus.
            JOptionPane.showMessageDialog(null, String.valueOf("FIRST DICE: " + a + "\nSECOND DICE: " + b + "\nCongratulations,\nYou have Won the Bet for Identical Ocurrannce of dices.\n€" + calc + " has been added to your Wallet"), "IDENTICAL DICES", JOptionPane.INFORMATION_MESSAGE);
            attemptLabel.setText("Attempt Left: " + attempt);

        }

    }

    public void NoRequiredOutComeCheck(int a, int b) {
        if (a != b && ((a - b) != 1) && ((b - a) != 1)) {
            totalWallet = totalWallet - Integer.valueOf(betPlacedText.getText());
            //calc=totalWallet - Integer.valueOf(betPlacedText.getText());
            currentWalletLabel.setText("Current Wallet: €" + (totalWallet));

            JOptionPane.showMessageDialog(null, String.valueOf("FIRST DICE: " + a + "\nSECOND DICE: " + b + "\nSorry,\nYou have Lost the Bet, Your Current Balance is: €" + totalWallet), "LOSS", JOptionPane.INFORMATION_MESSAGE);
            attemptLabel.setText("Attempt Left: " + attempt);

        }
    }

    @Override
    public void SequentialDiceCheck(int a, int b) {
        if (a - b == 1 || b - a == 1) {
            //Assigning the Double of the Amount Stake win to the SequentialBonus variable.
            //(Integer.valueOf(betPlacedText.getText()))*=(Integer.valueOf(sequentialText.getText()));
            calc = (int) (Integer.valueOf(betPlacedText.getText())) * (Integer.valueOf(sequentialText.getText()));
            //Using the Addition Assignment Operator to reAssign the Wallet;
            totalWallet -= Integer.valueOf(betPlacedText.getText()) - calc;
            //loadDices();
            currentWalletLabel.setText("Current Wallet: €" + (totalWallet));

            JOptionPane.showMessageDialog(null, String.valueOf("FIRST DICE: " + a + "\nSECOND DICE: " + b + "\nCongratulations, You have Won the Bet for Sequential Occurance of dices.\n€" + calc + " has been added to your Wallet"), "SEQUENCIAL DICES", JOptionPane.INFORMATION_MESSAGE);
            attemptLabel.setText("Attempt Left: " + attempt);
        }
    }

    @Override
    public void RestartGame() {
        if (attempt == 0) {
            new Table();
            if (!new Table().isVisible()) {
                int ans = JOptionPane.showConfirmDialog(null, playerName + ", Your chances for Playing Game is Over\nWould you like to play Again", "Game Over", JOptionPane.DEFAULT_OPTION);
                if (ans == 0) {
                    attempt = 5;
                    totalWallet = 50;
                    yourNameMethod();
                    betAmount();
                    IdenticalCheckDice(dicesInArray[0], dicesInArray[1]);
                    SequentialDiceCheck(dicesInArray[0], dicesInArray[1]);
                    NoRequiredOutComeCheck(dicesInArray[0], dicesInArray[1]);
                } else {
                    System.exit(0);
                }
                new DicePokerGame();
            }

        }

    }

    public static void LookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (Exception ex) {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;

                    }
                }
            } catch (Exception yex) {

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rollDiceButton) {
            try {
                if ((Integer.valueOf(betPlacedText.getText()) > totalWallet)) {
                    JOptionPane.showMessageDialog(null, "Stake Less than your Wallet", "invalid", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    if (!(betPlacedText.getText().matches("[0-9]+")) || !(identicalText.getText().matches("[0-9]+")) || !(sequentialText.getText().matches("[0-9]+"))) {
                        JOptionPane.showMessageDialog(null, "Please make sure all Fileds are filled with values (Integers only)", "Null field(s)", JOptionPane.INFORMATION_MESSAGE);
                    } else if (betPlacedText.getText().equals("0")) {
                        JOptionPane.showMessageDialog(null, "Your Amount of Stake is Below Requirement", "Stake High", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (totalWallet < 10) {
                            int ans = JOptionPane.showConfirmDialog(null, playerName + ", Your Account is insufficient to Bet\nWould you like to Start Game", "Low Balance", JOptionPane.YES_NO_OPTION);
                            if (ans == 0) {
                                new DicePokerGame();
                                dispose();

                            } else {
                                System.exit(0);
                            }
                        }
                        shuffleDices(FisrtDice, SecondDice);
                        attempt -= 1;
                        IdenticalCheckDice(dicesInArray[0], dicesInArray[1]);
                        SequentialDiceCheck(dicesInArray[0], dicesInArray[1]);
                        NoRequiredOutComeCheck(dicesInArray[0], dicesInArray[1]);
                    }
                    if (attempt == 1) {
                        attemptLabel.setText("Only " + attempt + " Attempt Left");

                    }
                    if(attempt==0 || totalWallet<10){
                        JOptionPane.showMessageDialog(null, "HighScore\n"+playerName+" Your total bet Won is: "+totalWallet+" in "+5+" attempts","Game Over",JOptionPane.INFORMATION_MESSAGE);
                    }

                    RestartGame();

                }

            } catch (Exception er) {
                try {
                    throw new Exception("hiiii");
                } catch (Exception ex) {
                    Logger.getLogger(DicePokerGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        LookAndFeel();

        new DicePokerGame();

    }

}
