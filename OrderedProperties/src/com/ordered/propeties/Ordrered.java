package com.ordered.propeties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Ordrered {

	
	public LinkedHashMap<String,String> OrderedPropertyReader()
	{
		String line=null;
		String keyvaluepair[];
		LinkedHashMap<String,String> map=new LinkedHashMap<>();
	File file=new File("C:/archivelogs/name.properties");
	try
	{
    BufferedReader br=new BufferedReader(new FileReader(file)) ;
     while((line=br.readLine())!=null)
     {
    	 keyvaluepair=line.split("=");
    	 map.put(keyvaluepair[0],keyvaluepair[1]);
     }
     br.close();
	}
	
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	return map;
	}
	
}
