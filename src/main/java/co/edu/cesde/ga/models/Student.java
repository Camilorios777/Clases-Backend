package co.edu.cesde.ga.models;

public class Student extends  Person{
    private String birthDate;

    public Student(){
        super();
    }

    public Student(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, String birthDate) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;


    }
    @Override
    public String toString(){
        return "Student = " + super.toString() +
                "birthDate'" + birthDate + '\'';
    }
}

