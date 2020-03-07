import java.util.*;

public class Hash04 {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genre = new HashMap<>();
        List<String> genreList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
        }

        genre.entrySet().forEach(t -> genreList.add(t.getKey()));
        Collections.sort(genreList, (String o1, String o2) -> genre.get(o2) - genre.get(o1));

        for (String name : genreList) {
            List<Integer> musicRank = new ArrayList<>();
            Map<Integer, Integer> musicCount = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(name)) {
                    musicCount.put(i, plays[i]);
                    musicRank.add(i);
                }
            }
            Collections.sort(musicRank, (Integer o1, Integer o2) -> musicCount.get(o2) - musicCount.get(o1));

            for (int i = 0; i < 2; i++) {
                result.add(musicRank.get(i));
                if (musicRank.size() == 1) {
                    break;
                }
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] result = solution(new String[]{"classic", "pop", "classic", "classic", "pop", "music"},
                new int[]{500, 600, 150, 800, 2500, 2000});
        for (int r: result) {
            System.out.print(r + " ");
        }
    }

}
