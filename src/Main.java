import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener{
	
JButton boton1;
static JButton Retirarse;
static JButton Ir;
static JButton Subir;
static JFrame ventana;
static JLabel l;
static JLabel j1;
static JLabel j2;
static JLabel j3;
static JLabel j4;
static boolean fin,floop = false,Cuarta = false,Quinta = false;
public static int apuestaJ1 = 0;
public static int apuestaJ2 = 0;
public static int apuestaJ3 = 0;
public static int apuestaJ4 = 0;
static Maquina maq1;
static Maquina maq2;
static Maquina maq3;
public static Main menu;
public static PaqueteDeCartas Paq1;
public static Carta c;
static int pozo = 0;
static int acum = 0,max=0,cont=0,Gana=-1,val=0,Cantidad = 4;
static int suma=0,subir=0;
static int suma1=0;
static int suma2=0;
static int suma3=0;
static int turno;
static int N=4;
static int j;
static int i;
public static Carta Mesa[][] = new Carta [7][N];

public Main()
{
	this.setSize(610,410);
    setLayout(null);
    boton1=new JButton("Nuevo Juego");
    boton1.setBounds(50,100,120,30);
    add(boton1);
    boton1.addActionListener(this);
}

/*Aca se carga la imagen principal donde aparece el boton nuevo juego*/


public void paint(Graphics g)
{
	((JPanel)getContentPane()).setOpaque(false); 
    ImageIcon imagen=new ImageIcon(this.getClass().getResource("pokers.jpg")); 
    JLabel fondo= new JLabel(); 
    fondo.setIcon(imagen); 
    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
    fondo.setBounds(0,0,imagen.getIconWidth(),imagen.getIconHeight());
	}



/*Esto es el evento del boton nuevo juego al presionarlo se llama a este evento*/
public void actionPerformed(ActionEvent e)
{
if(e.getSource() == boton1)
  {
	  mostrar(Datos.J);
	/*this.mayorApuesta(suma, suma1, suma2, suma3);*/
	Maquina.CantJugadores = 4;
while(turno!=1)
{
Maquinas();
if(turno!=1)
{
System.out.println("Turno Jugador: "+TurnoJugador());
}
}
if(turno == 1)
{
/* try{ Thread.sleep(3000); } 
 catch(InterruptedException f ) { 
	 System.out.println("Thread Interrupted");
	 }*/
	Ir.setVisible(true);
	Subir.setVisible(true);
	Retirarse.setVisible(true);
}
  }
if(e.getSource() == Ir)
	{
	    cont = cont + 1;
		Maquina.MovsJugadores[0] = "Ir";
		calcular_pozo(Main.turno);
		l.setText("Pozo: "+Main.pozo);
		ActualizarMesa();
		if(cont==Maquina.CantJugadores)
	 	{
			if(floop == false)
			{
	 		floop();
			}
			if(floop == true && Cuarta == false)
			{
				Cuarta();
			}
			if(floop == true && Cuarta == true && Quinta == false)
			{
				Quinta();
			}
	 		for(int i=0;i<Maquina.MovsJugadores.length;i++)
	 		{
	 			Maquina.MovsJugadores[i] = null;
	 		}
	 	}
		System.out.println("Turno Jugador: "+TurnoJugador());
		Ir.setVisible(false);
		Subir.setVisible(false);
		Retirarse.setVisible(false);
		if(cont != Maquina.CantJugadores)
		{
		Juego();
		}
	}
	if(e.getSource() == Subir)
	{
		for(int i=0;i<Maquina.MovsJugadores.length;i++)
 		{
 			Maquina.MovsJugadores[i] = null;
 		}
		cont = 0;
		max = 0;
		boolean repite = false;
	do{
		
		String valor = JOptionPane.showInputDialog("Ingrese el valor a subir");   
		try {
		val = Integer.parseInt(valor);
		repite = false;
		}
		catch(NumberFormatException f){
			repite = true;
		}
	}while ((repite) && (val<=0) && (val>Datos.J[0].bote));
		max = val;
		Maquina.MovsJugadores[0] = "Subir";
		calcular_pozo(turno);
		ActualizarMesa();
		System.out.println("Turno Jugador: "+TurnoJugador());
		Ir.setVisible(false);
		Subir.setVisible(false);
		Retirarse.setVisible(false);	
	}
	if(e.getSource() == Retirarse)
	{
		subir = subir + 1;
		if(subir == 2)
		{
			System.out.println("2 veces");
		}
		Maquina.MovsJugadores[0] = "Retirarse";
		Datos.J[0].Retirado = true;
		Maquina.CantJugadores = Maquina.CantJugadores - 1;
        if(Maquina.CantJugadores != 1)
		{
		System.out.println("Turno Jugador: "+TurnoJugador());
		}
        if(Maquina.CantJugadores == 1)
		{
			Main.GanaPorRetirada();
			}
		Ir.setVisible(false); 
		Subir.setVisible(false);
		Retirarse.setVisible(false);
		
	}
}
          
          /*Esto es para dibujar las 3 cartas en la mesa cuando todas las apuesta son iguales*/
      	
          
          public static void floop()
      	{
        	if(Maquina.CantJugadores==4)
        	{
      	    if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ3 && apuestaJ3 == apuestaJ4)
      	    {
      	    	ventana.repaint();
      	    	apuestaJ1 = 0;
      	    	apuestaJ2 = 0;
      	    	apuestaJ3 = 0;
      	    	apuestaJ4 = 0;
      	    	max=0;
      	    	suma = 0;
      	    	suma1 = 0;
      	    	suma2 = 0;
      	    	suma3 = 0;
      	    }
        	}
        	if(Maquina.CantJugadores==3)
        	{
        	if(Datos.J[0].Retirado == true)
        	{
      	    if(apuestaJ2 == apuestaJ3 && apuestaJ3 == apuestaJ4)
      	    {
      	    	ventana.repaint();
      	    	apuestaJ1 = 0;
      	    	apuestaJ2 = 0;
      	    	apuestaJ3 = 0;
      	    	apuestaJ4 = 0;
      	    	max=0;
      	    	suma = 0;
      	    	suma1 = 0;
      	    	suma2 = 0;
      	    	suma3 = 0;
      	    }
        	}
            if(Datos.J[1].Retirado == true)
            {
          	    if(apuestaJ1 == apuestaJ3 && apuestaJ3 == apuestaJ4)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            	}
            if(Datos.J[2].Retirado == true)
            {
            	if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ4)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            }
            if(Datos.J[3].Retirado == true)
            {
            	if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ3)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            }
            }
        	if(Maquina.CantJugadores == 2)
        	{
        		if(Datos.J[0].Retirado == true && Datos.J[1].Retirado == true)
            	{
          	    if(apuestaJ3 == apuestaJ4)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            	}
        		if(Datos.J[0].Retirado == true && Datos.J[2].Retirado == true)
            	{
          	    if(apuestaJ2 == apuestaJ4)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            	}
        		if(Datos.J[0].Retirado == true && Datos.J[3].Retirado == true)
            	{
          	    if(apuestaJ2 == apuestaJ3)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            	}
        		if(Datos.J[1].Retirado == true && Datos.J[2].Retirado == true)
            	{
          	    if(apuestaJ1 == apuestaJ4)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            	}
        		if(Datos.J[1].Retirado == true && Datos.J[3].Retirado == true)
            	{
          	    if(apuestaJ1 == apuestaJ3)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            	}
        		if(Datos.J[2].Retirado == true && Datos.J[3].Retirado == true)
            	{
          	    if(apuestaJ1 == apuestaJ2)
          	    {
          	    	ventana.repaint();
          	    	apuestaJ1 = 0;
          	    	apuestaJ2 = 0;
          	    	apuestaJ3 = 0;
          	    	apuestaJ4 = 0;
          	    	max=0;
          	    	suma = 0;
          	    	suma1 = 0;
          	    	suma2 = 0;
          	    	suma3 = 0;
          	    }
            	}
        	}
      	}

/*Esto es para dibujar las 4 cartas en la mesa cuando todas las apuesta son iguales*/
          
