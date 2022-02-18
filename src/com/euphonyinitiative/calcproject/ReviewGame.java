package com.euphonyinitiative.calcproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static com.euphonyinitiative.calcproject.CalcProject.*;

public class ReviewGame extends JFrame implements ActionListener {

    final JFrame frame;

    final JPanel panel;

    final Graph graph;

    final JLabel buttonLabel;
    final JLabel livesLabel;
    final JLabel scoreLabel;

    final JButton button1, button2, button3, button4;

    final int equationType;

    final HashMap<String, Line> lineMap;

    int score;
    int lives;

    boolean doingQuestion;

    String correct;
    String wrong1;
    String wrong2;
    String wrong3;

    Random random;

    public ReviewGame(int equationType) {

        this.equationType = equationType;

        if(equationType == PARENT) lineMap = CalcProject.genParentMap();
        else if (equationType == DERIVATIVE) lineMap = CalcProject.genDerivativeMap();
        else if (equationType == INTEGRAL) lineMap = CalcProject.genIntegralMap();
        else lineMap = null;

        score = 0;
        lives = 3;

        random = new Random();

        frame = new JFrame("Stephen and Cy's Review Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 480);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);

        buttonLabel = new JLabel();
        if(equationType == PARENT) buttonLabel.setText("Choose Equation: ");
        else if (equationType == DERIVATIVE) buttonLabel.setText("Derivative of: ");
        else if (equationType == INTEGRAL) buttonLabel.setText("Integral of: ");

        livesLabel = new JLabel("Lives: " + lives);

        scoreLabel = new JLabel("Score: " + score);

        button1 = new JButton("Option 1");
        button2 = new JButton("Option 2");
        button3 = new JButton("Option 3");
        button4 = new JButton("Option 4");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        panel.add(buttonLabel);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(livesLabel);
        panel.add(scoreLabel);

        graph = new Graph(new Line((x) -> 0, -5, 5, -5, 5, 0.1));

        frame.getContentPane().add(BorderLayout.WEST, panel);
        frame.getContentPane().add(BorderLayout.CENTER, graph);
        frame.setVisible(true);

        doQuestion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(doingQuestion) {

            doingQuestion = false;

            if(e.getActionCommand().equals(correct)) score += 1;
            else lives -= 1;

            livesLabel.setText("Lives: " + lives);
            scoreLabel.setText("Score: " + score);

            if(lives > 0) doQuestion();
            else {
                JOptionPane.showMessageDialog(this, "Game over!\nYour final score was: " + score);
            }
        }
    }

    private void doQuestion() {

        doingQuestion = true;

        ArrayList<String> keys = new ArrayList<>(lineMap.keySet());

        correct = keys.remove(random.nextInt(keys.size()));
        wrong1 = keys.remove(random.nextInt(keys.size()));
        wrong2 = keys.remove(random.nextInt(keys.size()));
        wrong3 = keys.remove(random.nextInt(keys.size()));

        ArrayList<String> lines = new ArrayList<>();
        lines.add(correct);
        lines.add(wrong1);
        lines.add(wrong2);
        lines.add(wrong3);

        button1.setText(lines.remove(random.nextInt(lines.size())));
        button2.setText(lines.remove(random.nextInt(lines.size())));
        button3.setText(lines.remove(random.nextInt(lines.size())));
        button4.setText(lines.remove(random.nextInt(lines.size())));

        graph.setLine(lineMap.get(correct));
    }
}
