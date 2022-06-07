public class App {

  public static void main(String[] args) {
    Arvore avl = new Arvore();

    avl.inserir(30);
    avl.inserir(40);
    avl.inserir(24);
    avl.inserir(58);
    avl.inserir(48);
    avl.inserir(26);
    avl.inserir(11);
    avl.inserir(13);
    avl.inserir(14);

    System.out.println("--- in ordem ---");
    avl.inOrder(avl.raiz);

    System.out.println("--- pre ordem ---");
    avl.preOrder(avl.raiz);

    System.out.println("--- pos ordem ---");
    avl.posOrder(avl.raiz);
  }
}
