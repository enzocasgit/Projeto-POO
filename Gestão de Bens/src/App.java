import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import Model.Sistema;

public class App extends Application 
{
    private Sistema sistema;
    private boolean isCadastroBensVisible = false;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        sistema = new Sistema();

        VBox loginView = createLoginScene(primaryStage);

        primaryStage.setTitle("Sistema de Reservas");
        primaryStage.setScene(new Scene(loginView));
        primaryStage.show();
    }

    private VBox createLoginScene(Stage stage) 
    {
        VBox loginView = new VBox(20);
        loginView.setPrefSize(1280, 720);
        loginView.setAlignment(javafx.geometry.Pos.CENTER);

        Label usernameLabel = new Label("Usuário:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Usuário");

        Label passwordLabel = new Label("Senha:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Senha");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            boolean isAdmin = sistema.autenticar(username, password);

            if (isAdmin) 
            {
                stage.setScene(new Scene(createMenuView(stage)));
            } 
            else 
            {
                stage.setScene(new Scene(createMenuView(stage)));
            }
        });

        loginView.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
        return loginView;
    }

    private VBox createMenuView(Stage stage) 
    {
        VBox menuView = new VBox(20);
        menuView.setPrefSize(1280, 720);
        menuView.setAlignment(javafx.geometry.Pos.CENTER);

        Button reservaButton = new Button("Reserva");
        reservaButton.setMinSize(200, 50);
        reservaButton.setOnAction(e -> {
            stage.setScene(new Scene(createReservaView(stage)));
        });

        Button cadastroBensButton = new Button("Gerenciar bens");
        cadastroBensButton.setMinSize(200, 50);
        cadastroBensButton.setOnAction(e -> {
            if (!isCadastroBensVisible) {
                stage.setScene(new Scene(createCadastroBensView(stage)));
                isCadastroBensVisible = true;
            } else {
                stage.setScene(new Scene(createMenuView(stage)));
                isCadastroBensVisible = false;
            }
        });

        menuView.getChildren().addAll(reservaButton, cadastroBensButton);
        return menuView;
    }

    private VBox createReservaView(Stage stage) 
    {
        VBox reservaView = new VBox(20);
        reservaView.setPrefSize(1280, 720);
        reservaView.setAlignment(javafx.geometry.Pos.CENTER);

        Button voltarButton = new Button("Voltar");
        voltarButton.setMinSize(200, 50);
        voltarButton.setOnAction(e -> {
            stage.setScene(new Scene(createMenuView(stage)));
        });

        reservaView.getChildren().add(voltarButton);
        return reservaView;
    }

    private VBox createCadastroBensView(Stage stage) 
    {
        VBox cadastroBensView = new VBox(20);
        cadastroBensView.setPrefSize(1280, 720);
        cadastroBensView.setAlignment(javafx.geometry.Pos.CENTER);

        // GerenciamentoBens gerenciamentoBens = new GerenciamentoBens(sistema);

        Button voltarButton = new Button("Voltar");
        voltarButton.setMinSize(200, 50);
        voltarButton.setOnAction(e -> {
            stage.setScene(new Scene(createMenuView(stage), 1280, 720));
            isCadastroBensVisible = false; // Marca como fechado
        });

        Button removerBemButton = new Button("Remover Bem");
        removerBemButton.setMinSize(200, 50);
        /*removerBemButton.setOnAction(e -> {
            Bem bemSelecionado = gerenciamentoBens.getBemSelecionado(); // Implementar método para pegar bem selecionado
            if (bemSelecionado != null) {
                sistema.removerBem(bemSelecionado.getIdBem()); // Remover pelo ID do bem
                gerenciamentoBens.refreshAssets(); // Atualiza a lista de bens
            }
        });*/

        Button editarBemButton = new Button("Editar Bem");
        editarBemButton.setMinSize(200, 50);
        /*editarBemButton.setOnAction(e -> {
            Bem bemSelecionado = gerenciamentoBens.getBemSelecionado(); // Implementar método para pegar bem selecionado
            if (bemSelecionado != null) {
                abrirJanelaEditarBem(bemSelecionado, gerenciamentoBens); // Abre janela de edição
            }
        });*/

        //cadastroBensView.getChildren().addAll(gerenciamentoBens.getAssetPane(), removerBemButton, editarBemButton, voltarButton);

        cadastroBensView.getChildren().addAll(removerBemButton, editarBemButton, voltarButton);
        return cadastroBensView;
    }
}


