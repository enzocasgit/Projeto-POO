package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.Bem;
import model.Local;
import model.Sistema;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GerenciamentoBens {

    private VBox assetPane;
    private Sistema sistema;

    private ObservableList<String> assets;
    private ListView<String> assetList;

    public GerenciamentoBens(Sistema sistema) {
        this.sistema = sistema;

        // Lista de bens
        assets = FXCollections.observableArrayList();
        assetList = new ListView<>(assets);
        refreshAssets();

        // Botão para abrir a parte de cadastro
        Button cadastrarButton = new Button("Cadastrar Novo Bem");

        // Campos de texto para adicionar um novo bem
        TextField nomeBemField = new TextField();
        nomeBemField.setPromptText("Nome do Bem");

        TextField idBemField = new TextField();
        idBemField.setPromptText("ID do Bem");

        TextField dataAquisicaoField = new TextField();
        dataAquisicaoField.setPromptText("Data de Aquisição (YYYY-MM-DD)");

        TextField unidadeField = new TextField();
        unidadeField.setPromptText("Unidade");

        TextField blocoField = new TextField();
        blocoField.setPromptText("Bloco");

        TextField salaField = new TextField();
        salaField.setPromptText("Sala");

        TextField idSalaField = new TextField();
        idSalaField.setPromptText("ID Sala");

        TextField valorOriginalField = new TextField();
        valorOriginalField.setPromptText("Valor Original");

        TextField valorAtualField = new TextField();
        valorAtualField.setPromptText("Valor Atual");

        TextField vidaUtilField = new TextField();
        vidaUtilField.setPromptText("Vida Útil");

        Button addButton = new Button("Adicionar Bem");

        // Inicialmente, os campos de cadastro estarão ocultos
        nomeBemField.setVisible(false);
        idBemField.setVisible(false);
        dataAquisicaoField.setVisible(false);
        unidadeField.setVisible(false);
        blocoField.setVisible(false);
        salaField.setVisible(false);
        idSalaField.setVisible(false);
        valorOriginalField.setVisible(false);
        valorAtualField.setVisible(false);
        vidaUtilField.setVisible(false);
        addButton.setVisible(false);

        cadastrarButton.setOnAction(e -> {
            // Exibe os campos de cadastro e o botão de adicionar quando "Cadastrar Novo Bem" é clicado
            nomeBemField.setVisible(true);
            idBemField.setVisible(true);
            dataAquisicaoField.setVisible(true);
            unidadeField.setVisible(true);
            blocoField.setVisible(true);
            salaField.setVisible(true);
            idSalaField.setVisible(true);
            valorOriginalField.setVisible(true);
            valorAtualField.setVisible(true);
            vidaUtilField.setVisible(true);
            addButton.setVisible(true);
        });

        addButton.setOnAction(e -> {
            String nomeBem = nomeBemField.getText();
            String idBemText = idBemField.getText();
            String dataAquisicao = dataAquisicaoField.getText();
            String unidadeText = unidadeField.getText();
            String bloco = blocoField.getText();
            String salaText = salaField.getText();
            String idSala = idSalaField.getText();
            String valorOriginalText = valorOriginalField.getText();
            String valorAtualText = valorAtualField.getText();
            String vidaUtilText = vidaUtilField.getText();

            try {
                long idBem = Long.parseLong(idBemText);
                int unidade = Integer.parseInt(unidadeText);
                int sala = Integer.parseInt(salaText);
                double valorOriginal = Double.parseDouble(valorOriginalText);
                double valorAtual = Double.parseDouble(valorAtualText);
                int vidaUtil = Integer.parseInt(vidaUtilText);
                LocalDate dataDeAquisicao = LocalDate.parse(dataAquisicao);

                Bem novoBem = new Bem(dataDeAquisicao.toString(), nomeBem, idBem,
                        new Local(unidade, bloco, sala, idSala), dataDeAquisicao, false,
                        valorOriginal, valorAtual, vidaUtil);
                sistema.cadastrarBem(novoBem);
                refreshAssets(); // Atualiza a lista de bens
            } catch (NumberFormatException ex) {
                showAlert("Erro", "IDs e números devem ser válidos.");
            } catch (DateTimeParseException ex) {
                showAlert("Erro", "Formato de data inválido.");
            } catch (Exception ex) {
                showAlert("Erro", "Verifique os dados fornecidos.");
            }
        });

        // Botão para remover o bem selecionado
        Button removerBemButton = new Button("Remover Bem");
        removerBemButton.setOnAction(e -> {
            Bem bemSelecionado = getBemSelecionado();
            if (bemSelecionado != null) {
                sistema.removerBem(bemSelecionado.getIdBem()); // Remove o bem pelo ID
                refreshAssets(); // Atualiza a lista de bens
            }
        });

        // Botão para editar o bem selecionado
        Button editarBemButton = new Button("Editar Bem");
        editarBemButton.setOnAction(e -> {
            Bem bemSelecionado = getBemSelecionado();
            if (bemSelecionado != null) {
                // Popula os campos com os dados do bem selecionado
                nomeBemField.setText(bemSelecionado.getNomeBem());
                idBemField.setText(String.valueOf(bemSelecionado.getIdBem()));
                dataAquisicaoField.setText(bemSelecionado.getDataDeAquisicao());
                unidadeField.setText(String.valueOf(bemSelecionado.getLocal().getUnidade()));
                blocoField.setText(bemSelecionado.getLocal().getBloco());
                salaField.setText(String.valueOf(bemSelecionado.getLocal().getSala()));
                idSalaField.setText(bemSelecionado.getLocal().getIdSala());
                valorOriginalField.setText(String.valueOf(bemSelecionado.getValorOriginal()));
                valorAtualField.setText(String.valueOf(bemSelecionado.getValorAtual()));
                vidaUtilField.setText(String.valueOf(bemSelecionado.getVidaUtil()));

                // Torna os campos visíveis e configura o botão para atualizar o bem
                nomeBemField.setVisible(true);
                idBemField.setVisible(true);
                dataAquisicaoField.setVisible(true);
                unidadeField.setVisible(true);
                blocoField.setVisible(true);
                salaField.setVisible(true);
                idSalaField.setVisible(true);
                valorOriginalField.setVisible(true);
                valorAtualField.setVisible(true);
                vidaUtilField.setVisible(true);
                addButton.setVisible(true);

                addButton.setOnAction(ev -> {
                    try {
                        long idBemAtualizado = Long.parseLong(idBemField.getText());
                        int unidadeAtualizada = Integer.parseInt(unidadeField.getText());
                        int salaAtualizada = Integer.parseInt(salaField.getText());
                        double valorOriginalAtualizado = Double.parseDouble(valorOriginalField.getText());
                        double valorAtualAtualizado = Double.parseDouble(valorAtualField.getText());
                        int vidaUtilAtualizada = Integer.parseInt(vidaUtilField.getText());
                        LocalDate dataDeAquisicaoAtualizada = LocalDate.parse(dataAquisicaoField.getText());

                        Bem bemAtualizado = new Bem(dataDeAquisicaoAtualizada.toString(), nomeBemField.getText(),
                                idBemAtualizado, new Local(unidadeAtualizada, blocoField.getText(), salaAtualizada, idSalaField.getText()),
                                dataDeAquisicaoAtualizada, false, valorOriginalAtualizado, valorAtualAtualizado, vidaUtilAtualizada);
                        sistema.atualizarBem(bemAtualizado);
                        refreshAssets(); // Atualiza a lista de bens
                    } catch (NumberFormatException ex) {
                        showAlert("Erro", "IDs e números devem ser válidos.");
                    } catch (DateTimeParseException ex) {
                        showAlert("Erro", "Formato de data inválido.");
                    } catch (Exception ex) {
                        showAlert("Erro", "Verifique os dados fornecidos.");
                    }
                });
            }
        });

        // Layout
        assetPane = new VBox(10, assetList, cadastrarButton, nomeBemField, idBemField, dataAquisicaoField, unidadeField, blocoField, salaField, idSalaField, valorOriginalField, valorAtualField, vidaUtilField, addButton, removerBemButton, editarBemButton);
    }

    public Bem getBemSelecionado() {
        String selected = assetList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            long idBem = extractIdFromText(selected); // Método para extrair ID do texto selecionado
            return sistema.getBemPorId(idBem);
        }
        return null;
    }

    private long extractIdFromText(String text) {
        // Implementar a lógica para extrair o ID do texto
        return Long.parseLong(text.split(" ")[0]); // Exemplo básico
    }

    public void refreshAssets() {
        assets.clear();
        for (Bem bem : sistema.getTodosBens()) {
            assets.add(bem.getIdBem() + " - " + bem.getNomeBem());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public VBox getAssetPane() {
        return assetPane;
    }
}
