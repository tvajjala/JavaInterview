package com.lyris.mesa.model.store;

/**
 * MySQL Queries which are used in MySQLMapStore
 * 
 */
		
public interface SQLQuery {

	String INSERT_QUERY = "INSERT INTO tbl_hazelmap(map_key,map_value) values(?,?)";
	String UPDATE_QUERY = "UPDATE tbl_hazelmap SET map_value=? WHERE map_key=?";
	String SELECT_QUERY = "SELECT map_value FROM tbl_hazelmap WHERE map_key=?";
	String ALL_KEYS = "SELECT map_key FROM  tbl_hazelmap";
	String DELETE_KEY = "DELETE FROM tbl_hazelmap WHERE map_key=?";

}
