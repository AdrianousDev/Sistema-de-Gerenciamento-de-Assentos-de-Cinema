package model;

import exception.SalaJaExisteException;
import exception.SalaNaoEncontradaException;

import java.util.List;
import java.util.ArrayList;

public class Cinema {
    private String nome;
    private List<Sala> salas;

    public Cinema(String nome) {
        this.nome = nome;
        this.salas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarSala(Sala sala) {
        for (Sala salaExistente : salas) {
            if (salaExistente.getNome().equalsIgnoreCase(sala.getNome())) throw new SalaJaExisteException();
        }
        salas.add(sala);
    }

    public Sala buscarSalaPorNome(String nome) {
        for (Sala sala : salas) {
            if (sala.getNome().equalsIgnoreCase(nome)) return sala;
        }
        throw new SalaNaoEncontradaException();
    }

    public void listarSalas() {
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");
            return;
        }

        for (Sala sala : salas) {
            System.out.println("- " + sala.getNome());
        }
    }
}