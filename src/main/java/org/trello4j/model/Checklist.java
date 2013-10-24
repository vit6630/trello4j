package org.trello4j.model;

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
public class Checklist extends TrelloObject {

    private String name;

    private String idBoard;

    private java.util.List<CheckItem> checkItems = new ArrayList<CheckItem>();

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

    public class CheckItem extends TrelloObject {

        private String name;
        private String state;
        private double pos;


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

        public double getPos() {
            return pos;
        }

        public void setPos(double pos) {
            this.pos = pos;
        }
    }
}
