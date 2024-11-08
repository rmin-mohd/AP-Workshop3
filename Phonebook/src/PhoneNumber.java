public class PhoneNumber {
    private String countryCode;
    private String number;

    public PhoneNumber(String countryCode, String number) {
        if (number.length() == 12) {
            this.countryCode = countryCode != null ? countryCode : "";
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be exactly 12 digits.");
        }
    }

    @Override
    public String toString() {
        return "Contact.PhoneNumber: " + (countryCode.isEmpty() ? "" : countryCode + " ") + number;
    }
}