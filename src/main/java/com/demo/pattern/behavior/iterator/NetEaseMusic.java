package com.demo.pattern.behavior.iterator;

/**
 * @author huaihai.guan
 * @since 2021/1/26 19:24
 */
public class NetEaseMusic {

    IList<Song> list;

    public NetEaseMusic() {
        this.list = new SongList(2);
        this.list.add(new Song("七里香", "周杰伦"));
        this.list.add(new Song("最佳损友", "陈奕迅"));
    }

    public void play() {
        Iterator<Song> iterator = list.iterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println(song.toString());
        }
    }
}
