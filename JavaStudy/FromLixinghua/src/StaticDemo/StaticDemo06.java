package StaticDemo;
class Demo{	// 定义Person类
	private static int count = 0 ;	// 所有对象共享此属性
	public Demo(){
		count++ ;					 // 只要有对象产生就应该自增
		System.out.println("产生了" + count + "个对象！") ;
	} 
};
public class StaticDemo06{
	public static void main(String args[]){
		new Demo() ;			// 增加新对象
		new Demo() ;			// 增加新对象
		new Demo() ;			// 增加新对象
	}
};
