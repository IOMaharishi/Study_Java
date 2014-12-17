import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * Created by illia on 08.12.14.
 */
public class View {

    private Scene scene;

    private GridPane gridPane;
    private HBox northHBox,soutHBox;
    private ToolBar bar;

    private TextField pathText;

    private TableView<FileInfo> table;
    private TableColumn filename;

    private Button updateButton;
    private Button deleteButton,renameButton,createButton,copyButton,searchButton;

    private  Label pathLabel;
    private  Separator separator;

    Stage dialog;//Create window
    Button dialogOkButton,dialogCancleButton;
    TextField dialogFileTextField;

    Stage renameDialog;//RenameFile window
    Button renameDialogOkButton,renameDialogCancleButton;
    TextField renameDialogFileTextField;

    public View(){

        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(50);
        gridPane.setVgap(50);
        gridPane.setStyle("-fx-background-color: gray");


        deleteButton = new Button("Удалить");
        createButton = new Button("Создать");
        renameButton = new Button("Переименовать");
        copyButton = new Button("Копировать");
        searchButton = new Button("Поиск");

        /*
        Initialization tableView
         */

        table = new TableView<FileInfo>();


        filename = new TableColumn();
        filename.setCellValueFactory(new PropertyValueFactory<FileInfo, String>("fileName"));
        filename.setPrefWidth(300);
        Label nameLabel = new Label("Имя файлa");
        nameLabel.setTooltip(new Tooltip("Имя файла"));
        filename.setGraphic(nameLabel);
        filename.setSortable(true);

        TableColumn filesize = new TableColumn();
        Label sizeLabel = new Label("Размер файла(Мб)");
        sizeLabel.setTooltip(new Tooltip("Размер файла(Мб)"));
        filesize.setGraphic(sizeLabel);
        filesize.setCellValueFactory(new PropertyValueFactory<FileInfo, Long>("filesize"));
        filesize.setPrefWidth(220);

/*
        TableColumn filetype = new TableColumn();
        Label typeLabel = new Label("Расширение");
        typeLabel.setTooltip(new Tooltip("Расширение файла"));
        filetype.setGraphic(typeLabel);
        filetype.setCellValueFactory(new PropertyValueFactory<FileInfo, String>("type"));
        filetype.setPrefWidth(100);
*/
        TableColumn filelastmodify = new TableColumn();
        Label lastmodifyLabel = new Label("Дата последнего изменения");
        lastmodifyLabel.setTooltip(new Tooltip("Дата последнего изменения"));
        filelastmodify.setGraphic(lastmodifyLabel);
        filelastmodify.setCellValueFactory(new PropertyValueFactory<FileInfo, String>("lastModify"));
        filelastmodify.setPrefWidth(230);

        table.setItems(Model.files);
        table.getColumns().addAll(filename,filesize,filelastmodify);



        // create ToolBar
        pathText = new TextField();
        updateButton = new Button("Обновить таблицу");
        pathLabel = new Label("Путь к диретории");

        bar = new ToolBar();
        bar.getItems().addAll(pathLabel,pathText,updateButton);
        bar.setStyle("-fx-background-color:darkseagreen;");

        separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        separator.setStyle("-fx-border-width: 0,5%;-fx-border-color: blueviolet");


        // north panel
        northHBox = new HBox(10);
        northHBox.setStyle("-fx-background-color:darkseagreen;");
        northHBox.setAlignment(Pos.CENTER_LEFT);
        northHBox.getChildren().addAll(bar);

        // south panel
        soutHBox = new HBox(10);
        soutHBox.setStyle("-fx-background-color: cadetblue; -fx-border-width: 0,5pt");
        soutHBox.setAlignment(Pos.CENTER);
        soutHBox.setSpacing(20);
        soutHBox.getChildren().addAll(deleteButton,renameButton,copyButton,createButton);



        gridPane.add(northHBox,0,0,16,2);
        gridPane.add(soutHBox,0,9,16,2);
        gridPane.add(table,0,1,16,9);

        scene = new Scene(gridPane,750,500);



 /*
          Dialog Window for create a new file;

  */
        dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        dialogOkButton = new Button("Ok");
        dialogCancleButton = new Button("Cancle");
        dialogFileTextField = new TextField();
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        HBox buttons = new HBox();
        buttons.setSpacing(75);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(dialogOkButton,dialogCancleButton);
        box.getChildren().addAll(new Label("Enter filename"),dialogFileTextField, buttons);
        Scene scene = new Scene(box);
        dialog.setScene(scene);


  /*
          Dialog Window for rename file
   */

        renameDialog = new Stage();
        renameDialog.initStyle(StageStyle.UTILITY);
        renameDialogOkButton = new Button("Ok");
        renameDialogCancleButton = new Button("Cancle");
        renameDialogFileTextField = new TextField();
        VBox renamebox = new VBox();
        renamebox.setAlignment(Pos.CENTER);
        HBox renamebuttons = new HBox();
        renamebuttons.setSpacing(75);
        renamebuttons.setAlignment(Pos.CENTER);
        renamebuttons.getChildren().addAll(renameDialogOkButton,renameDialogCancleButton);
        renamebox.getChildren().addAll(new Label("Enter new filename"),renameDialogFileTextField, renamebuttons);
        Scene renamescene = new Scene(renamebox);
        renameDialog.setScene(renamescene);

    }


    public void show(Stage primaryStage){
        primaryStage.setTitle("File Manager");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public TextField getPathText(){return pathText;}

    public Button getUpdateButton(){return updateButton;}

    public TableView getTableView(){return table;}

    public Button getDeleteButton() {
        return deleteButton;
    }

    public TableColumn getFilename() {
        return filename;
    }

    public Button getCreateButton(){return createButton;}

    public void showDialogWindow(){
        dialog.show();

    }

    public Button getDialogOkButton(){return dialogOkButton;}

    public Button getDialogCancleButton(){return dialogCancleButton;}

    public TextField getDialogFileTextField(){return dialogFileTextField;}

    public Stage getDialogWindow(){return dialog;}

    public Button getRenameButton(){return renameButton;}

    public Button getRenameDialogOkButton(){return renameDialogOkButton;}

    public Button getRenameDialogCancleButton(){return renameDialogCancleButton;}

    public Stage getRenameDialog(){ return renameDialog;}

    public TextField getRenameDialogFileTextField(){return renameDialogFileTextField;}
}

