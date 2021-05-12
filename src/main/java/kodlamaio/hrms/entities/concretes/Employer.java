package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="employers")
public class Employer extends User{
	
	@Column(name="company_name")
	String companyName;
	
	@Column(name="web_site_name")
	String webSiteName;
	
	@Column(name="email")
	String email;
	
	@Column(name="phone_number")
	String phone;
	
	@Column(name="password")
	String password;
	
	@Column(name="email_verification")
	Boolean emailVerification;
	
	@Column(name="verify_by_employee")
	Boolean verifyByEmployee;
}
