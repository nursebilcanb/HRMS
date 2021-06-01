package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto(id, employer.companyName, jobPosition.jobName, openPositionAmount, createdAt, applicationDeadline) from JobAdvert where active =: activityStatus")
	List<JobAdvertDto> getAllByActivity(@Param("activityStatus") Boolean activityStatus);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDto(id, employer.companyName, jobPosition.jobName, openPositionAmount, createdAt, applicationDeadline) from JobAdvert where employer.id =: employerId ")
	List<JobAdvertDto> getAllActiveAdvertsByEmployerId(@Param("employerId") int employerId);
}
