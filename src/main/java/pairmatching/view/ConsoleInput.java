package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements InputProvider {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
