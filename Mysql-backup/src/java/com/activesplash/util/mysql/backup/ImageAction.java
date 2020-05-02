package com.activesplash.util.mysql.backup;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ImageAction extends ActionSupport {

    private InputStream fileInputStream;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    @Override
    public String execute() throws Exception {
        fileInputStream = new FileInputStream(new File("D:\\bb\\images\\" + getFileName()));
        return SUCCESS;
    }
}
