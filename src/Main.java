import repository.SalaRepository;
import repository.memory.SalaRepositoryMemoria;
import service.CinemaService;
import ui.Menu;

public class Main {

    public static void main(String[] args) {

        SalaRepository salaRepository = new SalaRepositoryMemoria();

        CinemaService cinemaService = new CinemaService(salaRepository);

        cinemaService.cadastrarSala("Sala 1", 3, 4);
        cinemaService.cadastrarSala("Sala VIP", 2, 5);

        Menu menu = new Menu(cinemaService);
        menu.iniciar();

    }
}
