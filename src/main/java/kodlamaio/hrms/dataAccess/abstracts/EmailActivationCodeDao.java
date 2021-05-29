package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmailActivationCode;

public interface EmailActivationCodeDao extends JpaRepository<EmailActivationCode, Integer>{

}
