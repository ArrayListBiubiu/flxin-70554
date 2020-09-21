package jianzaozhe;



/**
 * Դ���н�����ģʽ��ɫ������StringBuilder��
 * 1.Appendable�ӿڶ����˶��append()���󷽷�����Appendable�ǳ�������
 * 2.AbstractStringBuilderʵ����Appendable�ӿڷ����������AbstractStringBuilder�ǽ����ߣ�ֻ�ǲ���ʵ����
 * 3.StringBuilder���䵱��ָ���ߣ�ͬʱҲ�ǽ����ߣ����췽����ʵ������AbstractStringBuilder��ɣ�
 * 		��StringBuilder�̳�����Ӧ����
 * 
 *
 */

/**
 * ***����Ʒ�����Բ����ʱ���ʺ�ʹ�ý�����ģʽ
 * �����Ҫ��������������OtherHouse��ֻ��Ҫ������Ӧ�࣬�̳г�������AbstractBuilder���ɣ�
 * �����������Ķ���һ�н���Ĺ��̾���ָ���ߴ����ˣ����ھ۵����
 * 
 * @author Administrator
 *
 */
public class Jianzaozhe {
	public static void main(String[] args) {
		//����ͨ����
		CommonHouse commonHouse = new CommonHouse();
		//����ָ����
		HouseDirector director = new HouseDirector(commonHouse);	
		//��ɸǷ��ӣ����ز�Ʒ
		director.constructHouse();
		
		//�Ǹ�¥
		HighHouse highHouse = new HighHouse();
		//����ָ����
		director.setBuilder(highHouse);
		//��ɸǷ��ӣ����ز�Ʒ
		director.constructHouse();
		StringBuilder bu = new StringBuilder("hell");
		System.out.println(bu);
	}
}


//��Ʒ��ɫ->Product
class House{
	public String basic;
	public String wall;
	public String roofed;
}


//��������->Builder���ɽӿڣ��ɳ����ࣩ
abstract class AbstractBuilder{
	protected House house = new House();
	//���󷽷�
	public abstract void buildBasic();
	public abstract void buildWall();
	public abstract void buildRoored();
	
	public House getBuildHouse() {
		return house;
	}
}

//(��ͨ����)�����彨����->ConcreatBuilder
class CommonHouse extends AbstractBuilder{
	public void buildBasic() {
		System.out.println("��ػ�1M");
	}
	public void buildWall() {
		System.out.println("��ǽ1M");
	}
	public void buildRoored() {
		System.out.println("���ݶ�1M");
	}	
}

//����¥�������彨����->ConcreatBuilder
class HighHouse extends AbstractBuilder{
	public void buildBasic() {
		System.out.println("��ػ�10M");
	}
	public void buildWall() {
		System.out.println("��ǽ10M");
	}
	public void buildRoored() {
		System.out.println("���ݶ�10M");
	}
}
//ָ����->Director����ָ̬���������̣����շ��ؾ����Ʒ��1.����ͻ�������������̣�2.������Ʋ�Ʒ������������
class HouseDirector{
	AbstractBuilder builder = null;
	public HouseDirector(AbstractBuilder builder) {
		this.builder = builder;
	}
	public void setBuilder(AbstractBuilder builder) {
		this.builder = builder;
	}
	//���췿�ӵ����̽���ָ����
	public House constructHouse() {
		builder.buildBasic();
		builder.buildWall();
		builder.buildRoored();
		return builder.getBuildHouse();
	}
}


