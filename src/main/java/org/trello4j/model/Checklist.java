package org.trello4j.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckList extends TrelloObject implements Parcelable, ITrelloNamedObject {

    //PARCELABLE
    public static final Parcelable.Creator<CheckList> CREATOR = new Parcelable.Creator<CheckList>() {

        public CheckList createFromParcel(Parcel source) {
            return new CheckList(source);
        }

        public CheckList[] newArray(int size) {
            throw new UnsupportedOperationException();
        }
    };
    public String name;
    protected String idBoard;
    protected java.util.List<CheckItem> checkItems = new ArrayList<CheckItem>();
    private String idCard;

    public CheckList() {
    }

    private CheckList(Parcel source) {
        setId(source.readString());
        name = source.readString();
        idBoard = source.readString();
        idCard = source.readString();
        checkItems = new ArrayList<CheckItem>();
        source.readList(checkItems, CheckItem.class.getClassLoader());
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

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
        Collections.sort(checkItems);
        return checkItems;
    }

    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }

    @Override
    public int describeContents() {
        return 0;  // не трогать
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getId());
        dest.writeString(name);
        dest.writeString(idBoard);
        dest.writeString(idCard);
        dest.writeList(checkItems);
    }

}

