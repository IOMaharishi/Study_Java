import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

/**
 * Created by illia on 08.12.14.
 */
public class Controller {

    File filelist[];

    private Model model;

    private View view;

    public boolean flag;

    public Controller(Model model) {
        this.model = model;
        this.view = new View();

        view.getUpdateButton().setOnAction(new Update_Button_Event());
        view.getDeleteButton().setOnAction(new Delete_Button_Event());
        view.getCreateButton().setOnAction(new Create_Button_Event());
        view.getDialogOkButton().setOnAction(new Dialog_Ok_Button_Event());
        view.getDialogCancleButton().setOnAction(new Dialog_Cancle_Button_Event());
        view.getRenameButton().setOnAction(new Rename_Button_Event());
        view.getRenameDialogOkButton().setOnAction(new Rename_Dialog_Ok_button_Event());
        view.getRenameDialogCancleButton().setOnAction(new Rename_Dialog_Cancle_button_Event());

    }

    public Model getModel() {
        return model;
    }


    public void show() {
        view.show(model.getStage());
    }


    public class Update_Button_Event implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent event) {

            updateTable();
        }



    }


    public class Delete_Button_Event implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            System.out.println(view.getTableView().getSelectionModel().getFocusedIndex());

            FileInfo fileInfo = (FileInfo)view.getTableView().getSelectionModel().getSelectedItem();
            File file = new File(fileInfo.getFullPath());
            System.out.println(fileInfo.getFullPath());

            if (file.exists()){
                System.out.println(file.delete());
                updateTable();
            }
            else System.out.println("File dont exist");
        }
    }

    public class Create_Button_Event implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           view.showDialogWindow();
        }
    }

    public class Dialog_Ok_Button_Event implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (!view.getDialogFileTextField().equals("")){


                File file = new File(view.getPathText().getText()+"/"+view.getDialogFileTextField().getText());
                try {

                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.err.println("Your textfiled is empty");
            }
            updateTable();
            view.getDialogWindow().close();
        }
    }

    public class Dialog_Cancle_Button_Event implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            view.getDialogWindow().close();
        }
    }

    public class Rename_Button_Event implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {

            view.getRenameDialog().show();
        }
    }

    public class Rename_Dialog_Ok_button_Event implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {

            FileInfo fileInfo = (FileInfo)view.getTableView().getSelectionModel().getSelectedItem();
            File file = new File(fileInfo.getFullPath());

            File newFile = new File(file.getParent(),view.getRenameDialogFileTextField().getText());

            try {
                Files.move(file.toPath(), newFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateTable();

        }
    }

    public class Rename_Dialog_Cancle_button_Event implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
        view.getRenameDialog().close();
            updateTable();

        }
    }

    public void updateTable() {
        File directory = new File(view.getPathText().getText());

        Model.files = FXCollections.observableArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println((directory.isDirectory()) ? "Directory" : "File");


        if (directory.isDirectory()) {
            filelist = directory.listFiles();

                 /*
                 Update File List
                  */

            for (int i = 0; i < filelist.length; i++) {
                if (filelist[i].isFile()) {
                    model.getList().addAll(new FileInfo(filelist[i].getName(), ((float) filelist[i].length() / (1024 * 1024)), (sdf.format(filelist[i].lastModified())).toString(), (filelist[i].getPath()).toString()));


                }

            }


        } else {
            System.out.println("You choose file, not directory");
        }

        view.getTableView().setItems(model.getList());
    }
}