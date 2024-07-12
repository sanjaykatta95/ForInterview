package reputation;

class A {

    // in the beginning the class A was given as static - which is wrong
    //External classes can't be static
    //only the member variables,functions and nested classes can be static

    public int getA() {
        return 10;
    }

    //Also I sad that the below method gives compilation error - which is correct

    /*public Integer getA() {
        return 11;
    }*/

    // Later the interviewer add the parameter - which makes it an overloaded method which is fine - no compilation error
    public Integer getA(int a) {
        return 11;
    }

}


class B extends A {

    public int getA() {
        return 12;
    }

    public Integer getA(int a) {
        return 13;
    }

}


public class Reputation {
    public static void main(String[] args) {
        A a = new A();
        A a1 = new B();
        B b = new B();
        // The below line would give a compilation error as the child class variable can't hold
        // the parent class object
//        B b1 = new A();

//        I have suggested the following outputs
//        System.out.println(b1.getA()); -- 10-- 12
        System.out.println(a.getA());
        ; //-- 10-- 10
        System.out.println(a1.getA()); //-- 12-- 10
        System.out.println(b.getA()); // -- 12-- 12


    }

}