package com.eas.utilities;

import java.io.BufferedReader;
import java.io.FileReader;

public class jsonReader {
	public String json_content = null, line;

	public String readJSONfile(String string) throws Exception {
		FileReader f_read = new FileReader("com.eas.payload" + string);
		BufferedReader b_read = new BufferedReader(f_read);
		while ((line = b_read.readLine()) != null) {
			json_content += line;
		}
		b_read.close();
		f_read.close();
		json_content = json_content.replaceAll("null", "");
		return json_content;
	}
}
