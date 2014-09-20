package de.cofinpro.codingdojo.server;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import de.cofinpro.codingdojo.server.api.*;

public class ApprovalServiceImpl implements ApprovalService {
	
	@EJB
	private ApprovalDao approvalDao;
	
	@Inject
	private ElectionService electionService;
	
	@Override
	public List getRequests(Long electionId) {
		Election election = electionService.getElection(electionId);
		return approvalDao.getApprovalsByStatus(ApprovalStatus.BEANTRAGT, election);
	}

	@Override
	public void approve(Long approvalId) {
		Approval approval = approvalDao.getApproval(approvalId);
		approval.setStatus(ApprovalStatus.ZUGELASSEN);
		approvalDao.update(approval);
	}

	@Override
	public void reject(Long approvalId) {
		Approval approval = approvalDao.getApproval(approvalId);
		approval.setStatus(ApprovalStatus.ABGELEHNT);
		approvalDao.update(approval);
	}

}
