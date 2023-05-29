package com.codefy.usuario;

import java.util.ArrayList;
import java.util.List;

public class ManipulacaoDeUsuario {
    private List<Usuario> listaDeUsuarios;

    public ManipulacaoDeUsuario() {
        this.listaDeUsuarios = new ArrayList<>();
    }

    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }


    public void adicionarUsuario(Usuario usuario){
        this.listaDeUsuarios.add(usuario);
        usuario.setId(listaDeUsuarios.indexOf(usuario));
    }
}
