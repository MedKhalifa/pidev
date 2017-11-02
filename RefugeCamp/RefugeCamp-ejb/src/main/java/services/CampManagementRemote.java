package services;

import java.util.List;
import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import persistence.Camp;
import persistence.Refugee;

@Remote
@WebService
public interface CampManagementRemote {
	
	@WebMethod(operationName="addCamp")
    @WebResult(name="adding")
	void addCamp(@WebParam(name="CampObj") Camp camp);

	@WebMethod(operationName="updateCamp")
    @WebResult( name="Updating")
	void updateCamp(@WebParam(name="CampObj") Camp camp);

	@WebMethod(operationName="deleteCampById")
    @WebResult(name="deletingCampId")
	void deleteCampById(@WebParam(name="CampId")int id);

	@WebMethod(operationName="deleteCamp")
    @WebResult(name="deletingCamp")
	void deleteCamp(@WebParam(name="CampOjbe")Camp camp);

	@WebMethod(operationName="findCampById")
    @WebResult(name="CampId")
	Camp findCampById(@WebParam(name="Id")int id);
	
	@WebMethod(operationName="findCampByNameAndLocation")
    @WebResult(name="CampNameLocation")
	List<Camp> findCampByNameAndLocation(@WebParam(name="Name")String name);

	@WebMethod(operationName="findAllCamps")
    @WebResult(name="ListCamps")
	List<Camp> findAllCamps();
	
	@WebMethod(operationName="findRefugies")
    @WebResult(name="findRefugees")
	public List<Refugee> findRefugies(@WebParam(name="CampId")int campid);

}
