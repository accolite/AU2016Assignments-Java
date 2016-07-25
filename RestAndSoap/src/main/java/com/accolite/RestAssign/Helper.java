package com.accolite.RestAssign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.json.*;

public class Helper {
	public String readFile(File file) {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			while ((line = reader.readLine()) != null)
				stringBuilder.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public void saveFile(Object obj, File file) {
		// TODO Auto-generated method stub
		FileWriter fs = null;
		try {
			fs = new FileWriter(file, false);
			fs.write(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String readIncomingStream(InputStream incomingData) {
		// TODO Auto-generated method stub
		BufferedReader reader = null;;
		try {
			reader = new BufferedReader(new InputStreamReader(incomingData));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			while ((line = reader.readLine()) != null) 
				stringBuilder.append(line);
			}catch(Exception e){
				e.printStackTrace();
			}
		return stringBuilder.toString();
	}

	public JSONObject extractJSONObject(String jsonString) {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new JSONObject(jsonString);
		return jsonObject;
	}

	public JSONObject getJSONObjectFromFile(File file) {
		// TODO Auto-generated method stub
		JSONObject jsonObject = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			try {
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
				}

				String jsonString = stringBuilder.toString();
				jsonObject = extractJSONObject(jsonString);
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}
