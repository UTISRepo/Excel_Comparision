package org.Data.Compare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.*;

public class newcompare {

    XSSFRow row1;

    public List<TestData> getcells(XSSFSheet Data) {
        row1 = Data.getRow(0);

        List<TestData> sht = new ArrayList<TestData>();

        int lastRow = Data.getLastRowNum();

        for (int i = 0; i <= lastRow; i++) {

            row1 = Data.getRow(i);

            TestData testData = new TestData();

            int cell = 0;
            XSSFCell cell1 = row1.getCell(cell);
            XSSFCell cell2 = row1.getCell(cell + 1);
            XSSFCell cell3 = row1.getCell(cell + 2);
            XSSFCell cell4 = row1.getCell(cell + 3);

            /*
             * int type = cell4.getCellType(); if(type==1) { String name =
             * cell4.getStringCellValue();
             * 
             * } if(type==0) { if(DateUtil.isCellDateFormatted(cell4)) { new
             * SimpleDateFormat("dd-mm-yyy").format(cell4.getDateCellValue()); } else {
             * String name = String.valueOf((long) cell4.getNumericCellValue()); } }
             */

            testData.setID(String.valueOf(cell1));
            testData.setName(String.valueOf(cell2));
            ;
            testData.setAge(String.valueOf(cell3));
            testData.setGender(String.valueOf(cell4));
            ;

            testData.setRowNumber(i + 1);

            if ((cell1.getCellType() == XSSFCell.CELL_TYPE_BLANK) && (cell2.getCellType() == XSSFCell.CELL_TYPE_BLANK)
                    && (cell3.getCellType() == XSSFCell.CELL_TYPE_BLANK)
                    && (cell4.getCellType() == XSSFCell.CELL_TYPE_BLANK)) {
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

    public void compare(List<TestData> Sourcevalue, List<TestData> Targetvalue) throws IOException {
        
        String Name = null;
        String Age= null;
        String Id = null;
        String Gender= null;
        Integer x = 1;
        Integer y = 1;
        Map < String, Object[] > compareData1 = new TreeMap < String, Object[] >();
        Map < String, Object[] > compareData2 = new TreeMap < String, Object[] >();
        compareData1.put( x.toString(), new Object[] {
            "Primary Column Value", "Source Column Name", "Source Column Value" , "Target Column Name", "Target Column Value", "Status"});
            compareData2.put( y.toString(), new Object[] {
                "Primary Column Value", "Status"});
        for(TestData Sourcedata: Sourcevalue) {
            
            //Name= sheet1.getName();
            Id = Sourcedata.getID();
            
            
            for (TestData Targetdata: Targetvalue) 
            {               
                
                    if (Sourcedata.getID().equals(Targetdata.getID()))
                    {
                    //  Id = Sourcedata.getID(); 
                      Id = null;

                       // if (sheet1.getAge().equals(sheet2.getAge())) {
                      if (!Sourcedata.getName().equals(Targetdata.getName()))
                    {
                        Name = Sourcedata.getName(); 
                        //  Name = null;
                    }

                            if(!Sourcedata.getAge().equals(Targetdata.getAge()))
                            {
                                Gender = Sourcedata.getGender(); 
                            }
                            if(!Sourcedata.getGender().equals(Targetdata.getGender()))
                            {
                                Age = Sourcedata.getAge(); 
                            }

                            if((Sourcedata.getName().equals(Targetdata.getName())) && (Sourcedata.getGender().equals(Targetdata.getGender())) && (Sourcedata.getAge().equals(Targetdata.getAge())))
                            {
                               // System.out.println("ID:" + (Sourcedata.getID()) + " of Source file is equal to ID: " + (Targetdata.getID()) + " of Target file");
                               
                                Name=null;
                                Age = null;
                                Gender= null;
                               
                             //break;
                            }
                           
                            
                            if ( Name!= null) {
                                x++;
                                //System.out.println("######");
                                //System.out.println("For ID:  " + Sourcedata.getID() + " Name (" + Sourcedata.getName() + ") Mismatch in Target");
                                //System.out.println("Updated Name is: "+Targetdata.getName());
                                //System.out.println("######");
                                compareData1.put( x.toString(), new Object[] {
                                    Sourcedata.getID().toString(), "Name", Sourcedata.getName() , "Name", Targetdata.getName(), "Data Mismatch"});
                                Gender = null;
                                Age = null;

                            }

                            if (Age != null) {
                                x++;
                             //   System.out.println("---------");
                               // System.out.println("For ID:  " + Sourcedata.getID() + " Age (" + Sourcedata.getAge() + ") Mismatch in Target");
                              //  System.out.println("Age has changed under name (" + Sourcedata.getName() + ") and gender (" + Sourcedata.getGender() + ") at ID: " + (Sourcedata.getID()));
                                //System.out.println("Updated age is: "+Targetdata.getAge());
                               // System.out.println("---------");
                                compareData1.put( x.toString(), new Object[] {
                                    Sourcedata.getID().toString(), "Age", Sourcedata.getAge().toString() , "Age", Targetdata.getAge().toString(), "Data Mismatch"});

                            }

                            
                            if (Gender != null) {
                                x++;
                              //  System.out.println("---------");
                               // System.out.println("For ID:  " + Sourcedata.getID() + " Gender (" + Sourcedata.getGender() + ") Mismatch in Target");
                               // System.out.println("Gender has changed under name (" + Sourcedata.getName() + ") and ID: " + (Sourcedata.getID()));
                               // System.out.println("Updated Gender is: "+Targetdata.getGender());
                               // System.out.println("---------");
                                compareData1.put( x.toString(), new Object[] {
                                    Sourcedata.getID(), "Gender", Sourcedata.getGender() , "Gender", Targetdata.getGender(), "Data Mismatch"});

                            }
                            
                      }
                    
          }
        
             if (Id != null) {
                y++;
               //  System.out.println("*****");
                // System.out.println("New Id name (" + Sourcedata.getName() + ")  listed at ID: " + (Sourcedata.getID()) );
                // System.out.println("ID: " +Sourcedata.getID() + " Not Available in Target ");
                // System.out.println("Name has changed under (" + Sourcedata.getName() + ") and ID: " + (Sourcedata.getID()));
               //  System.out.println("Updated name is: "+Targetvalue.);
                // System.out.println("*****");
                 compareData2.put( y.toString(), new Object[] {
                    Sourcedata.getID().toString(), "Row not found in target"});
                

             }

            
          
        }
      

         //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      
      //Create a blank sheet
      XSSFSheet spreadsheet1 = workbook.createSheet( " Sheet 1 ");
      XSSFSheet spreadsheet2 = workbook.createSheet( " Sheet 2 ");

      //Create row object
      XSSFRow row;

       //Iterate over data and write to sheet
       Set < String > keyid1 = compareData1.keySet();
       int rowid = 0;
       
       for (String key : keyid1) {
          row = spreadsheet1.createRow(rowid++);
          Object [] objectArr = compareData1.get(key);
          int cellid = 0;
          
          for (Object obj : objectArr){
             Cell cell = row.createCell(cellid++);
             cell.setCellValue((String)obj);
          }
       }

        //Iterate over data and write to sheet
        Set < String > keyid2 = compareData2.keySet();
         rowid = 0;
        
        for (String key : keyid2) {
           row = spreadsheet2.createRow(rowid++);
           Object [] objectArr = compareData2.get(key);
           int cellid = 0;
           
           for (Object obj : objectArr){
              Cell cell = row.createCell(cellid++);
              cell.setCellValue((String)obj);
           }
        }

         //Write the workbook in file system
      FileOutputStream out = new FileOutputStream( new File("E:\\my workspace\\testdb\\CSVSample\\src\\OutputFile.xlsx"));
     
     workbook.write(out);
    }
        
}
