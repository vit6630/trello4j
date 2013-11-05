package org.trello4j.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <code>
 * {
 * "id":"4e7b86d7ce194786721560b8",
 * "name":"Known Issues",
 * "closed":false,
 * "idBoard":"4d5ea62fd76aa1136000000c",
 * "pos":9408.2119140625
 * }
 * </code>
 *
 * @author joel
 */
public class List extends TrelloObject implements Parcelable {

    /**
     * The name.
     */
    private String name;

    /**
     * The closed.
     */
    private boolean closed;

    /**
     * The id board.
     */
    private String idBoard;

    /**
     * The pos.
     */
    private double pos;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if is closed.
     *
     * @return true, if is closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Sets the closed.
     *
     * @param closed the new closed
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     * Gets the id board.
     *
     * @return the id board
     */
    public String getIdBoard() {
        return idBoard;
    }

    /**
     * Sets the id board.
     *
     * @param idBoard the new id board
     */
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    /**
     * Gets the pos.
     *
     * @return the pos
     */
    public double getPos() {
        return pos;
    }

    /**
     * Sets the pos.
     *
     * @param pos the new pos
     */
    public void setPos(double pos) {
        this.pos = pos;
    }

    protected List(Parcel in) {
        setId(in.readString());
        name = in.readString();
        closed = in.readByte() != 0x00;
        idBoard = in.readString();
        pos = in.readDouble();
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getId());
        dest.writeString(name);
        dest.writeByte((byte) (closed ? 0x01 : 0x00));
        dest.writeString(idBoard);
        dest.writeDouble(pos);
    }

    public static final Parcelable.Creator<List> CREATOR = new Parcelable.Creator<List>() {
        public List createFromParcel(Parcel in) {
            return new List(in);
        }

        public List[] newArray(int size) {
            return new List[size];
        }
    };
}
