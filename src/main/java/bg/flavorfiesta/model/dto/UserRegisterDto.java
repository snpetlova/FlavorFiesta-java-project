package bg.flavorfiesta.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {

    @NotNull
    @Size(min=5, max=20, message = "Username should be between 5 and 20 symbols")
    private String username;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;
    @NotNull
    @Size(min=8, max=25, message = "Password should be at least 8 symbols")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRegisterDto() {
    }
}
