package pinterest4j.api;

import pinterest4j.entity.Board;
import pinterest4j.util.exception.PinterestException;

/**
 * Created by Aniket Divekar.
 */
public interface PinterestBoard {

    Board getBoard(String id, String board) throws PinterestException;

    Board getBoard(String id, String board, String[] fields) throws PinterestException;
}
