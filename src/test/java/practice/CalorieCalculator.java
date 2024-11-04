package practice;
import java.util.Scanner;


public class CalorieCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // First Questions
            System.out.println("Goal Based Onboarding Questionnaire (GBOQ) For FitCal App");

            // Age Question
            System.out.println("1. What is your age?");
            System.out.println("1) Under 18");
            System.out.println("2) 18-30");
            System.out.println("3) 31-50");
            System.out.println("4) Over 50");
            int ageGroup = scanner.nextInt();

            // Current Weight Question
            System.out.print("2. What is your current weight (in kg)? ");
            double currentWeight = scanner.nextDouble();

            // Height Question
            System.out.print("3. What is your height (in cm)? ");
            double height = scanner.nextDouble();

            // Gender Question
            System.out.println("4. What is Your Gender?");
            System.out.println("1) Male");
            System.out.println("2) Female");
            int gender = scanner.nextInt();

            // Goal Question
            System.out.println("5. What is Your Goal?");
            System.out.println("1) Lose Fat");
            System.out.println("2) Gain Weight");
            System.out.println("3) Be Healthier");
            int goal = scanner.nextInt();

            // Approach Question
            System.out.println("6. Which approach is gonna be followed?");
            System.out.println("1) Moderate Approach");
            System.out.println("2) Intensive Approach");
            System.out.println("3) Balanced Approach");
            int approach = scanner.nextInt();

            // Follow-up Questions
            // Question 4: Daily Calorie Reduction Aim
            System.out.println("7. How many calories are you aiming to reduce daily?");
            System.out.println("1) Minimal reduction");
            System.out.println("2) Moderate reduction");
            System.out.println("3) Significant reduction");
            int calorieReduction = scanner.nextInt();

            // Question 5: Time to See Results
            System.out.println("8. How soon do you want to see results?");
            System.out.println("1) No rush");
            System.out.println("2) Within 3 months");
            System.out.println("3) Within 1 month");
            int timeToResults = scanner.nextInt();

            // Question 7: Willingness to Track Food Intake
            System.out.println("9. Are you willing to track your food intake daily?");
            System.out.println("1) No");
            System.out.println("2) Yes, but with minimal effort");
            System.out.println("3) Yes, consistently and in detail");
            int foodTracking = scanner.nextInt();

            // Question 14: Time Commitment for Exercise
            System.out.println("10. How much time can you commit to exercise daily?");
            System.out.println("1) Less than 20 minutes");
            System.out.println("2) 20-40 minutes");
            System.out.println("3) 40+ minutes");
            int exerciseTimeCommitment = scanner.nextInt();

            // Calculate daily caloric needs
            double bmr = calculateBMR(currentWeight, height, ageGroup, gender);
            double tdee = calculateTDEE(bmr, exerciseTimeCommitment);
            double calorieGoal = adjustCalories(tdee, goal, calorieReduction);

            // Process the user input and print results
            processInput(ageGroup, currentWeight, height, gender, goal, approach, calorieReduction, timeToResults, foodTracking, exerciseTimeCommitment, calorieGoal);

            // Closing scanner
            scanner.close();
        }

        private static double calculateBMR(double weight, double height, int ageGroup, int gender) {
            // BMR calculation based on Mifflin-St Jeor Equation
            double bmr;
            if (gender == 1) { // Male
                bmr = 10 * weight + 6.25 * height - 5 * getAgeFromGroup(ageGroup) + 5;
            } else { // Female
                bmr = 10 * weight + 6.25 * height - 5 * getAgeFromGroup(ageGroup) - 161;
            }
            return bmr;
        }

        private static double calculateTDEE(double bmr, int exerciseTimeCommitment) {
            // Activity multipliers
            double activityMultiplier;
            if (exerciseTimeCommitment == 1) { // Less than 20 minutes
                activityMultiplier = 1.2; // Sedentary
            } else if (exerciseTimeCommitment == 2) { // 20-40 minutes
                activityMultiplier = 1.375; // Lightly active
            } else { // 40+ minutes
                activityMultiplier = 1.55; // Moderately active
            }
            return bmr * activityMultiplier;
        }

        private static double adjustCalories(double tdee, int goal, int calorieReduction) {
            double adjustedCalories = tdee;
            if (goal == 1) { // Lose Fat
                switch (calorieReduction) {
                    case 1: // Minimal reduction
                        adjustedCalories -= 250;
                        break;
                    case 2: // Moderate reduction
                        adjustedCalories -= 500;
                        break;
                    case 3: // Significant reduction
                        adjustedCalories -= 750;
                        break;
                }
            } else if (goal == 2) { // Gain Weight
                adjustedCalories += 500; // General increase for weight gain
            }
            return adjustedCalories;
        }

        private static double getAgeFromGroup(int ageGroup) {
            return switch (ageGroup) {
                case 1 -> 17; // Under 18
                case 2 -> 25; // 18-30
                case 3 -> 40; // 31-50
                case 4 -> 60; // Over 50
                default -> 25; // Default age
            };
        }

        private static void processInput(int ageGroup, double currentWeight, double height, int gender, int goal, int approach, int calorieReduction, int timeToResults, int foodTracking, int exerciseTimeCommitment, double calorieGoal) {
            // Here you can implement your logic to calculate results based on user input
            // For demonstration, let's print the values
            System.out.println("\nUser Input Summary:");
            System.out.printf("Age Group: %d\nCurrent Weight: %.2f kg\nHeight: %.2f cm\nGender: %d\nGoal: %d\nApproach: %d\nCalorie Reduction Aim: %d\nTime to Results: %d\nFood Tracking: %d\nExercise Time Commitment: %d\nTarget Daily Calories: %.2f kcal\n",
                    ageGroup, currentWeight, height, gender, goal, approach, calorieReduction, timeToResults, foodTracking, exerciseTimeCommitment, calorieGoal);
        }
    }



