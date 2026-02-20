/**
 * Scholarship Eligibility Checker
 * Determines if a student is eligible for a scholarship based on specific criteria
 */
public class ScholarshipEligibility {

    /**
     * Checks scholarship eligibility based on student criteria
     * 
     * @param age Student's age
     * @param caResidency2Years Student lived in CA for last 2 years
     * @param caWork6Months Student worked in CA for 6+ months
     * @param parentsCATax Parents paid CA tax for 1+ years
     * @param volunteeredCA Student volunteered in CA with proof
     * @param householdIncome Annual household income
     * @returN ENUM: ELIGIBLE, NOT_ELIGIBLE, DEFER_TO_DEAN
     */
    public static String evaluateEligibility(
            int age,
            boolean caResidency2Years,
            boolean caWork6Months,
            boolean parentsCATax,
            boolean volunteeredCA,
            double householdIncome) {
        
        // Criterion 1: Age must be between 18 and 24 (inclusive)
        if (age < 18 || age > 24) {
            return "NOT ELIGIBLE";
        }
        
        // Criterion 2: Check CA Residency (at least one must be true)
        boolean residencyMet = caResidency2Years || caWork6Months ||
                               parentsCATax || volunteeredCA;
        
        if (residencyMet) {
            return "ELIGIBLE";
        }
        
        // Criterion 3: Dean's Consideration
        if (householdIncome < 5000) {
            return "DEAN FOR CONSIDERATION";
        }
        
        return "NOT ELIGIBLE";
    }

    public static void main(String[] args) {
        // Test the function
        String test_result_consideration = 
            evaluateEligibility(22, false, 
                false, false, false, 3000);

        String test_result_false = 
            evaluateEligibility(25, true, 
                true, true, false, 6000);

        String test_result_true = 
            evaluateEligibility(19, true, 
                true, false, false, 2500);

        // Print the result
        System.out.println(test_result_consideration);
        System.out.println(test_result_false);
        System.out.println(test_result_true);
    }
}
