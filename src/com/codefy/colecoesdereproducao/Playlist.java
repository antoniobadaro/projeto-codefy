package com.codefy.colecoesdereproducao;

import com.codefy.interfaces.AcoesDeListas;
import com.codefy.servicos.Musica;
import com.codefy.usuario.Usuario;

import java.util.List;

public class Playlist implements AcoesDeListas {
    //atributos
    private Usuario autor;
    private List<Musica>musicasDaPlaylist;
    private String nomeDaPlaylist;

    private Integer idDaPlaylist;


    //Métodos da classe
    public void adicionarMusica(Musica musica){
        this.musicasDaPlaylist.add(musica);
    }
    public void adicionarMusica(List<Musica> musicas){ //sobrecarga do método anterior
        this.musicasDaPlaylist.addAll(musicas);
    }

    //getter e setter necessários


    public Integer getIdDaPlaylist() {
        return idDaPlaylist;
    }

    public void setIdDaPlaylist(Integer idDaPlaylist) {
        this.idDaPlaylist = idDaPlaylist;
    }

    public List<Musica> getMusicasDaPlaylist() {
        return musicasDaPlaylist;
    }

    public String getNomeDaPlaylist() {
        return nomeDaPlaylist;
    }

    public void setNomeDaPlaylist(String nomeDaPlaylist) {
        this.nomeDaPlaylist = nomeDaPlaylist;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    //Métodos sobrescritos da interface com.codefy.interfaces.AcoesDeListas
    @Override
    public void avancarFaixa() {

    }

    @Override
    public void retrocederFaixa() {

    }
}
