import com.bridgelabs.dao.UserRegistratioDAOImplDB;
import com.bridgelabs.model.Person;
import com.bridgelabs.utility.PersonInputOutput;
import com.bridgelabs.utility.UserInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {
    PersonInputOutput personInputOutput;

    @Before
    public void setUp() throws Exception {
        new PersonInputOutput();
    }

    @Test
    public void givenValidUser_WhenRegister_ShouldReturnSuccessMessage() {
        Person person = new Person("Mounika", "Chiluveri", "2A@sdfghj", "chiluveri.mounika@gmail.com", "9985241801");
        String mess = personInputOutput.validateField(person);
        Assert.assertEquals("Successfull", mess);
    }
}

