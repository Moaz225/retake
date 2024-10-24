import javax.validation.constraints.NotEmpty;

public class LoginForm {
    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Password is required")
    private String password;

    // Getters and setters...
}
