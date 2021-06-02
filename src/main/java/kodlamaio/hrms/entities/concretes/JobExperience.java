package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "work_place_name")
	String workPlaceName;
	
	@Column(name = "position")
	String position;

	@Column(name = "starting_date")
	LocalDate startingDate;
	
	@Column(name = "finish_date")
	LocalDate finishDate;
	
	@Column(name = "created_at")
	LocalDate createdAt = LocalDate.now();
	
	@Column(name = "is_activated")
	Boolean isActivated;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "jobExperiences")
	private List<Background> backgrounds;
	
	public String getFinishDate() {
		if(this.finishDate == null)
			return "Devam ediyor";
		return this.finishDate.toString();
	}
}
