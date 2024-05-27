
import controlador.*;
import vista.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends JFrame{




    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        new LoginFormControlador(new LoginForm());
    }

}
