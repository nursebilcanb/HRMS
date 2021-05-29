package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;



@Entity
@Table(name="employers")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id")
public class Employer extends User{
	
	@Column(name="company_name")
	String companyName;
	
	@Column(name="web_site_name")
	String webSiteName;
	
	@Column(name="phone_number")
	String phone;
	
	@Column(name="verify_by_employee")
	Boolean verifyByEmployee;
}
