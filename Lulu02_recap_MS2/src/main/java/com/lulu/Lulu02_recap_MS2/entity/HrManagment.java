package com.lulu.Lulu02_recap_MS2.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="hrm")
public class HrManagment {
	@Id
	int hrid;
	String dept;
	float sal;
	public HrManagment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HrManagment(int hrid, String dept, float sal) {
		super();
		this.hrid = hrid;
		this.dept = dept;
		this.sal = sal;
	}
	public int getHrid() {
		return hrid;
	}
	public void setHrid(int hrid) {
		this.hrid = hrid;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "HrManagment [hrid=" + hrid + ", dept=" + dept + ", sal=" + sal + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dept, hrid, sal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HrManagment other = (HrManagment) obj;
		return Objects.equals(dept, other.dept) && hrid == other.hrid
				&& Float.floatToIntBits(sal) == Float.floatToIntBits(other.sal);
	}
	
	

}
