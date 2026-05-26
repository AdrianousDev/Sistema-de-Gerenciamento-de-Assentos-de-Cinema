package repository;

import model.Cliente;

public interface ClienteRepository extends Repository<Cliente> {
    Cliente buscarPorCpf(String cpf);
}
