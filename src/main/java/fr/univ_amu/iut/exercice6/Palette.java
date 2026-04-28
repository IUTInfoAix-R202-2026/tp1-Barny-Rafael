package fr.univ_amu.iut.exercice6;

import fr.univ_amu.iut.exercice5.Compteur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {

  @Override
  public void start(Stage primaryStage) {
    // TODO exercice 6 : implémenter la palette décrite dans la Javadoc.
    //
    // Stratégie conseillée :
    //
    // 1. Créer un BorderPane comme racine.
    //
    // 2. Top : un HBox avec trois boutons "Rouge", "Vert", "Bleu".
    // Donne-leur les ids "btn-rouge", "btn-vert", "btn-bleu" - les tests
    // les retrouvent via robot.lookup("#btn-rouge") etc.
    //
    // 3. Center : un Pane avec l'id "zone", taille minimale 300×200.
    // Change sa couleur via setStyle("-fx-background-color: red;") etc.
    //
    // 4. Bottom : un Label avec l'id "compteurs", texte initial
    // "Rouge: 0 Vert: 0 Bleu: 0".
    //
    // 5. Trois entiers compteur_rouge, compteur_vert, compteur_bleu
    // (ou trois variables d'instance). Chaque clic incrémente le bon
    // compteur et reformate le texte du label.
    //
    // 6. Attention au format du texte du label : les tests vérifient la
    // présence exacte des substrings "Rouge: 2", "Vert: 0", "Bleu: 1"
    // après une séquence de clics.

    BorderPane racine = new BorderPane();
    Button rouge = new Button("Rouge");
    Button vert = new Button("Vert");
    Button bleu = new Button("Bleu");
    rouge.setId("btn-rouge");
    vert.setId("btn-vert");
    bleu.setId("btn-bleu");
    HBox hbox = new HBox(10);
    hbox.getChildren().addAll(rouge, vert, bleu);
    Pane pane = new Pane();
    pane.setMinSize(300, 200);
    pane.setId("zone");
    Label compteurs = new Label("Rouge: 0  Vert: 0  Bleu: 0");
    compteurs.setId("compteurs");
    Compteur compteur_rouge = new Compteur();
    Compteur compteur_vert = new Compteur();
    Compteur compteur_bleu = new Compteur();
    rouge.setOnAction(
        e -> {
          pane.setStyle("-fx-background-color: red;");
          compteur_rouge.incrementer();
          compteurs.setText(
              "Rouge: "
                  + compteur_rouge.getValeur()
                  + "  Vert: "
                  + compteur_vert.getValeur()
                  + "  Bleu: "
                  + compteur_bleu.getValeur());
        });
    vert.setOnAction(
        e -> {
          pane.setStyle("-fx-background-color: green;");
          compteur_vert.incrementer();
          compteurs.setText(
              "Rouge: "
                  + compteur_rouge.getValeur()
                  + "  Vert: "
                  + compteur_vert.getValeur()
                  + "  Bleu: "
                  + compteur_bleu.getValeur());
        });
    bleu.setOnAction(
        e -> {
          pane.setStyle("-fx-background-color: blue;");
          compteur_bleu.incrementer();
          compteurs.setText(
              "Rouge: "
                  + compteur_rouge.getValeur()
                  + "  Vert: "
                  + compteur_vert.getValeur()
                  + "  Bleu: "
                  + compteur_bleu.getValeur());
        });
    racine.setTop(hbox);
    racine.setCenter(pane);
    racine.setBottom(compteurs);
    Scene scene = new Scene(racine);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
