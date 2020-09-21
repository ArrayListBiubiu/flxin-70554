package shipeiqi;


/**
 * 类适配器模式
 * 
 * 缺点：VoltageAdapter继承Voltage220V，增加了耦合度，但是也可以重写，更加灵活
 *
 */
public class Shipeiqi {
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.charging(new VoltageAdapter());
	}
}
//被适配的类
class Voltage220V{
	//输出220伏电压
	public int output220V() {
		int src = 220;
		return src;
	}
}
//适配接口
interface IVoltage5V{
	public int output5V();
}
//适配器类
class VoltageAdapter extends Voltage220V implements IVoltage5V{
	public int output5V() {
		//获取到220伏电压
		int srcV = output220V();
		int dstV = srcV / 44;
		return dstV;
	}
}
class Phone{
	public void charging(IVoltage5V iVoltage5V) {
		if(iVoltage5V.output5V() == 5) {
			System.out.println("充电");
		}else {
			System.out.println("不能充电");
		}
	}
}