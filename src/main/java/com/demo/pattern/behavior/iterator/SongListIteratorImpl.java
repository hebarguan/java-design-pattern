package com.demo.pattern.behavior.iterator;

/**
 * @author huaihai.guan
 * @since 2021/1/26 18:47
 */
public class SongListIteratorImpl implements Iterator<Song> {

    private IList list;

    private int index;

    public SongListIteratorImpl(IList list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public Song next() {
        return (Song) this.list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < this.list.size();
    }
}
