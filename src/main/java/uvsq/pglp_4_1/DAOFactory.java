package uvsq.pglp_4_1;

public class DAOFactory {
	/*public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelSerialDAO();
	}*/
	
	public DAO<CompositePersonnels> getPersonnelGroupeDAO() {
		return new CompositePersonnelSerialDAO();
	}

}
