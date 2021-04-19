package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author marckoch
 */
public class GridlandMetro {

    static class Track {

        long start;
        long end;

        public Track(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getLength() {
            return end - start + 1;
        }

        @Override
        public String toString() {
            return "Track{" + "start=" + start + ", end=" + end + '}';
        }
    }

    // The main function that takes a set of intervals, merges
    // overlapping intervals and prints the result
    // https://www.geeksforgeeks.org/merging-intervals/
    // mergeIntervalls
    static void mergeTracks(List<Track> tracks) {
        if (tracks.isEmpty()) {
            return;
        }

        Stack<Track> s = new Stack<>();

        // sort the intervals in INcreasing order of start time
        tracks.sort((o1, o2) -> {
            return Long.compare(o1.start, o2.start);
        });

        s.push(tracks.get(0));

        // Start from the next interval and merge if necessary
        for (int i = 1; i < tracks.size(); i++) {
            // get interval from stack top
            Track top = s.peek();
            Track currentTrack = tracks.get(i);

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < currentTrack.start) {
                s.push(tracks.get(i));
            } // Otherwise update the ending time of top if ending of current
            // interval is more
            else if (top.end < currentTrack.end) {
                top.end = currentTrack.end;
            }
        }

        // stack now contains merged intervals, 
        // replace list with contents of stack
        //System.err.println("stack " + s);
        tracks.clear();
        while (!s.empty()) {
            tracks.add(s.pop());
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long n = in.nextLong();
            long m = in.nextLong();
            int nrOfTracks = in.nextInt();
            Map<Integer, List<Track>> tracks = new HashMap<>();
            for (int i = 0; i < nrOfTracks; i++) {
                int row = in.nextInt();
                if (!tracks.containsKey(row)) {
                    tracks.put(row, new ArrayList<>());
                }
                tracks.get(row).add(new Track(in.nextLong(), in.nextLong()));
            }

            //System.err.println("tracks before merge: " + tracks);
//            for (List<Track> trackList : tracks.values()) {
//                mergeTracks(trackList);
//            }
            //System.err.println("tracks after merge: " + tracks);

            long nrOfBlockedCells = 0L;
            for (List<Track> trackList : tracks.values()) {
                mergeTracks(trackList);
                
                for (Track track : trackList) {
                    nrOfBlockedCells += track.getLength();
                }
            }
            long result = (n * m) - nrOfBlockedCells;
            System.out.println(result);
        }
    }
}
