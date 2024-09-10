package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Model {
    private List<Observer> observers = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private final List<String> tiposDeEspaco = List.of("Reuniao", "Videoconferencia", "Auditorio", "Laboratorio 1",
            "Laboratorio 2", "Laboratorio 3");
    private final List<String> equipamentos = List.of("Projetor", "Caixas de som", "Microfone", "Computador");
    private Usuario usuarioAutenticado;

    public Model() {
        popularReservas();
    }

    public void salvarReserva(LocalDate data, Integer horaInicio, Integer minutoInicio, Integer horaTermino,
                              Integer minutoTermino, Integer numeroParticipantes, String tipoAtividade, String equipamento) {

        if (usuarioAutenticado == null || !usuarioAutenticado.podeSolicitarReserva()) {
            showError("Você não tem permissão para realizar reservas.");
            return;
        }

        Reserva reservaAtual = new Reserva(data, horaInicio, minutoInicio, horaTermino, minutoTermino,
                numeroParticipantes, tipoAtividade, equipamento, usuarioAutenticado);

        reservas.add(reservaAtual);
        showSuccess("Reserva solicitada com sucesso e está pendente de aprovação.");
    }

    public void gerenciarReserva(Reserva reserva, boolean aprovar) {
        if (usuarioAutenticado == null || !usuarioAutenticado.isAdmin()) {
            showError("Você não tem permissão para gerenciar reservas.");
            return;
        }

        if (aprovar) {
            reserva.setStatus(true); // Aprovada
            showSuccess("Reserva aprovada.");
        } else {
            reservas.remove(reserva); // Rejeitada
            showSuccess("Reserva rejeitada.");
        }
    }

    public boolean authenticate(String user, String password) {
        if (user.equals("admin@alu.ufc.br") && password.equals("admin")) {
            usuarioAutenticado = new Usuario("admin", user, Usuario.TipoUsuario.ADMINISTRADOR);
            return true;
        } else if (user.equals("servidor@alu.ufc.br") && password.equals("servidor")) {
            usuarioAutenticado = new Usuario("servidor", user, Usuario.TipoUsuario.SERVIDOR);
            return true;
        } else if (user.equals("aluno@alu.ufc.br") && password.equals("aluno")) {
            usuarioAutenticado = new Usuario("aluno", user, Usuario.TipoUsuario.ALUNO);
            return true;
        } else {
            return false;
        }
    }

    public void deslogarUsuario() {
        usuarioAutenticado = null;
        notifyObservers();
    }

    public void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showSuccess(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void popularReservas() {
        LocalDate hoje = LocalDate.now();

        for (int i = 0; i < 100; i++) {
            long diasAleatorios = ThreadLocalRandom.current().nextInt(1, 31);
            LocalDate dataAleatoria = hoje.plusDays(diasAleatorios);

            int horaInicio = ThreadLocalRandom.current().nextInt(8, 20);
            int minutoInicio = ThreadLocalRandom.current().nextInt(0, 55);
            int horaTermino = horaInicio + ThreadLocalRandom.current().nextInt(1, 3);
            int minutoTermino = ThreadLocalRandom.current().nextInt(0, 60);

            int numeroParticipantes = ThreadLocalRandom.current().nextInt(1, 20);
            String tipoDeEspaco = tiposDeEspaco.get(ThreadLocalRandom.current().nextInt(tiposDeEspaco.size()));
            String equipamento = equipamentos.get(ThreadLocalRandom.current().nextInt(equipamentos.size()));

            salvarReserva(dataAleatoria, horaInicio, minutoInicio, horaTermino, minutoTermino, numeroParticipantes,
                    tipoDeEspaco, equipamento);
        }
    }

    public void attachObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void detachObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        List<Observer> observersCopy = new ArrayList<>(observers);
        for (Observer observer : observersCopy) {
            observer.update();
        }
    }
}
