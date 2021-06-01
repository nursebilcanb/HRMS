package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_adverts")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "min_salary")
	int minSalary;
	
	@Column(name = "max_salary")
	int maxSalary;
	
	@Column(name = "is_activated")
	Boolean isActivated;
	
	@Column(name = "created_at")
	LocalDate createdAt = LocalDate.now();
	
	@Column(name = "application_deadline")
	LocalDate applicationDeadline;
	
	@Column(name = "open_position_amount")
	int openPositionAmount;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	City city;
}
