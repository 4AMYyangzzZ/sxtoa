import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Test2> test2Class = Test2.class;
        Test2 test2 = test2Class.newInstance();
        Field person = test2Class.getDeclaredField("person");
        person.set(test2,new Person(1,"zhangsan","男"));
        Method getPerson = test2Class.getDeclaredMethod("getPerson");
        System.out.println(person.get(test2));
        System.out.println(getPerson.invoke(test2));
    }
}
