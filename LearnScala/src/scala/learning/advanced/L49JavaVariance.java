package scala.learning.advanced;

import java.util.ArrayList;
import java.util.List;

/*
 * Java不支持形变
 * 但是Java的泛型支持上下界通配符
 * ? extends Object, ? super String之类的语法
 */
public class L49JavaVariance {
	
	static class Food{}
	static class Fruit extends Food{}
	static class Apple extends Fruit{}
	static class RedApple extends Apple{}
	
	static void callFunc(List<? extends Fruit> list) {
		for (Fruit f: list) { // 上界表明list里的元素都是Fruit的子类，所以可以cast成Fruit类型
			
		}
		return;
	}
	
	static void callFunc2(List<? super Fruit> list) {
		for (Object f: list) { // 下界表明list里的元素都是Fruit的父类，但是不确定是哪一个父类，所以只能cast成所有这些可能为Fruit父类的公共父类Object了
			
		}
		return;
	}

	public static void main(String...args) {
		List<Food> foodList = new ArrayList<Food>();
		List<Apple> appleList = new ArrayList<Apple>();
//		callFunc(foodList);
		callFunc(appleList);
		
		callFunc2(foodList);
//		callFunc2(appleList);
	}
}
