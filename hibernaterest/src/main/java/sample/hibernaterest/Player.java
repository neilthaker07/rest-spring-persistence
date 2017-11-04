package sample.hibernaterest;

public class Player {
	
	public Player()
	{
		
	}
	public Player(String name, int no)
	{
		this.name = name;
		this.no = no;
	}
	
	private String name;
	private int no;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
