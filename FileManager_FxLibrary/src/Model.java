import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * Created by illia on 08.12.14.
 */
public class Model {

    public static ObservableList<FileInfo> files;

    private Stage primaryStage;

    public Model(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public Stage getStage(){return primaryStage;}

    public ObservableList<FileInfo> getList() {
        return files;
    }
}
