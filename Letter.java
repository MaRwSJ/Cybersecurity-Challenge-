
public class Letter{
	/**
	 * @author Marwa J
	 */
    private char letter;
    private int label;
    private static final int UNSET = 0, UNUSED = 1, USED = 2, CORRECT = 3;
	public static final String Label = null;
    //Initialize label to UNSET and set the value of instance variable letter to c
    public Letter(char c){
        label = UNSET;
        letter = c;
    }
    //First checking whether otherObject is of the class Letter, and if not the value false is given
    public boolean equals(Object otherObject){

        if(otherObject instanceof Letter){
            Letter object = (Letter) otherObject;
            if (this.letter == object.letter){
                return true;
            }
            return false;
        }
        return false;
    }
    /**
     * 
     * @return
     */
    
    /*
     * Returning “+” (if the “label” attribute is USED),
     *  “-“ (if the “label” attribute is UNUSED), 
     *  “!(if the “label” attribute is CORRECT), or “ “ 
     */
    public String decorator() {
        if(label == UNSET){
            return " ";
        }
        if(label == UNUSED){
            return "-";
        }
        if(label == USED){
            return "+";
        }
        if(label == CORRECT){
            return "!";
        }
        return "";
    }
    /*
     * A method that is overridden and uses the assistance method decorator to provide a representation of the letter and label.
     * The String is of the type "dCd," with C denoting this object's "letter" attribute and d denoting the String 
     * returned by the decorator() method.
     */
    @Override
    public String toString(){
        return decorator() + letter + decorator();
    }
    // using this to change value of attribute "label" to UNUSED
    public void setUnused(){
        label = UNUSED;
    }
    // using this to changed value of attribute 'label to USED
    public void setUsed(){
        label = USED;
    }
    // using to change value of attribute 'label' to Correct
    public void setCorrect(){
        label = CORRECT;
    }
    /**
     * 
     * @return
     * Returns true if attribute 'label' to UNUSED
     * otherwise returns false
     */
    
    public boolean isUnused(){
        return label == UNUSED;
    }
    /**
     * 
     * @param s
     * @return
     * Produces an array of objects of the class Letter from the string s given as parameter
     */

    public static Letter[] fromString(String s){
        Letter[] array = new Letter[s.length()];
        for(int i = 0; i <s.length(); i++){
            array[i] = new Letter(s.charAt(i));
        }
        return array;
    }

	public Object getCharacter() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCorrect() {
		// TODO Auto-generated method stub
		return false;
	}

}
