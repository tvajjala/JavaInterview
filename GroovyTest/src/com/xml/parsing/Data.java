package com.xml.parsing;

import java.io.Serializable;

/**
 * 
 * @author tvajjala
 *
 */
public class Data implements Serializable {

	private static final long serialVersionUID = 2967936850951371585L;

	 String id;

	 String name;
	 String messages;
	 String lastsent;
	 String lastsentTZ;
	 String members;
	 String status;
	 String cacheTime;
	 String extendedAddressing;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}
	/**
	 * @return the lastsent
	 */
	public String getLastsent() {
		return lastsent;
	}
	/**
	 * @param lastsent the lastsent to set
	 */
	public void setLastsent(String lastsent) {
		this.lastsent = lastsent;
	}
	/**
	 * @return the lastsentTZ
	 */
	public String getLastsentTZ() {
		return lastsentTZ;
	}
	/**
	 * @param lastsentTZ the lastsentTZ to set
	 */
	public void setLastsentTZ(String lastsentTZ) {
		this.lastsentTZ = lastsentTZ;
	}
	/**
	 * @return the members
	 */
	public String getMembers() {
		return members;
	}
	/**
	 * @param members the members to set
	 */
	public void setMembers(String members) {
		this.members = members;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the cacheTime
	 */
	public String getCacheTime() {
		return cacheTime;
	}
	/**
	 * @param cacheTime the cacheTime to set
	 */
	public void setCacheTime(String cacheTime) {
		this.cacheTime = cacheTime;
	}
	/**
	 * @return the extendedAddressing
	 */
	public String getExtendedAddressing() {
		return extendedAddressing;
	}
	/**
	 * @param extendedAddressing the extendedAddressing to set
	 */
	public void setExtendedAddressing(String extendedAddressing) {
		this.extendedAddressing = extendedAddressing;
	}


     @Override
    public String toString() {
    
    	return "@id="+id+";\tstatus="+status+";\t members="+members +";\t messages="+messages+";\t name="+name+";\t extendingAdd="+extendedAddressing;
    }


}
