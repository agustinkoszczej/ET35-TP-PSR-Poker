import java.util.Random;

public class PaqueteDeCartas {
Carta[] Mazo= new Carta[52];

public PaqueteDeCartas()
{
	this.OrdenarPaq();
	}

public void OrdenarPaq()
{
	Mazo[0]=new Carta();
	Mazo[0].Valor=2;
	Mazo[0].Simbolo="2";
	Mazo[0].Suit="Picas";
	
	Mazo[1]=new Carta();
	Mazo[1].Valor=3;
	Mazo[1].Simbolo="3";
	Mazo[1].Suit="Picas";
	
	Mazo[2]=new Carta();
	Mazo[2].Valor=4;
	Mazo[2].Simbolo="4";
	Mazo[2].Suit="Picas";
	
	Mazo[3]=new Carta();
	Mazo[3].Valor=5;
	Mazo[3].Simbolo="5";
	Mazo[3].Suit="Picas";
	
	Mazo[4]=new Carta();
	Mazo[4].Valor=6;
	Mazo[4].Simbolo="6";
	Mazo[4].Suit="Picas";
	
	Mazo[5]=new Carta();
	Mazo[5].Valor=7;
	Mazo[5].Simbolo="7";
	Mazo[5].Suit="Picas";
	
	Mazo[6]=new Carta();
	Mazo[6].Valor=8;
	Mazo[6].Simbolo="8";
	Mazo[6].Suit="Picas";
	
	Mazo[7]=new Carta();
	Mazo[7].Valor=9;
	Mazo[7].Simbolo="9";
	Mazo[7].Suit="Picas";
	
	Mazo[8]=new Carta();
	Mazo[8].Valor=10;
	Mazo[8].Simbolo="10";
	Mazo[8].Suit="Picas";
	
	Mazo[9]=new Carta();
	Mazo[9].Valor=11;
	Mazo[9].Simbolo="J";
	Mazo[9].Suit="Picas";
	
	Mazo[10]=new Carta();
	Mazo[10].Valor=12;
	Mazo[10].Simbolo="Q";
	Mazo[10].Suit="Picas";
	
	Mazo[11]=new Carta();
	Mazo[11].Valor=13;
	Mazo[11].Simbolo="K";
	Mazo[11].Suit="Picas";
	
	Mazo[12]=new Carta();
	Mazo[12].Valor=14;
	Mazo[12].Simbolo="A";
	Mazo[12].Suit="Picas";
	
	//-------------------------
	
	Mazo[13]=new Carta();
	Mazo[13].Valor=2;
	Mazo[13].Simbolo="2";
	Mazo[13].Suit="Corazones";
	
	Mazo[14]=new Carta();
	Mazo[14].Valor=3;
	Mazo[14].Simbolo="3";
	Mazo[14].Suit="Corazones";
	
	Mazo[15]=new Carta();
	Mazo[15].Valor=4;
	Mazo[15].Simbolo="4";
	Mazo[15].Suit="Corazones";
	
	Mazo[16]=new Carta();
	Mazo[16].Valor=5;
	Mazo[16].Simbolo="5";
	Mazo[16].Suit="Corazones";
	
	Mazo[17]=new Carta();
	Mazo[17].Valor=6;
	Mazo[17].Simbolo="6";
	Mazo[17].Suit="Corazones";
	
	Mazo[18]=new Carta();
	Mazo[18].Valor=7;
	Mazo[18].Simbolo="7";
	Mazo[18].Suit="Corazones";
	
	Mazo[19]=new Carta();
	Mazo[19].Valor=8;
	Mazo[19].Simbolo="8";
	Mazo[19].Suit="Corazones";
	
	Mazo[20]=new Carta();
	Mazo[20].Valor=9;
	Mazo[20].Simbolo="9";
	Mazo[20].Suit="Corazones";
	
	Mazo[21]=new Carta();
	Mazo[21].Valor=10;
	Mazo[21].Simbolo="10";
	Mazo[21].Suit="Corazones";
	
	Mazo[22]=new Carta();
	Mazo[22].Valor=11;
	Mazo[22].Simbolo="J";
	Mazo[22].Suit="Corazones";
	
	Mazo[23]=new Carta();
	Mazo[23].Valor=12;
	Mazo[23].Simbolo="Q";
	Mazo[23].Suit="Corazones";
	
	Mazo[24]=new Carta();
	Mazo[24].Valor=13;
	Mazo[24].Simbolo="K";
	Mazo[24].Suit="Corazones";
	
	Mazo[25]=new Carta();
	Mazo[25].Valor=14;
	Mazo[25].Simbolo="A";
	Mazo[25].Suit="Corazones";
	
	//----------------------------
	
	Mazo[26]=new Carta();
	Mazo[26].Valor=2;
	Mazo[26].Simbolo="2";
	Mazo[26].Suit="Diamantes";
	
	Mazo[27]=new Carta();
	Mazo[27].Valor=3;
	Mazo[27].Simbolo="3";
	Mazo[27].Suit="Diamantes";
	
	Mazo[28]=new Carta();
	Mazo[28].Valor=4;
	Mazo[28].Simbolo="4";
	Mazo[28].Suit="Diamantes";
	
	Mazo[29]=new Carta();
	Mazo[29].Valor=5;
	Mazo[29].Simbolo="5";
	Mazo[29].Suit="Diamantes";
	
	Mazo[30]=new Carta();
	Mazo[30].Valor=6;
	Mazo[30].Simbolo="6";
	Mazo[30].Suit="Diamantes";
	
	Mazo[31]=new Carta();
	Mazo[31].Valor=7;
	Mazo[31].Simbolo="7";
	Mazo[31].Suit="Diamantes";
	
	Mazo[32]=new Carta();
	Mazo[32].Valor=8;
	Mazo[32].Simbolo="8";
	Mazo[32].Suit="Diamantes";
	
	Mazo[33]=new Carta();
	Mazo[33].Valor=9;
	Mazo[33].Simbolo="9";
	Mazo[33].Suit="Diamantes";
	
	Mazo[34]=new Carta();
	Mazo[34].Valor=10;
	Mazo[34].Simbolo="10";
	Mazo[34].Suit="Diamantes";
	
	Mazo[35]=new Carta();
	Mazo[35].Valor=11;
	Mazo[35].Simbolo="J";
	Mazo[35].Suit="Diamantes";
	
	Mazo[36]=new Carta();
	Mazo[36].Valor=12;
	Mazo[36].Simbolo="Q";
	Mazo[36].Suit="Diamantes";
	
	Mazo[37]=new Carta();
	Mazo[37].Valor=13;
	Mazo[37].Simbolo="K";
	Mazo[37].Suit="Diamantes";
	
	Mazo[38]=new Carta();
	Mazo[38].Valor=14;
	Mazo[38].Simbolo="A";
	Mazo[38].Suit="Diamantes";
	
	//----------------------------
	
	Mazo[39]=new Carta();
	Mazo[39].Valor=2;
	Mazo[39].Simbolo="2";
	Mazo[39].Suit="Treboles";
	
	Mazo[40]=new Carta();
	Mazo[40].Valor=3;
	Mazo[40].Simbolo="3";
	Mazo[40].Suit="Treboles";
	
	Mazo[41]=new Carta();
	Mazo[41].Valor=4;
	Mazo[41].Simbolo="4";
	Mazo[41].Suit="Treboles";
	
	Mazo[42]=new Carta();
	Mazo[42].Valor=5;
	Mazo[42].Simbolo="5";
	Mazo[42].Suit="Treboles";
	
	Mazo[43]=new Carta();
	Mazo[43].Valor=6;
	Mazo[43].Simbolo="6";
	Mazo[43].Suit="Treboles";
	
	Mazo[44]=new Carta();
	Mazo[44].Valor=7;
	Mazo[44].Simbolo="7";
	Mazo[44].Suit="Treboles";
	
	Mazo[45]=new Carta();
	Mazo[45].Valor=8;
	Mazo[45].Simbolo="8";
	Mazo[45].Suit="Treboles";
	
	Mazo[46]=new Carta();
	Mazo[46].Valor=9;
	Mazo[46].Simbolo="9";
	Mazo[46].Suit="Treboles";
	
	Mazo[47]=new Carta();
	Mazo[47].Valor=10;
	Mazo[47].Simbolo="10";
	Mazo[47].Suit="Treboles";
	
	Mazo[48]=new Carta();
	Mazo[48].Valor=11;
	Mazo[48].Simbolo="J";
	Mazo[48].Suit="Treboles";
	
	Mazo[49]=new Carta();
	Mazo[49].Valor=12;
	Mazo[49].Simbolo="Q";
	Mazo[49].Suit="Treboles";
	
	Mazo[50]=new Carta();
	Mazo[50].Valor=13;
	Mazo[50].Simbolo="K";
	Mazo[50].Suit="Treboles";
	
	Mazo[51]=new Carta();
	Mazo[51].Valor=14;
	Mazo[51].Simbolo="A";
	Mazo[51].Suit="Treboles";
}

public void MezclarPaq()
{
	Random X = new Random();
	Carta aux;
	int pos;
	for(int i=0; i<52;i++)
	{
		pos = X.nextInt(52);
		aux = Mazo[i];
		Mazo[i]=Mazo[pos];
		Mazo[pos]=aux;
	}
}


public Carta[][] Repartir(Carta[][] Mesa, int n) {
	int j=0;
	int k=0;
	int i;
	//Mesa.length=7
	//Mesa[0].length=4
	for(i=0;i<2;i++)
	{
		for(j=0;j<Mesa[0].length;j++) 
		{
			Mesa[i][j]=this.Mazo[k];
			k++;
		}
	}
	for(i=2;i<Mesa.length;i++)
	{
		for(j=0;j<Mesa[0].length;j++)
		{
			Mesa[i][j]=this.Mazo[k];
		}
		k++;
	}
	
	return Mesa;	
}
}
