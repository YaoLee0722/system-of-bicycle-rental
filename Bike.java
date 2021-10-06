public class Bike {

    private static String LETTERS = "ab";
    private static int DIGITS = 100;
    private String id;
    private boolean rent;

    public Bike() {
        this.id = getNextId();
        this.rent = false;
    }

    public Bike(String id, boolean rent) {
        this.id = id;
        this.rent = rent;
    }

    public String getNextId() {
        DIGITS += 1;
        return LETTERS + DIGITS;
    }

    public static void changeLetter(String letter) {
        LETTERS = letter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

}
