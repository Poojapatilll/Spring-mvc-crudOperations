package mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import mvc.dto.Employee;

@Repository
public class EmployeeDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("m5");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();

	public void save(Employee employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

	public List<Employee> fetchAll() {
		return manager.createNativeQuery("select * from employee",Employee.class).getResultList();
	}

	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		transaction.begin();
		manager.remove(employee);
		transaction.commit();
		
	}

	public Employee find(int id) {
		return manager.find(Employee.class, id);
	}

}
