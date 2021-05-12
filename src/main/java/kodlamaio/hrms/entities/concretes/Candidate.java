package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidate extends User{
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="nationality_id")
	String nationalityId;
	
	@Column(name="date_of_birth")
	Date dateOfBirth;
	
	@Column(name="email")
	String email;
	
	@Column(name="password")
	String password;
	
	@Column(name="email_verification")
	Boolean emailVerification;
}
