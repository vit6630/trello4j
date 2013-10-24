package org.trello4j;

import org.trello4j.model.*;
import org.trello4j.model.Board.Prefs;

import java.util.List;

/**
 * @author joel
 */
public interface BoardService {

    Board getBoard(String boardId);

    List<Action> getActionsByBoard(String boardId, String... filter);

    Organization getOrganizationByBoard(String boardId, String... filter);

    List<Member> getMembersInvitedByBoard(String boardId, String... filter);

    List<Member> getMembersByBoard(String boardId, String... filter);

    List<org.trello4j.model.List> getListByBoard(String boardId,
                                                 String... filter);

    List<CheckList> getChecklistByBoard(String boardId);

    List<Card> getCardsByBoard(String boardId, String... filter);

    Prefs getPrefsByBoard(String boardId);

}