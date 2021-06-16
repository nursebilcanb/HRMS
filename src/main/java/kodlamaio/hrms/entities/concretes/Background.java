package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "backgrounds")
@NoArgsConstructor
@AllArgsConstructor
public class Background {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "image_url")
	String imageUrl;
	
	@Column(name = "github")
	String github;
	
	@Column(name = "linkedin")
	String linkedin;
	
	@Column(name = "cover_letter")
	String coverLetter;
	
	@Column(name = "is_activated")
	boolean isActivated;
	
	@Column(name = "created_at")
	LocalDate createdAt;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "background_schools",
				joinColumns = {@JoinColumn(name = "background_id")},
				inverseJoinColumns = {@JoinColumn(name = "school_id")})
	private Set<School> schools = new HashSet<>();
	
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "background_job_experiences",
				joinColumns = {@JoinColumn(name = "background_id")},
				inverseJoinColumns = {@JoinColumn(name = "job_experience_id")})
	private Set<JobExperience> jobExperiences = new HashSet<>();
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "background_foreign_languages",
			joinColumns = {@JoinColumn(name = "background_id")},
			inverseJoinColumns = {@JoinColumn(name = "foreign_language_id")})
	private Set<ForeignLanguage> foreignLanguages =  new HashSet<>();
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "background_programming_languages",
	joinColumns = {@JoinColumn(name = "background_id")},
	inverseJoinColumns = {@JoinColumn(name = "programming_language_id")})
	private Set<ProgrammingLanguage> programmingLanguages =  new HashSet<>();
	
	
	
	public Background(Candidate candidate, String github, String linkedin, String coverLetter) {
		this.candidate = candidate;
		this.github = github;
		this.linkedin = linkedin;
		this.coverLetter = coverLetter;
	}
}
