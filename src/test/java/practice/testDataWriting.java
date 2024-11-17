package practice;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class testDataWriting {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("generatedData");

        XSSFRow row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("id");
            row1.createCell(1).setCellValue("name");
            row1.createCell(2).setCellValue("address");

        XSSFRow row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue(1);
            row2.createCell(1).setCellValue("ahmed");
            row2.createCell(2).setCellValue("alexandria");


        XSSFRow row3 = sheet.createRow(3);
            row2.createCell(0).setCellValue(1);
            row2.createCell(1).setCellValue("MINA");
            row2.createCell(2).setCellValue("CAIRO");

       FileOutputStream file = new FileOutputStream("C:\\Users\\Ahmed Elgebali\\Master-Automation\\testData\\myfile.xlsx");
        workbook.write(file);
        workbook.close();
        file.close();
    }
}
