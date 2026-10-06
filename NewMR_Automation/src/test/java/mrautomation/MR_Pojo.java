package mrautomation;

public class MR_Pojo {
	
	public MR_Pojo() {
		System.out.println("constructor demo");
		
	}
	public MR_Pojo(int i) {
		System.out.println(i);
		
	}
	
	public static void main(String[] args) {
		MR_Pojo mrp= new MR_Pojo();
		MR_Pojo mrp1= new MR_Pojo(5);
		
	}
}
