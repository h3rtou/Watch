package dev.heitor.watch.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class VideoPlayerController {

    //Principal Panes
    @FXML
    private ScrollPane leftPane, rightPane;


    private MediaPlayer mediaPlayer;

    public void initialize(){
        toggleListContentPane();
        toggleConfigPane();
        loadVideo("/home/heitor-ribeiro/.Watch/videos/BetterCallSaul.mp4");

        playPauseButton.setOnAction(e ->{
            String playState = mediaPlayer.getStatus().toString();
            switch (playState){
                case "PLAYING":
                    mediaPlayer.pause();
                    break;
                default:
                    mediaPlayer.play();
            }
                });
    }

    //Media
    @FXML
    private MediaView mediaView;

    @FXML
    private HBox mediaControlPane;

    public void loadVideo(String path){
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    //Media Buttons
    @FXML
    private Button playPauseButton;

    //Toggle Buttons Method
    @FXML
    public void toggleListContentPane(){
        boolean visibility = leftPane.isVisible();
        leftPane.setVisible(!visibility);
    }

    @FXML
    public void toggleConfigPane(){
        boolean visibility = rightPane.isVisible();
        rightPane.setVisible(!visibility);
    }

}
