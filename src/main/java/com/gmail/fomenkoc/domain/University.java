package com.gmail.fomenkoc.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private Integer accredetationLevel;

	@Column
	private Integer institutesQuantity;

	@Column
	private Integer studentsQuantity;

	@Column
	private String address;

	public University() {
		super();
	}

	public University(String name, Integer accredetationLevel,
			Integer institutesQuantity, Integer studentsQuantity,
			String address) {
		super();
		this.name = name;
		this.accredetationLevel = accredetationLevel;
		this.institutesQuantity = institutesQuantity;
		this.studentsQuantity = studentsQuantity;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAccredetationLevel() {
		return accredetationLevel;
	}

	public void setAccredetationLevel(Integer accredetationLevel) {
		this.accredetationLevel = accredetationLevel;
	}

	public Integer getInstitutesQuantity() {
		return institutesQuantity;
	}

	public void setInstitutesQuantity(Integer institutesQuantity) {
		this.institutesQuantity = institutesQuantity;
	}

	public Integer getStudentsQuantity() {
		return studentsQuantity;
	}

	public void setStudentsQuantity(Integer studentsQuantity) {
		this.studentsQuantity = studentsQuantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accredetationLevel, address, id, institutesQuantity,
				name, studentsQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		return Objects.equals(accredetationLevel, other.accredetationLevel)
				&& Objects.equals(address, other.address)
				&& Objects.equals(id, other.id)
				&& Objects.equals(institutesQuantity, other.institutesQuantity)
				&& Objects.equals(name, other.name)
				&& Objects.equals(studentsQuantity, other.studentsQuantity);
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name
				+ ", accredetationLevel=" + accredetationLevel
				+ ", institutesQuantity=" + institutesQuantity
				+ ", studentsQuantity=" + studentsQuantity + ", address="
				+ address + "]";
	}

}
