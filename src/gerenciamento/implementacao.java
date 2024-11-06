package gerenciamento;

import java.util.ArrayList;
import java.util.List;

// implementação da interface 
public class implementacao implements interfacee {
    private List<String> frutas;

    // Construtor
    public implementacao() {
        frutas = new ArrayList<>();
    }

    // Add uma fruta ao array
    @Override
    public void addFruta(String fruta) {
        frutas.add(fruta);
    }

    // remove uma fruta do array
    @Override
    public void deleteFruta(String fruta) {
        frutas.remove(fruta);
    }

    // lista todas as frutas no array
    @Override
    public String[] listarFrutas() {
        return frutas.toArray(new String[0]);
    }
}
