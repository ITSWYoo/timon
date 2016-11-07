/**
 * Created by Yoo on 2016-10-19.
 */
public class Beverages {
    private CoffeeType beveragedId;
    private int count;
    private int timeMinute;

    /**
     * Gets beveraged id.
     *
     * @return the beveraged id
     */
    public CoffeeType getBeveragedId() {
        return beveragedId;
    }

    /**
     * Sets beveraged id.
     *
     * @param beveragedId the beveraged id
     */
    public void setBeveragedId(CoffeeType beveragedId) {
        this.beveragedId = beveragedId;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets time minute.
     *
     * @return the time minute
     */
    public int getTimeMinute() {
        return timeMinute;
    }

    /**
     * Sets time minute.
     *
     * @param timeMinute the time minute
     */
    public void setTimeMinute(int timeMinute) {
        this.timeMinute = timeMinute;
    }

    /**
     * Instantiates a new Beverages.
     */
    public Beverages(){

    }

    /**
     * Instantiates a new Beverages.
     *
     * @param beveragedId the beveraged id
     * @param count       the count
     */
    public Beverages(CoffeeType beveragedId, int count) {
        this.beveragedId = beveragedId;
        this.count = count;
    }

    /**
     * Get total time int.
     *
     * @return the int
     */
    public int getTotalTime(){
        return count*timeMinute;
    }
}

/**
 * The type Espresso.
 */
class Espresso extends Beverages{
    /**
     * Instantiates a new Espresso.
     *
     * @param beveragedId the beveraged id
     * @param count       the count
     */
    public Espresso(CoffeeType beveragedId, int count) {
        super(beveragedId, count);
        super.setTimeMinute(2);
    }
}

/**
 * The type Americano.
 */
class Americano extends Beverages{

    /**
     * Instantiates a new Americano.
     *
     * @param beveragedId the beveraged id
     * @param count       the count
     */
    public Americano(CoffeeType beveragedId, int count) {
        super(beveragedId, count);
        super.setTimeMinute(3);
    }
}

/**
 * The type Fluit juice.
 */
class FluitJuice extends Beverages{
    /**
     * Instantiates a new Fluit juice.
     *
     * @param beveragedId the beveraged id
     * @param count       the count
     */
    public FluitJuice(CoffeeType beveragedId, int count) {
        super(beveragedId, count);
        super.setTimeMinute(5);
    }
}

/**
 * The type Caffe latte.
 */
class CaffeLatte extends Beverages{

    /**
     * Instantiates a new Caffe latte.
     *
     * @param beveragedId the beveraged id
     * @param count       the count
     */
    public CaffeLatte(CoffeeType beveragedId, int count) {
        super(beveragedId, count);
        super.setTimeMinute(4);
    }
}
