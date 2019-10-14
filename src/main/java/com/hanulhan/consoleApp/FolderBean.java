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

    static private String rootFolder= "/home/uli";
    private static final Logger LOGGER = LogManager.getLogger(FolderBean.class);
    private File f;
    
    public FolderBean() {
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
    
}
