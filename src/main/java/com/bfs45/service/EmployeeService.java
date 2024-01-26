package com.bfs45.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.bfs45.dao.EmployeeDao;
import com.bfs45.model.Employee;

public class EmployeeService {
	
	EmployeeDao empDao;
	
	public void readFromExcel(File file) throws EncryptedDocumentException, IOException, ClassNotFoundException, SQLException {
		FileInputStream fis=null;
		if(file.getName().contains("employee")){
			 fis=new FileInputStream(file);
			 
			 Workbook wbook=WorkbookFactory.create(fis);
		Sheet sheet=	 wbook.getSheet("employee");
		 String rowFields = "";
		 empDao=new EmployeeDao();
		for(Row row:sheet) {
			if(row.getRowNum()!=0) {
				
				Employee emp=new Employee((int)row.getCell(0).getNumericCellValue(), 
						String.valueOf(row.getCell(1)),
						String.valueOf(row.getCell(3)),
						(int)row.getCell(2).getNumericCellValue());
				empDao.saveEmployees(emp);
			}
		}
			 
		}
		
		
	}
	
	
	


}
