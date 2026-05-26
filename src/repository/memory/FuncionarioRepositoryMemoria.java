package repository.memory;

import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;
import repository.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositoryMemoria implements FuncionarioRepository {

    private List<Funcionario> funcionarios;

    public FuncionarioRepositoryMemoria() {
        this.funcionarios = new ArrayList<>();
    }

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarios;
    }

    @Override
    public Funcionario buscarPorMatricula(String matricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula().equalsIgnoreCase(matricula)) {
                return funcionario;
            }
        }

        throw new FuncionarioNaoEncontradoException();
    }
}
