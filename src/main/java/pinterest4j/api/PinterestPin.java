/*
 * Copyright (c) 2017 Aniket Divekar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
