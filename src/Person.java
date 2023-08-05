import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private int personId;
    private String personName;
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonAddress(List<String> personAddress) {
        this.personAddress = personAddress;
    }

    private List<String> personAddress;
     private static final List<Person> listOfPerson = new LinkedList<>();
    static void addPerson(Person p){
        listOfPerson.add(p);
    }
    Person getPersonById(int id){
        for(Person p : listOfPerson) {
            if(p.getPersonId() == id) return p;
        }
        return null;
    }
    static List<Person> getPersonsByAddress(String address){
        List<Person> ans = new ArrayList<>();
        for(Person p: listOfPerson){
            if(p.personAddress.contains(address)) ans.add(p);
        }
        return ans;
    }
    public String toString(){
        return "PersonId = "+personId+", person name = "+personName+", Addresses of person: "+personAddress;
    }
    public static void main(String[] args) {
        Person p = new Person();
        p.setPersonId(1);
        p.setPersonName("A");
        List<String> address = new ArrayList<>();
        address.add("Pune");
        address.add("Mumbai");
        p.setPersonAddress(address);
        Person p2 = new Person();
        p2.setPersonId(2);
        p2.setPersonName("B");
        List<String> address2 = new ArrayList<>();

        address2.add("Nashik");
        address2.add("Pune");
        p2.setPersonAddress(address2);

        Person p3 = new Person();
        p3.setPersonId(3);
        p3.setPersonName("C");
        List<String> address3 = new ArrayList<>();
        address3.add("Hyderabad");
        address3.add("Bangalore");
        p3.setPersonAddress(address3);

        Person.addPerson(p);
        Person.addPerson(p2);
        Person.addPerson(p3);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter person id: ");
        int id = sc.nextInt();

        System.out.println(p.getPersonById(id));
        System.out.println("Enter the city name to see all persons from that city: "); sc.nextLine();
        String city = sc.nextLine();
        List<Person> pr = Person.getPersonsByAddress(city);
        for(Person person: pr) System.out.println(person);
    }
}
