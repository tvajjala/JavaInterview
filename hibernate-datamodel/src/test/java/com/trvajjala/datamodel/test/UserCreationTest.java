package com.trvajjala.datamodel.test;

import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.UserType;
import com.trvajjala.entities.oltp.RoleEntity;
import com.trvajjala.entities.oltp.UserEntity;
import com.trvajjala.entities.oltp.UserGroupEntity;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserCreationTest extends HibernateConnection {

	@Test
	public void saveUser() {

		UserEntity userEntity = new UserEntity();
		userEntity.setEmail("tvajjala@innominds.com");
		userEntity.setUserType(UserType.CUSTOMER);
		userEntity.setFirstName("ThirupathiReddy");
		userEntity.setPhoneNumber("9000211024");
		userEntity.setCustomerID(new Random().nextInt());
		userEntity.setEnabled(true);
		userEntity.setRegisteredCountry(Country.US);
		session.save(userEntity);
	}

	@Test
	public void manyOneRelationTest() {

		UserGroupEntity userGroupEntity = new UserGroupEntity();
		userGroupEntity.setUserGroupCode("USER_GROUP");
		userGroupEntity.setUserGroupTitle("User Group");
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setRoleTitle("Administrator");
		roleEntity.setRoleCode("ROLE_ADMIN");
		//session.merge(roleEntity);
		userGroupEntity.setRole(roleEntity);
		session.save(userGroupEntity);
		
		
		

	}

}
