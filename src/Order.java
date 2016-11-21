import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Yoo on 2016-10-19.
 */


public class Order {
    private final int ESPRESSO = 1, AMERICANO = 2, FLUITJUICE = 3, CAFFELATTE = 4, EXIT = 0;
    private Queue<Beverages> orderList;
    private int espressoCnt, americanoCnt, fluitJuiceCnt, caffeLatteCnt;
    private int total_time;
    private int espressoTime, americanoTime, fluitJuiceTime, caffeLatteTime;
    private List<Integer> timeTable;
    private List<Baristar> baristars;
    public static int q = 0;

    /**
     * Instantiates a new Order.
     */
    public Order() {
        orderList = new LinkedList<>();
        timeTable = new ArrayList<>();
        baristars = new ArrayList<>();
        baristars.add(new BaristarA());
        baristars.add(new BaristarB());
        baristars.add(new BaristarC());
        baristars.add(new BaristarD());
    }

    /**
     * Gets order list.
     *
     * @return the order list
     */
    public Queue<Beverages> getOrderList() {
        return orderList;
    }

    /**
     * Sets order list.
     *
     * @param orderList the order list
     */
    public void setOrderList(Queue<Beverages> orderList) {
        this.orderList = orderList;
    }

    /**
     * Gets espresso cnt.
     *
     * @return the espresso cnt
     */
    public int getEspressoCnt() {
        return espressoCnt;
    }

    /**
     * Sets espresso cnt.
     *
     * @param espressoCnt the espresso cnt
     */
    public void setEspressoCnt(int espressoCnt) {
        this.espressoCnt = espressoCnt;
    }

    /**
     * Gets americano cnt.
     *
     * @return the americano cnt
     */
    public int getAmericanoCnt() {
        return americanoCnt;
    }

    /**
     * Sets americano cnt.
     *
     * @param americanoCnt the americano cnt
     */
    public void setAmericanoCnt(int americanoCnt) {
        this.americanoCnt = americanoCnt;
    }

    /**
     * Gets fluit juice cnt.
     *
     * @return the fluit juice cnt
     */
    public int getFluitJuiceCnt() {
        return fluitJuiceCnt;
    }

    /**
     * Sets fluit juice cnt.
     *
     * @param fluitJuiceCnt the fluit juice cnt
     */
    public void setFluitJuiceCnt(int fluitJuiceCnt) {
        this.fluitJuiceCnt = fluitJuiceCnt;
    }

    /**
     * Gets caffe latte cnt.
     *
     * @return the caffe latte cnt
     */
    public int getCaffeLatteCnt() {
        return caffeLatteCnt;
    }

