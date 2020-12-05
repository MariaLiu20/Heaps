/**
 * contains methods addEltTester() and remMinElt()
 */
public class HeapChecker {
    /**
     * checks whether the binary tree is a valid result of performing addElt() on the original heap
     * @param hOrig
     * @param elt
     * @param hAdded
     * @return boolean indicating whether the binary tree is a valid result
     */
    public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
        int hasElement = 0;
        int hasElementOne = 0;
        int count = 0;
        if (hAdded.isValidHeap()) {
            if (hOrig.convertToList().size() == hAdded.convertToList().size() - 1) {
                for (Integer i : hOrig.convertToList()) {         // checks if elt is a duplicate
                    if (i == elt)
                        hasElement++;
                    for (Integer j : hAdded.convertToList()) {  // checks if has same elements
                        if (i == j) {
                            count = 0;
                            break;
                        }
                        if (j == elt)
                            hasElementOne++;

                        count++;
                    }
                }
            }
            if ((hOrig.convertToList().size() == 0 && hAdded.convertToList().size() == 1) || (hOrig.convertToList().size() == 1 && hAdded.convertToList().size() == 2))
                return true;
            if(hOrig.convertToList().size() == hAdded.convertToList().size() - 1)
                if(count == 0)
                    return true;
            if (count == 0 || count == 1) {
                if (hasElement == hasElementOne)
                    return false;
                else if (hasElement < hasElementOne)
                    return true;
            }
            else
                return false;
        }
        return false;
    }

    /**
     * checks whether the binary tree is a valid result of performing remMinElt() on the original heap
     * @param hOrig
     * @param hRemoved
     * @return boolean indicating whether the binary tree is a valid result
     */
    boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
        int eltRemoved = hOrig.getNode();
        int eltCountOfOG = 0;
        int eltCountOfRemoved = 0;
        int count = 0;
        if (hRemoved.isValidHeap()) {
            if (hOrig.convertToList().size() -1 ==  hRemoved.convertToList().size()) {
                for(Integer i : hOrig.convertToList()) {
                    if(i == eltRemoved)                         //num occurrences of removed element
                        eltCountOfOG++;
                    for(Integer j : hRemoved.convertToList()) {
                        if(i == j) {
                            count = 0;
                            break;
                        }
                        if(j == eltRemoved)
                             eltCountOfRemoved++;

                        count++;
                    }
                }
                if (count >= 0 && eltCountOfRemoved < eltCountOfOG)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
}
