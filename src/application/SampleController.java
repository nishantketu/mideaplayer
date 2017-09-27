package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

public class SampleController implements Initializable {
	private String filePath;
	private MediaPlayer mediaPlayer;
	@FXML
	private Label label;
	@FXML
	private MediaView mediaview;  
	
	@FXML
	private void handleButtonAction(ActionEvent event){
		FileChooser FileChooser=new FileChooser();
		FileChooser.ExtensionFilter  filter=new FileChooser.ExtensionFilter("Mp4 file please", "*.mp4");
		
		FileChooser.getExtensionFilters().add(filter);
		File file=FileChooser.showOpenDialog(null);
		filePath=file.toURI().toString();
		
		if(filePath != null){
			Media media=new Media(filePath);
			mediaPlayer =new MediaPlayer(media);
			mediaview.setMediaPlayer(mediaPlayer);
			//mediaPlayer.setMute(true);
			mediaPlayer.play();
		}	
	}
	@FXML
	private void handleButton1Action(ActionEvent event){	
		mediaPlayer.pause();
	}
	@FXML
	private void handleButton2Action(ActionEvent event){	
	mediaPlayer.play();
	}
	@FXML
	private void handleButton3Action(ActionEvent event){	
		mediaPlayer.seek(mediaPlayer.getCurrentTime().add(mediaPlayer.getTotalDuration().divide(10)));
		mediaPlayer.play();
	}
	@FXML
	private void handleButton4Action(ActionEvent event){	
		mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(mediaPlayer.getTotalDuration().divide(10)));
		mediaPlayer.play();
	}
	@FXML
	private void handleButton5Action(ActionEvent event){	
		mediaPlayer.setMute(true);
	}
	@FXML
	private void handleButton6Action(ActionEvent event){	
		mediaPlayer.setMute(false);
	}
	@FXML
	private void handleKeyAction(ActionEvent event){	
	
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	
		
	}
	
}