public static void Cuarta()
{
	 
	if(Maquina.CantJugadores==4)
	{
	    if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ3 && apuestaJ3 == apuestaJ4)
	    {
	    	ventana.repaint();
	    	apuestaJ1 = 0;
	    	apuestaJ2 = 0;
	    	apuestaJ3 = 0;
	    	apuestaJ4 = 0;
	    	max=0;
	    	suma = 0;
	    	suma1 = 0;
	    	suma2 = 0;
	    	suma3 = 0;
	    }
	}
	if(Maquina.CantJugadores==3)
	{
	if(Datos.J[0].Retirado == true)
	{
	    if(apuestaJ2 == apuestaJ3 && apuestaJ3 == apuestaJ4)
	    {
	    	ventana.repaint();
	    	apuestaJ1 = 0;
	    	apuestaJ2 = 0;
	    	apuestaJ3 = 0;
	    	apuestaJ4 = 0;
	    	max=0;
	    	suma = 0;
	    	suma1 = 0;
	    	suma2 = 0;
	    	suma3 = 0;
	    }
	}
    if(Datos.J[1].Retirado == true)
    {
  	    if(apuestaJ1 == apuestaJ3 && apuestaJ3 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
    if(Datos.J[2].Retirado == true)
    {
    	if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    }
    if(Datos.J[3].Retirado == true)
    {
    	if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ3)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    }
    }
	if(Maquina.CantJugadores == 2)
	{
		if(Datos.J[0].Retirado == true && Datos.J[1].Retirado == true)
    	{
  	    if(apuestaJ3 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[0].Retirado == true && Datos.J[2].Retirado == true)
    	{
  	    if(apuestaJ2 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[0].Retirado == true && Datos.J[3].Retirado == true)
    	{
  	    if(apuestaJ2 == apuestaJ3)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[1].Retirado == true && Datos.J[2].Retirado == true)
    	{
  	    if(apuestaJ1 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[1].Retirado == true && Datos.J[3].Retirado == true)
    	{
  	    if(apuestaJ1 == apuestaJ3)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[2].Retirado == true && Datos.J[3].Retirado == true)
    	{
  	    if(apuestaJ1 == apuestaJ2)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
	}
	}

public static void Quinta()
{
	if(Maquina.CantJugadores==4)
	{
	    if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ3 && apuestaJ3 == apuestaJ4)
	    {
	    	ventana.repaint();
	    	apuestaJ1 = 0;
	    	apuestaJ2 = 0;
	    	apuestaJ3 = 0;
	    	apuestaJ4 = 0;
	    	max=0;
	    	suma = 0;
	    	suma1 = 0;
	    	suma2 = 0;
	    	suma3 = 0;
	    }
	}
	if(Maquina.CantJugadores==3)
	{
	if(Datos.J[0].Retirado == true)
	{
	    if(apuestaJ2 == apuestaJ3 && apuestaJ3 == apuestaJ4)
	    {
	    	ventana.repaint();
	    	apuestaJ1 = 0;
	    	apuestaJ2 = 0;
	    	apuestaJ3 = 0;
	    	apuestaJ4 = 0;
	    	max=0;
	    	suma = 0;
	    	suma1 = 0;
	    	suma2 = 0;
	    	suma3 = 0;
	    }
	}
    if(Datos.J[1].Retirado == true)
    {
  	    if(apuestaJ1 == apuestaJ3 && apuestaJ3 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
    if(Datos.J[2].Retirado == true)
    {
    	if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    }
    if(Datos.J[3].Retirado == true)
    {
    	if(apuestaJ1 == apuestaJ2 && apuestaJ2 == apuestaJ3)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    }
    }
	if(Maquina.CantJugadores == 2)
	{
		if(Datos.J[0].Retirado == true && Datos.J[1].Retirado == true)
    	{
  	    if(apuestaJ3 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[0].Retirado == true && Datos.J[2].Retirado == true)
    	{
  	    if(apuestaJ2 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[0].Retirado == true && Datos.J[3].Retirado == true)
    	{
  	    if(apuestaJ2 == apuestaJ3)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[1].Retirado == true && Datos.J[2].Retirado == true)
    	{
  	    if(apuestaJ1 == apuestaJ4)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[1].Retirado == true && Datos.J[3].Retirado == true)
    	{
  	    if(apuestaJ1 == apuestaJ3)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
		if(Datos.J[2].Retirado == true && Datos.J[3].Retirado == true)
    	{
  	    if(apuestaJ1 == apuestaJ2)
  	    {
  	    	ventana.repaint();
  	    	apuestaJ1 = 0;
  	    	apuestaJ2 = 0;
  	    	apuestaJ3 = 0;
  	    	apuestaJ4 = 0;
  	    	max=0;
  	    	suma = 0;
  	    	suma1 = 0;
  	    	suma2 = 0;
  	    	suma3 = 0;
  	    }
    	}
	}
	}
          
          
	public void mostrar(Jugador J[])
    {
		
		    Paq1=new PaqueteDeCartas();
			
			Paq1.MezclarPaq();
			
			Mesa= Paq1.Repartir(Mesa, N);	
			ventana = new JFrame();
	 		ventana.setSize(1200,700);
	 		ventana.setLocationRelativeTo(null);
	 		ventana.setTitle("Poker");
	 		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
	 		ventana.setResizable(false);
	 		 Ir = new JButton("Ir");
				Ir.setLayout(null);
				Ir.setBounds(400, 620, 120, 30);
				Ir.addActionListener(this);
				Subir = new JButton("Subir Apuesta");
				Subir.setLayout(null);
				Subir.setBounds(550, 620, 120, 30);
				Subir.addActionListener(this);
				Retirarse = new JButton("Retirarse");
				Retirarse.setLayout(null);
				Retirarse.setBounds(700, 620, 120, 30);
				Retirarse.addActionListener(this);
			    ventana.add(Ir);
			    ventana.add(Subir);
			    ventana.add(Retirarse);
			    Ir.setVisible(false);
			    Subir.setVisible(false);
			    Retirarse.setVisible(false);
				l = new JLabel();
				l.setText("pozo "+Main.pozo);
				l.setBounds(300, 200, 120, 30);
				l.setForeground(Color.black);
				ventana.add(l);
				j1 = new JLabel();
				j1.setText("$ "+Datos.J[0].bote);
				j1.setBounds(450, 500, 100, 30);
				j1.setForeground(Color.black);
				ventana.add(j1);
				j2 = new JLabel();
				j2.setText("$ "+Datos.J[1].bote);
				j2.setBounds(100, 150, 100, 30);
				j2.setForeground(Color.black);
				ventana.add(j2);
				j3 = new JLabel();
				j3.setText("$ "+Datos.J[2].bote);
				j3.setBounds(450, 50, 100, 30);
				j3.setForeground(Color.black);
				ventana.add(j3);
				j4 = new JLabel();
				j4.setText("$ "+Datos.J[3].bote);
				j4.setBounds(1050, 150, 100, 30);
				j4.setForeground(Color.black);
				ventana.add(j4);
				DibujoCarta dib = new DibujoCarta();
				ventana.add(dib);
				  ventana.setVisible(true);
			    dispose();           /*Esto es para ocultar la ventana principal*/
		        CartasJugador();
    }
	
	
public static void CartasJugador()
{
	for(j=0;j<N;j++)
	{
		Utils.trace("");
		Utils.trace("cartas jugador " + j);
		for(i=0;i<7;i++)
		{
			Utils.trace(Mesa[i][j].Simbolo + " de " + Mesa[i][j].Suit);
		}
	}
	int k=0;
	for(j=0;j<N;j++)
	{
	for(i=0;i<Mesa.length;i++)
	{
		if(i<2 && j==0)
		{
			if(Mesa[i][j].Valor == 14)
			{
			    Carta.cartas[k] = 1;
			    Carta.palos[k] = Mesa[i][j].Suit;
			    k++;
			}
			else if(Mesa[i][j].Valor != 14)
			{
			Carta.cartas[k] = Mesa[i][j].Valor;
			Carta.palos[k] = Mesa[i][j].Suit;
			k++;
			}
		}
		if(i<2 && j==1)
		{
			if(Mesa[i][j].Valor == 14)
			{
			    Carta.cartas[k] = 1;
			    Carta.palos[k] = Mesa[i][j].Suit;
			    k++;
			}
			else if(Mesa[i][j].Valor != 14)
			{
			Carta.cartas[k] = Mesa[i][j].Valor;
			Carta.palos[k] = Mesa[i][j].Suit;
			k++;
			}
		}
		if(i<2 && j==2)
		{
			if(Mesa[i][j].Valor == 14)
			{
			    Carta.cartas[k] = 1;
			    Carta.palos[k] = Mesa[i][j].Suit;
			    k++;
			}
			else if(Mesa[i][j].Valor != 14)
			{
			Carta.cartas[k] = Mesa[i][j].Valor;
			Carta.palos[k] = Mesa[i][j].Suit;
			k++;
			}
		}
		if(j==3)
		{
			if(Mesa[i][j].Valor == 14)
			{
			    Carta.cartas[k] = 1;
			    Carta.palos[k] = Mesa[i][j].Suit;
			    k++;
			}
			else if(Mesa[i][j].Valor != 14)
			{
			Carta.cartas[k] = Mesa[i][j].Valor;
			Carta.palos[k] = Mesa[i][j].Suit;
			k++;
			}
		}
		}
	}
	
	int turnoJ = 0;
	for(i=0;i<2;i++)
    {
    turnoJ = TurnoJugador();
    System.out.println("Turno Jugador: "+turnoJ);
    inicioApuesta(Datos.J,turnoJ);
    }
	
	
	
    System.out.println("Pozo Acumulado: "+pozo);	
    turnoJ = TurnoJugador();
    System.out.println("Turno Jugador: "+turnoJ);
}
	/*para descontar el dinero del jugador para igualar las apuestas*/
	
	
	
	public static int calcular_pozo(int turno)
	{
        if(turno == 1)
		{
		if(max>apuestaJ1)
		{ 
			for(int i=0;i<Maquina.MovsJugadores.length;i++)
			{
			if(apuestaJ1 == 1 && Maquina.MovsJugadores[i] == "Subir")
			{
				apuestaJ1 = 0;
			}
			}
			if(Datos.J[0].bote >= max)
			{
			acum = max - apuestaJ1;
			pozo = pozo + acum;
			apuestaJ1 = apuestaJ1 + acum;
			Datos.J[0].bote = Datos.J[0].bote - acum;
			l.setText("Pozo: "+pozo);
			}
			else if(Datos.J[0].bote < max)
			{
				acum = Datos.J[0].bote;
				pozo = pozo + acum;
				apuestaJ1 = apuestaJ1 + acum;
				Datos.J[0].bote = Datos.J[0].bote - acum;
				l.setText("Pozo: "+pozo);
			}
		  }
		 }
		if(turno == 2)
		{
		if(max>apuestaJ2)
		{   
			for(int i=0;i<Maquina.MovsJugadores.length;i++)
			{
			if(apuestaJ2 == 1 && Maquina.MovsJugadores[i] == "Subir")
			{
				apuestaJ2 = 0;
			}
			}
			if(Datos.J[1].bote >= max)
			{
			acum = max - apuestaJ2;
			pozo = pozo + acum;
			apuestaJ2 = apuestaJ2 + acum;
			Datos.J[1].bote = Datos.J[1].bote - acum;
			Maquina.Dinero = Datos.J[1].bote;
			l.setText("Pozo: "+pozo);
			}
			else if(Datos.J[1].bote < max)
			{
				if(floop == false)
				{
					acum = max - apuestaJ2;
					pozo = pozo + acum;
					apuestaJ2 = apuestaJ2 + acum;
					Datos.J[1].bote = Datos.J[1].bote - acum;
					l.setText("Pozo: "+pozo);
				}
				if(floop==true)
				{
				acum = Datos.J[1].bote - apuestaJ2;
				pozo = pozo + acum;
				apuestaJ2 = apuestaJ2 + acum;
				Datos.J[1].bote = Datos.J[1].bote - acum;
				l.setText("Pozo: "+pozo);
			}
		  }
		 }
		}
		if(turno == 3)
		{
		if(max>apuestaJ3)
		{   
			for(int i=0;i<Maquina.MovsJugadores.length;i++)
			{
			if(apuestaJ3 == 1 && Maquina.MovsJugadores[i] == "Subir")
			{
				apuestaJ3 = 0;
			}
			}
			if(Datos.J[2].bote >= max)
			{
			acum = max - apuestaJ3;
			pozo = pozo + acum;
			apuestaJ3 = apuestaJ3 + acum;
			Datos.J[2].bote = Datos.J[2].bote - acum;
			Maquina.Dinero = Datos.J[2].bote;
			l.setText("Pozo: "+pozo);
			}
			else if(Datos.J[2].bote < max)
			{
				if(floop == false)
				{
				acum = max - apuestaJ3;
				pozo = pozo + acum;
				apuestaJ3 = apuestaJ3 + acum;
				Datos.J[2].bote = Datos.J[2].bote - acum;
				l.setText("Pozo: "+pozo);
				}
				if(floop == true)
				{
					acum = Datos.J[2].bote - apuestaJ3;
					pozo = pozo + acum;
					apuestaJ3 = apuestaJ3 + acum;
					Datos.J[2].bote = Datos.J[2].bote - acum;
					l.setText("Pozo: "+pozo);
				}
			}
		  }
		 }
		if(turno == 4)
		{
		if(max>apuestaJ4)
		{   
			for(int i=0;i<Maquina.MovsJugadores.length;i++)
			{
			if(apuestaJ4 == 1 && Maquina.MovsJugadores[i] == "Subir")
			{
				apuestaJ4 = 0;
			}
			}
			if(Datos.J[3].bote >=max)
			{
			acum = max - apuestaJ4;
			pozo = pozo + acum;
			apuestaJ4 = apuestaJ4 + acum;
			Datos.J[3].bote = Datos.J[3].bote - acum;
			Maquina.Dinero = Datos.J[3].bote;
			l.setText("Pozo: "+pozo);
			}
			else if(Datos.J[3].bote < max)
			{
				if(floop == false)
				{
				acum = max - apuestaJ4;
				pozo = pozo + acum;
				apuestaJ4 = apuestaJ4 + acum;
				Datos.J[3].bote = Datos.J[3].bote - acum;
				l.setText("Pozo: "+pozo);
				}
				if(floop == true)
				{
					acum = Datos.J[3].bote - apuestaJ4;
					pozo = pozo + acum;
					apuestaJ4 = apuestaJ4 + acum;
					Datos.J[3].bote = Datos.J[3].bote - acum;
					l.setText("Pozo: "+pozo);
					
				}
			}
		  }
		 }
		System.out.println("Pozo Actual: "+pozo);
		return acum;
	}
	
	
public static void AsignarCiegas()
{
	if(cont!=0)
	{
		cont = 0;
	}
    for(int i=0;i<Datos.J.length;i++)
    {
    	if(Datos.J[i].CiegaChica == true)
    	{
    		if(Datos.J[i].NroJugador == 4 && Datos.J[3].CiegaChica == true)
    		{
    			Datos.J[i-3].CiegaChica = true;
    			Datos.J[i].CiegaChica = false;
    		}
    		if(Datos.J[i].NroJugador != 4)
    		{
    		Datos.J[i+1].CiegaChica = true;
    		turno = i+1;
    		Datos.J[i].CiegaChica = false;
    		i++;
    		}
    	}
    	if(Datos.J[i].CiegaGrande == true)
    	{
    		if(Datos.J[i].NroJugador == 4 && Datos.J[3].CiegaGrande == true)
    		{
    			Datos.J[i-3].CiegaGrande = true;
    			Datos.J[i].CiegaGrande = false;
    		}
    		if(Datos.J[i].NroJugador != 4)
    		{
    		Datos.J[i+1].CiegaGrande = true;
    		Datos.J[i].CiegaGrande = false;
    		i++;
    		}
    	}
    }
}

/*esto es para la primera mano para saber de acuerdo a quienes tengan las ciegas lo que se apostara*/
	
	
	public static void inicioApuesta(Jugador J[],int turnoJ)
	{
		 for(int i=0;i<J.length;i++)
	     {
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaGrande == true && J[i].NroJugador == 1)
	     	{
	     		J[i].bote = J[i].bote - 2;
	     		suma = suma + 2;
	     		pozo = pozo + 2;
	     		apuestaJ1 = apuestaJ1 + suma;
	     		l.setText("Pozo: "+pozo);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j1.setText("$ "+J[i].bote);
	         	}
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaGrande == true && J[i].NroJugador == 2)
	     	{
	     		J[i].bote = J[i].bote - 2;
	     		suma1 = suma1 + 2;
	     		pozo = pozo + 2;
	     		apuestaJ2 = apuestaJ2 + suma1;
	     		l.setText("Pozo: "+pozo);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j2.setText("$ "+J[i].bote);
	         	}
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaGrande == true && J[i].NroJugador == 3)
	     	{
	     		J[i].bote = J[i].bote - 2;
	     		suma2 = suma2 + 2;
	     		pozo = pozo + 2;
	     		apuestaJ3 = apuestaJ3 + suma2;
	     		l.setText("Pozo: "+pozo);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j3.setText("$ "+J[i].bote);
	           }
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaGrande == true && J[i].NroJugador == 4)
	     	{
	     		J[i].bote = J[i].bote - 2;
	     		suma3 = suma3 + 2;
	     		pozo = pozo + 2;
	     		apuestaJ4 = apuestaJ4 + suma3;
	     		l.setText("Pozo: "+pozo);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j4.setText("$ "+J[i].bote);
	     	}
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaChica == true && J[i].NroJugador == 1)
	     	{
	     		J[i].bote = J[i].bote - 1;
	     		suma = suma + 1;
	     		pozo = pozo + 1;
	     		apuestaJ1 = apuestaJ1 + suma;
	     		l.setText("Pozo: "+pozo);
	     		l.setText("$ "+J[i].bote);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j1.setText("$ "+J[i].bote);
	     	}
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaChica == true && J[i].NroJugador == 2)
	     	{
	     		J[i].bote = J[i].bote - 1;
	     		suma1 = suma1 + 1;
	     		pozo = pozo + 1;
	     		apuestaJ2 = apuestaJ2 + suma1;
	     		l.setText("Pozo: "+pozo);
	     		l.setText("$ "+J[i].bote);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j2.setText("$ "+J[i].bote);
	         	}
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaChica == true && J[i].NroJugador == 3)
	     	{
	     		J[i].bote = J[i].bote - 1;
	     		suma2 = suma2 + 1;
	     		pozo = pozo + 1;
	     		apuestaJ3 = apuestaJ3 + suma2;
	     		l.setText("Pozo: "+pozo);
	     		l.setText("$ "+J[i].bote);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j3.setText("$ "+J[i].bote);
	         	}
	     	if(J[i].NroJugador == turnoJ && J[i].CiegaChica == true && J[i].NroJugador == 4)
	     	{
	     		J[i].bote = J[i].bote - 1;
	     		suma3 = suma3 + 1;
	     		pozo = pozo + 1;
	     		apuestaJ4 = apuestaJ4 + suma3;
	     		l.setText("Pozo: "+pozo);
	     		l.setText("$ "+J[i].bote);
	     	  	System.out.println("Jugador: "+J[i].NroJugador);
	         	System.out.println("Bote: "+J[i].bote);
	         	j4.setText("$ "+J[i].bote);
	     	}
	     }
		 mayorApuesta(apuestaJ1, apuestaJ2, apuestaJ3, apuestaJ4);
	     }
	
public static void GanaPorRetirada()
{
	if(Datos.J[0].Retirado == false)
	{
		System.out.println("Ganador: Jugador 1");
		Main.Gana = 0;
	}
	if(Datos.J[1].Retirado == false)
	{
		System.out.println("Ganador: Jugador 2");
		Main.Gana = 1;
	}
	if(Datos.J[2].Retirado == false)
	{
		System.out.println("Ganador: Jugador 3");
		Main.Gana = 2;
	}
	if(Datos.J[3].Retirado == false)
	{
		System.out.println("Ganador: Jugador 4");
		Main.Gana = 3;
	}
	for(int i=0;i<Maquina.MovsJugadores.length;i++)
		{
			Maquina.MovsJugadores[i] = null;
		}
	int cant = 0;
	for(int i=0;i<Datos.J.length;i++)
	{
		if(Datos.J[i].bote > 0)
		{
	        cant = cant + 1;
		}
		if(cant == 2)
		{
			Maquina.CantJugadores = 2;
		}
		if(cant == 3)
		{
			Maquina.CantJugadores = 3;
		}
		if(cant == 4)
		{
			Maquina.CantJugadores = 4;
		}
	}
	cant = 0;
	Datos.J[0].Retirado = false;
	Datos.J[1].Retirado = false;
	Datos.J[2].Retirado = false;
	Datos.J[3].Retirado = false;
	Main.floop = false;
	Main.Cuarta = false;
	Main.Quinta = false;
	Main.apuestaJ1 = 0;
	Main.apuestaJ2 = 0;
	Main.apuestaJ3 = 0;
	Main.apuestaJ4 = 0;
	Main.suma = 0;
	Main.suma1 = 0;
	Main.suma2 = 0;
	Main.suma3 = 0;
	Main.GanadorMesa();
	Main.turno = 0;
		Main.AsignarCiegas();
    Main.Paq1.MezclarPaq();	
	Main.Mesa= Main.Paq1.Repartir(Main.Mesa, Main.N);
	Main.ventana.repaint();
	Main.CartasJugador();

}

public static void Juego()
{
	do
	{
	if(cont != Maquina.CantJugadores)
	{
	Maquinas();
	if(Main.cont!=Maquina.CantJugadores || Cuarta == false || Maquina.CantJugadores != 1)
	{
	System.out.println("Turno Jugador: "+TurnoJugador());
	}
	}
	}while(turno!=1 && cont != Maquina.CantJugadores);
	if(turno == 1)
	{
		Ir.setVisible(true);
		Subir.setVisible(true);
		Retirarse.setVisible(true);
	}
	if(Main.cont==Maquina.CantJugadores)
 	{
		if(floop == false)
		{
 		Main.floop();
		}
		if(floop == true && Cuarta == false)
		{
			Main.Cuarta();
		}
		if(floop == true && Cuarta == true && Quinta == false)
		{
			Main.Quinta();
		}
 		for(int i=0;i<Maquina.MovsJugadores.length;i++)
 		{
 			Maquina.MovsJugadores[i] = null;
 		}
 	}
}
	
/*Esto es para sacar que jugador es el que mas aposto y luego sacar la diferencia para poder igualar la apuesta*/
	
	public static void mayorApuesta(int suma,int suma1,int suma2,int suma3)
	{	
		if(max<suma)
		{
			max = suma;
		}
		if(max<suma1)
		{
			max = suma1;
		}
		if(max<suma2)
		{
			max = suma2;
		}
		if(max<suma3)
		{
			max = suma3;
		}
		System.out.println("Mayor Apuesta: "+max);
	}
	

/*Esto es para actualizar la mesa de acuerdo al jugador que gano y para poner el pozo en 0*/
public static void GanadorMesa()
{
	if(Main.Gana == 0)
		{
			Datos.J[0].bote = Datos.J[0].bote + Main.pozo;
			Main.pozo = 0;
		}
		if(Main.Gana == 1)
		{
			Datos.J[1].bote = Datos.J[1].bote + Main.pozo;
			Main.pozo = 0;
		}
		if(Main.Gana == 2)
		{
			Datos.J[2].bote = Datos.J[2].bote + Main.pozo;
			Main.pozo = 0;
		}
		if(Main.Gana == 3)
		{
			Datos.J[3].bote = Datos.J[3].bote + Main.pozo;
			Main.pozo = 0;
		}
		Main.ActualizarMesa();
		Main.l.setText("Pozo: "+Main.pozo);
		max = 0;
		Datos.J[0].Retirado = false;
		Datos.J[1].Retirado = false;
		Datos.J[2].Retirado = false;
		Datos.J[3].Retirado = false;
}


/*Esto es para saber el turno de que jugador es*/
	
	public static int TurnoJugador()
	{
		int turnos = turno;
		turno++;
		if(turnos == 1 && Datos.J[1].Retirado == true)
		{
			turno = turno++;
			turnos = turnos++;
			}
		if(turnos == 2 && Datos.J[2].Retirado == true)
		{
			turno++;
			turnos++;
		}
		if(turnos == 3 && Datos.J[3].Retirado == true)
		{
			turno++;
			turnos++;
		}
			
		if(turnos == 4 && Datos.J[0].Retirado == true)
		{
			turnos=0;
			turnos = turnos + 1;
			turno=0;
			turno = turno + 2;
		}
		if(turnos == 4 && Datos.J[0].Retirado == false)
		{
			turnos = 0;
			turno = 0;
			turno++;
		}
		return turnos+1;
	}
	
	
/*Esto es para actualizar el dinero de cada jugador que aparece en mesa*/
	
	public static void ActualizarMesa()
	{
		if(turno == 1 || Gana == 0)
		{
			j1.setText("$ "+Datos.J[0].bote);
		}
		if(turno == 2 || Gana == 1)
		{
			j2.setText("$ "+Datos.J[1].bote);
		}
		if(turno == 3 || Gana == 2)
		{
			j3.setText("$ "+Datos.J[2].bote);
		}
		if(turno == 4 || Gana == 3)
		{
			j4.setText("$ "+Datos.J[3].bote);
		}
	}
	
	
	
	
/*Esto es para que haga determinada accion de acuerdo al turno de cada jugador y a lo que eligio*/
	
public static void Maquinas()
{
	if(turno == 2 && Maquina.MovsJugadores[1] != "Retirarse")
	 {
		if(floop == true && Cuarta == false && Quinta == false)
		{
		 Maquina.Dinero = Datos.J[1].bote;
		 Maquina.Maq(3, Datos.J[1].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
		   Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0; 
		}
		if(Cuarta == true && Quinta == false)
		{
			 Maquina.Dinero = Datos.J[1].bote;
			Maquina.Maq(4, Datos.J[1].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);	
			   Maquina.ContIr = 0;
			    Maquina.ContRetirarse = 0;
			    Maquina.ContSubir = 0;
		}
		if(Quinta == true)
		{
			Maquina.Dinero = Datos.J[1].bote;
			Maquina.Maq(5, Datos.J[1].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
			   Maquina.ContIr = 0;
			    Maquina.ContRetirarse = 0;
			    Maquina.ContSubir = 0;
		}
		if(floop == false && Cuarta == false && Quinta == false)
		{
			Maquina.Dinero = Datos.J[1].bote;
			Maquina.Maq(0, Datos.J[1].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);	
		    Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0;
		}
		 if(Maquina.AccionMaquina == "Ir")
		 {
			 cont = cont + 1;
			 Maquina.MovsJugadores[1] = "Ir";
			 JLabel accion = new JLabel();
			 accion.setText("Ir");
			 accion.setBounds(100, 156, 100, 30);
		     accion.setForeground(Color.black);
		     Font f = new Font("Times New Roman",Font.BOLD,22);
		     accion.setFont(f);
			 ventana.add(accion);
			 
			 if(max>apuestaJ2)
			 {
			 calcular_pozo(turno);
			 ActualizarMesa();
			 }
			 }
		 if(Maquina.AccionMaquina == "Subir")
		 {
			 Maquina.MovsJugadores[1] = "Subir";
			 pozo = pozo + Maquina.DineroApuesta;
			 Datos.J[1].bote = Datos.J[1].bote - Maquina.DineroApuesta;
			 l.setText("Pozo: "+pozo);
			 ActualizarMesa();
			 max = pozo;
		 }
		 if(Maquina.AccionMaquina == "Retirarse")
		 {
			 Maquina.MovsJugadores[1] = "Retirarse";
			 Maquina.CantJugadores = Maquina.CantJugadores - 1;
			 Datos.J[1].Retirado = true;
		 }
		 Maquina.PosibilidadGanar = 0;
	 } 
if(turno == 3 && Maquina.MovsJugadores[2] != "Retirarse")
{
	if(floop == true && Cuarta == false && Quinta == false)
	{
		 Maquina.Dinero = Datos.J[2].bote;
	 Maquina.Maq(3, Datos.J[2].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
	   Maquina.ContIr = 0;
	    Maquina.ContRetirarse = 0;
	    Maquina.ContSubir = 0; 
	}
	if(Cuarta == true && Quinta == false)
	{
		 Maquina.Dinero = Datos.J[2].bote;
		Maquina.Maq(4, Datos.J[2].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
		   Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0;	
	}
	if(Quinta == true)
	{
		Maquina.Dinero = Datos.J[1].bote;
		Maquina.Maq(5, Datos.J[1].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
		   Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0;
	}
	if(floop == false && Cuarta == false && Quinta == false)
	{
		 Maquina.Dinero = Datos.J[2].bote;
		Maquina.Maq(0, Datos.J[2].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);	
		   Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0;
	}
		
	 if(Maquina.AccionMaquina == "Ir")
	 {
		 cont = cont + 1;
		 Maquina.MovsJugadores[2] = "Ir";
		 if(max>apuestaJ3)
		 {
		    calcular_pozo(turno);
		    ActualizarMesa();

		 }
		 }
	 if(Maquina.AccionMaquina == "Subir")
	 {
		 Maquina.MovsJugadores[2] = "Subir";
		 pozo = pozo + Maquina.DineroApuesta;
		 Datos.J[2].bote = Datos.J[2].bote - Maquina.DineroApuesta;
		 l.setText("Pozo: "+pozo);
		 ActualizarMesa();
		 max = pozo;
	 }
	 if(Maquina.AccionMaquina == "Retirarse")
	 {
		 Maquina.MovsJugadores[2] = "Retirarse";
		 Maquina.CantJugadores = Maquina.CantJugadores - 1;
		 Datos.J[2].Retirado = true;
	 }
	 Maquina.PosibilidadGanar = 0;
}
if(turno == 4 && Maquina.MovsJugadores[3] != "Retirarse")
{
	if(floop == true && Cuarta == false && Quinta == false)
	{
		 Maquina.Dinero = Datos.J[3].bote;
	 Maquina.Maq(3, Datos.J[3].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
	   Maquina.ContIr = 0;
	    Maquina.ContRetirarse = 0;
	    Maquina.ContSubir = 0; 
	}
	if(Cuarta == true && Quinta == false)
	{
		 Maquina.Dinero = Datos.J[3].bote;
		Maquina.Maq(4, Datos.J[3].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
		   Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0;	
	}
	if(Quinta == true)
	{
		Maquina.Dinero = Datos.J[1].bote;
		Maquina.Maq(5, Datos.J[1].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);
		   Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0;
	}
	if(floop == false && Cuarta == false && Quinta == false)
	{
		 Maquina.Dinero = Datos.J[3].bote;
		Maquina.Maq(0, Datos.J[3].bote, pozo,Carta.cartas,Carta.palos, Maquina.MesaPalos,Maquina.MesaCartas , Mesa, turno, Maquina.MovsJugadores, Maquina.CantJugadores);	
		   Maquina.ContIr = 0;
		    Maquina.ContRetirarse = 0;
		    Maquina.ContSubir = 0;
	}	
	 if(Maquina.AccionMaquina == "Ir")
	 {
		 cont = cont + 1;
		 Maquina.MovsJugadores[3] = "Ir";
		 if(max>apuestaJ4)
		 {
		 calcular_pozo(turno);
		 ActualizarMesa();
		 }
		 }
	 if(Maquina.AccionMaquina == "Subir")
	 {
		 Maquina.MovsJugadores[3] = "Subir";
		 pozo = pozo + Maquina.DineroApuesta;
		 Datos.J[3].bote = Datos.J[3].bote - Maquina.DineroApuesta;
		 l.setText("Pozo: "+pozo);
		 ActualizarMesa();
		 max = pozo;
	 }
	 if(Maquina.AccionMaquina == "Retirarse")
	 {  
		 Maquina.MovsJugadores[3] = "Retirarse";
		 Maquina.CantJugadores = Maquina.CantJugadores - 1;
		 Datos.J[3].Retirado = true;
	 }
	 Maquina.PosibilidadGanar = 0;
} 
}


public static void ganador()
{
	Carta[] Mejor = new Carta[5];
	int[] Punts = new int[N];
	int Max=0;
	Utils.trace("");
	int cont=0;
	for(i=0;i<N;i++)
	{
		if(Datos.J[i].Retirado == false)
		{
		Punts[i]=Puntaje(Mesa,i);
		switch(Punts[i])
		{
			case 10:
				Utils.trace("Jugador " + i + ": Escalera real");
			break;
			case 9:
				Utils.trace("Jugador " + i + ": Escalera de Color");
			break;
			case 8:
				Utils.trace("Jugador " + i + ": Poquer");
			break;
			case 7:
				Utils.trace("Jugador " + i + ": Full");
			break;
			case 6:
				Utils.trace("Jugador " + i + ": Color");
			break;
			case 5:
				Utils.trace("Jugador " + i + ": Escalera");
			break;
			case 4:
				Utils.trace("Jugador " + i + ": Trio");
			break;
			case 3:
				Utils.trace("Jugador " + i + ": Doble Pareja");
			break;
			case 2:
				Utils.trace("Jugador " + i + ": Pareja");
			break;
			case 1:
				Utils.trace("Jugador " + i + ": Ningun juego");
			break;				
		}
		if(Punts[i]>Max)
		{
			Max=Punts[i];
			Gana=i;
			cont=0;
		}
		if(Punts[i]==Max) cont++;
	}
}
	if(cont==1)
	{
		Utils.trace("Ganador: Jugador " + Gana);
	}
	else
	{
		int[] CM = new int[N];
		int aux=0;
		switch(Max)
		{
			case 10: //EscReal
				Utils.trace("El pozo se divide en " + cont);
			break;
			case 9://EscCol
				cont=0;
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					Mejor=getEscCol(Mesa,i);
					CM[i]=Mejor[0].Valor;
					}
				}
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					if(Punts[i]==Max)
					{
						if(CM[i]>aux) 
						{
							aux=CM[i];
							cont=0;
							Gana=i;
						}
						if(CM[i]==aux) cont++;
					}
					}
				}
				if(cont!=1) //2 jugadores
				{
					Utils.trace("El pozo se divide en " + cont);
				}
				else
				{
					Utils.trace("Ganador: Jugador " + Gana);
				}
			break;
			case 8:	//Poquer				
				cont=0;
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					Mejor=getPoquer(Mesa,i);
					CM[i]=Mejor[0].Valor;
					}
				}
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					if(Punts[i]==Max)
					{
						if(CM[i]>aux) 
						{
							aux=CM[i];
							cont=0;
							Gana=i;
						}
						if(CM[i]==aux) cont++;
					}
					}
				}
				
				if(cont!=1) //2 jugadores
				{
					cont=0;
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						Mejor=getPoquer(Mesa,i);
						CM[i]=Mejor[4].Valor;
						}
					}
					
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						if(Punts[i]==Max)
						{
							if(CM[i]>aux) 
							{
								aux=CM[i];
								cont=0;
								Gana=i;
							}
							if(CM[i]==aux) cont++;
						}
					  }
					}
					if(cont!=1) 
					{
						Utils.trace("El pozo se divide en " + cont);
					}
					else
					{
						Utils.trace("Ganador: Jugador " + Gana);
					}

				}
				else
				{
					Utils.trace("Ganador: Jugador " + Gana);
				}
				
			break;
			case 7: //Full
				
				cont=0;
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					Mejor=getFull(Mesa,i);
					CM[i]=Mejor[0].Valor;
					}
				}
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					if(Punts[i]==Max)
					{
						if(CM[i]>aux) 
						{
							aux=CM[i];
							cont=0;
							Gana=i;
						}
						if(CM[i]==aux) cont++;
					}
					}
				}
				
				if(cont!=1) //2 jugadores
				{
					cont=0;
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						Mejor=getFull(Mesa,i);
						CM[i]=Mejor[3].Valor;
						}
					}
					
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						if(Punts[i]==Max)
						{
							if(CM[i]>aux) 
							{
								aux=CM[i];
								cont=0;
								Gana=i;
							}
							if(CM[i]==aux) cont++;
						}
						}
					}
					if(cont!=1) 
					{
						Utils.trace("El pozo se divide en " + cont);
					}
					else
					{
						Utils.trace("Ganador: Jugador " + Gana);
					}

				}
				else
				{
					Utils.trace("Ganador: Jugador " + Gana);
				}

				
			break;
			case 6: //Color
				Utils.trace("El pozo se divide en " + cont);
			break;
			case 5: //Escalera
				cont=0;
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					Mejor=getEscalera(Mesa,i);
					CM[i]=Mejor[0].Valor;
					}
				}
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					if(Punts[i]==Max)
					{
						if(CM[i]>aux) 
						{
							aux=CM[i];
							cont=0;
							Gana=i;
						}
						if(CM[i]==aux) cont++;
					}
					}
				}
				if(cont!=1) 
				{
					Utils.trace("El pozo se divide en " + cont);
				}
				else
				{
					Utils.trace("Ganador: Jugador " + Gana);
				}
			break;
			case 4://Trio

				cont=0;
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					Mejor=getTrio(Mesa,i);
					CM[i]=Mejor[0].Valor;
					}
				}
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					if(Punts[i]==Max)
					{
						if(CM[i]>aux) 
						{
							aux=CM[i];
							cont=0;
							Gana=i;
						}
						if(CM[i]==aux) cont++;
					}
					}
				}
				
				if(cont!=1) 
				{
					cont=0;
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						Mejor=getTrio(Mesa,i);
						CM[i]=Mejor[3].Valor;
						}
					}
					
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						if(Punts[i]==Max)
						{
							if(CM[i]>aux) 
							{
								aux=CM[i];
								cont=0;
								Gana=i;
							}
							if(CM[i]==aux) cont++;
						}
						}
					}
					if(cont!=1) 
					{
						cont=0;
						for(i=0;i<N;i++)
						{
							if(Datos.J[i].Retirado == false)
							{
							Mejor=getTrio(Mesa,i);
							CM[i]=Mejor[4].Valor;
							}
						}
						
						for(i=0;i<N;i++)
						{
							if(Datos.J[i].Retirado == false)
							{
							if(Punts[i]==Max)
							{
								if(CM[i]>aux) 
								{
									aux=CM[i];
									cont=0;
									Gana=i;
								}
								if(CM[i]==aux) cont++;
							}
							}
						}
						if(cont!=1) 
						{
							Utils.trace("El pozo se divide en " + cont);
						}
						else
						{
							Utils.trace("Ganador: Jugador " + Gana);
						}

					}
					else
					{
						Utils.trace("Ganador: Jugador " + Gana);
					}

				}
				else
				{
					Utils.trace("Ganador: Jugador " + Gana);
				}

			break;
			case 3: //Doble Pareja	
				cont=0;
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					Mejor=getDoblePar(Mesa,i);
					CM[i]=Mejor[0].Valor;
					}
				}
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					if(Punts[i]==Max)
					{
						if(CM[i]>aux) 
						{
							aux=CM[i];
							cont=0;
							Gana=i;
						}
						if(CM[i]==aux) cont++;
					}
					}
				}
				
				if(cont!=1) 
				{
					cont=0;
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						Mejor=getDoblePar(Mesa,i);
						CM[i]=Mejor[2].Valor;
						}
					}
					
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						if(Punts[i]==Max)
						{
							if(CM[i]>aux) 
							{
								aux=CM[i];
								cont=0;
								Gana=i;
							}
							if(CM[i]==aux) cont++;
						}
						}
					}
					if(cont!=1) 
					{
						cont=0;
						for(i=0;i<N;i++)
						{
							if(Datos.J[i].Retirado == false)
							{
							Mejor=getDoblePar(Mesa,i);
							CM[i]=Mejor[4].Valor;
							}
						}
						
						for(i=0;i<N;i++)
						{
							if(Datos.J[i].Retirado == false)
							{
							if(Punts[i]==Max)
							{
								if(CM[i]>aux) 
								{
									aux=CM[i];
									cont=0;
									Gana=i;
								}
								if(CM[i]==aux) cont++;
							}
							}
						}
						if(cont!=1) 
						{
							Utils.trace("El pozo se divide en " + cont);
						}
						else
						{
							Utils.trace("Ganador: Jugador " + Gana);
						}

					}
					else
					{
						Utils.trace("Ganador: Jugador " + Gana);
					}

				}
				else
				{
					Utils.trace("Ganador: Jugador " + Gana);
				}

			break;
			case 2:	//Pareja
				cont=0;
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					Mejor=getPar(Mesa,i);
					CM[i]=Mejor[0].Valor;
					}
				}
				
				for(i=0;i<N;i++)
				{
					if(Datos.J[i].Retirado == false)
					{
					if(Punts[i]==Max)
					{
						if(CM[i]>aux) 
						{
							aux=CM[i];
							cont=0;
							Gana=i;
						}
						if(CM[i]==aux) cont++;
					}
					}
				}
				
				if(cont!=1) 
				{
					cont=0;
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						Mejor=getPar(Mesa,i);
						CM[i]=Mejor[2].Valor;
						}
					}
					
					for(i=0;i<N;i++)
					{
						if(Datos.J[i].Retirado == false)
						{
						if(Punts[i]==Max)
						{
							if(CM[i]>aux) 
							{
								aux=CM[i];
								cont=0;
								Gana=i;
							}
							if(CM[i]==aux) cont++;
						}
						}
					}
					if(cont!=1) 
					{
						cont=0;
						for(i=0;i<N;i++)
						{
							if(Datos.J[i].Retirado == false)
							{
							Mejor=getPar(Mesa,i);
							CM[i]=Mejor[3].Valor;
							}
						}
						
						for(i=0;i<N;i++)
						{
							if(Datos.J[i].Retirado == false)
							{
							if(Punts[i]==Max)
							{
								if(CM[i]>aux) 
								{
									aux=CM[i];
									cont=0;
									Gana=i;
								}
								if(CM[i]==aux) cont++;
							}
							}
						}
						if(cont!=1) 
						{
							cont=0;
							for(i=0;i<N;i++)
							{
								if(Datos.J[i].Retirado == false)
								{
								Mejor=getPar(Mesa,i);
								CM[i]=Mejor[4].Valor;
								}
							}
							
							for(i=0;i<N;i++)
							{
								if(Datos.J[i].Retirado == false)
								{
								if(Punts[i]==Max)
								{
									if(CM[i]>aux) 
									{
										aux=CM[i];
										cont=0;
										Gana=i;
									}
									if(CM[i]==aux) cont++;
								}
								}
							}
							if(cont!=1) 
							{
								Utils.trace("El pozo se divide en " + cont);
							}
							else
							{
								Utils.trace("Ganador: Jugador " + Gana);
							}

						}
						else
						{
							Utils.trace("Ganador: Jugador " + Gana);
						}

					}
					else
					{
						Utils.trace("Ganador: Jugador " + Gana);
					}

				}
				else
				{
					Utils.trace("Ganador: Jugador " + Gana);
				}
			break;
			case 1:
				Gana=JMayorCarta(Mesa);
				Utils.trace("Ganador: Jugador " + Gana);
									
			break;
		}
	}
}

