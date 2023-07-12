package dados;

public class Jogada {

    private int numJogador, numComputador;
    private char palpiteJogador;

    public Jogada(int numJogador, int numComputador, char palpiteJogador) {
        this.numJogador = numJogador;
        this.numComputador = numComputador;
        this.palpiteJogador = palpiteJogador;
    }

    public int getNumJogador() {
        return numJogador;
    }

    public int getNumComputador() {
        return numComputador;
    }

    public char getPalpiteJogador() {
        return palpiteJogador;
    }

    public char ganhador() {
        if ((palpiteJogador == 'P' && (numJogador + numComputador % 2 == 0)) || (palpiteJogador == 'I' && (numJogador + numComputador % 2 == 1)))
            return 'J';
        else
            return 'C';

    }
}
