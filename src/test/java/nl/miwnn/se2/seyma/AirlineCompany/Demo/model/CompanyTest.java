package nl.miwnn.se2.seyma.AirlineCompany.Demo.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Test units from the Company class
 */
class CompanyTest {

    @Test
    void getNumberOfAvailableAirplanesAllAvailable() {
        //Arrange
        Company company = new Company("test company");


        Airplane airplane1 = new Airplane(company);
        Airplane airplane2 = new Airplane(company);
        Airplane airplane3 = new Airplane(company);

        Set<Airplane> airplanes = new HashSet<>();
        airplanes.add(airplane1);
        airplanes.add(airplane2);
        airplanes.add(airplane3);

        company.setAirplanes(airplanes);

        int expectedAvailableAirplanes = 3;


        //Act
        int actualAvailableAirplanes = company.getNumberOfAvailableAirplanes();

        //Assert
        assertEquals(expectedAvailableAirplanes, actualAvailableAirplanes);

    }
    @Test
    void getNumberOfAvailableAirplanesNoneAvailable() {
        //Arrange
        Company company = new Company("test company");


        Airplane airplane1 = new Airplane(company);
        airplane1.setAvailable(false);
        Airplane airplane2 = new Airplane(company);
        Airplane airplane3 = new Airplane(company);
        airplane3.setAvailable(false);

        Set<Airplane> airplanes = new HashSet<>();
        airplanes.add(airplane1);
        airplanes.add(airplane2);
        airplane2.setAvailable(false);
        airplanes.add(airplane3);

        company.setAirplanes(airplanes);

        int expectedAvailableAirplanes = 0;


        //Act
        int actualAvailableAirplanes = company.getNumberOfAvailableAirplanes();

        //Assert
        assertEquals(expectedAvailableAirplanes, actualAvailableAirplanes);

    }
    @Test
    void getNumberOfAvailableAirplanesSomeAvailable() {
        //Arrange
        Company company = new Company("test company");


        Airplane airplane1 = new Airplane(company);
        Airplane airplane2 = new Airplane(company);
        airplane2.setAvailable(false);
        Airplane airplane3 = new Airplane(company);

        Set<Airplane> airplanes = new HashSet<>();
        airplanes.add(airplane1);
        airplanes.add(airplane2);
        airplanes.add(airplane3);

        company.setAirplanes(airplanes);

        int expectedAvailableAirplanes = 2;


        //Act
        int actualAvailableAirplanes = company.getNumberOfAvailableAirplanes();

        //Assert
        assertEquals(expectedAvailableAirplanes, actualAvailableAirplanes);

    }
    @Test
    void getNumberOfAvailableAirplanesWhenCompanyHasNoAirplanes() {
        //Arrange
        Company company = new Company("test company");


        int expectedAvailableAirplanes = 0;


        //Act
        int actualAvailableAirplanes = company.getNumberOfAvailableAirplanes();

        //Assert
        assertEquals(expectedAvailableAirplanes, actualAvailableAirplanes);

    }
}