package com.youzhong.message.resp;
/**
 * 音乐消息
 *
 * @author liufeng
 * 这个类的引用类还有一个子标签，所以我们用采用封装的形式
 *
 */
public class MusicMessage  extends BaseMessage  {
    // 音乐
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
