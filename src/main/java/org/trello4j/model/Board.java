package org.trello4j.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Board extends TrelloObject implements Parcelable, ITrelloNamedObject {

    public enum PERMISSION_TYPE {
        PUBLIC,
        ORGANIZATION,
        MEMBERS
    }

    private String name;
    private String desc;
    private boolean closed;
    private boolean invited = false;
    private String idOrganization;
    private String url;
    private Prefs prefs;


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

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }

    protected Board(Parcel in) {
        setId(in.readString());
        name = in.readString();
        desc = in.readString();
        closed = in.readByte() != 0;
        invited = in.readByte() != 0;
        idOrganization = in.readString();
        url = in.readString();
        prefs = in.readParcelable(Prefs.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getId());
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeByte((byte) (closed ? 1 : 0));
        dest.writeByte((byte) (invited ? 1 : 0));
        dest.writeString(idOrganization);
        dest.writeString(url);
        dest.writeParcelable(prefs, 0);

    }

    public static final Parcelable.Creator<Board> CREATOR = new Parcelable.Creator<Board>() {
        public Board createFromParcel(Parcel in) {
            return new Board(in);
        }

        public Board[] newArray(int size) {
            return new Board[size];
        }
    };

    public static class Prefs implements Parcelable {

        private PERMISSION_TYPE voting;
        private PERMISSION_TYPE permissionLevel;
        private PERMISSION_TYPE invitations;
        private PERMISSION_TYPE comments;

        public PERMISSION_TYPE getVoting() {
            return voting;
        }

        public void setVoting(PERMISSION_TYPE voting) {
            this.voting = voting;
        }

        public PERMISSION_TYPE getPermissionLevel() {
            return permissionLevel;
        }

        public void setPermissionLevel(PERMISSION_TYPE permissionLevel) {
            this.permissionLevel = permissionLevel;
        }

        public PERMISSION_TYPE getInvitations() {
            return invitations;
        }

        public void setInvitations(PERMISSION_TYPE invitations) {
            this.invitations = invitations;
        }

        public PERMISSION_TYPE getComments() {
            return comments;
        }

        public void setComments(PERMISSION_TYPE comments) {
            this.comments = comments;
        }

        private PERMISSION_TYPE getType(String type) {
            if (type.equals(PERMISSION_TYPE.MEMBERS.toString()))
                return PERMISSION_TYPE.MEMBERS;

            if (type.equals(PERMISSION_TYPE.ORGANIZATION.toString()))
                return PERMISSION_TYPE.ORGANIZATION;

            if (type.equals(PERMISSION_TYPE.PUBLIC.toString()))
                return PERMISSION_TYPE.PUBLIC;
            return null;
        }

        protected Prefs(Parcel in) {
            voting = getType(in.readString());
            permissionLevel = getType(in.readString());
            invitations = getType(in.readString());
            comments = getType(in.readString());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(voting != null ? voting.toString() : "null");
            dest.writeString(permissionLevel != null ? permissionLevel.toString() : "null");
            dest.writeString(invitations != null ? invitations.toString() : "null");
            dest.writeString(comments != null ? comments.toString() : "null");
        }

        public static final Parcelable.Creator<Prefs> CREATOR = new Parcelable.Creator<Prefs>() {
            public Prefs createFromParcel(Parcel in) {
                return new Prefs(in);
            }

            public Prefs[] newArray(int size) {
                return new Prefs[size];
            }
        };

    }
}
