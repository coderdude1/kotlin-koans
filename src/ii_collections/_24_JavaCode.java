package ii_collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import util.JavaCode;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class _24_JavaCode extends JavaCode {
    public Collection<String> doSomethingStrangeWithCollection(Collection<String> collection) {
        Map<Integer, List<String>> groupsByLength = Maps.newHashMap();

        //populate multimap with length->listOfStrings
        for (String s : collection) {
            List<String> strings = groupsByLength.get(s.length());
            if (strings == null) {
                strings = Lists.newArrayList();
                groupsByLength.put(s.length(), strings);
            }
            strings.add(s);
        }

        //find the count of the list with most entries
        int maximumSizeOfGroup = 0;
        for (List<String> group : groupsByLength.values()) { //this loop and next one can be combined with key entry set store the key of the longest list
            if (group.size() > maximumSizeOfGroup) {
                maximumSizeOfGroup = group.size();
            }
        }

        //now find the list with most entries and return it
        for (List<String> group : groupsByLength.values()) {
            if (group.size() == maximumSizeOfGroup) {
                return group;
            }
        }
        return null;
    }
}
