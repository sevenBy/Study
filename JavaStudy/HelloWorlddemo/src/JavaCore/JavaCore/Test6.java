package JavaCore;

import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的姓名：");
		String name = sc.nextLine();
		System.out.println("请输入你的年龄：");
		int age = sc.nextInt();
		System.out.println("请输入你的工资：");
		float salary = sc.nextFloat();
		System.out.println("你的信息如下：");
		System.out.println("姓名：" + name + "\n" + "年龄：" + age + "\n" + "工资：" + salary);
		sc.close();
	}

}
