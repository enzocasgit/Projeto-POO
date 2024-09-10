package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
    private Integer numeroParticipantes;
    private String tipoAtividade;
    private String equipamento;
    private Usuario professorResponsavel;
    private boolean status; // true = aprovado, false = pendente/rejeitado

    // Construtor modificado para aceitar o professorResponsavel (Usuario)
    public Reserva(LocalDate data, Integer horaInicio, Integer minutoInicio, Integer horaTermino, Integer minutoTermino,
                   Integer numeroParticipantes, String tipoAtividade, String equipamento, Usuario professorResponsavel) {
        this.data = data;
        this.horaInicio = LocalTime.of(horaInicio, minutoInicio);
        this.horaTermino = LocalTime.of(horaTermino, minutoTermino);
        this.numeroParticipantes = numeroParticipantes;
        this.tipoAtividade = tipoAtividade;
        this.equipamento = equipamento;
        this.professorResponsavel = professorResponsavel;
        this.status = false; // Inicia como pendente
    }

    // Getters e Setters
    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public Integer getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public Usuario getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Usuario professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }
}
