package org.Data.Compare;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CallData {
	
	public static void main(String[] args) throws FileNotFoundException, IOException  {

        try {
            
            FileInputStream file1 = new FileInputStream("C:\\Users\\UTIS LAPTOP 54\\Eclispe_Worspace6-DataComparision\\ExcelComparision\\ExcelSheet\\Sheet1.xlsx");
            FileInputStream file2 = new FileInputStream("C:\\Users\\UTIS LAPTOP 54\\Eclispe_Worspace6-DataComparision\\ExcelComparision\\ExcelSheet\\Sheet2.xlsx");

            
            XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
            XSSFWorkbook workbook2 = new XSSFWorkbook(file2);

            
            XSSFSheet sheet1 = workbook1.getSheetAt(0);
            XSSFSheet sheet2 = workbook2.getSheetAt(0);

            
            Compare compare = new Compare();

            
            List<TestData> sht1 = compare.getcells(sheet1);

            
            List<TestData> sht2 = compare.getcells(sheet2);

            
            compare.compare(sht1, sht2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}



