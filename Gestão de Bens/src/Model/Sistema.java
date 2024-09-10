package Model;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Bem> bens;
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    public Sistema() {
        bens = new ArrayList<>();
        usuarios = new ArrayList<>();
        // Adiciona usuários pré-cadastrados para o exemplo
        usuarios.add(new Usuario("admin", "admin", Usuario.TipoUsuario.ADMINISTRADOR)); // Administrador
        usuarios.add(new Usuario("user", "user", Usuario.TipoUsuario.ALUNO));  // Usuário normal
        usuarios.add(new Usuario("ISAAC", "pipipopo", Usuario.TipoUsuario.ADMINISTRADOR)); // Novo administrador
    }

    public void autenticarUsuario(String login, String senha) {
        if (login.equals("admin@alu.ufc.br") && senha.equals("admin")) {
            usuarioLogado = new Usuario("admin", senha, Usuario.TipoUsuario.ADMINISTRADOR);
        } else if (login.equals("servidor@alu.ufc.br") && senha.equals("servidor")) {
            usuarioLogado = new Usuario("servidor", senha, Usuario.TipoUsuario.SERVIDOR);
        } else if (login.equals("aluno@alu.ufc.br") && senha.equals("aluno")) {
            usuarioLogado = new Usuario("aluno", senha, Usuario.TipoUsuario.ALUNO);
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    }

    public boolean autenticar(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                return usuario.getTipoUsuario() == Usuario.TipoUsuario.ADMINISTRADOR;
            }
        }
        return false;
    }

    public void cadastrarBem(Bem bem) {
        try {
            validarBem(bem);
            bens.add(bem);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar bem: " + e.getMessage());
        }
    }

    public void atualizarBem(Bem bemAtualizado) {
        try {
            validarBem(bemAtualizado);
            for (int i = 0; i < bens.size(); i++) {
                Bem bem = bens.get(i);
                if (bem.getIdBem() == bemAtualizado.getIdBem()) {
                    bens.set(i, bemAtualizado);
                    return;
                }
            }
            System.out.println("Bem com o ID " + bemAtualizado.getIdBem() + " não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar bem: " + e.getMessage());
        }
    }

    public Bem getBemPorId(long idBem) {
        for (Bem bem : bens) {
            if (bem.getIdBem() == idBem) {
                return bem;
            }
        }
        System.out.println("Bem com o ID " + idBem + " não encontrado.");
        return null;
    }

    public List<Bem> getTodosBens() {
        return getBens(); // Chama o método que já retorna a lista de bens
    }

    public void removerBem(long idBem) {
        boolean removido = bens.removeIf(bem -> bem.getIdBem() == idBem);
        if (!removido) {
            System.out.println("Bem com o ID " + idBem + " não encontrado.");
        }
    }

    public Bem getBemByName(String nomeBem) {
        for (Bem bem : bens) {
            if (bem.getNomeBem().equals(nomeBem)) {
                return bem;
            }
        }
        return null;
    }

    public List<Bem> getBens() {
        return bens;
    }

    private void validarBem(Bem bem) {
        if (bem.getIdBem() <= 0) {
            throw new IllegalArgumentException("ID do bem deve ser positivo.");
        }
        if (bem.getValorOriginal() < 0 || bem.getValorAtual() < 0) {
            throw new IllegalArgumentException("Valores do bem devem ser não negativos.");
        }
        if (bem.getVidaUtil() < 0) {
            throw new IllegalArgumentException("Vida útil do bem deve ser não negativa.");
        }
        // Adicione outras validações conforme necessário
    }
}
