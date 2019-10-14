package com.hanulhan.consoleApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ser_fileList extends ArrayList<ser_file> {

	private static final long serialVersionUID = 1L;

	public void setDateTimeFormat(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format); 
		for (int i = 0; i < size(); i++) {
			get(i).setStrCreated(sdf.format(get(i).getCreated()));
		}
	}

}
