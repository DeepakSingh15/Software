import java.io.Serializable;

public class Student implements Serializable {
    String firstName;
    String lastName;
    String rollNo;
    String marks;
    String grade;

    public Student(String firstName,String lastName,String rollNo,String marks,String grade){
        this.firstName=firstName;
        this.lastName=lastName;
        this.rollNo=rollNo;
        this.marks=marks;
        this.grade=grade;
    }

    @Override
    public String toString(){
        return firstName+","+lastName+","+rollNo+","+marks+","+grade+"/";
    }

}
