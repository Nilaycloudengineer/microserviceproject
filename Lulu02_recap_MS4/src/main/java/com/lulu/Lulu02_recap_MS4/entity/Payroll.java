package com.lulu.Lulu02_recap_MS4.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="payroll")
public class Payroll {
	@Id
	int id;
	String name;
	float sal;
	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payroll(int id, String name, float sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Payroll [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, sal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payroll other = (Payroll) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Float.floatToIntBits(sal) == Float.floatToIntBits(other.sal);
	}
	
	

}
