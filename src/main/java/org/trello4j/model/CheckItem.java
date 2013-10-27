package org.trello4j.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CheckItem extends TrelloObject implements Parcelable, Comparable<CheckItem> {

    protected String name;
    protected String state;
    protected Double pos;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public boolean getStateBoolean() {
        return state.equals("complete");
    }

    public void setStateBoolean(boolean _state) {
        this.state = _state ? "complete" : "incomplete";
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getPos() {
        return pos;
    }

    public void setPos(Double pos) {
        this.pos = pos;
    }

    public static final Parcelable.Creator<CheckItem> CREATOR = new Parcelable.Creator<CheckItem>() {

        public CheckItem createFromParcel(Parcel source) {
            return new CheckItem(source);
        }

        public CheckItem[] newArray(int size) {
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public int describeContents() {
        return 0;
        //не трогать
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getId());
        dest.writeString(name);
        dest.writeString(state);
        dest.writeDouble(pos);
    }

    private CheckItem(Parcel source) {
        setId(source.readString());
        name = source.readString();
        state = source.readString();
        pos = source.readDouble();
    }

    public CheckItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckItem)) return false;

        CheckItem checkItem = (CheckItem) o;

        if (!this.getId().equals(checkItem.getId())) return false;
        if (Double.compare(checkItem.pos, pos) != 0) return false;
        if (name != null ? !name.equals(checkItem.name) : checkItem.name != null) return false;
        if (state != null ? !state.equals(checkItem.state) : checkItem.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        temp = Double.doubleToLongBits(pos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(CheckItem another) {
        return this.getPos().compareTo(another.getPos());
    }
}