public static boolean probarEscReal(Carta[][] Mesa, int Jug)
{
	Carta[] Mano = new Carta[7];
	Mano=ObtenerMano(Mesa,Jug);
	Carta aux;
	int i=0,j,cont=0,a=0;
	String SuitEsc="";
	do//(i=0;i<7;i++)
	{
		for(j=0;j<7;j++)
		{
			if(Mano[j].Suit.equals(Mano[i].Suit)) cont++;
		}
		if(cont>=5)
		{
			a=1;
			SuitEsc=Mano[i].Suit;
		}
		i++;
	}while(i<7&&a!=1);
	if(a==0)
	{
		return false;
	}
	else
	{
		for(i=0;i<7;i++)
		{
			if(Mano[i].Suit.equals(SuitEsc)==false)
			{
				aux=Mano[i];
				for(j=i;j<6;j++)
				{
					Mano[j]=Mano[j+1];
				}
				Mano[6]=aux;
			}
		}	
			if(Mano[0].Valor!=14) return false;
			else
			{
				if(Mano[1].Valor!=13) return false;
				else
				{
					if(Mano[2].Valor!=12) return false;
					else
					{
						if(Mano[3].Valor!=11) return false;
						else
						{
							if(Mano[4].Valor!=10) return false;
							else return true;
						}
					}
				}
			}
		
	}
}

