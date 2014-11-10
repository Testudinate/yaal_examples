import javax.swing.*;
import java.awt.*;

/**
 * Оставляем пустые ячейки при добавлении компонентов в GridLayout.
 */
public class GridLayoutEmpty {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridLayoutRandomFrame();
            }
        });
    }
}

class GridLayoutRandomFrame extends JFrame {
    GridLayoutRandomFrame() throws HeadlessException {
        JTextField text = new JTextField("Введите что-нибудь :)");

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 2));
        gridPanel.add(new JLabel("Номер карты:"));
        gridPanel.add(new JPanel());

        gridPanel.add(new JLabel("Номинал:"));
        gridPanel.add(new JPanel());

        gridPanel.add(new JPanel());
        gridPanel.add(new JButton("ПЕЧАТЬ"));

        setLayout(new BorderLayout());
        setSize(500, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        add(text, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
    }
}