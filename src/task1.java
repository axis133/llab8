import java.util.*;

public class task1 {
    private String stih = """
            В этот лес завороженный,
            По пушинкам серебра,
            Я с винтовкой заряженной
            На охоту шел вчера.
            По дорожке чистой, гладкой
            Я прошел, не наследил…
            Кто ж катался здесь украдкой?
            Кто здесь падал и ходил?
            Подойду, взгляну поближе:
            Хрупкий снег изломан весь.
            Здесь вот когти, дальше — лыжи…
            Кто-то странный бегал здесь.
            Кабы твердо знал я тайну
            Заколдованным речам,
            Я узнал бы хоть случайно,
            Кто здесь бродит по ночам.
            Из-за елки бы высокой
            Подсмотрел я на кругу:
            Кто глубокий след далекий
            Оставляет на снегу?..
            """;
    String[] lines = stih.split("\n");

    public static void main(String[] args) {
        task1 task = new task1();
        task.countAndSort(Arrays.asList("лес", "снег", "след", "круг"));
    }

    public void countAndSort(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String line : lines) {
            for (String word : words) {
                int count = 0;
                if (line.contains(word)) {
                    count = (line.split(word, -1).length) - 1;
                }
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + count);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordFrequency.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}