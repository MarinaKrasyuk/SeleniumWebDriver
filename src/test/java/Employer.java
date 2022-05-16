public class Employer {
    private String name;
    private String position;
    private String office;


    private String age;
    private String startDate;
    private String salary;


    public void setPosition(String position) {
        this.position = position;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setName(String name){
        this.name=name;

    }

    public String getPosition() {
        return position;
    }

    public String getOffice() {
        return office;
    }

    public String getAge() {
        return age;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
    public void println(){
        System.out.println(this.getName()+"  "+ this.getPosition()+"  "+ this.getOffice()+"  "+this.getAge()+" "+this.getSalary()+"   "+this.getStartDate());
    }

}