public static Carta[] getEscReal(Carta[][] Mesa, int Jug)
{
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;
	
	Carta[] Mano = new Carta[7];
	Carta[] Mejor = new Carta[5];
	Mano=ObtenerMano(Mesa,Jug);
	Carta aux;
	int i=0,j,cont=0,a=0;
	String SuitEsc="";
	if(probarEscReal(Mesa,Jug)==false) return Void;
	else
	{
	do//(i=0;i<7;i++)
	{
		for(j=0;j<7;j++)
		{
			if(Mano[j].Suit.equals(Mano[i].Suit)) cont++;
		}
		if(cont>=5)
		{
			a=1;
			SuitEsc=Mano[i].Suit;
		}
		i++;
	}while(i<7&&a!=1);
	
		for(i=0;i<7;i++)
		{
			if(Mano[i].Suit.equals(SuitEsc)==false)
			{
				aux=Mano[i];
				for(j=i;j<6;j++)
				{
					Mano[j]=Mano[j+1];
				}
				Mano[6]=aux;
			}
		}	
		
		for(i=0;i<5;i++)
		{
			Mejor[i]=Mano[i];
		}
		return Mejor;		
	}
}

public static boolean probarEscCol(Carta[][] Mesa, int Jug)
{
	int i=0,a=0,j,cont=0;
	String SuitEsc="";
	Carta aux;
	do//(i=0;i<7;i++)
	{
		for(j=0;j<7;j++)
		{
			if(Mesa[j][Jug].Suit.equals(Mesa[i][Jug].Suit)) cont++;
		}
		if(cont>=5)
		{
			a=1;
			SuitEsc=Mesa[i][Jug].Suit;
		}
		i++;
	}while(i<7&&a!=1);
	if(a==0)
	{
		return false;
	}
	else
	{
		Carta[] Mano = new Carta[7];
		Mano=ObtenerMano(Mesa,Jug);
		
		for(i=0;i<7;i++)
		{
			if(Mano[i].Valor==5)
			{
				for(j=0;j<7;j++)
				{
					if(Mano[j].Valor==4)
					{
						for(int k=0;k<7;k++)
						{
							if(Mano[k].Valor==3)
							{
								for(int m=0;m<7;m++)
								{						
									if(Mano[m].Valor==2)
									{
										for(int l=0;l<7;l++)
										{
											if(Mano[l].Valor==14)
											{
												Mano[l].Valor=1;
												Mano=Ordenar(Mano);	 
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		for(i=0;i<7;i++)
		{
			if(Mano[i].Suit.equals(SuitEsc)==false)
			{
				aux=Mano[i];
				for(j=i;j<6;j++)
				{
					Mano[j]=Mano[j+1];
				}
				Mano[6]=aux;
			}
		}
		
					if(Mano[2].Valor==(Mano[3].Valor+1)&&Mano[4].Valor==(Mano[3].Valor-1))
		{
			if(Mano[1].Valor==(Mano[2].Valor+1))
			{
				if(Mano[0].Valor==(Mano[1].Valor+1))
				{
					if(Mano[0].Suit.equals(SuitEsc)&&Mano[1].Suit.equals(SuitEsc)&&Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc))
					{
						return true;
					}
					else return false;
				}
				else
				{
					if(Mano[5].Valor==(Mano[4].Valor-1))
					{
						if(Mano[1].Suit.equals(SuitEsc)&&Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc)&&Mano[5].Suit.equals(SuitEsc))
						{
							return true;
						}
						else return false;
					}
					else return false;					
				}
			}
			else
			{
				if(Mano[5].Valor==(Mano[4].Valor-1))
				{
					if(Mano[6].Valor==(Mano[5].Valor-1))
					{
						if(Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc)&&Mano[5].Suit.equals(SuitEsc)&&Mano[6].Suit.equals(SuitEsc))
						{
							return true;
						}
						else return false;
					}
					else 
					{	
						if(Mano[1].Valor==(Mano[2].Valor+1))
						{
							if(Mano[1].Suit.equals(SuitEsc)&&Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc)&&Mano[5].Suit.equals(SuitEsc))
							{
								return true;
							}
							else return false;
						}
						else return false;					
					}
				}
				else return false;
			}
		}
		else return false;
	}	
}

public static Carta[] getEscCol(Carta[][] Mesa, int Jug)
{
	int i=0,a=0,j,cont=0;
	String SuitEsc="";
	Carta aux;
	do//(i=0;i<7;i++)
	{
		for(j=0;j<7;j++)
		{
			if(Mesa[j][Jug].Suit.equals(Mesa[i][Jug].Suit)) cont++;
		}
		if(cont>=5)
		{
			a=1;
			SuitEsc=Mesa[i][Jug].Suit;
		}
		i++;
	}while(i<7&&a!=1);
	
		Carta[] Mano = new Carta[7];
		Carta[] Mejor = new Carta[5];
		Carta CVoid = new Carta();
		CVoid.Valor=-1;
		CVoid.Simbolo="-1";
		CVoid.Suit="-1";
		Carta[] Void = new Carta[5];
		Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;
		Mano=ObtenerMano(Mesa,Jug);
		
		for(i=0;i<7;i++)
		{
			if(Mano[i].Valor==5)
			{
				for(j=0;j<7;j++)
				{
					if(Mano[j].Valor==4)
					{
						for(int k=0;k<7;k++)
						{
							if(Mano[k].Valor==3)
							{
								for(int m=0;m<7;m++)
								{						
									if(Mano[m].Valor==2)
									{
										for(int l=0;l<7;l++)
										{
											if(Mano[l].Valor==14)
											{
												Mano[l].Valor=1;
												Mano=Ordenar(Mano);	 
											}
										}}}}}}}}}

		for(i=0;i<7;i++)
		{
			if(Mano[i].Suit.equals(SuitEsc)==false)
			{
				aux=Mano[i];
				for(j=i;j<6;j++)
				{
					Mano[j]=Mano[j+1];
				}
				Mano[6]=aux;
			}
		}
		
		if(Mano[2].Valor==(Mano[3].Valor+1)&&Mano[4].Valor==(Mano[3].Valor-1))
		{
			if(Mano[1].Valor==(Mano[2].Valor+1))
			{
				if(Mano[0].Valor==(Mano[1].Valor+1))
				{
					if(Mano[0].Suit.equals(SuitEsc)&&Mano[1].Suit.equals(SuitEsc)&&Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc))
					{
						Mejor[0]=Mano[0];
						Mejor[1]=Mano[1];
						Mejor[2]=Mano[2];
						Mejor[3]=Mano[3];
						Mejor[4]=Mano[4];
						return Mejor;
					}
					else return Void;
				}
				else
				{
					if(Mano[5].Valor==(Mano[4].Valor-1))
					{
						if(Mano[1].Suit.equals(SuitEsc)&&Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc)&&Mano[5].Suit.equals(SuitEsc))
						{
							Mejor[0]=Mano[1];
							Mejor[1]=Mano[2];
							Mejor[2]=Mano[3];
							Mejor[3]=Mano[4];
							Mejor[4]=Mano[5];
							return Mejor;
						}
						else return Void;
					}
					else return Void;					
				}
			}
			else
			{
				if(Mano[5].Valor==(Mano[4].Valor-1))
				{
					if(Mano[6].Valor==(Mano[5].Valor-1))
					{
						if(Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc)&&Mano[5].Suit.equals(SuitEsc)&&Mano[6].Suit.equals(SuitEsc))
						{
							Mejor[0]=Mano[2];
							Mejor[1]=Mano[3];
							Mejor[2]=Mano[4];
							Mejor[3]=Mano[5];
							Mejor[4]=Mano[6];
							return Mejor;
						}
						else return Void;
					}
					else 
					{	
						if(Mano[1].Valor==(Mano[2].Valor+1))
						{
							if(Mano[1].Suit.equals(SuitEsc)&&Mano[2].Suit.equals(SuitEsc)&&Mano[3].Suit.equals(SuitEsc)&&Mano[4].Suit.equals(SuitEsc)&&Mano[5].Suit.equals(SuitEsc))
							{
								Mejor[0]=Mano[1];
								Mejor[1]=Mano[2];
								Mejor[2]=Mano[3];
								Mejor[3]=Mano[4];
								Mejor[4]=Mano[5];
								return Mejor;
							}
							else return Void;
						}
						else return Void;					
					}
				}
				else return Void;
			}
		}
		else return Void;
}

public static boolean probarPoquer(Carta[][] Mesa, int Jug)
{
	Carta[] Mano= new Carta[7];
	Mano=ObtenerMano(Mesa,Jug);
	int i=0,j,cont=0,a=0;
	do
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mano[j].Valor==Mano[i].Valor) cont++;
		}
		if(cont==4)	a=1;
		i++;
	}while(i<7&&a!=1);
	
	if(a==1) return true;
	else return false;
}

