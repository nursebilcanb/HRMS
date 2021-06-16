package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
public class Employer extends User{
	
	@Column(name="company_name")
	String companyName;
	
	@Column(name="web_site_name")
	String webSiteName;
	
	@Column(name="phone_number")
	String phone;
	
	@Column(name="verify_by_employee")
	boolean verifyByEmployee = false;
	
	@OneToMany(mappedBy = "employer")
	List<JobAdvert> jobAdverts;
} 
