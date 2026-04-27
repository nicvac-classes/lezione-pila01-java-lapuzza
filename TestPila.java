//Implementare qui la classe TestPila, per l'esercizio delle parentesi bilanciate
public class TestPila {

    static boolean parentesiBilanciate(String espressione){
        Pila<Character> pila = new Pila<>();

        for(int i = 0; i < espressione.length(); ++i){
            char parentesi = espressione.charAt(i);

            if(parentesi == '{' || parentesi == '[' || parentesi == '('){
                pila.push(parentesi);
            }else if(parentesi == '}' || parentesi == ']' || parentesi == ')'){
                if(pila.isEmpty()){
                    return false;
                }

                char parentesi2 = pila.pop();

                if(!(parentesi == '}' && parentesi2 == '{' || parentesi == ']' && parentesi2 == '[' || parentesi == ')' && parentesi2 == '(')){
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String[] test = {"{[()]}", "{[(])}", "((()))", "(]", "{[}", ""};
        boolean[] atteso = {true, false, true, false, false, true};

        for (int i = 0; i < test.length; i++) {
            boolean risultato = parentesiBilanciate(test[i]);
            String esito = (risultato == atteso[i]) ? "✓" : "✗";
            System.out.println(esito + " \"" + test[i] + "\" → " + risultato);
        }
    }

}