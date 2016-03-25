package model;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Ann Huang
 * @date 02/19/2016
 * @description model in the MVC architecture 
 * @functions RecordEntry class to store input file records
 */
public class RecordEntry { 
	/*
	 * record fields
	 * */ 
	public int id;	// unique id
	public String name;	// name
	public List<Integer> values = new ArrayList<Integer>();	// other values
	public boolean unique = true;	// used for comparison, difference->unique->true
	
	/**
	* @description add value in the values list
	* @argument integer
	* @return none, add value in the values list
	*/
	public void addValue(Integer i) {
		values.add(i);
	}
	
	/**
	* @description override equals method
	* @argument anther record
	* @return boolean, compare each fields in the two records, 
	* 		  if equals, return true, else return false
	*/
	@Override
	public boolean equals(Object other) {
	    if (!(other instanceof RecordEntry)) {
	        return false;
	    }

	    RecordEntry o = (RecordEntry) other;

	    // Custom equality check here.
	    boolean equal = true;
	    if(this.id != o.id ) equal = false;
	    if(!this.name.equals(o.name)) equal = false;
	    if(this.values.size() != o.values.size())	equal = false;
	    for(int i = 0; i < this.values.size(); i++) {
	    	if(this.values.get(i) != o.values.get(i))	
	    		equal = false;
	    }	    
	    return equal;
	}

	
	/********followings are getters setters********/
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the values
	 */
	public List<Integer> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<Integer> values) {
		this.values = values;
	}

	/**
	 * @return the unique
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * @param unique the unique to set
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
	}

}
