import java.util.*;
class Solution {
    static class Song {
        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    // 노래를 정렬하는 함수
    private void sortSongs(List<Song> songs) {
        songs.sort((a, b) -> {
            if (b.play == a.play) {
                return a.id - b.id; // 재생 횟수가 같으면 고유 번호 오름차순
            }
            return b.play - a.play; // 재생 횟수 내림차순
        });
    }

    public int[] solution(String[] genres, int[] plays) {
       // int[] answer = {};
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, List<Song>> genreSongs = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
       // ArrayList<Integer> answer = new ArrayList<>();
//        //장르별 총 재생  횟수 구하기
//        for(int i = 0; i < genres.length; i++) {
//            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
//        }
//        ArrayList<Integer> sorted = new ArrayList<>();
//        //노래 정보를 정리하기 으악 문제 생김 song 필요해짐
//        for(int i = 0; i < genres.length; i++) {
//            sorted.add(map.get(genres[i]));
//        }
        //장르별 총 재생 횟수 및 노래 정보 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 총 재생 횟수 업데이트
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            // 노래 정보 추가
            genreSongs.putIfAbsent(genre, new ArrayList<>()); // 초기화
            genreSongs.get(genre).add(new Song(i, play));
        }

        //장르를 총 재생 횟수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a)); // 내림차순 정렬

        List<Integer> result = new ArrayList<>(); // 결과를 저장할 리스트

        //각 장르별 상위 두 곡 선택
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);

            // 노래 정렬 함수 호출
            sortSongs(songs);

            // 최대 두 곡만 결과에 추가
            int count = 0;
            for (int i = 0; i < songs.size(); i++) {
                result.add(songs.get(i).id);
                count++;
                if (count == 2) break; // 두 곡만 추가하면 종료
            }
        }

        // 결과를 int[] 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}