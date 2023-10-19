package nl.miwnn.se2.seyma.AirlineCompany.Demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
@Entity
@Getter @Setter
public class Company {
    @Id @GeneratedValue
    private Long  companyId;
    @Column(unique = true)
    private String companyName;
    private String location;

    @OneToMany(mappedBy = "company")
    private List<Airplane> airplanes;

    public int getNumberOfAvailableAirplanes(){
        int count = 0;

        for (Airplane airplane : airplanes){
            if (airplane.getAvailable()){
                count++;
            }
        }
        return count;
    }

}
