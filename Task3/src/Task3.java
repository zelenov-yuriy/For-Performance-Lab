import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Task3 
{
	public static void main(String[] args)
	{				
		try
		{
			JSONParser parser = new JSONParser();
			
			Object object1 = parser.parse(new FileReader(args[0]));
			JSONObject jObject1 = (JSONObject)object1;
			
			Object object2 = parser.parse(new FileReader(args[1]));
			JSONObject jObject2 = (JSONObject)object2;
			
			if(jObject1.containsKey("values"))
			{
				JSONObject temp = jObject1;
				jObject1 = jObject2;
				jObject2 = temp;
			}
			
			JSONObject tests = jObject1;
			JSONObject values = jObject2;
			
			JSONArray testsArray = (JSONArray)tests.get("tests");
			testsArray.forEach(item -> fillValues((JSONObject) item, values));
			
			FileWriter file = new FileWriter("report.json");
			file.write(tests.toString());
			file.flush();
		}
		catch(FileNotFoundException e) { e.printStackTrace(); }
		catch(IOException e) { e.printStackTrace(); }
		catch(ParseException e) { e.printStackTrace(); }
	}
	
	private static void fillValues(JSONObject item, JSONObject values)
	{
		long id = (long)item.get("id");
		JSONArray valuesArray = (JSONArray)values.get("values");
		
		if(item.containsKey("value"))
		{
			for(int i=0; i<valuesArray.size(); i++)
			{
				JSONObject valuesItem = (JSONObject)valuesArray.get(i);
				long vId = (long)valuesItem.get("id");
				if(vId == id)
				{
					String vValue = (String)valuesItem.get("value");
					item.put("value", vValue);
					break;
				}
			}
		}
		if(item.containsKey("values"))
		{
			JSONArray itemsArray = (JSONArray)item.get("values");
			itemsArray.forEach(value -> fillValues((JSONObject) value, values));
		}
	}
}
