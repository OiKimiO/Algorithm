package week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question5 {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        Map<String,Integer> head = new HashMap<>();
        Map<String, List<Main.PlayHist>> item = new HashMap<>();

        // head
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            Main.PlayHist playHist = new Main.PlayHist(i,play);
            List<Main.PlayHist> playHists;

            if(head.getOrDefault(genre,0) == 0){
                head.put(genre, play);
                playHists = new ArrayList<>();
                playHists.add(playHist);
            }else{
                head.put(genre, head.get(genre)+play);
                playHists = item.get(genre);
                playHists.add(playHist);
            }

            item.put(genre, playHists);
        }

        // 내림차순 정렬
        List<String> keySet = new ArrayList<>(head.keySet());
        keySet.sort((o1, o2) -> head.get(o2).compareTo(head.get(o1)));
        StringBuffer sb = new StringBuffer();
        for (String key : keySet) {
            int count = 0;
            List<Main.PlayHist> playHists = item.get(key);

            // play가 높은 순서로, 만약 play가 같다면 idx가 낮은 순서로 정렬
            playHists.sort((p1, p2) -> {
                if (p1.play != p2.play) {
                    return Integer.compare(p2.play, p1.play); // play가 높은 순서
                } else {
                    return Integer.compare(p1.idx, p2.idx); // play가 같으면 idx가 낮은 순서
                }
            });

            for (Main.PlayHist playHist : playHists) {
                if(count == 2){
                    break;
                }
                sb.append(playHist.idx+",");

                count++;
            }
        }

        String[] split = sb.subSequence(0, sb.length() - 1).toString().split(",");
        int length = split.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            int i1 = Integer.parseInt(split[i]);
            answer[i] = i1;
        }
    }

    static class PlayHist{
        int idx;
        int play;

        public PlayHist(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }
}
