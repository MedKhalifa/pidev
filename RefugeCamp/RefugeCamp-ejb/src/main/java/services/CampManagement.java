package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Camp;
import persistence.Refugee;

/**
 * Session Bean implementation class CampManagement
 */
@Stateless
@WebService(name="CampManagementPortype",
portName="CampManagement",
serviceName="CampManagement",
targetNamespace="http://CampManagement.tn",endpointInterface="services.CampManagementRemote"
)
public class CampManagement implements CampManagementRemote, CampManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CampManagement() {
	}

	@Override
	public void addCamp(Camp camp) {
		entityManager.persist(camp);

	}

	@Override
	public void updateCamp(Camp camp) {
		entityManager.merge(camp);
	}

	@Override
	public void deleteCampById(int id) {
		entityManager.remove(findCampById(id));
	}

	@Override
	public void deleteCamp(Camp camp) {
		entityManager.remove(camp);
	}

	@Override
	public Camp findCampById(int id) {
		return entityManager.find(Camp.class, id);
	}
	@Override
	public List<Camp> findCampByNameAndLocation(String name) {
		////String jpql = "SELECT u FROM Camp u WHERE u.name = 'camp'";
		//Query query = entityManager.createQuery(jpql);
		Query query = entityManager.createQuery("SELECT u FROM Camp u where u.name LIKE '%"+name+"%' Or u.location LIKE '%"+name+"%'");		
		
		return query.getResultList();		
	}
	@Override
	public List<Camp> findAllCamps() {
		String jpql = "SELECT u FROM Camp u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	public List<Refugee> findRefugies(int campid) {
		String jpql = "SELECT u FROM Refugee u where u.campId ='"+campid+"'";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	



}
