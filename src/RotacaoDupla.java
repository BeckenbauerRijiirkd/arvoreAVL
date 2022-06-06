
public class RotacaoDupla {
    // ROTAÇÃO ESQUERDA DUPLA
    public static No rotacaoEsquerdaDupla(No raiz, No no) {
        RotacaoSimples.rotacaoDireitaSimples(raiz, no.getDireito());
        return RotacaoSimples.rotacaoEsquerdaSimples(raiz, no);
    }

    // ROTAÇÃO DIREITA DUPLA
    public static No rotacaoDireitaDupla(No raiz, No no) {
        RotacaoSimples.rotacaoEsquerdaSimples(raiz, no.getEsquerdo());
        return RotacaoSimples.rotacaoDireitaSimples(raiz, no);
    }
}