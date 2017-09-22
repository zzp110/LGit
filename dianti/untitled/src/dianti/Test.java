package dianti;
/**
 * Title:
 * Description:
 * Created Time: 2017/9/18 16:34
 *
 * @version 1.0
 *          To change this template use File | Settings | File and Code Templates.
 * @author: zzp1
 */
public class Test {
    public static void main(String[] args){
        Elevator ele = new Elevator();
        System.out.println("电梯在1楼");
        ele.externalButton(3,true);
        ele.internalButton(6);
        ele.externalButton(4,false);
        ele.externalButton(2,false);
        ele.working();
    }
}
