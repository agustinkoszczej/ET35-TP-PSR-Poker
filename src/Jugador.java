public class Jugador {

public int bote;
public int NroJugador;
public boolean CiegaGrande;
public boolean CiegaChica;
public boolean Retirado;

public Jugador(int NroJugador,int bote,boolean CiegaGrande,boolean CiegaChica,boolean Retirado)
{
    this.NroJugador = NroJugador;
    this.bote = bote;
    this.CiegaGrande = CiegaGrande;
    this.CiegaChica = CiegaChica;
    this.Retirado = Retirado;
}
}
