package de.cofinpro.codingdojo.server;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import de.cofinpro.codingdojo.server.api.Approval;
import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.ApprovalStatus;

@Stateless
@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
public class ApprovalDao {
	
	 @PersistenceContext(unitName = "codingdojo")
	    private EntityManager entityManager;

	    public Long create(Approval approval) {
	        entityManager.persist(approval);
	        entityManager.flush();
	        return approval.getId();
	    }

	    public Approval update(Approval approval) {
	        return entityManager.merge(approval);
	    }

	    public void delete(Approval approval) {
	        entityManager.remove(approval);
	    }

	    public List<Approval> getApprovals() {
	        Query query = entityManager.createQuery("SELECT a from Approval as a");
	        return query.getResultList();
	    }
	    
	    public List<Approval> getApprovalsByStatus(ApprovalStatus status, Election election) {
	    	TypedQuery query = entityManager.createNamedQuery("Approval.findByStatus", Approval.class);
	    	query.setParameter("status", status);
	    	query.setParameter("election", election);
	        return query.getResultList();
	    }

	    public Approval getApproval(Long approvalId) {
	        return entityManager.find(Approval.class, approvalId);
	    }
}
