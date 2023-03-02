import java.util.List;

public class Person {
	private String _id;
	private String name;
	private int age;
	private List<String> emails;
	private List<Address> addresses;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void addAddress(Address address){
		addresses.add(address);
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getEmails() {
		return emails;
	}


	public void setEmails(List<String> emails) {
		this.emails = emails;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public String get_id() {
		return _id;
	}

	
	

}
