package com.lyris.mesa.model.store;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.hazelcast.core.MapStore;

/**
 * 
 * mapstore will persist into mysql Database
 *
 */
public class MySQLMapStore implements MapStore<String, Object>, SQLQuery {

	private static Logger logger = Logger.getLogger(MySQLMapStore.class
			.getSimpleName());

	{
		logger.info("Hazelcast MySQL MapStore Instance Created. ");
	}

	/**
	 * jdbcTemplate will handle DB connection
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * setting method injected through IOC
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * load object from Database using given KEY
	 */
	public Object load(String key) {

		logger.info(" loading persisted entry " + key);

		try {
			byte[] bytes = jdbcTemplate.queryForObject(SELECT_QUERY,
					new Object[] { key }, byte[].class);

			return deserialize(bytes);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public Map<String, Object> loadAll(Collection<String> keys) {

		Map<String, Object> map = new HashMap<String, Object>();

		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String map_key = iterator.next();
			Object map_value = load(map_key);
			map.put(map_key, map_value);
		}
		logger.info(" total " + map.size() + " objects loaded ");
		return map;
	}

	public Set<String> loadAllKeys() {

		List<String> list = jdbcTemplate.queryForList(ALL_KEYS, String.class);

		logger.info(" total keys found " + list.size());
		return new HashSet<String>(list);
	}

	public void delete(final String key) {

		jdbcTemplate.execute(DELETE_KEY,
				new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1, key);
						return ps.execute();
					}
				});

		logger.info(" entry with key " + key + "deleted ");

	}

	public void deleteAll(Collection<String> keys) {

		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String map_key = iterator.next();
			delete(map_key);
		}

		if (!keys.isEmpty()) {
			logger.info(" total " + keys.size() + "objects deleted. ");
		}
	}

	/**
	 * store method save object into DB . if KEY already exist it will update
	 * the record with new value
	 */
	public void store(final String key, final Object value) {

		try {

			jdbcTemplate.execute(INSERT_QUERY,
					new PreparedStatementCallback<Boolean>() {

						public Boolean doInPreparedStatement(
								PreparedStatement ps) throws SQLException,
								DataAccessException {
							ps.setString(1, key);
							ps.setObject(2, value);
							return ps.execute();
						}

					});

			logger.info(" entry persisted successfully [ " + key + " = "
					+ value + " ]");

		} catch (org.springframework.dao.DuplicateKeyException dke) {
			logger.info(" updating  value with existing key " + key);
			update(key, value);
		}
	}

	private void update(final String key, final Object value) {

		jdbcTemplate.execute(UPDATE_QUERY,
				new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setObject(1, value);
						ps.setString(2, key);
						return ps.execute();
					}
				});
	}

	public void storeAll(Map<String, Object> map) {

		Set<Entry<String, Object>> set = map.entrySet();
		for (Iterator<Entry<String, Object>> iterator = set.iterator(); iterator
				.hasNext();) {
			Entry<String, Object> entry = iterator.next();
			store(entry.getKey(), entry.getValue());
		}

		logger.info(" total  " + map.size() + " objects saved.");

	}

	/**
	 * convert byte stream into Object
	 * 
	 * @param objectBytes
	 * @return
	 */
	public Object deserialize(byte[] objectBytes) {

		try {
			ObjectInputStream objectIn = new ObjectInputStream(
					new ByteArrayInputStream(objectBytes));

			return objectIn.readObject();
		} catch (Exception e) {
			return null;
		}
	}

}
