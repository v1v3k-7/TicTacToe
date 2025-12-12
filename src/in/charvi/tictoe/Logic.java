 
package in.charvi.tictoe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
  

public class Logic implements ActionListener, WindowListener{
    JFrame jf;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
    String str="";
    int count=0;
    String player1, player2, txt;
    String current="";
    boolean win=false;
    String winner="";
    int total_round, current_round=0;
    int player1_win=0, player2_win=0;
    int restart_count=0;
    JDialog dialogue;
    boolean button_clicked=false, restart=false;
    UserPanel up;
    
    Logic(UserPanel up, String player1, String player2, int total_round){
        this.player1=player1;
        this.total_round=total_round;
        this.player2=player2;
        this.up=up;
        current=player1;
        str="X";
    } 
    
    void createFrame() {
        jf=new JFrame(current+" turn ("+str+")");
        jf.setSize(700, 700);
        jf.setLayout(new GridLayout(3, 3));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jb1=new JButton();
        jb1.addActionListener(this);
        jf.add(jb1);
        
        jb2=new JButton();
        jb2.addActionListener(this);
        jf.add(jb2);
        
        jb3=new JButton();
        jb3.addActionListener(this);
        jf.add(jb3);
        
        jb4=new JButton();
        jb4.addActionListener(this);
        jf.add(jb4);
        
        jb5=new JButton();
        jb5.addActionListener(this);
        jf.add(jb5);
        
        jb6=new JButton();
        jb6.addActionListener(this);
        jf.add(jb6);
        
        jb7=new JButton();
        jb7.addActionListener(this);
        jf.add(jb7);
        
        jb8=new JButton();
        jb8.addActionListener(this);
        jf.add(jb8);
        
        jb9=new JButton();
        jb9.addActionListener(this);
        jf.add(jb9);
        
        jf.setVisible(true);
    }
    
    void clearInput(boolean restart_game) {
        count=0; 
        button_clicked=false;
        if(restart_game) {
            restart_count+=1;
            current_round=0;
            player1_win=0;
            player2_win=0;
            if(restart_count%2==0){
                current=player1;
                str="X";
            } else {
                current=player2;
                str="0";
            }
            
        } else {
            str=(str=="0")?"X":"0";
            current=winner;
            jf.setTitle(current+" turn ("+str+")");
    //        if(current!=player1){
    //            int temp=player1_win;
    //            player1_win=player2_win;
    //            player2_win=temp;
    //            player2=player1;
    //            player1=current;
    //        }
        }
       
        
        
        jb1.setText("");
        jb1.setBackground(null);
        jb1.setEnabled(true);
        jb2.setText("");
        jb2.setBackground(null);
        jb2.setEnabled(true);
        jb3.setText("");
        jb3.setBackground(null);
        jb3.setEnabled(true);
        jb4.setText("");
        jb4.setBackground(null);
        jb4.setEnabled(true);
        jb5.setText("");
        jb5.setBackground(null);
        jb5.setEnabled(true);
        jb6.setText("");
        jb6.setBackground(null);
        jb6.setEnabled(true);
        jb7.setText("");
        jb7.setBackground(null);
        jb7.setEnabled(true);
        jb8.setText("");
        jb8.setBackground(null);
        jb8.setEnabled(true);
        jb9.setText("");
        jb9.setBackground(null);
        jb9.setEnabled(true);
        
    }
    