/*
public class CalorieCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user information
        System.out.print("Enter your weight in kg: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in cm: ");
        double height = scanner.nextDouble();

        System.out.print("Enter your age in years: ");
        int age = scanner.nextInt();

        System.out.print("Enter your gender (M/F): ");
        char gender = scanner.next().toUpperCase().charAt(0);

        System.out.println("Choose your goal:");
        System.out.println("1. Lose Fat");
        System.out.println("2. Gain Weight");
        System.out.println("3. Be Healthier");
        int goal = scanner.nextInt();

        System.out.println("Choose your approach:");
        System.out.println("1. Moderate Approach");
        System.out.println("2. Intensive Approach");
        System.out.println("3. Balanced Approach");
        int approach = scanner.nextInt();

        // Get duration in weeks
        System.out.print("Enter the number of weeks for this goal: ");
        int weeks = scanner.nextInt();

        // Calculate the base calorie requirement
        double dailyCalories = calculateCalories(weight, height, age, gender);

        // Adjust calories based on goal and approach
        dailyCalories = adjustCaloriesForGoal(dailyCalories, goal, approach);

        // Calculate total calories for the specified number of weeks
        double totalCalories = dailyCalories * 7 * weeks;

        System.out.printf("Based on your inputs, you should aim for %.0f calories per day.%n", dailyCalories);
        System.out.printf("For %d weeks, you should aim for a total of %.0f calories.%n", weeks, totalCalories);

        scanner.close();
    }

    public static double calculateCalories(double weight, double height, int age, char gender) {
        double bmr;

        // Calculate BMR using the Mifflin-St Jeor Equation
        if (gender == 'M') {
            // BMR for men: 10 * weight + 6.25 * height - 5 * age + 5
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            // BMR for women: 10 * weight + 6.25 * height - 5 * age - 161
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        // Assuming sedentary activity level (multiplier of 1.2)
        return bmr * 1.2; // This can be adjusted based on actual activity level
    }

    public static double adjustCaloriesForGoal(double calories, int goal, int approach) {
        // Adjust calories based on goal and approach
        switch (goal) {
            case 1: // Lose Fat
                switch (approach) {
                    case 1: // Moderate Approach
                        calories -= 300;
                        break;
                    case 2: // Intensive Approach
                        calories -= 500;
                        break;
                    case 3: // Balanced Approach
                        calories -= 400;
                        break;
                }
                break;

            case 2: // Gain Weight
                switch (approach) {
                    case 1: // Moderate Approach
                        calories += 300;
                        break;
                    case 2: // Intensive Approach
                        calories += 500;
                        break;
                    case 3: // Balanced Approach
                        calories += 400;
                        break;
                }
                break;

            case 3: // Be Healthier
                switch (approach) {
                    case 1: // Moderate Approach
                        calories += 100; // Small increase for healthier choices
                        break;
                    case 2: // Intensive Approach
                        calories += 200; // Moderate increase for intensive healthy habits
                        break;
                    case 3: // Balanced Approach
                        // No significant change; aim for maintenance
                        break;
                }
                break;

            default:
                System.out.println("Invalid goal selected.");
        }

        return calories;
    }
}


 */