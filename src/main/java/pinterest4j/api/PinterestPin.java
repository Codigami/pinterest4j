package pinterest4j.api;

import pinterest4j.entity.Pin;
import pinterest4j.util.exception.PinterestException;

/**
 * Provides all the interfaces for Pinterest <b>Pin</b> APIs
 *
 * Created by Aniket Divekar.
 */
public interface PinterestPin {

    /**
     *
     * Get {@link Pin} with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param id id of the pin
     *
     * @return {@link Pin}
     * @throws PinterestException
     */
    Pin getPin(String id) throws PinterestException;

    /**
     *
     * Get {@link Pin} with with specific fields
     * Possible fields that can be returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>creator</li>
     *  <li>url</li>
     *  <li>media</li>
     *  <li>created_at</li>
     *  <li>original_link</li>
     *  <li>note</li>
     *  <li>color</li>
     *  <li>link</li>
     *  <li>board</li>
     *  <li>image</li>
     *  <li>counts</li>
     * </ul>
     *
     * <b>NOTE: <i>metadata</i> and <i>attribution</i> fields are planned to be included in future release</b>
     *
     * @param id id of the pin
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Pin}
     * @throws PinterestException
     */
    Pin getPin(String id, String[] fields) throws PinterestException;
}
