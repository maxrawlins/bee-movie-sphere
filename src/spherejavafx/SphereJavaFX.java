//Page 391 in the JavaFX Textbook
package spherejavafx;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class SphereJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        StackPane root = new StackPane();
        
        //root.getChildren().add(btn);
        Scene scene = new Scene(root, 1000, 1000);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        
        //Backs the camera away from the scene by 1000 units
        camera.setTranslateZ(-2500);
        
        //This is the range of which the camera will render objects
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        
        //The default field of view for the scene is 30 but change to suit
        camera.setFieldOfView(60);
        scene.setCamera(camera);
        
        //This sets up my sphere
        Sphere mysphere = new Sphere(1000);
        mysphere.setTranslateX(-380);
        mysphere.setTranslateY(-500);
        mysphere.setTranslateZ(200);
        root.getChildren().add(mysphere);
        
        //This sets up the image of the earth to wrap around my sphere
        Image earthImage = new Image("file:bee.jpg");
        PhongMaterial earthPhong = new PhongMaterial();
        earthPhong.setDiffuseMap(earthImage);
        mysphere.setMaterial(earthPhong);
        
        //This rotates my sphere
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(mysphere);
        rotate.setDuration(Duration.millis(1500));
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(-360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
  
        
        launch(args);
    }
    
}
