package Freshworks;

import Freshworks.exceptions.ValidationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CronValidator {

    String[] timeComponents = {"minutes", "hour", "dayOfTheMonth", "month", "dayOfTheWeek"};

    public boolean validateCronExpression(String cronExpression) {
        cronExpression.trim();
        String[] units = cronExpression.split("\\s+");
        int n = units.length;
        if (n == 0) {
            throw new ValidationException("Cron expression should not be empty");
        }
        /**
         * minute       0, 15, 30, 45
         *   hour          0
         *   day of month  1 2 3 15
         *   month         1 2 3 4 5 6 7 8 9 10 11 12
         *   day of week   1 2 3 4
         * */

        Map<String, Set<Integer>> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            basicValidations(units[i]);

            if (i == 0) {
                //Minute validator
//                validateMinutes(cronExpression, 0, 60);
                Set<Integer> set = parseString(units[i], 0, 60);
                result.put(timeComponents[i], set);
            } else if (i == 1) {
                //Hour validator
//                validateHours(cronExpression);
                Set<Integer> set = parseString(units[i], 0, 23);
                result.put(timeComponents[i], set);
            } else if (i == 2) {
                // Day of the month validator
//                validateDayOfMonth(cronExpression);
                Set<Integer> set = parseString(units[i], 1, 31);
                result.put(timeComponents[i], set);
            } else if (i == 3) {
                // Month validator
//                validateMonth(cronExpression);
                Set<Integer> set = parseString(units[i], 1, 12);
                result.put(timeComponents[i], set);
            } else if (i == 4) {
                //day of the week validator
//                validateDayOfTheWeek(cronExpression);
                Set<Integer> set = parseString(units[i], 1, 7);
                result.put(timeComponents[i], set);
            } else if (i == 5) {
                //Seconds validator
//                validateSeconds(cronExpression);
                Set<Integer> set = parseString(units[i], 0, 60);
                result.put(timeComponents[i], set);
            }


        }

        for (Map.Entry<String, Set<Integer>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return true;

    }

    private boolean isCommaSeparated(String cronExpression) {
        return cronExpression.split(",").length > 1;
    }

    public Set<Integer> parseString(String cronExpression, int start, int end) {
        boolean isCommaSeparated = isCommaSeparated(cronExpression);
        TreeSet<Integer> set = new TreeSet<>();
        if (isCommaSeparated) {
            System.out.println(cronExpression);
            for (String s : cronExpression.split(",")) {
                set.add(Integer.valueOf(s));
            }
            return set;
        } else if (cronExpression.startsWith("*/")) {
            System.out.println(cronExpression);
            int interval = 0;
            for (int i = 2; i < cronExpression.length(); i++) {
                interval = interval * 10 + Integer.valueOf(cronExpression.charAt(i)-'0');
            }
            System.out.println(interval);
            for (int i = start; i <= end; i += interval) {
                System.out.println(i);
                set.add(i);
            }
        } else if (cronExpression.split("-").length > 1) {
            System.out.println(cronExpression);
            int leftBoundary = Integer.valueOf(cronExpression.charAt(0)-'0');
            int rightBoundary = Integer.valueOf(cronExpression.charAt(1)-'0');
            for (int i = leftBoundary; i <= rightBoundary; i++) {
                set.add(i);
            }
        } else if ((cronExpression.length() == 1) && cronExpression.charAt(0) == '*') {
            for (int i = start; i <= end; i++) {
                set.add(i);
            }
        } else {
            System.out.println(cronExpression);
            set.add(Integer.valueOf(cronExpression));
        }
        return set;
    }

    public boolean basicValidations(String cronExpression) {
        return true;

        //Specific Validations

    }


}
