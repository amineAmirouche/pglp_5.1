package uvsq.pglp_4_1;

public interface DAO<T> {
	
	/*
	 * CRUD:
	 *  - Create
	 *  - Read
	 *  - Update
	 *  - Delete
	 */
	T create(T obj);
	T read(String id);
	T update(T obj);
	void delete(T obj);

}
