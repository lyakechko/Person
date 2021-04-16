import java.io.*;
import java.util.*;

public class Person implements Serializable {
    private transient int age;
    private String name;
    int x = 15;
    int y = 30;

    int x1 = 0;
    int y1 = 9;


    public Person(List<String> nameList, List<String> surnameList) {
        this.age = this.x + (int) (Math.random() * ((this.y - this.x) + 1));
        this.name = nameList.get(this.x1 + (int) (Math.random() * ((this.y1 - this.x1) + 1)));
        this.surname = surnameList.get(this.x1 + (int) (Math.random() * ((this.y1 - this.x1) + 1)));
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

    private String surname;

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

}
