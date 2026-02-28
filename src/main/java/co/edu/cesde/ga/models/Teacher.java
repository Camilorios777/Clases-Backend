package co.edu.cesde.ga.models;

public class Teacher extends Person {
    public Teacher() {
        super();
    }

    public Teacher(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status) {
        super(userId, code, documentNumber, firstName, lastName, status);

    }
    @Override
    public String toString(){
        return "Teacher{} " + super.toString();


    }
}
