package pecs;
import java.util.ArrayList;
import java.util.List;

import pecs.po.Banana;
import pecs.po.Fruit;

import static java.lang.System.out;

/**
 * REF:
 * https://www.ithome.com.tw/voice/116987
 *
 */

public class TestPECS {
	
	public static void main(String[] args) {
		/**
		 * 共變性、逆變性
		 * Producer extends, Consumer super
		 * 		
		**/
		//List<Fruit> fruits1 = new ArrayList<Banana>();
		//List<Banana> basket = new ArrayList<Fruit>();
		
		List<? extends Fruit> fruits = new ArrayList<Banana>();
		List<? super Banana> basket = new ArrayList<Fruit>();
		
		List<Banana> bananaList = new ArrayList<Banana>();
		List<Fruit> fruitList = new ArrayList<Fruit>();
		
		Fruit fr1= new Fruit();
		Banana ba1= new Banana();
		/*編譯時期看到的型態來檢查 error
		fruits.add(ba1);
		fruits.add(fr1);*/

		//支援共變性
		fruits.forEach(out::println);		
		basket.forEach(out::println);
		
		//支援逆變性
		addOne(bananaList);
		addOne(fruitList);
		
		out.println(bananaList.size());
		out.println(fruitList.size());
	}
	
	
	static void addOne(List<? super Banana> basket){
		basket.add(new Banana());
	}
	

}
