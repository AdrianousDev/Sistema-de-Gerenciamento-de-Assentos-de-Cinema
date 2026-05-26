package repository;

import model.Sala;

public interface SalaRepository extends Repository<Sala> {
    Sala buscarPorNome(String nome);
}