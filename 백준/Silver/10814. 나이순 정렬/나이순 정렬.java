import java.io.*;
import java.util.*;

class Customer {
    int age;
    String name;

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
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
}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Customer> list = new ArrayList<>();

        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Customer(age, name));
        }

        list.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer m1, Customer m2) {
                return m1.age - m2.age;
            }
        });


        StringBuilder sb = new StringBuilder();
        for (Customer m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);

    }
}