package beans;

import dados.Jogador;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named(value = "jogadoresBean")
@ApplicationScoped

public class JogadoresBean {
    
    private ArrayList<Jogador> jogadores;
    
    public JogadoresBean() {
        jogadores = new ArrayList<>();
    }
    
    public Jogador registrar(String nome){
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador;
            }
        }
        Jogador novo = new Jogador();
        novo.setNome(nome);
        jogadores.add(novo);
        return novo;
    }
    
}
