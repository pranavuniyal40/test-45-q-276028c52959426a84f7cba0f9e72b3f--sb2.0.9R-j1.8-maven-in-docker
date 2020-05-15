/**
 * 
 */

/**
 * @author SuperAdmin
 *
 */
package org.codejudge.sb.Service;

import org.codejudge.sb.entity.Lead;

public interface LeadService {
	 public void saveLead(Lead lead);
	 public Lead getLead(Integer employeeId);
	public boolean delete(int id);
	public void updateLead(Lead lead, int id);
	public String markLead(Lead lead, String communication);
}
