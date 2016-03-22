package Libraries;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import Objects.PageObjects;

public class ReadExcel {

    private static HSSFWorkbook workbook;

	/**
     * @param args
     * @throws IOException 
     */
    public static HashMap<String,String>  getDataMap(String path, String recordName) throws IOException {
        // TODO Auto-generated method stub
       
        HashMap<String,String> dataMap = new HashMap<String,String>();
        //..
        try {
            
            FileInputStream file = new FileInputStream(new File(path));
             
            workbook = new HSSFWorkbook(file);
         
            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
             
            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            HSSFRow firstRow = sheet.getRow(0);
            
            int colCount = firstRow.getLastCellNum();
                                           
           while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                 
                HSSFCell cell = (HSSFCell) row.getCell(0);
                
                
                if(cell.toString().equalsIgnoreCase(recordName))
                {
                	for(int i = 0; i<colCount;i++)
                    {
                		String name = firstRow.getCell(i).toString();
                		String value = row.getCell(i).toString();
                		
                		dataMap.put(name, value);
                	}           	
                    // System.out.println(dataMap.toString());
                   
                }
              }
           //comment
               System.out.println("");
               file.close(); 
               return dataMap;
                        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }
    
  
}