public static Carta[] getPoquer(Carta[][] Mesa, int Jug)
{
	Carta[] Mano= new Carta[7];
	Mano=ObtenerMano(Mesa,Jug);
	int i=0,j,cont=0,a=0,ValPoq=0;
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;

	if(probarPoquer(Mesa,Jug)==false) return Void;
	else
	{
	do
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mano[j].Valor==Mano[i].Valor) cont++;
		}
		if(cont==4)
		{
			a=1;
			ValPoq=Mano[i].Valor;
		}
		i++;
	}while(i<7&&a!=1);
	j=0;
	
	Carta[] Mejor = new Carta[5];
	j=0;
	for(i=0;i<7;i++)
	{
		if(Mano[i].Valor==ValPoq)
		{
			Mejor[j]=Mano[i];
			j++;
		}
	}
	i=0;
	a=0;
	do
	{
		if(Mano[i].Valor!=ValPoq)
		{
			Mejor[j]=Mano[i];
			j++;
			a=1;
		}
		i++;
	}while(a==0);
	
	return Mejor;
	}
}

public static boolean probarFull(Carta[][] Mesa, int Jug)
{
	Carta[] Mano= new Carta[5];
	Mano=ObtenerMano(Mesa,Jug);
	
	int Primer=0,i=0,j,cont=0,a=0;
	do
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mano[j].Valor==Mano[i].Valor) cont++;
		}
		if(cont==3)
		{
			a=1;
			Primer=Mano[i].Valor;
		}
		i++;
	}while(i<7&&a!=1);
	i=0;
	if(a==1)
	{
		a=0;
		do
		{
			for(j=0;j<7;j++)
			{
				if(Mano[i].Valor==Mano[j].Valor&&Mano[i].Valor!=Primer) cont++;
			}
			if(cont==2) a=1;
			i++;
		}while(i<7&&a!=1);
		if(a==1) return true;
		else return false;
	}
	else return false;
}

