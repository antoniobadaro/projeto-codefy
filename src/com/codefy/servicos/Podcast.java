package com.codefy.servicos;

import com.codefy.classesabstratas.CatacteristicasDasFaixas;

public class Podcast extends CatacteristicasDasFaixas {

    public Podcast(Integer duracaoSeg, String nomeFaixa, String autor, boolean reproduzindo) {
        super(duracaoSeg, nomeFaixa, autor, reproduzindo);
        // TODO Auto-generated constructor stub
    }
    @Override
    public Integer getDuracaoSeg() {
        // TODO Auto-generated method stub
        return super.getDuracaoSeg();
    }
    @Override
    public String getNomeFaixa() {
        // TODO Auto-generated method stub
        return super.getNomeFaixa();
    }
    @Override
    public String getAutor() {
        // TODO Auto-generated method stub
        return super.getAutor();
    }
    @Override
    public boolean getReproduzindo() {
        // TODO Auto-generated method stub
        return super.getReproduzindo();
    }
    @Override
    public void setAutor(String autor) {
        // TODO Auto-generated method stub
        super.setAutor(autor);
    }@Override
    public void setDuracaoSeg(Integer duracaoSeg) {
        // TODO Auto-generated method stub
        super.setDuracaoSeg(duracaoSeg);
    }@Override
    public void setNomeFaixa(String nomeFaixa) {
        // TODO Auto-generated method stub
        super.setNomeFaixa(nomeFaixa);
    }@Override
    public boolean pausar() {
        // TODO Auto-generated method stub
        return super.pausar();
    }@Override
    public boolean reproduzir() {
        // TODO Auto-generated method stub
        return super.reproduzir();
    }
}
