package jianzaozhe;



/**
 * 源码中建造者模式角色分析（StringBuilder）
 * 1.Appendable接口定义了多个append()抽象方法，即Appendable是抽象建造者
 * 2.AbstractStringBuilder实现了Appendable接口方法，这里的AbstractStringBuilder是建造者，只是不能实例化
 * 3.StringBuilder即充当了指挥者，同时也是建造者，建造方法的实现是由AbstractStringBuilder完成，
 * 		而StringBuilder继承了相应方法
 * 
 *
 */

/**
 * ***当产品差异性不大的时候，适合使用建造者模式
 * 如果想要创建其他的类如OtherHouse，只需要创建相应类，继承抽象建造者AbstractBuilder即可，
 * 无需做其他改动，一切建造的过程均由指挥者处理了，高内聚低耦合
 * 
 * @author Administrator
 *
 */
public class Jianzaozhe {
	public static void main(String[] args) {
		//盖普通房子
		CommonHouse commonHouse = new CommonHouse();
		//创建指挥者
		HouseDirector director = new HouseDirector(commonHouse);	
		//完成盖房子，返回产品
		director.constructHouse();
		
		//盖高楼
		HighHouse highHouse = new HighHouse();
		//重置指挥者
		director.setBuilder(highHouse);
		//完成盖房子，返回产品
		director.constructHouse();
		StringBuilder bu = new StringBuilder("hell");
		System.out.println(bu);
	}
}


//产品角色->Product
class House{
	public String basic;
	public String wall;
	public String roofed;
}


//抽象建造者->Builder（可接口，可抽象类）
abstract class AbstractBuilder{
	protected House house = new House();
	//抽象方法
	public abstract void buildBasic();
	public abstract void buildWall();
	public abstract void buildRoored();
	
	public House getBuildHouse() {
		return house;
	}
}

//(普通房子)，具体建造者->ConcreatBuilder
class CommonHouse extends AbstractBuilder{
	public void buildBasic() {
		System.out.println("打地基1M");
	}
	public void buildWall() {
		System.out.println("砌墙1M");
	}
	public void buildRoored() {
		System.out.println("盖屋顶1M");
	}	
}

//（高楼），具体建造者->ConcreatBuilder
class HighHouse extends AbstractBuilder{
	public void buildBasic() {
		System.out.println("打地基10M");
	}
	public void buildWall() {
		System.out.println("砌墙10M");
	}
	public void buildRoored() {
		System.out.println("盖屋顶10M");
	}
}
//指挥者->Director，动态指定制作流程，最终返回具体产品，1.隔离客户与对象生产过程，2.负责控制产品对象生产过程
class HouseDirector{
	AbstractBuilder builder = null;
	public HouseDirector(AbstractBuilder builder) {
		this.builder = builder;
	}
	public void setBuilder(AbstractBuilder builder) {
		this.builder = builder;
	}
	//建造房子的流程交给指挥者
	public House constructHouse() {
		builder.buildBasic();
		builder.buildWall();
		builder.buildRoored();
		return builder.getBuildHouse();
	}
}


