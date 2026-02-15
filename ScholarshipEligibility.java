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
     * @return 1 (eligible), 0 (not eligible), or "Dean for consideration"
     */
    public static Object checkScholarshipEligibility(
            int age,
            boolean caResidency2Years,
            boolean caWork6Months,
            boolean parentsCATax,
            boolean volunteeredCA,
            double householdIncome) {
        
        // Criterion 1: Age must be between 18 and 24 (inclusive)
        if (age < 18 || age > 24) {
            return 0;
        }
        
        // Criterion 2: Check CA Residency (at least one must be true)
        boolean residencyMet = caResidency2Years || caWork6Months ||
                               parentsCATax || volunteeredCA;
        
        if (residencyMet) {
            return 1;
        }
        
        // Criterion 3: Dean's Consideration
        if (householdIncome < 5000) {
            return "Dean for consideration";
        }
        
        return 0;
    }

    public static void main(String[] args) {
        // Test the function
        System.out.println("Scholarship Eligibility Test:");
        System.out.println(checkScholarshipEligibility(20, true, false, false, false, 6000));
        System.out.println(checkScholarshipEligibility(25, true, false, false, false, 6000));
        System.out.println(checkScholarshipEligibility(20, false, false, false, false, 3000));
    }
}
