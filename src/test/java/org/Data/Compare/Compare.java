package org.Data.Compare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.*;


public class Compare {

	XSSFRow row1;
	
	public List<TestData> getcells(XSSFSheet Data ){
		row1 = Data.getRow(0);

       
        List<TestData> sht = new ArrayList<TestData>();

        int lastRow = Data.getLastRowNum();

        for (int i = 0; i <= lastRow; i++) {

            row1 = Data.getRow(i);

           TestData testData = new TestData();
          
           int cell=0;
           XSSFCell cell1 = row1.getCell(cell);
           XSSFCell cell2 = row1.getCell(cell + 1);
           XSSFCell cell3 = row1.getCell(cell + 2);
           XSSFCell cell4 = row1.getCell(cell + 3);
           
           /*int type = cell4.getCellType();
           if(type==1) {
        	   String name = cell4.getStringCellValue();
        	  
           }
           if(type==0) {
        	   if(DateUtil.isCellDateFormatted(cell4)) {
        		   new SimpleDateFormat("dd-mm-yyy").format(cell4.getDateCellValue());
        	   }
        	   else {
        		   String name = String.valueOf((long) cell4.getNumericCellValue());
        	   }
           }*/
           
           testData.setID(String.valueOf(cell1));
           testData.setName(String.valueOf(cell2));;
           testData.setAge(String.valueOf(cell3));
           testData.setGender(String.valueOf(cell4));;
           
           testData.setRowNumber(i + 1);

           if ((cell1.getCellType() == XSSFCell.CELL_TYPE_BLANK) && (cell2.getCellType() == XSSFCell.CELL_TYPE_BLANK) && (cell3.getCellType() == XSSFCell.CELL_TYPE_BLANK) &&
                   (cell4.getCellType() == XSSFCell.CELL_TYPE_BLANK) )
           {
               break;
           }
		sht.add(testData);
	}
        System.out.println("*****Sheet*****");
        for (TestData val : sht) {

        	System.out.print("\t" + val.getID());
             System.out.print("\t" + val.getName());
            System.out.print("\t" + val.getAge());
            System.out.print("\t" + val.getGender());
            

            System.out.println("");
}
        return sht;
	}
	
	
	public void compare(List<TestData> sht1, List<TestData> sht2){
		
		String Name = null;
		String Age= null;
        String Id = null;
        String Gender= null;
        
		
        for(TestData sheet1: sht1) {
        	
        	Name= sheet1.getName();
        	Id = sheet1.getID();
        	
        	
        	for (TestData sheet2: sht2) {
        		
        		if (sheet1.getName().equals(sheet2.getName())) {

                    Name = null;

                    if (sheet1.getID().equals(sheet2.getID())) {

                        Id = null;

                       // if (sheet1.getAge().equals(sheet2.getAge())) {
                        	

                            if(!sheet1.getAge().equals(sheet2.getAge())){
                            	Gender = sheet1.getGender(); 
                            }
                            if(!sheet1.getGender().equals(sheet2.getGender())){
                            	Age = sheet1.getAge(); 
                            }

                            if( (sheet1.getName().equals(sheet2.getName())) && (sheet1.getGender().equals(sheet2.getGender())) && (sheet1.getAge().equals(sheet2.getAge()))){
                                System.out.println("Row No." + (sheet1.getRowNumber()) + " of Sheet 1 is equal to Row No." + (sheet2.getRowNumber()) + " of Sheet 2");
                                Age = null;
                                Gender= null;
                               
                                break;
        		
                            }
                        }
                   // }
                     
        		
        		
        	}
        	
        	
        }
		
        	if (Id != null) {
                System.out.println("*****");
                System.out.println("New Id name (" + sheet1.getName() + ")  listed at Row No." + (sheet1.getRowNumber()));
                System.out.println("*****");
                                

            }

            
            if ( Name!= null) {
                System.out.println("######");
                System.out.println("New name (" + sheet1.getID() + ") listed under name (" + sheet1.getName() + ") at Row No." + (sheet1.getRowNumber()));
                System.out.println("######");
                Gender = null;
                Age = null;

            }

            
            if (Age != null) {
                System.out.println("---------");
                System.out.println("Age has changed under name (" + sheet1.getName() + ") and gender (" + sheet1.getGender() + ") at Row No." + (sheet1.getRowNumber()));
                System.out.println("Updated age is: "+sheet1.getAge());
                System.out.println("---------");

            }

            
            if (Gender != null) {
                System.out.println("---------");
                System.out.println("Gender has changed under name (" + sheet1.getName() + ") and id (" + sheet1.getID() + ") at Row No." + (sheet1.getRowNumber()));
                System.out.println("Updated Gender is: "+sheet1.getGender());
                System.out.println("---------");

            }
        }
    }
		
}
	

        		
