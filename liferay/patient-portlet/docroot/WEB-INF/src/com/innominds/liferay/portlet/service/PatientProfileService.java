package com.innominds.liferay.portlet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innominds.liferay.portlet.vo.PatientProfile;

/**
 * 
 * @author tvajjala
 * 
 */

@Service
@SuppressWarnings("all")
public class PatientProfileService {

	String SELECT_QUERY = "SELECT * FROM NH_GN_PAT_REGISTRATION";
	// String INSERT_QUERY =
	// "INSERT INTO NH_GN_PAT_REGISTRATION(firstname,lastname,email,password) values(?,?,?,?)";

	String SELECT_BY = "SELECT * FROM NH_GN_PAT_REGISTRATION WHERE RG_INT_MR_NO=?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public List<PatientProfile> list() {
		List<PatientProfile> plist = new ArrayList<PatientProfile>();

		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList(SELECT_QUERY);

		for (Map rs : rows) {

			PatientProfile patientProfile = new PatientProfile();

			patientProfile.setFirstname((String) rs.get("RG_FIRST_NAME"));
			patientProfile.setLastname((String) rs.get("RG_LAST_NAME"));

			patientProfile.setAge(Integer.parseInt((String) rs.get("RG_AGE")));
			// patientProfile.setDob(new Timestamp(rs.get("RG_DOB")));
			patientProfile.setExtMR((String) rs.get("RG_EXT_MR_NO"));
			patientProfile.setIntMR((String) rs.get("RG_INT_MR_NO"));

			plist.add(patientProfile);
		}
		return plist;
	}

	public PatientProfile getProfile(String mrNumber) throws Exception{

		
		return jdbcTemplate.queryForObject(SELECT_BY,
				new Object[] { mrNumber }, new PatientProfileRowMapper());

	}

}

/**
 * 
 * this reusable entity RowMapper will map the database column with bean
 * properties
 * 
 */
class PatientProfileRowMapper implements RowMapper<PatientProfile> {

	@Override
	public PatientProfile mapRow(ResultSet rs, int arg1) throws SQLException {

		PatientProfile patientProfile = new PatientProfile();

		patientProfile.setFirstname(rs.getString("RG_FIRST_NAME"));
		patientProfile.setLastname(rs.getString("RG_LAST_NAME"));

		patientProfile.setAge(rs.getInt("RG_AGE"));
		patientProfile.setDob(rs.getTimestamp("RG_DOB"));
		patientProfile.setExtMR(rs.getString("RG_EXT_MR_NO"));
		patientProfile.setIntMR(rs.getString("RG_INT_MR_NO"));

		return patientProfile;
	}

	/*
	 * public void addPatient(final PatientProfile patientProfile) {
	 * 
	 * jdbcTemplate.execute(INSERT_QUERY, new
	 * PreparedStatementCallback<Boolean>() {
	 * 
	 * public Boolean doInPreparedStatement(PreparedStatement ps) throws
	 * SQLException, DataAccessException { ps.setObject(1,
	 * patientProfile.getFirstname()); ps.setString(2,
	 * patientProfile.getLastname()); ps.setString(3,
	 * patientProfile.getEmail()); ps.setObject(4,
	 * patientProfile.getPassword()); return ps.execute(); }
	 * 
	 * }); }
	 */
}
