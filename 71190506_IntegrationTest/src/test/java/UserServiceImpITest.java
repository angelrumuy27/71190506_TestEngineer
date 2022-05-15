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
    public void testGetNewPass() throws Exception {
        //prepared SUT
        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);
//        user.getPassword();
//        Mockito.when(user.getPassword()).thenReturn("1234");
//        System.out.println(user.getPassword());
        sut.assignPassword(user);
        Mockito.verify(user).getPassword();


    }

    @Test
    public void testUpdateUser() throws Exception {
        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);
//        Mockito.when(userDAO.updateUser(user)).thenReturn("71190506");
//        System.out.println(userDAO.updateUser(user));
//        userDAO.updateUser(user);
        sut.assignPassword(user);
        Mockito.verify(userDAO).updateUser(user);


    }

}