public static Carta[] getFull(Carta[][] Mesa, int Jug)
{
	Carta[] Mano= new Carta[7];
	Mano=ObtenerMano(Mesa,Jug);
	Carta[] Mejor = new Carta[5];
	int Trio=0,Pareja=0,i=0,j,cont=0,a=0;
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;
	
	if(probarFull(Mesa,Jug)==false) return Void;
	else
	{
	do
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mano[j].Valor==Mano[i].Valor) cont++;
		}
		if(cont==3)
		{
			a=1;
			Trio=Mano[i].Valor;
		}
		i++;
	}while(i<7&&a!=1);
	
		a=0;
		i=0;
		do
		{
			cont=0;
			for(j=0;j<7;j++)
			{
				if(Mano[i].Valor==Mano[j].Valor&&Mano[i].Valor!=Trio) cont++;
			}
			if(cont==2)
			{
				a=1;
				Pareja=Mano[i].Valor;
			}
			i++;
		}while(i<7&&a!=1);
		j=0;
			for(i=0;i<7;i++)
			{
				if(Mano[i].Valor==Trio)
					{
						Mejor[j]=Mano[i];
						j++;
					}
			}
			for(i=0;i<7;i++)
			{
				if(Mano[i].Valor==Pareja) 	
				{
					Mejor[j]=Mano[i];
					j++;
				}
			}	
	
	return Mejor;
	}
}

