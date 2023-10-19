package nl.miwnn.se2.seyma.AirlineCompany.Demo.model;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Employees can work in one or more companies
 */
@Entity
@Getter @Setter
public class Employee {
    @Id @GeneratedValue
    private Long employeeId;

    @Column(nullable = false) private String firstName;
    private String infixName;
    @Column(nullable = false) private String lastName;

    public String getDisplayName(){ //Display name
        String displayName = firstName;

        if(infixName != null && !infixName.equals("")){
            displayName += " " + infixName;

        }
        displayName += " " + lastName;

        return displayName;


    }







}
