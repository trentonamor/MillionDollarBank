public class Winner {
    int firstAmt;
    int secondAmt;
    public Winner(int first, int second) {
        firstAmt = first;
        secondAmt = second;
    }

    public int getFirstAmt() {
        return firstAmt;
    }

    public int getSecondAmt() {
        return secondAmt;
    }

    @Override
    public String toString() {
        return "(" + firstAmt + "," + secondAmt + ")";
    }
}