/* package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Bem;
import model.Sistema;

public class MainView extends Application {

    private Sistema sistema;
    private VBox cadastroBensView;
    private boolean isCadastroBensVisible = false; // Controla a exibição da aba "Gerenciar Bens"

    @Override
    public void start(Stage primaryStage) {
        sistema = new Sistema(); // Instancie o sistema

        VBox loginView = createLoginView(primaryStage);
        VBox menuView = createMenuView(primaryStage);

        primaryStage.setTitle("Sistema de Reservas");
        primaryStage.setScene(new Scene(loginView, 1280, 720));
        primaryStage.show();
    }

    private VBox createCadastroBensView(Stage stage) {
        if (cadastroBensView == null) {
            cadastroBensView = new VBox(20);
            cadastroBensView.setPrefSize(1280, 720);
            cadastroBensView.setAlignment(javafx.geometry.Pos.CENTER);

            GerenciamentoBens gerenciamentoBens = new GerenciamentoBens(sistema);

            Button voltarButton = new Button("Voltar");
            voltarButton.setMinSize(200, 50);
            voltarButton.setOnAction(e -> {
                stage.setScene(new Scene(createMenuView(stage), 1280, 720));
                isCadastroBensVisible = false; // Marca como fechado
            });

            Button removerBemButton = new Button("Remover Bem");
            removerBemButton.setMinSize(200, 50);
            removerBemButton.setOnAction(e -> {
                Bem bemSelecionado = gerenciamentoBens.getBemSelecionado(); // Implementar método para pegar bem selecionado
                if (bemSelecionado != null) {
                    sistema.removerBem(bemSelecionado.getIdBem()); // Remover pelo ID do bem
                    gerenciamentoBens.refreshAssets(); // Atualiza a lista de bens
                }
            });

            Button editarBemButton = new Button("Editar Bem");
            editarBemButton.setMinSize(200, 50);
            editarBemButton.setOnAction(e -> {
                Bem bemSelecionado = gerenciamentoBens.getBemSelecionado(); // Implementar método para pegar bem selecionado
                if (bemSelecionado != null) {
                    abrirJanelaEditarBem(bemSelecionado, gerenciamentoBens); // Abre janela de edição
                }
            });

            cadastroBensView.getChildren().addAll(gerenciamentoBens.getAssetPane(), removerBemButton, editarBemButton, voltarButton);
        }
        return cadastroBensView;
    }


    private void abrirJanelaEditarBem(Bem bem, GerenciamentoBens gerenciamentoBens) {
        Stage editarBemStage = new Stage();
        VBox editView = new VBox(20);
        editView.setAlignment(javafx.geometry.Pos.CENTER);

        TextField nomeField = new TextField(bem.getNomeBem());
        TextField dataAquisicaoField = new TextField(bem.getDataDeAquisicao());

        Button salvarButton = new Button("Salvar");
        salvarButton.setOnAction(e -> {
            bem.setNomeBem(nomeField.getText());
            bem.setDataDeAquisicao(dataAquisicaoField.getText());
            gerenciamentoBens.refreshAssets(); // Atualiza a lista com o bem editado
            editarBemStage.close();
        });

        editView.getChildren().addAll(new Label("Nome do Bem:"), nomeField, new Label("Data de Aquisição:"), dataAquisicaoField, salvarButton);
        editarBemStage.setScene(new Scene(editView, 300, 200));
        editarBemStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/
