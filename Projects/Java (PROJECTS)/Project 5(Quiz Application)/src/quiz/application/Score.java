
package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Score extends JFrame implements ActionListener{
    JButton submit,back;
    Score(String name,int score)
    {
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2=i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,200,300, 250);
        add(image);
        
        JLabel heading  = new JLabel("Thank You !!"+ name +" for playing simple Minds!!");
        heading.setBounds(45,30,700,80);
        heading.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(heading);
        
        JLabel lblscore  = new JLabel("Your score is " +score);
        lblscore.setBounds(350,200,300,30);
        lblscore.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(lblscore);
        
        submit = new JButton("Play Again");
        submit.setBounds(380,270,150,30);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(0,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit); 
        
        back = new JButton("Close");
        back.setBounds(550,270,150,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,22));
        back.setBackground(new Color(0,144,255));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back); 
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit){
            setVisible(false);
        new Login();
        }
        else
        {
            setVisible(false);
        }
        
       
    }
    public static void main(String[] args) {
        new Score("User",0);
    }
    
}
