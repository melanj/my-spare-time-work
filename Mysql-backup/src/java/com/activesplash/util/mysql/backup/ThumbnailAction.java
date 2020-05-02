package com.activesplash.util.mysql.backup;
/*
based on thumbnail.php (August ‎24, ‎2007)
Copyright 2007 Melan Nimesh <melanster@gmail.com>
 */

import com.opensymphony.xwork2.ActionSupport;
import java.awt.Graphics2D;
import java.io.File;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

public class ThumbnailAction extends ActionSupport {

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

        int width = 128;
        int height = 96;

        double width_orig;
        double height_orig;
        double ratio_orig;

        BufferedImage originalImage = ImageIO.read(new File("D:\\bb\\images\\" + getFileName()));

        width_orig = (double)originalImage.getWidth();
        height_orig =(double) originalImage.getHeight();

        ratio_orig = width_orig / height_orig;

        if (((double) (width / height) > ratio_orig))
            width = (int) Math.ceil(height * ratio_orig);
         else 
            height = (int) Math.ceil(width / ratio_orig);

        BufferedImage thumbnail = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = thumbnail.createGraphics();
        graphics.drawImage(originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, width, height, null);
        graphics.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(thumbnail, "jpg", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        fileInputStream = new ByteArrayInputStream(imageInByte);

        return SUCCESS;
    }
}
