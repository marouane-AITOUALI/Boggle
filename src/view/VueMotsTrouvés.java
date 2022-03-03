package view;

import boggle.model.Boggle;
import boggle.model.Dictionnaire;
import boggle.model.Observateur;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VueMotsTrouvés extends VBox implements Observateur {

    public Label[] motsTrouvés;
    public Boggle boggle;
    public int cpt = 0;

    public VueMotsTrouvés(Boggle b){
        super(2);
        boggle = b;
        this.setStyle("-fx-background-color: #FFF");
        motsTrouvés = new Label[boggle.getTaille() * boggle.getTaille()];
        this.setAlignment(Pos.CENTER_LEFT);
        motsTrouvés[cpt] = new Label("Les mots retrouvés: ");
        this.getChildren().add(motsTrouvés[cpt]);
        cpt++;
        boggle.ajouterObservateur(this);
    }

    public void mettreAJour(){
        Dictionnaire dico = Dictionnaire.getInstance() ;
        String motChoisi = boggle.getMotChoisi();
        boolean estAffiche = false;
        for(int i =0; i < cpt; i++){
            if(motsTrouvés[i].getText().equals(motChoisi)){
                estAffiche = true;
            }
        }
        if(!estAffiche && dico.contient(boggle.getMotChoisi())){
            motsTrouvés[cpt] = new Label(boggle.getMotChoisi());
            this.getChildren().add(motsTrouvés[cpt]);
            cpt++;
        }

    }


    @Override
    public void reagir() {
        this.mettreAJour();
    }
}
