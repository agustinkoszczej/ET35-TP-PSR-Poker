
public class Datos {

public static Jugador [] J;
public Datos(Jugador [] jugadores)
{
	J = new Jugador[4];
	for(int i=0;i<jugadores.length;i++)
	{
		J[i] = jugadores[i]; 
	}
}
}
