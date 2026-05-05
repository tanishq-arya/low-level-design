package AmazonLocker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Locker {
    // Extension =>
    // 1. Compartment states => {AVAILABLE, RESERVED, OCCUPIED, NOT_AVAILABLE}
    // 2. Reserve a compartment first, then confirm deposit
    // 3. Size - update getAvailable() to find next size if available.

    private final Compartment[] compartments;
    private final Map<String, AccessToken> accessTokenMap;

    public Locker(Compartment[] compartments) {
        this.compartments = compartments;
        this.accessTokenMap = new HashMap<>();
    }

    public String depositPackage(Size size) throws Exception {
        /*
            Core Logic:
            1. Find compartment of right size
            2. Open the compartment
            3. Mark this compartment as occupied
            4. Generate code & return to user

            Edge case:
            1. No compartment of right size -> throw Error
        * */

        Compartment compartment = getAvailableCompartment(size);
        if (compartment == null) {
            throw new Exception("No available compartment of that size");
        }
        compartment.openLock();
        compartment.markOccupied();

        AccessToken token = new AccessToken(compartment);
        String code = token.getCode();
        accessTokenMap.put(code, token);

        return code;
    }

    private Compartment getAvailableCompartment(Size size) {
        /*
            1. Scan all compartments
            2. for each see if right size and free
            3. First that matches return it

            Edge cases:
            1. none available -> return null
        * */
        for(Compartment compartment: compartments) {
            if(compartment.getSize() == size && !compartment.isOccupied()) {
                return compartment;
            }
        }
        return null;
    }

    private Compartment getAvailableCompartment2(Size requestedSize) {
        /*
            1. Scan all compartments
            2. for each see if right size and free
            3. First that matches return it

            Edge cases:
            1. none available -> return null
        * */
        List<Size> sizesInOrder = List.of(Size.SMALL, Size.MEDIUM, Size.LARGE);
        int startIdx = sizesInOrder.indexOf(requestedSize);

        for (int i=startIdx; i< sizesInOrder.size(); i++) {
            for(Compartment compartment: compartments) {
                if(compartment.getSize() == sizesInOrder.get(i) && !compartment.isOccupied()) {
                    return compartment;
                }
            }
        }
        return null;
    }

    public boolean pickup(String code) throws Exception {
        /*
            Core Logic:
            1. Lookup the code to get accessToken
            2. get compartment
            3. open
            4. mark free
            5. remove accessCode from map

            Edge Case:
            1. token invalid -> throw
            2. token expired -> throw
        * */

        AccessToken token = accessTokenMap.get(code);
        if (token == null) {
            throw new Exception("Token invalid");
        }

        if (token.isExpired()) {
            throw new Exception("Token expired");
        }

        Compartment compartment = token.getCompartment();
        compartment.openLock();
        compartment.markFree(); // update compartment **
        accessTokenMap.remove(code);

        return true;
    }

    public void openExpiredCompartments() {
        /*
            1. Scan through all access tokens in mapping
            2. find the expired
            3. get compartment of each
            4. open those compartments
            --- removes packages
            5. mark the compartment available again
            6. remove accessCode from map ?? **

            Edge Case:
            1.
        * */

        for (Map.Entry<String, AccessToken> entry: accessTokenMap.entrySet()) {
            AccessToken token = entry.getValue();
            if (token.isExpired()) {
                Compartment compartment = token.getCompartment();
                compartment.openLock();
                compartment.markFree();
            }

            // Loop to clear out accessToken from map that are 3 month+ old
        }

    }
}
