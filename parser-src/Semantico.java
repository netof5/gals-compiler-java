import java.util.LinkedHashMap;
import java.util.Map;

public class Semantico implements Constants
{
    private Map<String, String> tabelaSimbolos = new LinkedHashMap<>();

    private String tipoAtual;

    public void executeAction(int action, Token token) throws SemanticError
    {
        switch(action)
        {
            case 1:
                // Guarda o tipo atual: int, float, char, string, bool, void
                tipoAtual = token.getLexeme();
                break;

            case 2:
                // Insere identificador na tabela
                inserirIdentificador(token);
                break;

            case 3:
                // Verifica uso de identificador
                verificarIdentificador(token);
                break;
        }
    }

    private void inserirIdentificador(Token token) throws SemanticError
    {
        String nome = token.getLexeme();

        if(tabelaSimbolos.containsKey(nome))
        {
            throw new SemanticError(
                "Identificador já declarado: " + nome,
                token.getPosition()
            );
        }

        tabelaSimbolos.put(nome, tipoAtual);

        System.out.println("Inserido na tabela: " + nome + " - Tipo: " + tipoAtual);
    }

    private void verificarIdentificador(Token token) throws SemanticError
    {
        String nome = token.getLexeme();

        if(!tabelaSimbolos.containsKey(nome))
        {
            throw new SemanticError(
                "Identificador não declarado: " + nome,
                token.getPosition()
            );
        }

        System.out.println("Identificador usado: " + nome + " - Tipo: " + tabelaSimbolos.get(nome));
    }

    // =========================
    // RETORNA A TABELA
    // =========================
    public Map<String, String> getTabelaSimbolos()
    {
        return tabelaSimbolos;
    }
}