import com.bridgelabs.service.UserRegistrationValidator;
import com.bridgelabs.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest
{
    UserRegistrationValidator registration;

    @Before
    public void setUp() throws Exception {
        UserService userService =new UserService();
    }

    @Test
    public void givenFirstName_whenProper_ReturnTrue() {
        UserRegistrationValidator registration=new UserRegistrationValidator();
        boolean result = registration.validateInput("Mounika",UserRegistrationValidator.ValidatePattern.NAME);
        Assert.assertTrue(result);
    }
    @Test
    public void givenLastName_whenProper_ReturnTrue() {
        UserRegistrationValidator registration=new UserRegistrationValidator();
        boolean result = registration.validateInput("Chiluveri",UserRegistrationValidator.ValidatePattern.NAME);
        Assert.assertTrue(result);
    }
}