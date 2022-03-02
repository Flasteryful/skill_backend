package comparator;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityMainProfileComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return o1.getMainProfile().compareTo(o2.getMainProfile());
    }
}
