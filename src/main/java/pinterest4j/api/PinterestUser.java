package pinterest4j.api;

import pinterest4j.entity.User;
import pinterest4j.util.exception.PinterestException;

/**
 * Provides all the interfaces for Pinterest <b>Users</b> APIs
 *
 * Created by Aniket Divekar.
 */
public interface PinterestUser {

    /**
     *
     * Get Pinterest {@link User} with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>first_name</li>
     *  <li>last_name</li>
     *  <li>url</li>
     * </ul>
     *
     * @param id id of the user
     *
     * @return {@link User}
     * @throws PinterestException
     */
    User getUser(String id) throws PinterestException;

    /**
     *
     * Get Pinterest {@link User} with specific fields
     * Possible fields that can be returned by Pinterest are:
     * <ul>
     *      <li>id</li>
     *      <li>first_name</li>
     *      <li>last_name</li>
     *      <li>url</li>
     *      <li>username</li>
     *      <li>account_type</li>
     *      <li>bio</li>
     *      <li>created_at</li>
     *      <li>image</li>
     *      <li>counts</li>
     * </ul>
     *
     * @param id id or handle of the user
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link User}
     * @throws PinterestException
     */
    User getUser(String id, String[] fields) throws PinterestException;

}
