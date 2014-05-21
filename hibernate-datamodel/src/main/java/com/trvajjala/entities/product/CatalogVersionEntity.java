package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "CATALOG_VERSION")
public class CatalogVersionEntity implements Serializable {

	private static final long serialVersionUID = -645126012724719474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catalogVersionId;

	@ManyToOne
	@JoinColumn(name = "catalogId", nullable = false)
	@ForeignKey(name = "FK_catalogVersion_catalog")
	private CatalogEntity catalog;

	@Column(length = 20)
	private String version;

	@Column(length = 20)
	private String currentVersion;

	public Integer getCatalogVersionId() {
		return catalogVersionId;
	}

	public void setCatalogVersionId(Integer catalogVersionId) {
		this.catalogVersionId = catalogVersionId;
	}

	public CatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogEntity catalog) {
		this.catalog = catalog;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

}
