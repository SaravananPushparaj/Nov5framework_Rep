package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class Testdataprovider {
	
	
	@DataProvider(name="dp_Invalidsearch")
	public static Iterator<Object[]> getInvalidserachdata() throws IOException
	{
		
		return commontestdata("Scenario_Search","Invalid_Search");
		
	}
	
	@DataProvider(name="dp_Validsearch")
	public static Iterator<Object[]> getValidserachdata() throws IOException
	{
		
		return commontestdata("Scenario_Search","Valid_Search");
		
	}
	
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<Object[]> getAddCartdata() throws IOException
	{
		
		return commontestdata("Scenario_Cart","Add_Cart");
		
	}
	
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<Object[]> getDeletCartdata() throws IOException
	{
		
		return commontestdata("Scenario_Cart","Delete_Cart");
		
	}
	
	
	public static Iterator<Object[]> commontestdata(String sheetname,String scriptname) throws IOException
	{
		
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Nov5proj_Framework\\TestData\\Test_Data.xls");
		HSSFSheet Sheet = xl.Setsheet(sheetname);
		
		int RowCount = xl.getrowcount(Sheet);
		int ColCount = xl.getcolcount(Sheet, 0);
		
		
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			
			String Execute_Flag = xl.Readvalue(Sheet, i, "Execute_Flag");
			String Script_name = xl.Readvalue(Sheet, i, "Script_name");
			
			if((Execute_Flag.equalsIgnoreCase("Y")) &&(Script_name.equals(scriptname)))
			{
			
				Object[] x= new Object[1];
				Map<String,String> dMap= new HashMap<String,String>();
				
				for(int j=0;j<ColCount;j++)
				{
					String Skey = xl.Readvalue(Sheet, 0, j);
					String Value = xl.Readvalue(Sheet, i, j);					
					
					dMap.put(Skey, Value);
					
					
				}//end of inner for loop
				
				x[0]=dMap;
				arr_list.add(x);			
				
				
			}//end of if condition
			
				
			
		}//end of outer for loop
		
		return arr_list.iterator();	
		
		
	}	
	
	

}
