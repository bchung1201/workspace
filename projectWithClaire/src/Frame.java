import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Frame extends JFrame{
    public Frame(){
        Color myGreen= new Color (112,162,117,255);
        setVisible(true);
        setResizable(false);
        setSize(700,700);
        setLayout(new GridLayout(8, 8, 1, 1));
        getContentPane().setBackground(Color.BLACK);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel panel = new JPanel();
                panel.setBackground(myGreen);
                add(panel);
            }
        }
        JButton button= new JButton();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                button.setBackground (Color.YELLOW);
            }
        });
        add(button);


    }
}