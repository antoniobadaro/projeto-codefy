package com.codefy.usuario;

import com.codefy.colecoesdereproducao.Playlist;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private Integer idade;
    private Integer id;
    private String senha;
    private boolean assinante;
    private List<Playlist> minhasPlaylists;

    public Usuario() {
        this.assinante = false;
        minhasPlaylists=new ArrayList<>();
    }

    //Métodos da classe
    public boolean assinarPlano(){
        return this.assinante=true;
    }
    public boolean cancelarPlano(){
        return this.assinante=false;
    }
    public void adicionarPlaylist(Playlist novaPlaylist){ // Adiciona uma playlist que foi criada dentro do menu do usuário na classe Main
        minhasPlaylists.add(novaPlaylist);
        novaPlaylist.setIdDaPlaylist(minhasPlaylists.indexOf(novaPlaylist));
    }

    public void excluirPlaylist(Playlist playlist){
        minhasPlaylists.remove(playlist);
        System.out.println("playlist removida");
    }

    public void listarPlaylist(){
        for(int i=0;i<getMinhasPlaylists().size();i++){
            System.out.println(" Playlist: "+ minhasPlaylists.get(i).getNomeDaPlaylist()+" | ID: "+i);
        }
    }

    //getter e setter necessários


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

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
        List<String> nomesDasPlaylists=new ArrayList<>();
        for (int i=0;i<minhasPlaylists.size();i++){ //uma lista que armazena apenas os nomes das playlists para poder exibir
            nomesDasPlaylists.add(minhasPlaylists.get(i).getNomeDaPlaylist());

        }
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", id=" + id +
                ", assinante=" + assinante +
                ", minhasPlaylists=" + nomesDasPlaylists +//exibe só os nomes da playlist para a tela não ficar saturada de informações
                '}';
    }
}
