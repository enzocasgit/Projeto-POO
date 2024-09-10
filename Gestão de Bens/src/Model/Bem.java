package Model;

import java.time.LocalDate;

public class Bem {

    private String dataDeAquisicao;
    private String nomeBem;
    private long idBem;
    private Local local;
    private LocalDate dataDeReserva;
    private boolean reservado;
    private double valorOriginal;
    private double valorAtual;
    private int vidaUtil;

    public Bem() {
        // Construtor padrão
    }

    public Bem(String dataDeAquisicao, String nomeBem, long idBem, Local local, LocalDate dataDeReserva, boolean reservado, double valorOriginal, double valorAtual, int vidaUtil) {
        this.dataDeAquisicao = dataDeAquisicao;
        this.nomeBem = nomeBem;
        this.idBem = idBem;
        this.local = local;
        this.dataDeReserva = dataDeReserva;
        this.reservado = reservado;
        this.valorOriginal = valorOriginal;
        this.valorAtual = valorAtual;
        this.vidaUtil = vidaUtil;
    }

    // Métodos getters e setters

    public String getDataDeAquisicao() {
        return dataDeAquisicao;
    }

    public void setDataDeAquisicao(String dataDeAquisicao) {
        this.dataDeAquisicao = dataDeAquisicao;
    }

    public String getNomeBem() {
        return nomeBem;
    }

    public void setNomeBem(String nomeBem) {
        this.nomeBem = nomeBem;
    }

    public long getIdBem() {
        return idBem;
    }

    public void setIdBem(long idBem) {
        this.idBem = idBem;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public LocalDate getDataDeReserva() {
        return dataDeReserva;
    }

    public void setDataDeReserva(LocalDate dataDeReserva) {
        this.dataDeReserva = dataDeReserva;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public void depreciar(double taxa) {
        valorAtual -= valorAtual * taxa;
    }

    // Métodos de validação
    public boolean validarDataDeAquisicao() {
        // Implementar validação da data
        return true;
    }

    public boolean validarNomeBem() {
        return nomeBem != null && !nomeBem.trim().isEmpty();
    }

    public boolean validarIdBem() {
        return idBem > 0;
    }

    public boolean validarLocal() {
        return local != null;
    }

    public boolean validarDataDeReserva() {
        return dataDeReserva != null;
    }

    public boolean validarValorOriginal() {
        return valorOriginal >= 0;
    }

    public boolean validarValorAtual() {
        return valorAtual >= 0;
    }

    public boolean validarVidaUtil() {
        return vidaUtil > 0;
    }
}
