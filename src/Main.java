import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Yoo on 2016-10-19.
 */
public class Main {
    /**
     * The Order.
     */
    /**
     * The Buffered reader.
     */
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * The Exit.
     */
    static final int EXIT = 0;
    /**
     * The Order.
     */
    static final int ORDER = 1, /**
     * The Division.
     */
    DIVISION = 2;

    /**
     * Main.
     *
     * @param args the args
     * @throws IOException the io exception
     */
    public static void main(String args[]) throws IOException {
        simulation();
    }

    /**
     * Simulation.
     *
     * @throws IOException the io exception
     */
    public static void simulation() throws IOException {
        Order order = new Order();

        //input
        int num;

        System.out.println("입력을 해주세요\n 1:주문 2:분배 0:종료");

        while (true) {
            num = Integer.parseInt(bufferedReader.readLine());
            if (num == ORDER) {
                System.out.println("주문");
                order.orderBeverage();
                System.out.println("입력을 해주세요\n 1:주문 2:분배 0:종료");
            } else if (num == DIVISION) {
                System.out.println("분배");
                if (order.getOrderList().isEmpty()) System.out.println("주문이 없습니다.");
                else {
                    order.printOrder();
                    order.divideOrder();
                    order = new Order();
                }
            } else if (num == EXIT) {
                System.out.println("종료");
                return;
            } else System.out.println("입력이 잘못 되었습니다.");
        }
    }
}

