package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Background;

public interface BackgroundDao extends JpaRepository<Background, Integer> {
	List<Background> getByCandidateId(int candidateId);
}
