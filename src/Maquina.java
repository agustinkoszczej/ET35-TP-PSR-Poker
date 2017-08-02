import java.util.Random;

public class Maquina {
	 public static Random numerosAleatorios = new Random();
	 	public static int Puntos = 0;
		public static int Dinero; /*Variable donde va el dinero que tiene la maquina*/
		public static int Pozo = 0; /*Variable donde va el dinero total apostado*/
		public static String AccionMaquina; /*Variable para guardar que va a hacer la maquina*/
		public static float Apuesta = 0; /*Variable Auxiliar que permite calcular cuanto apostar*/
		public static int DineroApuesta = 0; /*Variable donde va la cantidad de dinero que va a apostar el jugador*/
		public static float PosibilidadGanar = 0; /*Variable para guardar % de ganar*/
		public static String [] MovsJugadores = new String [4]; /*Variable donde se guardan los movimientos de todos los jugadores*/ 
		public static int CantJugadores; /*Cantidad de jugadores jugando ACTUALMENTE la mano (obviamente sin contar a uno que seria la maquina en si que va a tomar la decision)*/
		public static int i = 0; 
		public static int ContRetirarse = 0, ContIr = 0, ContSubir = 0; /*Contadores para los Movimientos de los Jugadores*/
		public static Carta[][] Mesa;/*Variable de Manchi*/
		public static int Jug; /*Variable de Manchi*/
		public static String [] MesaPalos ;
		public static int [] MesaCartas;
/*public static String Maq (int n, int Dinero, int Pozo, int [] cartas, String [] palos, String [] MesaPalos, int [] MesaCartas, Carta[][] Mesa, int Jug, String [] MovsJugadores, int CantJugadores) {*/

public static String Maq (int n,int Dinero, int Pozo, int [] cartas, String [] palos, String [] MesaPalos, int [] MesaCartas, Carta[][] Mesa,int turno,String [] MovsJugadores,int CantJugadores)
{
		
		//int n = 3; /*Variable donde va la cantidad de cartas boca arriba en el momento*/
	//int [] cartas; /*Variable donde van las 2 cartas de la maquina*/
	//String [] palos;/*Variable donde van los 2 palos de la maquina*/
	//int [] MesaCartas; /*Variable donde van las cartas boca arriba en la mesa*/
	//String [] MesaPalos; /*Variable donde van los palos boca arriba en la mesa*/
	int [] CartasTot; /*Variable donde van las cartas de la maquina y la mesa ordenados de menor a mayor*/
	String [] PalosTot; /*Variable donde van los palos de la maquina y la mesa ordenados de menor a mayor*/
		
	/*Declaro tamaño de los arrays*/
	cartas = new int[2]; 
	palos = new String[2];
	MesaCartas = new int [n];
	MesaPalos = new String [n];
	CartasTot = new int [n+2];
	PalosTot = new String [n+2];
	/*Hasta aca*/
	
	/*Aca paso los datos de las cartas de cada maquina del array cartas y palos de carta a los arrays de esta clase*/
	int k=0;
	if(turno == 2)
	{
	for(i=2;i<4;i++)
	{
		cartas[k] = Carta.cartas[i];
		palos[k] = Carta.palos[i];
		k++;
	}
	}
	if(turno == 3)
	{
		for(i=4;i<6;i++)
		{
		cartas[k] = Carta.cartas[i];
		palos[k] = Carta.palos[i];
		k++;
		}
	}
	if(turno == 4)
	{
		for(i=6;i<8;i++)
		{
		cartas[k] = Carta.cartas[i];
		palos[k] = Carta.palos[i];
		k++;
		}
	}
	if(n==3)
	{
	k=0;
	for(i=8;i<11;i++)
	{
		MesaCartas[k] = Carta.cartas[i];
		MesaPalos[k] = Carta.palos[i];
		k++;
		}
	}
	if(n==4)
	{
		k=0;
		for(i=8;i<12;i++)
		{
			MesaCartas[k] = Carta.cartas[i];
			MesaPalos[k] = Carta.palos[i];
			k++;
			}
	}
	if(n==5)
	{
		k=0;
		for(i=8;i<13;i++)
		{
			MesaCartas[k] = Carta.cartas[i];
			MesaPalos[k] = Carta.palos[i];
			k++;
			}
	}
	
	
	/*Guardo en los arrays las cartas y palos de la maquina y la mesa*/
	for (i = 0; i<CartasTot.length;i++){
	if (i<2){
	CartasTot [i] = cartas[i];
	PalosTot [i] = palos[i];
	}
	else{
	CartasTot[i] = MesaCartas [i-2];
	PalosTot[i] = MesaPalos [i-2];
	}
	}
	/*Hasta aca*/
	
	/*Ordeno ese array de menor a mayor, cambiando de lugar tambien las posiciones de los palos*/
			int j, aux_a;
	String aux_b;
    for(i=0;i<CartasTot.length-1;i++){
         for(j=0;j<CartasTot.length-i-1;j++){
              if(CartasTot[j+1]<CartasTot[j]){
                 aux_a=CartasTot[j+1];
                 aux_b=PalosTot[j+1];
                 CartasTot[j+1]=CartasTot[j];
                 PalosTot[j+1]=PalosTot[j];
                 CartasTot[j]=aux_a;
                 PalosTot[j]=aux_b;
              }
         }
	}
    /*Hasta aca*/
    
    
    
    
    
    
    
    
    /*Primera Mano*/
    if (n == 0){
    	/*Escalera Real de Color*/
    	if ( ((cartas[0] >= 10) || (cartas[0] == 1)) && ((cartas[1] >= 10) || (cartas[1] == 1)) && (palos[0] == palos[1])){
    		Puntos = 10;
    }
    	/*Escalera de Color*/
    	else if ( ((cartas[0]+1 == cartas[1]) || (cartas[0] == cartas[1]+1)) && ((palos[0] == palos[1]))){
    		Puntos = 8;
    }
    	/*Poquer, Full, Trio, Doble Pareja o Pareja*/
    	else if (cartas[0] == cartas[1]){
    		Puntos = 6;
    }
    	/*Color*/
    	else if (palos[0] == palos[1]){
    		Puntos = 2;
    }
    	/*Escalera*/
    	else if (cartas[0]+1 == cartas[1]){
    		Puntos = 4;
    }
    	else {
			Puntos = 1;
	}
 } /*Hasta aca Primera Mano*/
    
    
    
    
    
    
   /*Segunda Mano*/ 
    else if (n == 3){ 
    /*Escalera Real de Color*/
	 if ((CartasTot[0] == 1) && (CartasTot[1] == 10) && (CartasTot[2] == 11) && (CartasTot[3] == 12) && (CartasTot[4] == 13) && (PalosTot[0] == PalosTot[1]) && (PalosTot[1] == PalosTot[2]) && (PalosTot[2] == PalosTot[3]) && (PalosTot[3] == PalosTot[4])){
		 Puntos = 10;
 }
	 /*Escalera de Color*/
	 else if ((CartasTot[0]+1 == CartasTot[1]) && (CartasTot[1]+1 == CartasTot[2]) && (CartasTot[2]+1 == CartasTot[3]) && (CartasTot[3]+1 == CartasTot[4]) && (PalosTot[0] == PalosTot[1]) && (PalosTot[1] == PalosTot[2]) && (PalosTot[2] == PalosTot[3]) && (PalosTot[3] == PalosTot[4])){
		 Puntos = 9;
 }
	 /*Poquer*/
	 else if ( ((CartasTot[0] == CartasTot[1]) && (CartasTot[1] == CartasTot[2]) && (CartasTot[2] == CartasTot[3])) || ((CartasTot[1] == CartasTot[2]) && (CartasTot[2] == CartasTot[3]) && (CartasTot[3] == CartasTot[4])) ){
		 Puntos = 8;
 }
	 /*Full*/
	 else if ( ((CartasTot[0] == CartasTot[1]) && (CartasTot[1] == CartasTot[2]) && (CartasTot[3] == CartasTot[4])) || ((CartasTot[0] == CartasTot[1]) && (CartasTot[2] == CartasTot[3]) && (CartasTot[3] == CartasTot[4])) ){
		 Puntos = 7;
 }
	 /*Color*/
	 else if ((PalosTot[0] == PalosTot[1]) && (PalosTot[1] == PalosTot[2]) && (PalosTot[2] == PalosTot[3]) && (PalosTot[3] == PalosTot[4])){
		 Puntos = 6;
 } 
	 /*Escalera*/
	 else if (((CartasTot[0]+1 == CartasTot[1]) && (CartasTot[1]+1 == CartasTot[2]) && (CartasTot[2]+1 == CartasTot[3]) && (CartasTot[3]+1 == CartasTot[4])) || ((CartasTot[0]+1 == CartasTot[1]) && (CartasTot[1]+1 == CartasTot[2]) && (CartasTot[2]+1 == CartasTot[3]) && (CartasTot[4] == 1))){
		 Puntos = 5;
 } 
	 /*Trio*/
	 else if (((CartasTot[0] == CartasTot[1]) && (CartasTot[1] == CartasTot[2])) || ((CartasTot[1] == CartasTot[2]) && (CartasTot[2] == CartasTot[3])) || ((CartasTot[2] == CartasTot[3]) && (CartasTot[3] == CartasTot[4]))){
		 Puntos = 4;
 } 
	 /*Doble Pareja*/
	 else if (((CartasTot[0] == CartasTot[1]) && (CartasTot[2] == CartasTot[3])) || ((CartasTot[1] == CartasTot[2]) && (CartasTot[3] == CartasTot[4]))){
		 Puntos = 3;
 } 
	 /*Pareja*/
	 else if ((CartasTot[0] == CartasTot[1]) || (CartasTot[1] == CartasTot[2]) || (CartasTot[2] == CartasTot[3]) || (CartasTot[3] == CartasTot[4])){
		 Puntos = 2;
 } 
	 /*Carta mas Alta*/
	 else{
		 Puntos = 1;
	 }
	 
 } /*Hasta aca Segunda Mano*/
    
    
    /*Tercera Mano*/ 
    if (n == 4){
    Puntos = Puntaje(Mesa, 1);			
    } /*Hasta aca Tercera Mano*/
    
    
    
    /*Cuarta Mano*/
    /*REEMPLAZAR CLASEMANCHI POR LA CLASE DONDE ESTAN LAS FUNCIONES QUE HIZO MANCHI*/
    if (n == 5){
    	boolean BoolCuartaMano;
    	BoolCuartaMano = Main.probarEscReal(Mesa,Jug);
    	if(BoolCuartaMano==true) Puntos = 10;
    	else
    	{
    		BoolCuartaMano=Main.probarEscCol(Mesa,Jug);
    		if(BoolCuartaMano==true) Puntos = 9;
    		else
    		{
    			BoolCuartaMano=Main.probarPoquer(Mesa,Jug);
    			if(BoolCuartaMano==true) Puntos = 8;
    			else
    			{
    				BoolCuartaMano=Main.probarFull(Mesa,Jug);
    				if(BoolCuartaMano==true) Puntos = 7;
    				else
    				{
    					BoolCuartaMano=Main.probarColor(Mesa,Jug);
    					if(BoolCuartaMano==true) Puntos = 6;
    					else
    					{
    						BoolCuartaMano=Main.probarEscalera(Mesa,Jug);
    						if(BoolCuartaMano==true) Puntos = 5;
    						else
    						{
    							BoolCuartaMano=Main.probarTrio(Mesa,Jug);
    							if(BoolCuartaMano==true) Puntos = 4;
    							else
    							{
    								BoolCuartaMano=Main.probarDoblePar(Mesa,Jug);
    								if(BoolCuartaMano==true) Puntos = 3;
    								else
    								{
    									BoolCuartaMano=Main.probarPar(Mesa,Jug);
    									if(BoolCuartaMano==true) Puntos = 2;
    									else Puntos = 1;
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    }
    /*Hasta aca Cuarta Mano*/
	AccionMaquina();
	return (AccionMaquina);
}
	
	
	
	
	
	
	
	
	
	public static void AccionMaquina ()
	{
		
	if (Dinero > 5)
	{
		PosibilidadGanar = PosibilidadGanar + (10/3);
		if (Dinero > 10)
    	{
			PosibilidadGanar = PosibilidadGanar + (10/3);
			if (Dinero > 15)
        	{
				PosibilidadGanar = PosibilidadGanar + (10/3);
				if (Dinero > 20)
	        	{
					PosibilidadGanar = PosibilidadGanar + (10/3);
					if (Dinero > 25)
					{
						PosibilidadGanar = PosibilidadGanar + (10/3);
					}
	        	}
        	}
    	}
	}
	
	if (Puntos > 0)
	{
		PosibilidadGanar = PosibilidadGanar + (10/3);
		if (Puntos > 1)
    	{
			PosibilidadGanar = PosibilidadGanar + (10/3);
			if (Puntos > 2)
			{
				PosibilidadGanar = PosibilidadGanar + (10/3);
				if (Puntos > 3)
    			{
    				PosibilidadGanar = PosibilidadGanar + (10/3);
    				if (Puntos > 4)
        			{
        				PosibilidadGanar = PosibilidadGanar + (10/3);
        				if (Puntos > 5)
            			{
            				PosibilidadGanar = PosibilidadGanar + (10/3);
            				if (Puntos > 6)
                			{
                				PosibilidadGanar = PosibilidadGanar + (10/3);
                				if (Puntos > 7)
                    			{
                    				PosibilidadGanar = PosibilidadGanar + (10/3);
                    				if (Puntos > 8)
                        			{
                        				PosibilidadGanar = PosibilidadGanar + (10/3);
                        				if (Puntos > 9)
                            			{
                            				PosibilidadGanar = PosibilidadGanar + (10/3);
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
	
	if (Pozo > 10)
	{
		PosibilidadGanar = PosibilidadGanar + (10/3);
		if (Pozo > 20)
    	{
			PosibilidadGanar = PosibilidadGanar + (10/3);
			if (Pozo > 30)
			{
				PosibilidadGanar = PosibilidadGanar + (10/3);
				if (Pozo > 40)
    			{
    				PosibilidadGanar = PosibilidadGanar + (10/3);
    				if (Pozo > 50)
        			{
        				PosibilidadGanar = PosibilidadGanar + (10/3);
        			}
	        	}
        	}
    	}
	}
	for (i = 0; i<MovsJugadores.length; i++){
	if (MovsJugadores [i] == "Retirarse") ContRetirarse ++;
	else if (MovsJugadores [i] == "Ir") ContIr ++;
	else if (MovsJugadores [i] == "Subir") ContSubir++;
	}
	if ((CantJugadores == 1) && (ContIr == 1)) PosibilidadGanar = PosibilidadGanar + (100/3);
	else if ((CantJugadores == 1) && (ContSubir == 1)) PosibilidadGanar = PosibilidadGanar + (40/3);
	
	else if (CantJugadores == 2){
		if ((ContRetirarse == 1) && (ContIr == 1)) PosibilidadGanar = PosibilidadGanar + (100/3);
		else if ((ContRetirarse == 0) && (ContIr == 2)) PosibilidadGanar = PosibilidadGanar + (80/3);
		else if ((ContRetirarse == 1) && (ContSubir == 1)) PosibilidadGanar = PosibilidadGanar + (60/3);
		else if ((ContSubir == 1) && (ContIr == 1)) PosibilidadGanar = PosibilidadGanar + (40/3);
		else if (ContSubir == 2) PosibilidadGanar = PosibilidadGanar + (20/3);
	}
	
	else if (CantJugadores == 3){
	if ((ContRetirarse == 2) && (ContIr == 1)) PosibilidadGanar = PosibilidadGanar + (100/3);
	else if ((ContRetirarse == 1) && (ContIr== 2)) PosibilidadGanar = PosibilidadGanar + (80/3);
	else if (ContIr == 3) PosibilidadGanar = PosibilidadGanar + (60/3);
	else if ((ContRetirarse == 2) && (ContSubir == 1)) PosibilidadGanar = PosibilidadGanar + (40/3);
	else if ((ContSubir > ContIr) && (ContSubir > ContRetirarse)) PosibilidadGanar = PosibilidadGanar + (20/3);
	}
		
	
	if (PosibilidadGanar <= (50/3))
	{
		if (numerosAleatorios.nextInt(11) == 1){
    		AccionMaquina = "Subir";
			DineroApuesta = Dinero;
		}
		else AccionMaquina = "Retirarse";
	}
	else if ((PosibilidadGanar > (50/3)) && (PosibilidadGanar <= (200/3)))	AccionMaquina = "Ir";
	
	
	else 
	{
	AccionMaquina = "Subir";	
	Apuesta = 100 - PosibilidadGanar;
	if ((Apuesta >= (80/3)) && (Apuesta <(100/3)))
	{
		DineroApuesta = numerosAleatorios.nextInt(4)+1;
	}
	else if ((Apuesta >= (60/3)) && (Apuesta <(80/3)))
	{
		DineroApuesta = numerosAleatorios.nextInt(4)+5;
	}
	else if ((Apuesta >= (40/3)) && (Apuesta <(60/3)))
	{
		if (numerosAleatorios.nextInt(4) == 1){
    		DineroApuesta = Dinero;
		}
		else{
		DineroApuesta = numerosAleatorios.nextInt(4)+9;
		}
	}
	else if  ((Apuesta >= (20/3)) && (Apuesta <(40/3)))
	{
		if (numerosAleatorios.nextInt(3) == 1){
    		DineroApuesta = Dinero;
		}
		else{
		DineroApuesta = numerosAleatorios.nextInt(4)+13;
		}
	}
	else if (Apuesta < (20/3))
	{
		if (numerosAleatorios.nextInt(2) == 1){
    		DineroApuesta = Dinero;
		}
		else{
		DineroApuesta = numerosAleatorios.nextInt(4)+17;
		}
	}
	if (DineroApuesta > Dinero) DineroApuesta = Dinero / 2;
}
}
	/*Hasta aca accion maquina*/
	
	
	
	
	
	
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
	
	public static Carta[] ObtenerMano(Carta[][] Mesa, int Jug){
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

	
	/*+-----------------------------+*/
	/*| Escalera Real de Color con 6|*/
	/*+-----------------------------+*/
	public static boolean probarEscRealcon6(Carta[][] Mesa, int Jug){

	Carta[] Mano = new Carta[6];
	Mano=ObtenerMano(Mesa,Jug);
	Carta aux;
	int i=0,j,cont=0,a=0;
	String SuitEsc="";
	do//(i=0;i<6;i++)
	{
		for(j=0;j<6;j++)
		{
			if(Mano[j].Suit.equals(Mano[i].Suit)) cont++;
		}
		if(cont>=5)
		{
			a=1;
			SuitEsc=Mano[i].Suit;
		}
		i++;
	}while(i<6&&a!=1);
	if(a==0)
	{
		return false;
	}
	else
	{
		for(i=0;i<6;i++)
		{
			if(Mano[i].Suit.equals(SuitEsc)==false)
			{
				aux=Mano[i];
				for(j=i;j<5;j++)
				{
					Mano[j]=Mano[j+1];
				}
				Mano[5]=aux;
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

	
	/*+-------------------------+*/
	/*| Escalera de Color con 6 |*/
	/*+-------------------------+*/	
public static boolean probarEscColcon6(Carta[][] Mesa, int Jug){

int i=0,a=0,j,cont=0;
String SuitEsc="";
Carta aux;
do//(i=0;i<6;i++)
{
	for(j=0;j<6;j++)
	{
		if(Mesa[j][Jug].Suit.equals(Mesa[i][Jug].Suit)) cont++;
	}
	if(cont>=5)
	{
		a=1;
		SuitEsc=Mesa[i][Jug].Suit;
	}
	i++;
}while(i<6&&a!=1);
if(a==0)
{
	return false;
}
else
{
	Carta[] Mano = new Carta[6];
	Mano=ObtenerMano(Mesa,Jug);
	
	for(i=0;i<6;i++)
	{
		if(Mano[i].Valor==5)
		{
			for(j=0;j<6;j++)
			{
				if(Mano[j].Valor==4)
				{
					for(int k=0;k<6;k++)
					{
						if(Mano[k].Valor==3)
						{
							for(int m=0;m<6;m++)
							{						
								if(Mano[m].Valor==2)
								{
									for(int l=0;l<6;l++)
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

	for(i=0;i<6;i++)
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
	
		if(Mano[1].Valor==(Mano[2].Valor+1)&&Mano[3].Valor==(Mano[4].Valor-1))
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
	else return false;
}
}

/*+--------------+*/
/*| Poquer con 6 |*/
/*+--------------+*/
public static boolean probarPoquercon6(Carta[][] Mesa, int Jug){
/*Poquer*/
Carta[] Mano= new Carta[6];
Mano=ObtenerMano(Mesa,Jug);
int i=0,j,cont=0,a=0;
do
{
	cont=0;
	for(j=0;j<6;j++)
	{
		if(Mano[j].Valor==Mano[i].Valor) cont++;
	}
	if(cont==4)	a=1;
	i++;
}while(i<6&&a!=1);

if(a==1) return true;
else return false;
}



/*+------------+*/
/*| Full con 6 |*/
/*+------------+*/
public static boolean probarFullcon6(Carta[][] Mesa, int Jug){
/*Full*/
Carta[] Mano= new Carta[6];
Mano=ObtenerMano(Mesa,Jug);

int Primer=0,i=0,j,cont=0,a=0;
do
{
	cont=0;
	for(j=0;j<6;j++)
	{
		if(Mano[j].Valor==Mano[i].Valor) cont++;
	}
	if(cont==3)
	{
		a=1;
		Primer=Mano[i].Valor;
	}
	i++;
}while(i<6&&a!=1);
i=0;
if(a==1)
{
	a=0;
	do
	{
		for(j=0;j<6;j++)
		{
			if(Mano[i].Valor==Mano[j].Valor&&Mano[i].Valor!=Primer) cont++;
		}
		if(cont==2) a=1;
		i++;
	}while(i<6&&a!=1);
	if(a==1) return true;
	else return false;
}
else return false;
}


/*+-------------+*/
/*| Color con 6 |*/
/*+-------------+*/
public static boolean probarColorcon6(Carta[][] Mesa, int Jug){
/*Color*/
int a=0,i=0,j,cont=0;
do
{	
	cont=0;
	for(j=0;j<6;j++)
	{
		if(Mesa[j][Jug].Suit.equals(Mesa[i][Jug].Suit)) cont++;
	}
	if(cont>=5) a=1;
	
	i++;
}while(i<6&&a!=1);
if(a==0)return false;
else return true;
}


/*+----------------+*/
/*| Escalera con 6 |*/ //Probar si funciona
/*+----------------+*/
public static boolean probarEscaleracon6(Carta[][] Mesa, int Jug){

Carta[] Mano = new Carta[6];
Mano=ObtenerMano(Mesa,Jug);

for(int i=0;i<6;i++)
{
	if(Mano[i].Valor==5)
	{
		for(int j=0;j<6;j++)
		{
			if(Mano[j].Valor==4)
			{
				for(int k=0;k<6;k++)
				{
					if(Mano[k].Valor==3)
					{
						for(int m=0;m<6;m++)
						{
					
							if(Mano[m].Valor==2)
							{
								for(int l=0;l<6;l++)
								{
									if(Mano[l].Valor==14)
									{
										Mano[l].Valor=1;
										Mano=Ordenar(Mano);	 
									}
								}}}}}}}}}


Carta aux;
for(int i=1;i<6;i++)
{
	if(Mano[i].Valor==Mano[i-1].Valor)
	{
		aux=Mano[i];
		for(int j=i;j<6;j++)
		{
			Mano[j]=Mano[j+1];
		}
		Mano[5]=aux;

	}
}
if(Mano[1].Valor==(Mano[2].Valor+1)&&Mano[3].Valor==(Mano[4].Valor+1))
{
	if(Mano[0].Valor==(Mano[1].Valor+1))
	{
			return true;
	}
		else
		{
			if(Mano[4].Valor==(Mano[5].Valor+1))
			{
				return true;
			}
			else return false;					
		}
}
	else return false;					
}	


/*+------------+*/
/*| Trio con 6 |*/
/*+------------+*/
public static boolean probarTriocon6(Carta[][] Mesa, int Jug){
int i=0,j,cont=0,a=0;
Carta[] Mano= new Carta[6];
Mano=ObtenerMano(Mesa,Jug);
do
{
	cont=0;
	for(j=0;j<6;j++)
	{
		if(Mano[j].Valor==Mano[i].Valor) cont++;
	}
	if(cont==3)	a=1;
	i++;
}while(i<6&&a!=1);

if(a==1) return true;
else return false;
}

/*+--------------------+*/
/*| Doble Pareja con 6 |*/
/*+--------------------+*/
public static boolean probarDobleParcon6(Carta[][] Mesa, int Jug){
/*Doble Pareja*/
int i=0,j=0,cont=0,par=0,a=0;
do
{
	cont=0;
	for(j=0;j<6;j++)
	{
		if(Mesa[i][Jug].Valor==Mesa[j][Jug].Valor) cont++;
	}
	if(cont==2) 
	{
		a=1;
		par=Mesa[i][Jug].Valor;
	}
	i++;
}while(i<6&&a==0);
if(a==1)
{
	i=0;
	a=0;
	do
	{
		cont=0;
		for(j=0;j<6;j++)
		{
			if(Mesa[i][Jug].Valor==Mesa[j][Jug].Valor&&Mesa[i][Jug].Valor!=par) cont++;
		}
		if(cont==2) 
		{
			a=1;
		}
		i++;
	}while(i<6&&a==0);
}
if(a==1) return true;
else return false;
}


/*+--------------+*/
/*| Pareja con 6 |*/
/*+--------------+*/
public static boolean probarParcon6(Carta[][] Mesa, int Jug){
/*Pareja*/
int i,j,cont,a=0;
for(i=0;i<6;i++)
{
	cont=0;
	for(j=0;j<6;j++)
	{
		if(Mesa[i][Jug].Valor==Mesa[j][Jug].Valor) cont++;
	}
	if(cont>=2) a=1;
}
if(a==1) return true;
else return false;
}

/*+---------------+*/
/*| Puntaje con 6 |*/
/*+---------------+*/
public static int Puntaje(Carta[][] Mesa, int Jug){
	boolean Bool;
	Bool = probarEscRealcon6(Mesa,Jug);
	if(Bool==true) return 10;
	else
	{
		Bool=probarEscColcon6(Mesa,Jug);
		if(Bool==true) return 9;
		else
		{
			Bool=probarPoquercon6(Mesa,Jug);
			if(Bool==true) return 8;
			else
			{
				Bool=probarFullcon6(Mesa,Jug);
				if(Bool==true) return 7;
				else
				{
					Bool=probarColorcon6(Mesa,Jug);
					if(Bool==true) return 6;
					else
					{
						Bool=probarEscaleracon6(Mesa,Jug);
						if(Bool==true) return 5;
						else
						{
							Bool=probarTriocon6(Mesa,Jug);
							if(Bool==true) return 4;
							else
							{
								Bool=probarDobleParcon6(Mesa,Jug);
								if(Bool==true) return 3;
								else
								{
									Bool=probarParcon6(Mesa,Jug);
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
	
}

