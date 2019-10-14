package com.hanulhan.consoleApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.json.annotations.JSON;


public class ser_file {
	private String fileName;
	private Date created;
	private String strCreated;
	private String contentType;
	private long fileSize;
	
        @SuppressWarnings("unused")
	private String fileSizeHumanReadable;
	private String saveExtention;
	
	public ser_file(File  aFile) {
            super();
            BasicFileAttributes attributes = null;
            try {
                attributes = Files.readAttributes(Paths.get(aFile.getPath()), BasicFileAttributes.class);
                this.created = new Date(attributes.creationTime().toMillis());

            } catch (IOException e) {
                System.out.println("oops error! " + e.getMessage());

            }
            this.fileName = aFile.getName();
	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@JSON(format="yyyyMMddHHmmssZ")
	public Date getCreated() {
		return created;
	}
	
	@JSON(format="yyyyMMddHHmmssZ")
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getStrCreated() {
		return strCreated;
	}
	public void setStrCreated(String strCreated) {
		this.strCreated = strCreated;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


	@Override
	public String toString() {
		return "ser_file [fileName=" + fileName
				+ ", created=" + created + ", fileSize=" + fileSize + "]";
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public String getFileSizeHumanReadable() {
		return FileUtils.byteCountToDisplaySize(fileSize);
	}


	public String getSaveExtention() {
		return saveExtention;
	}


	public void setSaveExtention(String saveExtention) {
		this.saveExtention = saveExtention;
	}
	
}
