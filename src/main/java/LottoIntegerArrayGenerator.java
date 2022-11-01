import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoIntegerArrayGenerator implements IntegerArrayGenerator {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1,46).boxed().collect(Collectors.toList());

    @Override
    public List<Integer> getIntegerArray() {
        Collections.sort(LOTTO_NUMBERS);
        Collections.shuffle(LOTTO_NUMBERS);
        return new ArrayList<>(LOTTO_NUMBERS.subList(0, 6));
    }
}
