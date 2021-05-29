package kodlamaio.hrms.adapters;


import java.rmi.RemoteException;
import java.time.ZoneId;

import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
		
		boolean result = false;
		
		try {
			result = kpsPublic.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalityId()),
				    candidate.getFirstName().toUpperCase(),
					candidate.getLastName().toUpperCase(),
					candidate.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear());

			
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		
		return result;
	}

}
