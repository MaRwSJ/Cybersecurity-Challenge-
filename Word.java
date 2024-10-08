
/**
 * This class stands in for the game's  word, 
 * which may contain any number of letters. 
 * A linearNode, which is a linked list of objects of type Letter,
 *  is used to represent this.
 */
public class Word {
	// A reference to the first node in the linked list representing the word corresponding to this object.
    private LinearNode<Letter> firstLetter;

    /**
     * Create the Word object from scratch such that the letters in the array "letters" are saved inside
     * its linked structure. 
     * The first node of the linked list must be the target of the instance variable firstLetter.
     * @param letters - array of Letter objects
     */
    public Word(Letter[] letters) {
        firstLetter = null;
        LinearNode<Letter> currentNode = firstLetter;
        for (Letter currentLetter : letters) {
            if (firstLetter == null) {
                firstLetter = new LinearNode<>(currentLetter);
                currentNode = firstLetter;
            } else {
                currentNode.setNext(new LinearNode<>(currentLetter));
                currentNode = currentNode.getNext();
            }
        }
    }
    /**
     * Creates a String with the following format: 
     * "Word: L1 L2 L3... Lk," where each Li represents the string that is produced 
     * when each Letter object in this Word is given the toSting method call.
     */

    
    public String toString() {
        StringBuilder output = new StringBuilder("Word: ");
        LinearNode<Letter> currentNode = firstLetter;
        while (currentNode != null) {
            output.append(currentNode.getElement()).append(" ");
            currentNode = currentNode.getNext();
        }
        return output.toString();
    }

    /**
     * takes a mystery word as a parameter and updates each of Letters’ “label”attribute
     *  contained in this Word object with respect to the mystery word returns true 
     *  if this word is identical in content to the mystery word
     * @param mystery Word containing the mystery letters
     * @return true if the mystery word is identical in content to the current word
     */
    public boolean labelWord(Word mystery) {
        LinearNode<Letter> currentNode = firstLetter;
        LinearNode<Letter> mysteryNode;
        while (currentNode != null) {
            Letter currentLetter = currentNode.getElement();
            mysteryNode = mystery.firstLetter;
            boolean wasLetterUsed = false;
            while (mysteryNode != null) {
                if (currentLetter.equals(mysteryNode.getElement())) {
                    
                    currentLetter.setUsed();
                    
                    wasLetterUsed = true;
                    break;
                }
              
                mysteryNode = mysteryNode.getNext();
            }
            
            if (!wasLetterUsed) {
                currentLetter.setUnused();
            }
            currentNode = currentNode.getNext();
        }
        
        currentNode = firstLetter;
        mysteryNode = mystery.firstLetter;

        while (currentNode != null && mysteryNode != null) {
            if (currentNode.getElement().equals(mysteryNode.getElement())) {
                currentNode.getElement().setCorrect();
            }
            currentNode = currentNode.getNext();
            mysteryNode = mysteryNode.getNext();
        }

        if (currentNode == null && mysteryNode == null) {
            // since both of these nodes are null, this means that the words are the same length
            currentNode = firstLetter;
            while (currentNode != null) {
                if (!currentNode.getElement().isCorrect()) {
                    return false;
                }
                currentNode = currentNode.getNext();
            }

            return true;
        }

        return false;
    }
}
