package spring.hello;

public class ClassRefTest {
	private String name;
	private ContructorTest ctt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContructorTest getCtt() {
		return ctt;
	}
	public void setCtt(ContructorTest ctt) {
		this.ctt = ctt;
	}
	@Override
	public String toString() {
		return "ClassRefTest [name=" + name + ", ctt=" + ctt + "]";
	}
	

}
