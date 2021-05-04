import java.util.ArrayList;
import java.util.List;

public class CreateNameSurname {
    List<String> listName = new ArrayList<>();
    List<String> listSurName = new ArrayList<>();

    public List<String> getListSurName() {
        listName.add("Имя1");
        listName.add("Имя2");
        listName.add("Имя3");
        listName.add("Имя4");
        listName.add("Имя5");
        listName.add("Имя5");
        listName.add("Имя7");
        listName.add("Имя8");
        listName.add("Имя9");
        listName.add("Имя10");
        return listSurName;
    }

    public List<String> getListName() {
        listSurName.add("Фамилия1");
        listSurName.add("Фамилия2");
        listSurName.add("Фамилия3");
        listSurName.add("Фамилия4");
        listSurName.add("Фамилия5");
        listSurName.add("Фамилия6");
        listSurName.add("Фамилия7");
        listSurName.add("Фамилия8");
        listSurName.add("Фамилия9");
        listSurName.add("Фамилия10");
        return listName;
    }

    public List<Person> createPersons() {
        List<Person> list = new ArrayList<>();

        Person person1 = new Person.Builder()
                .withName("Илья")
                .withAddress("Кирова 6")
                .withPassport("1111111111")
                .withDateOfBirthday("22.11.1994")
                .withSalary("")
                .withLetter("Текст")
                .withTimeToLunch(String.valueOf(System
                        .currentTimeMillis())).build();

        Person person2 = new Person.Builder()
                .withName("Илья")
                .withAddress("Кирова 6")
                .withPassport("1111111111")
                .withDateOfBirthday("22.11.1994")
                .withSalary("")
                .withLetter("Текст")
                .withTimeToLunch(String.valueOf(System
                        .currentTimeMillis())).build();


        Person person3 = new Person.Builder()
                .withName("Илья")
                .withAddress("Кирова 6")
                .withPassport("1111111111")
                .withDateOfBirthday("22.11.1994")
                .withSalary("")
                .withLetter("Текст")
                .withTimeToLunch(String.valueOf(System
                        .currentTimeMillis())).build();

        Person person4 = new Person.Builder()
                .withName("Илья")
                .withAddress("Кирова 6")
                .withPassport("1111111111")
                .withDateOfBirthday("22.11.1994")
                .withSalary("")
                .withLetter("Текст")
                .withTimeToLunch(String.valueOf(System
                        .currentTimeMillis())).build();


        Person person5 = new Person.Builder()
                .withName("Илья")
                .withAddress("Кирова 6")
                .withPassport("1111111111")
                .withDateOfBirthday("22.11.1994")
                .withSalary("")
                .withLetter("Текст")
                .withTimeToLunch(String.valueOf(System
                        .currentTimeMillis())).build();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        return list;
    }
}
