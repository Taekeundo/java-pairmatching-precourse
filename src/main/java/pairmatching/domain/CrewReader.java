package pairmatching.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CrewReader {

    public static List<Crew> readCrew(Course course) {
        String filename = course == Course.BACKEND ? "backend-crew.md" : "frontend-crew.md";
        List<Crew> crews = new ArrayList<>();

        try (InputStream is = CrewReader.class.getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    crews.add(new Crew(course, line.trim()));
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 크루 파일 읽기 실패");
        }

        return crews;
    }
}
