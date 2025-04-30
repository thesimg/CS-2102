package edu.wpi.hw6;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VotingController {
    @FXML
    private Label candidates;

    @FXML
    private TextField vote1;
    @FXML
    private TextField vote2;
    @FXML
    private TextField vote3;


    @FXML
    private Label winner;

    @FXML
    private TextField nominate;


    //TODO: ADD A FIELD FOR YOUR ElectionData OBJECT AND INITIALIZE IT WITH A MostFirstVotesStrategy

    @FXML
    private Label error;

    @FXML
    protected void onVoteClick() {
        //TODO: USE this.vote1.getText()... etc, to pass data to your ElectionData field and cast a vote
    }
    @FXML
    protected void onNominateClick() {
       //TODO: Use this.nominate.getText() to pass data to your ElectionData field and nominate a candidate
    }
    @FXML
    protected void onWinnerClick() {
        //TODO: Use winner.setText(...) to pass data from your ElectionData field to the GUI
    }

    //TODO: Add methods for clicking the change strategy buttons
}