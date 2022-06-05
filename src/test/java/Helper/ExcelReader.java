//package Helper;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelReader {
//
//    public static String excelReader(String fileLocation, int sheetNum, int rowNum, int colNum) throws IOException {
//        FileInputStream fis = new FileInputStream(new File(fileLocation));
//        HSSFWorkbook wb = new HSSFWorkbook(fis);
//        HSSFSheet sheet = wb.getSheetAt(sheetNum-1);
//        HSSFRow row = sheet.getRow(rowNum-1);
//        HSSFCell cell = row.getCell(colNum-1);
//        return cell.getStringCellValue();
//    }
//}