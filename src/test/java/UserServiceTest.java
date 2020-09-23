import com.bridgelabs.dao.UserRegistratioDAOImplDB;
import com.bridgelabs.exception.UserValidationException;
import com.bridgelabs.model.User;
import com.bridgelabs.utility.UserInputOutput;
import com.bridgelabs.utility.UserInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {
    UserInputOutput userInputOutput;

    @Before
    public void setUp() throws Exception {
        new UserInputOutput();
    }

    @Test
    public void givenValidUser_WhenRegister_ShouldReturnSuccessMessage() throws UserValidationException {
        User user = new User("Mounika", "Chiluveri", "2A@sdfghj", "chiluveri.mounika@gmail.com", "9985241801");
        String message = userInputOutput.validateField(user);
        Assert.assertEquals("Registration SuccessFul", message);
    }

    @Test
    public void givenFirstNameNotProper_WhenRegister_ShouldThrowException() {
        try {
            User user = new User("mounika", "Chiluveri", "2A@sdfghj", "chiluveri.mounika@gmail.com", "9985241801");
            userInputOutput.validateField(user);
        } catch (UserValidationException e) {
            Assert.assertEquals(UserValidationException.ExceptionType.INVALID_FIRSTNAME, e.exceptionType);
        }
    }

    @Test
    public void givenLastNameNotProper_WhenRegister_ShouldThrowException() {
        try {
            User user = new User("Mounika", "chiluveri", "2A@sdfghj", "chiluveri.mounika@gmail.com", "9985241801");
            userInputOutput.validateField(user);
        } catch (UserValidationException e) {
            Assert.assertEquals(UserValidationException.ExceptionType.INVALID_LASTNAME, e.exceptionType);
        }
    }

    @Test
    public void givenPasswordNotProper_WhenRegister_ShouldThrowException() {
        try {
            User user = new User("Mounika", "Chiluveri", "vbn@sdfghj", "chiluveri.mounika@gmail.com", "9985241801");
            userInputOutput.validateField(user);
        } catch (UserValidationException e) {
            Assert.assertEquals(UserValidationException.ExceptionType.INVALID_PASSWORD, e.exceptionType);
        }
    }
}



