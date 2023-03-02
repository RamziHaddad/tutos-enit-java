import java.util.List;
import java.util.Optional;

public interface PersonsDAO {
	
	void removeAll();
	List<Person> findAll();
	Optional<Person> findById();
	void save(Person p);
	List<Person> findByName(String name);
	List<Person> findByCity(String city);
	List<Person> findByAgeBetween(int min,int max);
	void removeById(String id);
	void update(Person p);


}
