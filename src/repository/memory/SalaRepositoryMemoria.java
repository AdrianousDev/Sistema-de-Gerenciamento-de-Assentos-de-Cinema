package repository.memory;

import exception.SalaJaExisteException;
import exception.SalaNaoEncontradaException;
import model.Sala;
import repository.SalaRepository;

import java.util.ArrayList;
import java.util.List;

public class SalaRepositoryMemoria implements SalaRepository {

    private List<Sala> salas;

    public SalaRepositoryMemoria() {
        this.salas = new ArrayList<>();
    }

    @Override
    public void salvar(Sala sala) {
        for (Sala salaExistente : salas) {
            if (salaExistente.getNome().equalsIgnoreCase(sala.getNome())) {
                throw new SalaJaExisteException();
            }
        }

        salas.add(sala);
    }

    @Override
    public List<Sala> listar() {
        return salas;
    }

    @Override
    public Sala buscarPorNome(String nome) {
        for (Sala sala : salas) {
            if (sala.getNome().equalsIgnoreCase(nome)) {
                return sala;
            }
        }

        throw new SalaNaoEncontradaException();
    }
}
