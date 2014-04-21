import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class gui extends JFrame implements Runnable, ActionListener {
	
	private JButton Odd = new JButton("Odd");
	private JButton Game = new JButton("New Game");
	private JButton End = new JButton("End");
	private JButton Even = new JButton("Even");
    private Image buffer;
    public boolean win = false;
    public boolean lose = false;
    public int wins = 0;
    public int loss = 0;
    public int played = 0;
    public int Gameover = 0;
    static oddEvenGame oeg = new oddEvenGame();

	public gui() {
        setTitle("Daniel's Rock Paper Scissor game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);
        Insets insets = getInsets();
        setSize(200 + insets.left + insets.right, 200 + insets.top + insets.bottom);
        toFront();
        Odd.setBounds(15, 115, 80, 25);
        Even.setBounds(115, 115, 80, 25);
        Game.setBounds(60, 145, 100, 25);
        End.setBounds(60, 180, 80, 25);
        getContentPane().add(Odd);
        getContentPane().add(Even);
        getContentPane().add(Game);
        getContentPane().add(End);
        Odd.addActionListener(this);
        Even.addActionListener(this);
        Game.addActionListener(this);
        End.addActionListener(this);
        buffer = createImage(getWidth(), getHeight());
	}
	
	public static void main(String[] args) {
		new gui();
	}
	
    @Override
    public void run() {
        while(true) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
        }
        
    @Override
	public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.PLAIN, 11));
        g.drawString("The computer has generated a number", 15, 50);
        g.drawString("Guess wether it is Even or Odd", 25, 65);
        if(win == true){
        	g.setFont(new Font(null, Font.PLAIN, 11));
        	g.setColor(Color.GREEN);
        	g.drawString("Congrats you're right!", 25, 75);
        	g.drawString("the number was"+ oeg.Number2, 25, 85);
        	g.setColor(Color.BLACK);
        	g.drawString("hit new game and try again", 25, 95);
        }
        if(lose == true){
        	g.setFont(new Font(null, Font.PLAIN, 11));
        	g.setColor(Color.RED);
        	g.drawString("Sorry you're wrong", 25, 75);
        	g.drawString("the number was"+ oeg.Number2, 25, 85);
        	g.setColor(Color.BLACK);
        	g.drawString("hit new game and try again", 25, 95);
        	
        }
        if(Gameover == 1){
        	g.drawString("You Played a total of:"+ played, 25, 75);
        	g.drawString("You won" + wins, 25, 85);
        	g.drawString("you lost" + loss, 25, 95);
        }
        	
    }
    
    @Override
    public final void actionPerformed(ActionEvent e) {
    	if (e.getSource() == Even) {
    		System.out.println(oeg.Number);
    		win = false;
    		lose = false;
    		repaint();
    		played++;
    		if(oeg.getEven() == true){
    			win = true;
    			wins++;
    		}
    			if(oeg.getEven() == false){
    				lose = true;
    				loss++;
    			}
    		repaint();
    }
    	if (e.getSource() == Odd) {
    		System.out.println(oeg.Number);
    		win = false;
    		lose = false;
    		played++;
    		repaint();
    		if(oeg.getEven() == false){
    			win = true;
    			wins++;
    		}
    			if(oeg.getEven() == true){
    				lose = true;
    				loss++;
    			}
    		repaint();
    }
    	if (e.getSource() == Game) {
    		oeg.Number = 0;
    		win = false;
    		lose = false;
    		repaint();
    		System.out.println(oeg.Number);
    	}
    	if (e.getSource() == End) {
    		win = false;
    		lose = false;
    		Gameover = 1;
    		repaint();
    	}
    }
    
    }
