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
import pinterest4j.entity.Pin;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.list.PageResponseList;

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
     * @param username handle of the board's creator
     * @param board name of the board
     *
     * @return {@link Board}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Board getBoard(String username, String board) throws PinterestException;

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
     * @param username handle of the board's creator
     * @param board name of the board
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Board}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Board getBoard(String username, String board, String[] fields) throws PinterestException;

    /**
     *
     * Get {@link PageResponseList<Pin>} on a {@link Board} with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the board's creator
     * @param board name of the board
     * @param cursor cursor
     *
     * @return {@link PageResponseList<Pin>}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> getBoardPins(String username, String board, String cursor) throws PinterestException;

    /**
     *
     * Get {@link PageResponseList<Pin>} on a {@link Board} with specific fields
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
     * @param username handle of the board's creator
     * @param board name of the board
     * @param cursor cursor
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<Pin>}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> getBoardPins(String username, String board, String cursor, String[] fields) throws PinterestException;

    /**
     *
     * Create {@link Board} and get board's default fields after creating the board
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>url</li>
     * </ul>
     *
     * @param name name of the board
     * @param description description for the board
     *
     * @return {@link Board}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Board createBoard(String name, String description) throws PinterestException;

    /**
     *
     * Create {@link Board} and get board's specified fields after creating the board
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
     * @param name name of the board
     * @param description description for the board
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Board}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Board createBoard(String name, String description, String[] fields) throws PinterestException;

    /**
     *
     * Edit {@link Board} and get board default fields as response after editing the board
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the board's creator
     * @param board name of the board
     * @param name the new board name.
     * @param description description for the board
     *
     * @return {@link Board}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Board editBoard(String username, String board, String name, String description) throws PinterestException;

    /**
     *
     * Edit {@link Board} and get board's specified fields as response after editing the board
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
     * @param username handle of the board's creator
     * @param board name of the board
     * @param name the new board name
     * @param description description for the board
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Board}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Board editBoard(String username, String board, String name, String description, String[] fields) throws PinterestException;

    /**
     *
     * delete the board
     *
     * @param username handle of the board's creator
     * @param board name of the board
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    void deleteBoard(String username, String board) throws PinterestException;
}
