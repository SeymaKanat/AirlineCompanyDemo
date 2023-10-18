package nl.miwnn.se2.seyma.AirlineCompany.Demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
@Entity
public class Company {
    @Id @GeneratedValue
    private Long  companyId;
    private String companyName;

    public Long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }
}
