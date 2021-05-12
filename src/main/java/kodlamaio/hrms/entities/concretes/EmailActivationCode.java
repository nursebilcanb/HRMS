package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="email_activation_codes")
public class EmailActivationCode {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	int userId;
	
	@Column(name="code")
	String code;
	
	@Column(name="is_activated")
	Boolean isActivated;
	
	@Column(name="created_at")
	Date createdAt;
	
}
