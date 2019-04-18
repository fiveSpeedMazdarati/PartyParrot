package com.parrotparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * A gif displaying a Party Parrot. See https://cultofthepartyparrot.com/ for the original concept.
 */
@Generated("com.robohorse.robopojogenerator")
public class Parrot {

	/**
	 * Instantiates a new Parrot.
	 */
	public Parrot() {

	}

	/**
	 * Instantiates a new Parrot.
	 *
	 * @param name     the name
	 * @param gif      the gif
	 * @param hd       the hd
	 * @param category the category
	 */
	public Parrot(String name, String gif, String hd, String category) {
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

	/**
	 * Set gif.
	 *
	 * @param gif the gif
	 */
	public void setGif(String gif){
		this.gif = gif;
	}

	/**
	 * Get gif string.
	 *
	 * @return the gif string
	 */
	public String getGif(){
		return gif;
	}

	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Get name string.
	 *
	 * @return the name string
	 */
	public String getName(){
		return name;
	}

	/**
	 * Set the link to the high definition gif.
	 *
	 * @param hd the high definition gif
	 */
	public void setHd(String hd){
		this.hd = hd;
	}

	/**
	 * Get the high definition gif string.
	 *
	 * @return the high definition gif string
	 */
	public String getHd(){
		return hd;
	}

	/**
	 * Set category.
	 *
	 * @param category the category
	 */
	public void setCategory(String category){
		this.category = category;
	}

	/**
	 * Get category string.
	 *
	 * @return the category string
	 */
	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"Parrot{" +
			"gif = '" + gif + '\'' + 
			",name = '" + name + '\'' + 
			",hd = '" + hd + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}