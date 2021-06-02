package kodlamaio.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackgroundAddDto {

	private int candidateId;
	String imageUrl;
	String github;
	String linkedin;
	String coverLetter;
	List<Integer> schoolIds;
	List<Integer> jobExperienceIds;
	List<Integer> foreignLanguageIds;
	List<Integer> programmingLanguageIds;	
	
}
