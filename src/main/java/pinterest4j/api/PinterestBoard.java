package pinterest4j.api;

import pinterest4j.entity.Board;
import pinterest4j.util.exception.PinterestException;

/**
 * Provides all the interfaces for Pinterest <b>Boards</b> APIs
 *
 * Created by Aniket Divekar.
 */
public interface PinterestBoard {

    /**
     *
     * Get {@link Board} with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>url</li>
     * </ul>
     *
     * @param id id or handle of the board
     * @param board name of the board
     *
     * @return {@link Board}
     * @throws PinterestException
     */
    Board getBoard(String id, String board) throws PinterestException;

    /**
     *
     * Get {@link Board} with specific fields
     * Possible fields that can be returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>creator</li>
     *  <li>url</li>
     *  <li>created_at</li>
     *  <li>privacy</li>
     *  <li>image</li>
     *  <li>description</li>
     *  <li>counts</li>
     * </ul>
     *
     * <b>NOTE: <i>reason</i> field is planned to be included in future release</b>
     *
     * @param id id or handle of the user
     * @param board name of the board
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Board}
     * @throws PinterestException
     */
    Board getBoard(String id, String board, String[] fields) throws PinterestException;
}
