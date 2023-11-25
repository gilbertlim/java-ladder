package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.domain.*;
import ladder.view.InputView;

import static ladder.view.ResultView.personNames;
import static ladder.view.ResultView.result;

public class LadderApplication {

    public static void main(String[] args) {
        PersonNames personNames = InputView.inputNames();
        int maxHeight = InputView.inputLadderMaxHeight();

        PointGenerator generator = new PointGenerator();
        List<Line> lines = IntStream.range(0, maxHeight)
            .mapToObj(n -> generator.generate(personNames.size()))
            .collect(Collectors.toList());

        personNames(personNames);
        result(lines);
    }
}
