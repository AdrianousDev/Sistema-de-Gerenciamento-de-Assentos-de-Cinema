package model;

import exception.CadeiraLivreException;
import exception.CadeiraOcupadaException;

public class Cadeira {
    private String codigo;
    private boolean ocupada;

    public Cadeira(String codigo) {
        this.codigo = codigo;
        this.ocupada = false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public boolean isOcupada() {
        return this.ocupada;
    }

    public void reservar() {
        if (this.ocupada) throw new CadeiraOcupadaException();

        ocupada = true;
    }

    public void liberar() {
        if (!this.ocupada) throw new CadeiraLivreException();

        ocupada = false;
    }

    @Override
    public String toString() {
        String status = ocupada ? "X" : "L";

        return "[" + codigo + "-" + status + "]";
    }
}