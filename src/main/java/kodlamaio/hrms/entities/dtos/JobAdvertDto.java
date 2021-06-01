package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertDto {

	private int id;
	String companyName;
	String jobPositionName;
	int openPositionAmount;
	LocalDate createdAt;
	LocalDate applicationDeadline;
}
