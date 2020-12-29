package world;

import java.util.Objects;

public class Song {
    private final String name;
    private String content;

    public Song(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        System.out.println("Текст песенки " + name + " был такой: \"" + content + "\"");
        this.content = content;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
