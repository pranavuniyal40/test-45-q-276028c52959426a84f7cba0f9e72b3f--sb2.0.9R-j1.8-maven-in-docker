package org.codejudge.sb.ServiceImpl;

import java.util.Optional;

import org.codejudge.sb.Dao.LeadRepository;
import org.codejudge.sb.Service.LeadService;
import org.codejudge.sb.entity.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService {


	 @Autowired
	 private LeadRepository leadRepository;
	 
	public void saveLead(Lead lead) {
		// TODO Auto-generated method stub
  leadRepository.save(lead);
	}

	public Lead getLead(Integer employeeId) {
		// TODO Auto-generated method stub
		 Optional<Lead> optEmp = leadRepository.findById(employeeId);
		  return optEmp.get();
	}

	public boolean delete(int emp) {
		// TODO Auto-generated method stub
		 leadRepository.deleteById(emp);
		return true;
	}

	public void updateLead(Lead lead,int id) {
		if(leadRepository.existsById(id)) {
		 leadRepository.save(lead);
		}
		else {
			return ;
		}
		// TODO Auto-generated method stub
		
	}

	public String markLead(Lead lead, String communication) {
		// TODO Auto-generated method stub
		 Lead optEmp = leadRepository.getOne(lead.getId());
		if(optEmp.getStatus().equals("created")) {
			optEmp.setStatus("Contacted");
		}
		
		return optEmp.getStatus()+" "+communication;
	}

}
