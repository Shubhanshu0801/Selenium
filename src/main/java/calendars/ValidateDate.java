package calendars;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateDate {
    public static void main(String[] args) throws Exception {
        String targetDate = "30-02-2023";
        //Format the String into Date format same as the pattern passed as the parameters.
        SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedTargetDate;
        try {
            //setLenient(true) parse "30-02-2023" as "02-03-2023(02 march)"
            targetDateFormat.setLenient(false);
            formattedTargetDate = targetDateFormat.parse(targetDate);
            System.out.println(formattedTargetDate);
        }
        catch(Exception e) {
            throw new Exception("Invalid date, please enter a valid date");
        }
    }
}
