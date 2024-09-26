package com.mocking.moc.util;

import java.io.FileInputStream;
import java.io.InputStream;

public class BookStoreDetails {
	

	private static BookStoreDetails instance = null; 
	
	private InputStream fis;
	
	private String fileLocation;
			
	private  BookStoreDetails(InputStream fis, String fileLocation) {
		this.fis = fis;
		this.fileLocation = fileLocation;
		System.out.println("File Location "+this.fileLocation);
	}
	
	public static BookStoreDetails getInstance(String fileLocation) throws Exception {
		if(instance == null) {
			return new BookStoreDetails(new FileInputStream(fileLocation), fileLocation);
		}
		return instance;
	}
	
	public InputStream getFis() {
		return fis;
	}
	
	public String getFileLocation() {
		return fileLocation;
	}	
}
