/**
 * Created by Yoo on 2016-11-04.
 */
enum CoffeeType {
    AMERICANO, CAFFELATTE, ESPRESSO, FLUITJUICE;

    @Override
    public String toString() {
        switch (this) {
            case AMERICANO:
                return "Americano";
            case CAFFELATTE:
                return "CafeeLatte";
            case ESPRESSO:
                return "Espresso";
            case FLUITJUICE:
                return "FluitJuice";
            default:
                return "";
        }
    }
}