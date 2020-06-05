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
            
            FileInputStream SourceFile = new FileInputStream("E:\\my workspace\\testdb\\CSVSample\\src\\SourceFile.xlsx");
            FileInputStream TargetFile = new FileInputStream("E:\\my workspace\\testdb\\CSVSample\\src\\TragetFile.xlsx");

            
            XSSFWorkbook workbook1 = new XSSFWorkbook(SourceFile);
            XSSFWorkbook workbook2 = new XSSFWorkbook(TargetFile);

            
            XSSFSheet Sourcedata = workbook1.getSheetAt(0);
            XSSFSheet Targetdata = workbook2.getSheetAt(0);

            
            Compare compare = new Compare();

            
            List<TestData> Sourcevalue = compare.getcells(Sourcedata);

            
            List<TestData> Targetvalue = compare.getcells(Targetdata);

            
            compare.compare(Sourcevalue, Targetvalue);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}



