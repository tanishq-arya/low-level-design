package ChessGame;

import java.util.Objects;

// Represents a square's coordinate on a 8x8 board. file a-h and rank 1-8
public class Coordinate {
    private final int file; // 0–7 for files ‘a’–‘h’ [columns]
    private final int rank; // 0–7 for ranks 1–8 [rows]

    public Coordinate(int file, int rank) {
        if (file < 0 || file > 7 || rank < 0 || rank > 7) {
            throw new IllegalArgumentException("Invalid coordinate: " + file + "," + rank);
        }
        this.file = file;
        this.rank = rank;
    }

    public static Coordinate fromAlgebraic(String notation) {
        if (notation.length() != 2) {
            throw new IllegalArgumentException("Invalid notation: " + notation);
        }

        char f = notation.charAt(0);
        char r = notation.charAt(1);

        int file = f-'a';
        int rank = r-'1';

        return new Coordinate(file, rank);
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate that)) return false;
        return file == that.file && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return  "" + (char)(file + 'a') + (char)(rank + '1');
    }
}