package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="email_activation_codes")
@NoArgsConstructor
@AllArgsConstructor
public class EmailActivationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	int userId;
	
	@Column(name="code")
	String code;
	
	@Column(name="is_activated")
	boolean isActivated;
	
	@Column(name="created_at")
	LocalDate createdAt = LocalDate.now();
	
}
