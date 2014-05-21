package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.Region;

@Entity
@Table(name = "EMAILSUBSCRIPTION")
public class EmailSubscriptionEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emailSubscriptionId;

	@Column(length = 255, unique = true, nullable = false)
	private String email;

	@Column(nullable = true,name="isSubscribed")
	private Boolean subscribed;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country country;

	@Column(length = 60, nullable = false)
	private String firstName;

	@Column(length = 60, nullable = true)
	private String lastName;

	@Column(length = 60, nullable = false)
	private String sourceValue;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Region region;
	
	

}
