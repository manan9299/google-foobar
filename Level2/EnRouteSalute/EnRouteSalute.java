public class EnRouteSalute {

    public static void main(String[] args) {
        System.out.println(solution(">---<"));
        System.out.println(solution("<<>><"));
        System.out.println(solution("--->-><-><-->-"));
        System.out.println(solution("<<>><"));
        System.out.println(solution("------"));

    }

    /**
     * Returns the number of Salutes for a given String
     * @param   s   Sequence of employees indicating their direction
     * @return  Returns the total number of Salutes being exchanged between them
     */
    public static int solution(String s) {
        int numEmployeesLtoR = 0;
        int numSalutes = 0;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            // Increase the count of employees going from left to right if direction is '>'
            if (curChar == '>') {
                numEmployeesLtoR++;
            // Update the number of salutes exchanged if we encounter an employee going from right to left i.e direction is '<'
            } else if (curChar == '<') {
                numSalutes += numEmployeesLtoR * 2;
            }
        }

        return numSalutes;
    }
}
