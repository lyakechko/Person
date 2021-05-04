import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public App() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//
//        //1.Создание пользователей
//        CreateNameSurname createNameSurname = new CreateNameSurname();
//        List<Person> list = new ArrayList<>();
//        for (int i = 0; i <= 100; i++) {
//            list.add(new Person(createNameSurname.getListName(), createNameSurname.getListSurName()));
//        }
//
//        //2.Сортировка меньше 21 возраст и печать на экран
//        list.stream().filter(e -> e.getAge() < 21).forEach(e -> System.out.println(e));
//
//        //3.Сортировка меньше 21 возраст и печать на экран
//        Collections.sort(list, Person.sortPerson());
//
//        //4.Убираем дубли
//        HashSet<Person> hashSetListPerson = new HashSet<>(list);
//
//        //5.Сохраняем в файл
//        Person.saveFile(hashSetListPerson);
//
//        //6.Читаем файл
//        Person.readFile();
//
//
//        //7.Сериализация и дессериализация
//        //8.Вывод на экран
//        Person.SerDesFile(hashSetListPerson);
        CreateNameSurname createNameSurname = new CreateNameSurname();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=UTC", "root",
                    "Kechko194@");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        statement = conn.createStatement();
        List<Person> list1 = createNameSurname.createPersons();
        for (Person person : list1) {
            String sql = "INSERT INTO person(age,address,dateOfBirthday,dateTimeCreate,letter,passport,salary,timeToLunch) VALUES(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, person.getAge());
            ps.setString(2, person.getAddress());
            ps.setString(3, person.getDateOfBirthday());
            ps.setString(4, person.getDateTimeCreate());
            ps.setString(5, person.getLetter());
            ps.setString(6, person.getPassport());
            ps.setString(7, person.getSalary());
            ps.setString(8, person.getTimeToLunch());
            statement.executeUpdate(sql);
        }
    }
}

