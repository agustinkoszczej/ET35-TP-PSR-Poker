import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;


public class DibujoCarta extends JPanel{


public DibujoCarta()
{
	this.setOpaque(false);
}
	public void paint(Graphics g)
	{
	/*	try{ Thread.sleep(1000);*/
	   super.paint(g);
		
     	Color c = new Color(119,13,13);
		g.setColor(c);
		g.fillRoundRect(70, 10, 1050, 590, 300, 300);
		g.setColor(Color.orange);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(6.0f)); 
		g2.draw(new RoundRectangle2D.Double(200, 150, 800, 300, 300,300)); 
		g.setColor(c);
		g.fillRoundRect(200, 150, 800, 300, 300, 300);
		g.setColor(Color.orange);
		g2.setStroke(new BasicStroke(4.0f)); 
		g2.drawRoundRect(430, 250, 370, 100, 30, 30); 
	for(int j=0;j<1;j++)
		{
		 for(int i=0;i<2;i++)
		 {
		 Font fuente=new Font("Times New Roman", Font.BOLD, 24);
		 g2.setStroke(new BasicStroke(0.0f)); 
		  if (i==0)
		  {
			  g.setFont(fuente);
			  g.setColor(Color.white);
			  g.fillRoundRect(540, 500, 60, 80, 10, 10);
			  g.setColor(Color.black);
			  g.drawRoundRect(540, 500, 60, 80, 10, 10);
		  if (Main.Mesa[i][j].Suit == "Corazones")
		  {
			  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
			  {
				  g.setColor(Color.red);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 580, 575);
				  g.setColor(Color.red);
				  g.drawString("♥", 543, 540);    
			  }
		  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
		  {
			  g.setColor(Color.red);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 574);
			  g.setColor(Color.red);
			  g.drawString("♥", 543, 540);    
		  }
		  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
		  {
			  g.setColor(Color.red);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 578);
			  g.setColor(Color.red);
			  g.drawString("♥", 543, 540);  
		  }
		  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
		  {
			  g.setColor(Color.red);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 575, 578);
			  g.setColor(Color.red);
			  g.drawString("♥", 543, 540);  
		  }
		  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
		  { 
		  g.setColor(Color.red);
		  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
		  g.drawString(""+Main.Mesa[i][j].Simbolo, 585, 578);
		  g.setColor(Color.red);
		  g.drawString("♥", 543, 540);
		  }
		  }
		  else if (Main.Mesa[i][j].Suit == "Treboles")
		  {
			  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 580, 575);
				  g.setColor(Color.black);
				  g.drawString("♣", 543, 540);    
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 574);
				  g.setColor(Color.black);
				  g.drawString("♣", 543, 540);    
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 578);
				  g.setColor(Color.black);
				  g.drawString("♣", 543, 540);  
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 575, 578);
				  g.setColor(Color.black);
				  g.drawString("♣", 543, 540);  
			  }
			  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
			  {
			  g.setColor(Color.black);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 585, 578);
			  g.setColor(Color.black);
		      g.drawString("♣", 543, 540);
			  }
		  }
		  else if (Main.Mesa[i][j].Suit == "Diamantes")
		  {
			  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
			  {
				  g.setColor(Color.red);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 580, 575);
				  g.setColor(Color.red);
				  g.drawString("♦", 543, 540);    
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
			  {
				  g.setColor(Color.red);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 574);
				  g.setColor(Color.red);
				  g.drawString("♦", 543, 540);    
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
			  {
				  g.setColor(Color.red);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 578);
				  g.setColor(Color.red);
				  g.drawString("♦", 543, 540);  
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
			  {
				  g.setColor(Color.red);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 575, 578);
				  g.setColor(Color.red);
				  g.drawString("♦", 543, 540);  
			  }
			  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
			  {
			  g.setColor(Color.red);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 585, 578);
			  g.setColor(Color.red);
		      g.drawString("♦", 543, 540);
			  }
		  }
		  else if (Main.Mesa[i][j].Suit == "Picas")
		  {
			  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 580, 575);
				  g.setColor(Color.black);
				  g.drawString("♠", 543, 540);    
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 574);
				  g.setColor(Color.black);
				  g.drawString("♠", 543, 540);    
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 579, 578);
				  g.setColor(Color.black);
				  g.drawString("♠", 543, 540);  
			  }
			  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
			  {
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 575, 578);
				  g.setColor(Color.black);
				  g.drawString("♠", 543, 540);  
			  }
			  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
			  { 
			  g.setColor(Color.black);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 544, 520);
			  g.drawString(""+Main.Mesa[i][j].Simbolo, 585, 578);
			  g.setColor(Color.black);
		      g.drawString("♠", 543, 540);
			  }
		  }
		  }
		  else if (i == 1)
		  {
			  g.setFont(fuente);
			  g.setColor(Color.white);
			  g.fillRoundRect(610, 500, 60, 80, 10, 10);
			  g.setColor(Color.black);
			  g.drawRoundRect(610, 500, 60, 80, 10, 10);
			  if (Main.Mesa[i][j].Suit == "Corazones")
			  {
				  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 651, 575);
					  g.setColor(Color.red);
					  g.drawString("♥", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 574);
					  g.setColor(Color.red);
					  g.drawString("♥", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 578);
					  g.setColor(Color.red);
					  g.drawString("♥", 613, 540);  
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 646, 578);
					  g.setColor(Color.red);
					  g.drawString("♥", 613, 540);  
				  }
				  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
				  { 
				  g.setColor(Color.red);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 656, 578);
				  g.setColor(Color.red);
			      g.drawString("♥", 613, 540);
				  }
			  }
			  else if (Main.Mesa[i][j].Suit == "Treboles")
			  {
				  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 651, 575);
					  g.setColor(Color.black);
					  g.drawString("♣", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 574);
					  g.setColor(Color.black);
					  g.drawString("♣", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 578);
					  g.setColor(Color.black);
					  g.drawString("♣", 613, 540);  
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 646, 578);
					  g.setColor(Color.black);
					  g.drawString("♣", 613, 540);  
				  }
				  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
				  { 
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 656, 578);
				  g.setColor(Color.black);
			      g.drawString("♣", 613, 540);
				  }
			  }
			  else if (Main.Mesa[i][j].Suit == "Diamantes")
			  {
				  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 651, 575);
					  g.setColor(Color.red);
					  g.drawString("♦", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 574);
					  g.setColor(Color.red);
					  g.drawString("♦", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 578);
					  g.setColor(Color.red);
					  g.drawString("♦", 613, 540);  
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
				  {
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 646, 578);
					  g.setColor(Color.red);
					  g.drawString("♦", 613, 540);  
				  }
				  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
				  { 
				  g.setColor(Color.red);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 656, 578);
				  g.setColor(Color.red);
			      g.drawString("♦", 613, 540);
				  }
			  }
			  else if (Main.Mesa[i][j].Suit == "Picas")
			  {
				  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 651, 575);
					  g.setColor(Color.black);
					  g.drawString("♠", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 574);
					  g.setColor(Color.black);
					  g.drawString("♠", 613, 540);    
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 650, 578);
					  g.setColor(Color.black);
					  g.drawString("♠", 613, 540);  
				  }
				  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
				  {
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 646, 578);
					  g.setColor(Color.black);
					  g.drawString("♠", 613, 540);  
				  }
				  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
				  { 
				  g.setColor(Color.black);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 614, 520);
				  g.drawString(""+Main.Mesa[i][j].Simbolo, 656, 578);
				  g.setColor(Color.black);
			      g.drawString("♠", 613, 540);
			  }
			  }  
		  }
	}
		}
		for(int j=1;j<2;j++)
		{
		for(int i=0;i<2;i++)
		{
			 Font fuente=new Font("Times New Roman", Font.BOLD, 24);
			 
			  if (i==0)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(100, 230, 80, 60, 10, 10);
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura2.jpg"));
				  g.drawImage(im, 100, 230, this);
			  }
			  else if (i == 1)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(100, 300, 80, 60, 10, 10);
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura2.jpg"));
				  g.drawImage(im, 100, 300, this);
				  }
		}
		}
	for(int j=2;j<3;j++)
	{
	for(int i=4;i<6;i++)
		{
			Font fuente=new Font("Times New Roman", Font.BOLD, 24);
			if(i==4)
			{
				 g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(540, 25, 60, 80, 10, 10);
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura1.jpg"));
				  g.drawImage(im, 540, 25, this);
			}
			else if(i == 5)
			{
				g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(610, 25, 60, 80, 10, 10);
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura1.jpg"));
				  g.drawImage(im, 610, 25, this);
			}
		}
	}
	for(int j=3;j<4;j++)
	{
		for(int i=0;i<2;i++)
		{
			Font fuente=new Font("Times New Roman", Font.BOLD, 24);
			if(i==0)
			{
				 g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(1010, 230, 80, 60, 10, 10);
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura2.jpg"));
				  g.drawImage(im, 1010, 230, this);
			}
			else if(i == 1)
			{
				g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(1010, 300, 80, 60, 10, 10);
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura2.jpg"));
				  g.drawImage(im, 1010, 300, this);
			}
		    
			  
		}
	}
		/*	  else if(i == 11)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(655,257 , 60, 80, 10, 10); 
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura1.jpg"));
					g.drawImage(im, 655, 257, this);
				 
			  }
			  else if(i == 12)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.black);
				  g.drawRoundRect(725,257 , 60, 80, 10, 10); 
				  Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textura1.jpg"));
					g.drawImage(im, 725, 257, this);
				  
			  }*/
	for(int i=0;i<Datos.J.length;i++)
		{
			if(Datos.J[i].NroJugador == 1 && Datos.J[i].CiegaGrande == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(580, 465, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(585, 470, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CG", 585, 481);
			}
			if(Datos.J[i].NroJugador == 1 && Datos.J[i].CiegaChica == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(580, 465, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(585, 470, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CP", 585, 481);
			}
			if(Datos.J[i].NroJugador == 2 && Datos.J[i].CiegaGrande == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(210, 280, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(215, 285, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CG", 215, 295);
			}
			if(Datos.J[i].NroJugador == 2 && Datos.J[i].CiegaChica == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(210, 280, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(215, 285, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CP", 215, 295);
			}
			if(Datos.J[i].NroJugador == 3 && Datos.J[i].CiegaGrande == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(570, 120, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(575, 125, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CG", 575, 136);
			}
			if(Datos.J[i].NroJugador == 3 && Datos.J[i].CiegaChica == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(210, 280, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(215, 285, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CP", 215, 295);
			}
			if(Datos.J[i].NroJugador == 4 && Datos.J[i].CiegaGrande == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(210, 280, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(215, 285, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CG", 215, 295);
			}
			if(Datos.J[i].NroJugador == 4 && Datos.J[i].CiegaGrande == true)
			{
				g2.setColor(Color.gray);
				g2.fillOval(210, 280, 24, 24);
				g2.setColor(Color.white);
				g2.fillOval(215, 285, 14, 14);
				Font f = new Font("Times New Roman",Font.BOLD,10);
				g.setColor(Color.black);
				g.setFont(f);
				g2.drawString("CP", 215, 295);
			}
		}
	if(Main.cont == Maquina.CantJugadores && Main.floop == true && Main.Cuarta == true)
	{
	
		
		for(int j=0;j<1;j++)
		{
		for(int i=2;i<7;i++)
		{ 

			Font fuente=new Font("Times New Roman", Font.BOLD, 24);
			if (i==2)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(445, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(445, 257, 60, 80, 10, 10);
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.red);
				      g.drawString("♥", 448, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.black);
				      g.drawString("♣", 448, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.red);
				      g.drawString("♦", 448, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.black);
				      g.drawString("♠", 448, 296);
					  }
				  }
			  }
			  else if(i == 3)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(515, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(515, 257 , 60, 80, 10, 10); 
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296);  
					  }
				  }
			  }
			  else if(i == 4)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(585, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(585, 257 , 60, 80, 10, 10); 
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296);  
					  }
				  }
			  }
			  if (i==5)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(655, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(655, 257, 60, 80, 10, 10);
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.red);
				      g.drawString("♥", 658, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.black);
				      g.drawString("♣", 658, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.red);
				      g.drawString("♦", 658, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.black);
				      g.drawString("♠", 658, 296);
					  }
				  }
			  }
			if (i==6)
			  {
				 g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(725, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(725, 257, 60, 80, 10, 10);
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 762, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 727, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 757, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 727, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 729, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 769, 333);
					  g.setColor(Color.red);
				      g.drawString("♥", 727, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 762, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 727, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 757, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 727, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 729, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 769, 333);
					  g.setColor(Color.black);
				      g.drawString("♣", 727, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 762, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 727, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 757, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 727, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 729, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 769, 333);
					  g.setColor(Color.red);
				      g.drawString("♦", 727, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 762, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 727, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 761, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 727, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 727, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 757, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 727, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 729, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 769, 333);
					  g.setColor(Color.black);
				      g.drawString("♠", 727, 296);
					  }
				  }
			  }
			  }
		}
		Main.Quinta = true;
		}	
	if(Main.cont == Maquina.CantJugadores && Main.floop == true)
	{
		
		for(int j=0;j<1;j++)
		{
		for(int i=2;i<6;i++)
		{
			Font fuente=new Font("Times New Roman", Font.BOLD, 24);
			if (i==2)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(445, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(445, 257, 60, 80, 10, 10);
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.red);
				      g.drawString("♥", 448, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.black);
				      g.drawString("♣", 448, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.red);
				      g.drawString("♦", 448, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
					  g.setColor(Color.black);
				      g.drawString("♠", 448, 296);
					  }
				  }
			  }
			  else if(i == 3)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(515, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(515, 257 , 60, 80, 10, 10); 
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 518, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 518, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 518, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 518, 296);  
					  }
				  }
			  }
			  else if(i == 4)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(585, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(585, 257 , 60, 80, 10, 10); 
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 588, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 588, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 588, 296);  
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 588, 296);  
					  }
				  }
			  }
			  if (i==5)
			  {
				  g.setFont(fuente);
				  g.setColor(Color.white);
				  g.fillRoundRect(655, 257, 60, 80, 10, 10);
				  g.setColor(Color.black);
				  g.drawRoundRect(655, 257, 60, 80, 10, 10);
				  if (Main.Mesa[i][j].Suit == "Corazones")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.red);
				      g.drawString("♥", 658, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Treboles")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.black);
				      g.drawString("♣", 658, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Diamantes")
				  {
					  
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.red);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.red);
				      g.drawString("♦", 658, 296);
					  }
				  }
				  else if (Main.Mesa[i][j].Suit == "Picas")
				  {
					  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 694, 331);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 329);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296); 
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 693, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296);  
					  }
					  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
					  {
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 689, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 658, 296);  
					  }
					  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
					  { 
					  g.setColor(Color.black);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 659, 277);
					  g.drawString(""+Main.Mesa[i][j].Simbolo, 699, 333);
					  g.setColor(Color.black);
				      g.drawString("♠", 658, 296);
					  }
				  }
			  }
		}
		}
		Main.Cuarta = true;

	}
		if(Main.cont == Maquina.CantJugadores && Main.floop == false && Maquina.CantJugadores > 1)
		{
			
			for(int j=0;j<1;j++)
			{
			for(int i=2;i<5;i++)
			{
				Font fuente=new Font("Times New Roman", Font.BOLD, 24);
				 
				  if (i==2)
				  {
					  g.setFont(fuente);
					  g.setColor(Color.white);
					  g.fillRoundRect(445, 257, 60, 80, 10, 10);
					  g.setColor(Color.black);
					  g.drawRoundRect(445, 257, 60, 80, 10, 10);
					  if (Main.Mesa[i][j].Suit == "Corazones")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
							  g.setColor(Color.red);
						      g.drawString("♥", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
							  g.setColor(Color.red);
						      g.drawString("♥", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 448, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 448, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
						  g.setColor(Color.red);
					      g.drawString("♥", 448, 296);
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Treboles")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
							  g.setColor(Color.black);
						      g.drawString("♣", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
							  g.setColor(Color.black);
						      g.drawString("♣", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 448, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 448, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
						  g.setColor(Color.black);
					      g.drawString("♣", 448, 296);
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Diamantes")
					  {
						  
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
							  g.setColor(Color.red);
						      g.drawString("♦", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
							  g.setColor(Color.red);
						      g.drawString("♦", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 448, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 448, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
						  g.setColor(Color.red);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
						  g.setColor(Color.red);
					      g.drawString("♦", 448, 296);
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Picas")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 484, 331);
							  g.setColor(Color.black);
						      g.drawString("♠", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 329);
							  g.setColor(Color.black);
						      g.drawString("♠", 448, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 483, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 448, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 479, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 448, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
						  g.setColor(Color.black);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 449, 277);
						  g.drawString(""+Main.Mesa[i][j].Simbolo, 489, 333);
						  g.setColor(Color.black);
					      g.drawString("♠", 448, 296);
						  }
					  }
				  }
				  else if(i == 3)
				  {
					  g.setFont(fuente);
					  g.setColor(Color.white);
					  g.fillRoundRect(515, 257, 60, 80, 10, 10);
					  g.setColor(Color.black);
					  g.drawRoundRect(515, 257 , 60, 80, 10, 10); 
					  if (Main.Mesa[i][j].Suit == "Corazones")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
							  g.setColor(Color.red);
						      g.drawString("♥", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
							  g.setColor(Color.red);
						      g.drawString("♥", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 518, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 518, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 518, 296);  
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Treboles")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
							  g.setColor(Color.black);
						      g.drawString("♣", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
							  g.setColor(Color.black);
						      g.drawString("♣", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 518, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 518, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 518, 296);  
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Diamantes")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
							  g.setColor(Color.red);
						      g.drawString("♦", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
							  g.setColor(Color.red);
						      g.drawString("♦", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 518, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 518, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 518, 296);  
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Picas")
					  {
						  
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 554, 331);
							  g.setColor(Color.black);
						      g.drawString("♠", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 329);
							  g.setColor(Color.black);
						      g.drawString("♠", 518, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 553, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 518, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 549, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 518, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 519, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 559, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 518, 296);  
						  }
					  }
				  }
				  else if(i == 4)
				  {
					  g.setFont(fuente);
					  g.setColor(Color.white);
					  g.fillRoundRect(585, 257, 60, 80, 10, 10);
					  g.setColor(Color.black);
					  g.drawRoundRect(585, 257 , 60, 80, 10, 10); 
					  if (Main.Mesa[i][j].Suit == "Corazones")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
							  g.setColor(Color.red);
						      g.drawString("♥", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
							  g.setColor(Color.red);
						      g.drawString("♥", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 588, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 588, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
							  g.setColor(Color.red);
						      g.drawString("♥", 588, 296);  
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Treboles")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
							  g.setColor(Color.black);
						      g.drawString("♣", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
							  g.setColor(Color.black);
						      g.drawString("♣", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 588, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 588, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
							  g.setColor(Color.black);
						      g.drawString("♣", 588, 296);  
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Diamantes")
					  {
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
							  g.setColor(Color.red);
						      g.drawString("♦", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
							  g.setColor(Color.red);
						      g.drawString("♦", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 588, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 588, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.red);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
							  g.setColor(Color.red);
						      g.drawString("♦", 588, 296);  
						  }
					  }
					  else if (Main.Mesa[i][j].Suit == "Picas")
					  {
						  
						  if(Main.Mesa[i][j].Simbolo.equals("A") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 624, 331);
							  g.setColor(Color.black);
						      g.drawString("♠", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("Q") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 329);
							  g.setColor(Color.black);
						      g.drawString("♠", 588, 296); 
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("K") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 623, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 588, 296);  
						  }
						  if(Main.Mesa[i][j].Simbolo.equals("10") == true)
						  {
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 619, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 588, 296);  
						  }
						  else if(Main.Mesa[i][j].Simbolo.equals("10") == false && Main.Mesa[i][j].Simbolo.equals("K") == false && Main.Mesa[i][j].Simbolo.equals("Q") == false && Main.Mesa[i][j].Simbolo.equals("A") == false)
						  { 
							  g.setColor(Color.black);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 589, 277);
							  g.drawString(""+Main.Mesa[i][j].Simbolo, 629, 333);
							  g.setColor(Color.black);
						      g.drawString("♠", 588, 296);  
						  }
					  }
				  }
		      }
			}
			Main.floop = true;
	
		}
		if(Main.cont==Maquina.CantJugadores)
     	{
     		Main.cont = 0;
     	}
	    Font fuen = new Font("Times New Roman",Font.BOLD,24);
		g.setFont(fuen);
	/*    g.setColor(Color.black);
		g.drawRoundRect(200, 505, 60, 80, 10, 10);*/
		g2.setStroke(new BasicStroke(15.0f)); 
     	g2.setColor(Color.black);
     	g2.draw(new RoundRectangle2D.Double(70, 10, 1050, 590, 300,300));
     	do
     	{
     	Main.Maquinas();
     	if(Main.turno!=1)
     	{
     	if(Main.Quinta == false && Main.cont != Maquina.CantJugadores)
     	{
     	System.out.println("Turno Jugador: "+Main.TurnoJugador());
     	}
     	}
     	}while(Main.turno!=1 && Main.Quinta == false && Main.cont != Maquina.CantJugadores && Maquina.CantJugadores > 1);
     	if(Maquina.CantJugadores == 1)
		{
			Main.GanaPorRetirada();
			}
		
     	if(Main.cont == Maquina.CantJugadores)
     	{
     		Main.Juego();
     		System.out.println("Turno Jugador: "+Main.TurnoJugador());
     	}
    	if(Main.Quinta == true)
    	{
     		Main.ganador();
     		Main.GanadorMesa();
     		int cant = 0;
     		for(int i=0;i<Datos.J.length;i++)
     		{
     			if(Datos.J[i].bote == 0)
     			{
     				Maquina.CantJugadores = Maquina.CantJugadores - 1;
     			}
     		}
     		cant = 0;
     		Main.floop = false;
     		Main.Cuarta = false;
     		Main.Quinta = false;
     		for(int i=0;i<Maquina.MovsJugadores.length;i++)
     		{
     			Maquina.MovsJugadores[i] = null;
     		}
     		Maquina.CantJugadores = 4;
     		Main.turno = 0;
     		Main.AsignarCiegas();
            Main.Paq1.MezclarPaq();
			
			Main.Mesa= Main.Paq1.Repartir(Main.Mesa, Main.N);
			Main.ventana.repaint();
			Main.CartasJugador();
     	}
     	if(Main.turno == 1)
     	{
     		Main.Ir.setVisible(true);
     		Main.Subir.setVisible(true);
     		Main.Retirarse.setVisible(true);
     	}
	/*	} 
		 catch(InterruptedException f ) { 
			 System.out.println("Thread Interrupted");
			 }*/
	}
}

