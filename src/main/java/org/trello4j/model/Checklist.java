package org.trello4j.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * A Trello checklist.
 * <p/>
 * <code>
 * {
 * "id":"4f92b89ea73738db6cdd4ed7",
 * "name":"Checklist",
 * "idBoard":"4f92b80ba73738db6cdd4309",
 * "checkItems":[
 * {
 * "id":"4f92b97cf9e2e2ae362df9ab",
 * "name":"Base for filtering",
 * "state":"check",
 * "pos":8588
 * },
 * {
 * "id":"4f92b99b5c92e5cd28006ee8",
 * "name":"GET /1/boards/[board_id]/actions?filter",
 * "state":"check",
 * "pos":12882
 * }
 * ]
 * }
 * </code>
 */
public class CheckList extends TrelloObject implements Parcelable {

    protected String name;
    protected String idBoard;
    protected java.util.List<CheckItem> checkItems = new ArrayList<CheckItem>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }

    public static final Parcelable.Creator<CheckList> CREATOR = new Parcelable.Creator<CheckList>() {

        public CheckList createFromParcel(Parcel source) {
            return new CheckList(source);
        }

        public CheckList[] newArray(int size) {
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public int describeContents() {
        return 0;  // не трогать
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getId());
        dest.writeString(name);
        dest.writeString(idBoard);
        dest.writeList(checkItems);
    }

    private CheckList(Parcel source) {
        setId(source.readString());
        name = source.readString();
        idBoard = source.readString();

        checkItems = new ArrayList<CheckItem>();
        source.readList(checkItems, CheckItem.class.getClassLoader());
    }

    public CheckList() {
    }

}

