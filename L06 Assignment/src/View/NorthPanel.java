package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NorthPanel extends JPanel
{
    private JTextField jtf;
    
    public NorthPanel()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);
        
        JLabel title = new JLabel();
        title.setText("PSU Football Roster");
        title.setOpaque(true);
        title.setBackground(Color.DARK_GRAY);
        title.setForeground(Color.white);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(40.0f));
        
        jtf = new JTextField();
        jtf.setFont(jtf.getFont().deriveFont(25.0f));
        jtf.setColumns(20);
        
        JLabel clear = new JLabel();
        clear.setOpaque(true);
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
        clear.setFont(clear.getFont().deriveFont(25.0f));
        clear.setText("Find Player (Selection): ");
        
        gbc.gridx=0;
        gbc.gridy=0;
        add(title, gbc);
        
        gbc.gridy++;
        gbc.gridy++;
        add(clear, gbc);
        
        gbc.gridy++;
        add(jtf, gbc);
    }

    public JTextField getJtf() {
        return jtf;
    }

    public void setJtf(JTextField jtf) {
        this.jtf = jtf;
    }
}
