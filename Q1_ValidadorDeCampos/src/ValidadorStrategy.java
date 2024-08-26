public interface ValidadorStrategy {
    boolean valida(String valor);
}

class ValidadorInteiro implements ValidadorStrategy {
    public boolean valida(String valor){
        for(int i=0;i<valor.length();i++){
            if (!Character.isDigit(valor.charAt(i))){
                return false;
            }
        }
        return true;
    }
}

class ValidadorMatricula implements ValidadorStrategy {
    public boolean valida(String valor){
        ValidadorInteiro valInt = new ValidadorInteiro();
        if (!valInt.valida(valor)){
            return false;
        }else{
            int sum = 0;
            for(int i=0;i<valor.length()-1;i++){
                sum += Character.getNumericValue(valor.charAt(i));
            }
            int verificador = sum%10;
            if (verificador == Character.getNumericValue(valor.charAt(valor.length()-1))){
                return true;
            }
        }
        return false;
    }
}

class ValidadorEmail implements ValidadorStrategy {
    public boolean valida(String valor){
        int posA = valor.indexOf('@');
        int posPt = valor.indexOf('.');
        if (posA <= 0 || posPt <= 0) 
            return false;
        return true;
    }
}