    void gameDone() {
        current_round+=1;
        
        String pop=(win)?winner+" win":"Game Tie";
        if(win & winner.equals(player1)) player1_win+=1;
        else if(win & winner.equals(player2)) player2_win+=1;
        
        dialogue = new JDialog(jf, pop, true);
        dialogue.addWindowListener(this);
        dialogue.setSize(500, 350);
        dialogue.setLayout(null);
        dialogue.setLocationRelativeTo(jf);
        
        
        
        if(current_round==total_round) {
            restart=true;
            if (player1_win>player2_win) txt="🎉 "+player1+" Won";
            else if (player1_win<player2_win) txt="🎉 "+player2+" Won";
            else txt="🤝 Match Tie";
            JLabel jl_1=new JLabel(txt);
            jl_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 22));
            jl_1.setBounds(90, 30, 340, 40);
            dialogue.add(jl_1);
            JLabel jl_2=new JLabel(player1 + " => " + player1_win);
            jl_2.setFont(new Font("Tahoma", 1, 18));
            jl_2.setBounds(50, 100, 280, 40);
            dialogue.add(jl_2);
            JLabel jl_3=new JLabel(player2 + " => " + player2_win);
            jl_3.setFont(new Font("Tahoma", 1, 18));
            jl_3.setBounds(50, 160, 280, 40);
            dialogue.add(jl_3);

            JButton jb_1=new JButton("Restart");
            jb_1.setBounds(50, 230, 115, 50);
            jb_1.setFont(new Font("Tahoma", 1, 20));
            dialogue.add(jb_1);
            
            JButton jb_3=new JButton("Reset");
            jb_3.setBounds(170, 230, 115, 50);
            jb_3.setFont(new Font("Tahoma", 1, 20));
            dialogue.add(jb_3);

            JButton jb_2=new JButton("Close");
            jb_2.setBounds(290, 230, 115, 50);
            jb_2.setFont(new Font("Tahoma", 1, 20));
            dialogue.add(jb_2);



