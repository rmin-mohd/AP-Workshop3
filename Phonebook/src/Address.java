public class Address {
    private String zipCode;
    private String country;
    private String city;

    public Address(String zipCode, String country, String city) {
        this.zipCode = zipCode != null ? zipCode : "";
        this.country = country != null ? country : "";
        this.city = city != null ? city : "";
    }

    @Override
    public String toString() {
        return "Address Details:\n" +
                "Zip Code: " + (zipCode.isEmpty() ? "N/A" : zipCode) + "\n" +
                "Country: " + (country.isEmpty() ? "N/A" : country) + "\n" +
                "City: " + (city.isEmpty() ? "N/A" : city);
    }

    public static void main(String[] args) {
        Address address = new Address("37196883", "INDIA", "New Delhi");
        System.out.println(address.toString());
    }
}
