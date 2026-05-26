package repository;

import model.Funcionario;

public interface FuncionarioRepository extends Repository<Funcionario> {
    Funcionario buscarPorMatricula(String matricula);
}
