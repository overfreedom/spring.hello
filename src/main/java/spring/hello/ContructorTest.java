package spring.hello;

public class ContructorTest {
	private String name;
	private String parent;
	private int refertime;
	private double createtime;
	
	//���������췽������ͬ�Ĳ�������
	
	public ContructorTest(String name, String parent, double createtime) {
		super();
		this.name = name;
		this.parent = parent;
		this.createtime = createtime;
	}


	public ContructorTest(String name, String parent, int refertime) {
		super();
		this.name = name;
		this.parent = parent;
		this.refertime = refertime;
	}


	@Override
	public String toString() {
		return "ContructorTest [name=" + name + ", parent=" + parent + ", refertime=" + refertime + ", createtime="
				+ createtime + "]";
	}

	

}
