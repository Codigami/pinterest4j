package pinterest4j.api;

import pinterest4j.entity.Pin;
import pinterest4j.util.exception.PinterestException;

/**
 * Created by Aniket Divekar.
 */
public interface PinterestPin {

    Pin getPin(String id) throws PinterestException;

    Pin getPin(String id, String[] fields) throws PinterestException;
}
