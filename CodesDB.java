package com.yms.aunretailer;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CodesDB extends SQLiteOpenHelper {

	
	public static final String path = "/data/data/com.example.aunretailer/databases/dbmanager";
String table_name="table1";
	
	// the paramenter constructer give me is uselss because we will make it constant
	public CodesDB(Context context) {
		super(context, "dbmanager", null, 1);
	}

	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE table1 (PurchaseCode text, AppList text, GenerationDate text, ActivationStatus text)" ;
		db.execSQL(sql);

	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
				db.execSQL("DROP TABLE IF EXISTS " + "table1");

				// Create tables again
				onCreate(db);
	}
	public long addRecord(String code,String list,String date,String status){
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("PurchaseCode", code);
		values.put("AppList", list);
		values.put("GenerationDate", date);
		values.put("ActivationStatus", status);
		
		
		long b=db.insert(table_name, null, values);
		db.close(); 
		return b;
	}
	public int updateRecord(String code,String colname, String value) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(colname, value);
		
		int ret=db.update(table_name, values, "PurchaseCode=?",
				new String[] { code });
		// updating row
		db.close();
		return ret;
		
		

	}
	
	
		
		public boolean recordExists(String chapter){
			boolean exists=false;
			String result = null;
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor cursor = db.rawQuery("select Chapter from table1 where Chapter=?", new String[]{ chapter });
			if (cursor.moveToNext()) {
				result = cursor.getString(0);
	 		}
			if(result!=null)
				exists=true;
			cursor.close();
			db.close();
			
			return  exists;
		}
		
		
		public ArrayList<String[]> getArrayList(){
			ArrayList<String[]> users=new ArrayList<String[]>();
			//String[] record={null,null,null,null,null};
			String[] columns;
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor c = db.rawQuery("select * from table1",null);
			try {
			    if (c != null) {
			        c.moveToFirst();
			        columns=c.getColumnNames();
			        //users.add(columns);

			        while (!c.isAfterLast()) {
			            	/*for(int i=0;i<5;i++){
								record[i]=c.getString(i);
									 }*/
			        	
			      String[] record={c.getString(0),c.getString(1),c.getString(2),c.getString(3)};
			            	users.add(record);
			            	c.moveToNext();

			                    }
			                    
			            }
			        } catch (SQLiteException e) {

			                Log.e("Retrieve Data", "Unable to get Data " + e);
			                e.printStackTrace();
			        }
			c.close();
			db.close();
		
			return users;
			 
			
		}
public String getField(String colname,String chapter){
			
			SQLiteDatabase db = this.getWritableDatabase();
			
			String field="";
			
			String query="select "+colname+" from "+table_name+" where Chapter=?";
			Cursor cursor = db.rawQuery(query, new String[]{ chapter });
			try {
			    if (cursor.moveToFirst()) {
			        
			        /*String cols[]=cursor.getColumnNames();
			        int col=0;
			        for(int i=0;i<cols.length;i++){
			        	if(cols[i].equalsIgnoreCase(colname)){
			        		col=i;
			        		break;
			        	}
			        }*/
			        field=cursor.getString(0);
			                    
			    }
			    } catch (SQLiteException e) {

			                
			                e.printStackTrace();
			        }
			cursor.close();
			db.close();
			return field;
		}

public ArrayList<String> getColumnData(String clas,String subject,String column){

	ArrayList<String> chapters=new ArrayList<String>();
	

	
	SQLiteDatabase db = this.getReadableDatabase();
	Cursor c 
	= db.rawQuery("select "+column+" from "+table_name+" where Class=? AND Subject=?", new String[]{ clas,subject });
	try {
	    if (c != null) {
	        c.moveToFirst();
	        
	        while (!c.isAfterLast()) {
	            	
	      String record=c.getString(0);
	      //System.out.println(column+"------"+record);
	            	chapters.add(record);
	            	c.moveToNext();

	                    }
	                    
	            }
	        } catch (SQLiteException e) {

	                Log.e("Retrieve Data", "Unable to get Data " + e);
	                e.printStackTrace();
	        }
	c.close();
	db.close();
	
	return chapters;	
}
		

		}

