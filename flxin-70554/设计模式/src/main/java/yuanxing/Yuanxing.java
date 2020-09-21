package yuanxing;

import java.util.Arrays;

/**
 * ԭ�����ģʽ
 * ʹ��Object���clone������ʵ�������ʵ��Cloneable�ӿ�
 *
 */
public class Yuanxing {
	public static void main(String[] args) throws CloneNotSupportedException {
		int[] arr = {1,2,3};
		Sheep s = new Sheep("����",2,arr);
		Sheep s2 = (Sheep) s.clone();
		System.out.println("s==s2:"+(s==s2));
		System.out.println("s.name==s2.name:     "+(s.name==s2.name));
		System.out.println("s.age==s2.age:     "+(s.age==s2.age));
		System.out.println("s.arr==s2.arr:     "+(s.arr==s2.arr));
		s2.arr[0] = 100;
		System.out.println(s);
		System.out.println(s2);

	}
}

/**
 * ������ܣ�
 * 1.���������Խ��и��ƣ������������͡��������͡�
 * 
 * 2.ʵ�ַ�ʽһ����дclone()������ʵ�������
 * 3.ʵ�ַ�ʽ����ͨ���������л�ʵ�������
 */


/**
 * ǳ�������ܣ�
 * 1.���ڻ����������͵ĳ�Ա������ǳ��������ֵ���ݣ�Ҳ���ǽ�����ֵ����һ�ݸ��¶���
 * 2.���������������͵ĳ�Ա������������ĳ�����顢ĳ�������ǳ�����������ô��ݣ�Ҳ���ǽ��ڴ��ַ����һ�ݸ��¶���
 * 3.ǳ����Ĭ��ʹ�õ���clone()������ʵ�֡�super.clone()��
 * 4.��¡����ʹ�õ���ǳ������
 *
 */

class Sheep implements Cloneable{
	public String name;
	public int age;
	public int[] arr;
	public Sheep(String name, int age, int[] arr) {
		super();
		this.name = name;
		this.age = age;
		this.arr = arr;
	}
	public String toString() {
		return "Sheep [name=" + name + ", age=" + age + ", arr=" + Arrays.toString(arr) + "]";
	}
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}