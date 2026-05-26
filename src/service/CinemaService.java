package service;

import model.Sala;
import repository.SalaRepository;

import java.util.List;

public class CinemaService {

    private SalaRepository salaRepository;

    public CinemaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public void cadastrarSala(String nome, int fileiras, int colunas) {
        Sala sala = new Sala(nome, fileiras, colunas);
        salaRepository.salvar(sala);
    }

    public List<Sala> listarSalas() {
        return salaRepository.listar();
    }

    public Sala buscarSalaPorNome(String nome) {
        return salaRepository.buscarPorNome(nome);
    }

    public void reservarCadeira(String nomeSala, String codigoCadeira) {
        Sala sala = salaRepository.buscarPorNome(nomeSala);

        sala.buscarCadeiraPorCodigo(codigoCadeira).reservar();
    }

    public void liberarCadeira(String nomeSala, String codigoCadeira) {
        Sala sala = salaRepository.buscarPorNome(nomeSala);

        sala.buscarCadeiraPorCodigo(codigoCadeira).liberar();
    }
}