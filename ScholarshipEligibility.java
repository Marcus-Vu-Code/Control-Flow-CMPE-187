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
        /**
         * Test Case 1: "Dean consideration"
         * Age (22) check FALSE
         * Residency not met: ALL FALSE
         * Income (3000 < 5000): True
         * Return: Defer to Dean
         */
        String test_result_consideration = 
            evaluateEligibility(22, false, 
                false, false, false, 3000);
        
        /**
         * Test Case 2: Age Fail
         * Age (25) check False
         * The other fields are randomly input
         * Return: Not eligible
         */
        String test_result_false = 
            evaluateEligibility(25, true, 
                true, true, false, 6000);

        /**
         * Test casse 3: Residency met
         * Age (19) check True
         * Residency met: more than one condition for residency is true
         * Income is not evaluated
         * Return: Eligible
         */
        String test_result_true = 
            evaluateEligibility(19, true, 
                true, true, false, 2500);

        /**
         * Test Case 4: Not Eligible
         * Age (20) check True
         * Residency not met: all conditions are False
         * Income (6000 > 5000): False
         * Return Not Eligible
         */
        String test_result_false2 = ScholarshipEligibility.evaluateEligibility(20, false, 
                false, false, false, 6000);
        
        /**
         * Test Case 5: Age Fail 1 below bound
         * Age (17) check False
         * Return: NOT ELIGIBLE
         */
        String test_result_age_fail_17 =
                evaluateEligibility(17, true,
                        false, false, false, 10000);

        /**
         * Test Case 6: Residency met
         * Age (18) check True
         * Residency met: caWork6Months ONLY is true
         * Return: ELIGIBLE
         */
        String test_result_age_boundary_18_residency =
                evaluateEligibility(18, false,
                        true, false, false, 10000);

        /**
         * Test Case 7: Dean consideration
         * Age (24) check True
         * Residency not met: ALL FALSE
         * Income (3000 < 5000): True
         * Return: DEAN FOR CONSIDERATION
         */
        String test_result_age_boundary_24_dean =
                evaluateEligibility(24, false,
                        false, false, false, 3000);

        /**
         * Test Case 8: Not eligible (Income boundary = 5000)
         * Age (20) check True
         * Residency not met: ALL FALSE
         * Income (5000 < 5000): False
         * Return: NOT ELIGIBLE
         */
        String test_result_income_boundary_5000 =
                evaluateEligibility(20, false,
                        false, false, false, 5000);

        /**
         * Test Case 9: Age Fail way too old
         * Age (30) check False
         * Return: NOT ELIGIBLE
         */
        String test_result_age_fail_30 =
                evaluateEligibility(30, false,
                        false, false, false, 1);

        /**
         * Test Case 10: Residency met parentsCATax ONLY
         * Age (21) check True
         * Residency met: parentsCATax ONLY is true
         * Return: ELIGIBLE
         */
        String test_result_residency_only_parents_tax =
                evaluateEligibility(21, false,
                        false, true, false, 99999);

        /**
         * Test Case 11: Dean consideration income 4999
         * Age (23) check True
         * Residency not met: ALL FALSE
         * Income (4999 < 5000): True
         * Return: DEAN FOR CONSIDERATION
         */
        String test_result_income_4999_dean =
                evaluateEligibility(23, false,
                        false, false, false, 4999);

        /**
         * Test Case 12: Not eligible income high 7000
         * Age (19) check True
         * Residency not met: ALL FALSE
         * Income (7000 < 5000): False
         * Return: NOT ELIGIBLE
         */
        String test_result_income_7000_not_eligible =
                evaluateEligibility(19, false,
                        false, false, false, 7000);

        /**
         * Test Case 13: Residency met volunteeredCA ONLY
         * Age (22) check True
         * Residency met: volunteeredCA ONLY is true
         * Return: ELIGIBLE
         */
        String test_result_residency_only_volunteer =
                evaluateEligibility(22, false,
                        false, false, true, 2000);

        /**
         * Test Case 14: Dean consideration negative income
         * Age (20) check True
         * Residency not met: ALL FALSE
         * Income (-1 < 5000): True
         * Return: DEAN FOR CONSIDERATION
         */
        String test_result_negative_income_dean =
                evaluateEligibility(20, false,
                        false, false, false, -1);

        // Print the result
        System.out.println("Test 1  (Dean consideration):       " + test_result_consideration);
        System.out.println("Test 2  (Age fail 25):              " + test_result_false);
        System.out.println("Test 3  (Residency met):            " + test_result_true);
        System.out.println("Test 4  (Not eligible income high): " + test_result_false2);
        System.out.println("Test 5  (Age fail 17):              " + test_result_age_fail_17);
        System.out.println("Test 6  (Age 18 residency met):     " + test_result_age_boundary_18_residency);
        System.out.println("Test 7  (Age 24 dean):              " + test_result_age_boundary_24_dean);
        System.out.println("Test 8  (Income = 5000):            " + test_result_income_boundary_5000);
        System.out.println("Test 9  (Age fail 30):              " + test_result_age_fail_30);
        System.out.println("Test 10 (Parents tax only):         " + test_result_residency_only_parents_tax);
        System.out.println("Test 11 (Income 4999 dean):         " + test_result_income_4999_dean);
        System.out.println("Test 12 (Income 7000 not eligible): " + test_result_income_7000_not_eligible);
        System.out.println("Test 13 (Volunteer only):           " + test_result_residency_only_volunteer);
        System.out.println("Test 14 (Negative income dean):     " + test_result_negative_income_dean);

    }
}
