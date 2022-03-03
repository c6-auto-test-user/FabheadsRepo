package com.c6.DataDriven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataDrivenClass 
{
	
@DataProvider(name="testdata")
private static Iterator<Object[]> getUserDetails() {

	ReadExcelFile rf = new ReadExcelFile();
	int rows = rf.getRowCount(0);

	List<Data_pojo> testList = new ArrayList<Data_pojo>();
    for(int i=0;i<rows;i++) {
	    	
	Data_pojo user = new Data_pojo();

	user.setDetails1(rf.getData(0, i, 0));   // (sheet,rows,column)
	user.setDetails2(rf.getData(0, i, 1));  
	user.setNumber1(rf.getData(0, i, 2));  
	user.setNumber2(rf.getData(0, i, 3));  
	
	testList.add(user);
 }
	
    Collection<Object[]> dp = new ArrayList<Object[]>();
	for(Data_pojo userDetails : testList){
	   dp.add(new Object[] {userDetails});
	}
	   return dp.iterator();
}

/*	
	@DataProvider(name="testdata")
	public Object[][] testDataExample(){

	ReadExcelFile configuration = new ReadExcelFile(".\\TestData\\DDTConcept_Data.xlsx");
	int rows = configuration.getRowCount(0);
	Object[][] signin_credentials = new Object[rows][2];

	for(int i=0;i<rows;i++)
	{
	signin_credentials[i][0] = configuration.getData(0, i, 0);    // (sheetnumber, row, column)
	signin_credentials[i][1] = configuration.getData(0, i, 1);
	}
	return signin_credentials;
	}
*/
	
}
