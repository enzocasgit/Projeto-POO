package Model;

public class Usuario {
    public enum TipoUsuario {
        ADMINISTRADOR,
        SERVIDOR,
        ALUNO
    }

    private String login;
    private String senha;
    private TipoUsuario tipoUsuario;

    public Usuario(String login, String senha, TipoUsuario tipoUsuario) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isAdmin() {
        return this.tipoUsuario == TipoUsuario.ADMINISTRADOR;
    }

    public boolean podeSolicitarReserva() {
        return tipoUsuario != TipoUsuario.ALUNO; // Apenas administradores e servidores podem solicitar reservas
    }
}
