package com.gmail.fomenkoc.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "role_id")
	@GeneratedValue
	private Integer roleID;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "is_staff")
	private Boolean isStaff;

	public Role() {
		super();
	}

	public Role(String roleName, Boolean isStaff) {
		super();
		this.roleName = roleName;
		this.isStaff = isStaff;
	}

	public Role(Integer roleID, String roleName, Boolean isStaff) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.isStaff = isStaff;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isStaff, roleID, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(isStaff, other.isStaff)
				&& Objects.equals(roleID, other.roleID)
				&& Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName
				+ ", isStaff=" + isStaff + "]";
	}

}
