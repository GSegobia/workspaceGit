package arvores;

public class Main {

	public static void main(String[] args) {

		ArvoreB tree = new ArvoreB(3);
		
		tree.insere(10);
		tree.insere(20);
		tree.insere(5);
		tree.insere(6);
		tree.insere(12);
		tree.insere(30);
		tree.insere(7);
		tree.insere(17);
		
		if(tree.busca(11) != null)
			System.out.println("Achei");
		else
			System.out.println("Falhei");
	}

}
