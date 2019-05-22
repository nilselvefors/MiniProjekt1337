package s;

public class testar {
	
	public static void main(String[] args) {
		HashTabel tesTabel = new HashTabel(101);
		HashTabel tesTabel2 = new HashTabel(101);
		
		for (int i = 0; i < 100; i++) {
			tesTabel.addHash(i+"");
		}
		System.out.println(tesTabel.sizeWords());
		for (int i = 0; i < 100; i++) {
			System.out.println(tesTabel.find(i+""));
		}
		System.out.println(tesTabel.sizeOfHashTabel());
		System.out.println(tesTabel2.isEmpty());
		for (int i = 0; i < 50; i++) {
			tesTabel2.addHash(i+"");
		}
		System.out.println(tesTabel2.isEmpty());
		System.out.println(tesTabel.sizeWords());
		System.out.println(tesTabel2.sizeWords());
	}

}
