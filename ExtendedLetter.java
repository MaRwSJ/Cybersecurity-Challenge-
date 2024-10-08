
public class ExtendedLetter extends Letter{
	private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;
    
    /*
     *  Initializing the instance variables of the superclass
     *  super(c) where c is an arbitrary char
     *  Initializing the instance variables as follows:
     *  Content is set to the String parameter 
     *  Related is set to false
     *  Family is set to SINGLETON
     */
    
 public ExtendedLetter(String s){
        super('y');
        this.content = s;
        this.related = false;
        this.family = this.SINGLETON;
    }
    /**
     * Initializing the instance variables of the superclass
     * super(c) where c is an arbitrary char
     * Initializing the instance variables as follows:
     * Content is set to the String parameter s
     * Related is set to false
     * Family is set to the int parameter fam
     * @param s
     * @param fam
     */
    public ExtendedLetter(String s, int fam) {
        super('y'); 
        content = s;
        related = false;
        family = fam;
    }
    // Returns false if the parameter other is not an instanceOf ExtendedLetter
    public boolean equals(Object other) {
        if (!(other instanceof ExtendedLetter)) {
            return false;
        }
        
        ExtendedLetter otherLetter = (ExtendedLetter) other;

        if (otherLetter.family == this.family) {
            this.related = true; 
        }

        // Returns true if the content of this letter is equivalent to the other instance
        return otherLetter.content.equals(this.content);
    }
    // An overridden method that gives a String representation of this ExtendedLetterobject
    public String toString(){
        if(decorator() == "-" && this.related){
            return "." + this.content + ".";
        }
        return decorator() + this.content + decorator();
    }
    /**
     *Produces a letter-shaped array of Letter objects that is the same size as the array's parameter-received content size.
     *The i-th entry of the array letters will contain an ExtendedLetter object built using the constructor ExtendedLetter(content[i])
     * if the argument codes is null.
     *If codes is not null, an ExtendedLetter object constructed with the constructor ExtendedLetter(content[i],codes[i])
     * will be stored in array letter's entry at index i
     * @param content
     * @param codes
     * @return
     */

    public static Letter[] fromStrings(String[] content, int[] codes){
        Letter[] letters = new Letter[content.length];
        if(codes == null){
            for(int i = 0; i < content.length; i++){
                letters[i] = new ExtendedLetter(content[i]);
            }
        }
        else{
            for(int i = 0; i  < content.length; i++){
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }
}

   
