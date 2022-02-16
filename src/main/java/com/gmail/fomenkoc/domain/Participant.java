package com.gmail.fomenkoc.domain;

import java.util.Objects;

public class Participant {

	private Integer id;
	private String name;
	private String email;
	private Level level;
	private String primarySkill;

	public Participant() {
		super();
	}

	public Participant(String name, String email, Level level,
			String primarySkill) {
		super();
		this.name = name;
		this.email = email;
		this.level = level;
		this.primarySkill = primarySkill;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, level, name, primarySkill);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && level == other.level
				&& Objects.equals(name, other.name)
				&& Objects.equals(primarySkill, other.primarySkill);
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", email=" + email
				+ ", level=" + level + ", primarySkill=" + primarySkill + "]";
	}

}
