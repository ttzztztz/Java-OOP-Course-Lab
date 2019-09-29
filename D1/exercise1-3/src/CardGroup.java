import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardGroup {
    private Card c1;
    private Card c2;
    private Card c3;

    public CardGroup(Card c1, Card c2, Card c3) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

	public void print() {
		System.out.println("#Group");
		c1.print();
		c2.print();
		c3.print();
		System.out.println("\n");
	}
    /*
     * Return the number of cards with the same number
     */
	private <T> Map<T, Long> aggregate(Function<Card, T> function) {
		return Stream.of(this.c1, this.c2, this.c3)
				.map(function)
				.collect(
						Collectors.groupingBy(
								Function.identity(),
								Collectors.counting()
						)
				);
	}

    public long numOfSameNumber() {
        Map<Integer, Long> aggregateSet = aggregate(Card::getNumber);

        long answer = 0L;
        for (Map.Entry<Integer, Long> entry : aggregateSet.entrySet()) {
            answer = Math.max(entry.getValue(), answer);
        }
        return answer; // to be replaced
    }

    /*
     * Return if all cards in the group are of the same suit.
     */
    public boolean ofSameSuit() {
        Map<String, Long> aggregateSet = aggregate(Card::getSuit);

        return aggregateSet.size() == 1; // to be replaced
    }

    public long getLevel() {
    	if (this.ofSameSuit()) {
    		return 4L;
		} else {
			return this.numOfSameNumber();
		}
    }

    /*
     * Compare if it is bigger than CardGroup c
     * @param c another CardGroup
     * @return true if it is bigger than c, false otherwise.
     */
    public boolean compare(CardGroup c) {
		long level1 = this.getLevel();
		long level2 = c.getLevel();

		return level1 > level2;
	}
}
