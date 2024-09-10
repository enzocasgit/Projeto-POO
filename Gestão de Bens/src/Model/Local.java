package Model;

public class Local {
    private int unidade;
    private String bloco;
    private int sala;
    private String idSala;

    public Local(int unidade, String bloco, int sala, String idSala) {
        this.unidade = unidade;
        this.bloco = bloco;
        this.sala = sala;
        this.idSala = idSala;
    }

    public int getUnidade() {
        return unidade;
    }

    public String getBloco() {
        return bloco;
    }

    public int getSala() {
        return sala;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }
}
