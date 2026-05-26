package repository.memory;

import exception.ClienteNaoEncontradoException;
import model.Cliente;
import repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryMemoria implements ClienteRepository {

    private List<Cliente> clientes;

    public ClienteRepositoryMemoria() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException();
    }
}
