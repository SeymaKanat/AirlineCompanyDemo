package nl.miwnn.se2.seyma.AirlineCompany.Demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
@Entity
@Getter @Setter
public class Airplane {
    @Id @GeneratedValue
    private Long id;
    private Boolean available = true;
    private String model;

    @ManyToOne // Relationship ekledik many = airplane one=company
    private Company company;


}
