/*
* Created By Vivek Kumar
 */
package in.charvi.tictoe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class UserPanel implements ActionListener{

    JFrame jf;
    JTextField jt1, jt2;
    JButton jb1;
    JComboBox<String> jc1;
    
    UserPanel() {
        jf=new JFrame("TicToe Game By Vivek");
        jf.setSize(700, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        
        JLabel jl1=new JLabel("TicToe  Game");
        jl1.setBounds(250, 30, 300, 40);
        jl1.setFont(new Font("Tahoma", 1, 22));
        jf.add(jl1);
        
        JLabel jl2=new JLabel("Player 1 Name (X):");
        jl2.setBounds(50, 110, 200, 30);
        jl2.setFont(new Font("Tahoma", 1, 18));
        jf.add(jl2);
        jt1=new JTextField("");
        jt1.setBounds(250, 110, 380, 40);
        jt1.setFont(new Font("Tahoma", 1, 18));
        jf.add(jt1);
        
        JLabel jl3=new JLabel("Player 2 Name (0):");
        jl3.setBounds(50, 180, 200, 30);
        jl3.setFont(new Font("Tahoma", 1, 18));
        jf.add(jl3);
        jt2=new JTextField("");
        jt2.setBounds(250, 180, 380, 40);
        jt2.setFont(new Font("Tahoma", 1, 18));
        jf.add(jt2);
        
        JLabel jl4=new JLabel("Total Round:");
        jl4.setBounds(50, 260, 200, 30);
        jl4.setFont(new Font("Tahoma", 1, 18));
        jf.add(jl4);
        String[] rounds={"1", "3", "5", "7"};
        jc1=new JComboBox<>(rounds);
        jc1.setBounds(250,260, 100, 40);
        jc1.setFont(new Font("Tahoma", 1, 18));
        jf.add(jc1);
        
        jb1=new JButton("Start Game");
        jb1.setBounds(230, 330, 200, 60);
        jb1.setFont(new Font("Tahoma", 1, 22));
        jb1.addActionListener(this);
        jf.add(jb1);
        
        jf.setVisible(true);
                
    } 
    
    public void resetGame() {
        jt1.setText("");
        jt2.setText("");
        jf.setVisible(true);   
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jb1){
            if(jt1.getText().isEmpty() || jt2.getText().isEmpty() || jc1.getSelectedItem()==null ) {
                JOptionPane.showMessageDialog(jf, "Please Enter Name of both Player & choose rounds.");
            } else {
                int rounds=Integer.parseInt(jc1.getSelectedItem().toString());
                Logic game = new Logic(this, jt1.getText(), jt2.getText(), rounds);
                game.createFrame();
                jf.setVisible(false);
                
            }
        }
    }
    
}
