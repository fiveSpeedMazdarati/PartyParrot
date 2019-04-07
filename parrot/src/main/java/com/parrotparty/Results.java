package com.parrotparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Results{

	public Results() {

	}

	public Results(String name, String gif, String hd, String category) {
		this.name = name;
		this.gif = gif;
		this.hd = hd;
		this.category = category;
	}

	@JsonProperty("gif")
	private String gif;

	@JsonProperty("name")
	private String name;

	@JsonProperty("hd")
	private String hd;

	@JsonProperty("category")
	private String category;

	public void setGif(String gif){
		this.gif = gif;
	}

	public String getGif(){
		return gif;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setHd(String hd){
		this.hd = hd;
	}

	public String getHd(){
		return hd;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"gif = '" + gif + '\'' + 
			",name = '" + name + '\'' + 
			",hd = '" + hd + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}