import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Employee> readEmployeesFromCSV(String filename)
    {
        List<Employee> employees = new ArrayList<Employee>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line = null;
            reader.readLine();  //Skip the header while creating objects
            while((line = reader.readLine()) != null)
            {
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double salary = Double.parseDouble(tokens[2]);
                String position = tokens[3];
                String department = tokens[4];
                double hourly_rate = Double.parseDouble(tokens[5]);

                Employee employee = new Employee(id, name, salary, position,
                        department, hourly_rate);

                //add the object to list
                employees.add(employee);
            }
        }catch(IOException e)
        {
            System.out.println("Error reading file : "+e.getMessage());
        }
        return employees;
    }
}
