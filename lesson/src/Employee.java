public class Employee {
    //data members
    private int id;
    private String name;  
    private Address address;
    public Employee() {
        this.id = 0;
        this.name = "unknown";
    }
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void display(){
        System.out.println("ID: " + id + " Name: " + name + " Address: " + address.getCity() + " " + address.getCountry());
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
    


    
    
}
