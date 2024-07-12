import validation.CronValidator;

import java.util.Map;

public class Main {
    /**
     * minute       0, 15, 30, 45
     * hour          0
     * day of month  1 2 3 15
     * month         1 2 3 4 5 6 7 8 9 10 11 12
     * day of week   1 2 3 4
     */
    public static void main(String[] args) {

        CronValidator validator = new CronValidator();
        validator.validateCronExpression("*/15 0 1,2,3,15 * 1-4");

    }
}