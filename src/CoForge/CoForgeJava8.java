package CoForge;

import java.util.ArrayList;
import java.util.List;

class Employee {
    int id;
    String name;
    String dept;

    public Employee(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "CoForge.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}

public class CoForgeJava8 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.sort((a,b)->{
            if(a.dept.equals(b.dept)){
                return a.name.compareTo(b.name);
            }
            return a.dept.compareTo(b.dept);
        });
        int n = employees.size();
        for(int i=0;i<Math.min(5,n);i++){
            System.out.println(employees.get(i));
        }


        employees.stream().limit(5).forEach(System.out::println);
    }

}
