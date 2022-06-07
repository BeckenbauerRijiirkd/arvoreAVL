
public class Arvore {

  public No raiz;;

  // INSERIR
  public void inserir(int valor) {
    No no = new No(valor);
    if (raiz == null) {
      System.out.println(valor + " Inserido na Raiz");
      raiz = no;
    } else {
      No pai = acharPai(valor, raiz);
      no.setPai(pai);
      if (pai.getValor() > valor) {
        System.out.println(valor + " Inserido a Esquerda de " + pai.getValor());
        pai.setEsquerdo(no);
      } else if (pai.getValor() < valor) {
        System.out.println(valor + " Inserido a Direita de " + pai.getValor());
        pai.setDireito(no);
      }
      ajustarFb(no.getValor(), pai);
    }
  }

  // ACHAR PAI
  public No acharPai(int valor, No no) {
    if (valor < no.getValor() && no.getEsquerdo() != null) {
      return acharPai(valor, no.getEsquerdo());
    } else if (valor > no.getValor() && no.getDireito() != null) {
      return acharPai(valor, no.getDireito());
    } else {
      return no;
    }
  }

  public void ajustarFb(int valor, No pai) {
    if (pai != null) {
      if (valor > pai.getValor()) {
        pai.setFb(pai.getFb() - 1);
        if (pai.getFb() < -1) {
          if (pai.getDireito() != null && pai.getDireito().getFb() > 0) {
            System.out.println("** Rotacao Esquerda Dupla em " + pai.getValor());
            pai = RotacaoDupla.rotacaoEsquerdaDupla(this.raiz, pai);
          } else if (pai.getDireito() != null && pai.getDireito().getFb() <= 0) {
            System.out.println("** Rotacao Esquerda Simples em " + pai.getValor());
            pai = RotacaoSimples.rotacaoEsquerdaSimples(this.raiz, pai);
          }
        }
        if (pai.getPai() != null && pai.getFb() != 0) {
          ajustarFb(pai.getValor(), pai.getPai());
        }
      } else if (valor < pai.getValor()) {
        pai.setFb(pai.getFb() + 1);
        if (pai.getFb() > 1) {
          if (pai.getEsquerdo() != null && pai.getEsquerdo().getFb() < 0) {
            System.out.println(" ** rotacao direita dupla em " + pai.getValor());
            pai = RotacaoDupla.rotacaoDireitaDupla(this.raiz, pai);
          } else if (pai.getEsquerdo() != null && pai.getEsquerdo().getFb() >= 0) {
            System.out.println("** rotacao direita simples em " + pai.getValor() + "(" + pai.getFb() + ")");
            pai = RotacaoSimples.rotacaoDireitaSimples(this.raiz, pai);
          }
        }
        if (pai.getPai() != null && pai.getFb() != 0) {
          ajustarFb(pai.getValor(), pai.getPai());
        }
      }
    }

    System.out.println("No:" + pai.getValor() + " -- Fator De Balançeamento: " + pai.getFb());
  }

  // IN ORDER
  public void inOrder(No no) {
    if (no.getEsquerdo() != null) {
      inOrder(no.getEsquerdo());
    }
    System.out.println(no.getValor() + " (" + no.getFb() + ")");
    if (no.getDireito() != null) {
      inOrder(no.getDireito());
    }
  }

  // PRE ORDER
  public void preOrder(No no) {
    System.out.println(no.getValor() + " (" + no.getFb() + ")");
    if (no.getEsquerdo() != null) {
      inOrder(no.getEsquerdo());
    }
    if (no.getDireito() != null) {
      inOrder(no.getDireito());
    }
  }

  // POS ORDER
  public void posOrder(No no) {
    if (no.getEsquerdo() != null) {
      inOrder(no.getEsquerdo());
    }
    if (no.getDireito() != null) {
      inOrder(no.getDireito());
    }
    System.out.println(no.getValor() + " (" + no.getFb() + ")");
  }

  public No getRaiz() {
    return this.raiz;
  }

  public void setRaiz(No raiz) {
    this.raiz = raiz;
  }
}
