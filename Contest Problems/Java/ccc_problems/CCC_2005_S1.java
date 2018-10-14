import java.util.Scanner;

public class CCC_2005_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPhones = Integer.parseInt(scanner.nextLine());
        String[] phones = new String[numPhones];
        for (int i = 0; i < numPhones; i++) {
            phones[i] = scanner.nextLine();
        }
        for (int i = 0; i < numPhones; i++) {
            StringBuilder temp = new StringBuilder(phones[i]);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '-') {
                    temp.deleteCharAt(j);
                }
            }
            for (int j = 0; j < temp.length(); j++) {
                switch (temp.charAt(j)) {
                    case 'A':
                    case 'B':
                    case 'C':
                        temp.setCharAt(j, '2');
                        break;
                    case 'D':
                    case 'E':
                    case 'F':
                        temp.setCharAt(j, '3');
                        break;
                    case 'G':
                    case 'H':
                    case 'I':
                        temp.setCharAt(j, '4');
                        break;
                    case 'J':
                    case 'K':
                    case 'L':
                        temp.setCharAt(j, '5');
                        break;
                    case 'M':
                    case 'N':
                    case 'O':
                        temp.setCharAt(j, '6');
                        break;
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                        temp.setCharAt(j, '7');
                        break;
                    case 'T':
                    case 'U':
                    case 'V':
                        temp.setCharAt(j, '8');
                        break;
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                        temp.setCharAt(j, '9');
                        break;
                }
            }
            temp.insert(3, '-');
            temp.insert(7, '-');
            System.out.println(temp.substring(0, 12));
        }
        scanner.close();
    }
}
