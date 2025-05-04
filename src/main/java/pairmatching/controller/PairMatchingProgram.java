package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewReader;
import pairmatching.domain.Level;
import pairmatching.service.PairMatcher;
import pairmatching.view.InputProvider;
import pairmatching.view.InputView;

import java.util.*;

public class PairMatchingProgram {

    private final InputProvider inputProvider;
    private final Map<String, List<String>> pairResults = new HashMap<>();

    public PairMatchingProgram(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public void run() {
        while (true) {
            InputView.showMenu();
            String input = inputProvider.readLine();

            if (input.equalsIgnoreCase("Q")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            if (input.equals("1")) {
                matchPair();
                continue;
            }

            if (input.equals("2")) {
                searchPair();
                continue;
            }

            if (input.equals("3")) {
                initializePair();
                continue;
            }

            InputView.showError("올바르지 않은 입력입니다.");
        }
    }

    private void matchPair() {
        InputView.showCourseAndMission();
        String[] inputs = inputProvider.readLine().split(",");
        Course course = Course.from(inputs[0].trim());
        Level level = Level.from(inputs[1].trim());
        String mission = inputs[2].trim();

        String key = course.getName() + "," + level.getName() + "," + mission;

        if (pairResults.containsKey(key)) {
            System.out.println("기존 매칭이 존재합니다. 재매칭 하시겠습니까? (네/아니오)");
            String retry = inputProvider.readLine();
            if (!retry.equalsIgnoreCase("네")) {
                return;
            }
        }

        List<Crew> crews = CrewReader.readCrew(course);
        List<String> pairs = PairMatcher.match(crews);
        pairResults.put(key, pairs);

        System.out.println("페어 매칭 결과입니다.");
        for (String pair : pairs) {
            System.out.println(pair);
        }
    }

    private void searchPair() {
        InputView.showCourseAndMission();
        String key = inputProvider.readLine();

        if (!pairResults.containsKey(key)) {
            InputView.showError("매칭 이력이 없습니다.");
            return;
        }

        System.out.println("페어 매칭 결과입니다.");
        for (String pair : pairResults.get(key)) {
            System.out.println(pair);
        }
    }

    private void initializePair() {
        pairResults.clear();
        System.out.println("초기화 되었습니다.");
    }
}
