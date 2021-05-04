import java.io.*;
import java.util.*;

public class Person implements Serializable {
    private transient int age;
    private String name;
    private String surname;
    private int id;
    private String salary; // Десятичные дробные числа
    private String passport; // Строки с фиксированной длиной (10 символов)
    private String address; // Строки с переменной длиной (до 200 символов)
    private String dateOfBirthday; // Дата
    private String dateTimeCreate; // Дата и время
    private String timeToLunch; // Время
    private String letter; // Текст большого объёма


    int x = 15;
    int y = 30;

    int x1 = 0;
    int y1 = 9;


    public Person(List<String> nameList, List<String> surnameList) {
        this.age = this.x + (int) (Math.random() * ((this.y - this.x) + 1));
        this.name = nameList.get(this.x1 + (int) (Math.random() * ((this.y1 - this.x1) + 1)));
        this.surname = surnameList.get(this.x1 + (int) (Math.random() * ((this.y1 - this.x1) + 1)));
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(String dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public String getTimeToLunch() {
        return timeToLunch;
    }

    public void setTimeToLunch(String timeToLunch) {
        this.timeToLunch = timeToLunch;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surname);
    }

    public static Comparator<Person> sortPerson() {
        Comparator<Person> comparator = Comparator.comparing(obj -> obj.getSurname());
        comparator = comparator.thenComparing(obj -> obj.getName());
        return comparator;
    }

    public static void saveFile(HashSet<Person> hashSetListPerson) throws IOException {
        FileWriter fileWriter = new FileWriter("D://test.txt", false);
        for (Person p : hashSetListPerson) {
            fileWriter.write(p.toString());
            fileWriter.append('\n');
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static void readFile() throws IOException {
        FileReader fileReader = new FileReader("D://test.txt");
        StringBuilder builder = new StringBuilder();
        int c;
        while ((c = fileReader.read()) != -1) {
            builder.append((char) c);
        }
        System.out.println(builder.toString());
        fileReader.close();
    }

    public static void SerDesFile(HashSet<Person> hashSetListPerson) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.out"));
        for (Person p : hashSetListPerson) {
            objectOutputStream.writeObject(p);
        }
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.out"));
        List<Person> list1 = new ArrayList<>();
        for (int i = 1; i <= hashSetListPerson.size(); i++) {
            Person person = (Person) objectInputStream.readObject();
            list1.add(person);
        }
        objectInputStream.close();

        System.out.println("###################################");
        for (Person p : list1) {
            System.out.println(p);
        }
    }

    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder withName(String name) {
            newPerson.name = name;
            return this;
        }

        public Builder withSalary(String salary) {
            newPerson.salary = salary;
            return this;
        }

        public Builder withTimeToLunch(String timeToLunch) {
            newPerson.timeToLunch = timeToLunch;
            return this;
        }

        public Builder withPassport(String passport) {
            newPerson.passport = passport;
            return this;
        }

        public Builder withLetter(String letter) {
            newPerson.letter = letter;
            return this;
        }

        public Builder withDateOfBirthday(String dateOfBirthday) {
            newPerson.dateOfBirthday = dateOfBirthday;
            return this;
        }

        public Builder withAddress(String address) {
            newPerson.address = address;
            return this;
        }

        public Builder withId(int id) {
            newPerson.id = id;
            return this;
        }

        //....

        public Person build() {
            return newPerson;
        }
    }

}
