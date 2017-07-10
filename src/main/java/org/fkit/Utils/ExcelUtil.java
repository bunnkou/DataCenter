package org.fkit.Utils;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.fkit.domain.ItTask;

public class ExcelUtil {
	 public static Workbook createWorkBook(List<Map<String, String>> list, String[] keys, String[] columnNames, String[] Types) {
		    Workbook wb = new HSSFWorkbook();
		    Sheet sheet = wb.createSheet("Sheet1");
		    for (int i = 0; i < keys.length; i++) {
		      sheet.setColumnWidth((short) i, (short) (35.7 * 150));
		    }
		 
		    Row row = sheet.createRow((short) 0);
		 
		    CellStyle cs = wb.createCellStyle();
		    CellStyle cs2 = wb.createCellStyle();
		 
		    Font f = wb.createFont();
		    Font f2 = wb.createFont();
		 
		    f.setFontHeightInPoints((short) 10);
		    f.setColor(IndexedColors.BLACK.getIndex());
		    f.setBoldweight(Font.BOLDWEIGHT_BOLD);
		 
		    f2.setFontHeightInPoints((short) 10);
		    f2.setColor(IndexedColors.BLACK.getIndex());
		 
		    cs.setFont(f);
		    cs.setBorderLeft(CellStyle.BORDER_THIN);
		    cs.setBorderRight(CellStyle.BORDER_THIN);
		    cs.setBorderTop(CellStyle.BORDER_THIN);
		    cs.setBorderBottom(CellStyle.BORDER_THIN);
		    cs.setAlignment(CellStyle.ALIGN_CENTER);
		 
		    cs2.setFont(f2);
		    cs2.setBorderLeft(CellStyle.BORDER_THIN);
		    cs2.setBorderRight(CellStyle.BORDER_THIN);
		    cs2.setBorderTop(CellStyle.BORDER_THIN);
		    cs2.setBorderBottom(CellStyle.BORDER_THIN);
		    cs2.setAlignment(CellStyle.ALIGN_CENTER);

		    for (int i = 0; i < columnNames.length; i++) {
		      Cell cell = row.createCell(i);
		      cell.setCellValue(columnNames[i]);
		      cell.setCellStyle(cs);
		    }
		    
		    for (short i = 1; i < list.size(); i++) {
		      Row row1 = sheet.createRow(i);
		      for (short j = 0; j < keys.length; j++) {
		        Cell cell = row1.createCell(j);
		        if( Types[j].equals("int") ){
		        	cell.setCellValue( Double.parseDouble( list.get(i).get(keys[j]) ) );
		        }else{
		        	cell.setCellValue(list.get(i).get(keys[j]) == null ? " " : list.get(i).get(keys[j]) );
		        }
		        cell.setCellStyle(cs2);
		      }
		    }
		    
		    return wb;
		  }
	 
}
