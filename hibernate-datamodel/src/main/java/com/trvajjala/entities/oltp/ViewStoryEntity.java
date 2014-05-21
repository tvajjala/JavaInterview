package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.Gender;

@Entity
@Table(name = "VIEWSTORY")
public class ViewStoryEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer viewStoryId;

	@Column(length = 100, nullable = false)
	private String viewStoryTitle;

	@Column(length = 30)
	private String viewStoryCode;

	@Column(length = 60, nullable = false)
	private String firstName;

	@Column(length = 60)
	private String lastName;

	@Column(length = 255)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	private Integer age;

	@Column(length = 100)
	private String useMyTestimonial;

	@Lob
	private String experience;

	private Date viewStoryDate;

	@ManyToOne
	@JoinColumn(name = "testimonialTypeId", nullable = false)
	@ForeignKey(name = "FK_ViewStory_TestimonialsTypes")
	private TestimonialsTypesEntity testimonialsType;

	private Boolean approved;

	@ManyToOne
	@JoinColumn(name = "testimonialsLinkId", nullable = false)
	@ForeignKey(name = "FK_ViewStory_TestimonialsLinks")
	private TestimonialsLinksEntity testimonialsLink;

	@Column(nullable = false)
	private Integer deviceTypeId;

	public Integer getViewStoryId() {
		return viewStoryId;
	}

	public void setViewStoryId(Integer viewStoryId) {
		this.viewStoryId = viewStoryId;
	}

	public String getViewStoryTitle() {
		return viewStoryTitle;
	}

	public void setViewStoryTitle(String viewStoryTitle) {
		this.viewStoryTitle = viewStoryTitle;
	}

	public String getViewStoryCode() {
		return viewStoryCode;
	}

	public void setViewStoryCode(String viewStoryCode) {
		this.viewStoryCode = viewStoryCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUseMyTestimonial() {
		return useMyTestimonial;
	}

	public void setUseMyTestimonial(String useMyTestimonial) {
		this.useMyTestimonial = useMyTestimonial;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getViewStoryDate() {
		return viewStoryDate;
	}

	public void setViewStoryDate(Date viewStoryDate) {
		this.viewStoryDate = viewStoryDate;
	}

	public TestimonialsTypesEntity getTestimonialsType() {
		return testimonialsType;
	}

	public void setTestimonialsType(TestimonialsTypesEntity testimonialsType) {
		this.testimonialsType = testimonialsType;
	}

	public Boolean isApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public TestimonialsLinksEntity getTestimonialsLink() {
		return testimonialsLink;
	}

	public void setTestimonialsLink(TestimonialsLinksEntity testimonialsLink) {
		this.testimonialsLink = testimonialsLink;
	}

	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

}
