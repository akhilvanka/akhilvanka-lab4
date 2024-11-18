public class Rotor {

    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        char endChar = rotorValues.charAt(rotorValues.length() - 1);
        rotorValues = endChar + rotorValues.substring(0, rotorValues.length() - 1);
        return rotorValues.charAt(0) == startChar;
    }
    

    public int indexOf(char c){
        return this.rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        return this.rotorValues.charAt(idx);
    }
}
    
