public class RotacaoSimples {

  // ROTAÇÃO ESQUERDA SIMPLES
  public static No rotacaoEsquerdaSimples(No raiz, No inicial) {
    No direito = inicial.getDireito();
    direito.setPai(inicial.getPai());
    inicial.setDireito(direito.getEsquerdo());

    if (inicial.getDireito() != null) {
      inicial.getDireito().setPai(inicial);
    }

    direito.setEsquerdo(inicial);
    inicial.setPai(direito);

    if (direito.getPai() != null) {
      if (direito.getPai().getDireito() == inicial) {
        direito.getPai().setDireito(direito);
      } else if (direito.getPai().getEsquerdo() == inicial) {
        direito.getPai().setEsquerdo(direito);
      }
    }

    if (inicial.getValor() == raiz.getValor()) {
      raiz = direito;
    }

    inicial.setFb(inicial.getFb() + 1 - Math.min(direito.getFb(), 0));
    direito.setFb(direito.getFb() + 1 + Math.max(inicial.getFb(), 0));

    return direito;
  }

  // ROTAÇÃO DIREITA SIMPLES
  public static No rotacaoDireitaSimples(No raiz, No inicial) {
    No esquerdo = inicial.getEsquerdo();
    esquerdo.setPai(inicial.getPai());
    inicial.setEsquerdo(inicial.getDireito());

    if (inicial.getEsquerdo() != null) {
      inicial.getEsquerdo().setPai(inicial);
    }

    esquerdo.setDireito(inicial);
    inicial.setPai(esquerdo);

    if (esquerdo.getPai() != null) {
      if (esquerdo.getPai().getDireito() == inicial) {
        esquerdo.getPai().setDireito(esquerdo);
      } else if (esquerdo.getPai().getEsquerdo() == inicial) {
        esquerdo.getPai().setEsquerdo(esquerdo);
      }
    }

    if (inicial.getValor() == raiz.getValor()) {
      raiz = esquerdo;
    }

    inicial.setFb(inicial.getFb() - 1 - Math.max(esquerdo.getFb(), 0));
    esquerdo.setFb(esquerdo.getFb() - 1 + Math.min(inicial.getFb(), 0));
    return esquerdo;
  }
}