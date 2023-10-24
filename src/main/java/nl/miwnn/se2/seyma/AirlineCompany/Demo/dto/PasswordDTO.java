package nl.miwnn.se2.seyma.AirlineCompany.Demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * information needed to change a password
 */
@Getter @Setter
public class PasswordDTO {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;


}
