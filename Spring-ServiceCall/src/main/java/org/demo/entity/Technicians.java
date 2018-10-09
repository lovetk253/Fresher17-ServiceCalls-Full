package org.demo.entity;
// Generated Oct 1, 2018 4:13:35 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Technicians generated by hbm2java
 */
@Entity
@Table(name = "Technicians", catalog = "db_assigment")
public class Technicians implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer technicianId;
	private String technicianName;
	private Set<ServiceRequestActions> serviceRequestActionses = new HashSet<ServiceRequestActions>(0);

	public Technicians() {
	}

	public Technicians(String technicianName, Set<ServiceRequestActions> serviceRequestActionses) {
		this.technicianName = technicianName;
		this.serviceRequestActionses = serviceRequestActionses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Technician_ID", unique = true, nullable = false)
	public Integer getTechnicianId() {
		return this.technicianId;
	}

	public void setTechnicianId(Integer technicianId) {
		this.technicianId = technicianId;
	}

	@Column(name = "Technician_Name", length = 45)
	public String getTechnicianName() {
		return this.technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "technicians")
	public Set<ServiceRequestActions> getServiceRequestActionses() {
		return this.serviceRequestActionses;
	}

	public void setServiceRequestActionses(Set<ServiceRequestActions> serviceRequestActionses) {
		this.serviceRequestActionses = serviceRequestActionses;
	}

}
