import UserServiceImplPack.SecurityService;
import UserServiceImplPack.User;
import UserServiceImplPack.UserDAO;
import UserServiceImplPack.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceImpITest {
    User user = Mockito.mock(User.class);

    UserDAO userDAO = Mockito.mock(UserDAO.class);
    SecurityService securityService = Mockito.mock(SecurityService.class);

    @Test
    public void testAssignPassword() throws Exception {
        //prepared SUT
        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);
        user.getPassword();
        Mockito.when(user.getPassword()).thenReturn("1234");
        Mockito.when(userDAO.updateUser(user)).thenReturn("71190506");

        System.out.println(user.getPassword());
//        System.out.println(userDAO.updateUser(user));

        sut.assignPassword(user);

        Mockito.verify(userDAO).updateUser(user);


    }

}
