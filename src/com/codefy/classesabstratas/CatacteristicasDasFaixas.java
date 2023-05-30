package com.codefy.classesabstratas;

import com.codefy.interfaces.AcoesPadrao;

public abstract class CatacteristicasDasFaixas implements AcoesPadrao {

    public Integer duracaoSeg;
    public String nomeFaixa;
    public String autor;
    public boolean reproduzindo = false;




    public CatacteristicasDasFaixas(Integer duracaoSeg, String nomeFaixa, String autor) {
        this.duracaoSeg = duracaoSeg;
        this.nomeFaixa = nomeFaixa;
        this.autor = autor;
        this.reproduzindo = false;
    }

    public boolean getReproduzindo() {

        if(this.reproduzindo){

            return  true;
        }

        return false;
    }

    @Override
    public boolean reproduzir() {

        if (!getReproduzindo()) {
            return this.reproduzindo=true;
        }
        return false;
    }

    @Override
    public boolean pausar() {

        if(getReproduzindo()) {

            this.reproduzindo=false;
        }
        return false;
    }

    public Integer getDuracaoSeg() {
        return duracaoSeg;
    }
    public void setDuracaoSeg(Integer duracaoSeg) {
        this.duracaoSeg = duracaoSeg;
    }
    public String getNomeFaixa() {
        return nomeFaixa;
    }
    public void setNomeFaixa(String nomeFaixa) {
        this.nomeFaixa = nomeFaixa;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