    /**
     * Sets caffe latte cnt.
     *
     * @param caffeLatteCnt the caffe latte cnt
     */
    public void setCaffeLatteCnt(int caffeLatteCnt) {
        this.caffeLatteCnt = caffeLatteCnt;
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
     * Gets espresso time.
     *
     * @return the espresso time
     */
    public int getEspressoTime() {
        return espressoTime;
    }

    /**
     * Sets espresso time.
     *
     * @param espressoTime the espresso time
     */
    public void setEspressoTime(int espressoTime) {
        this.espressoTime = espressoTime;
    }

    /**
     * Gets americano time.
     *
     * @return the americano time
     */
    public int getAmericanoTime() {
        return americanoTime;
    }

    /**
     * Sets americano time.
     *
     * @param americanoTime the americano time
     */
    public void setAmericanoTime(int americanoTime) {
        this.americanoTime = americanoTime;
    }

    /**
     * Gets fluit juice time.
     *
     * @return the fluit juice time
     */
    public int getFluitJuiceTime() {
        return fluitJuiceTime;
    }

    /**
     * Sets fluit juice time.
     *
     * @param fluitJuiceTime the fluit juice time
     */
    public void setFluitJuiceTime(int fluitJuiceTime) {
        this.fluitJuiceTime = fluitJuiceTime;
    }

    /**
     * Gets caffe latte time.
     *
     * @return the caffe latte time
     */
    public int getCaffeLatteTime() {
        return caffeLatteTime;
    }

    /**
     * Sets caffe latte time.
     *
     * @param caffeLatteTime the caffe latte time
     */
    public void setCaffeLatteTime(int caffeLatteTime) {
        this.caffeLatteTime = caffeLatteTime;
    }

    /**
     * Gets time table.
     *
     * @return the time table
     */
    public List<Integer> getTimeTable() {
        return timeTable;
    }

    /**
     * Sets time table.
     *
     * @param timeTable the time table
     */
    public void setTimeTable(List<Integer> timeTable) {
        this.timeTable = timeTable;
    }

    /**
     * Gets baristars.
     *
     * @return the baristars
     */
    public List<Baristar> getBaristars() {
        return baristars;
    }

    /**
     * Sets baristars.
     *
     * @param baristars the baristars
     */
    public void setBaristars(List<Baristar> baristars) {
        this.baristars = baristars;
    }

    /**
     * Divide order.
     */
//분배 알고리즘
    public void divideOrder() {

        //주문 Queue가 빌떄까지.
        while (!orderList.isEmpty()) {
            Beverages popBeverage = orderList.poll();
            //주문이 Espresso일때
            if (popBeverage.getBeveragedId().equals(CoffeeType.ESPRESSO)) {
                //각 음료 제작 시간에 따른 정렬
                Collections.sort(baristars, new Comparator<Baristar>() {
                    @Override
                    public int compare(Baristar o1, Baristar o2) {
                        return Integer.compare(o1.getEspressoAble_time(), o2.getEspressoAble_time());
                    }
                });

                //각 바리스타의 현재까지 시간과, 바리스타마다의 음료에 따른 걸리는 시간을 계산하여 최소인 바리스타에게 할당.
                for (int i = 0; i < popBeverage.getCount(); i++) {
                    int min = 0;
                    int time = baristars.get(0).getTotal_time() + baristars.get(0).getEspressoAble_time();

                    for (int j = 1; j < baristars.size(); j++) {
                        if (time > baristars.get(j).getTotal_time() + baristars.get(j).getEspressoAble_time()) {
                            min = j;
                            time = baristars.get(j).getTotal_time() + baristars.get(j).getEspressoAble_time();
                        }
                    }
                    baristars.get(min).setTotal_time(time);
                    baristars.get(min).getBeverages().add(popBeverage);
                }
            } else if (popBeverage.getBeveragedId().equals(CoffeeType.AMERICANO)) {

                Collections.sort(baristars, new Comparator<Baristar>() {
                    @Override
                    public int compare(Baristar o1, Baristar o2) {
                        return Integer.compare(o1.getAmericanoAble_time(), o2.getAmericanoAble_time());
                    }
                });

                for (int i = 0; i < popBeverage.getCount(); i++) {
                    int min = 0;
                    int time = baristars.get(0).getTotal_time() + baristars.get(0).getAmericanoAble_time();

                    for (int j = 1; j < baristars.size(); j++) {
                        if (time > baristars.get(j).getTotal_time() + baristars.get(j).getAmericanoAble_time()) {
                            min = j;
                            time = baristars.get(j).getTotal_time() + baristars.get(j).getAmericanoAble_time();
                        }
                    }
                    baristars.get(min).setTotal_time(time);
                    baristars.get(min).getBeverages().add(popBeverage);
                }
            } else if (popBeverage.getBeveragedId().equals(CoffeeType.FLUITJUICE)) {

                Collections.sort(baristars, new Comparator<Baristar>() {
                    @Override
                    public int compare(Baristar o1, Baristar o2) {
                        return Integer.compare(o1.getFluitJuiceAble_time(), o2.getFluitJuiceAble_time());
                    }
                });

                for (int i = 0; i < popBeverage.getCount(); i++) {
                    int min = 0;
                    int time = baristars.get(0).getTotal_time() + baristars.get(0).getFluitJuiceAble_time();

                    for (int j = 1; j < baristars.size(); j++) {
                        if (time > baristars.get(j).getTotal_time() + baristars.get(j).getFluitJuiceAble_time()) {
                            min = j;
                            time = baristars.get(j).getTotal_time() + baristars.get(j).getFluitJuiceAble_time();
                        }
                    }
                    baristars.get(min).setTotal_time(time);
                    baristars.get(min).getBeverages().add(popBeverage);
                }
            } else {
                Collections.sort(baristars, new Comparator<Baristar>() {
                    @Override
                    public int compare(Baristar o1, Baristar o2) {
                        return Integer.compare(o1.getCaffeLatteAble_time(), o2.getCaffeLatteAble_time());
                    }
                });

                for (int i = 0; i < popBeverage.getCount(); i++) {
                    int min = 0;
                    int time = baristars.get(0).getTotal_time() + baristars.get(0).getCaffeLatteAble_time();

                    for (int j = 1; j < baristars.size(); j++) {
                        if (time > baristars.get(j).getTotal_time() + baristars.get(j).getCaffeLatteAble_time()) {
                            min = j;
                            time = baristars.get(j).getTotal_time() + baristars.get(j).getCaffeLatteAble_time();
                        }
                    }
                    baristars.get(min).setTotal_time(time);
                    baristars.get(min).getBeverages().add(popBeverage);
                }
            }
        }
        int max = 0;
        Collections.sort(baristars, new Comparator<Baristar>() {
            @Override
            public int compare(Baristar o1, Baristar o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Baristar baristar : baristars) {
            System.out.print(baristar.getName() + ": " + baristar.getTotal_time() + "분 ");
            System.out.print("주문내역: ");
            for (Iterator i = baristar.getBeverages().iterator(); i.hasNext(); ) {
                System.out.print(((Beverages) i.next()).getBeveragedId() + " ");
            }
            if (max < baristar.getTotal_time()) {
                max = baristar.getTotal_time();
            }
            System.out.println();
        }
        System.out.println("각 바리스타가 분배되어 주문 처리시 총 시간은 :" + max + "분 입니다.");
        for (Baristar baristar : baristars) {
            baristar.baristar_thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (Beverages beverages : baristar.getBeverages()) {
                        System.out.println(baristar.getName() + "의 " + beverages.getBeveragedId().toString() + " 커피 만들기 시작 " + beverages.getTimeMinute() + "분 걸림");
                        try {
                            Thread.sleep(beverages.getTimeMinute() * 1000);
                            System.out.println(baristar.getName() + "의 " + beverages.getBeveragedId().toString() + " 커피 만들기 완료");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    q++;
                    if (q == 4)
                        System.out.println("입력을 해주세요\n 1:주문 2:분배 0:종료");
                }
            });
            baristar.baristar_thread.start();
        }
    }

    /**
     * Print order.
     */
//주문 리스트 출력
    public void printOrder() {
        for (Beverages beverages : orderList) {
            if (beverages.getBeveragedId().equals(CoffeeType.ESPRESSO)) {
                espressoCnt += beverages.getCount();
                espressoTime += beverages.getTotalTime();
            } else if (beverages.getBeveragedId().equals(CoffeeType.AMERICANO)) {
                americanoCnt += beverages.getCount();
                americanoTime += beverages.getTotalTime();
            } else if (beverages.getBeveragedId().equals(CoffeeType.FLUITJUICE)) {
                fluitJuiceCnt += beverages.getCount();
                fluitJuiceTime += beverages.getTotalTime();
            } else if (beverages.getBeveragedId().equals(CoffeeType.CAFFELATTE)) {
                caffeLatteCnt += beverages.getCount();
                caffeLatteTime += beverages.getTotalTime();
            }
        }
        System.out.println("주문내역: Espresso:" + espressoCnt + " Americano:" + americanoCnt + " FluitJuice:" + fluitJuiceCnt + " CaffeLatte:" + caffeLatteCnt);
        total_time = espressoTime + americanoTime + fluitJuiceTime + caffeLatteTime;

    }

    /**
     * Order beverage.
     *
     * @throws IOException the io exception
     */
//주문 함수.
    public void orderBeverage() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputNum;
        int inputCnt;
        while (true) {
            System.out.println("주문을 해주세요\n 1:에스프레소 2:아메리카노 3:과일 주스 4:카페라테 0:완료");
            inputNum = Integer.parseInt(bufferedReader.readLine());
            if (inputNum == EXIT) return;
            else {
                System.out.println("몇잔을 주문 하시겠습니까?");
                inputCnt = Integer.parseInt(bufferedReader.readLine());
                if (inputNum == ESPRESSO) {
                    orderList.add(new Espresso(CoffeeType.ESPRESSO, inputCnt));
                } else if (inputNum == AMERICANO) {
                    orderList.add(new Americano(CoffeeType.AMERICANO, inputCnt));
                } else if (inputNum == FLUITJUICE) {
                    orderList.add(new FluitJuice(CoffeeType.FLUITJUICE, inputCnt));
                } else if (inputNum == CAFFELATTE) {
                    orderList.add(new CaffeLatte(CoffeeType.CAFFELATTE, inputCnt));
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }
}
