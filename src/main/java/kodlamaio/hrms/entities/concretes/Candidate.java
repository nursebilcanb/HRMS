package kodlamaio.hrms.entities.concretes;

import java.util.Date;
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
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id")
public class Candidate extends User{
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="nationality_id")
	String nationalityId;
	
	@Column(name="date_of_birth")
	Date dateOfBirth;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	
	@OneToMany(mappedBy = "candidate")
	private List<Background> backgrounds;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;

}
