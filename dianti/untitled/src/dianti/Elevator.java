package dianti;
import java.util.Comparator;
import java.util.TreeSet;
/**
 * Title:
 * Description:
 * Created Time: 2017/9/18 8:59
 *
 * @version 1.0
 *          To change this template use File | Settings | File and Code Templates.
 * @author: zzp1
 */
public class Elevator {
    int stay = 1;//电梯初始所在楼层

    public final static int MAXFLOOR = 6;//楼层
    public final static int MINFLOOR = 1;
//    final int elevatorUp = 0;//电梯初始化状态
//    final int elevatorDown = 1;
//    final int elevatorPause = 2;
//    int state = elevatorPause;
    TreeSet<Integer> upset = new TreeSet();
    TreeSet<Integer> downset = new TreeSet();

    public enum StateElevator {
        UP, DOWN, PAUSE;
    }

    public void up() {
        if (stay == MAXFLOOR) {
            if (downset.isEmpty() == true)
                pause();
            else
                down();
        }
        stay++;
        System.out.println("电梯到达" + stay + "楼---▲");

        if (upset.contains(stay) == true) {
            openDoor();
            closeDoor();
            upset.remove(stay);
        }

    }

    public void down() {
        if (stay == MINFLOOR) {
            if (upset.isEmpty() == true)
                pause();
            else
                up();
        }
        stay--;
        System.out.println("电梯到达" + stay + "楼---▼");

        if (downset.contains(stay) == true) {
            openDoor();
            closeDoor();
            downset.remove(stay);
        }

    }

    public void pause() {
        System.out.println("电梯暂停在" + stay + "楼");
    }

    public void openDoor() {
        System.out.println("电梯开门");
    }

    public void closeDoor() {
        System.out.println("电梯关门");
    }

    public void turn() {//电梯转向
        if (downset.isEmpty() == true && upset.isEmpty() == true)
            pause();//state为PAUSE
        else if ((upset.isEmpty() == true && downset.floor(MAXFLOOR) > stay) ||
                (downset.isEmpty() == true && upset.ceiling(MINFLOOR) > stay))//小于等于最大楼层数的最大的数 > 电梯所在楼层
            up();//state为UP
        else if ((upset.isEmpty() == true && downset.floor(MAXFLOOR) < stay) ||
                (downset.isEmpty() == true && upset.ceiling(MINFLOOR) < stay))
            down();//state为DOWN
    }

    public void internalButton(int wantFloor) {//内部按钮
        if (wantFloor > stay)//如果电梯在上升
            upset.add(wantFloor);
        if (wantFloor < stay)
            downset.add(wantFloor);

    }

    public void externalButton(int currFloor, boolean isUp) {//外部按钮
        if (isUp == true) {//true代表想上楼
            upset.add(currFloor);
           // up();
            if (currFloor == stay) {
                openDoor();
                closeDoor();
                upset.remove(currFloor);
            }
        } else if (isUp == false) {//false代表想下楼
            downset.add(currFloor);
           // down();
            if (currFloor == stay) {
                openDoor();
                closeDoor();
                downset.remove(currFloor);
            }
        }
    }

    public void working() {
        while (upset.isEmpty() == false || downset.isEmpty() == false) {
            if (upset.isEmpty() == false) {
                up();
            }
            else if (downset.isEmpty() == false) {
                down();
            }
        }
        pause();
    }
}