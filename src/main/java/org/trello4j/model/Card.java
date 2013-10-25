package org.trello4j.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Card extends TrelloObject implements Parcelable {

    // TODO: idChecklists
    // TODO: checkItemStates
    // TODO: badges

    private String name;
    private String desc;
    private boolean closed;
    private Long idShort;
    private String idList;
    private String idBoard;
    private List<String> idMembers;
    private List<Attachment> attachments;
    private List<Label> labels;
    private String url;
    private double pos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Long getIdShort() {
        return idShort;
    }

    public void setIdShort(Long idShort) {
        this.idShort = idShort;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public List<String> getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(List<String> idMembers) {
        this.idMembers = idMembers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    protected Card(Parcel in) {
        setId(in.readString());
        name = in.readString();
        desc = in.readString();
        closed = in.readByte() != 0x00;
        idShort = in.readLong();
        idList = in.readString();
        idBoard = in.readString();
        idMembers = new ArrayList<String>();
        in.readList(idMembers, null);
        attachments = new ArrayList<Attachment>();
        in.readList(attachments, null);
        labels = new ArrayList<Label>();
        in.readList(labels, null);
        url = in.readString();
        pos = in.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getId());
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeByte((byte) (closed ? 0x01 : 0x00));
        dest.writeLong(idShort);
        dest.writeString(idList);
        dest.writeString(idBoard);
        dest.writeList(idMembers);
        dest.writeList(attachments);
        dest.writeList(labels);
        dest.writeString(url);
        dest.writeDouble(pos);
    }

    public static final Parcelable.Creator<Card> CREATOR = new Parcelable.Creator<Card>() {
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    public class Attachment implements Parcelable {

        private String _id;
        private String bytes;
        private Date date;
        private String url;
        private String name;
        private String idMember;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getBytes() {
            return bytes;
        }

        public void setBytes(String bytes) {
            this.bytes = bytes;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdMember() {
            return idMember;
        }

        public void setIdMember(String idMember) {
            this.idMember = idMember;
        }

        protected Attachment(Parcel in) {
            _id = in.readString();
            bytes = in.readString();
            long tmpDate = in.readLong();
            date = tmpDate != -1 ? new Date(tmpDate) : null;
            url = in.readString();
            name = in.readString();
            idMember = in.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(_id);
            dest.writeString(bytes);
            dest.writeLong(date != null ? date.getTime() : -1L);
            dest.writeString(url);
            dest.writeString(name);
            dest.writeString(idMember);
        }

        public final Parcelable.Creator<Attachment> CREATOR = new Parcelable.Creator<Attachment>() {
            public Attachment createFromParcel(Parcel in) {
                return new Attachment(in);
            }

            public Attachment[] newArray(int size) {
                return new Attachment[size];
            }
        };
    }

    public class Label implements Parcelable {

        private String color;
        private String name;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        protected Label(Parcel in) {
            color = in.readString();
            name = in.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(color);
            dest.writeString(name);
        }

        public final Parcelable.Creator<Label> CREATOR = new Parcelable.Creator<Label>() {
            public Label createFromParcel(Parcel in) {
                return new Label(in);
            }

            public Label[] newArray(int size) {
                return new Label[size];
            }
        };
    }
}
