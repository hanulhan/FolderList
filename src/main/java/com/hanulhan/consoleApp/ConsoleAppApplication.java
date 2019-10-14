package com.hanulhan.consoleApp;

import static java.lang.System.exit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleAppApplication implements CommandLineRunner{

    //@Autowired
    //private HelloMessageService helloService;
    
    @Autowired
    private FolderBean folder;
    
    public static void main(String[] args) {
        SpringApplication.run(ConsoleAppApplication.class, args);
    }
    // Put your logic here.

    @Override
    public void run(String... args) throws Exception {

        folder = new FolderBean();
        folder.listDir();
        exit(0);
    }

}