            jb_1.addActionListener(e -> {
                button_clicked=true;
                clearInput(restart);
                dialogue.dispose();
            });
            jb_3.addActionListener(e -> {
                dialogue.dispose();
                jf.dispose();
                up.resetGame();
            });
            jb_2.addActionListener(e -> {
                button_clicked=true;
                System.exit(0);

            });
            
        }
        else {
            restart=false;
            JLabel jl_1=new JLabel("Total Round = "+current_round+"/"+total_round);
            jl_1.setFont(new Font("Tahoma", 1, 20));
            jl_1.setBounds(70, 30, 350, 40);
            dialogue.add(jl_1);
            JLabel jl_2=new JLabel(player1+" (X) --> "+player1_win);
            jl_2.setFont(new Font("Tahoma", 1, 18));
            jl_2.setBounds(50, 80, 350, 40);
            dialogue.add(jl_2);
            JLabel jl_3=new JLabel(player2+" (0) --> "+player2_win);
            jl_3.setFont(new Font("Tahoma", 1, 18));
            jl_3.setBounds(50, 140, 350, 40);
            dialogue.add(jl_3);

            JButton jb_1=new JButton("Next Round");
            jb_1.setBounds(70, 200, 160, 50);
            jb_1.setFont(new Font("Tahoma", 1, 20));
            dialogue.add(jb_1);

            JButton jb_2=new JButton("Close");
            jb_2.setBounds(240, 200, 115, 50);
            jb_2.setFont(new Font("Tahoma", 1, 20));
            dialogue.add(jb_2);



            jb_1.addActionListener(e -> {
                button_clicked=true;
                clearInput(restart);
                dialogue.dispose();
            });
            jb_2.addActionListener(e -> {
                button_clicked=true;
                System.exit(0);

            });
        }
        
        
        dialogue.setVisible(true);
    }
    
    
    void winPossibility() {
        
        if (jb1.getText()==jb2.getText() && jb2.getText()==jb3.getText() && jb1.getText()!="") {
            win=true;
        } else if (jb4.getText()==jb5.getText() && jb5.getText()==jb6.getText() && jb4.getText()!="") {
            win=true;
        } else if (jb7.getText()==jb8.getText() && jb8.getText()==jb9.getText() && jb7.getText()!="") {
            win=true;
        } else if (jb1.getText()==jb4.getText() && jb4.getText()==jb7.getText() && jb4.getText()!="") {
            win=true;
        } else if (jb2.getText()==jb5.getText() && jb5.getText()==jb8.getText() && jb5.getText()!="") {
            win=true;
        } else if (jb3.getText()==jb6.getText() && jb6.getText()==jb9.getText() && jb3.getText()!="") {
            win=true;
        } else if (jb1.getText()==jb5.getText() && jb5.getText()==jb9.getText() && jb1.getText()!="") {
            win=true;
        } else if (jb3.getText()==jb5.getText() && jb5.getText()==jb7.getText() && jb3.getText()!="") {
            win=true;
        } else if(count==9) {
            JOptionPane.showMessageDialog(jf, "Match Tie");
            gameDone();
            
        } else {
            
        }
        
        if(win){
            winner=(current==player1)?player2:player1;
            JOptionPane.showMessageDialog(jf, winner+" Win");
            gameDone();
            win=false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        count+=1;
        
        Color color=(str=="X")?Color.RED:Color.YELLOW;
        
        if(ae.getSource()==jb1){
            int sz=(jb1.getWidth()*3)/4;
            jb1.setFont(new Font("Arial", 1, sz));
            jb1.setText(str);
            jb1.setBackground(color);
            jb1.setEnabled(false);
        } else if (ae.getSource()==jb2) {
            int sz=(jb1.getWidth()*3)/4;
            jb2.setFont(new Font("Arial", 1, sz));
            jb2.setText(str);
            jb2.setBackground(color);
            jb2.setEnabled(false);
        } else if (ae.getSource()==jb3) {
            int sz=(jb1.getWidth()*3)/4;
            jb3.setFont(new Font("Arial", 1, sz));
            jb3.setText(str);
            jb3.setBackground(color);
            jb3.setEnabled(false);
        } else if (ae.getSource()==jb4) {
            int sz=(jb1.getWidth()*3)/4;
            jb4.setFont(new Font("Arial", 1, sz));
            jb4.setText(str);
            jb4.setBackground(color);
            jb4.setEnabled(false);
        } else if (ae.getSource()==jb5) {
            int sz=(jb1.getWidth()*3)/4;
            jb5.setFont(new Font("Arial", 1, sz));
            jb5.setText(str);
            jb5.setBackground(color);
            jb5.setEnabled(false);
        } else if (ae.getSource()==jb6) {
            int sz=(jb1.getWidth()*3)/4;
            jb6.setFont(new Font("Arial", 1, sz));
            jb6.setText(str);
            jb6.setBackground(color);
            jb6.setEnabled(false);
        } else if (ae.getSource()==jb7) {
            int sz=(jb1.getWidth()*3)/4;
            jb7.setFont(new Font("Arial", 1, sz));
            jb7.setText(str);
            jb7.setBackground(color);
            jb7.setEnabled(false);
        } else if (ae.getSource()==jb8) {
            int sz=(jb1.getWidth()*3)/4;
            jb8.setFont(new Font("Arial", 1, sz));
            jb8.setText(str);
            jb8.setBackground(color);
            jb8.setEnabled(false);
        } else if (ae.getSource()==jb9) {
            int sz=(jb1.getWidth()*3)/4;
            jb9.setFont(new Font("Arial", 1, sz));
            jb9.setText(str);
            jb9.setBackground(color);
            jb9.setEnabled(false);
        } 
       
        
        
        
            
        
        str=("0".equals(str))?"X":"0";
        current=(current.equals(player1))?player2:player1;
        
       
        winPossibility();
        jf.setTitle(current+" turn ("+str+")");
    }

    
    
    @Override
    public void windowOpened(WindowEvent we) {
        
    }
 
    @Override
    public void windowClosing(WindowEvent we) {
        if(we.getSource()==dialogue && !button_clicked) {
           System.out.println("Dialogue Closed");
           clearInput(restart);
       }
    }

    @Override
    public void windowClosed(WindowEvent we) {
       
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
    
}
