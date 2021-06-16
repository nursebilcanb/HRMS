package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertDto(id, employer.companyName, jobPosition.jobName, openPositionAmount, createdAt, applicationDeadline) from JobAdvert where isActivated = :activityStatus")
	List<JobAdvertDto> dtoGetJobAdvertsByIsActivatedIs(@Param("activityStatus") boolean activityStatus);
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertDto(id, employer.companyName, jobPosition.jobName, openPositionAmount, createdAt, applicationDeadline) from JobAdvert where employer.id = :employerId ")
	List<JobAdvertDto> dtoGetAllActiveAdvertsByEmployerId(@Param("employerId") int employerId);
}
