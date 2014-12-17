import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by illia on 10.12.14.
 */
public class FileInfo {

    private FloatProperty filesize;
    private StringProperty fileName;
    private StringProperty type;
    private StringProperty lastModify;

    private String fullPath;
    public FileInfo( String Name, float size,String lastModify, String fullPath){

        this.fileName = new SimpleStringProperty(Name);
        this.filesize = new SimpleFloatProperty(size);
//        this.type = new SimpleStringProperty(type);
        this.lastModify = new SimpleStringProperty(lastModify);
        this.fullPath = fullPath;

    }

    public String getFileName(){return fileName.getValue();}

    public String getType(){return type.getValue();}

    public float getFilesize() {
        return filesize.getValue();
    }

    public String getLastModify(){return lastModify.getValue();}

    public StringProperty getLastModifyProperty() {
        return lastModify;
    }

    public StringProperty getFileProperty(){return fileName;}

    public FloatProperty getFileSizeProperty(){return filesize;}

    public StringProperty getFileTypeProperty(){return type;}

    public String getFullPath(){
        return(fullPath);
    }

}
