package io.wherevere.know.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    /**
     * id : 1485
     * originId : 1479
     * title : Android中图片压缩分析（上）
     * chapterId : 86
     * chapterName : 图片处理
     * envelopePic : null
     * link : https://mp.weixin.qq.com/s/QZ-XTsO7WnNvpnbr3DWQmg
     * author : QQ音乐技术团队
     * origin : null
     * publishTime : 1509611122000
     * zan : 0
     * desc : null
     * visible : 0
     * niceDate : 2小时前
     * courseId : 13
     * collect : false
     */

    private int originId;
    private boolean collect;
    private int id;
    private String title;
    private int chapterId;
    private String chapterName;
    private Object envelopePic;
    private String link;
    private String author;
    private Object origin;
    private long publishTime;
    private int zan;
    private Object desc;
    private int visible;
    private String niceDate;
    private int courseId;
    private int userId;

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Object getEnvelopePic() {
        return envelopePic;
    }

    public void setEnvelopePic(Object envelopePic) {
        this.envelopePic = envelopePic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public Object getDesc() {
        return desc;
    }

    public void setDesc(Object desc) {
        this.desc = desc;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.originId);
        dest.writeByte(this.collect ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeInt(this.chapterId);
        dest.writeString(this.chapterName);
        dest.writeParcelable((Parcelable) this.envelopePic, flags);
        dest.writeString(this.link);
        dest.writeString(this.author);
        dest.writeParcelable((Parcelable) this.origin, flags);
        dest.writeLong(this.publishTime);
        dest.writeInt(this.zan);
        dest.writeParcelable((Parcelable) this.desc, flags);
        dest.writeInt(this.visible);
        dest.writeString(this.niceDate);
        dest.writeInt(this.courseId);
        dest.writeInt(this.userId);
    }

    public Article() {
    }

    protected Article(Parcel in) {
        this.originId = in.readInt();
        this.collect = in.readByte() != 0;
        this.id = in.readInt();
        this.title = in.readString();
        this.chapterId = in.readInt();
        this.chapterName = in.readString();
        this.envelopePic = in.readParcelable(Object.class.getClassLoader());
        this.link = in.readString();
        this.author = in.readString();
        this.origin = in.readParcelable(Object.class.getClassLoader());
        this.publishTime = in.readLong();
        this.zan = in.readInt();
        this.desc = in.readParcelable(Object.class.getClassLoader());
        this.visible = in.readInt();
        this.niceDate = in.readString();
        this.courseId = in.readInt();
        this.userId = in.readInt();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
