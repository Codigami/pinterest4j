package pinterest4j.api;

import pinterest4j.entity.User;
import pinterest4j.util.exception.PinterestException;

/**
 * Created by Aniket Divekar.
 */
public interface PinterestUser {

    /**
     * Get User with minimum possible fields returned by Pinterest
     * Fields Returned by Pinterest are
     * <ul>
     *  <li>id</li>
     *  <li>first_name</li>
     *  <li>last_name</li>
     *  <li>url</li>
     * </ul>
     *
     */
    User getUser(String id) throws PinterestException;

    /**
     * Get User with specific fields
     *
     * @param fields array of specific fields required
     */
    User getUser(String id, String[] fields) throws PinterestException;

}
