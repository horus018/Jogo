package dados;

public class Jogador {
    private String nome;
    private int jogos, vitorias;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public void incrementarJogos(){
        jogos++;
    }
    
    public void incrementarVitorias(){
        vitorias++;
    }
    
    public void zerar(){
        jogos = 0;
        vitorias = 0;
    }
    
}