public static boolean probarColor(Carta[][] Mesa, int Jug)
{
	int a=0,i=0,j,cont=0;
	do//(i=0;i<7;i++)
	{	
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mesa[j][Jug].Suit.equals(Mesa[i][Jug].Suit)) cont++;
		}
		if(cont>=5) a=1;
		
		i++;
	}while(i<7&&a!=1);
	if(a==0)return false;
	else return true;
	
}

public static Carta[] getColor(Carta[][] Mesa, int Jug)
{
	int a=0,i=0,j,cont=0;
	Carta[] Mano = new Carta[7];
	Carta[] Mejor = new Carta[5];
	String SuitC="";
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;
	
	if(probarColor(Mesa,Jug)==false) return Void;
	else
	{
	Mano=ObtenerMano(Mesa,Jug);
	do//(i=0;i<7;i++)
	{	
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mano[j].Suit.equals(Mano[i].Suit)) cont++;
		}
		if(cont>=5)
		{
			SuitC=Mano[i].Suit;
			a=1;
		}
		
		i++;
	}while(i<7&&a!=1);
	j=0;
	for(i=0;i<7;i++)
	{
		if(Mano[i].Suit.equals(SuitC)) 
		{
			Mejor[j]=Mano[i];
			j++;
		}
	}
	return Mejor;
	}
}

public static boolean probarEscalera(Carta[][] Mesa,int Jug)
{
	Carta[] Mano = new Carta[7];
	Mano=ObtenerMano(Mesa,Jug);
	
	for(int i=0;i<7;i++)
	{
		if(Mano[i].Valor==5)
		{
			for(int j=0;j<7;j++)
			{
				if(Mano[j].Valor==4)
				{
					for(int k=0;k<7;k++)
					{
						if(Mano[k].Valor==3)
						{
							for(int m=0;m<7;m++)
							{
						
								if(Mano[m].Valor==2)
								{
									for(int l=0;l<7;l++)
									{
										if(Mano[l].Valor==14)
										{
											Mano[l].Valor=1;
											Mano=Ordenar(Mano);	 
										}
									}}}}}}}}}

	
	Carta aux;
	for(int i=1;i<7;i++)
	{
		if(Mano[i].Valor==Mano[i-1].Valor)
		{
			aux=Mano[i];
			for(int j=i;j<6;j++)
			{
				Mano[j]=Mano[j+1];
			}
			Mano[6]=aux;

		}
	}
	if(Mano[2].Valor==(Mano[3].Valor+1)&&Mano[4].Valor==(Mano[3].Valor-1))
	{
		if(Mano[1].Valor==(Mano[2].Valor+1))
		{
			if(Mano[0].Valor==(Mano[1].Valor+1))
			{
				return true;
			}
			else
			{
				if(Mano[5].Valor==(Mano[4].Valor-1))
				{
					return true;
				}
				else return false;					
			}
		}
		else
		{
			if(Mano[5].Valor==(Mano[4].Valor-1))
			{
				if(Mano[6].Valor==(Mano[5].Valor-1))
				{
					return true;
				}
				else 
				{	
					if(Mano[1].Valor==(Mano[2].Valor+1))
					{
						return true;
					}
					else return false;					
				}
			}
			else return false;
		}
	}
	else return false;
}

public static Carta[] getEscalera(Carta[][] Mesa,int Jug)
{
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;

	if(probarEscalera(Mesa,Jug)==false) return Void;
	else
	{
	Carta[] Mano = new Carta[7];
	Mano=ObtenerMano(Mesa,Jug);
	
	for(int i=0;i<7;i++)
	{
		if(Mano[i].Valor==5)
		{
			for(int j=0;j<7;j++)
			{
				if(Mano[j].Valor==4)
				{
					for(int k=0;k<7;k++)
					{
						if(Mano[k].Valor==3)
						{
							for(int m=0;m<7;m++)
							{
						
								if(Mano[m].Valor==2)
								{
									for(int l=0;l<7;l++)
									{
										if(Mano[l].Valor==14)
										{
											Mano[l].Valor=1;
											Mano=Ordenar(Mano);	 
										}
									}}}}}}}}}

	Carta aux;
	for(int i=1;i<7;i++)
	{
		if(Mano[i].Valor==Mano[i-1].Valor)
		{
			aux=Mano[i];
			for(int j=i;j<6;j++)
			{
				Mano[j]=Mano[j+1];
			}
			Mano[6]=aux;

		}
	}
	Carta[] Mejor = new Carta[5];
	if(Mano[2].Valor==(Mano[3].Valor+1)&&Mano[4].Valor==(Mano[3].Valor-1))
	{
		if(Mano[1].Valor==(Mano[2].Valor+1))
		{
			if(Mano[0].Valor==(Mano[1].Valor+1))
			{
				Mejor[0]=Mano[0];
				Mejor[1]=Mano[1];
				Mejor[2]=Mano[2];
				Mejor[3]=Mano[3];
				Mejor[4]=Mano[4];
				return Mejor;
			}
			else
			{
				if(Mano[5].Valor==(Mano[4].Valor-1))
				{
					Mejor[0]=Mano[1];
					Mejor[1]=Mano[2];
					Mejor[2]=Mano[3];
					Mejor[3]=Mano[4];
					Mejor[4]=Mano[5];
					return Mejor;
				}
				else return Void;					
			}
		}
		else
		{
			if(Mano[5].Valor==(Mano[4].Valor-1))
			{
				if(Mano[6].Valor==(Mano[5].Valor-1))
				{
					Mejor[0]=Mano[2];
					Mejor[1]=Mano[3];
					Mejor[2]=Mano[4];
					Mejor[3]=Mano[5];
					Mejor[4]=Mano[6];
					return Mejor;
				}
				else 
				{	
					if(Mano[1].Valor==(Mano[2].Valor+1))
					{
						Mejor[0]=Mano[1];
						Mejor[1]=Mano[2];
						Mejor[2]=Mano[3];
						Mejor[3]=Mano[4];
						Mejor[4]=Mano[5];
						return Mejor;
					}
					else return Void;					
				}
			}
			else return Void;
		}
	}
	else return Void;
	}
}

public static boolean probarTrio(Carta[][] Mesa, int Jug)
{
	int i=0,j,cont=0,a=0;
		Carta[] Mano= new Carta[7];
		Mano=ObtenerMano(Mesa,Jug);
		do
		{
			cont=0;
			for(j=0;j<7;j++)
			{
				if(Mano[j].Valor==Mano[i].Valor) cont++;
			}
			if(cont==3)	a=1;
			i++;
		}while(i<7&&a!=1);
		
		if(a==1) return true;
		else return false;
}

