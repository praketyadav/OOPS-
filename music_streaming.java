import java.util.*;

class Song {
    private String title;
    private String artist;
    private int duration; // seconds

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }

    public void play() {
        System.out.println("Playing: " + title + " by " + artist + " [" + duration + "s]");
    }
}

class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added \"" + song.getTitle() + "\" to playlist \"" + name + "\"");
    }

    public void playAll() {
        System.out.println("\n-- Now Playing Playlist: " + name + " --");
        for (Song song : songs) {
            song.play();
        }
    }

    public void shufflePlay() {
        System.out.println("\n-- Shuffle Playing Playlist: " + name + " --");
        Collections.shuffle(songs);
        playAll();
    }
}

public class MusicApp {
    public static void main(String[] args) {
        Song s1 = new Song("Lose Yourself", "Eminem", 326);
        Song s2 = new Song("Viva La Vida", "Coldplay", 245);
        Song s3 = new Song("Blinding Lights", "The Weeknd", 200);

        Playlist myMix = new Playlist("My Mix");
        myMix.addSong(s1);
        myMix.addSong(s2);
        myMix.addSong(s3);

        myMix.playAll();
        myMix.shufflePlay();
    }
}
