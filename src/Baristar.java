import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoo on 2016-10-19.
 */
public class Baristar {
    private String name;
    private int total_time;
    private int espressoAble_time;
    private int americanoAble_time;
    private int fluitJuiceAble_time;
    private int caffeLatteAble_time;
    private List<Beverages> beverages;
    Thread baristar_thread;

    public List<Beverages> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverages> beverages) {
        this.beverages = beverages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets total time.
     *
     * @return the total time
     */
    public int getTotal_time() {
        return total_time;
    }

    /**
     * Sets total time.
     *
     * @param total_time the total time
     */
    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    /**
     * Gets espresso able time.
     *
     * @return the espresso able time
     */
    public int getEspressoAble_time() {
        return espressoAble_time;
    }

    /**
     * Sets espresso able time.
     *
     * @param espressoAble_time the espresso able time
     */
    public void setEspressoAble_time(int espressoAble_time) {
        this.espressoAble_time = espressoAble_time;
    }

    /**
     * Gets americano able time.
     *
     * @return the americano able time
     */
    public int getAmericanoAble_time() {
        return americanoAble_time;
    }

    /**
     * Sets americano able time.
     *
     * @param americanoAble_time the americano able time
     */
    public void setAmericanoAble_time(int americanoAble_time) {
        this.americanoAble_time = americanoAble_time;
    }

    /**
     * Gets fluit juice able time.
     *
     * @return the fluit juice able time
     */
    public int getFluitJuiceAble_time() {
        return fluitJuiceAble_time;
    }

    /**
     * Sets fluit juice able time.
     *
     * @param fluitJuiceAble_time the fluit juice able time
     */
    public void setFluitJuiceAble_time(int fluitJuiceAble_time) {
        this.fluitJuiceAble_time = fluitJuiceAble_time;
    }

    /**
     * Gets caffe latte able time.
     *
     * @return the caffe latte able time
     */
    public int getCaffeLatteAble_time() {
        return caffeLatteAble_time;
    }

    /**
     * Sets caffe latte able time.
     *
     * @param caffeLatteAble_time the caffe latte able time
     */
    public void setCaffeLatteAble_time(int caffeLatteAble_time) {
        this.caffeLatteAble_time = caffeLatteAble_time;
    }

    /**
     * Instantiates a new Baristar.
     */
    public Baristar(){
        espressoAble_time = 2;
        americanoAble_time = 3;
        fluitJuiceAble_time = 5;
        caffeLatteAble_time = 4;
        this.beverages = new ArrayList<>();
    }

    /**
     * Instantiates a new Baristar.
     *
     * @param espressoAble_time   the espresso able time
     * @param americanoAble_time  the americano able time
     * @param fluitJuiceAble_time the fluit juice able time
     * @param caffeLatteAble_time the caffe latte able time
     */
    public Baristar(String name ,int espressoAble_time, int americanoAble_time, int fluitJuiceAble_time, int caffeLatteAble_time) {
        this.name = name;
        this.espressoAble_time = espressoAble_time;
        this.americanoAble_time = americanoAble_time;
        this.fluitJuiceAble_time = fluitJuiceAble_time;
        this.caffeLatteAble_time = caffeLatteAble_time;
    }
}

/**
 * The type Baristar a.
 */
class BaristarA extends Baristar{
    /**
     * Instantiates a new Baristar a.
     */
    public BaristarA() {
        super();
        super.setFluitJuiceAble_time(4);
        super.setName("A");
    }
}

/**
 * The type Baristar b.
 */
class BaristarB extends Baristar{
    /**
     * Instantiates a new Baristar b.
     */
    public BaristarB(){
        super();
        super.setAmericanoAble_time(4);
        super.setName("B");
    }
}
class Q{
    private static Q q;
    public static Q getInstance(){
        if(q==null) {
            q = new Q();
            return q;
        }
        else return q;
    }
}
/**
 * The type Baristar c.
 */
class BaristarC extends Baristar{
    /**
     * Instantiates a new Baristar c.
     */
    public BaristarC(){
        super();
        super.setName("C");
    }
}

/**
 * The type Baristar d.
 */
class BaristarD extends Baristar{
    /**
     * Instantiates a new Baristar d.
     */
    public BaristarD(){
        super();
        super.setCaffeLatteAble_time(5);
        super.setName("D");
    }
}

