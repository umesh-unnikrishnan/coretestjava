package jdbcdemo;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import com.google.gson.*;



public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
		// Get connected
			
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", ""); 
		
		// create statement
		
		Statement myStmtCust = myConn.createStatement();
		
		Statement myStmtEmp = myConn.createStatement();
		
		// Execute SQL Query
		
		ResultSet myResCus = myStmtCust.executeQuery("SELECT * FROM customers");
		
		
		ResultSet myResEmp = myStmtEmp.executeQuery("SELECT * FROM employees");
		
		ResultSetMetaData rsmd = myResCus.getMetaData();
		
		int numberOfColumns = rsmd.getColumnCount();
		
	    //System.out.println(numberOfColumns);
	    
		List rowValues = new ArrayList();

		
		while (myResCus.next()) {
			rowValues.add(myResCus.getString("phone"));
			
			
			
			
		}
		
		System.out.println(rowValues);
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss:SS");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		
		
		ArrayList<String> mylist = new ArrayList<String> ();
		 mylist.add("abc");
		 mylist.add("cfd");
		 mylist.add("ert");
		 mylist.add("fg");
		 mylist.add("ujk");
		 //String json = new Gson().toJson(mylist);
		 
		 
		 Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		 
		 Gson gson = new Gson();
		 String jsonArray = prettyGson.toJson(rowValues);
		 
		 System.out.println(jsonArray);
		 
		 //return jsonArray;
		 
			Calendar calobj1 = Calendar.getInstance();
			System.out.println(df.format(calobj1.getTime()));
		 
		 System.out.println("-------------------------------------------------------------------------------------");
		
		String phoneJson = new Gson().toJson(rowValues);
		
		System.out.println(phoneJson);
		
		// Creating ArrayList 
        ArrayList<String> list 
            = new ArrayList<String>(); 
  
        // Adding object in ArrayList 
        list.add("A"); 
        list.add("B"); 
        list.add("C"); 
        list.add("D"); 
  
        // Invoking ArrayList object 
        System.out.println("ArrayList: " + list); 
  
        // Creating HashMap 
        HashMap<Integer, String> hm 
            = new HashMap<Integer, String>(); 
  
        // Adding object in HashMap 
        hm.put(1, "A"); 
        hm.put(2, "B"); 
        hm.put(3, "C"); 
        hm.put(4, "D"); 
  
        // Invoking HashMap object 
        // It might or might not display elements 
        // in the insertion order 
        System.out.print("HasMap: " + hm); 
		
		
		
//		while (myResEmp.next()) {
//			System.out.println(myResEmp.getString("email"));
//			
//		}
		

		myConn.close();
		
		}
		catch	(Exception exc){
			exc.printStackTrace();
		}

	}

}
