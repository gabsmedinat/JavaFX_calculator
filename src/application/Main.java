package application;
	
import java.util.ArrayList;

import application.Calculatrice.Operation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	static float valeur1 = 0;
	static float valeur2 = 0;
	Operation op = Operation.Vide;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			// Entete (Écran)
			TextArea ecran = new TextArea();
			Label lblEcran = new Label();
			ecran.setFont(Font.font("Monospaced",FontWeight.EXTRA_BOLD, 20.0));
			
			AnchorPane conteneurEcran = new AnchorPane(ecran,lblEcran);
			lblEcran.setBackground(Background.fill(Color.AQUAMARINE));
			
			AnchorPane.setTopAnchor(lblEcran,10.0);
			AnchorPane.setLeftAnchor(lblEcran, 10.0);
			AnchorPane.setRightAnchor(lblEcran, 10.0);

			AnchorPane.setTopAnchor(ecran, 40.0);
			AnchorPane.setLeftAnchor(ecran, 10.0);
			AnchorPane.setBottomAnchor(ecran, 10.0);
			AnchorPane.setRightAnchor(ecran, 10.0);
			
			
			VBox.setVgrow(conteneurEcran, Priority.ALWAYS);
			conteneurEcran.setMaxHeight(Integer.MAX_VALUE);
			

			
			
			// Corps-centre (Clavier)
			GridPane conteneurClavier = new GridPane();
			//conteneurClavier.setGridLinesVisible(true);
			
			Bouton btnAddition = new Bouton("+",true);
			Bouton btnSoustraction = new Bouton("-",true);
			Bouton btnMultiplication = new Bouton("*",true);
			Bouton btnDivision = new Bouton("/",true);
			Bouton btnNum0 = new Bouton("0",true);
			Bouton btnNum1 = new Bouton("1",true);
			Bouton btnNum2 = new Bouton("2",true);
			Bouton btnNum3 = new Bouton("3",true);
			Bouton btnNum4 = new Bouton("4",true);
			Bouton btnNum5 = new Bouton("5",true);
			Bouton btnNum6 = new Bouton("6",true);
			Bouton btnNum7 = new Bouton("7",true);
			Bouton btnNum8 = new Bouton("8",true);
			Bouton btnNum9 = new Bouton("9",true);
			Bouton btnPoint = new Bouton(".",true);
			Bouton btnCalculer = new Bouton("=",true);
			Bouton btnInit = new Bouton("Réinitialiser",false);
			Bouton btnFermer = new Bouton("Fermer",false);
	
			
			
			conteneurClavier.add(btnAddition, 0, 0,1,1);
			GridPane.setMargin(btnAddition, new Insets(10));
			btnAddition.setOnAction(event->{
				String val = ecran.getText();
				if(val.isEmpty()) {
					System.out.println("Aucune valeur n'est encore saisie");
				}else {
					valeur1 = Float.parseFloat(val);
					op = Operation.Addition;
					String repSomme = "ADDITION: "+val+" + ";
					lblEcran.setText(repSomme);
					ecran.clear();
				}
			});
			
			conteneurClavier.add(btnSoustraction, 1, 0,1,1);
			GridPane.setMargin(btnSoustraction, new Insets(10));
			btnSoustraction.setOnAction(event->{
				String val = ecran.getText();
				if(val.isEmpty()) {
					System.out.println("Aucune valeur n'est encore saisie");
				}else {
					valeur1 = Float.parseFloat(val);
					op = Operation.Soustraction;
					String repSomme = "MULTIPLICATION: "+val+" - ";
					lblEcran.setText(repSomme);
					ecran.clear();
				}
			});

			
			conteneurClavier.add(btnMultiplication, 2, 0,1,1);
			GridPane.setMargin(btnMultiplication, new Insets(10));
			btnMultiplication.setOnAction(event->{
				String val = ecran.getText();
				if(val.isEmpty()) {
					System.out.println("Aucune valeur n'est encore saisie");
				}else {
					valeur1 = Float.parseFloat(val);
					op = Operation.Multiplication;
					String repSomme = "MULTIPLICATION: "+val+" * ";
					lblEcran.setText(repSomme);
					ecran.clear();
				}
			});
			
			conteneurClavier.add(btnDivision, 3, 0,1,1);
			GridPane.setMargin(btnDivision, new Insets(10));
			btnDivision.setOnAction(event->{
				String val = ecran.getText();
				if(val.isEmpty()) {
					System.out.println("Aucune valeur n'est encore saisie");
				}else {
					valeur1 = Float.parseFloat(val);
					op = Operation.Division;
					String repSomme = "DIVISION: "+val+" / ";
					lblEcran.setText(repSomme);
					ecran.clear();
				}
			});

			conteneurClavier.add(btnNum0, 0, 1,1,1);
			GridPane.setMargin(btnNum0, new Insets(10));
			btnNum0.setOnAction(event ->{
				String val = ecran.getText() +"0";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum1, 1, 1,1,1);
			GridPane.setMargin(btnNum1, new Insets(10));
			btnNum1.setOnAction(event ->{
				String val = ecran.getText() +"1";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum2, 2, 1,1,1);
			GridPane.setMargin(btnNum2, new Insets(10));
			btnNum2.setOnAction(event ->{
				String val = ecran.getText() +"2";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum3, 3, 1,1,1);
			GridPane.setMargin(btnNum3, new Insets(10));
			btnNum3.setOnAction(event ->{
				String val = ecran.getText() +"3";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum4, 0, 2,1,1);
			GridPane.setMargin(btnNum4, new Insets(10));
			btnNum4.setOnAction(event ->{
				String val = ecran.getText() +"4";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum5, 1, 2,1,1);
			GridPane.setMargin(btnNum5, new Insets(10));
			btnNum5.setOnAction(event ->{
				String val = ecran.getText() +"5";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum6, 2, 2,1,1);
			GridPane.setMargin(btnNum6, new Insets(10));
			btnNum6.setOnAction(event ->{
				String val = ecran.getText() +"6";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum7, 3, 2,1,1);
			GridPane.setMargin(btnNum7, new Insets(10));
			btnNum7.setOnAction(event ->{
				String val = ecran.getText() +"7";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum8, 0, 3,1,1);
			GridPane.setMargin(btnNum8, new Insets(10));
			btnNum8.setOnAction(event ->{
				String val = ecran.getText() +"8";
				ecran.setText(val);
			});

			conteneurClavier.add(btnNum9, 1, 3,1,1);
			GridPane.setMargin(btnNum9, new Insets(10));
			btnNum9.setOnAction(event ->{
				String val = ecran.getText() +"9";
				ecran.setText(val);
			});

			conteneurClavier.add(btnPoint, 2, 3,1,1);
			GridPane.setMargin(btnPoint, new Insets(10));
			btnPoint.setOnAction(event ->{
				String val = ecran.getText() +".";
				ecran.setText(val);
			});

			conteneurClavier.add(btnCalculer, 3, 3,1,1);
			GridPane.setMargin(btnCalculer, new Insets(10));
			btnCalculer.setOnAction(event ->{
				String val2 = ecran.getText();
				valeur2 = Float.parseFloat(val2);
				if(valeur1!=0 && valeur2!=0) {
					String resultat = "Résultat: "+Calculatrice.calculer(valeur1,valeur2,op);
					lblEcran.setText(resultat);
				}
			});
			

			conteneurClavier.add(btnInit, 0, 4,2,1);
			GridPane.setMargin(btnInit, new Insets(10));
			btnInit.setOnAction(event ->{
				ecran.clear();
				lblEcran.setText("");
				valeur1 = 0;
				valeur2 = 0;
			});

			conteneurClavier.add(btnFermer, 2, 4,2,1);
			GridPane.setMargin(btnFermer, new Insets(10));
			btnFermer.setOnAction(event ->{
				System.exit(0);
			});
			
			conteneurClavier.setHgap(5);
			conteneurClavier.setVgap(5);

			
			VBox.setVgrow(conteneurClavier, Priority.ALWAYS);
			conteneurClavier.setMaxWidth(Integer.MAX_VALUE);
			conteneurClavier.setAlignment(Pos.CENTER);
			

			root.getChildren().addAll(conteneurEcran,conteneurClavier);
			
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Calculatrice par Gabriel medina");
			primaryStage.show();
			
			

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}

class Bouton extends Button{
	Color couleur = Color.AQUAMARINE;
	
	public Bouton(String text, Boolean numerique) {
		// Si numerique==true, alors le paramètre width ne sera pas spécifié.
		
		this.setText(text);
		this.setFont(Font.font("Arial", FontWeight.BOLD,20.0));
		if(numerique) {
			this.setPrefWidth(100);
			this.setPrefHeight(50);

		}else {
			this.setMaxWidth(200);
			this.setMaxHeight(100);
		}
	}
	
}
