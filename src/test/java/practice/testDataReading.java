package practice;

import com.google.j2objc.annotations.WeakOuter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testDataReading {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\Ahmed Elgebali\\Master-Automation\\testData\\testDataSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("sheet1");
        int totalRowNum = sheet.getLastRowNum();
        int totalCellNum = sheet.getRow(0).getLastCellNum();

//        System.out.println("rows numbers: "+totalRowNum +"\n cells numbers:  "+ totalCellNum);

        for (int r=0; r <=totalRowNum; r++){
            XSSFRow currentRow = sheet.getRow(r);
            for (int c=0; c<totalCellNum; c++){
                XSSFCell currentCell = currentRow.getCell(c);
                System.out.print(currentCell.toString()+"\t");

            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }

}