public static Carta[] getTrio(Carta[][] Mesa, int Jug)
{
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;
	
	if(probarTrio(Mesa,Jug)==false) return Void;
	else
	{
	int i=0,j,cont=0,a=0;
		Carta[] Mano= new Carta[7];

		Carta[] Mejor = new Carta[5];
		Mano=ObtenerMano(Mesa,Jug);
		int ValTri=0;
		do
		{
			cont=0;
			for(j=0;j<7;j++)
			{
				if(Mano[j].Valor==Mano[i].Valor) cont++;
			}
			if(cont==3)
			{
				a=1;
				ValTri=Mano[i].Valor;
			}
			i++;
		}while(i<7&&a!=1);
		j=0;
		for(i=0;i<7;i++)
		{
			if(Mano[i].Valor==ValTri) 
			{
				Mejor[j]=Mano[i];
				j++;
			}
		}
		i=0;
		do
		{
			if(Mano[i].Valor!=ValTri)
			{
				Mejor[j]=Mano[i];
				j++;
			}
			i++;
		}while(j<5);
		return Mejor;
	}
}

public static boolean probarDoblePar(Carta[][] Mesa, int Jug)
{
	int i=0,j=0,cont=0,par=0,a=0;
	do//(i=0;i<7;i++)
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mesa[i][Jug].Valor==Mesa[j][Jug].Valor) cont++;
		}
		if(cont==2) 
		{
			a=1;
			par=Mesa[i][Jug].Valor;
		}
		i++;
	}while(i<7&&a==0);
	if(a==1)
	{
		i=0;
		a=0;
		do
		{
			cont=0;
			for(j=0;j<7;j++)
			{
				if(Mesa[i][Jug].Valor==Mesa[j][Jug].Valor&&Mesa[i][Jug].Valor!=par) cont++;
			}
			if(cont==2) 
			{
				a=1;
			}
			i++;
		}while(i<7&&a==0);
	}
	if(a==1) return true;
	else return false;

}

public static Carta[] getDoblePar(Carta[][] Mesa, int Jug)
{
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;

	if(probarDoblePar(Mesa,Jug)==false) return Void;
	else
	{
	Carta[] Mano = new Carta[7];
	int i,j,cont=0,Par1=0,Par2=0;
	Carta[] Mejor = new Carta[5];
	Mano=ObtenerMano(Mesa,Jug);
	for(i=0;i<7;i++)
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mesa[i][Jug].Valor==Mano[j].Valor) cont++;
		}
		if(cont==2)
		{
			if(Par1==0) Par1=Mano[i].Valor;
			else Par2=Mano[i].Valor;
		}
	}
	j=0;
	for(i=0;i<7;i++)
	{
		if(Mano[i].Valor==Par1) 
		{
			Mejor[j]=Mano[i];
			j++;
		}
	}
	for(i=0;i<7;i++)
	{
		if(Mano[i].Valor==Par2) 
		{
			Mejor[j]=Mano[i];
			j++;
		}
	}
	i=0;
	do
	{
		if(Mano[i].Valor!=Par1&&Mano[i].Valor!=Par2) 
		{
			Mejor[j]=Mano[i];
			j++;
		}
		i++;
	}while(j<5);
	return Mejor;
	}
}

public static boolean probarPar(Carta[][] Mesa, int Jug)
{
	int i,j,cont,a=0;
	for(i=0;i<7;i++)
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mesa[i][Jug].Valor==Mesa[j][Jug].Valor) cont++;
		}
		if(cont>=2) a=1;
	}
	if(a==1) return true;
	else return false;
}

public static Carta[] getPar(Carta[][] Mesa, int Jug)
{
	Carta CVoid = new Carta();
	CVoid.Valor=-1;
	CVoid.Simbolo="-1";
	CVoid.Suit="-1";
	Carta[] Void = new Carta[5];
	Void[0]=CVoid; Void[1]=CVoid; Void[2]=CVoid; Void[3]=CVoid; Void[4]=CVoid;

	if(probarPar(Mesa,Jug)==false) return Void;
	else
	{
	Carta[] Mano=new Carta[7];
	Carta[] Mejor = new Carta[5];
	Mano=ObtenerMano(Mesa,Jug);
	int i=0,j=0,cont,par=0;
	do
	{
		cont=0;
		for(j=0;j<7;j++)
		{
			if(Mano[i].Valor==Mano[j].Valor) cont++;
		}
		if(cont>=2)
		{
			par=Mano[i].Valor;
		}
		i++;
	}while(i<7&&par==0);
	j=0;
	i=0;
	for(i=0;i<7;i++)
	{
		if(Mano[i].Valor==par)
		{
			Mejor[j]=Mano[i];
			j++;
		}
	}
	i=0;
	do
	{
		if(Mano[i].Valor!=par)
		{
			Mejor[j]=Mano[i];
			j++;
		}
		i++;
	}while(i<7&&j<5);
	return Mejor;
	}
}

public static int JMayorCarta(Carta[][] Mesa)
{
	int[] Mayores=new int[Mesa[0].length];
	Carta[] Mano=new Carta[Mesa.length];
	int i,j,cont=0,a=0,may=0,Max,gana=-1,Ant;
	
	for(i=0;i<Mesa[0].length;i++)
	{
		Mano=ObtenerMano(Mesa,i);
		for(j=0;j<Mesa.length;j++)
		{
			Mesa[j][i]=Mano[j];
		}
	}
	
	for(i=0;i<Mesa[0].length;i++)
	{
		Mayores[i]=Mesa[may][i].Valor;
	}
	Max=0;
	for(i=0;i<Mayores.length;i++)
	{
		if(Mayores[i]>Max) 
		{
			Max=Mayores[i];
			cont=0;
		}
		if(Mayores[i]==Max)	cont++;
	}
	Ant=Max;
	if(cont==1) a=1;
	else
	{
		do
		{
			a=0;
			may++;
			Ant=Max;
			for(i=0;i<Mesa[0].length;i++)
			{
				Mayores[i]=Mesa[may][i].Valor;
			}
			Max=0;
			for(i=0;i<Mayores.length;i++)
			{
				if(Mesa[may-1][i].Valor==Ant)
				{
			
					if(Mayores[i]>Max) 
					{
						Max=Mayores[i];
						cont=0;
					}
					if(Mayores[i]==Max)	cont++;
				}
			}	
			if(cont==1) a=1;
		}while(a==0&&may<Mesa.length);
	}
		if(a==1)
		{
			for(i=0;i<Mayores.length;i++)
			{
					if(Mayores[i]==Max)	gana=i;
			}
			return gana;
		}
		else return -1;
			
}

public static Carta[] Ordenar(Carta[] Vect)
{
	int N=Vect.length;
	Carta aux;
	for(int i=0; i<N-1 ; i++ )
	{
        for(int j=i+1 ; j < N; j++)
        {
            if(Vect[j].Valor>Vect[i].Valor)
            {
                aux = Vect[j];
                Vect[j]= Vect[i];
                Vect[i] = aux;
            }
        }
	}
	return Vect;
}

public static Carta[] ObtenerMano(Carta[][] Mesa, int Jug)
{
	int N=Mesa.length;
	Carta[] Vect= new Carta[N];
	for(int i=0;i<7;i++)
	{
		Vect[i]=Mesa[i][Jug];
	}
	
	Carta aux;
	for(int i=0; i<N-1 ; i++ )
	{
        for(int j=i+1 ; j < N; j++)
        {
            if(Vect[j].Valor>Vect[i].Valor)
            {
                aux = Vect[j];
                Vect[j]= Vect[i];
                Vect[i] = aux;
            }
        }
	}
	return Vect;
}

public static int Puntaje(Carta[][] Mesa, int Jug)
{
	boolean Bool;
	Bool = probarEscReal(Mesa,Jug);
	if(Bool==true) return 10;
	else
	{
		Bool=probarEscCol(Mesa,Jug);
		if(Bool==true) return 9;
		else
		{
			Bool=probarPoquer(Mesa,Jug);
			if(Bool==true) return 8;
			else
			{
				Bool=probarFull(Mesa,Jug);
				if(Bool==true) return 7;
				else
				{
					Bool=probarColor(Mesa,Jug);
					if(Bool==true) return 6;
					else
					{
						Bool=probarEscalera(Mesa,Jug);
						if(Bool==true) return 5;
						else
						{
							Bool=probarTrio(Mesa,Jug);
							if(Bool==true) return 4;
							else
							{
								Bool=probarDoblePar(Mesa,Jug);
								if(Bool==true) return 3;
								else
								{
									Bool=probarPar(Mesa,Jug);
									if(Bool==true) return 2;
									else return 1;
								}
							}
						}
					}
				}
			}
		}
	}
}

public static Carta[] MejorMano(Carta[][] Mesa, int Jug)
{
	int Punt;
	Carta[] Mejor = new Carta[5];
	Punt=Puntaje(Mesa,Jug); 
	switch(Punt)
	{
		case 10:
			Mejor=getEscReal(Mesa,Jug);
			break;
		case 9:
			Mejor=getEscCol(Mesa,Jug);
			break;
		case 8:
			Mejor=getPoquer(Mesa,Jug);
			break;
		case 7:
			Mejor=getFull(Mesa,Jug);
			break;
		case 6:
			Mejor=getColor(Mesa,Jug);
			break;
		case 5:
			Mejor=getEscalera(Mesa,Jug);
			break;
		case 4:
			Mejor=getTrio(Mesa,Jug);
			break;
		case 3:
			Mejor=getDoblePar(Mesa,Jug);
			break;
		case 2:
			Mejor=getPar(Mesa,Jug);
			break;
		case 1:
			Mejor=ObtenerMano(Mesa,Jug);
			break;
	}
	return Mejor;
}

     public static void main(String [] args)
     {
    	    Main menu=new Main();
    	    menu.setBounds(0,0,610,410);
    	    menu.setVisible(true);
    	    menu.setLocationRelativeTo(null);
    	    menu.setResizable(false);
    	    menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
    		menu.setSize(610,410);
    		Jugador jugadores[] = new Jugador[Cantidad];
    		jugadores[0] = new Jugador(1,50,false,true,false);
    		jugadores[1] = new Jugador(2,50,true,false,false);
    		jugadores[2] = new Jugador(3,50,false,false,false);
    	    jugadores[3] = new Jugador(4,50,false,false,false);
    	    Datos d = new Datos(jugadores);
     }




}