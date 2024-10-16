import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class CSVWriter {

    public static void writeEmployeesToCSV(List<Employee> employees, String filename)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write("id,name,salary,position,department,hourly_rate");
            writer.newLine();
            for(Employee employee : employees)
            {
                writer.write(String.format("%d,%s,%.2f,%s,%s,%.2f", employee.getId(), employee.getName(),
                        employee.getSalary(), employee.getPosition(), employee.getDepartment(),
                        employee.getHourly_rate()));
                writer.newLine();
            }
        }catch(Exception e)
        {
            System.out.println("Error in writing file : "+e.getMessage());
        }
    }
}
