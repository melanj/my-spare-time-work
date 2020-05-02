package com.activesplash.util.mysql.backup;
//byte[] buffer = ((DataBufferByte)(bufferedImage).getRaster().getDataBuffer()).getData();

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {

   private InputStream fileInputStream;
   private String type;


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
         }

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

        @Override
	public String execute() throws Exception {
	    fileInputStream = new FileInputStream(new File("D:\\bb\\test." + getType()));
	    return SUCCESS;
	}

        public String gz() throws Exception {
	    fileInputStream = new FileInputStream(new File("D:\\bb\\test.gz"));
	    return SUCCESS;
	}

        public String zip() throws Exception {
	    fileInputStream = new FileInputStream(new File("D:\\bb\\test.zip"));
	    return SUCCESS;
	}

        public String sql() throws Exception {

	    fileInputStream = new FileInputStream(new File("D:\\bb\\test.sql"));
	    return SUCCESS;
	}
}