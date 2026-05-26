package model;

import exception.CadeiraNaoEncontradaException;
import exception.DimensoesSalaInvalidasException;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    private String nome;
    private int colunas;
    private List<Cadeira> cadeiras;

    public Sala(String nome, int fileiras, int colunas) {
        validarDimensoes(fileiras, colunas);

        this.nome = nome;
        this.colunas = colunas;
        this.cadeiras = new ArrayList<>();

        gerarCadeiras(fileiras, colunas);
    }

    public String getNome() {
        return nome;
    }

    public int getColunas() {
        return colunas;
    }

    public List<Cadeira> getCadeiras() {
        return cadeiras;
    }

    public Cadeira buscarCadeiraPorCodigo(String codigo) {
        for (Cadeira cadeira : cadeiras) {
            if (cadeira.getCodigo().equalsIgnoreCase(codigo)) {
                return cadeira;
            }
        }

        throw new CadeiraNaoEncontradaException();
    }

    private void gerarCadeiras(int fileiras, int colunas) {
        for (int i = 0; i < fileiras; i++) {
            char letraFileira = (char) ('A' + i);

            for (int j = 1; j <= colunas; j++) {
                String codigo = letraFileira + String.valueOf(j);
                cadeiras.add(new Cadeira(codigo));
            }
        }
    }

    private void validarDimensoes(int fileiras, int colunas) {
        if (fileiras <= 0 || colunas <= 0 || fileiras > 26 || colunas > 20) {
            throw new DimensoesSalaInvalidasException(fileiras, colunas);
        }
    }

}