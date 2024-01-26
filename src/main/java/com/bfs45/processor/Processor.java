package com.bfs45.processor;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;

import com.bfs45.service.EmployeeService;

public class Processor {
	
	public static void main(String[] args) {
		EmployeeService empservice=new EmployeeService();
		File file=new File("D:\\BFS45_workspace\\employee.xlsx");
		try {
			empservice.readFromExcel(file);
			
		} catch (EncryptedDocumentException | IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
		} catch (SQLException e) {
			
		}
	}

}
