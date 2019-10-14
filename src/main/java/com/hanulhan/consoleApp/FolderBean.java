/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanulhan.consoleApp;

import java.io.File;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author uli
 */

@Component
public class FolderBean {

    private String rootFolder;
    private static final Logger LOGGER = LogManager.getLogger(FolderBean.class);
    private File f;
    
    public FolderBean(String aRootFolder) {
        rootFolder= aRootFolder;
        f= new File(rootFolder);
    }

    public void listDir()   {
        File[] files= f.listFiles();
        if (files != null) {
            for (int i=0; i< files.length; i++) {
                if (files[i].isFile())  {
                    LOGGER.debug(files[i].getName() + ", " + files[i].length());
                   
                } else if (files[i].isDirectory())  {
                    LOGGER.debug(files[i].getName() + "d");
                }
            }
        }
        
    }


    ser_folder getFolders(Long parentFolder)    {
        
        ser_folder myFolder = new ser_folder();
        ser_file ser_tempFile;
        File[] files= f.listFiles();
        if (files != null) {
            for (File tempFile : files) {
                if (tempFile.isFile())  {
                    ser_tempFile= new ser_file(tempFile);
                    if (myFolder.getFiles() == null)    {
                        ser_fileList ser_fileList = new ser_fileList();
                    }
                    myFolder.setFiles(files);
                } else {
                    
                }
            }
        }
        for 
        /*
        for (File folder : getAssetFolders()) {
            long idparent = 0;
            long searchParent = 0;
            if ((parentFolder != null) && (parentFolder > 0)) {
                searchParent = parentFolder;
            }
            if (folder.getAssetFolders() != null) {
                idparent = folder.getAssetFolders().getId();
            }
            if (idparent == searchParent) {
                ser_folder f = new ser_folder(folder);
                f.setFolders(getFolders(folder.getId()));
                r.add(f);
                for (entityAssetFile afile : folder.getAssetFiles()) {
                    if (f.getFiles() == null) {
                        f.setFiles(new ser_fileList());
                    }
                    ser_file newFile = new ser_file(afile);
                    f.getFiles().add(newFile);
                }
            }

        }
        if (r.size() > 0) {
            return r;
        }
        */
    }
}
