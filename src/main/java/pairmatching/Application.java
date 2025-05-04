package pairmatching;

import pairmatching.controller.PairMatchingProgram;
import pairmatching.view.ConsoleInput;

public class Application {
    public static void main(String[] args) {
        PairMatchingProgram program = new PairMatchingProgram(new ConsoleInput());
        program.run();
    }
}