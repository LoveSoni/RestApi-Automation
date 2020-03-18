package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
        public Object[][] getExcelData(){
                FileInputStream fileInputStream = null;
                XSSFWorkbook xssfWorkbook = null;
                try {
                       fileInputStream = new FileInputStream("/Users/love/Documents/Projects/RestApiAutomation/testData.xlsx");
                }catch (FileNotFoundException f)
                { f.printStackTrace();
                }
                try {
                         xssfWorkbook = new XSSFWorkbook(fileInputStream);
                }catch (IOException e)
                {
                        e.printStackTrace();
                }
                XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");
                Object[][] obj = new Object[xssfSheet.getLastRowNum()][xssfSheet.getRow(1).getLastCellNum()];
                for(int i=0;i<xssfSheet.getLastRowNum();i++){
                        for(int j=0;j<xssfSheet.getRow(1).getLastCellNum();j++)
                        { obj[i][j]= xssfSheet.getRow(i+1).getCell(j).getStringCellValue();
                        }
                }
        return obj;
        }
}
