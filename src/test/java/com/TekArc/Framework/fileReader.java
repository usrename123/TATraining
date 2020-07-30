package com.TekArc.Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class fileReader {
	public static void main(String[] args) throws FileNotFoundException {
        Properties prop= new Properties();
		FileInputStream ip= new FileInputStream("C:\\TecArcTrainning\\TAGitHubTraining\\Aruna_Bindra\\Assignments\\SeleniumFrameworkAssignment\\src\\main\\java\\com\\TekArc\\Framework\\Configrations\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("ExcelDataFileName"));

	}
    
    
}
