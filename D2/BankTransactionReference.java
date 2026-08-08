import java.util.Scanner;

public class BankTransactionReference {

    static String normalizeReference(String raw) {
        raw = raw.trim();

        if (raw.length() >= 3) {
            raw = raw.substring(0, 3).toUpperCase() + raw.substring(3);
        }

        return raw;
    }

    static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9); // ddMMyy
        String seq = reference.substring(9);     // last 5 digits

        StringBuilder result = new StringBuilder();
        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(date.substring(0, 2))
              .append("/")
              .append(date.substring(2, 4))
              .append("/")
              .append(date.substring(4, 6))
              .append(" | SEQ: ")
              .append(seq);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);
        System.out.println(validateAndFormat(normalized));

        sc.close();
    }
}