package CollectionDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest {

	public List<String> testList;
	public Set<String> testHashSet;
	public Map<String, String> testMap;

	public CollectionTest() {
		this.testList = new ArrayList<String>();
		this.testHashSet = new HashSet<String>();
		this.testMap = new HashMap<String, String>();
	}

	public void ArrayList_Test() {
		// 添加ArrayList的测试数据
		testList.add("Hello");
		testList.add("world");
		testList.add("I AM OK");

		// 求长度
		System.out.println("ArrayList的长度是：" + testList.size());

		// foreach方式的遍历
		for (Object obj : testList) {
			String s = (String) obj;
			System.out.println("取出了：" + s);
		}

	}

	public void HashSet_Test() {
		// 添加
		testHashSet.add("Yeah");
		testHashSet.add("Java");
		// 测试添加重复元素
		testHashSet.add("Java");
		// HashSet大小
		System.out.println("HashSet的长度是：" + testHashSet.size());
		// 遍历之
		for (Object obj : testHashSet) {
			String s = (String) obj;
			System.out.println("取出了：" + s);
		}
	}

	public void HashMap_Test() {
		// 添加数据
		testMap.put("你的名字", "无名氏");
		testMap.put("你的爱好", "Java编程");
		testMap.put("你的目标", "到互联网公司做开发");
		// 测试添加相同KEY
		testMap.put("你的名字", "周杰伦");
		// 看看大小
		System.out.println("HashMap的大小是:" + testMap.size());
		// 遍历(注意，要通过遍历Map.keySet而不是直接拿HashMap遍历！)
		for (String key : testMap.keySet()) {
			String s = testMap.get(key);
			System.out.println("取出了：" + key + ":" + s);

		}

	}

	public static void main(String[] args) {
		// 声明CollectionTest类的对象ct，该对象有三个属性list、set、map
		CollectionTest ct = new CollectionTest();
		// 测试ArrayList各项功能
		// ct.ArrayList_Test();
		// 测试HashSet各项功能
		// ct.HashSet_Test();
		// 测试HashMap的各项功能
		ct.HashMap_Test();
	}
}
