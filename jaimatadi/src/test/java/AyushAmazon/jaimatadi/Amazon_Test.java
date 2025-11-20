package AyushAmazon.jaimatadi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Amazon_Test { 
	//ArrayList<String> list; 
	static WebDriver driver;   // SAME DRIVER in all rows
    static boolean isBrowserOpened = false;

    @Test(dataProvider = "excel")
    public void test1(String data1, String data2, String action) throws Exception {

        if (!isBrowserOpened) {
            driver = new ChromeDriver();
            isBrowserOpened = true;
        }

        switch (action.toUpperCase()) {

            case "URL":
                driver.get(data1);
                break;

            case "LOGIN":
                Login login = new Login(driver);
                HomePage hp = new HomePage(driver);

                login.loginClick();
                login.fillEmail(data1);
                login.pass(data2);

                hp.logo();
                hp.navigationBar();
                hp.footer();
                hp.language();
                break;

            case "PRODUCT":
                ProductResult p = new ProductResult(driver);
                p.searchProduct(data1);
                p.clickProduct();  
                break;

            default:
                System.out.println("Unknown action: " + action);
	 
	 }
		
		 
		
	
		}
		
			

		
		  
		  
		  // hp.promotional(); hp.returnAndOrders();
		  
		 
	  
		  //hp.deliver();
		  
		  
		  
		  
	
		 

	

	
	@DataProvider(name = "excel")
	public Object[][] m1() throws Exception {

	    FileInputStream f1 = new FileInputStream("D:\\Book1.xlsx");
	    Workbook wb = WorkbookFactory.create(f1);
	    Sheet sh = wb.getSheet("Sheet1");

	    int lastRow = sh.getLastRowNum();   
	    Object[][] data = new Object[lastRow][3];

	    for (int i = 1; i <= lastRow; i++) {

	        Row row = sh.getRow(i);
	        if (row == null) continue;

	        
	        Cell cell = row.getCell(row.getLastCellNum() - 2);
	        if (cell == null) continue;

	        String value = cell.toString().trim();
	        if (value.equalsIgnoreCase("N/A")) continue;

	        String[] arr = value.split("\\s+");
	        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

	        
	        data[i - 1][0] = list.size() > 0 ? list.get(0) : "";

	        
	        data[i - 1][1] = list.size() > 1 ? list.get(1) : "";

	       
	        Cell cell2 = row.getCell(row.getLastCellNum() - 1);
	        String cell2Value = (cell2 == null) ? "" : cell2.toString().trim();

	        data[i - 1][2] = cell2Value;

	        System.out.println(
	            "Row " + i + " => " +
	            data[i - 1][0] + " | " +
	            data[i - 1][1] + " | " +
	            data[i - 1][2]
	        );
	    }

	    wb.close();
	    f1.close();
	    return data;
	}




}
