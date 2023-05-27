package com.codefy.usuario;

import com.codefy.colecoesdereproducao.Playlist;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int idade;
    private int id;
    private boolean assinante;
    private List<Playlist> minhasPlaylists;


    //Construtor


    public Usuario(String nome, int idade, int id) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
        minhasPlaylists = new ArrayList<>();
    }

    //Métodos da classe
    public boolean assinarPlano(){
        return this.assinante=true;
    }
    public boolean cancelarPlano(){
        return this.assinante=false;
    }
    public void criarPlaylist(String nomeDaPlaylist){ //Esse método cria uma instância da classe Playlist passando como parâmetros do construtor a propria instancia do Usuario que está chamando o método CriarPalylist e o nome da playlist
        Playlist novaPlaylist=new Playlist(this, nomeDaPlaylist);
        minhasPlaylists.add(novaPlaylist);
    }

    //getter e setter necessários
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getId() {
        return id;
    }

    public boolean isAssinante() {
        return assinante;
    }

    public List<Playlist> getMinhasPlaylists() {
        return minhasPlaylists;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", id=" + id +
                ", assinante=" + assinante +
                ", minhasPlaylists=" + minhasPlaylists +
                '}';
    }
}
