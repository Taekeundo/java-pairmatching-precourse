package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairMatcher {

    public static List<String> match(List<Crew> crews) {
        List<String> shuffled = new ArrayList<>();
        for (Crew crew : crews) {
            shuffled.add(crew.getName());
        }
        Randoms.shuffle(shuffled);

        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < shuffled.size(); i += 2) {
            String pair = shuffled.get(i);
            if (i + 1 < shuffled.size()) {
                pair += " - " + shuffled.get(i + 1);
            }
            pairs.add(pair);
        }
        return pairs;
    }
}
