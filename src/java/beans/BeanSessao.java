package beans;

import dados.Jogada;
import dados.Jogador;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "beanSessao")
@SessionScoped
public class BeanSessao implements Serializable {

    private String nome;
    private Jogador jogador;
    private Integer numero;
    private char parOuImpar;
    private String resultado;
    private ArrayList<Jogada> jogadas = new ArrayList<>();

    @Inject
    JogadoresBean jogadores;

    public BeanSessao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public char getParOuImpar() {
        return parOuImpar;
    }

    public void setParOuImpar(char parOuImpar) {
        this.parOuImpar = parOuImpar;
    }

    public String logar() {
        if (nome == null || nome.trim().length() == 0) {
            return null;
        }
        //registrar no bean de aplicacao
        jogador = jogadores.registrar(nome);
        return "jogar.xhtml";
    }

    public String jogar() {
        //aq é tipo aqle jogo de impar ou par, soma o seu numero e o numero da outra pessoa e ve se deu par ou impar
        Random r = new Random(System.currentTimeMillis());
        int computador = r.nextInt(5) + 1;
        int soma = computador + numero;
        jogador.incrementarJogos();
        Jogada nova = new Jogada(numero, computador, parOuImpar);
        if (nova.ganhador() == 'J') {
            jogador.incrementarVitorias();
            //adiciona um alert com uma mensagem tipo joption
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ganhou!","Você ganhou."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perdeu!","Você perdeu."));
        }
        jogadas.add(nova);
        return null;
    }
    
    public void limpar(){
        jogadas.clear();
        jogador.zerar();
//        como aqui foi chamado via ajax nao precisa do return
    }

    public ArrayList<Jogada> getJogadas() {
        return jogadas;
    }

    public void setJogadas(ArrayList<Jogada> jogadas) {
        this.jogadas = jogadas;
    }

}
