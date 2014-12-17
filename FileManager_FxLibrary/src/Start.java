import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by illia on 08.12.14.
 */
public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Model model = new Model(primaryStage);
        Controller controller = new Controller(model);
        controller.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
