package nl.miwnn.se2.seyma.AirlineCompany.Demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
@Entity
@Getter @Setter
public class Company {
    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company() {

    }

    @Id @GeneratedValue
    private Long  companyId;

    @Column(unique = true)
    private String companyName;

    private String location;

    @ManyToMany
    private Set<Employee> employees = new HashSet<>();


    @OneToMany(mappedBy = "company")
    private Set<Airplane> airplanes;

    public void  addEmployee(Employee employee){
        employees.add(employee);
    }

    public int getNumberOfAvailableAirplanes(){
        int count = 0;

        for (Airplane airplane : airplanes){
            if (airplane.getAvailable()){
                count++;
            }
        }
        return count;
    }

    public String getAllEmployeesDisplayString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Employee employee : employees) {
            stringBuilder.append(employee.getDisplayName()).append(", ");
        }

        return stringBuilder.toString();
    }

}
