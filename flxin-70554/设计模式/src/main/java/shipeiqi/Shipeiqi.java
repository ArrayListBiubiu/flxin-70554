package shipeiqi;


/**
 * ��������ģʽ
 * 
 * ȱ�㣺VoltageAdapter�̳�Voltage220V����������϶ȣ�����Ҳ������д���������
 *
 */
public class Shipeiqi {
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.charging(new VoltageAdapter());
	}
}
//���������
class Voltage220V{
	//���220����ѹ
	public int output220V() {
		int src = 220;
		return src;
	}
}
//����ӿ�
interface IVoltage5V{
	public int output5V();
}
//��������
class VoltageAdapter extends Voltage220V implements IVoltage5V{
	public int output5V() {
		//��ȡ��220����ѹ
		int srcV = output220V();
		int dstV = srcV / 44;
		return dstV;
	}
}
class Phone{
	public void charging(IVoltage5V iVoltage5V) {
		if(iVoltage5V.output5V() == 5) {
			System.out.println("���");
		}else {
			System.out.println("���ܳ��");
		}
	}
}