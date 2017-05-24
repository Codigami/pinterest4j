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
