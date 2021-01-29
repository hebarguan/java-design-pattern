package com.demo.pattern.behavior.iterator;

/**
 * @author huaihai.guan
 * @since 2021/1/26 18:40
 */
public class SongList implements IList<Song> {

    public int index = 0;

    public int size = 0;

    public Song[] songs;

    public Iterator iterator = new SongListIteratorImpl(this);

    public SongList(int size) {
        this.songs = new Song[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Song song) {
        this.songs[index++] = song;
        size++;
    }

    @Override
    public Song get(int index) {
        if (index < size) {
            return this.songs[index];
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return this.iterator;
    }
}
