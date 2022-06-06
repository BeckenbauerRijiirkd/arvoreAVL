public class App{

    public static void main(String[] args) {
      Arvore avl = new Arvore();
      
      avl.inserir(15);
      avl.inserir(8);
      avl.inserir(90);
      avl.inserir(44);
      avl.inserir(65);
      avl.inserir(9);
      avl.inserir(7);
      avl.inserir(5);
      avl.inserir(6);

      
      System.out.println("--- in ordem ---");
      avl.inOrder(avl.raiz);
    }
  }
  