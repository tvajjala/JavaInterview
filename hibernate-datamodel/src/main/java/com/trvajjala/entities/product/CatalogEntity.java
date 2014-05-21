package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.CatalogType;
import com.trvajjala.entities.constants.Country;

@Entity
@Table(name = "CATALOG")
public class CatalogEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catalogId;

	@Column(length = 100, nullable = false)
	private String catalogTitle;

	@ManyToOne
	@JoinColumn(name = "channelId")
	@ForeignKey(name = "FK_Catalog_Channel")
	private ChannelEntity channel;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private CatalogType catalogType;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Country country;

	@Column(nullable = false)
	private Boolean active;

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogTitle() {
		return catalogTitle;
	}

	public void setCatalogTitle(String catalogTitle) {
		this.catalogTitle = catalogTitle;
	}

	public ChannelEntity getChannel() {
		return channel;
	}

	public void setChannel(ChannelEntity channel) {
		this.channel = channel;
	}

	public CatalogType getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(CatalogType catalogType) {
		this.catalogType = catalogType;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
