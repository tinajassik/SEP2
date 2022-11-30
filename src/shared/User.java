package shared;

import java.io.Serializable;

public interface User extends Serializable {
    String getFullName();
    String getAddress();
    String getPhoneNumber();
    String getEmail();
    String getPassword();
    String getUsername();

    void setFullName(String fullName);
    void setAddress(String address);
    void setPhoneNumber(String phoneNumber);
    void setEmail(String email);
    void setPassword(String password);
    void setUsername(String username);


}
