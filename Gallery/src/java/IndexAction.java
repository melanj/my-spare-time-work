
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IndexAction extends ActionSupport {

    List<String> fileList = new ArrayList<String>();

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public List<String> getFileList() {
        return this.fileList;
    }

    @Override
    public String execute() throws Exception {
        File folder = new File("/media/Dev/AppData/");
        File[] listOfFiles = folder.listFiles();
        List<String> files = new ArrayList<String>();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile())
                files.add( listOfFiles[i].getName());
        }
        
        setFileList(files);
        return SUCCESS;
    }
}
