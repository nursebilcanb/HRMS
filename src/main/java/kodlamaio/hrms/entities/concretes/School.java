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
@Table(name = "schools")
@NoArgsConstructor
@AllArgsConstructor
public class School {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "department")
	 String department;
	
	@Column(name = "starting_date")
	 LocalDate startingDate;
	
	@Column(name = "finish_date")
	 LocalDate finishDate;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy ="schools")
	private List<Background> backgrounds;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	public String getFinishDate() {
		if(this.finishDate == null)
			return "Devam ediyor";
		return this.finishDate.toString();
	}
}
