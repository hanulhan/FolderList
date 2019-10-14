package com.hanulhan.consoleApp;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.json.annotations.JSON;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ser_folder {

    private String folderName;
    private Date created;
    private String strCreated;
    private boolean systemFolder;
    private ser_folderList folders;
    private ser_fileList files;

    public ser_folder(File aFile) {
        super();
        BasicFileAttributes attributes = null;
        try {
            attributes = Files.readAttributes(Paths.get(aFile.getPath()), BasicFileAttributes.class);
            this.created = new Date(attributes.creationTime().toMillis());

        } catch (IOException e) {
            System.out.println("oops error! " + e.getMessage());

        }
        this.folderName = aFile.getName();

    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @JSON(format = "yyyyMMddHHmmssZ")
    public Date getCreated() {
        return created;
    }

    @JSON(format = "yyyyMMddHHmmssZ")
    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isSystemFolder() {
        return systemFolder;
    }

    public void setSystemFolder(boolean systemFolder) {
        this.systemFolder = systemFolder;
    }

    public ser_folderList getFolders() {
        return folders;
    }

    public void ser_asset_folderList(ser_folderList folders) {
        this.folders = folders;
    }

    public void debugPrint(int level) {
        String s = "[";
        if (level > 0) {
            s = "[" + StringUtils.repeat(".", level);
        }
        s += folderName + "]";
        System.out.println(s);
        if (folders != null) {
            for (ser_folder f : folders) {
                f.debugPrint(level + 1);
            }
        }
    }

    @Override
    public String toString() {
        return "ser_asset_folder [folderName=" + folderName
                + ", created=" + created + ", systemFolder=" + systemFolder
                + ", folders=" + folders + "]";
    }

    public void setFolders(ser_folderList folders) {
        this.folders = folders;
    }

    public String getStrCreated() {
        return strCreated;
    }

    public void setStrCreated(String strCreated) {
        this.strCreated = strCreated;
    }

    public ser_fileList getFiles() {
        return files;
    }

    public void setFiles(ser_fileList files) {
        this.files = files;
    }

    public long getFolderSize() {
        long f = 0;
        if (folders != null) {
            for (ser_folder folder : folders) {
                f += folder.getFolderSize();
            }
        }

        if (files != null) {
            for (ser_file file : files) {
                f += file.getFileSize();
            }
        }
        return f;
    }

    public String getFolderSizeHumanReadable() {
        return FileUtils.byteCountToDisplaySize((long) getFolderSize());

    }

}
