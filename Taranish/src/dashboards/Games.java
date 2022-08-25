package dashboards;
import loginsignups.*;
import transactions.*;

import java.lang.*;

public class Games {

	private String name;
	private double price;
	private String category;
	private String appid;
	
	public Games(String name, double price, String category, String appid){
		this.name = name;
		this.price = price;
		this.category = category;
		this.appid = appid;
	}
	




	//set functions
	public void setName (String name) {
		this.name = name;
	}
	public void setPrice (Double price) {
		this.price = price;
	}
	public void setCategory (String category) {
		this.category = category;
	}
	public void setAppID (String appid) {
		this.appid = appid;
	}
	





	//get functions
	public String getName (){
		return name;
	}
	
	public double getPrice (){
		return price;
	}
	
	public String getCategory (){
		return category;
	}
	
	public String getAppID (){
		return appid;
	}
	



	public void showAll(){
		System.out.println("Name: "+name);
		System.out.println("Price: "+price);
		System.out.println("Category: "+category);
		System.out.println("App ID: "+appid);
	}


	
}
