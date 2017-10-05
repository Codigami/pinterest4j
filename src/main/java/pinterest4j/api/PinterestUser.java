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
     * @throws PinterestException when Pinterest is unavailable or sends an error
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
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    User getUser(String id, String[] fields) throws PinterestException;

}
