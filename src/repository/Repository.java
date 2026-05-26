package repository;

import java.util.List;

public interface Repository<T> {
    void salvar(T objeto);
    List<T> listar();
}
