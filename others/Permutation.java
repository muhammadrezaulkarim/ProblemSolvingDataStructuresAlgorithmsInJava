public class Permutation {
    private String inputStr;
    private Boolean[] flag;
    private StringBuilder permutationHolder = new StringBuilder();

    public void generationHelper(String str) {
        inputStr = str;
        flag = new Boolean[inputStr.length()];

        // can be avoided as boolean default value is false
        for (int i = 0; i < flag.length; i++) {
            flag[i] = false;
        }

        System.out.println();

        // requires to search for a sepecific string
        // boolean found = false;

        for (int i = 0; i < inputStr.length(); i++) {

            permuteChar(i);

            /*
             * // search for a sepcific string
             * found = findStringWithPermuation(i, "dbca");
             * 
             * if(found)
             * {
             * System.out.println("found");
             * break;
             * }
             */
        }

    }

    public void permuteChar(int k) {
        // permutationHolder: holds the next permutation
        flag[k] = true; // at the beginning set the flag to true
        permutationHolder.append(inputStr.charAt(k));

        if (permutationHolder.toString().length() == inputStr.length()) {
            System.out.println(permutationHolder.toString());

            // before returning set the flag to false so that the symbol can be reached
            // again in the search
            flag[k] = false;

            // backtrack: remove the character appended in this call to the current
            // permuation.
            // permutationHolder.delete(currentLength - 1, currentLength); // end index
            // exclusive
            permutationHolder.setLength(permutationHolder.length() - 1);

            return; // need to backtrack
        }

        for (int i = 0; i < inputStr.length(); i++) {
            if (flag[i] == false) {
                permuteChar(i);
            }
        }

        // before returning set the flag to false so that the symbol can be reached
        // again in the search
        flag[k] = false;

        // backtrack: remove the character appended in this call to the current
        // permuation.
        permutationHolder.setLength(permutationHolder.length() - 1); // end index exclusive
    }

    public boolean findStringWithPermuation(int k, String targetStr) {
        // permutationHolder: holds the next permutation
        flag[k] = true; // at the beginning set the flag to true
        permutationHolder.append(inputStr.charAt(k));

        if (permutationHolder.toString().length() == inputStr.length()) {

            // before returning set the flag to false so that the symbol can be reached
            // again in the search
            flag[k] = false;

            if (permutationHolder.toString().equals(targetStr)) {
                // backtrack: remove the character appended in this call to the current
                // permuation.
                permutationHolder.setLength(permutationHolder.length() - 1);

                return true;
            } else {
                // backtrack: remove the character appended in this call to the current
                // permuation.
                permutationHolder.setLength(permutationHolder.length() - 1);

                return false;
            }
        }

        for (int i = 0; i < inputStr.length(); i++) {
            if (flag[i] == false) {
                boolean found = findStringWithPermuation(i, targetStr);

                if (found) // prune the search space
                    return true;
            }
        }

        // before returning set the flag to false so that the symbol can be reached
        // again in the search
        flag[k] = false;

        // backtrack: remove the character appended in this call to the current
        // permuation.
        permutationHolder.setLength(permutationHolder.length() - 1);

        return false;
    }

    public static void main(String[] args) {
        String str = "abcd";
        Permutation permGenerator = new Permutation();
        permGenerator.generationHelper(str);
    }
}
