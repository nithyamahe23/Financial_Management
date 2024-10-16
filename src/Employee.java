public class Employee {
    private int id;
    private String name;
    private double salary;
    private String position;
    private String department;
    private double hourly_rate;

    public Employee(int id, String name, double salary,
                    String position, String department, double hourly_rate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.hourly_rate = hourly_rate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public double getHourly_rate() {
        return hourly_rate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", hourly_rate=" + hourly_rate +
                '}';
    }
}
