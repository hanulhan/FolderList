package com.hanulhan.consoleApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ser_folderList extends ArrayList<ser_folder> {

	private static final long serialVersionUID = 1L;

	public void setDateTimeFormat(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format); 
		for (int i = 0; i < size(); i++) {
			get(i).setStrCreated(sdf.format(get(i).getCreated()));
			if (get(i).getFolders() != null) {
			  for (int x = 0; x < get(i).getFolders().size(); x++) {
				  get(i).getFolders().setDateTimeFormat(format);
			  }
			}  
			if (get(i).getFiles() != null) {
				for (int x = 0; x < get(i).getFiles().size(); x++) {
					get(i).getFiles().get(x).setStrCreated(sdf.format(get(i).getFiles().get(x).getCreated()));
				}
			}
		}
		
	}

}
