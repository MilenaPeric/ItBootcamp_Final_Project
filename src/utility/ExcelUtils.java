  package utility;
import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import org.apache.poi.hssf.usermodel.HSSFCell;
	import org.apache.poi.hssf.usermodel.HSSFRow;
	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	
	public class ExcelUtils {
		
		
		
		private static HSSFWorkbook wb;
		private static HSSFSheet sheet;
		private static FileInputStream fi;
		private static String excellPath;
		
		
		public static void findExcellSheet() {
			try {
				fi = new FileInputStream("C:\\Users\\hp-840g1\\Documents\\Downloads\\Book.xls");
				wb = new HSSFWorkbook(fi);
				sheet = wb.getSheetAt(0);
			} catch (IOException e) {
				System.out.print("Ne nalazi excel");
				e.printStackTrace();
			}
		}
		public static boolean setExcell(String path) {
			if (wb != null) {
				try {
					wb.close();
				} catch (Exception e) {
					System.out.println(e.toString());
					return false;
				}
			}
			File f= new File(path);
			try {
				FileInputStream fis= new FileInputStream(f);
				
				wb=new HSSFWorkbook(fis);
				excellPath=path;
				return true;
			}catch(Exception e) {
				System.out.println(e.toString());
				System.out.println("Lose otvaranje fajla!");
				return false;
			}
		}
		public static boolean setWorkSheet(int index) {
			try {
				sheet=wb.getSheetAt(index);
				return true;
			}catch(Exception e) {
				System.out.println(e.toString());
				System.out.println("Lose otvaranje worksheeta!");
				return false;
			}
		}
		public static boolean setWorkSheet(String name) {
			try {
				sheet=wb.getSheet(name);
				return true;
			}catch(Exception e) {
				System.out.println(e.toString());
				System.out.println("Lose otvaranje worksheeta!");
				return false;
			}
		}
		public static String getDataAt(int row,int column) {
			try {
			HSSFRow r= sheet.getRow(row);
			HSSFCell celija=r.getCell(column);
			return celija.toString();
			}catch(NullPointerException e) {
				System.out.println(e.toString());
				System.out.println("Nesto je null!");
			}catch(Exception e) {
				System.out.println(e.toString());
				System.out.println("Doslo je do greske!");
			}
			return "";
		}
		public static boolean setDataAt(int row,int column,String data) {
			try{
				HSSFRow r= sheet.getRow(row);
				if(r==null) {
					r=sheet.createRow(row);
				}
				HSSFCell cell=r.getCell(column);
				if(cell==null) {
					cell=r.createCell(column);
				}
				cell.setCellValue(data);
				FileOutputStream fos= new FileOutputStream(excellPath);
				wb.write(fos);
				return true;
			}catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("Doslo je do greske!");
				return false;
			}
		}
		public static int getRowNumber() {
			try {
				return sheet.getLastRowNum()+1;
			}catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("Doslo je do greske!");
				return -1;
			}
		}
		public static boolean closeExcell() {
			if(wb!=null) {
				try {
					wb.close();
					wb=null;
					return true;
				} catch (IOException e) {
					e.printStackTrace();
					wb=null;
					return false;
				}
				
			}
			return true;
		}
		
	}